package com.huitong.business.service;

import java.util.List;
import com.huitong.business.domain.DevOperation;

/**
 * 重要点位卡口运行稳定情况Service接口
 *
 * @author huitong
 * @date 2025-04-01
 */
public interface IDevOperationService
{
    /**
     * 查询重要点位卡口运行稳定情况
     *
     * @param id 重要点位卡口运行稳定情况主键
     * @return 重要点位卡口运行稳定情况
     */
    public DevOperation selectDevOperationById(Long id);

    /**
     * 查询重要点位卡口运行稳定情况列表
     *
     * @param devOperation 重要点位卡口运行稳定情况
     * @return 重要点位卡口运行稳定情况集合
     */
    public List<DevOperation> selectDevOperationList(DevOperation devOperation);
    public List<DevOperation> selectDevOperationLists(DevOperation devOperation);

    /**
     * 新增重要点位卡口运行稳定情况
     *
     * @param devOperation 重要点位卡口运行稳定情况
     * @return 结果
     */
    public int insertDevOperation(DevOperation devOperation);

    /**
     * 修改重要点位卡口运行稳定情况
     *
     * @param devOperation 重要点位卡口运行稳定情况
     * @return 结果
     */
    public int updateDevOperation(DevOperation devOperation);

    /**
     * 批量删除重要点位卡口运行稳定情况
     *
     * @param ids 需要删除的重要点位卡口运行稳定情况主键集合
     * @return 结果
     */
    public int deleteDevOperationByIds(String ids);

    /**
     * 删除重要点位卡口运行稳定情况信息
     *
     * @param id 重要点位卡口运行稳定情况主键
     * @return 结果
     */
    public int deleteDevOperationById(Long id);
}
