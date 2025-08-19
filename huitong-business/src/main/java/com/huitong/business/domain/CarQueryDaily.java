package com.huitong.business.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.huitong.common.annotation.Excel;
import com.huitong.common.core.domain.BaseEntity;

import java.util.Map;

/**
 * 日查询量高出全省日查询量倍数统计对象 car_query_daily
 *
 * @author huitong
 * @date 2025-04-07
 */
public class CarQueryDaily extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户代号 */
    @Excel(name = "用户代号")
    private String yhdh;

    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;

    /** 管理部门 */
    @Excel(name = "管理部门")
    private String glbm;

    /** 查询时间 */
    @Excel(name = "查询时间")
    private String sj;

    /** 当日最大查询 */
    @Excel(name = "当日最大查询")
    private String drzd;

    /** 高出全省日查询量倍数 */
    @Excel(name = "高出全省日查询量倍数")
    private String bs;
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
    public void setSj(String sj)
    {
        this.sj = sj;
    }

    public String getSj()
    {
        return sj;
    }
    public void setDrzd(String drzd)
    {
        this.drzd = drzd;
    }

    public String getDrzd()
    {
        return drzd;
    }
    public void setBs(String bs)
    {
        this.bs = bs;
    }

    public String getBs()
    {
        return bs;
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
            .append("sj", getSj())
            .append("drzd", getDrzd())
            .append("bs", getBs())
            .toString();
    }
}
