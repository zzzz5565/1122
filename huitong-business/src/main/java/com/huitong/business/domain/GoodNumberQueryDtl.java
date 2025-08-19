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
 * 靓号综合查询详情对象 good_number_query_dtl
 *
 * @author huitong
 * @date 2025-03-25
 */
public class GoodNumberQueryDtl extends BaseEntity
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

    /** 号牌号码 */
    @Excel(name = "号牌号码")
    private String hphm;

    /** 号牌种类 */
    @Excel(name = "号牌种类")
    private String hpzl;

    /** ip地址 */
    @Excel(name = "ip地址")
    private String ip;

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
    public void setHphm(String hphm)
    {
        this.hphm = hphm;
    }

    public String getHphm()
    {
        return hphm;
    }
    public void setHpzl(String hpzl)
    {
        this.hpzl = hpzl;
    }

    public String getHpzl()
    {
        return hpzl;
    }
    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getIp()
    {
        return ip;
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
            .append("hphm", getHphm())
            .append("hpzl", getHpzl())
            .append("ip", getIp())
            .append("xrsj", getXrsj())
            .toString();
    }
}
