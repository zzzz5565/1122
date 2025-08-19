package com.huitong.business.mapper;

import java.util.List;
import com.huitong.business.domain.DeviceNoPic;

/**
 * 执法设备无备案图片统计Mapper接口
 *
 * @author huitong
 * @date 2025-04-01
 */
public interface DeviceNoPicMapper
{
    /**
     * 查询执法设备无备案图片统计
     *
     * @param id 执法设备无备案图片统计主键
     * @return 执法设备无备案图片统计
     */
    public DeviceNoPic selectDeviceNoPicById(Long id);

    /**
     * 查询执法设备无备案图片统计列表
     *
     * @param deviceNoPic 执法设备无备案图片统计
     * @return 执法设备无备案图片统计集合
     */
    public List<DeviceNoPic> selectDeviceNoPicList(DeviceNoPic deviceNoPic);
    public List<DeviceNoPic> selectDeviceNoPicLists(DeviceNoPic deviceNoPic);

    /**
     * 新增执法设备无备案图片统计
     *
     * @param deviceNoPic 执法设备无备案图片统计
     * @return 结果
     */
    public int insertDeviceNoPic(DeviceNoPic deviceNoPic);

    /**
     * 修改执法设备无备案图片统计
     *
     * @param deviceNoPic 执法设备无备案图片统计
     * @return 结果
     */
    public int updateDeviceNoPic(DeviceNoPic deviceNoPic);

    /**
     * 删除执法设备无备案图片统计
     *
     * @param id 执法设备无备案图片统计主键
     * @return 结果
     */
    public int deleteDeviceNoPicById(Long id);

    /**
     * 批量删除执法设备无备案图片统计
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDeviceNoPicByIds(String[] ids);
}
