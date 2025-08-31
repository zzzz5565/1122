package com.huitong.business.service.impl;

import java.util.List;

import com.huitong.business.domain.DevVioEquipment;
import com.huitong.common.config.datasource.DynamicDataSourceContextHolder;
import com.huitong.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.EvidenceEquRecordMapper;
import com.huitong.business.domain.EvidenceEquRecord;
import com.huitong.business.service.IEvidenceEquRecordService;
import com.huitong.common.core.text.Convert;

/**
 * 执法取证设备备案统计Service业务层处理
 *
 * @author hairun
 * @date 2025-03-20
 */
@Service
public class EvidenceEquRecordServiceImpl implements IEvidenceEquRecordService
{
    @Autowired
    private EvidenceEquRecordMapper evidenceEquRecordMapper;

    /**
     * 查询执法取证设备备案统计
     *
     * @param id 执法取证设备备案统计主键
     * @return 执法取证设备备案统计
     */
    @Override
    public EvidenceEquRecord selectEvidenceEquRecordById(Long id)
    {
        return evidenceEquRecordMapper.selectEvidenceEquRecordById(id);
    }

    /**
     * 查询执法取证设备备案统计列表
     *
     * @param evidenceEquRecord 执法取证设备备案统计
     * @return 执法取证设备备案统计
     */
    @Override
    public List<EvidenceEquRecord> selectEvidenceEquRecordList(EvidenceEquRecord evidenceEquRecord)
    {
        return evidenceEquRecordMapper.selectEvidenceEquRecordList(evidenceEquRecord);
    }

    @Override
    public List<EvidenceEquRecord> selectEvidenceEquRecordLists(EvidenceEquRecord evidenceEquRecord)
    {
        return evidenceEquRecordMapper.selectEvidenceEquRecordLists(evidenceEquRecord);
    }

    /**
     * 新增执法取证设备备案统计
     *
     * @param evidenceEquRecord 执法取证设备备案统计
     * @return 结果
     */
    @Override
    public int insertEvidenceEquRecord(EvidenceEquRecord evidenceEquRecord)
    {
        return evidenceEquRecordMapper.insertEvidenceEquRecord(evidenceEquRecord);
    }

    /**
     * 修改执法取证设备备案统计
     *
     * @param evidenceEquRecord 执法取证设备备案统计
     * @return 结果
     */
    @Override
    public int updateEvidenceEquRecord(EvidenceEquRecord evidenceEquRecord)
    {
        return evidenceEquRecordMapper.updateEvidenceEquRecord(evidenceEquRecord);
    }

    /**
     * 批量删除执法取证设备备案统计
     *
     * @param ids 需要删除的执法取证设备备案统计主键
     * @return 结果
     */
    @Override
    public int deleteEvidenceEquRecordByIds(String ids)
    {
        return evidenceEquRecordMapper.deleteEvidenceEquRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除执法取证设备备案统计信息
     *
     * @param id 执法取证设备备案统计主键
     * @return 结果
     */
    @Override
    public int deleteEvidenceEquRecordById(Long id)
    {
        return evidenceEquRecordMapper.deleteEvidenceEquRecordById(id);
    }

    @Override
    public List<DevVioEquipment> selectDetailList(String ztlx, String bmbm) {
        return evidenceEquRecordMapper.selectDetailList(ztlx, bmbm);
    }

    @Override
    public List<DevVioEquipment> selectTempDetailList(String bmbm) {
        return evidenceEquRecordMapper.selectTempDetailList(bmbm);
    }
    @Override
    public List<DevVioEquipment> selectDetailListForBA(String bmbm) {
        return evidenceEquRecordMapper.selectDetailListForBA(bmbm);
    }
    @Override
    public long countDetailListForBA(String bmbm) {
        return evidenceEquRecordMapper.countDetailListForBA(bmbm);
    }
}
