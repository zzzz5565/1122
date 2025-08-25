package com.huitong.business.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.huitong.business.domain.DevVioEquWarning;
import com.huitong.common.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import com.huitong.common.enums.BusinessType;
import com.huitong.business.domain.DevVioEquWarningDept;
import com.huitong.business.service.IDevVioEquWarningDeptService;
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
 * 设备预警Controller
 * 
 * @author jsj
 * @date 2025-08-13
 */
@Controller
@RequestMapping("/business/devVioEquWarningDept")
public class DevVioEquWarningDeptController extends BaseController {
    private String prefix = "business/devVioEquWarningDept";

    @Autowired
    private IDevVioEquWarningDeptService devVioEquWarningDeptService;

    @RequiresPermissions("business:devVioEquWarningDept:view")
    @GetMapping()
    public String devVioEquWarningDept() {
        return prefix + "/devVioEquWarningDept";
    }

    /**
     * 查询设备预警列表
     */
    @RequiresPermissions("business:devVioEquWarningDept:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody DevVioEquWarningDept devVioEquWarningDept) throws ParseException {
        startPage(devVioEquWarningDept.getPageNum(), devVioEquWarningDept.getPageSize());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 获取前一天日期
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.add(Calendar.DATE, -1);
        Date preDate = calendar.getTime();
        devVioEquWarningDept.setYjrq(preDate);
//        calendar.add(Calendar.DATE, -1);
        Date endDate = calendar.getTime();
        devVioEquWarningDept.setEndDate(endDate);

        calendar.add(Calendar.DATE, -9);
        Date startDate = calendar.getTime();
        devVioEquWarningDept.setPreDate(startDate);

        List<DevVioEquWarningDept> list = devVioEquWarningDeptService.selectWarningDeptList(devVioEquWarningDept);
        return getDataTable(list);
    }

    @GetMapping("/getDetail/{yjlx}/{glbm}/{yjrq}")
    public String getDetail(@PathVariable("yjlx") String yjlx, @PathVariable("glbm") String glbm, @PathVariable("yjrq") String yjrq, ModelMap mmap) {
        mmap.put("yjlx", yjlx);
        mmap.put("glbm", glbm);
        mmap.put("yjrq", yjrq);
        if ("1".equals(yjlx)) {
            return prefix + "/zplycDetail";
        } else if ("2".equals(yjlx)) {
            return prefix + "/wsjscDetail";
        } else if ("5".equals(yjlx)) {
            return prefix + "/csycDetail";
        } else if ("7".equals(yjlx)) {
            return prefix + "/ztycDetail";
        } else if ("15".equals(yjlx)) {
            return prefix + "/sjjzDetail";
        } else if ("16".equals(yjlx)) {
            return prefix + "/sjjjDetail";
        } else if ("17".equals(yjlx)) {
            return prefix + "/zfscsbDetail";
        } else {
            return prefix + "/detail";
        }
    }

    /**
     * 数据初审异常
     */
    @RequiresPermissions("business:devVioEquWarningDept:list")
    @PostMapping("/csycDetailList/{yjlx}/{glbm}/{yjrq}")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo csycDetailList(@PathVariable("yjlx") String yjlx, @PathVariable("glbm") String glbm, @PathVariable("yjrq") String yjrq, ModelMap mmap) throws ParseException {
        DevVioEquWarningDept devVioEquWarningDept = new DevVioEquWarningDept();
        devVioEquWarningDept.setGlbm(glbm);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date yjrqDate = sdf.parse(yjrq);
        devVioEquWarningDept.setYjrq(yjrqDate);
        startPage();
        List<DevVioEquWarningDept> list = devVioEquWarningDeptService.selectCsycList(devVioEquWarningDept);
        return getDataTable(list);
    }

    /**
     * 无数据上传明细
     */
    @RequiresPermissions("business:devVioEquWarningDept:list")
    @PostMapping("/wsjscDetailList/{yjlx}/{glbm}/{yjrq}")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo wsjscDetailList(@PathVariable("yjlx") String yjlx, @PathVariable("glbm") String glbm, @PathVariable("yjrq") String yjrq, ModelMap mmap) throws ParseException {
        DevVioEquWarningDept devVioEquWarningDept = new DevVioEquWarningDept();
        devVioEquWarningDept.setGlbm(glbm);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date yjrqDate = sdf.parse(yjrq);
        devVioEquWarningDept.setYjrq(yjrqDate);

        devVioEquWarningDept.setYjlx(Integer.valueOf(yjlx));
        startPage();
        List<DevVioEquWarningDept> list = devVioEquWarningDeptService.selectWsjscList(devVioEquWarningDept);
        return getDataTable(list);
    }

