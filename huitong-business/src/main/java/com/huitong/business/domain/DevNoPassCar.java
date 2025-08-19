package com.huitong.business.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.huitong.common.annotation.Excel;
import com.huitong.common.core.domain.BaseEntity;

/**
 * 无过车数据卡口信息统计对象 dev_no_pass_car
 *
 * @author hairun
 * @date 2025-03-20
 */
public class DevNoPassCar extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 大队名称 */
    @Excel(name = "大队名称")
    private String bmmc;

    /** 卡口编号 */
    @Excel(name = "卡口编号")
    private String kkbh;

    /** 卡口名称 */
    @Excel(name = "卡口名称")
    private String kkmc;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd  HH:mm:ss")
    private Date gxsj;

    /** 统计日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "统计日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date tjrq;

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
    public void setBmmc(String bmmc)
    {
        this.bmmc = bmmc;
    }

    public String getBmmc()
    {
        return bmmc;
    }
    public void setKkbh(String kkbh)
    {
        this.kkbh = kkbh;
    }

    public String getKkbh()
    {
        return kkbh;
    }
    public void setKkmc(String kkmc)
    {
        this.kkmc = kkmc;
    }

    public String getKkmc()
    {
        return kkmc;
    }
    public void setGxsj(Date gxsj)
    {
        this.gxsj = gxsj;
    }

    public Date getGxsj()
    {
        return gxsj;
    }
    public void setTjrq(Date tjrq)
    {
        this.tjrq = tjrq;
    }

    public Date getTjrq()
    {
        return tjrq;
    }
    public Map<String, Object> getParams()
    {
        if (params == null)
        {
            params = new HashMap<>();
        }
        return params;
    }

    public void setParams(Map<String, Object> params)
    {
        this.params = params;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bmmc", getBmmc())
            .append("kkbh", getKkbh())
            .append("kkmc", getKkmc())
            .append("gxsj", getGxsj())
            .append("tjrq", getTjrq())
            .toString();
    }
}
