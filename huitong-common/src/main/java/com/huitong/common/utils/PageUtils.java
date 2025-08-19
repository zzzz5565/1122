package com.huitong.common.utils;

import com.github.pagehelper.PageHelper;
import com.huitong.common.core.page.PageDomain;
import com.huitong.common.core.page.TableSupport;
import com.huitong.common.utils.sql.SqlUtil;

/**
 * 分页工具类
 * 
 *
 */
public class PageUtils extends PageHelper
{
    /**
     * 设置请求分页数据
     */
    public static void startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
        Boolean reasonable = pageDomain.getReasonable();
        PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
    }

    protected void startPage(Integer pageNum,Integer pageSize) {
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize)) {
            PageHelper.startPage(pageNum, pageSize, "");
        }
    }
    /**
     * 清理分页的线程变量
     */
    public static void clearPage()
    {
        PageHelper.clearPage();
    }
}
