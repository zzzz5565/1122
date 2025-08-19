package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.CarQueryMonthMapper;
import com.huitong.business.domain.CarQueryMonth;
import com.huitong.business.service.ICarQueryMonthService;
import com.huitong.common.core.text.Convert;

/**
 * 月查询量占总查询量比例统计Service业务层处理
 *
 * @author huitong
 * @date 2025-04-07
 */
@Service
public class CarQueryMonthServiceImpl implements ICarQueryMonthService
{
    @Autowired
    private CarQueryMonthMapper carQueryMonthMapper;

    /**
     * 查询月查询量占总查询量比例统计
     *
     * @param id 月查询量占总查询量比例统计主键
     * @return 月查询量占总查询量比例统计
     */
    @Override
    public CarQueryMonth selectCarQueryMonthById(Long id)
    {
        return carQueryMonthMapper.selectCarQueryMonthById(id);
    }

    /**
     * 查询月查询量占总查询量比例统计列表
     *
     * @param carQueryMonth 月查询量占总查询量比例统计
     * @return 月查询量占总查询量比例统计
     */
    @Override
    public List<CarQueryMonth> selectCarQueryMonthList(CarQueryMonth carQueryMonth)
    {
        return carQueryMonthMapper.selectCarQueryMonthList(carQueryMonth);
    }

    @Override
    public List<CarQueryMonth> selectCarQueryMonthLists(CarQueryMonth carQueryMonth)
    {
        return carQueryMonthMapper.selectCarQueryMonthLists(carQueryMonth);
    }

    /**
     * 新增月查询量占总查询量比例统计
     *
     * @param carQueryMonth 月查询量占总查询量比例统计
     * @return 结果
     */
    @Override
    public int insertCarQueryMonth(CarQueryMonth carQueryMonth)
    {
        return carQueryMonthMapper.insertCarQueryMonth(carQueryMonth);
    }

    /**
     * 修改月查询量占总查询量比例统计
     *
     * @param carQueryMonth 月查询量占总查询量比例统计
     * @return 结果
     */
    @Override
    public int updateCarQueryMonth(CarQueryMonth carQueryMonth)
    {
        return carQueryMonthMapper.updateCarQueryMonth(carQueryMonth);
    }

    /**
     * 批量删除月查询量占总查询量比例统计
     *
     * @param ids 需要删除的月查询量占总查询量比例统计主键
     * @return 结果
     */
    @Override
    public int deleteCarQueryMonthByIds(String ids)
    {
        return carQueryMonthMapper.deleteCarQueryMonthByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除月查询量占总查询量比例统计信息
     *
     * @param id 月查询量占总查询量比例统计主键
     * @return 结果
     */
    @Override
    public int deleteCarQueryMonthById(Long id)
    {
        return carQueryMonthMapper.deleteCarQueryMonthById(id);
    }
}
