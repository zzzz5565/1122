package com.huitong.quartz.task;

import com.huitong.business.domain.*;
import com.huitong.business.mapper.DevTollgateMapper;
import com.huitong.business.mapper.DevVioEquipmentMapper;
import com.huitong.business.service.*;
import com.huitong.common.config.datasource.DynamicDataSourceContextHolder;
import com.huitong.common.enums.DataSourceType;
import com.huitong.common.utils.DateUtils;
import com.huitong.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 同步设备预警信息任务
 */
@Component("SyncEquipTask")
public class SyncEquipTask {

    @Autowired
    private DevVioEquipmentMapper devVioEquipmentMapper;

    @Autowired
    private IAbnormalWarningService abnormalWarningService;

    @Autowired
    private IDeviceNoDataService deviceNoDataService;

    @Autowired
    private IDeviceNoPicService deviceNoPicService;

    @Autowired
    private IEquPicDetectionService equPicDetectionService;

    @Autowired
    private IDevNameNonStandardService devNameNonStandardService;

    @Autowired
    private IDevJwdNonStandardService devJwdNonStandardService;

    @Autowired
    private IDevVioEquWarningService devVioEquWarningService;

    @Autowired
    private DevTollgateMapper devTollgateMapper;

    // 同步设备信息(dev_vio_equipment_daily表)
    public void getEquipmentDaily(String daily) {
        try {
            // 获取当前日期
            LocalDate currentDate = LocalDate.now();
            // 获取前一天的日期
            LocalDate previousDate = currentDate.minusDays(1);
            // 定义开始时间为前一天的00:00:00
            LocalDateTime startTime = LocalDateTime.of(previousDate, LocalTime.MIN);
            // 定义日期时间格式
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            // 格式化时间
            String strDaily = startTime.format(formatter);
            if (StringUtils.isNotEmpty(daily)) {
                strDaily = daily;
            }
            // 获取备信息
            DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
            List<DevVioEquipment> list = devVioEquipmentMapper.selectDevVioEquipmentListSlave(new DevVioEquipment());
            DynamicDataSourceContextHolder.clearDataSourceType();
            System.out.println("已查询设备数量："+list.size());
            // 设置日期
            String finalStrDaily = strDaily;
            list.stream().forEach(equipment -> equipment.setDaily(finalStrDaily));

            // 保存设备信息
            saveEquipment(list, strDaily);
        }catch (Exception e) {
            System.out.println("同步设备信息报错，"+e.getMessage());
        }
    }
    // 保存设备信息
    @Transactional
    void saveEquipment(List<DevVioEquipment> list, String daily){
        //删除对应日期设备信息
        devVioEquipmentMapper.deleteDevVioEquipmentByDaily(daily);

        if (!list.isEmpty()) {
            // 设置每批处理的数据量
            int batchSize = 50;
            int totalSize = list.size();
            int batchCount = (totalSize + batchSize - 1) / batchSize;

            // 分批处理数据
            for (int i = 0; i < batchCount; i++) {
                int fromIndex = i * batchSize;
                int toIndex = Math.min((i + 1) * batchSize, totalSize);
                List<DevVioEquipment> batchList = list.subList(fromIndex, toIndex);

                // 每50条数据执行一次批量插入
                devVioEquipmentMapper.insertDevVioEquEquipmentDailyBatch(batchList);
            }
        }
    }

    // 同步设备信息(dev_vio_equipment表)
    public void getEquipment() {
        try {
            // 获取备信息
            DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
            List<DevVioEquipment> list = devVioEquipmentMapper.selectDevVioEquipmentListSlave(new DevVioEquipment());
            DynamicDataSourceContextHolder.clearDataSourceType();
            for (DevVioEquipment equipment : list) {
                DevVioEquipment existequipment = devVioEquipmentMapper.selectDevVioEquipmentBySbbh(equipment.getSbbh());
                if (existequipment == null) {
                    devVioEquipmentMapper.insertDevVioEquipment(equipment);
                } else {
                    equipment.setId(existequipment.getId());
                    devVioEquipmentMapper.updateDevVioEquipment(equipment);
                }
            }
        }catch (Exception e) {
            System.out.println("同步设备信息报错，"+e.getMessage());
        }
    }

