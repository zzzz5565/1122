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
import com.huitong.business.domain.CarQueryDaily;
import com.huitong.business.service.ICarQueryDailyService;
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
 * 日查询量高出全省日查询量倍数统计Controller
 *
 * @author huitong
 * @date 2025-04-07
 */
@Controller
@RequestMapping("/business/carQueryDaily")
public class CarQueryDailyController extends BaseController
{
    private String prefix = "business/carQueryDaily";

    @Autowired
    private ICarQueryDailyService carQueryDailyService;

//    @RequiresPermissions("business:carQueryDaily:view")
    @GetMapping()
    public String carQueryDaily()
    {
        return prefix + "/carQueryDaily";
    }

    /**
     * 查询日查询量高出全省日查询量倍数统计列表
     */
//    @RequiresPermissions("business:carQueryDaily:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody CarQueryDaily carQueryDaily)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE2.name());
//        startPage(carQueryDaily.getPageNum(),carQueryDaily.getPageSize());
        List<CarQueryDaily> list = carQueryDailyService.selectCarQueryDailyLists(carQueryDaily);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

    /**
     * 导出日查询量高出全省日查询量倍数统计列表
     */
    @RequiresPermissions("business:carQueryDaily:export")
    @Log(title = "日查询量高出全省日查询量倍数统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody CarQueryDaily carQueryDaily)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE2.name());
//        startPage(carQueryDaily.getPageNum(),carQueryDaily.getPageSize());
        List<CarQueryDaily> list = carQueryDailyService.selectCarQueryDailyLists(carQueryDaily);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<CarQueryDaily> util = new ExcelUtil<CarQueryDaily>(CarQueryDaily.class);
        return util.exportExcel(list, "日查询量高出全省日查询量倍数统计数据");
    }
//
//    /**
//     * 导出日查询量高出全省日查询量倍数统计数据
//     */
//    @RequiresPermissions("business:carQueryDaily:export")
//    @Log(title = "日查询量高出全省日查询量倍数统计", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody CarQueryDaily carQueryDaily)
//    {
//        List<CarQueryDaily> list = carQueryDailyService.selectCarQueryDailyList(carQueryDaily);
//        ExcelUtil<CarQueryDaily> util = new ExcelUtil<CarQueryDaily>(CarQueryDaily.class);
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
//     * 新增日查询量高出全省日查询量倍数统计
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存日查询量高出全省日查询量倍数统计
//     */
//    @RequiresPermissions("business:carQueryDaily:add")
//    @Log(title = "日查询量高出全省日查询量倍数统计", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody CarQueryDaily carQueryDaily)
//    {
//        carQueryDaily.setCreateBy(getLoginName());
//        return toAjax(carQueryDailyService.insertCarQueryDaily(carQueryDaily));
//    }
//
//    /**
//     * 修改日查询量高出全省日查询量倍数统计
//     */
//    @RequiresPermissions("business:carQueryDaily:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        CarQueryDaily carQueryDaily = carQueryDailyService.selectCarQueryDailyById(id);
//        mmap.put("carQueryDaily", carQueryDaily);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存日查询量高出全省日查询量倍数统计
//     */
//    @RequiresPermissions("business:carQueryDaily:edit")
//    @Log(title = "日查询量高出全省日查询量倍数统计", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody CarQueryDaily carQueryDaily)
//    {
//        carQueryDaily.setUpdateBy(getLoginName());
//        return toAjax(carQueryDailyService.updateCarQueryDaily(carQueryDaily));
//    }
//
//    /**
//     * 删除日查询量高出全省日查询量倍数统计
//     */
//    @RequiresPermissions("business:carQueryDaily:remove")
//    @Log(title = "日查询量高出全省日查询量倍数统计", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(carQueryDailyService.deleteCarQueryDailyByIds(ids));
//    }
}
