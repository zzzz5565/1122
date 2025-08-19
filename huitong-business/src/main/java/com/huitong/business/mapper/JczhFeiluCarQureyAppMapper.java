package com.huitong.business.mapper;

import java.util.List;
import com.huitong.business.domain.JczhFeiluCarQureyApp;

/**
 * 集成指挥平台查询非鲁车-appMapper接口
 *
 * @author huitong
 * @date 2025-05-26
 */
public interface JczhFeiluCarQureyAppMapper
{
    /**
     * 查询集成指挥平台查询非鲁车-app
     *
     * @param id 集成指挥平台查询非鲁车-app主键
     * @return 集成指挥平台查询非鲁车-app
     */
    public JczhFeiluCarQureyApp selectJczhFeiluCarQureyAppById(Long id);

    /**
     * 查询集成指挥平台查询非鲁车-app列表
     *
     * @param jczhFeiluCarQureyApp 集成指挥平台查询非鲁车-app
     * @return 集成指挥平台查询非鲁车-app集合
     */
    public List<JczhFeiluCarQureyApp> selectJczhFeiluCarQureyAppList(JczhFeiluCarQureyApp jczhFeiluCarQureyApp);
    public List<JczhFeiluCarQureyApp> selectJczhFeiluCarQureyAppLists(JczhFeiluCarQureyApp jczhFeiluCarQureyApp);

    /**
     * 新增集成指挥平台查询非鲁车-app
     *
     * @param jczhFeiluCarQureyApp 集成指挥平台查询非鲁车-app
     * @return 结果
     */
    public int insertJczhFeiluCarQureyApp(JczhFeiluCarQureyApp jczhFeiluCarQureyApp);

    /**
     * 修改集成指挥平台查询非鲁车-app
     *
     * @param jczhFeiluCarQureyApp 集成指挥平台查询非鲁车-app
     * @return 结果
     */
    public int updateJczhFeiluCarQureyApp(JczhFeiluCarQureyApp jczhFeiluCarQureyApp);

    /**
     * 删除集成指挥平台查询非鲁车-app
     *
     * @param id 集成指挥平台查询非鲁车-app主键
     * @return 结果
     */
    public int deleteJczhFeiluCarQureyAppById(Long id);

    /**
     * 批量删除集成指挥平台查询非鲁车-app
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJczhFeiluCarQureyAppByIds(String[] ids);
}
