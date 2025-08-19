package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.CarQueryDailyMapper;
import com.huitong.business.domain.CarQueryDaily;
import com.huitong.business.service.ICarQueryDailyService;
import com.huitong.common.core.text.Convert;

/**
 * 日查询量高出全省日查询量倍数统计Service业务层处理
 *
 * @author huitong
 * @date 2025-04-07
 */
@Service
public class CarQueryDailyServiceImpl implements ICarQueryDailyService
{
    @Autowired
    private CarQueryDailyMapper carQueryDailyMapper;

    /**
     * 查询日查询量高出全省日查询量倍数统计
     *
     * @param id 日查询量高出全省日查询量倍数统计主键
     * @return 日查询量高出全省日查询量倍数统计
     */
    @Override
    public CarQueryDaily selectCarQueryDailyById(Long id)
    {
        return carQueryDailyMapper.selectCarQueryDailyById(id);
    }

    /**
     * 查询日查询量高出全省日查询量倍数统计列表
     *
     * @param carQueryDaily 日查询量高出全省日查询量倍数统计
     * @return 日查询量高出全省日查询量倍数统计
     */
    @Override
    public List<CarQueryDaily> selectCarQueryDailyList(CarQueryDaily carQueryDaily)
    {
        return carQueryDailyMapper.selectCarQueryDailyList(carQueryDaily);
    }
    @Override
    public List<CarQueryDaily> selectCarQueryDailyLists(CarQueryDaily carQueryDaily)
    {
        return carQueryDailyMapper.selectCarQueryDailyLists(carQueryDaily);
    }

    /**
     * 新增日查询量高出全省日查询量倍数统计
     *
     * @param carQueryDaily 日查询量高出全省日查询量倍数统计
     * @return 结果
     */
    @Override
    public int insertCarQueryDaily(CarQueryDaily carQueryDaily)
    {
        return carQueryDailyMapper.insertCarQueryDaily(carQueryDaily);
    }

    /**
     * 修改日查询量高出全省日查询量倍数统计
     *
     * @param carQueryDaily 日查询量高出全省日查询量倍数统计
     * @return 结果
     */
    @Override
    public int updateCarQueryDaily(CarQueryDaily carQueryDaily)
    {
        return carQueryDailyMapper.updateCarQueryDaily(carQueryDaily);
    }

    /**
     * 批量删除日查询量高出全省日查询量倍数统计
     *
     * @param ids 需要删除的日查询量高出全省日查询量倍数统计主键
     * @return 结果
     */
    @Override
    public int deleteCarQueryDailyByIds(String ids)
    {
        return carQueryDailyMapper.deleteCarQueryDailyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除日查询量高出全省日查询量倍数统计信息
     *
     * @param id 日查询量高出全省日查询量倍数统计主键
     * @return 结果
     */
    @Override
    public int deleteCarQueryDailyById(Long id)
    {
        return carQueryDailyMapper.deleteCarQueryDailyById(id);
    }
}
