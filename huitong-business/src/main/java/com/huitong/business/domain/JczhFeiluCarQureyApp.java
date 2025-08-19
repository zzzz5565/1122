package com.huitong.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.huitong.common.annotation.Excel;
import com.huitong.common.core.domain.BaseEntity;

/**
 * 集成指挥平台查询非鲁车-app对象 jczh_feilu_car_qurey_app
 *
 * @author huitong
 * @date 2025-05-26
 */
public class JczhFeiluCarQureyApp extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 管理部门 */
    @Excel(name = "管理部门")
    private String glbm;

    /** 警号 */
    @Excel(name = "警号")
    private String yhdh;

    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;

    /** 数量 */
    @Excel(name = "数量")
    private Long num;

    /** 查询时间 */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @Excel(name = "查询时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
//    private Date rksj;

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
    public void setYhdh(String yhdh)
    {
        this.yhdh = yhdh;
    }

    public String getYhdh()
    {
        return yhdh;
    }
    public void setNum(Long num)
    {
        this.num = num;
    }

    public Long getNum()
    {
        return num;
    }
//    public void setRksj(Date rksj)
//    {
//        this.rksj = rksj;
//    }
//
//    public Date getRksj()
//    {
//        return rksj;
//    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("glbm", getGlbm())
            .append("yhdh", getYhdh())
            .append("num", getNum())
//            .append("rksj", getRksj())
            .toString();
    }
}
