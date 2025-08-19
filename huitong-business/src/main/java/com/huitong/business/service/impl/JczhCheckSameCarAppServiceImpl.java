package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.JczhCheckSameCarAppMapper;
import com.huitong.business.domain.JczhCheckSameCarApp;
import com.huitong.business.service.IJczhCheckSameCarAppService;
import com.huitong.common.core.text.Convert;

/**
 * 反复查询同一辆车-app-带姓名警号Service业务层处理
 *
 * @author huitong
 * @date 2025-05-15
 */
@Service
public class JczhCheckSameCarAppServiceImpl implements IJczhCheckSameCarAppService
{
    @Autowired
    private JczhCheckSameCarAppMapper jczhCheckSameCarAppMapper;

    /**
     * 查询反复查询同一辆车-app-带姓名警号
     *
     * @param id 反复查询同一辆车-app-带姓名警号主键
     * @return 反复查询同一辆车-app-带姓名警号
     */
    @Override
    public JczhCheckSameCarApp selectJczhCheckSameCarAppById(Long id)
    {
        return jczhCheckSameCarAppMapper.selectJczhCheckSameCarAppById(id);
    }

    /**
     * 查询反复查询同一辆车-app-带姓名警号列表
     *
     * @param jczhCheckSameCarApp 反复查询同一辆车-app-带姓名警号
     * @return 反复查询同一辆车-app-带姓名警号
     */
    @Override
    public List<JczhCheckSameCarApp> selectJczhCheckSameCarAppList(JczhCheckSameCarApp jczhCheckSameCarApp)
    {
        return jczhCheckSameCarAppMapper.selectJczhCheckSameCarAppList(jczhCheckSameCarApp);
    }

    @Override
    public List<JczhCheckSameCarApp> selectJczhCheckSameCarAppLists(JczhCheckSameCarApp jczhCheckSameCarApp)
    {
        return jczhCheckSameCarAppMapper.selectJczhCheckSameCarAppLists(jczhCheckSameCarApp);
    }

    /**
     * 新增反复查询同一辆车-app-带姓名警号
     *
     * @param jczhCheckSameCarApp 反复查询同一辆车-app-带姓名警号
     * @return 结果
     */
    @Override
    public int insertJczhCheckSameCarApp(JczhCheckSameCarApp jczhCheckSameCarApp)
    {
        return jczhCheckSameCarAppMapper.insertJczhCheckSameCarApp(jczhCheckSameCarApp);
    }

    /**
     * 修改反复查询同一辆车-app-带姓名警号
     *
     * @param jczhCheckSameCarApp 反复查询同一辆车-app-带姓名警号
     * @return 结果
     */
    @Override
    public int updateJczhCheckSameCarApp(JczhCheckSameCarApp jczhCheckSameCarApp)
    {
        return jczhCheckSameCarAppMapper.updateJczhCheckSameCarApp(jczhCheckSameCarApp);
    }

    /**
     * 批量删除反复查询同一辆车-app-带姓名警号
     *
     * @param ids 需要删除的反复查询同一辆车-app-带姓名警号主键
     * @return 结果
     */
    @Override
    public int deleteJczhCheckSameCarAppByIds(String ids)
    {
        return jczhCheckSameCarAppMapper.deleteJczhCheckSameCarAppByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除反复查询同一辆车-app-带姓名警号信息
     *
     * @param id 反复查询同一辆车-app-带姓名警号主键
     * @return 结果
     */
    @Override
    public int deleteJczhCheckSameCarAppById(Long id)
    {
        return jczhCheckSameCarAppMapper.deleteJczhCheckSameCarAppById(id);
    }
}
