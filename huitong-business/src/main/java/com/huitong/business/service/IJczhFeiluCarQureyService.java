package com.huitong.business.service;

import java.util.List;
import com.huitong.business.domain.JczhFeiluCarQurey;

/**
 * 集成指挥平台查询非鲁车Service接口
 *
 * @author huitong
 * @date 2025-05-15
 */
public interface IJczhFeiluCarQureyService
{
    /**
     * 查询集成指挥平台查询非鲁车
     *
     * @param id 集成指挥平台查询非鲁车主键
     * @return 集成指挥平台查询非鲁车
     */
    public JczhFeiluCarQurey selectJczhFeiluCarQureyById(Long id);

    /**
     * 查询集成指挥平台查询非鲁车列表
     *
     * @param jczhFeiluCarQurey 集成指挥平台查询非鲁车
     * @return 集成指挥平台查询非鲁车集合
     */
    public List<JczhFeiluCarQurey> selectJczhFeiluCarQureyList(JczhFeiluCarQurey jczhFeiluCarQurey);
    public List<JczhFeiluCarQurey> selectJczhFeiluCarQureyLists(JczhFeiluCarQurey jczhFeiluCarQurey);

    /**
     * 新增集成指挥平台查询非鲁车
     *
     * @param jczhFeiluCarQurey 集成指挥平台查询非鲁车
     * @return 结果
     */
    public int insertJczhFeiluCarQurey(JczhFeiluCarQurey jczhFeiluCarQurey);

    /**
     * 修改集成指挥平台查询非鲁车
     *
     * @param jczhFeiluCarQurey 集成指挥平台查询非鲁车
     * @return 结果
     */
    public int updateJczhFeiluCarQurey(JczhFeiluCarQurey jczhFeiluCarQurey);

    /**
     * 批量删除集成指挥平台查询非鲁车
     *
     * @param ids 需要删除的集成指挥平台查询非鲁车主键集合
     * @return 结果
     */
    public int deleteJczhFeiluCarQureyByIds(String ids);

    /**
     * 删除集成指挥平台查询非鲁车信息
     *
     * @param id 集成指挥平台查询非鲁车主键
     * @return 结果
     */
    public int deleteJczhFeiluCarQureyById(Long id);
}
