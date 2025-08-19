package com.huitong.business.service;

import java.util.List;
import com.huitong.business.domain.FeiluCarQurey;

/**
 * 查询非鲁车Service接口
 *
 * @author huitong
 * @date 2025-04-09
 */
public interface IFeiluCarQureyService
{
    /**
     * 查询查询非鲁车
     *
     * @param id 查询非鲁车主键
     * @return 查询非鲁车
     */
    public FeiluCarQurey selectFeiluCarQureyById(Long id);

    /**
     * 查询查询非鲁车列表
     *
     * @param feiluCarQurey 查询非鲁车
     * @return 查询非鲁车集合
     */
    public List<FeiluCarQurey> selectFeiluCarQureyList(FeiluCarQurey feiluCarQurey);
    public List<FeiluCarQurey> selectFeiluCarQureyLists(FeiluCarQurey feiluCarQurey);

    /**
     * 新增查询非鲁车
     *
     * @param feiluCarQurey 查询非鲁车
     * @return 结果
     */
    public int insertFeiluCarQurey(FeiluCarQurey feiluCarQurey);

    /**
     * 修改查询非鲁车
     *
     * @param feiluCarQurey 查询非鲁车
     * @return 结果
     */
    public int updateFeiluCarQurey(FeiluCarQurey feiluCarQurey);

    /**
     * 批量删除查询非鲁车
     *
     * @param ids 需要删除的查询非鲁车主键集合
     * @return 结果
     */
    public int deleteFeiluCarQureyByIds(String ids);

    /**
     * 删除查询非鲁车信息
     *
     * @param id 查询非鲁车主键
     * @return 结果
     */
    public int deleteFeiluCarQureyById(Long id);
}
