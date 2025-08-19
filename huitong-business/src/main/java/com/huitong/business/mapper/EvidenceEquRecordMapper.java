package com.huitong.business.mapper;

import java.util.List;
import com.huitong.business.domain.EvidenceEquRecord;

/**
 * 执法取证设备备案统计Mapper接口
 *
 * @author hairun
 * @date 2025-03-20
 */
public interface EvidenceEquRecordMapper
{
    /**
     * 查询执法取证设备备案统计
     *
     * @param id 执法取证设备备案统计主键
     * @return 执法取证设备备案统计
     */
    public EvidenceEquRecord selectEvidenceEquRecordById(Long id);

    /**
     * 查询执法取证设备备案统计列表
     *
     * @param evidenceEquRecord 执法取证设备备案统计
     * @return 执法取证设备备案统计集合
     */
    public List<EvidenceEquRecord> selectEvidenceEquRecordList(EvidenceEquRecord evidenceEquRecord);
    public List<EvidenceEquRecord> selectEvidenceEquRecordLists(EvidenceEquRecord evidenceEquRecord);

    /**
     * 新增执法取证设备备案统计
     *
     * @param evidenceEquRecord 执法取证设备备案统计
     * @return 结果
     */
    public int insertEvidenceEquRecord(EvidenceEquRecord evidenceEquRecord);

    /**
     * 修改执法取证设备备案统计
     *
     * @param evidenceEquRecord 执法取证设备备案统计
     * @return 结果
     */
    public int updateEvidenceEquRecord(EvidenceEquRecord evidenceEquRecord);

    /**
     * 删除执法取证设备备案统计
     *
     * @param id 执法取证设备备案统计主键
     * @return 结果
     */
    public int deleteEvidenceEquRecordById(Long id);

    /**
     * 批量删除执法取证设备备案统计
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEvidenceEquRecordByIds(String[] ids);
}
