package com.huitong.business.service;

import java.util.List;
import com.huitong.business.domain.FuseDetail;

/**
 * 集成指挥平台熔断明细Service接口
 *
 * @author huitong
 * @date 2025-04-09
 */
public interface IFuseDetailService
{
    /**
     * 查询集成指挥平台熔断明细
     *
     * @param id 集成指挥平台熔断明细主键
     * @return 集成指挥平台熔断明细
     */
    public FuseDetail selectFuseDetailById(Long id);

    /**
     * 查询集成指挥平台熔断明细列表
     *
     * @param fuseDetail 集成指挥平台熔断明细
     * @return 集成指挥平台熔断明细集合
     */
    public List<FuseDetail> selectFuseDetailList(FuseDetail fuseDetail);
    public List<FuseDetail> selectFuseDetailLists(FuseDetail fuseDetail);

    /**
     * 新增集成指挥平台熔断明细
     *
     * @param fuseDetail 集成指挥平台熔断明细
     * @return 结果
     */
    public int insertFuseDetail(FuseDetail fuseDetail);

    /**
     * 修改集成指挥平台熔断明细
     *
     * @param fuseDetail 集成指挥平台熔断明细
     * @return 结果
     */
    public int updateFuseDetail(FuseDetail fuseDetail);

    /**
     * 批量删除集成指挥平台熔断明细
     *
     * @param ids 需要删除的集成指挥平台熔断明细主键集合
     * @return 结果
     */
    public int deleteFuseDetailByIds(String ids);

    /**
     * 删除集成指挥平台熔断明细信息
     *
     * @param id 集成指挥平台熔断明细主键
     * @return 结果
     */
    public int deleteFuseDetailById(Long id);
}
