package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.JczhCheckSameCarWebDtlMapper;
import com.huitong.business.domain.JczhCheckSameCarWebDtl;
import com.huitong.business.service.IJczhCheckSameCarWebDtlService;
import com.huitong.common.core.text.Convert;

/**
 * 反复查询同一辆车-web个人查询明细Service业务层处理
 *
 * @author huitong
 * @date 2025-05-15
 */
@Service
public class JczhCheckSameCarWebDtlServiceImpl implements IJczhCheckSameCarWebDtlService
{
    @Autowired
    private JczhCheckSameCarWebDtlMapper jczhCheckSameCarWebDtlMapper;

    /**
     * 查询反复查询同一辆车-web个人查询明细
     *
     * @param id 反复查询同一辆车-web个人查询明细主键
     * @return 反复查询同一辆车-web个人查询明细
     */
    @Override
    public JczhCheckSameCarWebDtl selectJczhCheckSameCarWebDtlById(Long id)
    {
        return jczhCheckSameCarWebDtlMapper.selectJczhCheckSameCarWebDtlById(id);
    }

    /**
     * 查询反复查询同一辆车-web个人查询明细列表
     *
     * @param jczhCheckSameCarWebDtl 反复查询同一辆车-web个人查询明细
     * @return 反复查询同一辆车-web个人查询明细
     */
    @Override
    public List<JczhCheckSameCarWebDtl> selectJczhCheckSameCarWebDtlList(JczhCheckSameCarWebDtl jczhCheckSameCarWebDtl)
    {
        return jczhCheckSameCarWebDtlMapper.selectJczhCheckSameCarWebDtlList(jczhCheckSameCarWebDtl);
    }
    @Override
    public List<JczhCheckSameCarWebDtl> selectJczhCheckSameCarWebDtlLists(JczhCheckSameCarWebDtl jczhCheckSameCarWebDtl)
    {
        return jczhCheckSameCarWebDtlMapper.selectJczhCheckSameCarWebDtlLists(jczhCheckSameCarWebDtl);
    }

    /**
     * 新增反复查询同一辆车-web个人查询明细
     *
     * @param jczhCheckSameCarWebDtl 反复查询同一辆车-web个人查询明细
     * @return 结果
     */
    @Override
    public int insertJczhCheckSameCarWebDtl(JczhCheckSameCarWebDtl jczhCheckSameCarWebDtl)
    {
        return jczhCheckSameCarWebDtlMapper.insertJczhCheckSameCarWebDtl(jczhCheckSameCarWebDtl);
    }

    /**
     * 修改反复查询同一辆车-web个人查询明细
     *
     * @param jczhCheckSameCarWebDtl 反复查询同一辆车-web个人查询明细
     * @return 结果
     */
    @Override
    public int updateJczhCheckSameCarWebDtl(JczhCheckSameCarWebDtl jczhCheckSameCarWebDtl)
    {
        return jczhCheckSameCarWebDtlMapper.updateJczhCheckSameCarWebDtl(jczhCheckSameCarWebDtl);
    }

    /**
     * 批量删除反复查询同一辆车-web个人查询明细
     *
     * @param ids 需要删除的反复查询同一辆车-web个人查询明细主键
     * @return 结果
     */
    @Override
    public int deleteJczhCheckSameCarWebDtlByIds(String ids)
    {
        return jczhCheckSameCarWebDtlMapper.deleteJczhCheckSameCarWebDtlByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除反复查询同一辆车-web个人查询明细信息
     *
     * @param id 反复查询同一辆车-web个人查询明细主键
     * @return 结果
     */
    @Override
    public int deleteJczhCheckSameCarWebDtlById(Long id)
    {
        return jczhCheckSameCarWebDtlMapper.deleteJczhCheckSameCarWebDtlById(id);
    }
}
