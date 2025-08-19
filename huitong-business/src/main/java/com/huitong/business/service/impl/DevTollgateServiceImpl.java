package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.DevTollgateMapper;
import com.huitong.business.domain.DevTollgate;
import com.huitong.business.service.IDevTollgateService;
import com.huitong.common.core.text.Convert;

/**
 * 卡口信息Service业务层处理
 * 
 * @author hr
 * @date 2025-06-20
 */
@Service
public class DevTollgateServiceImpl implements IDevTollgateService 
{
    @Autowired
    private DevTollgateMapper devTollgateMapper;

    /**
     * 查询卡口信息
     * 
     * @param id 卡口信息主键
     * @return 卡口信息
     */
    @Override
    public DevTollgate selectDevTollgateById(Long id)
    {
        return devTollgateMapper.selectDevTollgateById(id);
    }

    /**
     * 查询卡口信息列表
     * 
     * @param devTollgate 卡口信息
     * @return 卡口信息
     */
    @Override
    public List<DevTollgate> selectDevTollgateList(DevTollgate devTollgate)
    {
        return devTollgateMapper.selectDevTollgateList(devTollgate);
    }

    /**
     * 新增卡口信息
     * 
     * @param devTollgate 卡口信息
     * @return 结果
     */
    @Override
    public int insertDevTollgate(DevTollgate devTollgate)
    {
        return devTollgateMapper.insertDevTollgate(devTollgate);
    }

    /**
     * 修改卡口信息
     * 
     * @param devTollgate 卡口信息
     * @return 结果
     */
    @Override
    public int updateDevTollgate(DevTollgate devTollgate)
    {
        return devTollgateMapper.updateDevTollgate(devTollgate);
    }

    /**
     * 批量删除卡口信息
     * 
     * @param ids 需要删除的卡口信息主键
     * @return 结果
     */
    @Override
    public int deleteDevTollgateByIds(String ids)
    {
        return devTollgateMapper.deleteDevTollgateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除卡口信息信息
     * 
     * @param id 卡口信息主键
     * @return 结果
     */
    @Override
    public int deleteDevTollgateById(Long id)
    {
        return devTollgateMapper.deleteDevTollgateById(id);
    }
}
