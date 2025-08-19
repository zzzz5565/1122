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
import com.huitong.business.domain.GoodNumberQuery;
import com.huitong.business.service.IGoodNumberQueryService;
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
 * 靓号综合查询统计Controller
 *
 * @author hairun
 * @date 2025-03-25
 */
@Controller
@RequestMapping("/business/goodNumberQuery")
public class GoodNumberQueryController extends BaseController
{
    private String prefix = "business/goodNumberQuery";

    @Autowired
    private IGoodNumberQueryService goodNumberQueryService;

//    @RequiresPermissions("business:goodNumberQuery:view")
    @GetMapping()
    public String goodNumberQuery()
    {
        return prefix + "/goodNumberQuery";
    }

    /**
     * 查询靓号综合查询统计列表
     */
//    @RequiresPermissions("business:goodNumberQuery:list")
    @PostMapping("/list")
    @ResponseBody
    @Decrypt
    @Encrypt
    public TableDataInfo list(@RequestBody GoodNumberQuery goodNumberQuery)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE2.name());
//        startPage(goodNumberQuery.getPageNum(),goodNumberQuery.getPageSize());
        List<GoodNumberQuery> list = goodNumberQueryService.selectGoodNumberQueryLists(goodNumberQuery);
        DynamicDataSourceContextHolder.clearDataSourceType();
        return getDataTable(list);
    }

//    /**
//     * 导出靓号综合查询统计列表
//     */
    @RequiresPermissions("business:goodNumberQuery:export")
    @Log(title = "靓号综合查询统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    @Decrypt
    public AjaxResult export(@RequestBody GoodNumberQuery goodNumberQuery)
    {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE2.name());
        List<GoodNumberQuery> list = goodNumberQueryService.selectGoodNumberQueryLists(goodNumberQuery);
        DynamicDataSourceContextHolder.clearDataSourceType();
        ExcelUtil<GoodNumberQuery> util = new ExcelUtil<GoodNumberQuery>(GoodNumberQuery.class);
        return util.exportExcel(list, "靓号综合查询统计数据");
    }

//    /**
//     * 导出靓号综合查询统计数据
//     */
//    @RequiresPermissions("business:goodNumberQuery:export")
//    @Log(title = "靓号综合查询统计", businessType = BusinessType.EXPORT)
//    @PostMapping("/exportZip")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult exportZip(@RequestBody GoodNumberQuery goodNumberQuery)
//    {
//        List<GoodNumberQuery> list = goodNumberQueryService.selectGoodNumberQueryList(goodNumberQuery);
//        ExcelUtil<GoodNumberQuery> util = new ExcelUtil<GoodNumberQuery>(GoodNumberQuery.class);
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
//     * 新增靓号综合查询统计
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存靓号综合查询统计
//     */
//    @RequiresPermissions("business:goodNumberQuery:add")
//    @Log(title = "靓号综合查询统计", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult addSave(@RequestBody GoodNumberQuery goodNumberQuery)
//    {
//        goodNumberQuery.setCreateBy(getLoginName());
//        return toAjax(goodNumberQueryService.insertGoodNumberQuery(goodNumberQuery));
//    }
//
//    /**
//     * 修改靓号综合查询统计
//     */
//    @RequiresPermissions("business:goodNumberQuery:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        GoodNumberQuery goodNumberQuery = goodNumberQueryService.selectGoodNumberQueryById(id);
//        mmap.put("goodNumberQuery", goodNumberQuery);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存靓号综合查询统计
//     */
//    @RequiresPermissions("business:goodNumberQuery:edit")
//    @Log(title = "靓号综合查询统计", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult editSave(@RequestBody GoodNumberQuery goodNumberQuery)
//    {
//        goodNumberQuery.setUpdateBy(getLoginName());
//        return toAjax(goodNumberQueryService.updateGoodNumberQuery(goodNumberQuery));
//    }
//
//    /**
//     * 删除靓号综合查询统计
//     */
//    @RequiresPermissions("business:goodNumberQuery:remove")
//    @Log(title = "靓号综合查询统计", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    @Decrypt
//    public AjaxResult remove(@RequestBody String ids)
//    {
//        return toAjax(goodNumberQueryService.deleteGoodNumberQueryByIds(ids));
//    }
}
