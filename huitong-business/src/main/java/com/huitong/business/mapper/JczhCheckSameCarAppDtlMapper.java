package com.huitong.business.mapper;

import java.util.List;
import com.huitong.business.domain.JczhCheckSameCarAppDtl;

/**
 * 反复查询同一辆车-app-个人查询明细Mapper接口
 *
 * @author huitong
 * @date 2025-05-15
 */
public interface JczhCheckSameCarAppDtlMapper
{
    /**
     * 查询反复查询同一辆车-app-个人查询明细
     *
     * @param id 反复查询同一辆车-app-个人查询明细主键
     * @return 反复查询同一辆车-app-个人查询明细
     */
    public JczhCheckSameCarAppDtl selectJczhCheckSameCarAppDtlById(Long id);

    /**
     * 查询反复查询同一辆车-app-个人查询明细列表
     *
     * @param jczhCheckSameCarAppDtl 反复查询同一辆车-app-个人查询明细
     * @return 反复查询同一辆车-app-个人查询明细集合
     */
    public List<JczhCheckSameCarAppDtl> selectJczhCheckSameCarAppDtlList(JczhCheckSameCarAppDtl jczhCheckSameCarAppDtl);
    public List<JczhCheckSameCarAppDtl> selectJczhCheckSameCarAppDtlLists(JczhCheckSameCarAppDtl jczhCheckSameCarAppDtl);

    /**
     * 新增反复查询同一辆车-app-个人查询明细
     *
     * @param jczhCheckSameCarAppDtl 反复查询同一辆车-app-个人查询明细
     * @return 结果
     */
    public int insertJczhCheckSameCarAppDtl(JczhCheckSameCarAppDtl jczhCheckSameCarAppDtl);

    /**
     * 修改反复查询同一辆车-app-个人查询明细
     *
     * @param jczhCheckSameCarAppDtl 反复查询同一辆车-app-个人查询明细
     * @return 结果
     */
    public int updateJczhCheckSameCarAppDtl(JczhCheckSameCarAppDtl jczhCheckSameCarAppDtl);

    /**
     * 删除反复查询同一辆车-app-个人查询明细
     *
     * @param id 反复查询同一辆车-app-个人查询明细主键
     * @return 结果
     */
    public int deleteJczhCheckSameCarAppDtlById(Long id);

    /**
     * 批量删除反复查询同一辆车-app-个人查询明细
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJczhCheckSameCarAppDtlByIds(String[] ids);
}
