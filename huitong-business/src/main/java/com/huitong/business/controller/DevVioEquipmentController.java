package com.huitong.business.controller;

import java.util.Date;
import java.util.List;

import com.huitong.business.domain.DevVioEquWarning;
import com.huitong.business.service.IDevVioEquWarningService;
import com.huitong.common.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import com.huitong.common.enums.BusinessType;
import com.huitong.business.domain.DevVioEquipment;
import com.huitong.business.service.IDevVioEquipmentService;
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
 * 设备信息Controller
 *
 * @author huitong
 * @date 2025-06-17
 */
@Controller
@RequestMapping("/business/devVioEquipment")
public class DevVioEquipmentController extends BaseController
{
    private String prefix = "business/devVioEquipment";

    private String prefix2 = "business";

    @Autowired
    private IDevVioEquipmentService devVioEquipmentService;
    @Autowired
    private IDevVioEquWarningService devVioEquWarningService;

    @RequiresPermissions("business:devVioEquipment:view")
    @GetMapping()
    public String devVioEquipment()
    {
        return prefix + "/devVioEquipment";
    }
    @GetMapping("/view/{yjlx}/{yjrq}")
    public String devVioEquipment(@PathVariable("yjlx") Long yjlx, @PathVariable("yjrq") Date yjrq, ModelMap mmap)
    {
        mmap.put("yjlx", yjlx.toString());
        mmap.put("yjrq", DateUtils.dateTime(yjrq));
        if ("1".equals(yjlx.toString())) {
            return prefix2 + "/yjAbnormalWarning/yjAbnormalWarning";
        } else if("7".equals(yjlx.toString())) {
            return prefix2 + "/yjEquipmentStatus/yjEquipmentStatus";
        } else if("5".equals(yjlx.toString()) || "6".equals(yjlx.toString())) {
            return prefix2 + "/yjAuditExceptions/yjAuditExceptions";
        } else {

            return prefix + "/devVioEquipment";
        }

    }

    @GetMapping("/getXq/{sbbh}/{sblx}")
    public String getXq(@PathVariable("sbbh") String sbbh, @PathVariable("sblx") String sblx, ModelMap mmap)
    {
        mmap.put("sbbh", sbbh);
        mmap.put("sblx", sblx);
        return prefix2 + "/yjExceptionDetails/yjExceptionDetails";
    }

    /**
     * 查询设备信息列表
     */
    @RequiresPermissions("business:devVioEquipment:list")
    @PostMapping("/xqList/{sbbh}")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo xqList(@PathVariable("sbbh") String sbbh, ModelMap mmap)
    {
        DevVioEquWarning devVioEquWarning = new DevVioEquWarning();
        devVioEquWarning.setSbbh(sbbh);
        System.out.println("=========devVioEquipment=========" + devVioEquWarning);
//        devVioEquWarning.setSbbh("37061300000005121");
        startPage();
        List<DevVioEquWarning> list = devVioEquWarningService.selectDevVioEquWarningLists(devVioEquWarning);
        System.out.println("===========list==========" + list);
        return getDataTable(list);
    }

    /**
     * 查询设备信息列表
     */
    @RequiresPermissions("business:devVioEquipment:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody DevVioEquipment devVioEquipment)
    {
        startPage(devVioEquipment.getPageNum(),devVioEquipment.getPageSize());
        List<DevVioEquipment> list;
        if ("1".equals(devVioEquipment.getSblx())) {    //抓拍量异常的列表
            list = devVioEquipmentService.selectDevVioEquipmentLists(devVioEquipment);
        } else {
            list = devVioEquipmentService.selectDevVioEquipmentList(devVioEquipment);
        }

        return getDataTable(list);
    }

    /**
     * 导出设备信息列表
     */
    @RequiresPermissions("business:devVioEquipment:export")
    @Log(title = "设备信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody DevVioEquipment devVioEquipment)
    {
        List<DevVioEquipment> list = devVioEquipmentService.selectDevVioEquipmentList(devVioEquipment);
        ExcelUtil<DevVioEquipment> util = new ExcelUtil<DevVioEquipment>(DevVioEquipment.class);
        return util.exportExcel(list, "设备信息数据");
    }

    /**
     * 导出设备信息数据
     */
    @RequiresPermissions("business:devVioEquipment:export")
    @Log(title = "设备信息", businessType = BusinessType.EXPORT)
    @PostMapping("/exportZip")
    @ResponseBody
    @Decrypt
    public AjaxResult exportZip(@RequestBody DevVioEquipment devVioEquipment)
    {
        List<DevVioEquipment> list = devVioEquipmentService.selectDevVioEquipmentList(devVioEquipment);
        ExcelUtil<DevVioEquipment> util = new ExcelUtil<DevVioEquipment>(DevVioEquipment.class);
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
     * 新增设备信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备信息
     */
    @RequiresPermissions("business:devVioEquipment:add")
    @Log(title = "设备信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    @Decrypt
    public AjaxResult addSave(@RequestBody DevVioEquipment devVioEquipment)
    {
        devVioEquipment.setCreateBy(getLoginName());
        return toAjax(devVioEquipmentService.insertDevVioEquipment(devVioEquipment));
    }

    /**
     * 修改设备信息
     */
    @RequiresPermissions("business:devVioEquipment:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DevVioEquipment devVioEquipment = devVioEquipmentService.selectDevVioEquipmentById(id);
        mmap.put("devVioEquipment", devVioEquipment);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备信息
     */
    @RequiresPermissions("business:devVioEquipment:edit")
    @Log(title = "设备信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    @Decrypt
    public AjaxResult editSave(@RequestBody DevVioEquipment devVioEquipment)
    {
        devVioEquipment.setUpdateBy(getLoginName());
        return toAjax(devVioEquipmentService.updateDevVioEquipment(devVioEquipment));
    }

    /**
     * 删除设备信息
     */
    @RequiresPermissions("business:devVioEquipment:remove")
    @Log(title = "设备信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    @Decrypt
    public AjaxResult remove(@RequestBody String ids)
    {
        return toAjax(devVioEquipmentService.deleteDevVioEquipmentByIds(ids));
    }
}
