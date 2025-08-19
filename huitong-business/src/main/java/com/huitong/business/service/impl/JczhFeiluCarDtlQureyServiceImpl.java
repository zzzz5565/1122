package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.JczhFeiluCarDtlQureyMapper;
import com.huitong.business.domain.JczhFeiluCarDtlQurey;
import com.huitong.business.service.IJczhFeiluCarDtlQureyService;
import com.huitong.common.core.text.Convert;

/**
 * 集成指挥平台查询非鲁车明细Service业务层处理
 *
 * @author huitong
 * @date 2025-05-15
 */
@Service
public class JczhFeiluCarDtlQureyServiceImpl implements IJczhFeiluCarDtlQureyService
{
    @Autowired
    private JczhFeiluCarDtlQureyMapper jczhFeiluCarDtlQureyMapper;

    /**
     * 查询集成指挥平台查询非鲁车明细
     *
     * @param id 集成指挥平台查询非鲁车明细主键
     * @return 集成指挥平台查询非鲁车明细
     */
    @Override
    public JczhFeiluCarDtlQurey selectJczhFeiluCarDtlQureyById(Long id)
    {
        return jczhFeiluCarDtlQureyMapper.selectJczhFeiluCarDtlQureyById(id);
    }

    /**
     * 查询集成指挥平台查询非鲁车明细列表
     *
     * @param jczhFeiluCarDtlQurey 集成指挥平台查询非鲁车明细
     * @return 集成指挥平台查询非鲁车明细
     */
    @Override
    public List<JczhFeiluCarDtlQurey> selectJczhFeiluCarDtlQureyList(JczhFeiluCarDtlQurey jczhFeiluCarDtlQurey)
    {
        return jczhFeiluCarDtlQureyMapper.selectJczhFeiluCarDtlQureyList(jczhFeiluCarDtlQurey);
    }

    @Override
    public List<JczhFeiluCarDtlQurey> selectJczhFeiluCarDtlQureyLists(JczhFeiluCarDtlQurey jczhFeiluCarDtlQurey)
    {
        return jczhFeiluCarDtlQureyMapper.selectJczhFeiluCarDtlQureyLists(jczhFeiluCarDtlQurey);
    }

    /**
     * 新增集成指挥平台查询非鲁车明细
     *
     * @param jczhFeiluCarDtlQurey 集成指挥平台查询非鲁车明细
     * @return 结果
     */
    @Override
    public int insertJczhFeiluCarDtlQurey(JczhFeiluCarDtlQurey jczhFeiluCarDtlQurey)
    {
        return jczhFeiluCarDtlQureyMapper.insertJczhFeiluCarDtlQurey(jczhFeiluCarDtlQurey);
    }

    /**
     * 修改集成指挥平台查询非鲁车明细
     *
     * @param jczhFeiluCarDtlQurey 集成指挥平台查询非鲁车明细
     * @return 结果
     */
    @Override
    public int updateJczhFeiluCarDtlQurey(JczhFeiluCarDtlQurey jczhFeiluCarDtlQurey)
    {
        return jczhFeiluCarDtlQureyMapper.updateJczhFeiluCarDtlQurey(jczhFeiluCarDtlQurey);
    }

    /**
     * 批量删除集成指挥平台查询非鲁车明细
     *
     * @param ids 需要删除的集成指挥平台查询非鲁车明细主键
     * @return 结果
     */
    @Override
    public int deleteJczhFeiluCarDtlQureyByIds(String ids)
    {
        return jczhFeiluCarDtlQureyMapper.deleteJczhFeiluCarDtlQureyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除集成指挥平台查询非鲁车明细信息
     *
     * @param id 集成指挥平台查询非鲁车明细主键
     * @return 结果
     */
    @Override
    public int deleteJczhFeiluCarDtlQureyById(Long id)
    {
        return jczhFeiluCarDtlQureyMapper.deleteJczhFeiluCarDtlQureyById(id);
    }
}
