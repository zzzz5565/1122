package com.huitong.business.controller;

import java.util.List;
import com.huitong.common.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import com.huitong.common.enums.BusinessType;
import com.huitong.business.domain.VioSurveil;
import com.huitong.business.service.IVioSurveilService;
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
 * 违法数据上传记录Controller
 * 
 * @author jsj
 * @date 2025-08-22
 */
@Controller
@RequestMapping("/business/vioSurveil")
public class VioSurveilController extends BaseController
{
    private String prefix = "business/vioSurveil";

    @Autowired
    private IVioSurveilService vioSurveilService;

    @RequiresPermissions("business:vioSurveil:view")
    @GetMapping()
    public String vioSurveil()
    {
        return prefix + "/vioSurveil";
    }

    /**
     * 查询违法数据上传记录列表
     */
    @RequiresPermissions("business:vioSurveil:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody VioSurveil vioSurveil)
    {
        startPage(vioSurveil.getPageNum(),vioSurveil.getPageSize());
        List<VioSurveil> list = vioSurveilService.selectVioSurveilList(vioSurveil);
        return getDataTable(list);
    }

    /**
     * 导出违法数据上传记录列表
     */
    @RequiresPermissions("business:vioSurveil:export")
    @Log(title = "违法数据上传记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody VioSurveil vioSurveil)
    {
        List<VioSurveil> list = vioSurveilService.selectVioSurveilList(vioSurveil);
        ExcelUtil<VioSurveil> util = new ExcelUtil<VioSurveil>(VioSurveil.class);
        return util.exportExcel(list, "违法数据上传记录数据");
    }

    /**
     * 导出违法数据上传记录数据
     */
    @RequiresPermissions("business:vioSurveil:export")
    @Log(title = "违法数据上传记录", businessType = BusinessType.EXPORT)
    @PostMapping("/exportZip")
    @ResponseBody
    @Decrypt
    public AjaxResult exportZip(@RequestBody VioSurveil vioSurveil)
    {
        List<VioSurveil> list = vioSurveilService.selectVioSurveilList(vioSurveil);
        ExcelUtil<VioSurveil> util = new ExcelUtil<VioSurveil>(VioSurveil.class);
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
     * 新增违法数据上传记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存违法数据上传记录
     */
    @RequiresPermissions("business:vioSurveil:add")
    @Log(title = "违法数据上传记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    @Decrypt
    public AjaxResult addSave(@RequestBody VioSurveil vioSurveil)
    {
        vioSurveil.setCreateBy(getLoginName());
        return toAjax(vioSurveilService.insertVioSurveil(vioSurveil));
    }

    /**
     * 修改违法数据上传记录
     */
    @RequiresPermissions("business:vioSurveil:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        VioSurveil vioSurveil = vioSurveilService.selectVioSurveilById(id);
        mmap.put("vioSurveil", vioSurveil);
        return prefix + "/edit";
    }

    /**
     * 修改保存违法数据上传记录
     */
    @RequiresPermissions("business:vioSurveil:edit")
    @Log(title = "违法数据上传记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    @Decrypt
    public AjaxResult editSave(@RequestBody VioSurveil vioSurveil)
    {
        vioSurveil.setUpdateBy(getLoginName());
        return toAjax(vioSurveilService.updateVioSurveil(vioSurveil));
    }

    /**
     * 删除违法数据上传记录
     */
    @RequiresPermissions("business:vioSurveil:remove")
    @Log(title = "违法数据上传记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    @Decrypt
    public AjaxResult remove(@RequestBody String ids)
    {
        return toAjax(vioSurveilService.deleteVioSurveilByIds(ids));
    }
}
