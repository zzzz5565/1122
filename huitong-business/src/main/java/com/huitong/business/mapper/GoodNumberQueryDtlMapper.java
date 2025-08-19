package com.huitong.business.mapper;

import java.util.List;
import com.huitong.business.domain.GoodNumberQueryDtl;

/**
 * 靓号综合查询详情Mapper接口
 *
 * @author huitong
 * @date 2025-03-25
 */
public interface GoodNumberQueryDtlMapper
{
    /**
     * 查询靓号综合查询详情
     *
     * @param id 靓号综合查询详情主键
     * @return 靓号综合查询详情
     */
    public GoodNumberQueryDtl selectGoodNumberQueryDtlById(Long id);

    /**
     * 查询靓号综合查询详情列表
     *
     * @param goodNumberQueryDtl 靓号综合查询详情
     * @return 靓号综合查询详情集合
     */
    public List<GoodNumberQueryDtl> selectGoodNumberQueryDtlList(GoodNumberQueryDtl goodNumberQueryDtl);
    public List<GoodNumberQueryDtl> selectGoodNumberQueryDtlLists(GoodNumberQueryDtl goodNumberQueryDtl);

    /**
     * 新增靓号综合查询详情
     *
     * @param goodNumberQueryDtl 靓号综合查询详情
     * @return 结果
     */
    public int insertGoodNumberQueryDtl(GoodNumberQueryDtl goodNumberQueryDtl);

    /**
     * 修改靓号综合查询详情
     *
     * @param goodNumberQueryDtl 靓号综合查询详情
     * @return 结果
     */
    public int updateGoodNumberQueryDtl(GoodNumberQueryDtl goodNumberQueryDtl);

    /**
     * 删除靓号综合查询详情
     *
     * @param id 靓号综合查询详情主键
     * @return 结果
     */
    public int deleteGoodNumberQueryDtlById(Long id);

    /**
     * 批量删除靓号综合查询详情
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGoodNumberQueryDtlByIds(String[] ids);
}
