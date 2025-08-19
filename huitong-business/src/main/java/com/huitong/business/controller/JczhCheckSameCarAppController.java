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
import com.huitong.business.domain.JczhCheckSameCarApp;
import com.huitong.business.service.IJczhCheckSameCarAppService;
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
 * 反复查询同一辆车-app-带姓名警号Controller
 *
 * @author huitong
 * @date 2025-05-15
 */
@Controller
@RequestMapping("/business/jczhCheckSameCarApp")
public class JczhCheckSameCarAppController extends BaseController
{
    private String prefix = "business/jczhCheckSameCarApp";

    @Autowired
    private IJczhCheckSameCarAppService jczhCheckSameCarAppService;

    @RequiresPermissions("business:jczhCheckSameCarApp:view")
    @GetMapping()
    public String jczhCheckSameCarApp()
    {
        return prefix + "/jczhCheckSameCarApp";
    }

    /**
     * 查询反复查询同一辆车-app-带姓名警号列表
     */
//    @RequiresPermissions("business:jczhCheckSameCarApp:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody JczhCheckSameCarApp jczhCheckSameCarApp)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
//        startPage(jczhCheckSameCarApp.getPageNum(),jczhCheckSameCarApp.getPageSize());
        List<JczhCheckSameCarApp> list = jczhCheckSameCarAppService.selectJczhCheckSameCarAppLists(jczhCheckSameCarApp);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出反复查询同一辆车-app-带姓名警号列表
     */
//    @RequiresPermissions("business:jczhCheckSameCarApp:export")
    @Log(title = "反复查询同一辆车-app-带姓名警号", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody JczhCheckSameCarApp jczhCheckSameCarApp)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        List<JczhCheckSameCarApp> list = jczhCheckSameCarAppService.selectJczhCheckSameCarAppLists(jczhCheckSameCarApp);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<JczhCheckSameCarApp> util = new ExcelUtil<JczhCheckSameCarApp>(JczhCheckSameCarApp.class);
        return util.exportExcel(list, "反复查询同一辆车-app-带姓名警号数据");
    }

//    /**
//     * 导出反复查询同一辆车-app-带姓名警号数据
//     */
//    @RequiresPermissions("business:jczhCheckSameCarApp:export")
//    @Log(title = "反复查询同一辆车-app-带姓名警号", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody JczhCheckSameCarApp jczhCheckSameCarApp)
//    {
//        List<JczhCheckSameCarApp> list = jczhCheckSameCarAppService.selectJczhCheckSameCarAppList(jczhCheckSameCarApp);
//        ExcelUtil<JczhCheckSameCarApp> util = new ExcelUtil<JczhCheckSameCarApp>(JczhCheckSameCarApp.class);
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
//     * 新增反复查询同一辆车-app-带姓名警号
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存反复查询同一辆车-app-带姓名警号
//     */
//    @RequiresPermissions("business:jczhCheckSameCarApp:add")
//    @Log(title = "反复查询同一辆车-app-带姓名警号", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody JczhCheckSameCarApp jczhCheckSameCarApp)
//    {
//        jczhCheckSameCarApp.setCreateBy(getLoginName());
//        return toAjax(jczhCheckSameCarAppService.insertJczhCheckSameCarApp(jczhCheckSameCarApp));
//    }
//
//    /**
//     * 修改反复查询同一辆车-app-带姓名警号
//     */
//    @RequiresPermissions("business:jczhCheckSameCarApp:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        JczhCheckSameCarApp jczhCheckSameCarApp = jczhCheckSameCarAppService.selectJczhCheckSameCarAppById(id);
//        mmap.put("jczhCheckSameCarApp", jczhCheckSameCarApp);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存反复查询同一辆车-app-带姓名警号
//     */
//    @RequiresPermissions("business:jczhCheckSameCarApp:edit")
//    @Log(title = "反复查询同一辆车-app-带姓名警号", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody JczhCheckSameCarApp jczhCheckSameCarApp)
//    {
//        jczhCheckSameCarApp.setUpdateBy(getLoginName());
//        return toAjax(jczhCheckSameCarAppService.updateJczhCheckSameCarApp(jczhCheckSameCarApp));
//    }
//
//    /**
//     * 删除反复查询同一辆车-app-带姓名警号
//     */
//    @RequiresPermissions("business:jczhCheckSameCarApp:remove")
//    @Log(title = "反复查询同一辆车-app-带姓名警号", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(jczhCheckSameCarAppService.deleteJczhCheckSameCarAppByIds(ids));
//    }
}