    /**
     * 状态异常变化
     */
    @RequiresPermissions("business:devVioEquWarningDept:list")
    @PostMapping("/ztycDetailList/{yjlx}/{glbm}/{yjrq}")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo ztycDetailList(@PathVariable("yjlx") String yjlx, @PathVariable("glbm") String glbm, @PathVariable("yjrq") String yjrq, ModelMap mmap) throws ParseException {
        DevVioEquWarningDept devVioEquWarningDept = new DevVioEquWarningDept();
        devVioEquWarningDept.setGlbm(glbm);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date yjrqDate = sdf.parse(yjrq);
        devVioEquWarningDept.setYjrq(yjrqDate);

        // 获取前一天日期
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(yjrqDate);
        calendar.add(Calendar.DATE, -1);
        Date preDate = calendar.getTime();

        devVioEquWarningDept.setPreDate(preDate);
        devVioEquWarningDept.setYjlx(Integer.valueOf(yjlx));
        startPage();
        List<DevVioEquWarningDept> list = devVioEquWarningDeptService.selectZtycList(devVioEquWarningDept);
        return getDataTable(list);
    }

    /**
     * 抓拍量异常明细
     */
    @RequiresPermissions("business:devVioEquWarningDept:list")
    @PostMapping("/zplycDetailList/{yjlx}/{glbm}/{yjrq}")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo zplycDetailList(@PathVariable("yjlx") String yjlx, @PathVariable("glbm") String glbm, @PathVariable("yjrq") String yjrq, ModelMap mmap) throws ParseException {
        DevVioEquWarningDept devVioEquWarningDept = new DevVioEquWarningDept();
        devVioEquWarningDept.setGlbm(glbm);
        devVioEquWarningDept.setYjlx(Integer.valueOf(yjlx));
        devVioEquWarningDept.setGlbm(glbm);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date yjrqDate = sdf.parse(yjrq);
        devVioEquWarningDept.setYjrq(yjrqDate);
        startPage();
        List<DevVioEquWarningDept> list = devVioEquWarningDeptService.selectZplycList(devVioEquWarningDept);
        return getDataTable(list);
    }

    /**
     * 数据激增明细
     */
    @RequiresPermissions("business:devVioEquWarningDept:list")
    @PostMapping("/sjjzDetailList/{yjlx}/{glbm}/{yjrq}")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo sjjzDetailList(@PathVariable("yjlx") String yjlx, @PathVariable("glbm") String glbm, @PathVariable("yjrq") String yjrq, ModelMap mmap) throws ParseException {
        DevVioEquWarningDept devVioEquWarningDept = new DevVioEquWarningDept();
        devVioEquWarningDept.setGlbm(glbm);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 获取前一天日期
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.add(Calendar.DATE, -1);
        Date preDate = calendar.getTime();
        devVioEquWarningDept.setYjrq(preDate);
//        calendar.add(Calendar.DATE, -1);
        Date endDate = calendar.getTime();
        devVioEquWarningDept.setEndDate(endDate);

        calendar.add(Calendar.DATE, -9);
        Date startDate = calendar.getTime();
        devVioEquWarningDept.setPreDate(startDate);

        devVioEquWarningDept.setGlbm(glbm);
        devVioEquWarningDept.setYjlx(Integer.valueOf(yjlx));
        startPage();
        List<DevVioEquWarningDept> list = devVioEquWarningDeptService.selectSjjzList(devVioEquWarningDept);
        return getDataTable(list);
    }

    /**
     * 数据巨减明细
     */
    @RequiresPermissions("business:devVioEquWarningDept:list")
    @PostMapping("/sjjjDetailList/{yjlx}/{glbm}/{yjrq}")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo sjjjDetailList(@PathVariable("yjlx") String yjlx, @PathVariable("glbm") String glbm, @PathVariable("yjrq") String yjrq, ModelMap mmap) throws ParseException {
        DevVioEquWarningDept devVioEquWarningDept = new DevVioEquWarningDept();
        devVioEquWarningDept.setGlbm(glbm);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 获取前一天日期
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.add(Calendar.DATE, -1);
        Date preDate = calendar.getTime();
        devVioEquWarningDept.setYjrq(preDate);
//        calendar.add(Calendar.DATE, -1);
        Date endDate = calendar.getTime();
        devVioEquWarningDept.setEndDate(endDate);

        calendar.add(Calendar.DATE, -9);
        Date startDate = calendar.getTime();
        devVioEquWarningDept.setPreDate(startDate);

        devVioEquWarningDept.setGlbm(glbm);
        devVioEquWarningDept.setYjlx(Integer.valueOf(yjlx));
        startPage();
        List<DevVioEquWarningDept> list = devVioEquWarningDeptService.selectSjjjList(devVioEquWarningDept);
        return getDataTable(list);
    }

