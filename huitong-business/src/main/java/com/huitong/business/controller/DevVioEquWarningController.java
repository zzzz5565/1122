package com.huitong.business.controller;

import java.util.List;
import com.huitong.common.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import com.huitong.common.enums.BusinessType;
import com.huitong.business.domain.DevVioEquWarning;
import com.huitong.business.service.IDevVioEquWarningService;
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
 * 设备预警Controller
 * 
 * @author hr
 * @date 2025-06-17
 */
@Controller
@RequestMapping("/business/devVioEquWarning")
public class DevVioEquWarningController extends BaseController
{
    private String prefix = "business/devVioEquWarning";

    @Autowired
    private IDevVioEquWarningService devVioEquWarningService;

    @RequiresPermissions("business:devVioEquWarning:view")
    @GetMapping()
    public String devVioEquWarning()
    {
        return prefix + "/devVioEquWarning";
    }

    /**
     * 查询设备预警列表
     */
    @RequiresPermissions("business:devVioEquWarning:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody DevVioEquWarning devVioEquWarning)
    {
        startPage(devVioEquWarning.getPageNum(),devVioEquWarning.getPageSize());
        List<DevVioEquWarning> list = devVioEquWarningService.selectDevVioEquWarningList(devVioEquWarning);
        return getDataTable(list);
    }

    /**
     * 导出设备预警列表
     */
    @RequiresPermissions("business:devVioEquWarning:export")
    @Log(title = "设备预警", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody DevVioEquWarning devVioEquWarning)
    {
        List<DevVioEquWarning> list = devVioEquWarningService.selectDevVioEquWarningList(devVioEquWarning);
        ExcelUtil<DevVioEquWarning> util = new ExcelUtil<DevVioEquWarning>(DevVioEquWarning.class);
        return util.exportExcel(list, "设备预警数据");
    }

    /**
     * 导出设备预警数据
     */
    @RequiresPermissions("business:devVioEquWarning:export")
    @Log(title = "设备预警", businessType = BusinessType.EXPORT)
    @PostMapping("/exportZip")
    @ResponseBody
    @Decrypt
    public AjaxResult exportZip(@RequestBody DevVioEquWarning devVioEquWarning)
    {
        List<DevVioEquWarning> list = devVioEquWarningService.selectDevVioEquWarningList(devVioEquWarning);
        ExcelUtil<DevVioEquWarning> util = new ExcelUtil<DevVioEquWarning>(DevVioEquWarning.class);
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
     * 新增设备预警
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备预警
     */
    @RequiresPermissions("business:devVioEquWarning:add")
    @Log(title = "设备预警", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    @Decrypt
    public AjaxResult addSave(@RequestBody DevVioEquWarning devVioEquWarning)
    {
        devVioEquWarning.setCreateBy(getLoginName());
        return toAjax(devVioEquWarningService.insertDevVioEquWarning(devVioEquWarning));
    }

    /**
     * 修改设备预警
     */
    @RequiresPermissions("business:devVioEquWarning:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DevVioEquWarning devVioEquWarning = devVioEquWarningService.selectDevVioEquWarningById(id);
        mmap.put("devVioEquWarning", devVioEquWarning);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备预警
     */
    @RequiresPermissions("business:devVioEquWarning:edit")
    @Log(title = "设备预警", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    @Decrypt
    public AjaxResult editSave(@RequestBody DevVioEquWarning devVioEquWarning)
    {
        devVioEquWarning.setUpdateBy(getLoginName());
        return toAjax(devVioEquWarningService.updateDevVioEquWarning(devVioEquWarning));
    }

    /**
     * 删除设备预警
     */
    @RequiresPermissions("business:devVioEquWarning:remove")
    @Log(title = "设备预警", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    @Decrypt
    public AjaxResult remove(@RequestBody String ids)
    {
        return toAjax(devVioEquWarningService.deleteDevVioEquWarningByIds(ids));
    }
}
