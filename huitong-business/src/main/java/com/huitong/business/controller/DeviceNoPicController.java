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
import com.huitong.business.domain.DeviceNoPic;
import com.huitong.business.service.IDeviceNoPicService;
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
 * 执法设备无备案图片统计Controller
 *
 * @author huitong
 * @date 2025-04-01
 */
@Controller
@RequestMapping("/business/deviceNoPic")
public class DeviceNoPicController extends BaseController
{
    private String prefix = "business/deviceNoPic";

    @Autowired
    private IDeviceNoPicService deviceNoPicService;

//    @RequiresPermissions("business:deviceNoPic:view")
    @GetMapping()
    public String deviceNoPic()
    {
        return prefix + "/deviceNoPic";
    }

    /**
     * 查询执法设备无备案图片统计列表
     */
//    @RequiresPermissions("business:deviceNoPic:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody DeviceNoPic deviceNoPic)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
//        startPage(deviceNoPic.getPageNum(),deviceNoPic.getPageSize());
        List<DeviceNoPic> list = deviceNoPicService.selectDeviceNoPicLists(deviceNoPic);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出执法设备无备案图片统计列表
     */
    @RequiresPermissions("business:deviceNoPic:export")
    @Log(title = "执法设备无备案图片统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody DeviceNoPic deviceNoPic)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        List<DeviceNoPic> list = deviceNoPicService.selectDeviceNoPicLists(deviceNoPic);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<DeviceNoPic> util = new ExcelUtil<DeviceNoPic>(DeviceNoPic.class);
        return util.exportExcel(list, "执法设备无备案图片统计数据");
    }
//
//    /**
//     * 导出执法设备无备案图片统计数据
//     */
//    @RequiresPermissions("business:deviceNoPic:export")
//    @Log(title = "执法设备无备案图片统计", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody DeviceNoPic deviceNoPic)
//    {
//        List<DeviceNoPic> list = deviceNoPicService.selectDeviceNoPicList(deviceNoPic);
//        ExcelUtil<DeviceNoPic> util = new ExcelUtil<DeviceNoPic>(DeviceNoPic.class);
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
//     * 新增执法设备无备案图片统计
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存执法设备无备案图片统计
//     */
//    @RequiresPermissions("business:deviceNoPic:add")
//    @Log(title = "执法设备无备案图片统计", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody DeviceNoPic deviceNoPic)
//    {
//        deviceNoPic.setCreateBy(getLoginName());
//        return toAjax(deviceNoPicService.insertDeviceNoPic(deviceNoPic));
//    }
//
//    /**
//     * 修改执法设备无备案图片统计
//     */
//    @RequiresPermissions("business:deviceNoPic:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        DeviceNoPic deviceNoPic = deviceNoPicService.selectDeviceNoPicById(id);
//        mmap.put("deviceNoPic", deviceNoPic);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存执法设备无备案图片统计
//     */
//    @RequiresPermissions("business:deviceNoPic:edit")
//    @Log(title = "执法设备无备案图片统计", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody DeviceNoPic deviceNoPic)
//    {
//        deviceNoPic.setUpdateBy(getLoginName());
//        return toAjax(deviceNoPicService.updateDeviceNoPic(deviceNoPic));
//    }
//
//    /**
//     * 删除执法设备无备案图片统计
//     */
//    @RequiresPermissions("business:deviceNoPic:remove")
//    @Log(title = "执法设备无备案图片统计", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(deviceNoPicService.deleteDeviceNoPicByIds(ids));
//    }
}
