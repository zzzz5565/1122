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
import com.huitong.business.domain.CheckSameCar;
import com.huitong.business.service.ICheckSameCarService;
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
 * 反复查询同一辆车Controller
 *
 * @author huitong
 * @date 2025-04-09
 */
@Controller
@RequestMapping("/business/checkSameCar")
public class CheckSameCarController extends BaseController
{
    private String prefix = "business/checkSameCar";

    @Autowired
    private ICheckSameCarService checkSameCarService;

//    @RequiresPermissions("business:checkSameCar:view")
    @GetMapping()
    public String checkSameCar()
    {
        return prefix + "/checkSameCar";
    }

    /**
     * 查询反复查询同一辆车列表
     */
//    @RequiresPermissions("business:checkSameCar:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody CheckSameCar checkSameCar)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE3.name());
//        startPage(checkSameCar.getPageNum(),checkSameCar.getPageSize());
        List<CheckSameCar> list = checkSameCarService.selectCheckSameCarLists(checkSameCar);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

//    /**
//     * 导出反复查询同一辆车列表
//     */
//    @RequiresPermissions("business:checkSameCar:export")
//    @Log(title = "反复查询同一辆车", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult export(@RequestBody CheckSameCar checkSameCar)
//    {
//        List<CheckSameCar> list = checkSameCarService.selectCheckSameCarList(checkSameCar);
//        ExcelUtil<CheckSameCar> util = new ExcelUtil<CheckSameCar>(CheckSameCar.class);
//        return util.exportExcel(list, "反复查询同一辆车数据");
//    }
//
//    /**
//     * 导出反复查询同一辆车数据
//     */
//    @RequiresPermissions("business:checkSameCar:export")
//    @Log(title = "反复查询同一辆车", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody CheckSameCar checkSameCar)
//    {
//        List<CheckSameCar> list = checkSameCarService.selectCheckSameCarList(checkSameCar);
//        ExcelUtil<CheckSameCar> util = new ExcelUtil<CheckSameCar>(CheckSameCar.class);
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
//     * 新增反复查询同一辆车
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存反复查询同一辆车
//     */
//    @RequiresPermissions("business:checkSameCar:add")
//    @Log(title = "反复查询同一辆车", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody CheckSameCar checkSameCar)
//    {
//        checkSameCar.setCreateBy(getLoginName());
//        return toAjax(checkSameCarService.insertCheckSameCar(checkSameCar));
//    }
//
//    /**
//     * 修改反复查询同一辆车
//     */
//    @RequiresPermissions("business:checkSameCar:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        CheckSameCar checkSameCar = checkSameCarService.selectCheckSameCarById(id);
//        mmap.put("checkSameCar", checkSameCar);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存反复查询同一辆车
//     */
//    @RequiresPermissions("business:checkSameCar:edit")
//    @Log(title = "反复查询同一辆车", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody CheckSameCar checkSameCar)
//    {
//        checkSameCar.setUpdateBy(getLoginName());
//        return toAjax(checkSameCarService.updateCheckSameCar(checkSameCar));
//    }
//
//    /**
//     * 删除反复查询同一辆车
//     */
//    @RequiresPermissions("business:checkSameCar:remove")
//    @Log(title = "反复查询同一辆车", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(checkSameCarService.deleteCheckSameCarByIds(ids));
//    }
}
