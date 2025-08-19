package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.DevNameNonStandardMapper;
import com.huitong.business.domain.DevNameNonStandard;
import com.huitong.business.service.IDevNameNonStandardService;
import com.huitong.common.core.text.Convert;

/**
 * 卡口命名不规范统计Service业务层处理
 *
 * @author huitong
 * @date 2025-03-31
 */
@Service
public class DevNameNonStandardServiceImpl implements IDevNameNonStandardService
{
    @Autowired
    private DevNameNonStandardMapper devNameNonStandardMapper;

    /**
     * 查询卡口命名不规范统计
     *
     * @param id 卡口命名不规范统计主键
     * @return 卡口命名不规范统计
     */
    @Override
    public DevNameNonStandard selectDevNameNonStandardById(Long id)
    {
        return devNameNonStandardMapper.selectDevNameNonStandardById(id);
    }

    /**
     * 查询卡口命名不规范统计列表
     *
     * @param devNameNonStandard 卡口命名不规范统计
     * @return 卡口命名不规范统计
     */
    @Override
    public List<DevNameNonStandard> selectDevNameNonStandardList(DevNameNonStandard devNameNonStandard)
    {
        return devNameNonStandardMapper.selectDevNameNonStandardList(devNameNonStandard);
    }
    @Override
    public List<DevNameNonStandard> selectDevNameNonStandardLists(DevNameNonStandard devNameNonStandard)
    {
        return devNameNonStandardMapper.selectDevNameNonStandardLists(devNameNonStandard);
    }

    /**
     * 新增卡口命名不规范统计
     *
     * @param devNameNonStandard 卡口命名不规范统计
     * @return 结果
     */
    @Override
    public int insertDevNameNonStandard(DevNameNonStandard devNameNonStandard)
    {
        return devNameNonStandardMapper.insertDevNameNonStandard(devNameNonStandard);
    }

    /**
     * 修改卡口命名不规范统计
     *
     * @param devNameNonStandard 卡口命名不规范统计
     * @return 结果
     */
    @Override
    public int updateDevNameNonStandard(DevNameNonStandard devNameNonStandard)
    {
        return devNameNonStandardMapper.updateDevNameNonStandard(devNameNonStandard);
    }

    /**
     * 批量删除卡口命名不规范统计
     *
     * @param ids 需要删除的卡口命名不规范统计主键
     * @return 结果
     */
    @Override
    public int deleteDevNameNonStandardByIds(String ids)
    {
        return devNameNonStandardMapper.deleteDevNameNonStandardByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除卡口命名不规范统计信息
     *
     * @param id 卡口命名不规范统计主键
     * @return 结果
     */
    @Override
    public int deleteDevNameNonStandardById(Long id)
    {
        return devNameNonStandardMapper.deleteDevNameNonStandardById(id);
    }
}
