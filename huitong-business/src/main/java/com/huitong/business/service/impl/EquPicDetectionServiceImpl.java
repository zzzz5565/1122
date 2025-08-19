package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.EquPicDetectionMapper;
import com.huitong.business.domain.EquPicDetection;
import com.huitong.business.service.IEquPicDetectionService;
import com.huitong.common.core.text.Convert;

/**
 * 执法设备备案图片检测Service业务层处理
 *
 * @author hairun
 * @date 2025-03-25
 */
@Service
public class EquPicDetectionServiceImpl implements IEquPicDetectionService
{
    @Autowired
    private EquPicDetectionMapper equPicDetectionMapper;

    /**
     * 查询执法设备备案图片检测
     *
     * @param id 执法设备备案图片检测主键
     * @return 执法设备备案图片检测
     */
    @Override
    public EquPicDetection selectEquPicDetectionById(Long id)
    {
        return equPicDetectionMapper.selectEquPicDetectionById(id);
    }

    /**
     * 查询执法设备备案图片检测列表
     *
     * @param equPicDetection 执法设备备案图片检测
     * @return 执法设备备案图片检测
     */
    @Override
    public List<EquPicDetection> selectEquPicDetectionList(EquPicDetection equPicDetection)
    {
        return equPicDetectionMapper.selectEquPicDetectionList(equPicDetection);
    }
    @Override
    public List<EquPicDetection> selectEquPicDetectionLists(EquPicDetection equPicDetection)
    {
        return equPicDetectionMapper.selectEquPicDetectionLists(equPicDetection);
    }

    /**
     * 新增执法设备备案图片检测
     *
     * @param equPicDetection 执法设备备案图片检测
     * @return 结果
     */
    @Override
    public int insertEquPicDetection(EquPicDetection equPicDetection)
    {
        return equPicDetectionMapper.insertEquPicDetection(equPicDetection);
    }

    /**
     * 修改执法设备备案图片检测
     *
     * @param equPicDetection 执法设备备案图片检测
     * @return 结果
     */
    @Override
    public int updateEquPicDetection(EquPicDetection equPicDetection)
    {
        return equPicDetectionMapper.updateEquPicDetection(equPicDetection);
    }

    /**
     * 批量删除执法设备备案图片检测
     *
     * @param ids 需要删除的执法设备备案图片检测主键
     * @return 结果
     */
    @Override
    public int deleteEquPicDetectionByIds(String ids)
    {
        return equPicDetectionMapper.deleteEquPicDetectionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除执法设备备案图片检测信息
     *
     * @param id 执法设备备案图片检测主键
     * @return 结果
     */
    @Override
    public int deleteEquPicDetectionById(Long id)
    {
        return equPicDetectionMapper.deleteEquPicDetectionById(id);
    }
}