    // 同步卡口信息
    public void getTollgate() {
        try {
            // 获取卡口信息
            DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
            List<DevTollgate> list = devTollgateMapper.selectDevTollgateListSlave(new DevTollgate());
            DynamicDataSourceContextHolder.clearDataSourceType();
            for (DevTollgate tollgate : list) {
                DevTollgate existDevTollgate = devTollgateMapper.selectDevTollgateByKKbh(tollgate.getKkbh());
                if (existDevTollgate == null) {
                    devTollgateMapper.insertDevTollgate(tollgate);
                } else {
                    tollgate.setId(existDevTollgate.getId());
                    devTollgateMapper.updateDevTollgate(tollgate);
                }
            }
        }catch (Exception e) {
            System.out.println("同步卡口信息报错，"+e.getMessage());
        }
    }

    /**
     * 同步预警信息
     * @startDate 开始日期
     * @endDate 结束日期
     * @yjlx 预警类型
    */
    public void getWarning(String startDate, String endDate, Integer yjlx) {
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();
        // 获取前一天的日期
        LocalDate previousDate = currentDate.minusDays(1);
        // 获取前三天的日期
        LocalDate previous3Date = currentDate.minusDays(3);
        // 定义开始时间为前一天的00:00:00
        LocalDateTime startTime = LocalDateTime.of(previousDate, LocalTime.MIN);
        // 定义开始时间为前三天的00:00:00
        LocalDateTime startTime3 = LocalDateTime.of(previous3Date, LocalTime.MIN);
        // 定义结束时间为前一天的23:59:59
        LocalDateTime endTime = LocalDateTime.of(previousDate, LocalTime.MAX);

        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 格式化时间
        String strDayStart = startTime.format(formatter);
        String strDayStart3 = startTime3.format(formatter);
        String strDayEnd = endTime.format(formatter);
        if (StringUtils.isNotEmpty(startDate)) {
            strDayStart = startDate + " 00:00:00";
        }
        if (StringUtils.isNotEmpty(startDate)) {
            strDayStart3 = startDate + " 00:00:00";
        }
        if (StringUtils.isNotEmpty(endDate)) {
            strDayEnd = endDate + " 23:59:59";
        }
        switch (yjlx) {
            case 0:
                processAbnormalWarning(strDayStart, strDayEnd, 1, 1);// 同步违法数据异常数据
                processDeviceNoData(strDayStart, strDayEnd, 2, 1);// 同步执法设备无数据
                processDeviceNoPic(strDayStart,3 ,2);// 同步执法设备无备案图片
                processDeviceSamePic(strDayStart,4 ,2);// 同步执法设备三张图片一样
                processDeviceCheckAbnormal(strDayStart3, strDayEnd, 5 ,1);// 同步执法设备初审异常
                processDeviceReCheckAbnormal(strDayStart3, strDayEnd,6 ,1);// 同步执法设备复审异常
                processDeviceStatusChange(strDayStart,7 ,1);// 执法设备状态异常变化
                processDeviceNoService(strDayStart,8 ,1);// 执法设备停用

                processNameNonStandard(strDayStart,10 ,2);// 同步卡口命名不规范
                processJwdNonStandard(strDayStart,11 ,2);// 同步卡口经纬度不规范
                break;
            case 1:// 同步违法数据异常数据
                processAbnormalWarning(strDayStart, strDayEnd, 1, 1);
                break;
            case 2:// 同步执法设备无数据
                processDeviceNoData(strDayStart, strDayEnd, 2, 1);
                break;
            case 3:// 同步执法设备无备案图片
                processDeviceNoPic(strDayStart,3, 2);
                break;
            case 4:// 同步执法设备三张图片一样
                processDeviceSamePic(strDayStart,4, 2);
                break;
            case 5:// 同步执法设备初审异常
                processDeviceCheckAbnormal(strDayStart, strDayEnd, 5, 1);
                break;
            case 6:// 同步执法设备复审异常
                processDeviceReCheckAbnormal(strDayStart, strDayEnd,6, 1);
                break;
            case 7:// 执法设备状态异常变化
                processDeviceStatusChange(strDayStart,7, 1);
                break;
            case 8:// 执法设备停用
                processDeviceNoService(strDayStart,8, 1);
                break;
            case 10:// 同步卡口命名不规范
                processNameNonStandard(strDayStart,10, 2);
                break;
            case 11:// 同步卡口经纬度不规范
                processJwdNonStandard(strDayStart,11, 2);
                break;
            default:
                System.out.println("不支持的预警类型");
        }
    }
    // 1同步违法数据异常数据
    private void processAbnormalWarning(String startDate, String endDate, Integer yjlx, Integer yjllx){
        try {
            AbnormalWarning abnormalWarning = new AbnormalWarning();
            Map<String, Object> params = new HashMap<>();
            params.put("beginTime", startDate);
            params.put("endTime", endDate);
            abnormalWarning.setParams(params);
            abnormalWarning.setSl(0L);
            DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
            List<AbnormalWarning> list = abnormalWarningService.selectAbnormalWarningLists(abnormalWarning);
            DynamicDataSourceContextHolder.clearDataSourceType();
            System.out.println("查询违法数据异常数据:" + list.size());
            //保存违法数据异常数据
            saveAbnormalWarning(list, startDate, yjlx, yjllx);
        }catch (Exception e) {
            System.out.println("同步违法数据异常数据报错，"+e.getMessage());
        }
    }
    // 2同步执法设备无数据
    private void processDeviceNoData(String startDate, String endDate, Integer yjlx, Integer yjllx){
        try {
            DeviceNoData deviceNoData = new DeviceNoData();
            Map<String, Object> params = new HashMap<>();
            params.put("beginTime", startDate);
            params.put("endTime", endDate);
            deviceNoData.setParams(params);
            DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
            List<DeviceNoData> list = deviceNoDataService.selectDeviceNoDataLists(deviceNoData);
            DynamicDataSourceContextHolder.clearDataSourceType();
            System.out.println("查询执法设备无数据数据:" + list.size());
            //保存执法设备无数据
            saveDeviceNoData(list, startDate, yjlx, yjllx);
        }catch (Exception e) {
            System.out.println("同步执法设备无数据报错，"+e.getMessage());
        }
    }

