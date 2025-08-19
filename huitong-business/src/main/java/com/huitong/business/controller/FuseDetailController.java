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
import com.huitong.business.domain.FuseDetail;
import com.huitong.business.service.IFuseDetailService;
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
 * 集成指挥平台熔断明细Controller
 *
 * @author huitong
 * @date 2025-04-09
 */
@Controller
@RequestMapping("/business/fuseDetail")
public class FuseDetailController extends BaseController
{
    private String prefix = "business/fuseDetail";

    @Autowired
    private IFuseDetailService fuseDetailService;

//    @RequiresPermissions("business:fuseDetail:view")
    @GetMapping()
    public String fuseDetail()
    {
        return prefix + "/fuseDetail";
    }

    /**
     * 查询集成指挥平台熔断明细列表
     */
//    @RequiresPermissions("business:fuseDetail:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody FuseDetail fuseDetail)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
//        startPage(fuseDetail.getPageNum(),fuseDetail.getPageSize());
        List<FuseDetail> list = fuseDetailService.selectFuseDetailLists(fuseDetail);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出集成指挥平台熔断明细列表
     */
    @RequiresPermissions("business:fuseDetail:export")
    @Log(title = "集成指挥平台熔断明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody FuseDetail fuseDetail)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        List<FuseDetail> list = fuseDetailService.selectFuseDetailLists(fuseDetail);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<FuseDetail> util = new ExcelUtil<FuseDetail>(FuseDetail.class);
        return util.exportExcel(list, "集成指挥平台熔断明细数据");
    }
//
//    /**
//     * 导出集成指挥平台熔断明细数据
//     */
//    @RequiresPermissions("business:fuseDetail:export")
//    @Log(title = "集成指挥平台熔断明细", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody FuseDetail fuseDetail)
//    {
//        List<FuseDetail> list = fuseDetailService.selectFuseDetailList(fuseDetail);
//        ExcelUtil<FuseDetail> util = new ExcelUtil<FuseDetail>(FuseDetail.class);
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
//     * 新增集成指挥平台熔断明细
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存集成指挥平台熔断明细
//     */
//    @RequiresPermissions("business:fuseDetail:add")
//    @Log(title = "集成指挥平台熔断明细", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody FuseDetail fuseDetail)
//    {
//        fuseDetail.setCreateBy(getLoginName());
//        return toAjax(fuseDetailService.insertFuseDetail(fuseDetail));
//    }
//
//    /**
//     * 修改集成指挥平台熔断明细
//     */
//    @RequiresPermissions("business:fuseDetail:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        FuseDetail fuseDetail = fuseDetailService.selectFuseDetailById(id);
//        mmap.put("fuseDetail", fuseDetail);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存集成指挥平台熔断明细
//     */
//    @RequiresPermissions("business:fuseDetail:edit")
//    @Log(title = "集成指挥平台熔断明细", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody FuseDetail fuseDetail)
//    {
//        fuseDetail.setUpdateBy(getLoginName());
//        return toAjax(fuseDetailService.updateFuseDetail(fuseDetail));
//    }
//
//    /**
//     * 删除集成指挥平台熔断明细
//     */
//    @RequiresPermissions("business:fuseDetail:remove")
//    @Log(title = "集成指挥平台熔断明细", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(fuseDetailService.deleteFuseDetailByIds(ids));
//    }
}
