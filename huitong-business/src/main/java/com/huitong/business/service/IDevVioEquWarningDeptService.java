package com.huitong.business.service;

import java.util.List;
import com.huitong.business.domain.DevVioEquWarningDept;

/**
 * 设备预警Service接口
 * 
 * @author jsj
 * @date 2025-08-13
 */
public interface IDevVioEquWarningDeptService 
{
    /**
     * 查询设备预警
     * 
     * @param id 设备预警主键
     * @return 设备预警
     */
    public DevVioEquWarningDept selectDevVioEquWarningDeptById(Long id);

    /**
     * 查询设备预警列表
     * 
     * @param devVioEquWarningDept 设备预警
     * @return 设备预警集合
     */
    public List<DevVioEquWarningDept> selectDevVioEquWarningDeptList(DevVioEquWarningDept devVioEquWarningDept);

    public List<DevVioEquWarningDept> selectWarningDeptList(DevVioEquWarningDept devVioEquWarningDept);

    public List<DevVioEquWarningDept> selectCsycList(DevVioEquWarningDept devVioEquWarningDept);
    public List<DevVioEquWarningDept> selectWsjscList(DevVioEquWarningDept devVioEquWarningDept);
    public List<DevVioEquWarningDept> selectZtycList(DevVioEquWarningDept devVioEquWarningDept);
    public List<DevVioEquWarningDept> selectZplycList(DevVioEquWarningDept devVioEquWarningDept);
    public List<DevVioEquWarningDept> selectSjjzList(DevVioEquWarningDept devVioEquWarningDept);
    public List<DevVioEquWarningDept> selectSjjjList(DevVioEquWarningDept devVioEquWarningDept);

    /**
     * 新增设备预警
     * 
     * @param devVioEquWarningDept 设备预警
     * @return 结果
     */
    public int insertDevVioEquWarningDept(DevVioEquWarningDept devVioEquWarningDept);

    /**
     * 修改设备预警
     * 
     * @param devVioEquWarningDept 设备预警
     * @return 结果
     */
    public int updateDevVioEquWarningDept(DevVioEquWarningDept devVioEquWarningDept);

    /**
     * 批量删除设备预警
     * 
     * @param ids 需要删除的设备预警主键集合
     * @return 结果
     */
    public int deleteDevVioEquWarningDeptByIds(String ids);

    /**
     * 删除设备预警信息
     * 
     * @param id 设备预警主键
     * @return 结果
     */
    public int deleteDevVioEquWarningDeptById(Long id);
}
