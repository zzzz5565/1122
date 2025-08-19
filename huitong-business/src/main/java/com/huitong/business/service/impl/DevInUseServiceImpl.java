package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.DevInUseMapper;
import com.huitong.business.domain.DevInUse;
import com.huitong.business.service.IDevInUseService;
import com.huitong.common.core.text.Convert;

/**
 * 在用设备执法数据统计Service业务层处理
 * 
 * @author jsj
 * @date 2025-08-14
 */
@Service
public class DevInUseServiceImpl implements IDevInUseService 
{
    @Autowired
    private DevInUseMapper devInUseMapper;

    /**
     * 查询在用设备执法数据统计
     * 
     * @param id 在用设备执法数据统计主键
     * @return 在用设备执法数据统计
     */
    @Override
    public DevInUse selectDevInUseById(Long id)
    {
        return devInUseMapper.selectDevInUseById(id);
    }

    /**
     * 查询在用设备执法数据统计列表
     * 
     * @param devInUse 在用设备执法数据统计
     * @return 在用设备执法数据统计
     */
    @Override
    public List<DevInUse> selectDevInUseList(DevInUse devInUse)
    {
        return devInUseMapper.selectDevInUseList(devInUse);
    }

    // 同步在用设备
    @Override
    public List<DevInUse> selectDevInUseLists(DevInUse devInUse, String strDayStart, String strDayEnd)
    {
        return devInUseMapper.selectDevInUseLists(devInUse, strDayStart, strDayEnd);
    }

    // 判断是否存在
    @Override
    public DevInUse selectDevInUseBySbbh(String sbbh, String strDayStart)
    {
        return devInUseMapper.selectDevInUseBySbbh(sbbh, strDayStart);
    }

    /**
     * 新增在用设备执法数据统计
     * 
     * @param devInUse 在用设备执法数据统计
     * @return 结果
     */
    @Override
    public int insertDevInUse(DevInUse devInUse)
    {
        return devInUseMapper.insertDevInUse(devInUse);
    }

    /**
     * 修改在用设备执法数据统计
     * 
     * @param devInUse 在用设备执法数据统计
     * @return 结果
     */
    @Override
    public int updateDevInUse(DevInUse devInUse)
    {
        return devInUseMapper.updateDevInUse(devInUse);
    }

    // 更新
    @Override
    public int updateDevInUseBySbbh(DevInUse devInUse, String sbbh, String strDayStart)
    {
        return devInUseMapper.updateDevInUseBySbbh(devInUse, sbbh, strDayStart);
    }

    /**
     * 批量删除在用设备执法数据统计
     * 
     * @param ids 需要删除的在用设备执法数据统计主键
     * @return 结果
     */
    @Override
    public int deleteDevInUseByIds(String ids)
    {
        return devInUseMapper.deleteDevInUseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除在用设备执法数据统计信息
     * 
     * @param id 在用设备执法数据统计主键
     * @return 结果
     */
    @Override
    public int deleteDevInUseById(Long id)
    {
        return devInUseMapper.deleteDevInUseById(id);
    }
}
