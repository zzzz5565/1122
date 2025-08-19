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
import com.huitong.business.domain.PassCarQurey;
import com.huitong.business.service.IPassCarQureyService;
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
 * 云平台过车查询Controller
 *
 * @author huitong
 * @date 2025-04-09
 */
@Controller
@RequestMapping("/business/passCarQurey")
public class PassCarQureyController extends BaseController
{
    private String prefix = "business/passCarQurey";

    @Autowired
    private IPassCarQureyService passCarQureyService;

//    @RequiresPermissions("business:passCarQurey:view")
    @GetMapping()
    public String passCarQurey()
    {
        return prefix + "/passCarQurey";
    }
    @GetMapping("/nonWorkingTime")
    public String nonWorkingTimeQurey()
    {
        return prefix + "/nonWorkingTimeQuery";
    }
    /**
     * 查询云平台过车查询列表
     */
//    @RequiresPermissions("business:passCarQurey:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody PassCarQurey passCarQurey)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE3.name());
//        startPage(passCarQurey.getPageNum(),passCarQurey.getPageSize());
        List<PassCarQurey> list = passCarQureyService.selectPassCarQureyLists(passCarQurey);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    @PostMapping("/list2")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list2(@RequestBody PassCarQurey passCarQurey)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE3.name());
        List<PassCarQurey> list = passCarQureyService.selectPassCarQureyLists2(passCarQurey);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

//    /**
//     * 导出云平台过车查询列表
//     */
//    @RequiresPermissions("business:passCarQurey:export")
//    @Log(title = "云平台过车查询", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult export(@RequestBody PassCarQurey passCarQurey)
//    {
//        List<PassCarQurey> list = passCarQureyService.selectPassCarQureyList(passCarQurey);
//        ExcelUtil<PassCarQurey> util = new ExcelUtil<PassCarQurey>(PassCarQurey.class);
//        return util.exportExcel(list, "云平台过车查询数据");
//    }
//
//    /**
//     * 导出云平台过车查询数据
//     */
//    @RequiresPermissions("business:passCarQurey:export")
//    @Log(title = "云平台过车查询", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody PassCarQurey passCarQurey)
//    {
//        List<PassCarQurey> list = passCarQureyService.selectPassCarQureyList(passCarQurey);
//        ExcelUtil<PassCarQurey> util = new ExcelUtil<PassCarQurey>(PassCarQurey.class);
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
//     * 新增云平台过车查询
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存云平台过车查询
//     */
//    @RequiresPermissions("business:passCarQurey:add")
//    @Log(title = "云平台过车查询", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody PassCarQurey passCarQurey)
//    {
//        passCarQurey.setCreateBy(getLoginName());
//        return toAjax(passCarQureyService.insertPassCarQurey(passCarQurey));
//    }
//
//    /**
//     * 修改云平台过车查询
//     */
//    @RequiresPermissions("business:passCarQurey:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        PassCarQurey passCarQurey = passCarQureyService.selectPassCarQureyById(id);
//        mmap.put("passCarQurey", passCarQurey);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存云平台过车查询
//     */
//    @RequiresPermissions("business:passCarQurey:edit")
//    @Log(title = "云平台过车查询", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody PassCarQurey passCarQurey)
//    {
//        passCarQurey.setUpdateBy(getLoginName());
//        return toAjax(passCarQureyService.updatePassCarQurey(passCarQurey));
//    }
//
//    /**
//     * 删除云平台过车查询
//     */
//    @RequiresPermissions("business:passCarQurey:remove")
//    @Log(title = "云平台过车查询", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(passCarQureyService.deletePassCarQureyByIds(ids));
//    }
}
