package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.GoodNumberQueryMapper;
import com.huitong.business.domain.GoodNumberQuery;
import com.huitong.business.service.IGoodNumberQueryService;
import com.huitong.common.core.text.Convert;

/**
 * 靓号综合查询统计Service业务层处理
 *
 * @author hairun
 * @date 2025-03-25
 */
@Service
public class GoodNumberQueryServiceImpl implements IGoodNumberQueryService
{
    @Autowired
    private GoodNumberQueryMapper goodNumberQueryMapper;

    /**
     * 查询靓号综合查询统计
     *
     * @param id 靓号综合查询统计主键
     * @return 靓号综合查询统计
     */
    @Override
    public GoodNumberQuery selectGoodNumberQueryById(Long id)
    {
        return goodNumberQueryMapper.selectGoodNumberQueryById(id);
    }

    /**
     * 查询靓号综合查询统计列表
     *
     * @param goodNumberQuery 靓号综合查询统计
     * @return 靓号综合查询统计
     */
    @Override
    public List<GoodNumberQuery> selectGoodNumberQueryList(GoodNumberQuery goodNumberQuery)
    {
        return goodNumberQueryMapper.selectGoodNumberQueryList(goodNumberQuery);
    }
    @Override
    public List<GoodNumberQuery> selectGoodNumberQueryLists(GoodNumberQuery goodNumberQuery)
    {
        return goodNumberQueryMapper.selectGoodNumberQueryLists(goodNumberQuery);
    }

    /**
     * 新增靓号综合查询统计
     *
     * @param goodNumberQuery 靓号综合查询统计
     * @return 结果
     */
    @Override
    public int insertGoodNumberQuery(GoodNumberQuery goodNumberQuery)
    {
        return goodNumberQueryMapper.insertGoodNumberQuery(goodNumberQuery);
    }

    /**
     * 修改靓号综合查询统计
     *
     * @param goodNumberQuery 靓号综合查询统计
     * @return 结果
     */
    @Override
    public int updateGoodNumberQuery(GoodNumberQuery goodNumberQuery)
    {
        return goodNumberQueryMapper.updateGoodNumberQuery(goodNumberQuery);
    }

    /**
     * 批量删除靓号综合查询统计
     *
     * @param ids 需要删除的靓号综合查询统计主键
     * @return 结果
     */
    @Override
    public int deleteGoodNumberQueryByIds(String ids)
    {
        return goodNumberQueryMapper.deleteGoodNumberQueryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除靓号综合查询统计信息
     *
     * @param id 靓号综合查询统计主键
     * @return 结果
     */
    @Override
    public int deleteGoodNumberQueryById(Long id)
    {
        return goodNumberQueryMapper.deleteGoodNumberQueryById(id);
    }
}
