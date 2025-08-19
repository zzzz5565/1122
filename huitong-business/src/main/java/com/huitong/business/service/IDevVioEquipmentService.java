package com.huitong.business.service;

import java.util.List;
import com.huitong.business.domain.DevVioEquipment;

/**
 * 设备信息Service接口
 * 
 * @author huitong
 * @date 2025-06-17
 */
public interface IDevVioEquipmentService 
{
    /**
     * 查询设备信息
     * 
     * @param id 设备信息主键
     * @return 设备信息
     */
    public DevVioEquipment selectDevVioEquipmentById(Long id);

    /**
     * 查询设备信息列表
     * 
     * @param devVioEquipment 设备信息
     * @return 设备信息集合
     */
    public List<DevVioEquipment> selectDevVioEquipmentList(DevVioEquipment devVioEquipment);

    public List<DevVioEquipment> selectDevVioEquipmentLists(DevVioEquipment devVioEquipment);

    /**
     * 新增设备信息
     * 
     * @param devVioEquipment 设备信息
     * @return 结果
     */
    public int insertDevVioEquipment(DevVioEquipment devVioEquipment);

    /**
     * 修改设备信息
     * 
     * @param devVioEquipment 设备信息
     * @return 结果
     */
    public int updateDevVioEquipment(DevVioEquipment devVioEquipment);

    /**
     * 批量删除设备信息
     * 
     * @param ids 需要删除的设备信息主键集合
     * @return 结果
     */
    public int deleteDevVioEquipmentByIds(String ids);

    /**
     * 删除设备信息信息
     * 
     * @param id 设备信息主键
     * @return 结果
     */
    public int deleteDevVioEquipmentById(Long id);
}
