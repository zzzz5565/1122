package com.huitong.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.huitong.common.annotation.Excel;
import com.huitong.common.core.domain.BaseEntity;

/**
 * 在用设备执法数据统计对象 dev_in_use
 * 
 * @author jsj
 * @date 2025-08-14
 */
public class DevInUse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 预警日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预警日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date yjrq;

    /** 管理部门 */
    @Excel(name = "管理部门")
    private String glbm;

    /** 部门编码 */
    @Excel(name = "部门编码")
    private String bmbm;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String sbbh;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String sblx;

    /** 试用状态 */
    @Excel(name = "试用状态")
    private String syzt;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String sbmc;

    /** 抓拍量 */
    @Excel(name = "抓拍量")
    private String zpl;

    /** 试用量 */
    @Excel(name = "试用量")
    private String syl;

    /** 待初审量 */
    @Excel(name = "待初审量")
    private String dcsl;

    /** 历史待初审量 */
    @Excel(name = "历史待初审量")
    private String lsdcsl;

    /** 待核对量 */
    @Excel(name = "待核对量")
    private String dhdl;

    /** 历史待核对量 */
    @Excel(name = "历史待核对量")
    private String lsdhdl;

    /** 已上传量 */
    @Excel(name = "已上传量")
    private String yscl;

    /** 初审作废量 */
    @Excel(name = "初审作废量")
    private String cszfl;

    /** 复审作废量 */
    @Excel(name = "复审作废量")
    private String fszfl;

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
    public void setSblx(String sblx) 
    {
        this.sblx = sblx;
    }

    public String getSblx() 
    {
        return sblx;
    }
    public void setSyzt(String syzt) 
    {
        this.syzt = syzt;
    }

    public String getSyzt() 
    {
        return syzt;
    }
    public void setSbmc(String sbmc) 
    {
        this.sbmc = sbmc;
    }

    public String getSbmc() 
    {
        return sbmc;
    }
    public void setZpl(String zpl) 
    {
        this.zpl = zpl;
    }

    public String getZpl() 
    {
        return zpl;
    }
    public void setSyl(String syl) 
    {
        this.syl = syl;
    }

    public String getSyl() 
    {
        return syl;
    }
    public void setDcsl(String dcsl) 
    {
        this.dcsl = dcsl;
    }

    public String getDcsl() 
    {
        return dcsl;
    }
    public void setLsdcsl(String lsdcsl) 
    {
        this.lsdcsl = lsdcsl;
    }

    public String getLsdcsl() 
    {
        return lsdcsl;
    }
    public void setDhdl(String dhdl) 
    {
        this.dhdl = dhdl;
    }

    public String getDhdl() 
    {
        return dhdl;
    }
    public void setLsdhdl(String lsdhdl) 
    {
        this.lsdhdl = lsdhdl;
    }

    public String getLsdhdl() 
    {
        return lsdhdl;
    }
    public void setYscl(String yscl) 
    {
        this.yscl = yscl;
    }

    public String getYscl() 
    {
        return yscl;
    }
    public void setCszfl(String cszfl) 
    {
        this.cszfl = cszfl;
    }

    public String getCszfl() 
    {
        return cszfl;
    }
    public void setFszfl(String fszfl) 
    {
        this.fszfl = fszfl;
    }

    public String getFszfl() 
    {
        return fszfl;
    }
    public void setCjsj(Date cjsj) 
    {
        this.cjsj = cjsj;
    }

    public Date getCjsj() 
    {
        return cjsj;
    }

    public String getBmbm() {
        return bmbm;
    }

    public void setBmbm(String bmbm) {
        this.bmbm = bmbm;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("yjrq", getYjrq())
            .append("glbm", getGlbm())
            .append("sbbh", getSbbh())
            .append("sblx", getSblx())
            .append("syzt", getSyzt())
            .append("sbmc", getSbmc())
            .append("zpl", getZpl())
            .append("syl", getSyl())
            .append("dcsl", getDcsl())
            .append("lsdcsl", getLsdcsl())
            .append("dhdl", getDhdl())
            .append("lsdhdl", getLsdhdl())
            .append("yscl", getYscl())
            .append("cszfl", getCszfl())
            .append("fszfl", getFszfl())
            .append("cjsj", getCjsj())
            .toString();
    }
}
