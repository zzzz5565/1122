package com.huitong.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.business.mapper.DevVioEquWarningDeptMapper;
import com.huitong.business.domain.DevVioEquWarningDept;
import com.huitong.business.service.IDevVioEquWarningDeptService;
import com.huitong.common.core.text.Convert;

/**
 * 设备预警Service业务层处理
 * 
 * @author jsj
 * @date 2025-08-13
 */
@Service
public class DevVioEquWarningDeptServiceImpl implements IDevVioEquWarningDeptService 
{
    @Autowired
    private DevVioEquWarningDeptMapper devVioEquWarningDeptMapper;

    /**
     * 查询设备预警
     * 
     * @param id 设备预警主键
     * @return 设备预警
     */
    @Override
    public DevVioEquWarningDept selectDevVioEquWarningDeptById(Long id)
    {
        return devVioEquWarningDeptMapper.selectDevVioEquWarningDeptById(id);
    }

    /**
     * 查询设备预警列表
     * 
     * @param devVioEquWarningDept 设备预警
     * @return 设备预警
     */
    @Override
    public List<DevVioEquWarningDept> selectDevVioEquWarningDeptList(DevVioEquWarningDept devVioEquWarningDept)
    {
        return devVioEquWarningDeptMapper.selectDevVioEquWarningDeptList(devVioEquWarningDept);
    }

    @Override
    public List<DevVioEquWarningDept> selectWarningDeptList(DevVioEquWarningDept devVioEquWarningDept)
    {
        return devVioEquWarningDeptMapper.selectWarningDeptList(devVioEquWarningDept);
    }

    @Override
    public List<DevVioEquWarningDept> selectCsycList(DevVioEquWarningDept devVioEquWarningDept)
    {
        return devVioEquWarningDeptMapper.selectCsycList(devVioEquWarningDept);
    }

    @Override
    public List<DevVioEquWarningDept> selectWsjscList(DevVioEquWarningDept devVioEquWarningDept)
    {
        return devVioEquWarningDeptMapper.selectWsjscList(devVioEquWarningDept);
    }

    @Override
    public List<DevVioEquWarningDept> selectZtycList(DevVioEquWarningDept devVioEquWarningDept)
    {
        return devVioEquWarningDeptMapper.selectZtycList(devVioEquWarningDept);
    }

    @Override
    public List<DevVioEquWarningDept> selectZplycList(DevVioEquWarningDept devVioEquWarningDept)
    {
        return devVioEquWarningDeptMapper.selectZplycList(devVioEquWarningDept);
    }

    @Override
    public List<DevVioEquWarningDept> selectSjjzList(DevVioEquWarningDept devVioEquWarningDept)
    {
        return devVioEquWarningDeptMapper.selectSjjzList(devVioEquWarningDept);
    }

    @Override
    public List<DevVioEquWarningDept> selectSjjjList(DevVioEquWarningDept devVioEquWarningDept)
    {
        return devVioEquWarningDeptMapper.selectSjjjList(devVioEquWarningDept);
    }
    @Override
    public List<DevVioEquWarningDept> selectZfscsbList(DevVioEquWarningDept devVioEquWarningDept)
    {
        return devVioEquWarningDeptMapper.selectZfscsbList(devVioEquWarningDept);
    }
    /**
     * 新增设备预警
     * 
     * @param devVioEquWarningDept 设备预警
     * @return 结果
     */
    @Override
    public int insertDevVioEquWarningDept(DevVioEquWarningDept devVioEquWarningDept)
    {
        return devVioEquWarningDeptMapper.insertDevVioEquWarningDept(devVioEquWarningDept);
    }

    /**
     * 修改设备预警
     * 
     * @param devVioEquWarningDept 设备预警
     * @return 结果
     */
    @Override
    public int updateDevVioEquWarningDept(DevVioEquWarningDept devVioEquWarningDept)
    {
        return devVioEquWarningDeptMapper.updateDevVioEquWarningDept(devVioEquWarningDept);
    }

    /**
     * 批量删除设备预警
     * 
     * @param ids 需要删除的设备预警主键
     * @return 结果
     */
    @Override
    public int deleteDevVioEquWarningDeptByIds(String ids)
    {
        return devVioEquWarningDeptMapper.deleteDevVioEquWarningDeptByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备预警信息
     * 
     * @param id 设备预警主键
     * @return 结果
     */
    @Override
    public int deleteDevVioEquWarningDeptById(Long id)
    {
        return devVioEquWarningDeptMapper.deleteDevVioEquWarningDeptById(id);
    }
}
