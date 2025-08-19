package com.huitong.business.controller;

import java.util.Date;
import java.util.List;
import com.huitong.common.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import com.huitong.common.enums.BusinessType;
import com.huitong.business.domain.DevTollgate;
import com.huitong.business.service.IDevTollgateService;
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
 * 卡口信息Controller
 *
 * @author hr
 * @date 2025-06-20
 */
@Controller
@RequestMapping("/business/devTollgate")
public class DevTollgateController extends BaseController
{
    private String prefix = "business/devTollgate";

    @Autowired
    private IDevTollgateService devTollgateService;

    @RequiresPermissions("business:devTollgate:view")
    @GetMapping()
    public String devTollgate()
    {
        return prefix + "/devTollgate";
    }

    @GetMapping("/view/{yjlx}/{yjrq}")
    public String devTollgate(@PathVariable("yjlx") Long yjlx, @PathVariable("yjrq") Date yjrq, ModelMap mmap)
    {
        mmap.put("yjlx", yjlx.toString());
        mmap.put("yjrq", DateUtils.dateTime(yjrq));
        return prefix + "/devTollgate";
    }

    /**
     * 查询卡口信息列表
     */
    @RequiresPermissions("business:devTollgate:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody DevTollgate devTollgate)
    {
        startPage(devTollgate.getPageNum(),devTollgate.getPageSize());
        List<DevTollgate> list = devTollgateService.selectDevTollgateList(devTollgate);
        return getDataTable(list);
    }

    /**
     * 导出卡口信息列表
     */
    @RequiresPermissions("business:devTollgate:export")
    @Log(title = "卡口信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody DevTollgate devTollgate)
    {
        List<DevTollgate> list = devTollgateService.selectDevTollgateList(devTollgate);
        ExcelUtil<DevTollgate> util = new ExcelUtil<DevTollgate>(DevTollgate.class);
        return util.exportExcel(list, "卡口信息数据");
    }

    /**
     * 导出卡口信息数据
     */
    @RequiresPermissions("business:devTollgate:export")
    @Log(title = "卡口信息", businessType = BusinessType.EXPORT)
    @PostMapping("/exportZip")
    @ResponseBody
    @Decrypt
    public AjaxResult exportZip(@RequestBody DevTollgate devTollgate)
    {
        List<DevTollgate> list = devTollgateService.selectDevTollgateList(devTollgate);
        ExcelUtil<DevTollgate> util = new ExcelUtil<DevTollgate>(DevTollgate.class);
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
     * 新增卡口信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存卡口信息
     */
    @RequiresPermissions("business:devTollgate:add")
    @Log(title = "卡口信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    @Decrypt
    public AjaxResult addSave(@RequestBody DevTollgate devTollgate)
    {
        devTollgate.setCreateBy(getLoginName());
        return toAjax(devTollgateService.insertDevTollgate(devTollgate));
    }

    /**
     * 修改卡口信息
     */
    @RequiresPermissions("business:devTollgate:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DevTollgate devTollgate = devTollgateService.selectDevTollgateById(id);
        mmap.put("devTollgate", devTollgate);
        return prefix + "/edit";
    }

    /**
     * 修改保存卡口信息
     */
    @RequiresPermissions("business:devTollgate:edit")
    @Log(title = "卡口信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    @Decrypt
    public AjaxResult editSave(@RequestBody DevTollgate devTollgate)
    {
        devTollgate.setUpdateBy(getLoginName());
        return toAjax(devTollgateService.updateDevTollgate(devTollgate));
    }

    /**
     * 删除卡口信息
     */
    @RequiresPermissions("business:devTollgate:remove")
    @Log(title = "卡口信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    @Decrypt
    public AjaxResult remove(@RequestBody String ids)
    {
        return toAjax(devTollgateService.deleteDevTollgateByIds(ids));
    }
}
