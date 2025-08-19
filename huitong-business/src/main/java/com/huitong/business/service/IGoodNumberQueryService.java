package com.huitong.business.service;

import java.util.List;
import com.huitong.business.domain.GoodNumberQuery;

/**
 * 靓号综合查询统计Service接口
 *
 * @author hairun
 * @date 2025-03-25
 */
public interface IGoodNumberQueryService
{
    /**
     * 查询靓号综合查询统计
     *
     * @param id 靓号综合查询统计主键
     * @return 靓号综合查询统计
     */
    public GoodNumberQuery selectGoodNumberQueryById(Long id);

    /**
     * 查询靓号综合查询统计列表
     *
     * @param goodNumberQuery 靓号综合查询统计
     * @return 靓号综合查询统计集合
     */
    public List<GoodNumberQuery> selectGoodNumberQueryList(GoodNumberQuery goodNumberQuery);
    public List<GoodNumberQuery> selectGoodNumberQueryLists(GoodNumberQuery goodNumberQuery);

    /**
     * 新增靓号综合查询统计
     *
     * @param goodNumberQuery 靓号综合查询统计
     * @return 结果
     */
    public int insertGoodNumberQuery(GoodNumberQuery goodNumberQuery);

    /**
     * 修改靓号综合查询统计
     *
     * @param goodNumberQuery 靓号综合查询统计
     * @return 结果
     */
    public int updateGoodNumberQuery(GoodNumberQuery goodNumberQuery);

    /**
     * 批量删除靓号综合查询统计
     *
     * @param ids 需要删除的靓号综合查询统计主键集合
     * @return 结果
     */
    public int deleteGoodNumberQueryByIds(String ids);

    /**
     * 删除靓号综合查询统计信息
     *
     * @param id 靓号综合查询统计主键
     * @return 结果
     */
    public int deleteGoodNumberQueryById(Long id);
}
