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
import com.huitong.business.domain.JczhFeiluCarQurey;
import com.huitong.business.service.IJczhFeiluCarQureyService;
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
 * 集成指挥平台查询非鲁车Controller
 *
 * @author huitong
 * @date 2025-05-15
 */
@Controller
@RequestMapping("/business/jczhFeiluCarQurey")
public class JczhFeiluCarQureyController extends BaseController
{
    private String prefix = "business/jczhFeiluCarQurey";

    @Autowired
    private IJczhFeiluCarQureyService jczhFeiluCarQureyService;

    @RequiresPermissions("business:jczhFeiluCarQurey:view")
    @GetMapping()
    public String jczhFeiluCarQurey()
    {
        return prefix + "/jczhFeiluCarQurey";
    }

    /**
     * 查询集成指挥平台查询非鲁车列表
     */
//    @RequiresPermissions("business:jczhFeiluCarQurey:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody JczhFeiluCarQurey jczhFeiluCarQurey)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
//        startPage(jczhFeiluCarQurey.getPageNum(),jczhFeiluCarQurey.getPageSize());
        List<JczhFeiluCarQurey> list = jczhFeiluCarQureyService.selectJczhFeiluCarQureyLists(jczhFeiluCarQurey);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出集成指挥平台查询非鲁车列表
     */
//    @RequiresPermissions("business:jczhFeiluCarQurey:export")
    @Log(title = "集成指挥平台查询非鲁车", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody JczhFeiluCarQurey jczhFeiluCarQurey)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        List<JczhFeiluCarQurey> list = jczhFeiluCarQureyService.selectJczhFeiluCarQureyLists(jczhFeiluCarQurey);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<JczhFeiluCarQurey> util = new ExcelUtil<JczhFeiluCarQurey>(JczhFeiluCarQurey.class);
        return util.exportExcel(list, "集成指挥平台查询非鲁车数据");
    }

//    /**
//     * 导出集成指挥平台查询非鲁车数据
//     */
//    @RequiresPermissions("business:jczhFeiluCarQurey:export")
//    @Log(title = "集成指挥平台查询非鲁车", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody JczhFeiluCarQurey jczhFeiluCarQurey)
//    {
//        List<JczhFeiluCarQurey> list = jczhFeiluCarQureyService.selectJczhFeiluCarQureyList(jczhFeiluCarQurey);
//        ExcelUtil<JczhFeiluCarQurey> util = new ExcelUtil<JczhFeiluCarQurey>(JczhFeiluCarQurey.class);
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
//     * 新增集成指挥平台查询非鲁车
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存集成指挥平台查询非鲁车
//     */
//    @RequiresPermissions("business:jczhFeiluCarQurey:add")
//    @Log(title = "集成指挥平台查询非鲁车", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody JczhFeiluCarQurey jczhFeiluCarQurey)
//    {
//        jczhFeiluCarQurey.setCreateBy(getLoginName());
//        return toAjax(jczhFeiluCarQureyService.insertJczhFeiluCarQurey(jczhFeiluCarQurey));
//    }
//
//    /**
//     * 修改集成指挥平台查询非鲁车
//     */
//    @RequiresPermissions("business:jczhFeiluCarQurey:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        JczhFeiluCarQurey jczhFeiluCarQurey = jczhFeiluCarQureyService.selectJczhFeiluCarQureyById(id);
//        mmap.put("jczhFeiluCarQurey", jczhFeiluCarQurey);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存集成指挥平台查询非鲁车
//     */
//    @RequiresPermissions("business:jczhFeiluCarQurey:edit")
//    @Log(title = "集成指挥平台查询非鲁车", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody JczhFeiluCarQurey jczhFeiluCarQurey)
//    {
//        jczhFeiluCarQurey.setUpdateBy(getLoginName());
//        return toAjax(jczhFeiluCarQureyService.updateJczhFeiluCarQurey(jczhFeiluCarQurey));
//    }
//
//    /**
//     * 删除集成指挥平台查询非鲁车
//     */
//    @RequiresPermissions("business:jczhFeiluCarQurey:remove")
//    @Log(title = "集成指挥平台查询非鲁车", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(jczhFeiluCarQureyService.deleteJczhFeiluCarQureyByIds(ids));
//    }
}
