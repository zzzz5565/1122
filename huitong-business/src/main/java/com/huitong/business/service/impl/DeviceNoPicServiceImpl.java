package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.DeviceNoPicMapper;
import com.huitong.business.domain.DeviceNoPic;
import com.huitong.business.service.IDeviceNoPicService;
import com.huitong.common.core.text.Convert;

/**
 * 执法设备无备案图片统计Service业务层处理
 *
 * @author huitong
 * @date 2025-04-01
 */
@Service
public class DeviceNoPicServiceImpl implements IDeviceNoPicService
{
    @Autowired
    private DeviceNoPicMapper deviceNoPicMapper;

    /**
     * 查询执法设备无备案图片统计
     *
     * @param id 执法设备无备案图片统计主键
     * @return 执法设备无备案图片统计
     */
    @Override
    public DeviceNoPic selectDeviceNoPicById(Long id)
    {
        return deviceNoPicMapper.selectDeviceNoPicById(id);
    }

    /**
     * 查询执法设备无备案图片统计列表
     *
     * @param deviceNoPic 执法设备无备案图片统计
     * @return 执法设备无备案图片统计
     */
    @Override
    public List<DeviceNoPic> selectDeviceNoPicList(DeviceNoPic deviceNoPic)
    {
        return deviceNoPicMapper.selectDeviceNoPicList(deviceNoPic);
    }
    @Override
    public List<DeviceNoPic> selectDeviceNoPicLists(DeviceNoPic deviceNoPic)
    {
        return deviceNoPicMapper.selectDeviceNoPicLists(deviceNoPic);
    }

    /**
     * 新增执法设备无备案图片统计
     *
     * @param deviceNoPic 执法设备无备案图片统计
     * @return 结果
     */
    @Override
    public int insertDeviceNoPic(DeviceNoPic deviceNoPic)
    {
        return deviceNoPicMapper.insertDeviceNoPic(deviceNoPic);
    }

    /**
     * 修改执法设备无备案图片统计
     *
     * @param deviceNoPic 执法设备无备案图片统计
     * @return 结果
     */
    @Override
    public int updateDeviceNoPic(DeviceNoPic deviceNoPic)
    {
        return deviceNoPicMapper.updateDeviceNoPic(deviceNoPic);
    }

    /**
     * 批量删除执法设备无备案图片统计
     *
     * @param ids 需要删除的执法设备无备案图片统计主键
     * @return 结果
     */
    @Override
    public int deleteDeviceNoPicByIds(String ids)
    {
        return deviceNoPicMapper.deleteDeviceNoPicByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除执法设备无备案图片统计信息
     *
     * @param id 执法设备无备案图片统计主键
     * @return 结果
     */
    @Override
    public int deleteDeviceNoPicById(Long id)
    {
        return deviceNoPicMapper.deleteDeviceNoPicById(id);
    }
}
