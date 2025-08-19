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
 * 集成指挥平台查询非鲁车对象 jczh_feilu_car_qurey
 *
 * @author huitong
 * @date 2025-05-15
 */
public class JczhFeiluCarQurey extends BaseEntity
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

    /** 数量 */
    @Excel(name = "数量")
    private Long num;

    /** 查询时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "查询时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date cxsj;

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
    public void setNum(Long num)
    {
        this.num = num;
    }

    public Long getNum()
    {
        return num;
    }
    public void setCxsj(Date cxsj)
    {
        this.cxsj = cxsj;
    }

    public Date getCxsj()
    {
        return cxsj;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("glbm", getGlbm())
            .append("xm", getXm())
            .append("num", getNum())
            .append("cxsj", getCxsj())
            .toString();
    }
}
