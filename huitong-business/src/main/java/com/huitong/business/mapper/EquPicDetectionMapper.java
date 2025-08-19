package com.huitong.business.mapper;

import java.util.List;
import com.huitong.business.domain.EquPicDetection;

/**
 * 执法设备备案图片检测Mapper接口
 *
 * @author hairun
 * @date 2025-03-25
 */
public interface EquPicDetectionMapper
{
    /**
     * 查询执法设备备案图片检测
     *
     * @param id 执法设备备案图片检测主键
     * @return 执法设备备案图片检测
     */
    public EquPicDetection selectEquPicDetectionById(Long id);

    /**
     * 查询执法设备备案图片检测列表
     *
     * @param equPicDetection 执法设备备案图片检测
     * @return 执法设备备案图片检测集合
     */
    public List<EquPicDetection> selectEquPicDetectionList(EquPicDetection equPicDetection);
    public List<EquPicDetection> selectEquPicDetectionLists(EquPicDetection equPicDetection);

    /**
     * 新增执法设备备案图片检测
     *
     * @param equPicDetection 执法设备备案图片检测
     * @return 结果
     */
    public int insertEquPicDetection(EquPicDetection equPicDetection);

    /**
     * 修改执法设备备案图片检测
     *
     * @param equPicDetection 执法设备备案图片检测
     * @return 结果
     */
    public int updateEquPicDetection(EquPicDetection equPicDetection);

    /**
     * 删除执法设备备案图片检测
     *
     * @param id 执法设备备案图片检测主键
     * @return 结果
     */
    public int deleteEquPicDetectionById(Long id);

    /**
     * 批量删除执法设备备案图片检测
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEquPicDetectionByIds(String[] ids);
}
