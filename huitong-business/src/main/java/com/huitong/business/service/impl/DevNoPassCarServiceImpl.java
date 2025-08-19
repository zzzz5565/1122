package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.DevNoPassCarMapper;
import com.huitong.business.domain.DevNoPassCar;
import com.huitong.business.service.IDevNoPassCarService;
import com.huitong.common.core.text.Convert;

/**
 * 无过车数据卡口信息统计Service业务层处理
 *
 * @author hairun
 * @date 2025-03-20
 */
@Service
public class DevNoPassCarServiceImpl implements IDevNoPassCarService
{
    @Autowired
    private DevNoPassCarMapper devNoPassCarMapper;

    /**
     * 查询无过车数据卡口信息统计
     *
     * @param id 无过车数据卡口信息统计主键
     * @return 无过车数据卡口信息统计
     */
    @Override
    public DevNoPassCar selectDevNoPassCarById(Long id)
    {
        return devNoPassCarMapper.selectDevNoPassCarById(id);
    }

    /**
     * 查询无过车数据卡口信息统计列表
     *
     * @param devNoPassCar 无过车数据卡口信息统计
     * @return 无过车数据卡口信息统计
     */
    @Override
    public List<DevNoPassCar> selectDevNoPassCarList(DevNoPassCar devNoPassCar)
    {
        return devNoPassCarMapper.selectDevNoPassCarList(devNoPassCar);
    }
    @Override
    public List<DevNoPassCar> selectDevNoPassCarLists(DevNoPassCar devNoPassCar)
    {
        return devNoPassCarMapper.selectDevNoPassCarLists(devNoPassCar);
    }

    /**
     * 新增无过车数据卡口信息统计
     *
     * @param devNoPassCar 无过车数据卡口信息统计
     * @return 结果
     */
    @Override
    public int insertDevNoPassCar(DevNoPassCar devNoPassCar)
    {
        return devNoPassCarMapper.insertDevNoPassCar(devNoPassCar);
    }

    /**
     * 修改无过车数据卡口信息统计
     *
     * @param devNoPassCar 无过车数据卡口信息统计
     * @return 结果
     */
    @Override
    public int updateDevNoPassCar(DevNoPassCar devNoPassCar)
    {
        return devNoPassCarMapper.updateDevNoPassCar(devNoPassCar);
    }

    /**
     * 批量删除无过车数据卡口信息统计
     *
     * @param ids 需要删除的无过车数据卡口信息统计主键
     * @return 结果
     */
    @Override
    public int deleteDevNoPassCarByIds(String ids)
    {
        return devNoPassCarMapper.deleteDevNoPassCarByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除无过车数据卡口信息统计信息
     *
     * @param id 无过车数据卡口信息统计主键
     * @return 结果
     */
    @Override
    public int deleteDevNoPassCarById(Long id)
    {
        return devNoPassCarMapper.deleteDevNoPassCarById(id);
    }
}
