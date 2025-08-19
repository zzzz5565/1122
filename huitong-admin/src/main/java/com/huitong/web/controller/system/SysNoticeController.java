package com.huitong.web.controller.system;

import java.util.List;
import com.huitong.common.annotation.Decrypt;
import com.huitong.common.annotation.Encrypt;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.huitong.common.annotation.Log;
import com.huitong.common.core.controller.BaseController;
import com.huitong.common.core.domain.AjaxResult;
import com.huitong.common.core.page.TableDataInfo;
import com.huitong.common.enums.BusinessType;
import com.huitong.system.domain.SysNotice;
import com.huitong.system.service.ISysNoticeService;

/**
 * 公告 信息操作处理
 * 
 * 
 */
@Controller
@RequestMapping("/system/notice")
public class SysNoticeController extends BaseController
{
    private String prefix = "system/notice";

    @Autowired
    private ISysNoticeService noticeService;

    @RequiresPermissions("system:notice:view")
    @GetMapping()
    public String notice()
    {
        return prefix + "/notice";
    }

    /**
     * 查询公告列表
     */
    @RequiresPermissions("system:notice:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody SysNotice notice)
    {
        startPage(notice.getPageNum(),notice.getPageSize());
        List<SysNotice> list = noticeService.selectNoticeList(notice);
        return getDataTable(list);
    }

    /**
     * 新增公告
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存公告
     */
    @RequiresPermissions("system:notice:add")
    @Log(title = "通知公告", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    @Decrypt
    public AjaxResult addSave(@RequestBody @Validated SysNotice notice)
    {
        notice.setCreateBy(getLoginName());
        return toAjax(noticeService.insertNotice(notice));
    }

    /**
     * 修改公告
     */
    @RequiresPermissions("system:notice:edit")
    @GetMapping("/edit/{noticeId}")
    public String edit(@PathVariable("noticeId") Long noticeId, ModelMap mmap)
    {
        mmap.put("notice", noticeService.selectNoticeById(noticeId));
        return prefix + "/edit";
    }

    /**
     * 修改保存公告
     */
    @RequiresPermissions("system:notice:edit")
    @Log(title = "通知公告", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    @Decrypt
    public AjaxResult editSave(@RequestBody @Validated SysNotice notice)
    {
        notice.setUpdateBy(getLoginName());
        return toAjax(noticeService.updateNotice(notice));
    }

    /**
     * 删除公告
     */
    @RequiresPermissions("system:notice:remove")
    @Log(title = "通知公告", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    @Decrypt
    public AjaxResult remove(@RequestBody String ids)
    {
        return toAjax(noticeService.deleteNoticeByIds(ids));
    }
}