    // 3同步执法设备无备案图片
    private void processDeviceNoPic(String startDate, Integer yjlx, Integer yjllx){
        try {
            DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
            List<DeviceNoPic> list = deviceNoPicService.selectDeviceNoPicLists(new DeviceNoPic());
            DynamicDataSourceContextHolder.clearDataSourceType();
            System.out.println("查询执法设备无备案图片数据:" + list.size());
            //保存执法设备无备案图片
            saveDeviceNoPic(list, startDate, yjlx, yjllx);
        }catch (Exception e) {
            System.out.println("同步执法设备无备案图片报错，"+e.getMessage());
        }
    }

    // 4同步执法设备三张图片一样
    private void processDeviceSamePic(String startDate, Integer yjlx, Integer yjllx){
        try {
            DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
            List<EquPicDetection> list = equPicDetectionService.selectEquPicDetectionLists(new EquPicDetection());
            DynamicDataSourceContextHolder.clearDataSourceType();
            System.out.println("查询执法设备三张图片一样数据:" + list.size());
            //保存执法设备三张图片一样
            saveDeviceSamePic(list, startDate, yjlx, yjllx);
        }catch (Exception e) {
            System.out.println("同步执法设备三张图片一样报错，"+e.getMessage());
        }
    }

    // 5同步执法设备初审异常
    private void processDeviceCheckAbnormal(String startDate, String endDate, Integer yjlx, Integer yjllx){
        try {
            DevVioEquipment devVioEquipment = new DevVioEquipment();
            Map<String, Object> params = new HashMap<>();
            params.put("beginTime", startDate);
            params.put("endTime", endDate);
            devVioEquipment.setParams(params);
            DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
            List<DevVioEquipment> list = devVioEquipmentMapper.selectDevCheckAbnormalSlave(devVioEquipment);
            DynamicDataSourceContextHolder.clearDataSourceType();
            System.out.println("查询执法设备初审异常数据:" + list.size());
            //保存执法设备初审异常
            saveDeviceInfo(list, endDate, yjlx, yjllx);
        }catch (Exception e) {
            System.out.println("同步执法设备初审异常报错，"+e.getMessage());
        }
    }

