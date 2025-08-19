package com.huitong.business.service;

import java.util.List;
import com.huitong.business.domain.DevNameNonStandard;

/**
 * 卡口命名不规范统计Service接口
 *
 * @author huitong
 * @date 2025-03-31
 */
public interface IDevNameNonStandardService
{
    /**
     * 查询卡口命名不规范统计
     *
     * @param id 卡口命名不规范统计主键
     * @return 卡口命名不规范统计
     */
    public DevNameNonStandard selectDevNameNonStandardById(Long id);

    /**
     * 查询卡口命名不规范统计列表
     *
     * @param devNameNonStandard 卡口命名不规范统计
     * @return 卡口命名不规范统计集合
     */
    public List<DevNameNonStandard> selectDevNameNonStandardList(DevNameNonStandard devNameNonStandard);
    public List<DevNameNonStandard> selectDevNameNonStandardLists(DevNameNonStandard devNameNonStandard);

    /**
     * 新增卡口命名不规范统计
     *
     * @param devNameNonStandard 卡口命名不规范统计
     * @return 结果
     */
    public int insertDevNameNonStandard(DevNameNonStandard devNameNonStandard);

    /**
     * 修改卡口命名不规范统计
     *
     * @param devNameNonStandard 卡口命名不规范统计
     * @return 结果
     */
    public int updateDevNameNonStandard(DevNameNonStandard devNameNonStandard);

    /**
     * 批量删除卡口命名不规范统计
     *
     * @param ids 需要删除的卡口命名不规范统计主键集合
     * @return 结果
     */
    public int deleteDevNameNonStandardByIds(String ids);

    /**
     * 删除卡口命名不规范统计信息
     *
     * @param id 卡口命名不规范统计主键
     * @return 结果
     */
    public int deleteDevNameNonStandardById(Long id);
}
