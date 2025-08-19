package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.DevJwdNonStandardMapper;
import com.huitong.business.domain.DevJwdNonStandard;
import com.huitong.business.service.IDevJwdNonStandardService;
import com.huitong.common.core.text.Convert;

/**
 * 卡口经纬度不规范统计Service业务层处理
 *
 * @author huitong
 * @date 2025-04-01
 */
@Service
public class DevJwdNonStandardServiceImpl implements IDevJwdNonStandardService
{
    @Autowired
    private DevJwdNonStandardMapper devJwdNonStandardMapper;

    /**
     * 查询卡口经纬度不规范统计
     *
     * @param id 卡口经纬度不规范统计主键
     * @return 卡口经纬度不规范统计
     */
    @Override
    public DevJwdNonStandard selectDevJwdNonStandardById(Long id)
    {
        return devJwdNonStandardMapper.selectDevJwdNonStandardById(id);
    }

    /**
     * 查询卡口经纬度不规范统计列表
     *
     * @param devJwdNonStandard 卡口经纬度不规范统计
     * @return 卡口经纬度不规范统计
     */
    @Override
    public List<DevJwdNonStandard> selectDevJwdNonStandardList(DevJwdNonStandard devJwdNonStandard)
    {
        return devJwdNonStandardMapper.selectDevJwdNonStandardList(devJwdNonStandard);
    }
    @Override
    public List<DevJwdNonStandard> selectDevJwdNonStandardLists(DevJwdNonStandard devJwdNonStandard)
    {
        return devJwdNonStandardMapper.selectDevJwdNonStandardLists(devJwdNonStandard);
    }

    /**
     * 新增卡口经纬度不规范统计
     *
     * @param devJwdNonStandard 卡口经纬度不规范统计
     * @return 结果
     */
    @Override
    public int insertDevJwdNonStandard(DevJwdNonStandard devJwdNonStandard)
    {
        return devJwdNonStandardMapper.insertDevJwdNonStandard(devJwdNonStandard);
    }

    /**
     * 修改卡口经纬度不规范统计
     *
     * @param devJwdNonStandard 卡口经纬度不规范统计
     * @return 结果
     */
    @Override
    public int updateDevJwdNonStandard(DevJwdNonStandard devJwdNonStandard)
    {
        return devJwdNonStandardMapper.updateDevJwdNonStandard(devJwdNonStandard);
    }

    /**
     * 批量删除卡口经纬度不规范统计
     *
     * @param ids 需要删除的卡口经纬度不规范统计主键
     * @return 结果
     */
    @Override
    public int deleteDevJwdNonStandardByIds(String ids)
    {
        return devJwdNonStandardMapper.deleteDevJwdNonStandardByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除卡口经纬度不规范统计信息
     *
     * @param id 卡口经纬度不规范统计主键
     * @return 结果
     */
    @Override
    public int deleteDevJwdNonStandardById(Long id)
    {
        return devJwdNonStandardMapper.deleteDevJwdNonStandardById(id);
    }
}
