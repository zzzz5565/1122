package com.huitong.business.service;

import java.util.List;
import com.huitong.business.domain.DevJwdNonStandard;

/**
 * 卡口经纬度不规范统计Service接口
 *
 * @author huitong
 * @date 2025-04-01
 */
public interface IDevJwdNonStandardService
{
    /**
     * 查询卡口经纬度不规范统计
     *
     * @param id 卡口经纬度不规范统计主键
     * @return 卡口经纬度不规范统计
     */
    public DevJwdNonStandard selectDevJwdNonStandardById(Long id);

    /**
     * 查询卡口经纬度不规范统计列表
     *
     * @param devJwdNonStandard 卡口经纬度不规范统计
     * @return 卡口经纬度不规范统计集合
     */
    public List<DevJwdNonStandard> selectDevJwdNonStandardList(DevJwdNonStandard devJwdNonStandard);
    public List<DevJwdNonStandard> selectDevJwdNonStandardLists(DevJwdNonStandard devJwdNonStandard);

    /**
     * 新增卡口经纬度不规范统计
     *
     * @param devJwdNonStandard 卡口经纬度不规范统计
     * @return 结果
     */
    public int insertDevJwdNonStandard(DevJwdNonStandard devJwdNonStandard);

    /**
     * 修改卡口经纬度不规范统计
     *
     * @param devJwdNonStandard 卡口经纬度不规范统计
     * @return 结果
     */
    public int updateDevJwdNonStandard(DevJwdNonStandard devJwdNonStandard);

    /**
     * 批量删除卡口经纬度不规范统计
     *
     * @param ids 需要删除的卡口经纬度不规范统计主键集合
     * @return 结果
     */
    public int deleteDevJwdNonStandardByIds(String ids);

    /**
     * 删除卡口经纬度不规范统计信息
     *
     * @param id 卡口经纬度不规范统计主键
     * @return 结果
     */
    public int deleteDevJwdNonStandardById(Long id);
}
