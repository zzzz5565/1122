package com.huitong.business.service;

import java.util.Date;
import java.util.List;
import com.huitong.business.domain.DevVioEquWarning;

/**
 * 设备预警Service接口
 *
 * @author hr
 * @date 2025-06-17
 */
public interface IDevVioEquWarningService
{
    /**
     * 查询设备预警
     *
     * @param id 设备预警主键
     * @return 设备预警
     */
    public DevVioEquWarning selectDevVioEquWarningById(Long id);

    /**
     * 查询设备预警列表
     *
     * @param devVioEquWarning 设备预警
     * @return 设备预警集合
     */
    public List<DevVioEquWarning> selectDevVioEquWarningList(DevVioEquWarning devVioEquWarning);

    public List<DevVioEquWarning> selectDevVioEquWarningLists(DevVioEquWarning devVioEquWarning);

    /**
     * 新增设备预警
     *
     * @param devVioEquWarning 设备预警
     * @return 结果
     */
    public int insertDevVioEquWarning(DevVioEquWarning devVioEquWarning);

    /**
     * 修改设备预警
     *
     * @param devVioEquWarning 设备预警
     * @return 结果
     */
    public int updateDevVioEquWarning(DevVioEquWarning devVioEquWarning);

    /**
     * 批量删除设备预警
     *
     * @param ids 需要删除的设备预警主键集合
     * @return 结果
     */
    public int deleteDevVioEquWarningByIds(String ids);

    /**
     * 删除设备预警信息
     *
     * @param id 设备预警主键
     * @return 结果
     */
    public int deleteDevVioEquWarningById(Long id);

    /**
     * 批量处理异常警告数据并插入数据库（每100条一批）
     * @param list 异常警告列表
     * @return 插入的总记录数
     */
    public int insertDevVioEquWarningBatch(List<DevVioEquWarning> list);

    public int insertAbnormalWarningData(List<DevVioEquWarning> list);

    /**
     * 批量删除
     *
     * */
    public int deleteDevVioEquWarningBatch(Integer yjlx, Date yjrq);
}
