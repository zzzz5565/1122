package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.JczhFeiluCarQureyAppMapper;
import com.huitong.business.domain.JczhFeiluCarQureyApp;
import com.huitong.business.service.IJczhFeiluCarQureyAppService;
import com.huitong.common.core.text.Convert;

/**
 * 集成指挥平台查询非鲁车-appService业务层处理
 *
 * @author huitong
 * @date 2025-05-26
 */
@Service
public class JczhFeiluCarQureyAppServiceImpl implements IJczhFeiluCarQureyAppService
{
    @Autowired
    private JczhFeiluCarQureyAppMapper jczhFeiluCarQureyAppMapper;

    /**
     * 查询集成指挥平台查询非鲁车-app
     *
     * @param id 集成指挥平台查询非鲁车-app主键
     * @return 集成指挥平台查询非鲁车-app
     */
    @Override
    public JczhFeiluCarQureyApp selectJczhFeiluCarQureyAppById(Long id)
    {
        return jczhFeiluCarQureyAppMapper.selectJczhFeiluCarQureyAppById(id);
    }

    /**
     * 查询集成指挥平台查询非鲁车-app列表
     *
     * @param jczhFeiluCarQureyApp 集成指挥平台查询非鲁车-app
     * @return 集成指挥平台查询非鲁车-app
     */
    @Override
    public List<JczhFeiluCarQureyApp> selectJczhFeiluCarQureyAppList(JczhFeiluCarQureyApp jczhFeiluCarQureyApp)
    {
        return jczhFeiluCarQureyAppMapper.selectJczhFeiluCarQureyAppList(jczhFeiluCarQureyApp);
    }
    @Override
    public List<JczhFeiluCarQureyApp> selectJczhFeiluCarQureyAppLists(JczhFeiluCarQureyApp jczhFeiluCarQureyApp)
    {
        return jczhFeiluCarQureyAppMapper.selectJczhFeiluCarQureyAppLists(jczhFeiluCarQureyApp);
    }

    /**
     * 新增集成指挥平台查询非鲁车-app
     *
     * @param jczhFeiluCarQureyApp 集成指挥平台查询非鲁车-app
     * @return 结果
     */
    @Override
    public int insertJczhFeiluCarQureyApp(JczhFeiluCarQureyApp jczhFeiluCarQureyApp)
    {
        return jczhFeiluCarQureyAppMapper.insertJczhFeiluCarQureyApp(jczhFeiluCarQureyApp);
    }

    /**
     * 修改集成指挥平台查询非鲁车-app
     *
     * @param jczhFeiluCarQureyApp 集成指挥平台查询非鲁车-app
     * @return 结果
     */
    @Override
    public int updateJczhFeiluCarQureyApp(JczhFeiluCarQureyApp jczhFeiluCarQureyApp)
    {
        return jczhFeiluCarQureyAppMapper.updateJczhFeiluCarQureyApp(jczhFeiluCarQureyApp);
    }

    /**
     * 批量删除集成指挥平台查询非鲁车-app
     *
     * @param ids 需要删除的集成指挥平台查询非鲁车-app主键
     * @return 结果
     */
    @Override
    public int deleteJczhFeiluCarQureyAppByIds(String ids)
    {
        return jczhFeiluCarQureyAppMapper.deleteJczhFeiluCarQureyAppByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除集成指挥平台查询非鲁车-app信息
     *
     * @param id 集成指挥平台查询非鲁车-app主键
     * @return 结果
     */
    @Override
    public int deleteJczhFeiluCarQureyAppById(Long id)
    {
        return jczhFeiluCarQureyAppMapper.deleteJczhFeiluCarQureyAppById(id);
    }
}
