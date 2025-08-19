package com.huitong.business.service;

import java.util.List;
import com.huitong.business.domain.JczhFeiluCarDtlQureyApp;

/**
 * 集成指挥平台查询非鲁车明细-appService接口
 *
 * @author huitong
 * @date 2025-05-26
 */
public interface IJczhFeiluCarDtlQureyAppService
{
    /**
     * 查询集成指挥平台查询非鲁车明细-app
     *
     * @param id 集成指挥平台查询非鲁车明细-app主键
     * @return 集成指挥平台查询非鲁车明细-app
     */
    public JczhFeiluCarDtlQureyApp selectJczhFeiluCarDtlQureyAppById(Long id);

    /**
     * 查询集成指挥平台查询非鲁车明细-app列表
     *
     * @param jczhFeiluCarDtlQureyApp 集成指挥平台查询非鲁车明细-app
     * @return 集成指挥平台查询非鲁车明细-app集合
     */
    public List<JczhFeiluCarDtlQureyApp> selectJczhFeiluCarDtlQureyAppList(JczhFeiluCarDtlQureyApp jczhFeiluCarDtlQureyApp);
    public List<JczhFeiluCarDtlQureyApp> selectJczhFeiluCarDtlQureyAppLists(JczhFeiluCarDtlQureyApp jczhFeiluCarDtlQureyApp);

    /**
     * 新增集成指挥平台查询非鲁车明细-app
     *
     * @param jczhFeiluCarDtlQureyApp 集成指挥平台查询非鲁车明细-app
     * @return 结果
     */
    public int insertJczhFeiluCarDtlQureyApp(JczhFeiluCarDtlQureyApp jczhFeiluCarDtlQureyApp);

    /**
     * 修改集成指挥平台查询非鲁车明细-app
     *
     * @param jczhFeiluCarDtlQureyApp 集成指挥平台查询非鲁车明细-app
     * @return 结果
     */
    public int updateJczhFeiluCarDtlQureyApp(JczhFeiluCarDtlQureyApp jczhFeiluCarDtlQureyApp);

    /**
     * 批量删除集成指挥平台查询非鲁车明细-app
     *
     * @param ids 需要删除的集成指挥平台查询非鲁车明细-app主键集合
     * @return 结果
     */
    public int deleteJczhFeiluCarDtlQureyAppByIds(String ids);

    /**
     * 删除集成指挥平台查询非鲁车明细-app信息
     *
     * @param id 集成指挥平台查询非鲁车明细-app主键
     * @return 结果
     */
    public int deleteJczhFeiluCarDtlQureyAppById(Long id);
}
