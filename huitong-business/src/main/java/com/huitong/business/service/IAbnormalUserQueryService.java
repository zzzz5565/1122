package com.huitong.business.service;

import java.util.List;
import com.huitong.business.domain.AbnormalUserQuery;

/**
 * 车辆查询异常用户Service接口
 *
 * @author huitong
 * @date 2025-04-07
 */
public interface IAbnormalUserQueryService
{
    /**
     * 查询车辆查询异常用户
     *
     * @param id 车辆查询异常用户主键
     * @return 车辆查询异常用户
     */
    public AbnormalUserQuery selectAbnormalUserQueryById(Long id);

    /**
     * 查询车辆查询异常用户列表
     *
     * @param abnormalUserQuery 车辆查询异常用户
     * @return 车辆查询异常用户集合
     */
    public List<AbnormalUserQuery> selectAbnormalUserQueryList(AbnormalUserQuery abnormalUserQuery);
    public List<AbnormalUserQuery> selectAbnormalUserQueryLists(AbnormalUserQuery abnormalUserQuery);

    /**
     * 新增车辆查询异常用户
     *
     * @param abnormalUserQuery 车辆查询异常用户
     * @return 结果
     */
    public int insertAbnormalUserQuery(AbnormalUserQuery abnormalUserQuery);

    /**
     * 修改车辆查询异常用户
     *
     * @param abnormalUserQuery 车辆查询异常用户
     * @return 结果
     */
    public int updateAbnormalUserQuery(AbnormalUserQuery abnormalUserQuery);

    /**
     * 批量删除车辆查询异常用户
     *
     * @param ids 需要删除的车辆查询异常用户主键集合
     * @return 结果
     */
    public int deleteAbnormalUserQueryByIds(String ids);

    /**
     * 删除车辆查询异常用户信息
     *
     * @param id 车辆查询异常用户主键
     * @return 结果
     */
    public int deleteAbnormalUserQueryById(Long id);
}
