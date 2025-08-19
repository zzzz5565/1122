package com.huitong.business.mapper;

import java.util.List;
import com.huitong.business.domain.JczhCheckSameCarWeb;

/**
 * 反复查询同一辆车-webMapper接口
 *
 * @author huitong
 * @date 2025-05-15
 */
public interface JczhCheckSameCarWebMapper
{
    /**
     * 查询反复查询同一辆车-web
     *
     * @param id 反复查询同一辆车-web主键
     * @return 反复查询同一辆车-web
     */
    public JczhCheckSameCarWeb selectJczhCheckSameCarWebById(Long id);

    /**
     * 查询反复查询同一辆车-web列表
     *
     * @param jczhCheckSameCarWeb 反复查询同一辆车-web
     * @return 反复查询同一辆车-web集合
     */
    public List<JczhCheckSameCarWeb> selectJczhCheckSameCarWebList(JczhCheckSameCarWeb jczhCheckSameCarWeb);
    public List<JczhCheckSameCarWeb> selectJczhCheckSameCarWebLists(JczhCheckSameCarWeb jczhCheckSameCarWeb);

    /**
     * 新增反复查询同一辆车-web
     *
     * @param jczhCheckSameCarWeb 反复查询同一辆车-web
     * @return 结果
     */
    public int insertJczhCheckSameCarWeb(JczhCheckSameCarWeb jczhCheckSameCarWeb);

    /**
     * 修改反复查询同一辆车-web
     *
     * @param jczhCheckSameCarWeb 反复查询同一辆车-web
     * @return 结果
     */
    public int updateJczhCheckSameCarWeb(JczhCheckSameCarWeb jczhCheckSameCarWeb);

    /**
     * 删除反复查询同一辆车-web
     *
     * @param id 反复查询同一辆车-web主键
     * @return 结果
     */
    public int deleteJczhCheckSameCarWebById(Long id);

    /**
     * 批量删除反复查询同一辆车-web
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJczhCheckSameCarWebByIds(String[] ids);
}
