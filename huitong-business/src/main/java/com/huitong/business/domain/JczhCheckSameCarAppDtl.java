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
 * 反复查询同一辆车-app-个人查询明细对象 jczh_check_same_car_app_dtl
 *
 * @author huitong
 * @date 2025-05-15
 */
public class JczhCheckSameCarAppDtl extends BaseEntity
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

    /** 查询时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "查询时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date rksj;

    /** 号牌种类 */
    @Excel(name = "号牌种类")
    private String cxhpzl;

    /** 号牌号码 */
    @Excel(name = "号牌号码")
    private String cxhphm;

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
    public void setRksj(Date rksj)
    {
        this.rksj = rksj;
    }

    public Date getRksj()
    {
        return rksj;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("glbm", getGlbm())
            .append("xm", getXm())
            .append("rksj", getRksj())
            .append("cxhpzl", getCxhpzl())
            .append("cxhphm", getCxhphm())
            .toString();
    }
}