    // 6同步执法设备复审异常
    private void processDeviceReCheckAbnormal(String startDate, String endDate, Integer yjlx, Integer yjllx){
        try {
            DevVioEquipment devVioEquipment = new DevVioEquipment();
            Map<String, Object> params = new HashMap<>();
            params.put("beginTime", startDate);
            params.put("endTime", endDate);
            devVioEquipment.setParams(params);
            DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
            List<DevVioEquipment> list = devVioEquipmentMapper.selectDevReCheckAbnormalSlave(devVioEquipment);
            DynamicDataSourceContextHolder.clearDataSourceType();
            System.out.println("查询执法设备复审异常数据:" + list.size());
            //保存执法设备复审异常
            saveDeviceInfo(list, endDate, yjlx, yjllx);
        }catch (Exception e) {
            System.out.println("同步执法设备复审异常报错，"+e.getMessage());
        }
    }

    // 7同步执法设备状态异常变化
    private void processDeviceStatusChange(String startDate, Integer yjlx, Integer yjllx){
        try {
            List<DevVioEquipment> list = devVioEquipmentMapper.selectDevForStatusChange(new DevVioEquipment());
            System.out.println("查询执法设备状态异常变化数据:" + list.size());
            //保存执法设备状态异常变化
            saveDeviceInfo(list, startDate, yjlx, yjllx);
        }catch (Exception e) {
            System.out.println("同步执法设备状态异常变化报错，"+e.getMessage());
        }
    }

    // 8同步执法设备停用
    private void processDeviceNoService(String startDate, Integer yjlx, Integer yjllx){
        try {
            DevVioEquipment devVioEquipment = new DevVioEquipment();
            devVioEquipment.setZt(2);//停用
            List<DevVioEquipment> list = devVioEquipmentMapper.selectDevVioEquipmentList(devVioEquipment);
            System.out.println("查询执法设备停用数据:" + list.size());
            //保存执法设备停用
            saveDeviceInfo(list, startDate, yjlx, yjllx);
        }catch (Exception e) {
            System.out.println("同步执法设备停用报错，"+e.getMessage());
        }
    }

    // 同步卡口命名不规范
    private void processNameNonStandard(String startDate, Integer yjlx, Integer yjllx){
        try {
            DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
            List<DevNameNonStandard> list = devNameNonStandardService.selectDevNameNonStandardLists(new DevNameNonStandard());
            DynamicDataSourceContextHolder.clearDataSourceType();
            System.out.println("查询卡口命名不规范数据:" + list.size());
            //保存卡口命名不规范
            saveNameNonStandard(list, startDate, yjlx, yjllx);
        }catch (Exception e) {
            System.out.println("同步卡口命名不规范报错，"+e.getMessage());
        }
    }

    // 同步卡口经纬度不规范
    private void processJwdNonStandard(String startDate, Integer yjlx, Integer yjllx){
        try {
            DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
            List<DevJwdNonStandard> list = devJwdNonStandardService.selectDevJwdNonStandardLists(new DevJwdNonStandard());
            DynamicDataSourceContextHolder.clearDataSourceType();
            System.out.println("查询卡口经纬度不规范数据:" + list.size());
            //保存卡口经纬度不规范
            saveJwdNonStandard(list, startDate, yjlx, yjllx);
        }catch (Exception e) {
            System.out.println("同步卡口经纬度不规范报错，"+e.getMessage());
        }
    }

