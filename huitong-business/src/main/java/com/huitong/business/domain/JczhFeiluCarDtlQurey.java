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
 * 集成指挥平台查询非鲁车明细对象 jczh_feilu_car_dtl_qurey
 *
 * @author huitong
 * @date 2025-05-15
 */
public class JczhFeiluCarDtlQurey extends BaseEntity
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

    /** 号牌号码 */
    @Excel(name = "号牌号码")
    private String hphm;

    /** ip */
    @Excel(name = "ip")
    private String ip;

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
    public void setHphm(String hphm)
    {
        this.hphm = hphm;
    }

    public String getHphm()
    {
        return hphm;
    }
    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getIp()
    {
        return ip;
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
            .append("hphm", getHphm())
            .append("ip", getIp())
            .append("cxsj", getCxsj())
            .toString();
    }
}
