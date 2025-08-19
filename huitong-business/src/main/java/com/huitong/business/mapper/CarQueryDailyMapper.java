package com.huitong.business.mapper;

import java.util.List;
import com.huitong.business.domain.CarQueryDaily;

/**
 * 日查询量高出全省日查询量倍数统计Mapper接口
 *
 * @author huitong
 * @date 2025-04-07
 */
public interface CarQueryDailyMapper
{
    /**
     * 查询日查询量高出全省日查询量倍数统计
     *
     * @param id 日查询量高出全省日查询量倍数统计主键
     * @return 日查询量高出全省日查询量倍数统计
     */
    public CarQueryDaily selectCarQueryDailyById(Long id);

    /**
     * 查询日查询量高出全省日查询量倍数统计列表
     *
     * @param carQueryDaily 日查询量高出全省日查询量倍数统计
     * @return 日查询量高出全省日查询量倍数统计集合
     */
    public List<CarQueryDaily> selectCarQueryDailyList(CarQueryDaily carQueryDaily);
    public List<CarQueryDaily> selectCarQueryDailyLists(CarQueryDaily carQueryDaily);

    /**
     * 新增日查询量高出全省日查询量倍数统计
     *
     * @param carQueryDaily 日查询量高出全省日查询量倍数统计
     * @return 结果
     */
    public int insertCarQueryDaily(CarQueryDaily carQueryDaily);

    /**
     * 修改日查询量高出全省日查询量倍数统计
     *
     * @param carQueryDaily 日查询量高出全省日查询量倍数统计
     * @return 结果
     */
    public int updateCarQueryDaily(CarQueryDaily carQueryDaily);

    /**
     * 删除日查询量高出全省日查询量倍数统计
     *
     * @param id 日查询量高出全省日查询量倍数统计主键
     * @return 结果
     */
    public int deleteCarQueryDailyById(Long id);

    /**
     * 批量删除日查询量高出全省日查询量倍数统计
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCarQueryDailyByIds(String[] ids);
}
