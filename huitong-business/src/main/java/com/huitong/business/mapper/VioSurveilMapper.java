package com.huitong.business.mapper;

import java.util.List;
import com.huitong.business.domain.VioSurveil;
import org.apache.ibatis.annotations.Param;

/**
 * 违法数据上传记录Mapper接口
 * 
 * @author jsj
 * @date 2025-08-22
 */
public interface VioSurveilMapper 
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

    public List<VioSurveil> selectVioSurveilLists(VioSurveil vioSurveil, @Param("strDayStart") String strDayStart, @Param("strDayEnd") String strDayEnd);

    public VioSurveil selectDevInUseBySbbh(@Param("sbbh") String sbbh, @Param("strDayStart") String strDayStart);

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
     * 删除违法数据上传记录
     * 
     * @param id 违法数据上传记录主键
     * @return 结果
     */
    public int deleteVioSurveilById(Long id);

    public int deleteVioSurveilByYjrq(String strDayStart);

    /**
     * 批量删除违法数据上传记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVioSurveilByIds(String[] ids);
}
