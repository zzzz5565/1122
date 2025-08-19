package com.huitong.business.mapper;

import java.util.List;
import com.huitong.business.domain.JczhCheckSameCarWebDtl;

/**
 * 反复查询同一辆车-web个人查询明细Mapper接口
 *
 * @author huitong
 * @date 2025-05-15
 */
public interface JczhCheckSameCarWebDtlMapper
{
    /**
     * 查询反复查询同一辆车-web个人查询明细
     *
     * @param id 反复查询同一辆车-web个人查询明细主键
     * @return 反复查询同一辆车-web个人查询明细
     */
    public JczhCheckSameCarWebDtl selectJczhCheckSameCarWebDtlById(Long id);

    /**
     * 查询反复查询同一辆车-web个人查询明细列表
     *
     * @param jczhCheckSameCarWebDtl 反复查询同一辆车-web个人查询明细
     * @return 反复查询同一辆车-web个人查询明细集合
     */
    public List<JczhCheckSameCarWebDtl> selectJczhCheckSameCarWebDtlList(JczhCheckSameCarWebDtl jczhCheckSameCarWebDtl);
    public List<JczhCheckSameCarWebDtl> selectJczhCheckSameCarWebDtlLists(JczhCheckSameCarWebDtl jczhCheckSameCarWebDtl);

    /**
     * 新增反复查询同一辆车-web个人查询明细
     *
     * @param jczhCheckSameCarWebDtl 反复查询同一辆车-web个人查询明细
     * @return 结果
     */
    public int insertJczhCheckSameCarWebDtl(JczhCheckSameCarWebDtl jczhCheckSameCarWebDtl);

    /**
     * 修改反复查询同一辆车-web个人查询明细
     *
     * @param jczhCheckSameCarWebDtl 反复查询同一辆车-web个人查询明细
     * @return 结果
     */
    public int updateJczhCheckSameCarWebDtl(JczhCheckSameCarWebDtl jczhCheckSameCarWebDtl);

    /**
     * 删除反复查询同一辆车-web个人查询明细
     *
     * @param id 反复查询同一辆车-web个人查询明细主键
     * @return 结果
     */
    public int deleteJczhCheckSameCarWebDtlById(Long id);

    /**
     * 批量删除反复查询同一辆车-web个人查询明细
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJczhCheckSameCarWebDtlByIds(String[] ids);
}
