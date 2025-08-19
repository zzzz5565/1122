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
import com.huitong.business.domain.CarQueryMonth;
import com.huitong.business.service.ICarQueryMonthService;
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
 * 月查询量占总查询量比例统计Controller
 *
 * @author huitong
 * @date 2025-04-07
 */
@Controller
@RequestMapping("/business/carQueryMonth")
public class CarQueryMonthController extends BaseController
{
    private String prefix = "business/carQueryMonth";

    @Autowired
    private ICarQueryMonthService carQueryMonthService;

//    @RequiresPermissions("business:carQueryMonth:view")
    @GetMapping()
    public String carQueryMonth()
    {
        return prefix + "/carQueryMonth";
    }

    /**
     * 查询月查询量占总查询量比例统计列表
     */
//    @RequiresPermissions("business:carQueryMonth:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody CarQueryMonth carQueryMonth)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE2.name());
//        startPage(carQueryMonth.getPageNum(),carQueryMonth.getPageSize());
        List<CarQueryMonth> list = carQueryMonthService.selectCarQueryMonthLists(carQueryMonth);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出月查询量占总查询量比例统计列表
     */
    @RequiresPermissions("business:carQueryMonth:export")
    @Log(title = "月查询量占总查询量比例统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody CarQueryMonth carQueryMonth)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE2.name());
//        startPage(carQueryMonth.getPageNum(),carQueryMonth.getPageSize());
        List<CarQueryMonth> list = carQueryMonthService.selectCarQueryMonthLists(carQueryMonth);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<CarQueryMonth> util = new ExcelUtil<CarQueryMonth>(CarQueryMonth.class);
        return util.exportExcel(list, "月查询量占总查询量比例统计数据");
    }
//
//    /**
//     * 导出月查询量占总查询量比例统计数据
//     */
//    @RequiresPermissions("business:carQueryMonth:export")
//    @Log(title = "月查询量占总查询量比例统计", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody CarQueryMonth carQueryMonth)
//    {
//        List<CarQueryMonth> list = carQueryMonthService.selectCarQueryMonthList(carQueryMonth);
//        ExcelUtil<CarQueryMonth> util = new ExcelUtil<CarQueryMonth>(CarQueryMonth.class);
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
//     * 新增月查询量占总查询量比例统计
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存月查询量占总查询量比例统计
//     */
//    @RequiresPermissions("business:carQueryMonth:add")
//    @Log(title = "月查询量占总查询量比例统计", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody CarQueryMonth carQueryMonth)
//    {
//        carQueryMonth.setCreateBy(getLoginName());
//        return toAjax(carQueryMonthService.insertCarQueryMonth(carQueryMonth));
//    }
//
//    /**
//     * 修改月查询量占总查询量比例统计
//     */
//    @RequiresPermissions("business:carQueryMonth:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        CarQueryMonth carQueryMonth = carQueryMonthService.selectCarQueryMonthById(id);
//        mmap.put("carQueryMonth", carQueryMonth);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存月查询量占总查询量比例统计
//     */
//    @RequiresPermissions("business:carQueryMonth:edit")
//    @Log(title = "月查询量占总查询量比例统计", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody CarQueryMonth carQueryMonth)
//    {
//        carQueryMonth.setUpdateBy(getLoginName());
//        return toAjax(carQueryMonthService.updateCarQueryMonth(carQueryMonth));
//    }
//
//    /**
//     * 删除月查询量占总查询量比例统计
//     */
//    @RequiresPermissions("business:carQueryMonth:remove")
//    @Log(title = "月查询量占总查询量比例统计", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(carQueryMonthService.deleteCarQueryMonthByIds(ids));
//    }
}
