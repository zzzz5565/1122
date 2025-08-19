package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.AbnormalUserQueryMapper;
import com.huitong.business.domain.AbnormalUserQuery;
import com.huitong.business.service.IAbnormalUserQueryService;
import com.huitong.common.core.text.Convert;

/**
 * 车辆查询异常用户Service业务层处理
 *
 * @author huitong
 * @date 2025-04-07
 */
@Service
public class AbnormalUserQueryServiceImpl implements IAbnormalUserQueryService
{
    @Autowired
    private AbnormalUserQueryMapper abnormalUserQueryMapper;

    /**
     * 查询车辆查询异常用户
     *
     * @param id 车辆查询异常用户主键
     * @return 车辆查询异常用户
     */
    @Override
    public AbnormalUserQuery selectAbnormalUserQueryById(Long id)
    {
        return abnormalUserQueryMapper.selectAbnormalUserQueryById(id);
    }

    /**
     * 查询车辆查询异常用户列表
     *
     * @param abnormalUserQuery 车辆查询异常用户
     * @return 车辆查询异常用户
     */
    @Override
    public List<AbnormalUserQuery> selectAbnormalUserQueryList(AbnormalUserQuery abnormalUserQuery)
    {
        return abnormalUserQueryMapper.selectAbnormalUserQueryList(abnormalUserQuery);
    }
    @Override
    public List<AbnormalUserQuery> selectAbnormalUserQueryLists(AbnormalUserQuery abnormalUserQuery)
    {
        return abnormalUserQueryMapper.selectAbnormalUserQueryLists(abnormalUserQuery);
    }

    /**
     * 新增车辆查询异常用户
     *
     * @param abnormalUserQuery 车辆查询异常用户
     * @return 结果
     */
    @Override
    public int insertAbnormalUserQuery(AbnormalUserQuery abnormalUserQuery)
    {
        return abnormalUserQueryMapper.insertAbnormalUserQuery(abnormalUserQuery);
    }

    /**
     * 修改车辆查询异常用户
     *
     * @param abnormalUserQuery 车辆查询异常用户
     * @return 结果
     */
    @Override
    public int updateAbnormalUserQuery(AbnormalUserQuery abnormalUserQuery)
    {
        return abnormalUserQueryMapper.updateAbnormalUserQuery(abnormalUserQuery);
    }

    /**
     * 批量删除车辆查询异常用户
     *
     * @param ids 需要删除的车辆查询异常用户主键
     * @return 结果
     */
    @Override
    public int deleteAbnormalUserQueryByIds(String ids)
    {
        return abnormalUserQueryMapper.deleteAbnormalUserQueryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车辆查询异常用户信息
     *
     * @param id 车辆查询异常用户主键
     * @return 结果
     */
    @Override
    public int deleteAbnormalUserQueryById(Long id)
    {
        return abnormalUserQueryMapper.deleteAbnormalUserQueryById(id);
    }
}
