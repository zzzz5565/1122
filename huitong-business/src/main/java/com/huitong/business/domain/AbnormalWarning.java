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
 * 违法数据异常预警统计对象 abnormal_warning
 *
 * @author huitong
 * @date 2025-04-14
 */
public class AbnormalWarning extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 管理部门 */
    @Excel(name = "管理部门")
    private String qh;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String bm;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String bh;

    /** 违法地址 */
    @Excel(name = "违法地址")
    private String mc;

    /** 违法行为 */
    @Excel(name = "违法行为")
    private String wf;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date rq;

    /** 数量 */
    @Excel(name = "数量")
    private Long sl;

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
    public void setQh(String qh)
    {
        this.qh = qh;
    }

    public String getQh()
    {
        return qh;
    }
    public void setBm(String bm)
    {
        this.bm = bm;
    }

    public String getBm()
    {
        return bm;
    }
    public void setBh(String bh)
    {
        this.bh = bh;
    }

    public String getBh()
    {
        return bh;
    }
    public void setMc(String mc)
    {
        this.mc = mc;
    }

    public String getMc()
    {
        return mc;
    }
    public void setWf(String wf)
    {
        this.wf = wf;
    }

    public String getWf()
    {
        return wf;
    }
    public void setRq(Date rq)
    {
        this.rq = rq;
    }

    public Date getRq()
    {
        return rq;
    }
    public void setSl(Long sl)
    {
        this.sl = sl;
    }

    public Long getSl()
    {
        return sl;
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
            .append("qh", getQh())
            .append("bm", getBm())
            .append("bh", getBh())
            .append("mc", getMc())
            .append("wf", getWf())
            .append("rq", getRq())
            .append("sl", getSl())
            .toString();
    }
}
