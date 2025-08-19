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
 * 车辆查询异常用户对象 abnormal_user_query
 *
 * @author huitong
 * @date 2025-04-07
 */
public class AbnormalUserQuery extends BaseEntity
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

    /** 查询总数 */
    @Excel(name = "查询总数")
    private String cxzs;

    /** 月查询天数 */
    @Excel(name = "月查询天数")
    private String cxts;

    /** 查询时间 */
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Excel(name = "查询时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String sj;

    /** 单日最大查询 */
    @Excel(name = "单日最大查询")
    private String drzd;

    /** 月平均查询数 */
    @Excel(name = "月平均查询数")
    private String ypjcxs;

    /** 查询倍数 */
    @Excel(name = "查询倍数")
    private String cxbs;

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
    public void setCxzs(String cxzs)
    {
        this.cxzs = cxzs;
    }

    public String getCxzs()
    {
        return cxzs;
    }
    public void setCxts(String cxts)
    {
        this.cxts = cxts;
    }

    public String getCxts()
    {
        return cxts;
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
    public void setYpjcxs(String ypjcxs)
    {
        this.ypjcxs = ypjcxs;
    }

    public String getYpjcxs()
    {
        return ypjcxs;
    }
    public void setCxbs(String cxbs)
    {
        this.cxbs = cxbs;
    }

    public String getCxbs()
    {
        return cxbs;
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
            .append("cxzs", getCxzs())
            .append("cxts", getCxts())
            .append("sj", getSj())
            .append("drzd", getDrzd())
            .append("ypjcxs", getYpjcxs())
            .append("cxbs", getCxbs())
            .toString();
    }
}
