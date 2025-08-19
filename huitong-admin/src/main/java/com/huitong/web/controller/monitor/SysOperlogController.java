package com.huitong.web.controller.monitor;

import java.util.List;

import com.huitong.common.annotation.Decrypt;
import com.huitong.common.annotation.Encrypt;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.huitong.common.annotation.Log;
import com.huitong.common.core.controller.BaseController;
import com.huitong.common.core.domain.AjaxResult;
import com.huitong.common.core.page.TableDataInfo;
import com.huitong.common.enums.BusinessType;
import com.huitong.common.utils.poi.ExcelUtil;
import com.huitong.system.domain.SysOperLog;
import com.huitong.system.service.ISysOperLogService;

/**
 * 操作日志记录
 * 
 *
 */
@Controller
@RequestMapping("/monitor/operlog")
public class SysOperlogController extends BaseController
{
    private String prefix = "monitor/operlog";

    @Autowired
    private ISysOperLogService operLogService;

    @RequiresPermissions("monitor:operlog:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/operlog";
    }

    @RequiresPermissions("monitor:operlog:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody SysOperLog operLog)
    {
        startPage(operLog.getPageNum(),operLog.getPageSize());
        List<SysOperLog> list = operLogService.selectOperLogList(operLog);
        return getDataTable(list);
    }

    @Log(title = "操作日志", businessType = BusinessType.EXPORT)
    @RequiresPermissions("monitor:operlog:export")
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody SysOperLog operLog)
    {
        List<SysOperLog> list = operLogService.selectOperLogList(operLog);
        ExcelUtil<SysOperLog> util = new ExcelUtil<SysOperLog>(SysOperLog.class);
        return util.exportExcel(list, "操作日志");
    }

    @RequiresPermissions("monitor:operlog:detail")
    @GetMapping("/detail/{operId}")
    public String detail(@PathVariable("operId") Long operId, ModelMap mmap)
    {
        mmap.put("operLog", operLogService.selectOperLogById(operId));
        return prefix + "/detail";
    }

}
