package com.huitong.business.service.impl;

import java.util.List;
import com.huitong.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.FeiluCarQureyMapper;
import com.huitong.business.domain.FeiluCarQurey;
import com.huitong.business.service.IFeiluCarQureyService;
import com.huitong.common.core.text.Convert;

/**
 * 查询非鲁车Service业务层处理
 *
 * @author huitong
 * @date 2025-04-09
 */
@Service
public class FeiluCarQureyServiceImpl implements IFeiluCarQureyService
{
    @Autowired
    private FeiluCarQureyMapper feiluCarQureyMapper;

    /**
     * 查询查询非鲁车
     *
     * @param id 查询非鲁车主键
     * @return 查询非鲁车
     */
    @Override
    public FeiluCarQurey selectFeiluCarQureyById(Long id)
    {
        return feiluCarQureyMapper.selectFeiluCarQureyById(id);
    }

    /**
     * 查询查询非鲁车列表
     *
     * @param feiluCarQurey 查询非鲁车
     * @return 查询非鲁车
     */
    @Override
    public List<FeiluCarQurey> selectFeiluCarQureyList(FeiluCarQurey feiluCarQurey)
    {
        return feiluCarQureyMapper.selectFeiluCarQureyList(feiluCarQurey);
    }
    @Override
    public List<FeiluCarQurey> selectFeiluCarQureyLists(FeiluCarQurey feiluCarQurey)
    {
        return feiluCarQureyMapper.selectFeiluCarQureyLists(feiluCarQurey);
    }

    /**
     * 新增查询非鲁车
     *
     * @param feiluCarQurey 查询非鲁车
     * @return 结果
     */
    @Override
    public int insertFeiluCarQurey(FeiluCarQurey feiluCarQurey)
    {
        feiluCarQurey.setCreateTime(DateUtils.getNowDate());
        return feiluCarQureyMapper.insertFeiluCarQurey(feiluCarQurey);
    }

    /**
     * 修改查询非鲁车
     *
     * @param feiluCarQurey 查询非鲁车
     * @return 结果
     */
    @Override
    public int updateFeiluCarQurey(FeiluCarQurey feiluCarQurey)
    {
        return feiluCarQureyMapper.updateFeiluCarQurey(feiluCarQurey);
    }

    /**
     * 批量删除查询非鲁车
     *
     * @param ids 需要删除的查询非鲁车主键
     * @return 结果
     */
    @Override
    public int deleteFeiluCarQureyByIds(String ids)
    {
        return feiluCarQureyMapper.deleteFeiluCarQureyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除查询非鲁车信息
     *
     * @param id 查询非鲁车主键
     * @return 结果
     */
    @Override
    public int deleteFeiluCarQureyById(Long id)
    {
        return feiluCarQureyMapper.deleteFeiluCarQureyById(id);
    }
}