    // 保存违法数据异常数据
    @Transactional
    public void saveAbnormalWarning(List<AbnormalWarning> list, String yjrq, Integer yjlx, Integer yjllx) {
        saveAbnormalWarningData(list, yjrq, yjlx,
                warning -> {
                    if (warning.getSl() > 50 || warning.getSl() < 1) {
                        DevVioEquWarning devVioEquWarning = new DevVioEquWarning();
                        devVioEquWarning.setYjrq(DateUtils.parseDate(yjrq));
                        devVioEquWarning.setSbbh(warning.getBh());
                        devVioEquWarning.setGlbm(warning.getBm());
                        devVioEquWarning.setYjlx(yjlx);
                        devVioEquWarning.setYjllx(yjllx);
                        devVioEquWarning.setShuliang(warning.getSl().toString());
                        devVioEquWarning.setCjsj(new Date());
                        devVioEquWarning.setWfxw(warning.getWf());
                        return devVioEquWarning;
                    }
                    return null;
                }
        );
    }

    // 保存执法设备无数据
    @Transactional
    public void saveDeviceNoData(List<DeviceNoData> list, String yjrq, Integer yjlx, Integer yjllx) {
        saveWarningData(list, yjrq, yjlx,
                device -> {
                    DevVioEquWarning devVioEquWarning = new DevVioEquWarning();
                    devVioEquWarning.setYjrq(DateUtils.parseDate(yjrq));
                    devVioEquWarning.setSbbh(device.getSbbh());
                    devVioEquWarning.setGlbm(device.getBmmc());
                    devVioEquWarning.setYjlx(yjlx);
                    devVioEquWarning.setYjllx(yjllx);
                    devVioEquWarning.setCjsj(new Date());
                    return devVioEquWarning;
                }
        );
    }

    // 保存执法设备无备案图片
    @Transactional
    public void saveDeviceNoPic(List<DeviceNoPic> list, String yjrq, Integer yjlx, Integer yjllx) {
        saveWarningData(list, yjrq, yjlx,
                device -> {
                    DevVioEquWarning devVioEquWarning = new DevVioEquWarning();
                    devVioEquWarning.setYjrq(DateUtils.parseDate(yjrq));
                    devVioEquWarning.setSbbh(device.getSbbh());
                    devVioEquWarning.setGlbm(device.getGlbm());
                    devVioEquWarning.setYjlx(yjlx);
                    devVioEquWarning.setYjllx(yjllx);
                    devVioEquWarning.setCjsj(new Date());
                    return devVioEquWarning;
                }
        );
    }

    // 保存执法设备三张图片一样
    @Transactional
    public void saveDeviceSamePic(List<EquPicDetection> list, String yjrq, Integer yjlx, Integer yjllx) {
        saveWarningData(list, yjrq, yjlx,
                device -> {
                    DevVioEquWarning devVioEquWarning = new DevVioEquWarning();
                    devVioEquWarning.setYjrq(DateUtils.parseDate(yjrq));
                    devVioEquWarning.setSbbh(device.getSbbh());
                    devVioEquWarning.setGlbm(device.getGlbm());
                    devVioEquWarning.setYjlx(yjlx);
                    devVioEquWarning.setYjllx(yjllx);
                    devVioEquWarning.setCjsj(new Date());
                    return devVioEquWarning;
                }
        );
    }

    // 保存执法设备信息(5同步执法设备初审异常|6同步执法设备复审异常|7同步执法设备状态异常变化| 8同步执法设备停用)
    @Transactional
    public void saveDeviceInfo(List<DevVioEquipment> list, String yjrq, Integer yjlx, Integer yjllx) {
        saveWarningData(list, yjrq, yjlx,
                device -> {
                    DevVioEquWarning devVioEquWarning = new DevVioEquWarning();
                    devVioEquWarning.setYjrq(DateUtils.parseDate(yjrq));
                    devVioEquWarning.setSbbh(device.getSbbh());
                    devVioEquWarning.setGlbm(device.getBmmc());
                    devVioEquWarning.setYjlx(yjlx);
                    devVioEquWarning.setYjllx(yjllx);
                    if(yjlx==7) {//设备状态异常变化时，保存旧状态
                        devVioEquWarning.setShuliang(device.getZt().toString());
                    }
                    devVioEquWarning.setCjsj(new Date());
                    return devVioEquWarning;
                }
        );
    }