    /**
     * 导出设备预警列表
     */
    @RequiresPermissions("business:devVioEquWarningDept:export")
    @Log(title = "设备预警", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody DevVioEquWarningDept devVioEquWarningDept) {
        List<DevVioEquWarningDept> list = devVioEquWarningDeptService.selectDevVioEquWarningDeptList(devVioEquWarningDept);
        ExcelUtil<DevVioEquWarningDept> util = new ExcelUtil<DevVioEquWarningDept>(DevVioEquWarningDept.class);
        return util.exportExcel(list, "设备预警数据");
    }

    /**
     * 导出设备预警数据
     */
    @RequiresPermissions("business:devVioEquWarningDept:export")
    @Log(title = "设备预警", businessType = BusinessType.EXPORT)
    @PostMapping("/exportZip")
    @ResponseBody
    @Decrypt
    public AjaxResult exportZip(@RequestBody DevVioEquWarningDept devVioEquWarningDept) {
        List<DevVioEquWarningDept> list = devVioEquWarningDeptService.selectDevVioEquWarningDeptList(devVioEquWarningDept);
        ExcelUtil<DevVioEquWarningDept> util = new ExcelUtil<DevVioEquWarningDept>(DevVioEquWarningDept.class);
        AjaxResult ajaxResult = util.exportExcel(list, "数据文件");
        String fileName = ajaxResult.get("msg").toString();//获取文件下载名称
        String filePath = HuiTongConfig.getDownloadPath() + fileName;
        String zipFileName = System.currentTimeMillis() + ".zip";
        String zipFilePath = HuiTongConfig.getDownloadPath() + zipFileName;
        if (StringUtils.isNotEmpty(filePath)) {
            try {
                FileZipUtil.zipFilePwd(filePath, zipFilePath, null);
                FileUtils.deleteFile(filePath);//删除文件
                ajaxResult.put("msg", "");
                ajaxResult.put("fileName", zipFileName);
                ajaxResult.put("realFileName", "数据文件" + DateUtils.dateTimeNow() + ".zip");
            } catch (Exception e) {
                ajaxResult.put("code", "-1");
                ajaxResult.put("msg", "导出失败!!!");
                e.printStackTrace();
            }
        }
        return ajaxResult;
    }

    /**
     * 新增设备预警
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存设备预警
     */
    @RequiresPermissions("business:devVioEquWarningDept:add")
    @Log(title = "设备预警", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    @Decrypt
    public AjaxResult addSave(@RequestBody DevVioEquWarningDept devVioEquWarningDept) {
        devVioEquWarningDept.setCreateBy(getLoginName());
        return toAjax(devVioEquWarningDeptService.insertDevVioEquWarningDept(devVioEquWarningDept));
    }

    /**
     * 修改设备预警
     */
    @RequiresPermissions("business:devVioEquWarningDept:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        DevVioEquWarningDept devVioEquWarningDept = devVioEquWarningDeptService.selectDevVioEquWarningDeptById(id);
        mmap.put("devVioEquWarningDept", devVioEquWarningDept);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备预警
     */
    @RequiresPermissions("business:devVioEquWarningDept:edit")
    @Log(title = "设备预警", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    @Decrypt
    public AjaxResult editSave(@RequestBody DevVioEquWarningDept devVioEquWarningDept) {
        devVioEquWarningDept.setUpdateBy(getLoginName());
        return toAjax(devVioEquWarningDeptService.updateDevVioEquWarningDept(devVioEquWarningDept));
    }

    /**
     * 删除设备预警
     */
    @RequiresPermissions("business:devVioEquWarningDept:remove")
    @Log(title = "设备预警", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    @Decrypt
    public AjaxResult remove(@RequestBody String ids) {
        return toAjax(devVioEquWarningDeptService.deleteDevVioEquWarningDeptByIds(ids));
    }
    /**
     * 违法还在上传
     */
    @RequiresPermissions("business:devVioEquWarningDept:list")
    @PostMapping("/zfscsbDetailList/{yjlx}/{glbm}/{yjrq}")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo zfscsbDetailList(@PathVariable("yjlx") String yjlx, @PathVariable("glbm") String glbm, @PathVariable("yjrq") String yjrq) throws ParseException {
        DevVioEquWarningDept devVioEquWarningDept = new DevVioEquWarningDept();
        devVioEquWarningDept.setGlbm(glbm);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date yjrqDate = sdf.parse(yjrq);
        devVioEquWarningDept.setYjrq(yjrqDate);

        startPage();
        List<DevVioEquWarningDept> list = devVioEquWarningDeptService.selectZfscsbList(devVioEquWarningDept);
        return getDataTable(list);
    }
}