package com.huitong.business.mapper;

import java.util.List;
import com.huitong.business.domain.DevNoPassCar;

/**
 * 无过车数据卡口信息统计Mapper接口
 *
 * @author hairun
 * @date 2025-03-20
 */
public interface DevNoPassCarMapper
{
    /**
     * 查询无过车数据卡口信息统计
     *
     * @param id 无过车数据卡口信息统计主键
     * @return 无过车数据卡口信息统计
     */
    public DevNoPassCar selectDevNoPassCarById(Long id);

    /**
     * 查询无过车数据卡口信息统计列表
     *
     * @param devNoPassCar 无过车数据卡口信息统计
     * @return 无过车数据卡口信息统计集合
     */
    public List<DevNoPassCar> selectDevNoPassCarList(DevNoPassCar devNoPassCar);
    public List<DevNoPassCar> selectDevNoPassCarLists(DevNoPassCar devNoPassCar);

    /**
     * 新增无过车数据卡口信息统计
     *
     * @param devNoPassCar 无过车数据卡口信息统计
     * @return 结果
     */
    public int insertDevNoPassCar(DevNoPassCar devNoPassCar);

    /**
     * 修改无过车数据卡口信息统计
     *
     * @param devNoPassCar 无过车数据卡口信息统计
     * @return 结果
     */
    public int updateDevNoPassCar(DevNoPassCar devNoPassCar);

    /**
     * 删除无过车数据卡口信息统计
     *
     * @param id 无过车数据卡口信息统计主键
     * @return 结果
     */
    public int deleteDevNoPassCarById(Long id);

    /**
     * 批量删除无过车数据卡口信息统计
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDevNoPassCarByIds(String[] ids);
}
