package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.DevOperationMapper;
import com.huitong.business.domain.DevOperation;
import com.huitong.business.service.IDevOperationService;
import com.huitong.common.core.text.Convert;

/**
 * 重要点位卡口运行稳定情况Service业务层处理
 *
 * @author huitong
 * @date 2025-04-01
 */
@Service
public class DevOperationServiceImpl implements IDevOperationService
{
    @Autowired
    private DevOperationMapper devOperationMapper;

    /**
     * 查询重要点位卡口运行稳定情况
     *
     * @param id 重要点位卡口运行稳定情况主键
     * @return 重要点位卡口运行稳定情况
     */
    @Override
    public DevOperation selectDevOperationById(Long id)
    {
        return devOperationMapper.selectDevOperationById(id);
    }

    /**
     * 查询重要点位卡口运行稳定情况列表
     *
     * @param devOperation 重要点位卡口运行稳定情况
     * @return 重要点位卡口运行稳定情况
     */
    @Override
    public List<DevOperation> selectDevOperationList(DevOperation devOperation)
    {
        return devOperationMapper.selectDevOperationList(devOperation);
    }
    @Override
    public List<DevOperation> selectDevOperationLists(DevOperation devOperation)
    {
        return devOperationMapper.selectDevOperationLists(devOperation);
    }

    /**
     * 新增重要点位卡口运行稳定情况
     *
     * @param devOperation 重要点位卡口运行稳定情况
     * @return 结果
     */
    @Override
    public int insertDevOperation(DevOperation devOperation)
    {
        return devOperationMapper.insertDevOperation(devOperation);
    }

    /**
     * 修改重要点位卡口运行稳定情况
     *
     * @param devOperation 重要点位卡口运行稳定情况
     * @return 结果
     */
    @Override
    public int updateDevOperation(DevOperation devOperation)
    {
        return devOperationMapper.updateDevOperation(devOperation);
    }

    /**
     * 批量删除重要点位卡口运行稳定情况
     *
     * @param ids 需要删除的重要点位卡口运行稳定情况主键
     * @return 结果
     */
    @Override
    public int deleteDevOperationByIds(String ids)
    {
        return devOperationMapper.deleteDevOperationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除重要点位卡口运行稳定情况信息
     *
     * @param id 重要点位卡口运行稳定情况主键
     * @return 结果
     */
    @Override
    public int deleteDevOperationById(Long id)
    {
        return devOperationMapper.deleteDevOperationById(id);
    }
}
