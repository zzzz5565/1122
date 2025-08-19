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
import com.huitong.business.domain.EvidenceEquRecord;
import com.huitong.business.service.IEvidenceEquRecordService;
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
 * 执法取证设备备案统计Controller
 *
 * @author hairun
 * @date 2025-03-20
 */
@Controller
@RequestMapping("/business/evidenceEquRecord")
public class EvidenceEquRecordController extends BaseController
{
    private String prefix = "business/evidenceEquRecord";

    @Autowired
    private IEvidenceEquRecordService evidenceEquRecordService;

//    @RequiresPermissions("business:evidenceEquRecord:view")
    @GetMapping()
    public String evidenceEquRecord()
    {
        return prefix + "/evidenceEquRecord";
    }

    /**
     * 查询执法取证设备备案统计列表
     */
//    @RequiresPermissions("business:evidenceEquRecord:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody EvidenceEquRecord evidenceEquRecord)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
//        startPage(evidenceEquRecord.getPageNum(),evidenceEquRecord.getPageSize());
        List<EvidenceEquRecord> list = evidenceEquRecordService.selectEvidenceEquRecordLists(evidenceEquRecord);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出执法取证设备备案统计列表
     */
    @RequiresPermissions("business:evidenceEquRecord:export")
    @Log(title = "执法取证设备备案统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody EvidenceEquRecord evidenceEquRecord)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        List<EvidenceEquRecord> list = evidenceEquRecordService.selectEvidenceEquRecordLists(evidenceEquRecord);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<EvidenceEquRecord> util = new ExcelUtil<EvidenceEquRecord>(EvidenceEquRecord.class);
        return util.exportExcel(list, "执法取证设备备案统计数据");
    }
//
//    /**
//     * 导出执法取证设备备案统计数据
//     */
//    @RequiresPermissions("business:evidenceEquRecord:export")
//    @Log(title = "执法取证设备备案统计", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody EvidenceEquRecord evidenceEquRecord)
//    {
//        List<EvidenceEquRecord> list = evidenceEquRecordService.selectEvidenceEquRecordList(evidenceEquRecord);
//        ExcelUtil<EvidenceEquRecord> util = new ExcelUtil<EvidenceEquRecord>(EvidenceEquRecord.class);
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
//     * 新增执法取证设备备案统计
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存执法取证设备备案统计
//     */
//    @RequiresPermissions("business:evidenceEquRecord:add")
//    @Log(title = "执法取证设备备案统计", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody EvidenceEquRecord evidenceEquRecord)
//    {
//        evidenceEquRecord.setCreateBy(getLoginName());
//        return toAjax(evidenceEquRecordService.insertEvidenceEquRecord(evidenceEquRecord));
//    }
//
//    /**
//     * 修改执法取证设备备案统计
//     */
//    @RequiresPermissions("business:evidenceEquRecord:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        EvidenceEquRecord evidenceEquRecord = evidenceEquRecordService.selectEvidenceEquRecordById(id);
//        mmap.put("evidenceEquRecord", evidenceEquRecord);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存执法取证设备备案统计
//     */
//    @RequiresPermissions("business:evidenceEquRecord:edit")
//    @Log(title = "执法取证设备备案统计", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody EvidenceEquRecord evidenceEquRecord)
//    {
//        evidenceEquRecord.setUpdateBy(getLoginName());
//        return toAjax(evidenceEquRecordService.updateEvidenceEquRecord(evidenceEquRecord));
//    }
//
//    /**
//     * 删除执法取证设备备案统计
//     */
//    @RequiresPermissions("business:evidenceEquRecord:remove")
//    @Log(title = "执法取证设备备案统计", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(evidenceEquRecordService.deleteEvidenceEquRecordByIds(ids));
//    }
}
