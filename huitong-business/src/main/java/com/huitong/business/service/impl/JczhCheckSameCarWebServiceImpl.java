package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.JczhCheckSameCarWebMapper;
import com.huitong.business.domain.JczhCheckSameCarWeb;
import com.huitong.business.service.IJczhCheckSameCarWebService;
import com.huitong.common.core.text.Convert;

/**
 * 反复查询同一辆车-webService业务层处理
 *
 * @author huitong
 * @date 2025-05-15
 */
@Service
public class JczhCheckSameCarWebServiceImpl implements IJczhCheckSameCarWebService
{
    @Autowired
    private JczhCheckSameCarWebMapper jczhCheckSameCarWebMapper;

    /**
     * 查询反复查询同一辆车-web
     *
     * @param id 反复查询同一辆车-web主键
     * @return 反复查询同一辆车-web
     */
    @Override
    public JczhCheckSameCarWeb selectJczhCheckSameCarWebById(Long id)
    {
        return jczhCheckSameCarWebMapper.selectJczhCheckSameCarWebById(id);
    }

    /**
     * 查询反复查询同一辆车-web列表
     *
     * @param jczhCheckSameCarWeb 反复查询同一辆车-web
     * @return 反复查询同一辆车-web
     */
    @Override
    public List<JczhCheckSameCarWeb> selectJczhCheckSameCarWebList(JczhCheckSameCarWeb jczhCheckSameCarWeb)
    {
        return jczhCheckSameCarWebMapper.selectJczhCheckSameCarWebList(jczhCheckSameCarWeb);
    }
    @Override
    public List<JczhCheckSameCarWeb> selectJczhCheckSameCarWebLists(JczhCheckSameCarWeb jczhCheckSameCarWeb)
    {
        return jczhCheckSameCarWebMapper.selectJczhCheckSameCarWebLists(jczhCheckSameCarWeb);
    }

    /**
     * 新增反复查询同一辆车-web
     *
     * @param jczhCheckSameCarWeb 反复查询同一辆车-web
     * @return 结果
     */
    @Override
    public int insertJczhCheckSameCarWeb(JczhCheckSameCarWeb jczhCheckSameCarWeb)
    {
        return jczhCheckSameCarWebMapper.insertJczhCheckSameCarWeb(jczhCheckSameCarWeb);
    }

    /**
     * 修改反复查询同一辆车-web
     *
     * @param jczhCheckSameCarWeb 反复查询同一辆车-web
     * @return 结果
     */
    @Override
    public int updateJczhCheckSameCarWeb(JczhCheckSameCarWeb jczhCheckSameCarWeb)
    {
        return jczhCheckSameCarWebMapper.updateJczhCheckSameCarWeb(jczhCheckSameCarWeb);
    }

    /**
     * 批量删除反复查询同一辆车-web
     *
     * @param ids 需要删除的反复查询同一辆车-web主键
     * @return 结果
     */
    @Override
    public int deleteJczhCheckSameCarWebByIds(String ids)
    {
        return jczhCheckSameCarWebMapper.deleteJczhCheckSameCarWebByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除反复查询同一辆车-web信息
     *
     * @param id 反复查询同一辆车-web主键
     * @return 结果
     */
    @Override
    public int deleteJczhCheckSameCarWebById(Long id)
    {
        return jczhCheckSameCarWebMapper.deleteJczhCheckSameCarWebById(id);
    }
}