    // 保存卡口命名不规范
    @Transactional
    public void saveNameNonStandard(List<DevNameNonStandard> list, String yjrq, Integer yjlx, Integer yjllx) {
        saveWarningData(list, yjrq, yjlx,
                device -> {
                    DevVioEquWarning devVioEquWarning = new DevVioEquWarning();
                    devVioEquWarning.setYjrq(DateUtils.parseDate(yjrq));
                    devVioEquWarning.setSbbh(device.getKkbh());
                    devVioEquWarning.setGlbm(device.getGlbm());
                    devVioEquWarning.setYjlx(yjlx);
                    devVioEquWarning.setYjllx(yjllx);
                    devVioEquWarning.setCjsj(new Date());
                    return devVioEquWarning;
                }
        );
    }

    // 保存卡口经纬度不规范
    @Transactional
    public void saveJwdNonStandard(List<DevJwdNonStandard> list, String yjrq, Integer yjlx, Integer yjllx) {
        saveWarningData(list, yjrq, yjlx,
                device -> {
                    DevVioEquWarning devVioEquWarning = new DevVioEquWarning();
                    devVioEquWarning.setYjrq(DateUtils.parseDate(yjrq));
                    devVioEquWarning.setSbbh(device.getKkbh());
                    devVioEquWarning.setGlbm(device.getGlbm());
                    devVioEquWarning.setYjlx(yjlx);
                    devVioEquWarning.setYjllx(yjllx);
                    devVioEquWarning.setCjsj(new Date());
                    return devVioEquWarning;
                }
        );
    }

    // 执法设备抓拍量异常保存数据方法
    private <T> void saveAbnormalWarningData(
            List<T> list,
            String yjrq,
            Integer yjlx,
            Function<T, DevVioEquWarning> converter) {

        try {
            // 批量删除
            devVioEquWarningService.deleteDevVioEquWarningBatch(yjlx, DateUtils.parseDate(yjrq));

            if (!list.isEmpty()) {
                List<DevVioEquWarning> warningList = list.stream()
                        .map(converter)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList());

                if (!warningList.isEmpty()) {
                    // 设置每批处理的数据量
                    int batchSize = 50;
                    int totalSize = warningList.size();
                    int batchCount = (totalSize + batchSize - 1) / batchSize;

                    // 分批处理数据
                    for (int i = 0; i < batchCount; i++) {
                        int fromIndex = i * batchSize;
                        int toIndex = Math.min((i + 1) * batchSize, totalSize);
                        List<DevVioEquWarning> batchList = warningList.subList(fromIndex, toIndex);

                        // 每100条数据执行一次批量插入
                        devVioEquWarningService.insertAbnormalWarningData(batchList);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("保存预警数据异常:");
            e.printStackTrace();
        }
    }

    // 通用的保存预警数据方法
    private <T> void saveWarningData(
            List<T> list,
            String yjrq,
            Integer yjlx,
            Function<T, DevVioEquWarning> converter) {

        try {
            // 批量删除
            devVioEquWarningService.deleteDevVioEquWarningBatch(yjlx, DateUtils.parseDate(yjrq));

            if (!list.isEmpty()) {
                List<DevVioEquWarning> warningList = list.stream()
                        .map(converter)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList());

                if (!warningList.isEmpty()) {
                    // 设置每批处理的数据量
                    int batchSize = 50;
                    int totalSize = warningList.size();
                    int batchCount = (totalSize + batchSize - 1) / batchSize;

                    // 分批处理数据
                    for (int i = 0; i < batchCount; i++) {
                        int fromIndex = i * batchSize;
                        int toIndex = Math.min((i + 1) * batchSize, totalSize);
                        List<DevVioEquWarning> batchList = warningList.subList(fromIndex, toIndex);

                        // 每100条数据执行一次批量插入
                        devVioEquWarningService.insertDevVioEquWarningBatch(batchList);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("保存预警数据异常:");
            e.printStackTrace();
        }
    }
}
