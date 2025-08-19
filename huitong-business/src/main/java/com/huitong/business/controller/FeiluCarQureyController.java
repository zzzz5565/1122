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
import com.huitong.business.domain.FeiluCarQurey;
import com.huitong.business.service.IFeiluCarQureyService;
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
 * 查询非鲁车Controller
 *
 * @author huitong
 * @date 2025-04-09
 */
@Controller
@RequestMapping("/business/feiluCarQurey")
public class FeiluCarQureyController extends BaseController
{
    private String prefix = "business/feiluCarQurey";

    @Autowired
    private IFeiluCarQureyService feiluCarQureyService;

//    @RequiresPermissions("business:feiluCarQurey:view")
    @GetMapping()
    public String feiluCarQurey()
    {
        return prefix + "/feiluCarQurey";
    }

    /**
     * 查询查询非鲁车列表
     */
//    @RequiresPermissions("business:feiluCarQurey:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody FeiluCarQurey feiluCarQurey)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE3.name());
//        startPage(feiluCarQurey.getPageNum(),feiluCarQurey.getPageSize());
        List<FeiluCarQurey> list = feiluCarQureyService.selectFeiluCarQureyLists(feiluCarQurey);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出查询非鲁车列表
     */
    @RequiresPermissions("business:feiluCarQurey:export")
    @Log(title = "查询非鲁车", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody FeiluCarQurey feiluCarQurey)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE3.name());
//        startPage(feiluCarQurey.getPageNum(),feiluCarQurey.getPageSize());
        List<FeiluCarQurey> list = feiluCarQureyService.selectFeiluCarQureyLists(feiluCarQurey);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<FeiluCarQurey> util = new ExcelUtil<FeiluCarQurey>(FeiluCarQurey.class);
        return util.exportExcel(list, "查询非鲁车数据");
    }
//
//    /**
//     * 导出查询非鲁车数据
//     */
//    @RequiresPermissions("business:feiluCarQurey:export")
//    @Log(title = "查询非鲁车", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody FeiluCarQurey feiluCarQurey)
//    {
//        List<FeiluCarQurey> list = feiluCarQureyService.selectFeiluCarQureyList(feiluCarQurey);
//        ExcelUtil<FeiluCarQurey> util = new ExcelUtil<FeiluCarQurey>(FeiluCarQurey.class);
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
//     * 新增查询非鲁车
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存查询非鲁车
//     */
//    @RequiresPermissions("business:feiluCarQurey:add")
//    @Log(title = "查询非鲁车", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody FeiluCarQurey feiluCarQurey)
//    {
//        feiluCarQurey.setCreateBy(getLoginName());
//        return toAjax(feiluCarQureyService.insertFeiluCarQurey(feiluCarQurey));
//    }
//
//    /**
//     * 修改查询非鲁车
//     */
//    @RequiresPermissions("business:feiluCarQurey:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        FeiluCarQurey feiluCarQurey = feiluCarQureyService.selectFeiluCarQureyById(id);
//        mmap.put("feiluCarQurey", feiluCarQurey);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存查询非鲁车
//     */
//    @RequiresPermissions("business:feiluCarQurey:edit")
//    @Log(title = "查询非鲁车", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody FeiluCarQurey feiluCarQurey)
//    {
//        feiluCarQurey.setUpdateBy(getLoginName());
//        return toAjax(feiluCarQureyService.updateFeiluCarQurey(feiluCarQurey));
//    }
//
//    /**
//     * 删除查询非鲁车
//     */
//    @RequiresPermissions("business:feiluCarQurey:remove")
//    @Log(title = "查询非鲁车", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(feiluCarQureyService.deleteFeiluCarQureyByIds(ids));
//    }
}
