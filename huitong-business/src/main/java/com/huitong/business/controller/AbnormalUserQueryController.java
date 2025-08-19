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
import com.huitong.business.domain.AbnormalUserQuery;
import com.huitong.business.service.IAbnormalUserQueryService;
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
 * 车辆查询异常用户Controller
 *
 * @author huitong
 * @date 2025-04-07
 */
@Controller
@RequestMapping("/business/abnormalUserQuery")
public class AbnormalUserQueryController extends BaseController
{
    private String prefix = "business/abnormalUserQuery";

    @Autowired
    private IAbnormalUserQueryService abnormalUserQueryService;

//    @RequiresPermissions("business:abnormalUserQuery:view")
    @GetMapping()
    public String abnormalUserQuery()
    {
        return prefix + "/abnormalUserQuery";
    }

    /**
     * 查询车辆查询异常用户列表
     */
//    @RequiresPermissions("business:abnormalUserQuery:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody AbnormalUserQuery abnormalUserQuery)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE2.name());
//        startPage(abnormalUserQuery.getPageNum(),abnormalUserQuery.getPageSize());
        List<AbnormalUserQuery> list = abnormalUserQueryService.selectAbnormalUserQueryLists(abnormalUserQuery);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出车辆查询异常用户列表
     */
    @RequiresPermissions("business:abnormalUserQuery:export")
    @Log(title = "车辆查询异常用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody AbnormalUserQuery abnormalUserQuery)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE2.name());
//        startPage(abnormalUserQuery.getPageNum(),abnormalUserQuery.getPageSize());
        List<AbnormalUserQuery> list = abnormalUserQueryService.selectAbnormalUserQueryLists(abnormalUserQuery);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<AbnormalUserQuery> util = new ExcelUtil<AbnormalUserQuery>(AbnormalUserQuery.class);
        return util.exportExcel(list, "车辆查询异常用户数据");
    }
//
//    /**
//     * 导出车辆查询异常用户数据
//     */
//    @RequiresPermissions("business:abnormalUserQuery:export")
//    @Log(title = "车辆查询异常用户", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody AbnormalUserQuery abnormalUserQuery)
//    {
//        List<AbnormalUserQuery> list = abnormalUserQueryService.selectAbnormalUserQueryList(abnormalUserQuery);
//        ExcelUtil<AbnormalUserQuery> util = new ExcelUtil<AbnormalUserQuery>(AbnormalUserQuery.class);
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
//     * 新增车辆查询异常用户
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存车辆查询异常用户
//     */
//    @RequiresPermissions("business:abnormalUserQuery:add")
//    @Log(title = "车辆查询异常用户", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody AbnormalUserQuery abnormalUserQuery)
//    {
//        abnormalUserQuery.setCreateBy(getLoginName());
//        return toAjax(abnormalUserQueryService.insertAbnormalUserQuery(abnormalUserQuery));
//    }
//
//    /**
//     * 修改车辆查询异常用户
//     */
//    @RequiresPermissions("business:abnormalUserQuery:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        AbnormalUserQuery abnormalUserQuery = abnormalUserQueryService.selectAbnormalUserQueryById(id);
//        mmap.put("abnormalUserQuery", abnormalUserQuery);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存车辆查询异常用户
//     */
//    @RequiresPermissions("business:abnormalUserQuery:edit")
//    @Log(title = "车辆查询异常用户", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody AbnormalUserQuery abnormalUserQuery)
//    {
//        abnormalUserQuery.setUpdateBy(getLoginName());
//        return toAjax(abnormalUserQueryService.updateAbnormalUserQuery(abnormalUserQuery));
//    }
//
//    /**
//     * 删除车辆查询异常用户
//     */
//    @RequiresPermissions("business:abnormalUserQuery:remove")
//    @Log(title = "车辆查询异常用户", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(abnormalUserQueryService.deleteAbnormalUserQueryByIds(ids));
//    }
}
