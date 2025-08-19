package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.JczhFeiluCarQureyMapper;
import com.huitong.business.domain.JczhFeiluCarQurey;
import com.huitong.business.service.IJczhFeiluCarQureyService;
import com.huitong.common.core.text.Convert;

/**
 * 集成指挥平台查询非鲁车Service业务层处理
 *
 * @author huitong
 * @date 2025-05-15
 */
@Service
public class JczhFeiluCarQureyServiceImpl implements IJczhFeiluCarQureyService
{
    @Autowired
    private JczhFeiluCarQureyMapper jczhFeiluCarQureyMapper;

    /**
     * 查询集成指挥平台查询非鲁车
     *
     * @param id 集成指挥平台查询非鲁车主键
     * @return 集成指挥平台查询非鲁车
     */
    @Override
    public JczhFeiluCarQurey selectJczhFeiluCarQureyById(Long id)
    {
        return jczhFeiluCarQureyMapper.selectJczhFeiluCarQureyById(id);
    }

    /**
     * 查询集成指挥平台查询非鲁车列表
     *
     * @param jczhFeiluCarQurey 集成指挥平台查询非鲁车
     * @return 集成指挥平台查询非鲁车
     */
    @Override
    public List<JczhFeiluCarQurey> selectJczhFeiluCarQureyList(JczhFeiluCarQurey jczhFeiluCarQurey)
    {
        return jczhFeiluCarQureyMapper.selectJczhFeiluCarQureyList(jczhFeiluCarQurey);
    }
    @Override
    public List<JczhFeiluCarQurey> selectJczhFeiluCarQureyLists(JczhFeiluCarQurey jczhFeiluCarQurey)
    {
        return jczhFeiluCarQureyMapper.selectJczhFeiluCarQureyLists(jczhFeiluCarQurey);
    }

    /**
     * 新增集成指挥平台查询非鲁车
     *
     * @param jczhFeiluCarQurey 集成指挥平台查询非鲁车
     * @return 结果
     */
    @Override
    public int insertJczhFeiluCarQurey(JczhFeiluCarQurey jczhFeiluCarQurey)
    {
        return jczhFeiluCarQureyMapper.insertJczhFeiluCarQurey(jczhFeiluCarQurey);
    }

    /**
     * 修改集成指挥平台查询非鲁车
     *
     * @param jczhFeiluCarQurey 集成指挥平台查询非鲁车
     * @return 结果
     */
    @Override
    public int updateJczhFeiluCarQurey(JczhFeiluCarQurey jczhFeiluCarQurey)
    {
        return jczhFeiluCarQureyMapper.updateJczhFeiluCarQurey(jczhFeiluCarQurey);
    }

    /**
     * 批量删除集成指挥平台查询非鲁车
     *
     * @param ids 需要删除的集成指挥平台查询非鲁车主键
     * @return 结果
     */
    @Override
    public int deleteJczhFeiluCarQureyByIds(String ids)
    {
        return jczhFeiluCarQureyMapper.deleteJczhFeiluCarQureyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除集成指挥平台查询非鲁车信息
     *
     * @param id 集成指挥平台查询非鲁车主键
     * @return 结果
     */
    @Override
    public int deleteJczhFeiluCarQureyById(Long id)
    {
        return jczhFeiluCarQureyMapper.deleteJczhFeiluCarQureyById(id);
    }
}
