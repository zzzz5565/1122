package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.CheckSameCarMapper;
import com.huitong.business.domain.CheckSameCar;
import com.huitong.business.service.ICheckSameCarService;
import com.huitong.common.core.text.Convert;

/**
 * 反复查询同一辆车Service业务层处理
 *
 * @author huitong
 * @date 2025-04-09
 */
@Service
public class CheckSameCarServiceImpl implements ICheckSameCarService
{
    @Autowired
    private CheckSameCarMapper checkSameCarMapper;

    /**
     * 查询反复查询同一辆车
     *
     * @param id 反复查询同一辆车主键
     * @return 反复查询同一辆车
     */
    @Override
    public CheckSameCar selectCheckSameCarById(Long id)
    {
        return checkSameCarMapper.selectCheckSameCarById(id);
    }

    /**
     * 查询反复查询同一辆车列表
     *
     * @param checkSameCar 反复查询同一辆车
     * @return 反复查询同一辆车
     */
    @Override
    public List<CheckSameCar> selectCheckSameCarList(CheckSameCar checkSameCar)
    {
        return checkSameCarMapper.selectCheckSameCarList(checkSameCar);
    }
    @Override
    public List<CheckSameCar> selectCheckSameCarLists(CheckSameCar checkSameCar)
    {
        return checkSameCarMapper.selectCheckSameCarLists(checkSameCar);
    }

    /**
     * 新增反复查询同一辆车
     *
     * @param checkSameCar 反复查询同一辆车
     * @return 结果
     */
    @Override
    public int insertCheckSameCar(CheckSameCar checkSameCar)
    {
        return checkSameCarMapper.insertCheckSameCar(checkSameCar);
    }

    /**
     * 修改反复查询同一辆车
     *
     * @param checkSameCar 反复查询同一辆车
     * @return 结果
     */
    @Override
    public int updateCheckSameCar(CheckSameCar checkSameCar)
    {
        return checkSameCarMapper.updateCheckSameCar(checkSameCar);
    }

    /**
     * 批量删除反复查询同一辆车
     *
     * @param ids 需要删除的反复查询同一辆车主键
     * @return 结果
     */
    @Override
    public int deleteCheckSameCarByIds(String ids)
    {
        return checkSameCarMapper.deleteCheckSameCarByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除反复查询同一辆车信息
     *
     * @param id 反复查询同一辆车主键
     * @return 结果
     */
    @Override
    public int deleteCheckSameCarById(Long id)
    {
        return checkSameCarMapper.deleteCheckSameCarById(id);
    }
}
