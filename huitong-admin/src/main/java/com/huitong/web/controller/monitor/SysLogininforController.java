package com.huitong.web.controller.monitor;

import java.util.List;

import com.huitong.common.annotation.Decrypt;
import com.huitong.common.annotation.Encrypt;
import com.huitong.framework.shiro.service.SysPasswordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.huitong.common.annotation.Log;
import com.huitong.common.core.controller.BaseController;
import com.huitong.common.core.domain.AjaxResult;
import com.huitong.common.core.page.TableDataInfo;
import com.huitong.common.enums.BusinessType;
import com.huitong.common.utils.poi.ExcelUtil;
import com.huitong.system.domain.SysLogininfor;
import com.huitong.system.service.ISysLogininforService;

/**
 * 系统访问记录
 * 
 * 
 */
@Controller
@RequestMapping("/monitor/logininfor")
public class SysLogininforController extends BaseController
{
    private String prefix = "monitor/logininfor";

    @Autowired
    private ISysLogininforService logininforService;

    @Autowired
    private SysPasswordService passwordService;

    @RequiresPermissions("monitor:logininfor:view")
    @GetMapping()
    public String logininfor()
    {
        return prefix + "/logininfor";
    }

    @RequiresPermissions("monitor:logininfor:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody SysLogininfor logininfor)
    {
        startPage(logininfor.getPageNum(),logininfor.getPageSize());
        List<SysLogininfor> list = logininforService.selectLogininforList(logininfor);
        return getDataTable(list);
    }

    @Log(title = "登录日志", businessType = BusinessType.EXPORT)
    @RequiresPermissions("monitor:logininfor:export")
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody SysLogininfor logininfor)
    {
        List<SysLogininfor> list = logininforService.selectLogininforList(logininfor);
        ExcelUtil<SysLogininfor> util = new ExcelUtil<SysLogininfor>(SysLogininfor.class);
        return util.exportExcel(list, "登录日志");
    }

    @RequiresPermissions("monitor:logininfor:remove")
    @Log(title = "登录日志", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    @Decrypt
    public AjaxResult remove(@RequestBody String ids)
    {
        return toAjax(logininforService.deleteLogininforByIds(ids));
    }
    
    @RequiresPermissions("monitor:logininfor:remove")
    @Log(title = "登录日志", businessType = BusinessType.CLEAN)
    @PostMapping("/clean")
    @ResponseBody
    public AjaxResult clean()
    {
        logininforService.cleanLogininfor();
        return success();
    }

    @RequiresPermissions("monitor:logininfor:unlock")
    @Log(title = "账户解锁", businessType = BusinessType.OTHER)
    @PostMapping("/unlock")
    @ResponseBody
    public AjaxResult unlock(String loginName)
    {
        passwordService.clearLoginRecordCache(loginName);
        return success();
    }
}
