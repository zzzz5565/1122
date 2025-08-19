package com.huitong.business.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.huitong.common.annotation.Excel;
import com.huitong.common.core.domain.BaseEntity;

import java.util.Map;

/**
 * 月查询量占总查询量比例统计对象 car_query_month
 *
 * @author huitong
 * @date 2025-04-07
 */
public class CarQueryMonth extends BaseEntity
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

    /** 非“鲁”号牌车辆数 */
    @Excel(name = "非“鲁”号牌车辆数")
    private String fl;

    /** 总查询量 */
    @Excel(name = "总查询量")
    private String zs;

    /** 比例 */
    @Excel(name = "比例")
    private String bl;

    /** 查询时间 */
    @Excel(name = "查询时间")
    private String sj;

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
    public void setFl(String fl)
    {
        this.fl = fl;
    }

    public String getFl()
    {
        return fl;
    }
    public void setZs(String zs)
    {
        this.zs = zs;
    }

    public String getZs()
    {
        return zs;
    }
    public void setBl(String bl)
    {
        this.bl = bl;
    }

    public String getBl()
    {
        return bl;
    }
    public void setSj(String sj)
    {
        this.sj = sj;
    }

    public String getSj()
    {
        return sj;
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
            .append("fl", getFl())
            .append("zs", getZs())
            .append("bl", getBl())
            .toString();
    }
}
