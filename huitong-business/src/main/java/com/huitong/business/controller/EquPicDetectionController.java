package com.huitong.business.controller;

import java.util.List;
import com.huitong.common.annotation.*;
import com.huitong.common.config.datasource.DynamicDataSourceContextHolder;
import com.huitong.common.enums.DataSourceType;
import org.springframework.web.bind.annotation.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import com.huitong.common.enums.BusinessType;
import com.huitong.business.domain.EquPicDetection;
import com.huitong.business.service.IEquPicDetectionService;
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
 * 执法设备备案图片检测Controller
 *
 * @author hairun
 * @date 2025-03-25
 */
@Controller
@RequestMapping("/business/equPicDetection")
public class EquPicDetectionController extends BaseController
{
    private String prefix = "business/equPicDetection";

    @Autowired
    private IEquPicDetectionService equPicDetectionService;

//    @RequiresPermissions("business:equPicDetection:view")
    @GetMapping()
    public String equPicDetection()
    {
        return prefix + "/equPicDetection";
    }

    /**
     * 查询执法设备备案图片检测列表
     */
//    @RequiresPermissions("business:equPicDetection:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody EquPicDetection equPicDetection)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
//        startPage(equPicDetection.getPageNum(),equPicDetection.getPageSize());
        List<EquPicDetection> list = equPicDetectionService.selectEquPicDetectionLists(equPicDetection);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出执法设备备案图片检测列表
     */
    @RequiresPermissions("business:equPicDetection:export")
    @Log(title = "执法设备备案图片检测", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody EquPicDetection equPicDetection)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        List<EquPicDetection> list = equPicDetectionService.selectEquPicDetectionLists(equPicDetection);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<EquPicDetection> util = new ExcelUtil<EquPicDetection>(EquPicDetection.class);
        return util.exportExcel(list, "执法设备备案图片检测数据");
    }
//
//    /**
//     * 导出执法设备备案图片检测数据
//     */
//    @RequiresPermissions("business:equPicDetection:export")
//    @Log(title = "执法设备备案图片检测", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody EquPicDetection equPicDetection)
//    {
//        List<EquPicDetection> list = equPicDetectionService.selectEquPicDetectionList(equPicDetection);
//        ExcelUtil<EquPicDetection> util = new ExcelUtil<EquPicDetection>(EquPicDetection.class);
//        AjaxResult ajaxResult =  util.exportExcel(list, "数据文件");
//        String fileName= ajaxResult.get("msg").toString();//获取文件下载名称
//        String filePath = HuiTongConfig.getDownloadPath() + fileName;
//        String zipFileName = System.currentTimeMillis()+".zip";
//        String zipFilePath = HuiTongConfig.getDownloadPath()+zipFileName;
//        if(StringUtils.isNotEmpty(filePath)){
//            try{
//                FileZipUtil.zipFilePwd(filePath,zipFilePath,null);
//                FileUtils.deleteFile(filePath);//删除文件
//                ajaxResult.put("msg","");
//                ajaxResult.put("fileName",zipFileName);
//                ajaxResult.put("realFileName","数据文件"+DateUtils.dateTimeNow()+".zip");
//            }catch (Exception e){
//                ajaxResult.put("code","-1");
//                ajaxResult.put("msg","导出失败!!!");
//                e.printStackTrace();
//            }
//        }
//        return ajaxResult;
//    }
//
//    /**
//     * 新增执法设备备案图片检测
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存执法设备备案图片检测
//     */
//    @RequiresPermissions("business:equPicDetection:add")
//    @Log(title = "执法设备备案图片检测", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody EquPicDetection equPicDetection)
//    {
//        equPicDetection.setCreateBy(getLoginName());
//        return toAjax(equPicDetectionService.insertEquPicDetection(equPicDetection));
//    }
//
//    /**
//     * 修改执法设备备案图片检测
//     */
//    @RequiresPermissions("business:equPicDetection:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        EquPicDetection equPicDetection = equPicDetectionService.selectEquPicDetectionById(id);
//        mmap.put("equPicDetection", equPicDetection);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存执法设备备案图片检测
//     */
//    @RequiresPermissions("business:equPicDetection:edit")
//    @Log(title = "执法设备备案图片检测", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody EquPicDetection equPicDetection)
//    {
//        equPicDetection.setUpdateBy(getLoginName());
//        return toAjax(equPicDetectionService.updateEquPicDetection(equPicDetection));
//    }
//
//    /**
//     * 删除执法设备备案图片检测
//     */
//    @RequiresPermissions("business:equPicDetection:remove")
//    @Log(title = "执法设备备案图片检测", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(equPicDetectionService.deleteEquPicDetectionByIds(ids));
//    }
}
