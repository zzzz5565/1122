package com.huitong.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.huitong.common.annotation.Excel;
import com.huitong.common.core.domain.BaseEntity;

/**
 * 违法数据上传记录对象 vio_surveil
 * 
 * @author jsj
 * @date 2025-08-22
 */
public class VioSurveil extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 预警日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预警日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date yjrq;

    /** 管理部门 */
    @Excel(name = "管理部门")
    private String glbm;

    /** 设备编号 (需要和 dev_vio_equiment 表关联) */
    @Excel(name = "设备编号 (需要和 dev_vio_equiment 表关联)")
    private String sbbh;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String sbmc;

    /** 违法时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "违法时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date wfsj;

    /** 状态 */
    @Excel(name = "状态")
    private String zt;

    /** 试用状态 */
    @Excel(name = "试用状态")
    private String syzt;

    private String wfxw;

    /** 采集时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "采集时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cjsj;

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
    public void setSbmc(String sbmc) 
    {
        this.sbmc = sbmc;
    }

    public String getSbmc() 
    {
        return sbmc;
    }
    public void setWfsj(Date wfsj) 
    {
        this.wfsj = wfsj;
    }

    public Date getWfsj() 
    {
        return wfsj;
    }
    public void setZt(String zt) 
    {
        this.zt = zt;
    }

    public String getZt() 
    {
        return zt;
    }
    public void setSyzt(String syzt) 
    {
        this.syzt = syzt;
    }

    public String getSyzt() 
    {
        return syzt;
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
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("yjrq", getYjrq())
            .append("glbm", getGlbm())
            .append("sbbh", getSbbh())
            .append("sbmc", getSbmc())
            .append("wfsj", getWfsj())
            .append("zt", getZt())
            .append("syzt", getSyzt())
            .append("cjsj", getCjsj())
            .toString();
    }
}
