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
 * 执法设备无数据统计对象 device_no_data
 *
 * @author huitong
 * @date 2025-04-01
 */
public class DeviceNoData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String bmmc;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String sbmc;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String sbbh;

    /** 采集时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "采集时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date cjsj;

    /** 违法时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "违法时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date wfsj;

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
    public void setSbmc(String sbmc)
    {
        this.sbmc = sbmc;
    }

    public String getSbmc()
    {
        return sbmc;
    }
    public void setSbbh(String sbbh)
    {
        this.sbbh = sbbh;
    }

    public String getSbbh()
    {
        return sbbh;
    }
    public void setCjsj(Date cjsj)
    {
        this.cjsj = cjsj;
    }

    public Date getCjsj()
    {
        return cjsj;
    }
    public void setWfsj(Date wfsj)
    {
        this.wfsj = wfsj;
    }

    public Date getWfsj()
    {
        return wfsj;
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
            .append("bmmc", getBmmc())
            .append("sbmc", getSbmc())
            .append("sbbh", getSbbh())
            .append("cjsj", getCjsj())
            .append("wfsj", getWfsj())
            .toString();
    }
}
