package com.huitong.business.controller;

import java.util.List;
import com.huitong.common.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import com.huitong.common.enums.BusinessType;
import com.huitong.business.domain.DevInUse;
import com.huitong.business.service.IDevInUseService;
import com.huitong.common.core.controller.BaseController;
import com.huitong.common.core.domain.AjaxResult;
import com.huitong.common.utils.poi.ExcelUtil;
import com.huitong.common.utils.StringUtils;
import com.huitong.common.utils.FileZipUtil;
import com.huitong.common.utils.DateUtils;
import com.huitong.common.utils.file.FileUtils;
import com.huitong.common.config.HuiTongConfig;
import com.huitong.common.core.page.TableDataInfo;

/**
 * 在用设备执法数据统计Controller
 * 
 * @author jsj
 * @date 2025-08-14
 */
@Controller
@RequestMapping("/business/devInUse")
public class DevInUseController extends BaseController
{
    private String prefix = "business/devInUse";

    @Autowired
    private IDevInUseService devInUseService;

    @RequiresPermissions("business:devInUse:view")
    @GetMapping()
    public String devInUse()
    {
        return prefix + "/devInUse";
    }

    /**
     * 查询在用设备执法数据统计列表
     */
    @RequiresPermissions("business:devInUse:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody DevInUse devInUse)
    {
        startPage(devInUse.getPageNum(),devInUse.getPageSize());
        List<DevInUse> list = devInUseService.selectDevInUseList(devInUse);
        return getDataTable(list);
    }

    /**
     * 导出在用设备执法数据统计列表
     */
    @RequiresPermissions("business:devInUse:export")
    @Log(title = "在用设备执法数据统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody DevInUse devInUse)
    {
        List<DevInUse> list = devInUseService.selectDevInUseList(devInUse);
        ExcelUtil<DevInUse> util = new ExcelUtil<DevInUse>(DevInUse.class);
        return util.exportExcel(list, "在用设备执法数据统计数据");
    }

    /**
     * 导出在用设备执法数据统计数据
     */
    @RequiresPermissions("business:devInUse:export")
    @Log(title = "在用设备执法数据统计", businessType = BusinessType.EXPORT)
    @PostMapping("/exportZip")
    @ResponseBody
    @Decrypt
    public AjaxResult exportZip(@RequestBody DevInUse devInUse)
    {
        List<DevInUse> list = devInUseService.selectDevInUseList(devInUse);
        ExcelUtil<DevInUse> util = new ExcelUtil<DevInUse>(DevInUse.class);
        AjaxResult ajaxResult =  util.exportExcel(list, "数据文件");
        String fileName= ajaxResult.get("msg").toString();//获取文件下载名称
        String filePath = HuiTongConfig.getDownloadPath() + fileName;
        String zipFileName = System.currentTimeMillis()+".zip";
        String zipFilePath = HuiTongConfig.getDownloadPath()+zipFileName;
        if(StringUtils.isNotEmpty(filePath)){
            try{
                FileZipUtil.zipFilePwd(filePath,zipFilePath,null);
                FileUtils.deleteFile(filePath);//删除文件
                ajaxResult.put("msg","");
                ajaxResult.put("fileName",zipFileName);
                ajaxResult.put("realFileName","数据文件"+DateUtils.dateTimeNow()+".zip");
            }catch (Exception e){
                ajaxResult.put("code","-1");
                ajaxResult.put("msg","导出失败!!!");
                e.printStackTrace();
            }
        }
        return ajaxResult;
    }

    /**
     * 新增在用设备执法数据统计
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存在用设备执法数据统计
     */
    @RequiresPermissions("business:devInUse:add")
    @Log(title = "在用设备执法数据统计", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    @Decrypt
    public AjaxResult addSave(@RequestBody DevInUse devInUse)
    {
        devInUse.setCreateBy(getLoginName());
        return toAjax(devInUseService.insertDevInUse(devInUse));
    }

    /**
     * 修改在用设备执法数据统计
     */
    @RequiresPermissions("business:devInUse:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DevInUse devInUse = devInUseService.selectDevInUseById(id);
        mmap.put("devInUse", devInUse);
        return prefix + "/edit";
    }

    /**
     * 修改保存在用设备执法数据统计
     */
    @RequiresPermissions("business:devInUse:edit")
    @Log(title = "在用设备执法数据统计", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    @Decrypt
    public AjaxResult editSave(@RequestBody DevInUse devInUse)
    {
        devInUse.setUpdateBy(getLoginName());
        return toAjax(devInUseService.updateDevInUse(devInUse));
    }

    /**
     * 删除在用设备执法数据统计
     */
    @RequiresPermissions("business:devInUse:remove")
    @Log(title = "在用设备执法数据统计", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    @Decrypt
    public AjaxResult remove(@RequestBody String ids)
    {
        return toAjax(devInUseService.deleteDevInUseByIds(ids));
    }
}
