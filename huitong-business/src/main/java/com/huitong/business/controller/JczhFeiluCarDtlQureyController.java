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
import com.huitong.business.domain.JczhFeiluCarDtlQurey;
import com.huitong.business.service.IJczhFeiluCarDtlQureyService;
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
 * 集成指挥平台查询非鲁车明细Controller
 *
 * @author huitong
 * @date 2025-05-15
 */
@Controller
@RequestMapping("/business/jczhFeiluCarDtlQurey")
public class JczhFeiluCarDtlQureyController extends BaseController
{
    private String prefix = "business/jczhFeiluCarDtlQurey";

    @Autowired
    private IJczhFeiluCarDtlQureyService jczhFeiluCarDtlQureyService;

    @RequiresPermissions("business:jczhFeiluCarDtlQurey:view")
    @GetMapping()
    public String jczhFeiluCarDtlQurey()
    {
        return prefix + "/jczhFeiluCarDtlQurey";
    }

    /**
     * 查询集成指挥平台查询非鲁车明细列表
     */
//    @RequiresPermissions("business:jczhFeiluCarDtlQurey:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody JczhFeiluCarDtlQurey jczhFeiluCarDtlQurey)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
//        startPage(jczhFeiluCarDtlQurey.getPageNum(),jczhFeiluCarDtlQurey.getPageSize());
        List<JczhFeiluCarDtlQurey> list = jczhFeiluCarDtlQureyService.selectJczhFeiluCarDtlQureyLists(jczhFeiluCarDtlQurey);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出集成指挥平台查询非鲁车明细列表
     */
//    @RequiresPermissions("business:jczhFeiluCarDtlQurey:export")
    @Log(title = "集成指挥平台查询非鲁车明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody JczhFeiluCarDtlQurey jczhFeiluCarDtlQurey)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        List<JczhFeiluCarDtlQurey> list = jczhFeiluCarDtlQureyService.selectJczhFeiluCarDtlQureyLists(jczhFeiluCarDtlQurey);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<JczhFeiluCarDtlQurey> util = new ExcelUtil<JczhFeiluCarDtlQurey>(JczhFeiluCarDtlQurey.class);
        return util.exportExcel(list, "集成指挥平台查询非鲁车明细数据");
    }

//    /**
//     * 导出集成指挥平台查询非鲁车明细数据
//     */
//    @RequiresPermissions("business:jczhFeiluCarDtlQurey:export")
//    @Log(title = "集成指挥平台查询非鲁车明细", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody JczhFeiluCarDtlQurey jczhFeiluCarDtlQurey)
//    {
//        List<JczhFeiluCarDtlQurey> list = jczhFeiluCarDtlQureyService.selectJczhFeiluCarDtlQureyList(jczhFeiluCarDtlQurey);
//        ExcelUtil<JczhFeiluCarDtlQurey> util = new ExcelUtil<JczhFeiluCarDtlQurey>(JczhFeiluCarDtlQurey.class);
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
//     * 新增集成指挥平台查询非鲁车明细
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存集成指挥平台查询非鲁车明细
//     */
//    @RequiresPermissions("business:jczhFeiluCarDtlQurey:add")
//    @Log(title = "集成指挥平台查询非鲁车明细", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody JczhFeiluCarDtlQurey jczhFeiluCarDtlQurey)
//    {
//        jczhFeiluCarDtlQurey.setCreateBy(getLoginName());
//        return toAjax(jczhFeiluCarDtlQureyService.insertJczhFeiluCarDtlQurey(jczhFeiluCarDtlQurey));
//    }
//
//    /**
//     * 修改集成指挥平台查询非鲁车明细
//     */
//    @RequiresPermissions("business:jczhFeiluCarDtlQurey:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        JczhFeiluCarDtlQurey jczhFeiluCarDtlQurey = jczhFeiluCarDtlQureyService.selectJczhFeiluCarDtlQureyById(id);
//        mmap.put("jczhFeiluCarDtlQurey", jczhFeiluCarDtlQurey);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存集成指挥平台查询非鲁车明细
//     */
//    @RequiresPermissions("business:jczhFeiluCarDtlQurey:edit")
//    @Log(title = "集成指挥平台查询非鲁车明细", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody JczhFeiluCarDtlQurey jczhFeiluCarDtlQurey)
//    {
//        jczhFeiluCarDtlQurey.setUpdateBy(getLoginName());
//        return toAjax(jczhFeiluCarDtlQureyService.updateJczhFeiluCarDtlQurey(jczhFeiluCarDtlQurey));
//    }
//
//    /**
//     * 删除集成指挥平台查询非鲁车明细
//     */
//    @RequiresPermissions("business:jczhFeiluCarDtlQurey:remove")
//    @Log(title = "集成指挥平台查询非鲁车明细", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(jczhFeiluCarDtlQureyService.deleteJczhFeiluCarDtlQureyByIds(ids));
//    }
}
