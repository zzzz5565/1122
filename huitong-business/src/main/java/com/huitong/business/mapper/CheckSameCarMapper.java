package com.huitong.business.mapper;

import java.util.List;
import com.huitong.business.domain.CheckSameCar;

/**
 * 反复查询同一辆车Mapper接口
 *
 * @author huitong
 * @date 2025-04-09
 */
public interface CheckSameCarMapper
{
    /**
     * 查询反复查询同一辆车
     *
     * @param id 反复查询同一辆车主键
     * @return 反复查询同一辆车
     */
    public CheckSameCar selectCheckSameCarById(Long id);

    /**
     * 查询反复查询同一辆车列表
     *
     * @param checkSameCar 反复查询同一辆车
     * @return 反复查询同一辆车集合
     */
    public List<CheckSameCar> selectCheckSameCarList(CheckSameCar checkSameCar);
    public List<CheckSameCar> selectCheckSameCarLists(CheckSameCar checkSameCar);

    /**
     * 新增反复查询同一辆车
     *
     * @param checkSameCar 反复查询同一辆车
     * @return 结果
     */
    public int insertCheckSameCar(CheckSameCar checkSameCar);

    /**
     * 修改反复查询同一辆车
     *
     * @param checkSameCar 反复查询同一辆车
     * @return 结果
     */
    public int updateCheckSameCar(CheckSameCar checkSameCar);

    /**
     * 删除反复查询同一辆车
     *
     * @param id 反复查询同一辆车主键
     * @return 结果
     */
    public int deleteCheckSameCarById(Long id);

    /**
     * 批量删除反复查询同一辆车
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCheckSameCarByIds(String[] ids);
}
