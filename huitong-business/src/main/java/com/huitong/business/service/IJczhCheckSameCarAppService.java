package com.huitong.business.service;

import java.util.List;
import com.huitong.business.domain.JczhCheckSameCarApp;

/**
 * 反复查询同一辆车-app-带姓名警号Service接口
 *
 * @author huitong
 * @date 2025-05-15
 */
public interface IJczhCheckSameCarAppService
{
    /**
     * 查询反复查询同一辆车-app-带姓名警号
     *
     * @param id 反复查询同一辆车-app-带姓名警号主键
     * @return 反复查询同一辆车-app-带姓名警号
     */
    public JczhCheckSameCarApp selectJczhCheckSameCarAppById(Long id);

    /**
     * 查询反复查询同一辆车-app-带姓名警号列表
     *
     * @param jczhCheckSameCarApp 反复查询同一辆车-app-带姓名警号
     * @return 反复查询同一辆车-app-带姓名警号集合
     */
    public List<JczhCheckSameCarApp> selectJczhCheckSameCarAppList(JczhCheckSameCarApp jczhCheckSameCarApp);
    public List<JczhCheckSameCarApp> selectJczhCheckSameCarAppLists(JczhCheckSameCarApp jczhCheckSameCarApp);

    /**
     * 新增反复查询同一辆车-app-带姓名警号
     *
     * @param jczhCheckSameCarApp 反复查询同一辆车-app-带姓名警号
     * @return 结果
     */
    public int insertJczhCheckSameCarApp(JczhCheckSameCarApp jczhCheckSameCarApp);

    /**
     * 修改反复查询同一辆车-app-带姓名警号
     *
     * @param jczhCheckSameCarApp 反复查询同一辆车-app-带姓名警号
     * @return 结果
     */
    public int updateJczhCheckSameCarApp(JczhCheckSameCarApp jczhCheckSameCarApp);

    /**
     * 批量删除反复查询同一辆车-app-带姓名警号
     *
     * @param ids 需要删除的反复查询同一辆车-app-带姓名警号主键集合
     * @return 结果
     */
    public int deleteJczhCheckSameCarAppByIds(String ids);

    /**
     * 删除反复查询同一辆车-app-带姓名警号信息
     *
     * @param id 反复查询同一辆车-app-带姓名警号主键
     * @return 结果
     */
    public int deleteJczhCheckSameCarAppById(Long id);
}
