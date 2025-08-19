package com.huitong.business.service.impl;

import java.util.List;
import com.huitong.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.PassCarQureyMapper;
import com.huitong.business.domain.PassCarQurey;
import com.huitong.business.service.IPassCarQureyService;
import com.huitong.common.core.text.Convert;

/**
 * 云平台过车查询Service业务层处理
 *
 * @author huitong
 * @date 2025-04-09
 */
@Service
public class PassCarQureyServiceImpl implements IPassCarQureyService
{
    @Autowired
    private PassCarQureyMapper passCarQureyMapper;

    /**
     * 查询云平台过车查询
     *
     * @param id 云平台过车查询主键
     * @return 云平台过车查询
     */
    @Override
    public PassCarQurey selectPassCarQureyById(Long id)
    {
        return passCarQureyMapper.selectPassCarQureyById(id);
    }

    /**
     * 查询云平台过车查询列表
     *
     * @param passCarQurey 云平台过车查询
     * @return 云平台过车查询
     */
    @Override
    public List<PassCarQurey> selectPassCarQureyList(PassCarQurey passCarQurey)
    {
        return passCarQureyMapper.selectPassCarQureyList(passCarQurey);
    }
    @Override
    public List<PassCarQurey> selectPassCarQureyLists(PassCarQurey passCarQurey)
    {
        return passCarQureyMapper.selectPassCarQureyLists(passCarQurey);
    }
    @Override
    public List<PassCarQurey> selectPassCarQureyLists2(PassCarQurey passCarQurey)
    {
        return passCarQureyMapper.selectPassCarQureyLists2(passCarQurey);
    }

    /**
     * 新增云平台过车查询
     *
     * @param passCarQurey 云平台过车查询
     * @return 结果
     */
    @Override
    public int insertPassCarQurey(PassCarQurey passCarQurey)
    {
        passCarQurey.setCreateTime(DateUtils.getNowDate());
        return passCarQureyMapper.insertPassCarQurey(passCarQurey);
    }

    /**
     * 修改云平台过车查询
     *
     * @param passCarQurey 云平台过车查询
     * @return 结果
     */
    @Override
    public int updatePassCarQurey(PassCarQurey passCarQurey)
    {
        return passCarQureyMapper.updatePassCarQurey(passCarQurey);
    }

    /**
     * 批量删除云平台过车查询
     *
     * @param ids 需要删除的云平台过车查询主键
     * @return 结果
     */
    @Override
    public int deletePassCarQureyByIds(String ids)
    {
        return passCarQureyMapper.deletePassCarQureyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除云平台过车查询信息
     *
     * @param id 云平台过车查询主键
     * @return 结果
     */
    @Override
    public int deletePassCarQureyById(Long id)
    {
        return passCarQureyMapper.deletePassCarQureyById(id);
    }
}
