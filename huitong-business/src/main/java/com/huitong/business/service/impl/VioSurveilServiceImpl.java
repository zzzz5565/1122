package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.VioSurveilMapper;
import com.huitong.business.domain.VioSurveil;
import com.huitong.business.service.IVioSurveilService;
import com.huitong.common.core.text.Convert;

/**
 * 违法数据上传记录Service业务层处理
 * 
 * @author jsj
 * @date 2025-08-22
 */
@Service
public class VioSurveilServiceImpl implements IVioSurveilService 
{
    @Autowired
    private VioSurveilMapper vioSurveilMapper;

    /**
     * 查询违法数据上传记录
     * 
     * @param id 违法数据上传记录主键
     * @return 违法数据上传记录
     */
    @Override
    public VioSurveil selectVioSurveilById(Long id)
    {
        return vioSurveilMapper.selectVioSurveilById(id);
    }

    /**
     * 查询违法数据上传记录列表
     * 
     * @param vioSurveil 违法数据上传记录
     * @return 违法数据上传记录
     */
    @Override
    public List<VioSurveil> selectVioSurveilList(VioSurveil vioSurveil)
    {
        return vioSurveilMapper.selectVioSurveilList(vioSurveil);
    }

    @Override
    public List<VioSurveil> selectVioSurveilLists(VioSurveil vioSurveil,String strDayStart,String strDayEnd)
    {
        return vioSurveilMapper.selectVioSurveilLists(vioSurveil,strDayStart,strDayEnd);
    }

    @Override
    public VioSurveil selectDevInUseBySbbh(String sbbh,String strDayStart)
    {
        return vioSurveilMapper.selectDevInUseBySbbh(sbbh,strDayStart);
    }

    /**
     * 新增违法数据上传记录
     * 
     * @param vioSurveil 违法数据上传记录
     * @return 结果
     */
    @Override
    public int insertVioSurveil(VioSurveil vioSurveil)
    {
        return vioSurveilMapper.insertVioSurveil(vioSurveil);
    }

    /**
     * 修改违法数据上传记录
     * 
     * @param vioSurveil 违法数据上传记录
     * @return 结果
     */
    @Override
    public int updateVioSurveil(VioSurveil vioSurveil)
    {
        return vioSurveilMapper.updateVioSurveil(vioSurveil);
    }

    /**
     * 批量删除违法数据上传记录
     * 
     * @param ids 需要删除的违法数据上传记录主键
     * @return 结果
     */
    @Override
    public int deleteVioSurveilByIds(String ids)
    {
        return vioSurveilMapper.deleteVioSurveilByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除违法数据上传记录信息
     * 
     * @param id 违法数据上传记录主键
     * @return 结果
     */
    @Override
    public int deleteVioSurveilById(Long id)
    {
        return vioSurveilMapper.deleteVioSurveilById(id);
    }

    @Override
    public int deleteVioSurveilByYjrq(String strDayStart)
    {
        return vioSurveilMapper.deleteVioSurveilByYjrq(strDayStart);
    }
}
