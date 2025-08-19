package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.GoodNumberQueryDtlMapper;
import com.huitong.business.domain.GoodNumberQueryDtl;
import com.huitong.business.service.IGoodNumberQueryDtlService;
import com.huitong.common.core.text.Convert;

/**
 * 靓号综合查询详情Service业务层处理
 *
 * @author huitong
 * @date 2025-03-25
 */
@Service
public class GoodNumberQueryDtlServiceImpl implements IGoodNumberQueryDtlService
{
    @Autowired
    private GoodNumberQueryDtlMapper goodNumberQueryDtlMapper;

    /**
     * 查询靓号综合查询详情
     *
     * @param id 靓号综合查询详情主键
     * @return 靓号综合查询详情
     */
    @Override
    public GoodNumberQueryDtl selectGoodNumberQueryDtlById(Long id)
    {
        return goodNumberQueryDtlMapper.selectGoodNumberQueryDtlById(id);
    }

    /**
     * 查询靓号综合查询详情列表
     *
     * @param goodNumberQueryDtl 靓号综合查询详情
     * @return 靓号综合查询详情
     */
    @Override
    public List<GoodNumberQueryDtl> selectGoodNumberQueryDtlList(GoodNumberQueryDtl goodNumberQueryDtl)
    {
        return goodNumberQueryDtlMapper.selectGoodNumberQueryDtlList(goodNumberQueryDtl);
    }
    @Override
    public List<GoodNumberQueryDtl> selectGoodNumberQueryDtlLists(GoodNumberQueryDtl goodNumberQueryDtl)
    {
        return goodNumberQueryDtlMapper.selectGoodNumberQueryDtlLists(goodNumberQueryDtl);
    }

    /**
     * 新增靓号综合查询详情
     *
     * @param goodNumberQueryDtl 靓号综合查询详情
     * @return 结果
     */
    @Override
    public int insertGoodNumberQueryDtl(GoodNumberQueryDtl goodNumberQueryDtl)
    {
        return goodNumberQueryDtlMapper.insertGoodNumberQueryDtl(goodNumberQueryDtl);
    }

    /**
     * 修改靓号综合查询详情
     *
     * @param goodNumberQueryDtl 靓号综合查询详情
     * @return 结果
     */
    @Override
    public int updateGoodNumberQueryDtl(GoodNumberQueryDtl goodNumberQueryDtl)
    {
        return goodNumberQueryDtlMapper.updateGoodNumberQueryDtl(goodNumberQueryDtl);
    }

    /**
     * 批量删除靓号综合查询详情
     *
     * @param ids 需要删除的靓号综合查询详情主键
     * @return 结果
     */
    @Override
    public int deleteGoodNumberQueryDtlByIds(String ids)
    {
        return goodNumberQueryDtlMapper.deleteGoodNumberQueryDtlByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除靓号综合查询详情信息
     *
     * @param id 靓号综合查询详情主键
     * @return 结果
     */
    @Override
    public int deleteGoodNumberQueryDtlById(Long id)
    {
        return goodNumberQueryDtlMapper.deleteGoodNumberQueryDtlById(id);
    }
}
