package com.huitong.business.domain;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.huitong.common.annotation.Excel;
import com.huitong.common.core.domain.BaseEntity;

/**
 * 靓号综合查询统计对象 good_number_query
 *
 * @author hairun
 * @date 2025-03-25
 */
public class GoodNumberQuery extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户电话 */
    @Excel(name = "用户代号")
    private String yhdh;

    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;

    /** 管理部门 */
    @Excel(name = "管理部门")
    private String glbm;

    /** 次数 */
    @Excel(name = "次数")
    private Long cs;

    /** 写入时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "查询时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date xrsj;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> params;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setYhdh(String yhdh)
    {
        this.yhdh = yhdh;
    }

    public String getYhdh()
    {
        return yhdh;
    }
    public void setXm(String xm)
    {
        this.xm = xm;
    }

    public String getXm()
    {
        return xm;
    }
    public void setGlbm(String glbm)
    {
        this.glbm = glbm;
    }

    public String getGlbm()
    {
        return glbm;
    }
    public void setCs(Long cs)
    {
        this.cs = cs;
    }

    public Long getCs()
    {
        return cs;
    }
    public void setXrsj(Date xrsj)
    {
        this.xrsj = xrsj;
    }

    public Date getXrsj()
    {
        return xrsj;
    }

    @Override
    public Map<String, Object> getParams() {
        return params;
    }

    @Override
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("yhdh", getYhdh())
            .append("xm", getXm())
            .append("glbm", getGlbm())
            .append("cs", getCs())
            .append("xrsj", getXrsj())
            .toString();
    }
}
