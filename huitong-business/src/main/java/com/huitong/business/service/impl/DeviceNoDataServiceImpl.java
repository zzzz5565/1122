package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.DeviceNoDataMapper;
import com.huitong.business.domain.DeviceNoData;
import com.huitong.business.service.IDeviceNoDataService;
import com.huitong.common.core.text.Convert;

/**
 * 执法设备无数据统计Service业务层处理
 *
 * @author huitong
 * @date 2025-04-01
 */
@Service
public class DeviceNoDataServiceImpl implements IDeviceNoDataService
{
    @Autowired
    private DeviceNoDataMapper deviceNoDataMapper;

    /**
     * 查询执法设备无数据统计
     *
     * @param id 执法设备无数据统计主键
     * @return 执法设备无数据统计
     */
    @Override
    public DeviceNoData selectDeviceNoDataById(Long id)
    {
        return deviceNoDataMapper.selectDeviceNoDataById(id);
    }

    /**
     * 查询执法设备无数据统计列表
     *
     * @param deviceNoData 执法设备无数据统计
     * @return 执法设备无数据统计
     */
    @Override
    public List<DeviceNoData> selectDeviceNoDataList(DeviceNoData deviceNoData)
    {
        return deviceNoDataMapper.selectDeviceNoDataList(deviceNoData);
    }
    @Override
    public List<DeviceNoData> selectDeviceNoDataLists(DeviceNoData deviceNoData)
    {
        return deviceNoDataMapper.selectDeviceNoDataLists(deviceNoData);
    }

    /**
     * 新增执法设备无数据统计
     *
     * @param deviceNoData 执法设备无数据统计
     * @return 结果
     */
    @Override
    public int insertDeviceNoData(DeviceNoData deviceNoData)
    {
        return deviceNoDataMapper.insertDeviceNoData(deviceNoData);
    }

    /**
     * 修改执法设备无数据统计
     *
     * @param deviceNoData 执法设备无数据统计
     * @return 结果
     */
    @Override
    public int updateDeviceNoData(DeviceNoData deviceNoData)
    {
        return deviceNoDataMapper.updateDeviceNoData(deviceNoData);
    }

    /**
     * 批量删除执法设备无数据统计
     *
     * @param ids 需要删除的执法设备无数据统计主键
     * @return 结果
     */
    @Override
    public int deleteDeviceNoDataByIds(String ids)
    {
        return deviceNoDataMapper.deleteDeviceNoDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除执法设备无数据统计信息
     *
     * @param id 执法设备无数据统计主键
     * @return 结果
     */
    @Override
    public int deleteDeviceNoDataById(Long id)
    {
        return deviceNoDataMapper.deleteDeviceNoDataById(id);
    }
}
