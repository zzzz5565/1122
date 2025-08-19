package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.FuseDetailMapper;
import com.huitong.business.domain.FuseDetail;
import com.huitong.business.service.IFuseDetailService;
import com.huitong.common.core.text.Convert;

/**
 * 集成指挥平台熔断明细Service业务层处理
 *
 * @author huitong
 * @date 2025-04-09
 */
@Service
public class FuseDetailServiceImpl implements IFuseDetailService
{
    @Autowired
    private FuseDetailMapper fuseDetailMapper;

    /**
     * 查询集成指挥平台熔断明细
     *
     * @param id 集成指挥平台熔断明细主键
     * @return 集成指挥平台熔断明细
     */
    @Override
    public FuseDetail selectFuseDetailById(Long id)
    {
        return fuseDetailMapper.selectFuseDetailById(id);
    }

    /**
     * 查询集成指挥平台熔断明细列表
     *
     * @param fuseDetail 集成指挥平台熔断明细
     * @return 集成指挥平台熔断明细
     */
    @Override
    public List<FuseDetail> selectFuseDetailList(FuseDetail fuseDetail)
    {
        return fuseDetailMapper.selectFuseDetailList(fuseDetail);
    }
    @Override
    public List<FuseDetail> selectFuseDetailLists(FuseDetail fuseDetail)
    {
        return fuseDetailMapper.selectFuseDetailLists(fuseDetail);
    }

    /**
     * 新增集成指挥平台熔断明细
     *
     * @param fuseDetail 集成指挥平台熔断明细
     * @return 结果
     */
    @Override
    public int insertFuseDetail(FuseDetail fuseDetail)
    {
        return fuseDetailMapper.insertFuseDetail(fuseDetail);
    }

    /**
     * 修改集成指挥平台熔断明细
     *
     * @param fuseDetail 集成指挥平台熔断明细
     * @return 结果
     */
    @Override
    public int updateFuseDetail(FuseDetail fuseDetail)
    {
        return fuseDetailMapper.updateFuseDetail(fuseDetail);
    }

    /**
     * 批量删除集成指挥平台熔断明细
     *
     * @param ids 需要删除的集成指挥平台熔断明细主键
     * @return 结果
     */
    @Override
    public int deleteFuseDetailByIds(String ids)
    {
        return fuseDetailMapper.deleteFuseDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除集成指挥平台熔断明细信息
     *
     * @param id 集成指挥平台熔断明细主键
     * @return 结果
     */
    @Override
    public int deleteFuseDetailById(Long id)
    {
        return fuseDetailMapper.deleteFuseDetailById(id);
    }
}
