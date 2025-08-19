package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.JczhFeiluCarDtlQureyAppMapper;
import com.huitong.business.domain.JczhFeiluCarDtlQureyApp;
import com.huitong.business.service.IJczhFeiluCarDtlQureyAppService;
import com.huitong.common.core.text.Convert;

/**
 * 集成指挥平台查询非鲁车明细-appService业务层处理
 *
 * @author huitong
 * @date 2025-05-26
 */
@Service
public class JczhFeiluCarDtlQureyAppServiceImpl implements IJczhFeiluCarDtlQureyAppService
{
    @Autowired
    private JczhFeiluCarDtlQureyAppMapper jczhFeiluCarDtlQureyAppMapper;

    /**
     * 查询集成指挥平台查询非鲁车明细-app
     *
     * @param id 集成指挥平台查询非鲁车明细-app主键
     * @return 集成指挥平台查询非鲁车明细-app
     */
    @Override
    public JczhFeiluCarDtlQureyApp selectJczhFeiluCarDtlQureyAppById(Long id)
    {
        return jczhFeiluCarDtlQureyAppMapper.selectJczhFeiluCarDtlQureyAppById(id);
    }

    /**
     * 查询集成指挥平台查询非鲁车明细-app列表
     *
     * @param jczhFeiluCarDtlQureyApp 集成指挥平台查询非鲁车明细-app
     * @return 集成指挥平台查询非鲁车明细-app
     */
    @Override
    public List<JczhFeiluCarDtlQureyApp> selectJczhFeiluCarDtlQureyAppList(JczhFeiluCarDtlQureyApp jczhFeiluCarDtlQureyApp)
    {
        return jczhFeiluCarDtlQureyAppMapper.selectJczhFeiluCarDtlQureyAppList(jczhFeiluCarDtlQureyApp);
    }
    @Override
    public List<JczhFeiluCarDtlQureyApp> selectJczhFeiluCarDtlQureyAppLists(JczhFeiluCarDtlQureyApp jczhFeiluCarDtlQureyApp)
    {
        return jczhFeiluCarDtlQureyAppMapper.selectJczhFeiluCarDtlQureyAppLists(jczhFeiluCarDtlQureyApp);
    }

    /**
     * 新增集成指挥平台查询非鲁车明细-app
     *
     * @param jczhFeiluCarDtlQureyApp 集成指挥平台查询非鲁车明细-app
     * @return 结果
     */
    @Override
    public int insertJczhFeiluCarDtlQureyApp(JczhFeiluCarDtlQureyApp jczhFeiluCarDtlQureyApp)
    {
        return jczhFeiluCarDtlQureyAppMapper.insertJczhFeiluCarDtlQureyApp(jczhFeiluCarDtlQureyApp);
    }

    /**
     * 修改集成指挥平台查询非鲁车明细-app
     *
     * @param jczhFeiluCarDtlQureyApp 集成指挥平台查询非鲁车明细-app
     * @return 结果
     */
    @Override
    public int updateJczhFeiluCarDtlQureyApp(JczhFeiluCarDtlQureyApp jczhFeiluCarDtlQureyApp)
    {
        return jczhFeiluCarDtlQureyAppMapper.updateJczhFeiluCarDtlQureyApp(jczhFeiluCarDtlQureyApp);
    }

    /**
     * 批量删除集成指挥平台查询非鲁车明细-app
     *
     * @param ids 需要删除的集成指挥平台查询非鲁车明细-app主键
     * @return 结果
     */
    @Override
    public int deleteJczhFeiluCarDtlQureyAppByIds(String ids)
    {
        return jczhFeiluCarDtlQureyAppMapper.deleteJczhFeiluCarDtlQureyAppByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除集成指挥平台查询非鲁车明细-app信息
     *
     * @param id 集成指挥平台查询非鲁车明细-app主键
     * @return 结果
     */
    @Override
    public int deleteJczhFeiluCarDtlQureyAppById(Long id)
    {
        return jczhFeiluCarDtlQureyAppMapper.deleteJczhFeiluCarDtlQureyAppById(id);
    }
}
