package com.huitong.business.service.impl;

import java.util.Date;
import java.util.List;

import com.huitong.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.DevVioEquWarningMapper;
import com.huitong.business.domain.DevVioEquWarning;
import com.huitong.business.service.IDevVioEquWarningService;
import com.huitong.common.core.text.Convert;

/**
 * 设备预警Service业务层处理
 *
 * @author hr
 * @date 2025-06-17
 */
@Service
public class DevVioEquWarningServiceImpl implements IDevVioEquWarningService
{
    @Autowired
    private DevVioEquWarningMapper devVioEquWarningMapper;

    /**
     * 查询设备预警
     *
     * @param id 设备预警主键
     * @return 设备预警
     */
    @Override
    public DevVioEquWarning selectDevVioEquWarningById(Long id)
    {
        return devVioEquWarningMapper.selectDevVioEquWarningById(id);
    }

    /**
     * 查询设备预警列表
     *
     * @param devVioEquWarning 设备预警
     * @return 设备预警
     */
    @Override
    public List<DevVioEquWarning> selectDevVioEquWarningList(DevVioEquWarning devVioEquWarning)
    {
        return devVioEquWarningMapper.selectDevVioEquWarningList(devVioEquWarning);
    }

    public List<DevVioEquWarning> selectDevVioEquWarningLists(DevVioEquWarning devVioEquWarning)
    {
        return devVioEquWarningMapper.selectDevVioEquWarningLists(devVioEquWarning);
    }

    /**
     * 新增设备预警
     *
     * @param devVioEquWarning 设备预警
     * @return 结果
     */
    @Override
    public int insertDevVioEquWarning(DevVioEquWarning devVioEquWarning)
    {
        return devVioEquWarningMapper.insertDevVioEquWarning(devVioEquWarning);
    }

    /**
     * 修改设备预警
     *
     * @param devVioEquWarning 设备预警
     * @return 结果
     */
    @Override
    public int updateDevVioEquWarning(DevVioEquWarning devVioEquWarning)
    {
        return devVioEquWarningMapper.updateDevVioEquWarning(devVioEquWarning);
    }

    /**
     * 批量删除设备预警
     *
     * @param ids 需要删除的设备预警主键
     * @return 结果
     */
    @Override
    public int deleteDevVioEquWarningByIds(String ids)
    {
        return devVioEquWarningMapper.deleteDevVioEquWarningByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备预警信息
     *
     * @param id 设备预警主键
     * @return 结果
     */
    @Override
    public int deleteDevVioEquWarningById(Long id)
    {
        return devVioEquWarningMapper.deleteDevVioEquWarningById(id);
    }

    @Override
    public int insertDevVioEquWarningBatch(List<DevVioEquWarning> list)
    {
        return devVioEquWarningMapper.insertDevVioEquWarningBatch(list);
    }

    @Override
    public int insertAbnormalWarningData(List<DevVioEquWarning> list)
    {
        return devVioEquWarningMapper.insertAbnormalWarningData(list);
    }

    @Override
    public int deleteDevVioEquWarningBatch(Integer yjlx, Date yjrq)
    {
        DevVioEquWarning devVioEquWarning = new DevVioEquWarning();
        devVioEquWarning.setYjlx(yjlx);
        devVioEquWarning.setYjrq(yjrq);
        return devVioEquWarningMapper.deleteDevVioEquWarningBatch(devVioEquWarning);
    }
}
