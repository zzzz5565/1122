package com.huitong.business.domain;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.huitong.common.annotation.Excel;
import com.huitong.common.core.domain.BaseEntity;

/**
 * 设备预警对象 dev_vio_equ_warning
 *
 * @author hr
 * @date 2025-06-18
 */
public class DevVioEquWarning extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 预警日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预警日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date yjrq;

    /** 管理部门 */
    @Excel(name = "管理部门")
    private String glbm;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String sbbh;

    /** 预警类型 */
    @Excel(name = "预警类型")
    private Integer yjllx;

    /** 预警内容 */
    @Excel(name = "预警内容")
    private Integer yjlx;

    /** 设备数量 */
    @Excel(name = "设备数量")
    private String shuliang;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date cjsj;

    /** 违法行为 */
    @Excel(name = "违法行为")
    private String wfxw;

    private Map<String, Object> params;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setYjrq(Date yjrq)
    {
        this.yjrq = yjrq;
    }

    public Date getYjrq()
    {
        return yjrq;
    }
    public void setGlbm(String glbm)
    {
        this.glbm = glbm;
    }

    public String getGlbm()
    {
        return glbm;
    }
    public void setSbbh(String sbbh)
    {
        this.sbbh = sbbh;
    }

    public String getSbbh()
    {
        return sbbh;
    }
    public void setYjlx(Integer yjlx)
    {
        this.yjlx = yjlx;
    }

    public Integer getYjlx()
    {
        return yjlx;
    }
    public void setShuliang(String shuliang)
    {
        this.shuliang = shuliang;
    }

    public String getShuliang()
    {
        return shuliang;
    }
    public void setCjsj(Date cjsj)
    {
        this.cjsj = cjsj;
    }

    public Date getCjsj()
    {
        return cjsj;
    }

    public String getWfxw() {
        return wfxw;
    }

    public void setWfxw(String wfxw) {
        this.wfxw = wfxw;
    }

    @Override
    public Map<String, Object> getParams() {
        return params;
    }

    @Override
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Integer getYjllx() {
        return yjllx;
    }

    public void setYjllx(Integer yjllx) {
        this.yjllx = yjllx;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("yjrq", getYjrq())
            .append("glbm", getGlbm())
            .append("sbbh", getSbbh())
            .append("yjlx", getYjlx())
            .append("shuliang", getShuliang())
            .append("cjsj", getCjsj())
            .toString();
    }
}
