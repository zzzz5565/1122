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
import com.huitong.business.domain.JczhFeiluCarQureyApp;
import com.huitong.business.service.IJczhFeiluCarQureyAppService;
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
 * 集成指挥平台查询非鲁车-appController
 *
 * @author huitong
 * @date 2025-05-26
 */
@Controller
@RequestMapping("/business/jczhFeiluCarQureyApp")
public class JczhFeiluCarQureyAppController extends BaseController
{
    private String prefix = "business/jczhFeiluCarQureyApp";

    @Autowired
    private IJczhFeiluCarQureyAppService jczhFeiluCarQureyAppService;

//    @RequiresPermissions("business:jczhFeiluCarQureyApp:view")
    @GetMapping()
    public String jczhFeiluCarQureyApp()
    {
        return prefix + "/jczhFeiluCarQureyApp";
    }

    /**
     * 查询集成指挥平台查询非鲁车-app列表
     */
//    @RequiresPermissions("business:jczhFeiluCarQureyApp:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody JczhFeiluCarQureyApp jczhFeiluCarQureyApp)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
//        startPage(jczhFeiluCarQureyApp.getPageNum(),jczhFeiluCarQureyApp.getPageSize());
        List<JczhFeiluCarQureyApp> list = jczhFeiluCarQureyAppService.selectJczhFeiluCarQureyAppLists(jczhFeiluCarQureyApp);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出集成指挥平台查询非鲁车-app列表
     */
//    @RequiresPermissions("business:jczhFeiluCarQureyApp:export")
    @Log(title = "集成指挥平台查询非鲁车-app", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody JczhFeiluCarQureyApp jczhFeiluCarQureyApp)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        List<JczhFeiluCarQureyApp> list = jczhFeiluCarQureyAppService.selectJczhFeiluCarQureyAppLists(jczhFeiluCarQureyApp);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<JczhFeiluCarQureyApp> util = new ExcelUtil<JczhFeiluCarQureyApp>(JczhFeiluCarQureyApp.class);
        return util.exportExcel(list, "集成指挥平台查询非鲁车-app数据");
    }

//    /**
//     * 导出集成指挥平台查询非鲁车-app数据
//     */
//    @RequiresPermissions("business:jczhFeiluCarQureyApp:export")
//    @Log(title = "集成指挥平台查询非鲁车-app", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody JczhFeiluCarQureyApp jczhFeiluCarQureyApp)
//    {
//        List<JczhFeiluCarQureyApp> list = jczhFeiluCarQureyAppService.selectJczhFeiluCarQureyAppList(jczhFeiluCarQureyApp);
//        ExcelUtil<JczhFeiluCarQureyApp> util = new ExcelUtil<JczhFeiluCarQureyApp>(JczhFeiluCarQureyApp.class);
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
//     * 新增集成指挥平台查询非鲁车-app
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存集成指挥平台查询非鲁车-app
//     */
//    @RequiresPermissions("business:jczhFeiluCarQureyApp:add")
//    @Log(title = "集成指挥平台查询非鲁车-app", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody JczhFeiluCarQureyApp jczhFeiluCarQureyApp)
//    {
//        jczhFeiluCarQureyApp.setCreateBy(getLoginName());
//        return toAjax(jczhFeiluCarQureyAppService.insertJczhFeiluCarQureyApp(jczhFeiluCarQureyApp));
//    }
//
//    /**
//     * 修改集成指挥平台查询非鲁车-app
//     */
//    @RequiresPermissions("business:jczhFeiluCarQureyApp:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        JczhFeiluCarQureyApp jczhFeiluCarQureyApp = jczhFeiluCarQureyAppService.selectJczhFeiluCarQureyAppById(id);
//        mmap.put("jczhFeiluCarQureyApp", jczhFeiluCarQureyApp);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存集成指挥平台查询非鲁车-app
//     */
//    @RequiresPermissions("business:jczhFeiluCarQureyApp:edit")
//    @Log(title = "集成指挥平台查询非鲁车-app", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody JczhFeiluCarQureyApp jczhFeiluCarQureyApp)
//    {
//        jczhFeiluCarQureyApp.setUpdateBy(getLoginName());
//        return toAjax(jczhFeiluCarQureyAppService.updateJczhFeiluCarQureyApp(jczhFeiluCarQureyApp));
//    }
//
//    /**
//     * 删除集成指挥平台查询非鲁车-app
//     */
//    @RequiresPermissions("business:jczhFeiluCarQureyApp:remove")
//    @Log(title = "集成指挥平台查询非鲁车-app", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(jczhFeiluCarQureyAppService.deleteJczhFeiluCarQureyAppByIds(ids));
//    }
}
