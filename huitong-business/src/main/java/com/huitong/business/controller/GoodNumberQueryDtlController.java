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
import com.huitong.business.domain.GoodNumberQueryDtl;
import com.huitong.business.service.IGoodNumberQueryDtlService;
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
 * 靓号综合查询详情Controller
 *
 * @author huitong
 * @date 2025-03-25
 */
@Controller
@RequestMapping("/business/goodNumberQueryDtl")
public class GoodNumberQueryDtlController extends BaseController
{
    private String prefix = "business/goodNumberQueryDtl";

    @Autowired
    private IGoodNumberQueryDtlService goodNumberQueryDtlService;

//    @RequiresPermissions("business:goodNumberQueryDtl:view")
    @GetMapping()
    public String goodNumberQueryDtl()
    {
        return prefix + "/goodNumberQueryDtl";
    }

    /**
     * 查询靓号综合查询详情列表
     */
//    @RequiresPermissions("business:goodNumberQueryDtl:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody GoodNumberQueryDtl goodNumberQueryDtl)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE2.name());
//        startPage(goodNumberQueryDtl.getPageNum(),goodNumberQueryDtl.getPageSize());
        List<GoodNumberQueryDtl> list = goodNumberQueryDtlService.selectGoodNumberQueryDtlLists(goodNumberQueryDtl);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出靓号综合查询详情列表
     */
    @RequiresPermissions("business:goodNumberQueryDtl:export")
    @Log(title = "靓号综合查询详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody GoodNumberQueryDtl goodNumberQueryDtl)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE2.name());
//        startPage(goodNumberQueryDtl.getPageNum(),goodNumberQueryDtl.getPageSize());
        List<GoodNumberQueryDtl> list = goodNumberQueryDtlService.selectGoodNumberQueryDtlLists(goodNumberQueryDtl);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<GoodNumberQueryDtl> util = new ExcelUtil<GoodNumberQueryDtl>(GoodNumberQueryDtl.class);
        return util.exportExcel(list, "靓号综合查询详情数据");
    }
//
//    /**
//     * 导出靓号综合查询详情数据
//     */
//    @RequiresPermissions("business:goodNumberQueryDtl:export")
//    @Log(title = "靓号综合查询详情", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody GoodNumberQueryDtl goodNumberQueryDtl)
//    {
//        List<GoodNumberQueryDtl> list = goodNumberQueryDtlService.selectGoodNumberQueryDtlList(goodNumberQueryDtl);
//        ExcelUtil<GoodNumberQueryDtl> util = new ExcelUtil<GoodNumberQueryDtl>(GoodNumberQueryDtl.class);
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
//     * 新增靓号综合查询详情
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存靓号综合查询详情
//     */
//    @RequiresPermissions("business:goodNumberQueryDtl:add")
//    @Log(title = "靓号综合查询详情", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody GoodNumberQueryDtl goodNumberQueryDtl)
//    {
//        goodNumberQueryDtl.setCreateBy(getLoginName());
//        return toAjax(goodNumberQueryDtlService.insertGoodNumberQueryDtl(goodNumberQueryDtl));
//    }
//
//    /**
//     * 修改靓号综合查询详情
//     */
//    @RequiresPermissions("business:goodNumberQueryDtl:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        GoodNumberQueryDtl goodNumberQueryDtl = goodNumberQueryDtlService.selectGoodNumberQueryDtlById(id);
//        mmap.put("goodNumberQueryDtl", goodNumberQueryDtl);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存靓号综合查询详情
//     */
//    @RequiresPermissions("business:goodNumberQueryDtl:edit")
//    @Log(title = "靓号综合查询详情", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody GoodNumberQueryDtl goodNumberQueryDtl)
//    {
//        goodNumberQueryDtl.setUpdateBy(getLoginName());
//        return toAjax(goodNumberQueryDtlService.updateGoodNumberQueryDtl(goodNumberQueryDtl));
//    }
//
//    /**
//     * 删除靓号综合查询详情
//     */
//    @RequiresPermissions("business:goodNumberQueryDtl:remove")
//    @Log(title = "靓号综合查询详情", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(goodNumberQueryDtlService.deleteGoodNumberQueryDtlByIds(ids));
//    }
}
