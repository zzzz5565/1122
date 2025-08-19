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
import com.huitong.business.domain.JczhFeiluCarDtlQureyApp;
import com.huitong.business.service.IJczhFeiluCarDtlQureyAppService;
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
 * 集成指挥平台查询非鲁车明细-appController
 *
 * @author huitong
 * @date 2025-05-26
 */
@Controller
@RequestMapping("/business/jczhFeiluCarDtlQureyApp")
public class JczhFeiluCarDtlQureyAppController extends BaseController
{
    private String prefix = "business/jczhFeiluCarDtlQureyApp";

    @Autowired
    private IJczhFeiluCarDtlQureyAppService jczhFeiluCarDtlQureyAppService;

//    @RequiresPermissions("business:jczhFeiluCarDtlQureyApp:view")
    @GetMapping()
    public String jczhFeiluCarDtlQureyApp()
    {
        return prefix + "/jczhFeiluCarDtlQureyApp";
    }

    /**
     * 查询集成指挥平台查询非鲁车明细-app列表
     */
//    @RequiresPermissions("business:jczhFeiluCarDtlQureyApp:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody JczhFeiluCarDtlQureyApp jczhFeiluCarDtlQureyApp)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
//        startPage(jczhFeiluCarDtlQureyApp.getPageNum(),jczhFeiluCarDtlQureyApp.getPageSize());
        List<JczhFeiluCarDtlQureyApp> list = jczhFeiluCarDtlQureyAppService.selectJczhFeiluCarDtlQureyAppLists(jczhFeiluCarDtlQureyApp);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出集成指挥平台查询非鲁车明细-app列表
     */
//    @RequiresPermissions("business:jczhFeiluCarDtlQureyApp:export")
    @Log(title = "集成指挥平台查询非鲁车明细-app", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody JczhFeiluCarDtlQureyApp jczhFeiluCarDtlQureyApp)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        List<JczhFeiluCarDtlQureyApp> list = jczhFeiluCarDtlQureyAppService.selectJczhFeiluCarDtlQureyAppLists(jczhFeiluCarDtlQureyApp);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<JczhFeiluCarDtlQureyApp> util = new ExcelUtil<JczhFeiluCarDtlQureyApp>(JczhFeiluCarDtlQureyApp.class);
        return util.exportExcel(list, "集成指挥平台查询非鲁车明细-app数据");
    }

//    /**
//     * 导出集成指挥平台查询非鲁车明细-app数据
//     */
//    @RequiresPermissions("business:jczhFeiluCarDtlQureyApp:export")
//    @Log(title = "集成指挥平台查询非鲁车明细-app", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody JczhFeiluCarDtlQureyApp jczhFeiluCarDtlQureyApp)
//    {
//        List<JczhFeiluCarDtlQureyApp> list = jczhFeiluCarDtlQureyAppService.selectJczhFeiluCarDtlQureyAppList(jczhFeiluCarDtlQureyApp);
//        ExcelUtil<JczhFeiluCarDtlQureyApp> util = new ExcelUtil<JczhFeiluCarDtlQureyApp>(JczhFeiluCarDtlQureyApp.class);
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
//     * 新增集成指挥平台查询非鲁车明细-app
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存集成指挥平台查询非鲁车明细-app
//     */
//    @RequiresPermissions("business:jczhFeiluCarDtlQureyApp:add")
//    @Log(title = "集成指挥平台查询非鲁车明细-app", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody JczhFeiluCarDtlQureyApp jczhFeiluCarDtlQureyApp)
//    {
//        jczhFeiluCarDtlQureyApp.setCreateBy(getLoginName());
//        return toAjax(jczhFeiluCarDtlQureyAppService.insertJczhFeiluCarDtlQureyApp(jczhFeiluCarDtlQureyApp));
//    }
//
//    /**
//     * 修改集成指挥平台查询非鲁车明细-app
//     */
//    @RequiresPermissions("business:jczhFeiluCarDtlQureyApp:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        JczhFeiluCarDtlQureyApp jczhFeiluCarDtlQureyApp = jczhFeiluCarDtlQureyAppService.selectJczhFeiluCarDtlQureyAppById(id);
//        mmap.put("jczhFeiluCarDtlQureyApp", jczhFeiluCarDtlQureyApp);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存集成指挥平台查询非鲁车明细-app
//     */
//    @RequiresPermissions("business:jczhFeiluCarDtlQureyApp:edit")
//    @Log(title = "集成指挥平台查询非鲁车明细-app", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody JczhFeiluCarDtlQureyApp jczhFeiluCarDtlQureyApp)
//    {
//        jczhFeiluCarDtlQureyApp.setUpdateBy(getLoginName());
//        return toAjax(jczhFeiluCarDtlQureyAppService.updateJczhFeiluCarDtlQureyApp(jczhFeiluCarDtlQureyApp));
//    }
//
//    /**
//     * 删除集成指挥平台查询非鲁车明细-app
//     */
//    @RequiresPermissions("business:jczhFeiluCarDtlQureyApp:remove")
//    @Log(title = "集成指挥平台查询非鲁车明细-app", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(jczhFeiluCarDtlQureyAppService.deleteJczhFeiluCarDtlQureyAppByIds(ids));
//    }
}
