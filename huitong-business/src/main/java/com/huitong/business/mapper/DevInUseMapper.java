package com.huitong.business.mapper;

import java.util.List;
import com.huitong.business.domain.DevInUse;
import org.apache.ibatis.annotations.Param;

/**
 * 在用设备执法数据统计Mapper接口
 * 
 * @author jsj
 * @date 2025-08-14
 */
public interface DevInUseMapper 
{
    /**
     * 查询在用设备执法数据统计
     * 
     * @param id 在用设备执法数据统计主键
     * @return 在用设备执法数据统计
     */
    public DevInUse selectDevInUseById(Long id);

    /**
     * 查询在用设备执法数据统计列表
     * 
     * @param devInUse 在用设备执法数据统计
     * @return 在用设备执法数据统计集合
     */
    public List<DevInUse> selectDevInUseList(DevInUse devInUse);

    // 同步在用设备
    public List<DevInUse> selectDevInUseLists(DevInUse devInUse, @Param("strDayStart") String strDayStart, @Param("strDayEnd") String strDayEnd);

    // 判断是否存在
    public DevInUse selectDevInUseBySbbh(@Param("sbbh") String sbbh,@Param("strDayStart") String strDayStart);

    /**
     * 新增在用设备执法数据统计
     * 
     * @param devInUse 在用设备执法数据统计
     * @return 结果
     */
    public int insertDevInUse(DevInUse devInUse);

    /**
     * 修改在用设备执法数据统计
     * 
     * @param devInUse 在用设备执法数据统计
     * @return 结果
     */
    public int updateDevInUse(DevInUse devInUse);

    public int updateDevInUseBySbbh(DevInUse devInUse, @Param("sbbh") String sbbh,@Param("strDayStart") String strDayStart);

    /**
     * 删除在用设备执法数据统计
     * 
     * @param id 在用设备执法数据统计主键
     * @return 结果
     */
    public int deleteDevInUseById(Long id);

    /**
     * 批量删除在用设备执法数据统计
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDevInUseByIds(String[] ids);
}
