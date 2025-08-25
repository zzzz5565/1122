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

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@Component("SyncDevTask")
public class SyncDevTask {
    @Autowired
    private IDevInUseService devInUseService;

    @Autowired
    private IVioSurveilService vioSurveilService;

    // 同步在用设备执法情况
    public void getDevInUse() throws ParseException {
//        try {
            System.out.println("同步在用设备");
            // 获取当前日期
            LocalDate currentDate = LocalDate.now();
            // 获取前一天的日期
            LocalDate previousDate = currentDate.minusDays(1);
            LocalDateTime startTime = LocalDateTime.of(previousDate, LocalTime.MIN);
            // 定义结束时间为前一天的23:59:59
            LocalDateTime endTime = LocalDateTime.of(previousDate, LocalTime.MAX);

            // 定义日期时间格式
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // 格式化时间
            String strDayStart = startTime.format(formatter);
            String strDayEnd = endTime.format(formatter);

            // 在用设备执法情况
            DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
            DevInUse devInUse = new DevInUse();
            devInUse.setYjrq(new Date());
            List<DevInUse> list = devInUseService.selectDevInUseLists(devInUse,strDayStart,strDayEnd);
            DynamicDataSourceContextHolder.clearDataSourceType();
            for (DevInUse devInUse1 : list) {
                devInUse1.setYjrq(sdf.parse(strDayStart));
                devInUse1.setCjsj(new Date());
                DevInUse existDevInUse = devInUseService.selectDevInUseBySbbh(devInUse1.getSbbh(), strDayStart);
                if (existDevInUse == null) {
                    devInUseService.insertDevInUse(devInUse1);
                } else {
                    devInUseService.updateDevInUseBySbbh(devInUse1, devInUse1.getSbbh(), strDayStart);
                }
            }
//        }catch (Exception e) {
//            System.out.println("同步在用设备信息报错，"+e.getMessage());
//        }
    }

    // 同步在用设备执法情况（按5天前之和来同步）
    public void getDevInUse5() throws ParseException {
//        try {
        LocalDate currentDate = LocalDate.now();
        // 获取前六天的日期
        LocalDate previousDate = currentDate.minusDays(5);
        LocalDateTime startTime = LocalDateTime.of(previousDate, LocalTime.MIN);
        // 定义结束时间为前一天的23:59:59
        LocalDate endDate = currentDate.minusDays(1);
        LocalDateTime yjrq = LocalDateTime.of(endDate, LocalTime.MIN);
        LocalDateTime endTime = LocalDateTime.of(endDate, LocalTime.MAX);

        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 格式化时间
        String strDayStart = startTime.format(formatter);
        String strDayEnd = endTime.format(formatter);
        String yjrqstr = yjrq.format(formatter);

        // 在用设备执法情况
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        DevInUse devInUse = new DevInUse();
        devInUse.setYjrq(new Date());
        List<DevInUse> list = devInUseService.selectDevInUseLists(devInUse,strDayStart,strDayEnd);
        DynamicDataSourceContextHolder.clearDataSourceType();
        for (DevInUse devInUse1 : list) {
            devInUse1.setYjrq(sdf.parse(yjrqstr));
            devInUse1.setCjsj(new Date());
            DevInUse existDevInUse = devInUseService.selectDevInUseBySbbh5(devInUse1.getSbbh(), strDayStart);
            if (existDevInUse == null) {
                devInUseService.insertDevInUses(devInUse1);
            } else {
                System.out.println("暂无更新");
                //devInUseService.updateDevInUseBySbbh(devInUse1, devInUse1.getSbbh(), strDayStart);
            }
        }
//        }catch (Exception e) {
//            System.out.println("同步在用设备信息报错，"+e.getMessage());
//        }
    }

    // 同步在用设备执法情况
    public void getYcsc() throws ParseException {
//        try {
        System.out.println("同步设备状态异常但还在上传数据的设备");
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();
        // 获取前一天的日期
        LocalDate previousDate = currentDate.minusDays(1);
        LocalDateTime startTime = LocalDateTime.of(previousDate, LocalTime.MIN);
        // 定义结束时间为前一天的23:59:59
        LocalDateTime endTime = LocalDateTime.of(previousDate, LocalTime.MAX);

        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 格式化时间
        String strDayStart = startTime.format(formatter);
        String strDayEnd = endTime.format(formatter);

        // 设备状态异常上传
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        VioSurveil vioSurveil = new VioSurveil();
        List<VioSurveil> list = vioSurveilService.selectVioSurveilLists(vioSurveil,strDayStart,strDayEnd);
        DynamicDataSourceContextHolder.clearDataSourceType();

//        vioSurveilService.deleteVioSurveilByYjrq(strDayStart);
        for (VioSurveil vioSurveil1 : list) {
            vioSurveil1.setYjrq(sdf.parse(strDayStart));
            vioSurveil1.setCjsj(new Date());
            vioSurveilService.insertVioSurveil(vioSurveil1);

        }
//        }catch (Exception e) {
//            System.out.println("同步在用设备信息报错，"+e.getMessage());
//        }
    }
}
