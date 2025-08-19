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
 * 反复查询同一辆车-app-带姓名警号对象 jczh_check_same_car_app
 *
 * @author huitong
 * @date 2025-05-15
 */
public class JczhCheckSameCarApp extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 管理部门 */
    @Excel(name = "管理部门")
    private String glbm;

    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;

    /** 警号 */
    @Excel(name = "警号")
    private String yhdh;

    /** 号牌种类 */
    @Excel(name = "号牌种类")
    private String cxhpzl;

    /** 号牌号码 */
    @Excel(name = "号牌号码")
    private String cxhphm;

    /** 数量 */
    @Excel(name = "数量")
    private Long sl;

    /** 查询时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "查询时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date rksj;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setGlbm(String glbm)
    {
        this.glbm = glbm;
    }

    public String getGlbm()
    {
        return glbm;
    }
    public void setXm(String xm)
    {
        this.xm = xm;
    }

    public String getXm()
    {
        return xm;
    }
    public void setYhdh(String yhdh)
    {
        this.yhdh = yhdh;
    }

    public String getYhdh()
    {
        return yhdh;
    }
    public void setCxhpzl(String cxhpzl)
    {
        this.cxhpzl = cxhpzl;
    }

    public String getCxhpzl()
    {
        return cxhpzl;
    }
    public void setCxhphm(String cxhphm)
    {
        this.cxhphm = cxhphm;
    }

    public String getCxhphm()
    {
        return cxhphm;
    }
    public void setSl(Long sl)
    {
        this.sl = sl;
    }

    public Long getSl()
    {
        return sl;
    }
    public void setRksj(Date rksj)
    {
        this.rksj = rksj;
    }

    public Date getRksj()
    {
        return rksj;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("glbm", getGlbm())
            .append("xm", getXm())
            .append("yhdh", getYhdh())
            .append("cxhpzl", getCxhpzl())
            .append("cxhphm", getCxhphm())
            .append("sl", getSl())
            .append("rksj", getRksj())
            .toString();
    }
}
