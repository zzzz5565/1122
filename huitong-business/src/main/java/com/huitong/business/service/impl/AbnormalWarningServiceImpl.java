package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.AbnormalWarningMapper;
import com.huitong.business.domain.AbnormalWarning;
import com.huitong.business.service.IAbnormalWarningService;
import com.huitong.common.core.text.Convert;

/**
 * 违法数据异常预警统计Service业务层处理
 *
 * @author huitong
 * @date 2025-04-14
 */
@Service
public class AbnormalWarningServiceImpl implements IAbnormalWarningService
{
    @Autowired
    private AbnormalWarningMapper abnormalWarningMapper;

    /**
     * 查询违法数据异常预警统计
     *
     * @param id 违法数据异常预警统计主键
     * @return 违法数据异常预警统计
     */
    @Override
    public AbnormalWarning selectAbnormalWarningById(Long id)
    {
        return abnormalWarningMapper.selectAbnormalWarningById(id);
    }

    /**
     * 查询违法数据异常预警统计列表
     *
     * @param abnormalWarning 违法数据异常预警统计
     * @return 违法数据异常预警统计
     */
    @Override
    public List<AbnormalWarning> selectAbnormalWarningList(AbnormalWarning abnormalWarning)
    {
        return abnormalWarningMapper.selectAbnormalWarningList(abnormalWarning);
    }
    @Override
    public List<AbnormalWarning> selectAbnormalWarningLists(AbnormalWarning abnormalWarning)
    {
        return abnormalWarningMapper.selectAbnormalWarningLists(abnormalWarning);
    }

    /**
     * 新增违法数据异常预警统计
     *
     * @param abnormalWarning 违法数据异常预警统计
     * @return 结果
     */
    @Override
    public int insertAbnormalWarning(AbnormalWarning abnormalWarning)
    {
        return abnormalWarningMapper.insertAbnormalWarning(abnormalWarning);
    }

    /**
     * 修改违法数据异常预警统计
     *
     * @param abnormalWarning 违法数据异常预警统计
     * @return 结果
     */
    @Override
    public int updateAbnormalWarning(AbnormalWarning abnormalWarning)
    {
        return abnormalWarningMapper.updateAbnormalWarning(abnormalWarning);
    }

    /**
     * 批量删除违法数据异常预警统计
     *
     * @param ids 需要删除的违法数据异常预警统计主键
     * @return 结果
     */
    @Override
    public int deleteAbnormalWarningByIds(String ids)
    {
        return abnormalWarningMapper.deleteAbnormalWarningByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除违法数据异常预警统计信息
     *
     * @param id 违法数据异常预警统计主键
     * @return 结果
     */
    @Override
    public int deleteAbnormalWarningById(Long id)
    {
        return abnormalWarningMapper.deleteAbnormalWarningById(id);
    }
}
