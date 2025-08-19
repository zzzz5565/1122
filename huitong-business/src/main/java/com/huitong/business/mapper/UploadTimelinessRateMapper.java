package com.huitong.business.mapper;

import java.util.List;
import com.huitong.business.domain.UploadTimelinessRate;

/**
 * 上传及时率统计Mapper接口
 *
 * @author huitong
 * @date 2025-04-21
 */
public interface UploadTimelinessRateMapper
{
    /**
     * 查询上传及时率统计
     *
     * @param id 上传及时率统计主键
     * @return 上传及时率统计
     */
    public UploadTimelinessRate selectUploadTimelinessRateById(Long id);

    /**
     * 查询上传及时率统计列表
     *
     * @param uploadTimelinessRate 上传及时率统计
     * @return 上传及时率统计集合
     */
    public List<UploadTimelinessRate> selectUploadTimelinessRateList(UploadTimelinessRate uploadTimelinessRate);
    public List<UploadTimelinessRate> selectUploadTimelinessRateLists(UploadTimelinessRate uploadTimelinessRate);

    /**
     * 新增上传及时率统计
     *
     * @param uploadTimelinessRate 上传及时率统计
     * @return 结果
     */
    public int insertUploadTimelinessRate(UploadTimelinessRate uploadTimelinessRate);

    /**
     * 修改上传及时率统计
     *
     * @param uploadTimelinessRate 上传及时率统计
     * @return 结果
     */
    public int updateUploadTimelinessRate(UploadTimelinessRate uploadTimelinessRate);

    /**
     * 删除上传及时率统计
     *
     * @param id 上传及时率统计主键
     * @return 结果
     */
    public int deleteUploadTimelinessRateById(Long id);

    /**
     * 批量删除上传及时率统计
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUploadTimelinessRateByIds(String[] ids);
}
