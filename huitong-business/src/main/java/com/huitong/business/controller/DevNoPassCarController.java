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
import com.huitong.business.domain.DevNoPassCar;
import com.huitong.business.service.IDevNoPassCarService;
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
 * 无过车数据卡口信息统计Controller
 *
 * @author hairun
 * @date 2025-03-20
 */
@Controller
@RequestMapping("/business/devNoPassCar")
public class DevNoPassCarController extends BaseController
{
    private String prefix = "business/devNoPassCar";

    @Autowired
    private IDevNoPassCarService devNoPassCarService;

//    @RequiresPermissions("business:devNoPassCar:view")
    @GetMapping()
    public String devNoPassCar()
    {
        return prefix + "/devNoPassCar";
    }

    /**
     * 查询无过车数据卡口信息统计列表
     */
//    @RequiresPermissions("business:devNoPassCar:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody DevNoPassCar devNoPassCar)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
//        startPage(devNoPassCar.getPageNum(),devNoPassCar.getPageSize());
        List<DevNoPassCar> list = devNoPassCarService.selectDevNoPassCarLists(devNoPassCar);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出无过车数据卡口信息统计列表
     */
    @RequiresPermissions("business:devNoPassCar:export")
    @Log(title = "无过车数据卡口信息统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody DevNoPassCar devNoPassCar)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        List<DevNoPassCar> list = devNoPassCarService.selectDevNoPassCarLists(devNoPassCar);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<DevNoPassCar> util = new ExcelUtil<DevNoPassCar>(DevNoPassCar.class);
        return util.exportExcel(list, "无过车数据卡口信息统计数据");
    }
//
//    /**
//     * 导出无过车数据卡口信息统计数据
//     */
//    @RequiresPermissions("business:devNoPassCar:export")
//    @Log(title = "无过车数据卡口信息统计", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody DevNoPassCar devNoPassCar)
//    {
//        List<DevNoPassCar> list = devNoPassCarService.selectDevNoPassCarList(devNoPassCar);
//        ExcelUtil<DevNoPassCar> util = new ExcelUtil<DevNoPassCar>(DevNoPassCar.class);
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
//     * 新增无过车数据卡口信息统计
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存无过车数据卡口信息统计
//     */
//    @RequiresPermissions("business:devNoPassCar:add")
//    @Log(title = "无过车数据卡口信息统计", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody DevNoPassCar devNoPassCar)
//    {
//        devNoPassCar.setCreateBy(getLoginName());
//        return toAjax(devNoPassCarService.insertDevNoPassCar(devNoPassCar));
//    }
//
//    /**
//     * 修改无过车数据卡口信息统计
//     */
//    @RequiresPermissions("business:devNoPassCar:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        DevNoPassCar devNoPassCar = devNoPassCarService.selectDevNoPassCarById(id);
//        mmap.put("devNoPassCar", devNoPassCar);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存无过车数据卡口信息统计
//     */
//    @RequiresPermissions("business:devNoPassCar:edit")
//    @Log(title = "无过车数据卡口信息统计", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody DevNoPassCar devNoPassCar)
//    {
//        devNoPassCar.setUpdateBy(getLoginName());
//        return toAjax(devNoPassCarService.updateDevNoPassCar(devNoPassCar));
//    }
//
//    /**
//     * 删除无过车数据卡口信息统计
//     */
//    @RequiresPermissions("business:devNoPassCar:remove")
//    @Log(title = "无过车数据卡口信息统计", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(devNoPassCarService.deleteDevNoPassCarByIds(ids));
//    }
}
