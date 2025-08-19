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
import com.huitong.business.domain.JczhCheckSameCarWeb;
import com.huitong.business.service.IJczhCheckSameCarWebService;
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
 * 反复查询同一辆车-webController
 *
 * @author huitong
 * @date 2025-05-15
 */
@Controller
@RequestMapping("/business/jczhCheckSameCarWeb")
public class JczhCheckSameCarWebController extends BaseController
{
    private String prefix = "business/jczhCheckSameCarWeb";

    @Autowired
    private IJczhCheckSameCarWebService jczhCheckSameCarWebService;

    @RequiresPermissions("business:jczhCheckSameCarWeb:view")
    @GetMapping()
    public String jczhCheckSameCarWeb()
    {
        return prefix + "/jczhCheckSameCarWeb";
    }

    /**
     * 查询反复查询同一辆车-web列表
     */
//    @RequiresPermissions("business:jczhCheckSameCarWeb:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody JczhCheckSameCarWeb jczhCheckSameCarWeb)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
//        startPage(jczhCheckSameCarWeb.getPageNum(),jczhCheckSameCarWeb.getPageSize());
        List<JczhCheckSameCarWeb> list = jczhCheckSameCarWebService.selectJczhCheckSameCarWebLists(jczhCheckSameCarWeb);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出反复查询同一辆车-web列表
     */
//    @RequiresPermissions("business:jczhCheckSameCarWeb:export")
    @Log(title = "反复查询同一辆车-web", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody JczhCheckSameCarWeb jczhCheckSameCarWeb)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        List<JczhCheckSameCarWeb> list = jczhCheckSameCarWebService.selectJczhCheckSameCarWebLists(jczhCheckSameCarWeb);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<JczhCheckSameCarWeb> util = new ExcelUtil<JczhCheckSameCarWeb>(JczhCheckSameCarWeb.class);
        return util.exportExcel(list, "反复查询同一辆车-web数据");
    }

//    /**
//     * 导出反复查询同一辆车-web数据
//     */
//    @RequiresPermissions("business:jczhCheckSameCarWeb:export")
//    @Log(title = "反复查询同一辆车-web", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody JczhCheckSameCarWeb jczhCheckSameCarWeb)
//    {
//        List<JczhCheckSameCarWeb> list = jczhCheckSameCarWebService.selectJczhCheckSameCarWebList(jczhCheckSameCarWeb);
//        ExcelUtil<JczhCheckSameCarWeb> util = new ExcelUtil<JczhCheckSameCarWeb>(JczhCheckSameCarWeb.class);
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
//     * 新增反复查询同一辆车-web
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存反复查询同一辆车-web
//     */
//    @RequiresPermissions("business:jczhCheckSameCarWeb:add")
//    @Log(title = "反复查询同一辆车-web", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody JczhCheckSameCarWeb jczhCheckSameCarWeb)
//    {
//        jczhCheckSameCarWeb.setCreateBy(getLoginName());
//        return toAjax(jczhCheckSameCarWebService.insertJczhCheckSameCarWeb(jczhCheckSameCarWeb));
//    }
//
//    /**
//     * 修改反复查询同一辆车-web
//     */
//    @RequiresPermissions("business:jczhCheckSameCarWeb:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        JczhCheckSameCarWeb jczhCheckSameCarWeb = jczhCheckSameCarWebService.selectJczhCheckSameCarWebById(id);
//        mmap.put("jczhCheckSameCarWeb", jczhCheckSameCarWeb);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存反复查询同一辆车-web
//     */
//    @RequiresPermissions("business:jczhCheckSameCarWeb:edit")
//    @Log(title = "反复查询同一辆车-web", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody JczhCheckSameCarWeb jczhCheckSameCarWeb)
//    {
//        jczhCheckSameCarWeb.setUpdateBy(getLoginName());
//        return toAjax(jczhCheckSameCarWebService.updateJczhCheckSameCarWeb(jczhCheckSameCarWeb));
//    }
//
//    /**
//     * 删除反复查询同一辆车-web
//     */
//    @RequiresPermissions("business:jczhCheckSameCarWeb:remove")
//    @Log(title = "反复查询同一辆车-web", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(jczhCheckSameCarWebService.deleteJczhCheckSameCarWebByIds(ids));
//    }
}
