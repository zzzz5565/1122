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
 * 反复查询同一辆车对象 check_same_car
 *
 * @author huitong
 * @date 2025-04-09
 */
public class CheckSameCar extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 账户 */
    @Excel(name = "账户")
    private String account;

    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String bmmc;

    /** 管理部门 */
    @Excel(name = "管理部门")
    private String glbm;

    /** ip */
    @Excel(name = "ip")
    private String ip;

    /** 号牌号码 */
    @Excel(name = "号牌号码")
    private String hphm;

    /** 数量 */
    @Excel(name = "数量")
    private Long sl;

    /** 插入时间 */
    private String timeDay;

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
    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getAccount()
    {
        return account;
    }
    public void setXm(String xm)
    {
        this.xm = xm;
    }

    public String getXm()
    {
        return xm;
    }
    public void setBmmc(String bmmc)
    {
        this.bmmc = bmmc;
    }

    public String getBmmc()
    {
        return bmmc;
    }
    public void setGlbm(String glbm)
    {
        this.glbm = glbm;
    }

    public String getGlbm()
    {
        return glbm;
    }
    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getIp()
    {
        return ip;
    }
    public void setHphm(String hphm)
    {
        this.hphm = hphm;
    }

    public String getHphm()
    {
        return hphm;
    }
    public void setSl(Long sl)
    {
        this.sl = sl;
    }

    public Long getSl()
    {
        return sl;
    }
    public void setTimeDay(String timeDay)
    {
        this.timeDay = timeDay;
    }

    public String getTimeDay()
    {
        return timeDay;
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
            .append("account", getAccount())
            .append("xm", getXm())
            .append("bmmc", getBmmc())
            .append("glbm", getGlbm())
            .append("ip", getIp())
            .append("hphm", getHphm())
            .append("sl", getSl())
            .append("timeDay", getTimeDay())
            .toString();
    }
}
