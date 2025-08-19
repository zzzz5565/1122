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
import com.huitong.business.domain.JczhCheckSameCarWebDtl;
import com.huitong.business.service.IJczhCheckSameCarWebDtlService;
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
 * 反复查询同一辆车-web个人查询明细Controller
 *
 * @author huitong
 * @date 2025-05-15
 */
@Controller
@RequestMapping("/business/jczhCheckSameCarWebDtl")
public class JczhCheckSameCarWebDtlController extends BaseController
{
    private String prefix = "business/jczhCheckSameCarWebDtl";

    @Autowired
    private IJczhCheckSameCarWebDtlService jczhCheckSameCarWebDtlService;

    @RequiresPermissions("business:jczhCheckSameCarWebDtl:view")
    @GetMapping()
    public String jczhCheckSameCarWebDtl()
    {
        return prefix + "/jczhCheckSameCarWebDtl";
    }

    /**
     * 查询反复查询同一辆车-web个人查询明细列表
     */
//    @RequiresPermissions("business:jczhCheckSameCarWebDtl:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody JczhCheckSameCarWebDtl jczhCheckSameCarWebDtl)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
//        startPage(jczhCheckSameCarWebDtl.getPageNum(),jczhCheckSameCarWebDtl.getPageSize());
        List<JczhCheckSameCarWebDtl> list = jczhCheckSameCarWebDtlService.selectJczhCheckSameCarWebDtlLists(jczhCheckSameCarWebDtl);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出反复查询同一辆车-web个人查询明细列表
     */
//    @RequiresPermissions("business:jczhCheckSameCarWebDtl:export")
    @Log(title = "反复查询同一辆车-web个人查询明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody JczhCheckSameCarWebDtl jczhCheckSameCarWebDtl)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        List<JczhCheckSameCarWebDtl> list = jczhCheckSameCarWebDtlService.selectJczhCheckSameCarWebDtlLists(jczhCheckSameCarWebDtl);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<JczhCheckSameCarWebDtl> util = new ExcelUtil<JczhCheckSameCarWebDtl>(JczhCheckSameCarWebDtl.class);
        return util.exportExcel(list, "反复查询同一辆车-web个人查询明细数据");
    }

//    /**
//     * 导出反复查询同一辆车-web个人查询明细数据
//     */
//    @RequiresPermissions("business:jczhCheckSameCarWebDtl:export")
//    @Log(title = "反复查询同一辆车-web个人查询明细", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody JczhCheckSameCarWebDtl jczhCheckSameCarWebDtl)
//    {
//        List<JczhCheckSameCarWebDtl> list = jczhCheckSameCarWebDtlService.selectJczhCheckSameCarWebDtlList(jczhCheckSameCarWebDtl);
//        ExcelUtil<JczhCheckSameCarWebDtl> util = new ExcelUtil<JczhCheckSameCarWebDtl>(JczhCheckSameCarWebDtl.class);
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
//     * 新增反复查询同一辆车-web个人查询明细
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存反复查询同一辆车-web个人查询明细
//     */
//    @RequiresPermissions("business:jczhCheckSameCarWebDtl:add")
//    @Log(title = "反复查询同一辆车-web个人查询明细", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody JczhCheckSameCarWebDtl jczhCheckSameCarWebDtl)
//    {
//        jczhCheckSameCarWebDtl.setCreateBy(getLoginName());
//        return toAjax(jczhCheckSameCarWebDtlService.insertJczhCheckSameCarWebDtl(jczhCheckSameCarWebDtl));
//    }
//
//    /**
//     * 修改反复查询同一辆车-web个人查询明细
//     */
//    @RequiresPermissions("business:jczhCheckSameCarWebDtl:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        JczhCheckSameCarWebDtl jczhCheckSameCarWebDtl = jczhCheckSameCarWebDtlService.selectJczhCheckSameCarWebDtlById(id);
//        mmap.put("jczhCheckSameCarWebDtl", jczhCheckSameCarWebDtl);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存反复查询同一辆车-web个人查询明细
//     */
//    @RequiresPermissions("business:jczhCheckSameCarWebDtl:edit")
//    @Log(title = "反复查询同一辆车-web个人查询明细", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody JczhCheckSameCarWebDtl jczhCheckSameCarWebDtl)
//    {
//        jczhCheckSameCarWebDtl.setUpdateBy(getLoginName());
//        return toAjax(jczhCheckSameCarWebDtlService.updateJczhCheckSameCarWebDtl(jczhCheckSameCarWebDtl));
//    }
//
//    /**
//     * 删除反复查询同一辆车-web个人查询明细
//     */
//    @RequiresPermissions("business:jczhCheckSameCarWebDtl:remove")
//    @Log(title = "反复查询同一辆车-web个人查询明细", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(jczhCheckSameCarWebDtlService.deleteJczhCheckSameCarWebDtlByIds(ids));
//    }
}
