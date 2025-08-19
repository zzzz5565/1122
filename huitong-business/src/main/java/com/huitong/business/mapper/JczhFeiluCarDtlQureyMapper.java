package com.huitong.business.mapper;

import java.util.List;
import com.huitong.business.domain.JczhFeiluCarDtlQurey;

/**
 * 集成指挥平台查询非鲁车明细Mapper接口
 *
 * @author huitong
 * @date 2025-05-15
 */
public interface JczhFeiluCarDtlQureyMapper
{
    /**
     * 查询集成指挥平台查询非鲁车明细
     *
     * @param id 集成指挥平台查询非鲁车明细主键
     * @return 集成指挥平台查询非鲁车明细
     */
    public JczhFeiluCarDtlQurey selectJczhFeiluCarDtlQureyById(Long id);

    /**
     * 查询集成指挥平台查询非鲁车明细列表
     *
     * @param jczhFeiluCarDtlQurey 集成指挥平台查询非鲁车明细
     * @return 集成指挥平台查询非鲁车明细集合
     */
    public List<JczhFeiluCarDtlQurey> selectJczhFeiluCarDtlQureyList(JczhFeiluCarDtlQurey jczhFeiluCarDtlQurey);
    public List<JczhFeiluCarDtlQurey> selectJczhFeiluCarDtlQureyLists(JczhFeiluCarDtlQurey jczhFeiluCarDtlQurey);

    /**
     * 新增集成指挥平台查询非鲁车明细
     *
     * @param jczhFeiluCarDtlQurey 集成指挥平台查询非鲁车明细
     * @return 结果
     */
    public int insertJczhFeiluCarDtlQurey(JczhFeiluCarDtlQurey jczhFeiluCarDtlQurey);

    /**
     * 修改集成指挥平台查询非鲁车明细
     *
     * @param jczhFeiluCarDtlQurey 集成指挥平台查询非鲁车明细
     * @return 结果
     */
    public int updateJczhFeiluCarDtlQurey(JczhFeiluCarDtlQurey jczhFeiluCarDtlQurey);

    /**
     * 删除集成指挥平台查询非鲁车明细
     *
     * @param id 集成指挥平台查询非鲁车明细主键
     * @return 结果
     */
    public int deleteJczhFeiluCarDtlQureyById(Long id);

    /**
     * 批量删除集成指挥平台查询非鲁车明细
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJczhFeiluCarDtlQureyByIds(String[] ids);
}
