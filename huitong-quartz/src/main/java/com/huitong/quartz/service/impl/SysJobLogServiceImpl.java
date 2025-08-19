package com.huitong.quartz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huitong.common.core.text.Convert;
import com.huitong.quartz.domain.SysJobLog;
import com.huitong.quartz.mapper.SysJobLogMapper;
import com.huitong.quartz.service.ISysJobLogService;

/**
 * 定时任务调度日志信息 服务层
 * 
 *
 */
@Service
public class SysJobLogServiceImpl implements ISysJobLogService
{
    @Autowired
    private SysJobLogMapper jobLogMapper;

    /**
     * 获取quartz调度器日志的计划任务
     * 
     * @param jobLog 调度日志信息
     * @return 调度任务日志集合
     */
    @Override
    public List<SysJobLog> selectJobLogList(SysJobLog jobLog)
    {
        return jobLogMapper.selectJobLogList(jobLog);
    }

    /**
     * 通过调度任务日志ID查询调度信息
     * 
     * @param jobLogId 调度任务日志ID
     * @return 调度任务日志对象信息
     */
    @Override
    public SysJobLog selectJobLogById(Long jobLogId)
    {
        return jobLogMapper.selectJobLogById(jobLogId);
    }

    /**
     * 新增任务日志
     * 
     * @param jobLog 调度日志信息
     */
    @Override
    public void addJobLog(SysJobLog jobLog)
    {
        jobLogMapper.insertJobLog(jobLog);
    }

}
