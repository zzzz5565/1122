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
import com.huitong.business.domain.DevOperation;
import com.huitong.business.service.IDevOperationService;
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
 * 重要点位卡口运行稳定情况Controller
 *
 * @author huitong
 * @date 2025-04-01
 */
@Controller
@RequestMapping("/business/devOperation")
public class DevOperationController extends BaseController
{
    private String prefix = "business/devOperation";

    @Autowired
    private IDevOperationService devOperationService;

//    @RequiresPermissions("business:devOperation:view")
    @GetMapping()
    public String devOperation()
    {
        return prefix + "/devOperation";
    }

    /**
     * 查询重要点位卡口运行稳定情况列表
     */
//    @RequiresPermissions("business:devOperation:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody DevOperation devOperation)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
//        startPage(devOperation.getPageNum(),devOperation.getPageSize());
        List<DevOperation> list = devOperationService.selectDevOperationLists(devOperation);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出重要点位卡口运行稳定情况列表
     */
    @RequiresPermissions("business:devOperation:export")
    @Log(title = "重要点位卡口运行稳定情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody DevOperation devOperation)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        List<DevOperation> list = devOperationService.selectDevOperationLists(devOperation);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<DevOperation> util = new ExcelUtil<DevOperation>(DevOperation.class);
        return util.exportExcel(list, "重要点位卡口运行稳定情况数据");
    }
//
//    /**
//     * 导出重要点位卡口运行稳定情况数据
//     */
//    @RequiresPermissions("business:devOperation:export")
//    @Log(title = "重要点位卡口运行稳定情况", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody DevOperation devOperation)
//    {
//        List<DevOperation> list = devOperationService.selectDevOperationList(devOperation);
//        ExcelUtil<DevOperation> util = new ExcelUtil<DevOperation>(DevOperation.class);
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
//     * 新增重要点位卡口运行稳定情况
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存重要点位卡口运行稳定情况
//     */
//    @RequiresPermissions("business:devOperation:add")
//    @Log(title = "重要点位卡口运行稳定情况", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody DevOperation devOperation)
//    {
//        devOperation.setCreateBy(getLoginName());
//        return toAjax(devOperationService.insertDevOperation(devOperation));
//    }
//
//    /**
//     * 修改重要点位卡口运行稳定情况
//     */
//    @RequiresPermissions("business:devOperation:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        DevOperation devOperation = devOperationService.selectDevOperationById(id);
//        mmap.put("devOperation", devOperation);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存重要点位卡口运行稳定情况
//     */
//    @RequiresPermissions("business:devOperation:edit")
//    @Log(title = "重要点位卡口运行稳定情况", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody DevOperation devOperation)
//    {
//        devOperation.setUpdateBy(getLoginName());
//        return toAjax(devOperationService.updateDevOperation(devOperation));
//    }
//
//    /**
//     * 删除重要点位卡口运行稳定情况
//     */
//    @RequiresPermissions("business:devOperation:remove")
//    @Log(title = "重要点位卡口运行稳定情况", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(devOperationService.deleteDevOperationByIds(ids));
//    }
}
