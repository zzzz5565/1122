package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.UploadTimelinessRateMapper;
import com.huitong.business.domain.UploadTimelinessRate;
import com.huitong.business.service.IUploadTimelinessRateService;
import com.huitong.common.core.text.Convert;

/**
 * 上传及时率统计Service业务层处理
 *
 * @author huitong
 * @date 2025-04-21
 */
@Service
public class UploadTimelinessRateServiceImpl implements IUploadTimelinessRateService
{
    @Autowired
    private UploadTimelinessRateMapper uploadTimelinessRateMapper;

    /**
     * 查询上传及时率统计
     *
     * @param id 上传及时率统计主键
     * @return 上传及时率统计
     */
    @Override
    public UploadTimelinessRate selectUploadTimelinessRateById(Long id)
    {
        return uploadTimelinessRateMapper.selectUploadTimelinessRateById(id);
    }

    /**
     * 查询上传及时率统计列表
     *
     * @param uploadTimelinessRate 上传及时率统计
     * @return 上传及时率统计
     */
    @Override
    public List<UploadTimelinessRate> selectUploadTimelinessRateList(UploadTimelinessRate uploadTimelinessRate)
    {
        return uploadTimelinessRateMapper.selectUploadTimelinessRateList(uploadTimelinessRate);
    }
    @Override
    public List<UploadTimelinessRate> selectUploadTimelinessRateLists(UploadTimelinessRate uploadTimelinessRate)
    {
        return uploadTimelinessRateMapper.selectUploadTimelinessRateLists(uploadTimelinessRate);
    }

    /**
     * 新增上传及时率统计
     *
     * @param uploadTimelinessRate 上传及时率统计
     * @return 结果
     */
    @Override
    public int insertUploadTimelinessRate(UploadTimelinessRate uploadTimelinessRate)
    {
        return uploadTimelinessRateMapper.insertUploadTimelinessRate(uploadTimelinessRate);
    }

    /**
     * 修改上传及时率统计
     *
     * @param uploadTimelinessRate 上传及时率统计
     * @return 结果
     */
    @Override
    public int updateUploadTimelinessRate(UploadTimelinessRate uploadTimelinessRate)
    {
        return uploadTimelinessRateMapper.updateUploadTimelinessRate(uploadTimelinessRate);
    }

    /**
     * 批量删除上传及时率统计
     *
     * @param ids 需要删除的上传及时率统计主键
     * @return 结果
     */
    @Override
    public int deleteUploadTimelinessRateByIds(String ids)
    {
        return uploadTimelinessRateMapper.deleteUploadTimelinessRateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除上传及时率统计信息
     *
     * @param id 上传及时率统计主键
     * @return 结果
     */
    @Override
    public int deleteUploadTimelinessRateById(Long id)
    {
        return uploadTimelinessRateMapper.deleteUploadTimelinessRateById(id);
    }
}
