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
import com.huitong.business.domain.UploadTimelinessRate;
import com.huitong.business.service.IUploadTimelinessRateService;
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
 * 上传及时率统计Controller
 *
 * @author huitong
 * @date 2025-04-21
 */
@Controller
@RequestMapping("/business/uploadTimelinessRate")
public class UploadTimelinessRateController extends BaseController
{
    private String prefix = "business/uploadTimelinessRate";

    @Autowired
    private IUploadTimelinessRateService uploadTimelinessRateService;

    @RequiresPermissions("business:uploadTimelinessRate:view")
    @GetMapping()
    public String uploadTimelinessRate()
    {
        return prefix + "/uploadTimelinessRate";
    }

    /**
     * 查询上传及时率统计列表
     */
//    @RequiresPermissions("business:uploadTimelinessRate:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody UploadTimelinessRate uploadTimelinessRate)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
//        startPage(uploadTimelinessRate.getPageNum(),uploadTimelinessRate.getPageSize());
        List<UploadTimelinessRate> list = uploadTimelinessRateService.selectUploadTimelinessRateLists(uploadTimelinessRate);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出上传及时率统计列表
     */
//    @RequiresPermissions("business:uploadTimelinessRate:export")
    @Log(title = "上传及时率统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody UploadTimelinessRate uploadTimelinessRate)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        List<UploadTimelinessRate> list = uploadTimelinessRateService.selectUploadTimelinessRateLists(uploadTimelinessRate);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<UploadTimelinessRate> util = new ExcelUtil<UploadTimelinessRate>(UploadTimelinessRate.class);
        return util.exportExcel(list, "上传及时率统计数据");
    }

//    /**
//     * 导出上传及时率统计数据
//     */
//    @RequiresPermissions("business:uploadTimelinessRate:export")
//    @Log(title = "上传及时率统计", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody UploadTimelinessRate uploadTimelinessRate)
//    {
//        List<UploadTimelinessRate> list = uploadTimelinessRateService.selectUploadTimelinessRateList(uploadTimelinessRate);
//        ExcelUtil<UploadTimelinessRate> util = new ExcelUtil<UploadTimelinessRate>(UploadTimelinessRate.class);
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
//     * 新增上传及时率统计
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存上传及时率统计
//     */
//    @RequiresPermissions("business:uploadTimelinessRate:add")
//    @Log(title = "上传及时率统计", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody UploadTimelinessRate uploadTimelinessRate)
//    {
//        uploadTimelinessRate.setCreateBy(getLoginName());
//        return toAjax(uploadTimelinessRateService.insertUploadTimelinessRate(uploadTimelinessRate));
//    }
//
//    /**
//     * 修改上传及时率统计
//     */
//    @RequiresPermissions("business:uploadTimelinessRate:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        UploadTimelinessRate uploadTimelinessRate = uploadTimelinessRateService.selectUploadTimelinessRateById(id);
//        mmap.put("uploadTimelinessRate", uploadTimelinessRate);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存上传及时率统计
//     */
//    @RequiresPermissions("business:uploadTimelinessRate:edit")
//    @Log(title = "上传及时率统计", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody UploadTimelinessRate uploadTimelinessRate)
//    {
//        uploadTimelinessRate.setUpdateBy(getLoginName());
//        return toAjax(uploadTimelinessRateService.updateUploadTimelinessRate(uploadTimelinessRate));
//    }
//
//    /**
//     * 删除上传及时率统计
//     */
//    @RequiresPermissions("business:uploadTimelinessRate:remove")
//    @Log(title = "上传及时率统计", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(uploadTimelinessRateService.deleteUploadTimelinessRateByIds(ids));
//    }
}
