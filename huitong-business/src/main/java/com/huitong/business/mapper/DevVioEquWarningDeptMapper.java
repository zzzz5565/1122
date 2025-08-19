package com.huitong.business.mapper;

import java.util.List;
import com.huitong.business.domain.DevVioEquWarningDept;

/**
 * 设备预警Mapper接口
 * 
 * @author jsj
 * @date 2025-08-13
 */
public interface DevVioEquWarningDeptMapper 
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

    // 初审异常
    public List<DevVioEquWarningDept> selectCsycList(DevVioEquWarningDept devVioEquWarningDept);

    // 无数据上传
    public List<DevVioEquWarningDept> selectWsjscList(DevVioEquWarningDept devVioEquWarningDept);

    // 状态异常变化
    public List<DevVioEquWarningDept> selectZtycList(DevVioEquWarningDept devVioEquWarningDept);

    // 抓拍量异常
    public List<DevVioEquWarningDept> selectZplycList(DevVioEquWarningDept devVioEquWarningDept);

    // 数据激增
    public List<DevVioEquWarningDept> selectSjjzList(DevVioEquWarningDept devVioEquWarningDept);

    // 数据巨减
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
     * 删除设备预警
     * 
     * @param id 设备预警主键
     * @return 结果
     */
    public int deleteDevVioEquWarningDeptById(Long id);

    /**
     * 批量删除设备预警
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDevVioEquWarningDeptByIds(String[] ids);
}
