package com.huitong.business.mapper;

import java.util.List;
import com.huitong.business.domain.CarQueryMonth;

/**
 * 月查询量占总查询量比例统计Mapper接口
 *
 * @author huitong
 * @date 2025-04-07
 */
public interface CarQueryMonthMapper
{
    /**
     * 查询月查询量占总查询量比例统计
     *
     * @param id 月查询量占总查询量比例统计主键
     * @return 月查询量占总查询量比例统计
     */
    public CarQueryMonth selectCarQueryMonthById(Long id);

    /**
     * 查询月查询量占总查询量比例统计列表
     *
     * @param carQueryMonth 月查询量占总查询量比例统计
     * @return 月查询量占总查询量比例统计集合
     */
    public List<CarQueryMonth> selectCarQueryMonthList(CarQueryMonth carQueryMonth);
    public List<CarQueryMonth> selectCarQueryMonthLists(CarQueryMonth carQueryMonth);

    /**
     * 新增月查询量占总查询量比例统计
     *
     * @param carQueryMonth 月查询量占总查询量比例统计
     * @return 结果
     */
    public int insertCarQueryMonth(CarQueryMonth carQueryMonth);

    /**
     * 修改月查询量占总查询量比例统计
     *
     * @param carQueryMonth 月查询量占总查询量比例统计
     * @return 结果
     */
    public int updateCarQueryMonth(CarQueryMonth carQueryMonth);

    /**
     * 删除月查询量占总查询量比例统计
     *
     * @param id 月查询量占总查询量比例统计主键
     * @return 结果
     */
    public int deleteCarQueryMonthById(Long id);

    /**
     * 批量删除月查询量占总查询量比例统计
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCarQueryMonthByIds(String[] ids);
}
