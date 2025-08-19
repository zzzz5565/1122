package com.huitong.business.service;

import java.util.List;
import com.huitong.business.domain.AbnormalWarning;

/**
 * 违法数据异常预警统计Service接口
 *
 * @author huitong
 * @date 2025-04-14
 */
public interface IAbnormalWarningService
{
    /**
     * 查询违法数据异常预警统计
     *
     * @param id 违法数据异常预警统计主键
     * @return 违法数据异常预警统计
     */
    public AbnormalWarning selectAbnormalWarningById(Long id);

    /**
     * 查询违法数据异常预警统计列表
     *
     * @param abnormalWarning 违法数据异常预警统计
     * @return 违法数据异常预警统计集合
     */
    public List<AbnormalWarning> selectAbnormalWarningList(AbnormalWarning abnormalWarning);
    public List<AbnormalWarning> selectAbnormalWarningLists(AbnormalWarning abnormalWarning);

    /**
     * 新增违法数据异常预警统计
     *
     * @param abnormalWarning 违法数据异常预警统计
     * @return 结果
     */
    public int insertAbnormalWarning(AbnormalWarning abnormalWarning);

    /**
     * 修改违法数据异常预警统计
     *
     * @param abnormalWarning 违法数据异常预警统计
     * @return 结果
     */
    public int updateAbnormalWarning(AbnormalWarning abnormalWarning);

    /**
     * 批量删除违法数据异常预警统计
     *
     * @param ids 需要删除的违法数据异常预警统计主键集合
     * @return 结果
     */
    public int deleteAbnormalWarningByIds(String ids);

    /**
     * 删除违法数据异常预警统计信息
     *
     * @param id 违法数据异常预警统计主键
     * @return 结果
     */
    public int deleteAbnormalWarningById(Long id);
}
