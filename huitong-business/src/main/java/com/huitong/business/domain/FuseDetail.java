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
 * 集成指挥平台熔断明细对象 fuse_detail
 *
 * @author huitong
 * @date 2025-04-09
 */
public class FuseDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 身份证号码 */
    @Excel(name = "身份证号码")
    private String sfzmhm;

    /** 管理部门 */
    @Excel(name = "管理部门")
    private String glbm;

    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;

    /** 数量 */
    @Excel(name = "数量")
    private Integer num;

    /** 熔断开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "熔断开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date rdkssj;

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
    public void setSfzmhm(String sfzmhm)
    {
        this.sfzmhm = sfzmhm;
    }

    public String getSfzmhm()
    {
        return sfzmhm;
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
    public void setNum(Integer num)
    {
        this.num = num;
    }

    public Integer getNum()
    {
        return num;
    }
    public void setRdkssj(Date rdkssj)
    {
        this.rdkssj = rdkssj;
    }

    public Date getRdkssj()
    {
        return rdkssj;
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
            .append("sfzmhm", getSfzmhm())
            .append("glbm", getGlbm())
            .append("xm", getXm())
            .append("num", getNum())
            .append("rdkssj", getRdkssj())
            .toString();
    }
}
