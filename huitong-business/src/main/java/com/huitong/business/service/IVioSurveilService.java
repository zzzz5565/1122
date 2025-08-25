package com.huitong.business.service;

import java.util.List;
import com.huitong.business.domain.VioSurveil;

/**
 * 违法数据上传记录Service接口
 * 
 * @author jsj
 * @date 2025-08-22
 */
public interface IVioSurveilService 
{
    /**
     * 查询违法数据上传记录
     * 
     * @param id 违法数据上传记录主键
     * @return 违法数据上传记录
     */
    public VioSurveil selectVioSurveilById(Long id);

    /**
     * 查询违法数据上传记录列表
     * 
     * @param vioSurveil 违法数据上传记录
     * @return 违法数据上传记录集合
     */
    public List<VioSurveil> selectVioSurveilList(VioSurveil vioSurveil);

    public List<VioSurveil> selectVioSurveilLists(VioSurveil vioSurveil,String strDayStart,String strDayEnd);

    public VioSurveil selectDevInUseBySbbh(String sbbh,String strDayStart);

    /**
     * 新增违法数据上传记录
     * 
     * @param vioSurveil 违法数据上传记录
     * @return 结果
     */
    public int insertVioSurveil(VioSurveil vioSurveil);

    /**
     * 修改违法数据上传记录
     * 
     * @param vioSurveil 违法数据上传记录
     * @return 结果
     */
    public int updateVioSurveil(VioSurveil vioSurveil);

    /**
     * 批量删除违法数据上传记录
     * 
     * @param ids 需要删除的违法数据上传记录主键集合
     * @return 结果
     */
    public int deleteVioSurveilByIds(String ids);

    /**
     * 删除违法数据上传记录信息
     * 
     * @param id 违法数据上传记录主键
     * @return 结果
     */
    public int deleteVioSurveilById(Long id);

    public int deleteVioSurveilByYjrq(String strDayStart);
}
