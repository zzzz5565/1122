package com.huitong.quartz.service;

import java.util.List;
import com.huitong.quartz.domain.SysJobLog;

/**
 * 定时任务调度日志信息信息 服务层
 * 
 * 
 */
public interface ISysJobLogService
{
    /**
     * 获取quartz调度器日志的计划任务
     * 
     * @param jobLog 调度日志信息
     * @return 调度任务日志集合
     */
    public List<SysJobLog> selectJobLogList(SysJobLog jobLog);

    /**
     * 通过调度任务日志ID查询调度信息
     * 
     * @param jobLogId 调度任务日志ID
     * @return 调度任务日志对象信息
     */
    public SysJobLog selectJobLogById(Long jobLogId);

    /**
     * 新增任务日志
     * 
     * @param jobLog 调度日志信息
     */
    public void addJobLog(SysJobLog jobLog);

}
