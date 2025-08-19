package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.DevVioEquipmentMapper;
import com.huitong.business.domain.DevVioEquipment;
import com.huitong.business.service.IDevVioEquipmentService;
import com.huitong.common.core.text.Convert;

/**
 * 设备信息Service业务层处理
 * 
 * @author huitong
 * @date 2025-06-17
 */
@Service
public class DevVioEquipmentServiceImpl implements IDevVioEquipmentService 
{
    @Autowired
    private DevVioEquipmentMapper devVioEquipmentMapper;

    /**
     * 查询设备信息
     * 
     * @param id 设备信息主键
     * @return 设备信息
     */
    @Override
    public DevVioEquipment selectDevVioEquipmentById(Long id)
    {
        return devVioEquipmentMapper.selectDevVioEquipmentById(id);
    }

    /**
     * 查询设备信息列表
     * 
     * @param devVioEquipment 设备信息
     * @return 设备信息
     */
    @Override
    public List<DevVioEquipment> selectDevVioEquipmentList(DevVioEquipment devVioEquipment)
    {
        return devVioEquipmentMapper.selectDevVioEquipmentList(devVioEquipment);
    }

    @Override
    public List<DevVioEquipment> selectDevVioEquipmentLists(DevVioEquipment devVioEquipment)
    {
        return devVioEquipmentMapper.selectDevVioEquipmentLists(devVioEquipment);
    }

    /**
     * 新增设备信息
     * 
     * @param devVioEquipment 设备信息
     * @return 结果
     */
    @Override
    public int insertDevVioEquipment(DevVioEquipment devVioEquipment)
    {
        return devVioEquipmentMapper.insertDevVioEquipment(devVioEquipment);
    }

    /**
     * 修改设备信息
     * 
     * @param devVioEquipment 设备信息
     * @return 结果
     */
    @Override
    public int updateDevVioEquipment(DevVioEquipment devVioEquipment)
    {
        return devVioEquipmentMapper.updateDevVioEquipment(devVioEquipment);
    }

    /**
     * 批量删除设备信息
     * 
     * @param ids 需要删除的设备信息主键
     * @return 结果
     */
    @Override
    public int deleteDevVioEquipmentByIds(String ids)
    {
        return devVioEquipmentMapper.deleteDevVioEquipmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备信息信息
     * 
     * @param id 设备信息主键
     * @return 结果
     */
    @Override
    public int deleteDevVioEquipmentById(Long id)
    {
        return devVioEquipmentMapper.deleteDevVioEquipmentById(id);
    }
}
