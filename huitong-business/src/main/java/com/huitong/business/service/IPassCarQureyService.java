package com.huitong.business.service;

import java.util.List;
import com.huitong.business.domain.PassCarQurey;

/**
 * 云平台过车查询Service接口
 *
 * @author huitong
 * @date 2025-04-09
 */
public interface IPassCarQureyService
{
    /**
     * 查询云平台过车查询
     *
     * @param id 云平台过车查询主键
     * @return 云平台过车查询
     */
    public PassCarQurey selectPassCarQureyById(Long id);

    /**
     * 查询云平台过车查询列表
     *
     * @param passCarQurey 云平台过车查询
     * @return 云平台过车查询集合
     */
    public List<PassCarQurey> selectPassCarQureyList(PassCarQurey passCarQurey);
    public List<PassCarQurey> selectPassCarQureyLists(PassCarQurey passCarQurey);
    public List<PassCarQurey> selectPassCarQureyLists2(PassCarQurey passCarQurey);

    /**
     * 新增云平台过车查询
     *
     * @param passCarQurey 云平台过车查询
     * @return 结果
     */
    public int insertPassCarQurey(PassCarQurey passCarQurey);

    /**
     * 修改云平台过车查询
     *
     * @param passCarQurey 云平台过车查询
     * @return 结果
     */
    public int updatePassCarQurey(PassCarQurey passCarQurey);

    /**
     * 批量删除云平台过车查询
     *
     * @param ids 需要删除的云平台过车查询主键集合
     * @return 结果
     */
    public int deletePassCarQureyByIds(String ids);

    /**
     * 删除云平台过车查询信息
     *
     * @param id 云平台过车查询主键
     * @return 结果
     */
    public int deletePassCarQureyById(Long id);
}
