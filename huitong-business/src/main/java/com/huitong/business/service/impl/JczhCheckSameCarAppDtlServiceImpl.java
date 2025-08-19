package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.JczhCheckSameCarAppDtlMapper;
import com.huitong.business.domain.JczhCheckSameCarAppDtl;
import com.huitong.business.service.IJczhCheckSameCarAppDtlService;
import com.huitong.common.core.text.Convert;

/**
 * 反复查询同一辆车-app-个人查询明细Service业务层处理
 *
 * @author huitong
 * @date 2025-05-15
 */
@Service
public class JczhCheckSameCarAppDtlServiceImpl implements IJczhCheckSameCarAppDtlService
{
    @Autowired
    private JczhCheckSameCarAppDtlMapper jczhCheckSameCarAppDtlMapper;

    /**
     * 查询反复查询同一辆车-app-个人查询明细
     *
     * @param id 反复查询同一辆车-app-个人查询明细主键
     * @return 反复查询同一辆车-app-个人查询明细
     */
    @Override
    public JczhCheckSameCarAppDtl selectJczhCheckSameCarAppDtlById(Long id)
    {
        return jczhCheckSameCarAppDtlMapper.selectJczhCheckSameCarAppDtlById(id);
    }

    /**
     * 查询反复查询同一辆车-app-个人查询明细列表
     *
     * @param jczhCheckSameCarAppDtl 反复查询同一辆车-app-个人查询明细
     * @return 反复查询同一辆车-app-个人查询明细
     */
    @Override
    public List<JczhCheckSameCarAppDtl> selectJczhCheckSameCarAppDtlList(JczhCheckSameCarAppDtl jczhCheckSameCarAppDtl)
    {
        return jczhCheckSameCarAppDtlMapper.selectJczhCheckSameCarAppDtlList(jczhCheckSameCarAppDtl);
    }

    @Override
    public List<JczhCheckSameCarAppDtl> selectJczhCheckSameCarAppDtlLists(JczhCheckSameCarAppDtl jczhCheckSameCarAppDtl)
    {
        return jczhCheckSameCarAppDtlMapper.selectJczhCheckSameCarAppDtlLists(jczhCheckSameCarAppDtl);
    }

    /**
     * 新增反复查询同一辆车-app-个人查询明细
     *
     * @param jczhCheckSameCarAppDtl 反复查询同一辆车-app-个人查询明细
     * @return 结果
     */
    @Override
    public int insertJczhCheckSameCarAppDtl(JczhCheckSameCarAppDtl jczhCheckSameCarAppDtl)
    {
        return jczhCheckSameCarAppDtlMapper.insertJczhCheckSameCarAppDtl(jczhCheckSameCarAppDtl);
    }

    /**
     * 修改反复查询同一辆车-app-个人查询明细
     *
     * @param jczhCheckSameCarAppDtl 反复查询同一辆车-app-个人查询明细
     * @return 结果
     */
    @Override
    public int updateJczhCheckSameCarAppDtl(JczhCheckSameCarAppDtl jczhCheckSameCarAppDtl)
    {
        return jczhCheckSameCarAppDtlMapper.updateJczhCheckSameCarAppDtl(jczhCheckSameCarAppDtl);
    }

    /**
     * 批量删除反复查询同一辆车-app-个人查询明细
     *
     * @param ids 需要删除的反复查询同一辆车-app-个人查询明细主键
     * @return 结果
     */
    @Override
    public int deleteJczhCheckSameCarAppDtlByIds(String ids)
    {
        return jczhCheckSameCarAppDtlMapper.deleteJczhCheckSameCarAppDtlByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除反复查询同一辆车-app-个人查询明细信息
     *
     * @param id 反复查询同一辆车-app-个人查询明细主键
     * @return 结果
     */
    @Override
    public int deleteJczhCheckSameCarAppDtlById(Long id)
    {
        return jczhCheckSameCarAppDtlMapper.deleteJczhCheckSameCarAppDtlById(id);
    }
}
