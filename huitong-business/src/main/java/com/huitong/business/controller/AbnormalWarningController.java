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
import com.huitong.business.domain.AbnormalWarning;
import com.huitong.business.service.IAbnormalWarningService;
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
 * 违法数据异常预警统计Controller
 *
 * @author huitong
 * @date 2025-04-14
 */
@Controller
@RequestMapping("/business/abnormalWarning")
public class AbnormalWarningController extends BaseController
{
    private String prefix = "business/abnormalWarning";

    @Autowired
    private IAbnormalWarningService abnormalWarningService;

//    @RequiresPermissions("business:abnormalWarning:view")
    @GetMapping()
    public String abnormalWarning()
    {
        return prefix + "/abnormalWarning";
    }

    /**
     * 查询违法数据异常预警统计列表
     */
//    @RequiresPermissions("business:abnormalWarning:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody AbnormalWarning abnormalWarning)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
//        startPage(abnormalWarning.getPageNum(),abnormalWarning.getPageSize());
        List<AbnormalWarning> list = abnormalWarningService.selectAbnormalWarningLists(abnormalWarning);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出违法数据异常预警统计列表
     */
    @RequiresPermissions("business:abnormalWarning:export")
    @Log(title = "违法数据异常预警统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody AbnormalWarning abnormalWarning)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        List<AbnormalWarning> list = abnormalWarningService.selectAbnormalWarningLists(abnormalWarning);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<AbnormalWarning> util = new ExcelUtil<AbnormalWarning>(AbnormalWarning.class);
        return util.exportExcel(list, "违法数据异常预警统计数据");
    }
//
//    /**
//     * 导出违法数据异常预警统计数据
//     */
//    @RequiresPermissions("business:abnormalWarning:export")
//    @Log(title = "违法数据异常预警统计", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody AbnormalWarning abnormalWarning)
//    {
//        List<AbnormalWarning> list = abnormalWarningService.selectAbnormalWarningList(abnormalWarning);
//        ExcelUtil<AbnormalWarning> util = new ExcelUtil<AbnormalWarning>(AbnormalWarning.class);
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
//     * 新增违法数据异常预警统计
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存违法数据异常预警统计
//     */
//    @RequiresPermissions("business:abnormalWarning:add")
//    @Log(title = "违法数据异常预警统计", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody AbnormalWarning abnormalWarning)
//    {
//        abnormalWarning.setCreateBy(getLoginName());
//        return toAjax(abnormalWarningService.insertAbnormalWarning(abnormalWarning));
//    }
//
//    /**
//     * 修改违法数据异常预警统计
//     */
//    @RequiresPermissions("business:abnormalWarning:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        AbnormalWarning abnormalWarning = abnormalWarningService.selectAbnormalWarningById(id);
//        mmap.put("abnormalWarning", abnormalWarning);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存违法数据异常预警统计
//     */
//    @RequiresPermissions("business:abnormalWarning:edit")
//    @Log(title = "违法数据异常预警统计", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody AbnormalWarning abnormalWarning)
//    {
//        abnormalWarning.setUpdateBy(getLoginName());
//        return toAjax(abnormalWarningService.updateAbnormalWarning(abnormalWarning));
//    }
//
//    /**
//     * 删除违法数据异常预警统计
//     */
//    @RequiresPermissions("business:abnormalWarning:remove")
//    @Log(title = "违法数据异常预警统计", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(abnormalWarningService.deleteAbnormalWarningByIds(ids));
//    }
}
