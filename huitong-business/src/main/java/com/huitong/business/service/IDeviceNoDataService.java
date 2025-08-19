package com.huitong.business.service;

import java.util.List;
import com.huitong.business.domain.DeviceNoData;

/**
 * 执法设备无数据统计Service接口
 *
 * @author huitong
 * @date 2025-04-01
 */
public interface IDeviceNoDataService
{
    /**
     * 查询执法设备无数据统计
     *
     * @param id 执法设备无数据统计主键
     * @return 执法设备无数据统计
     */
    public DeviceNoData selectDeviceNoDataById(Long id);

    /**
     * 查询执法设备无数据统计列表
     *
     * @param deviceNoData 执法设备无数据统计
     * @return 执法设备无数据统计集合
     */
    public List<DeviceNoData> selectDeviceNoDataList(DeviceNoData deviceNoData);
    public List<DeviceNoData> selectDeviceNoDataLists(DeviceNoData deviceNoData);

    /**
     * 新增执法设备无数据统计
     *
     * @param deviceNoData 执法设备无数据统计
     * @return 结果
     */
    public int insertDeviceNoData(DeviceNoData deviceNoData);

    /**
     * 修改执法设备无数据统计
     *
     * @param deviceNoData 执法设备无数据统计
     * @return 结果
     */
    public int updateDeviceNoData(DeviceNoData deviceNoData);

    /**
     * 批量删除执法设备无数据统计
     *
     * @param ids 需要删除的执法设备无数据统计主键集合
     * @return 结果
     */
    public int deleteDeviceNoDataByIds(String ids);

    /**
     * 删除执法设备无数据统计信息
     *
     * @param id 执法设备无数据统计主键
     * @return 结果
     */
    public int deleteDeviceNoDataById(Long id);
}
