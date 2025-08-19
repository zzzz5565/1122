package com.huitong.business.controller;

import java.util.List;

import com.huitong.business.domain.DevNoPassCar;
import com.huitong.common.annotation.*;
import com.huitong.common.config.datasource.DynamicDataSourceContextHolder;
import com.huitong.common.enums.DataSourceType;
import org.springframework.web.bind.annotation.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import com.huitong.common.enums.BusinessType;
import com.huitong.business.domain.DevNameNonStandard;
import com.huitong.business.service.IDevNameNonStandardService;
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
 * 卡口命名不规范统计Controller
 *
 * @author huitong
 * @date 2025-03-31
 */
@Controller
@RequestMapping("/business/devNameNonStandard")
public class DevNameNonStandardController extends BaseController
{
    private String prefix = "business/devNameNonStandard";

    @Autowired
    private IDevNameNonStandardService devNameNonStandardService;

//    @RequiresPermissions("business:devNameNonStandard:view")
    @GetMapping()
    public String devNameNonStandard()
    {
        return prefix + "/devNameNonStandard";
    }

    /**
     * 查询卡口命名不规范统计列表
     */
//    @RequiresPermissions("business:devNameNonStandard:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody DevNameNonStandard devNameNonStandard)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
//        startPage(devNameNonStandard.getPageNum(),devNameNonStandard.getPageSize());
        List<DevNameNonStandard> list = devNameNonStandardService.selectDevNameNonStandardLists(devNameNonStandard);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出卡口命名不规范统计列表
     */
    @RequiresPermissions("business:devNameNonStandard:export")
    @Log(title = "卡口命名不规范统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody DevNameNonStandard devNameNonStandard)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        List<DevNameNonStandard> list = devNameNonStandardService.selectDevNameNonStandardLists(devNameNonStandard);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<DevNameNonStandard> util = new ExcelUtil<DevNameNonStandard>(DevNameNonStandard.class);
        return util.exportExcel(list, "卡口命名不规范统计数据");
    }
//
//    /**
//     * 导出卡口命名不规范统计数据
//     */
//    @RequiresPermissions("business:devNameNonStandard:export")
//    @Log(title = "卡口命名不规范统计", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody DevNameNonStandard devNameNonStandard)
//    {
//        List<DevNameNonStandard> list = devNameNonStandardService.selectDevNameNonStandardList(devNameNonStandard);
//        ExcelUtil<DevNameNonStandard> util = new ExcelUtil<DevNameNonStandard>(DevNameNonStandard.class);
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
//     * 新增卡口命名不规范统计
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存卡口命名不规范统计
//     */
//    @RequiresPermissions("business:devNameNonStandard:add")
//    @Log(title = "卡口命名不规范统计", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody DevNameNonStandard devNameNonStandard)
//    {
//        devNameNonStandard.setCreateBy(getLoginName());
//        return toAjax(devNameNonStandardService.insertDevNameNonStandard(devNameNonStandard));
//    }
//
//    /**
//     * 修改卡口命名不规范统计
//     */
//    @RequiresPermissions("business:devNameNonStandard:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        DevNameNonStandard devNameNonStandard = devNameNonStandardService.selectDevNameNonStandardById(id);
//        mmap.put("devNameNonStandard", devNameNonStandard);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存卡口命名不规范统计
//     */
//    @RequiresPermissions("business:devNameNonStandard:edit")
//    @Log(title = "卡口命名不规范统计", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody DevNameNonStandard devNameNonStandard)
//    {
//        devNameNonStandard.setUpdateBy(getLoginName());
//        return toAjax(devNameNonStandardService.updateDevNameNonStandard(devNameNonStandard));
//    }
//
//    /**
//     * 删除卡口命名不规范统计
//     */
//    @RequiresPermissions("business:devNameNonStandard:remove")
//    @Log(title = "卡口命名不规范统计", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(devNameNonStandardService.deleteDevNameNonStandardByIds(ids));
//    }
}
