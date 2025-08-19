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
import com.huitong.business.domain.DevJwdNonStandard;
import com.huitong.business.service.IDevJwdNonStandardService;
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
 * 卡口经纬度不规范统计Controller
 *
 * @author huitong
 * @date 2025-04-01
 */
@Controller
@RequestMapping("/business/devJwdNonStandard")
public class DevJwdNonStandardController extends BaseController
{
    private String prefix = "business/devJwdNonStandard";

    @Autowired
    private IDevJwdNonStandardService devJwdNonStandardService;

//    @RequiresPermissions("business:devJwdNonStandard:view")
    @GetMapping()
    public String devJwdNonStandard()
    {
        return prefix + "/devJwdNonStandard";
    }

    /**
     * 查询卡口经纬度不规范统计列表
     */
//    @RequiresPermissions("business:devJwdNonStandard:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody DevJwdNonStandard devJwdNonStandard)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
//        startPage(devJwdNonStandard.getPageNum(),devJwdNonStandard.getPageSize());
        List<DevJwdNonStandard> list = devJwdNonStandardService.selectDevJwdNonStandardLists(devJwdNonStandard);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出卡口经纬度不规范统计列表
     */
    @RequiresPermissions("business:devJwdNonStandard:export")
    @Log(title = "卡口经纬度不规范统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody DevJwdNonStandard devJwdNonStandard)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        List<DevJwdNonStandard> list = devJwdNonStandardService.selectDevJwdNonStandardLists(devJwdNonStandard);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<DevJwdNonStandard> util = new ExcelUtil<DevJwdNonStandard>(DevJwdNonStandard.class);
        return util.exportExcel(list, "卡口经纬度不规范统计数据");
    }
//
//    /**
//     * 导出卡口经纬度不规范统计数据
//     */
//    @RequiresPermissions("business:devJwdNonStandard:export")
//    @Log(title = "卡口经纬度不规范统计", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody DevJwdNonStandard devJwdNonStandard)
//    {
//        List<DevJwdNonStandard> list = devJwdNonStandardService.selectDevJwdNonStandardList(devJwdNonStandard);
//        ExcelUtil<DevJwdNonStandard> util = new ExcelUtil<DevJwdNonStandard>(DevJwdNonStandard.class);
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
//     * 新增卡口经纬度不规范统计
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存卡口经纬度不规范统计
//     */
//    @RequiresPermissions("business:devJwdNonStandard:add")
//    @Log(title = "卡口经纬度不规范统计", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody DevJwdNonStandard devJwdNonStandard)
//    {
//        devJwdNonStandard.setCreateBy(getLoginName());
//        return toAjax(devJwdNonStandardService.insertDevJwdNonStandard(devJwdNonStandard));
//    }
//
//    /**
//     * 修改卡口经纬度不规范统计
//     */
//    @RequiresPermissions("business:devJwdNonStandard:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        DevJwdNonStandard devJwdNonStandard = devJwdNonStandardService.selectDevJwdNonStandardById(id);
//        mmap.put("devJwdNonStandard", devJwdNonStandard);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存卡口经纬度不规范统计
//     */
//    @RequiresPermissions("business:devJwdNonStandard:edit")
//    @Log(title = "卡口经纬度不规范统计", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody DevJwdNonStandard devJwdNonStandard)
//    {
//        devJwdNonStandard.setUpdateBy(getLoginName());
//        return toAjax(devJwdNonStandardService.updateDevJwdNonStandard(devJwdNonStandard));
//    }
//
//    /**
//     * 删除卡口经纬度不规范统计
//     */
//    @RequiresPermissions("business:devJwdNonStandard:remove")
//    @Log(title = "卡口经纬度不规范统计", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(devJwdNonStandardService.deleteDevJwdNonStandardByIds(ids));
//    }
}
