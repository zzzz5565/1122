package com.huitong.business.mapper;

import java.util.List;
import com.huitong.business.domain.DevVioEquWarning;

/**
 * 设备预警Mapper接口
 *
 * @author hr
 * @date 2025-06-17
 */
public interface DevVioEquWarningMapper
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
     * 删除设备预警
     *
     * @param id 设备预警主键
     * @return 结果
     */
    public int deleteDevVioEquWarningById(Long id);

    /**
     * 批量删除设备预警
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDevVioEquWarningByIds(String[] ids);

    public int insertDevVioEquWarningBatch(List<DevVioEquWarning> list);

    public int insertAbnormalWarningData(List<DevVioEquWarning> list);

    public int deleteDevVioEquWarningBatch(DevVioEquWarning devVioEquWarning);
}
