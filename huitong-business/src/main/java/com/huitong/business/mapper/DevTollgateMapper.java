package com.huitong.business.mapper;

import java.util.List;
import com.huitong.business.domain.DevTollgate;

/**
 * 卡口信息Mapper接口
 *
 * @author hr
 * @date 2025-06-20
 */
public interface DevTollgateMapper
{
    /**
     * 查询卡口信息
     *
     * @param id 卡口信息主键
     * @return 卡口信息
     */
    public DevTollgate selectDevTollgateById(Long id);

    public DevTollgate selectDevTollgateByKKbh(String kkbh);

    /**
     * 查询卡口信息列表
     *
     * @param devTollgate 卡口信息
     * @return 卡口信息集合
     */
    public List<DevTollgate> selectDevTollgateList(DevTollgate devTollgate);

    public List<DevTollgate> selectDevTollgateListSlave(DevTollgate devTollgate);

    /**
     * 新增卡口信息
     *
     * @param devTollgate 卡口信息
     * @return 结果
     */
    public int insertDevTollgate(DevTollgate devTollgate);

    /**
     * 修改卡口信息
     *
     * @param devTollgate 卡口信息
     * @return 结果
     */
    public int updateDevTollgate(DevTollgate devTollgate);

    /**
     * 删除卡口信息
     *
     * @param id 卡口信息主键
     * @return 结果
     */
    public int deleteDevTollgateById(Long id);

    /**
     * 批量删除卡口信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDevTollgateByIds(String[] ids);
}
