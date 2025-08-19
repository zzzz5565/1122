package com.huitong.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.huitong.common.annotation.Excel;
import com.huitong.common.core.domain.BaseEntity;

/**
 * 设备预警对象 dev_vio_equ_warning
 * 
 * @author jsj
 * @date 2025-08-13
 */
public class DevVioEquWarningDept extends BaseEntity
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

    /** 违法数量 */
    @Excel(name = "违法数量")
    private String shuliang;

    /** 违法行为 */
    @Excel(name = "违法行为")
    private String wfxw;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cjsj;

    /** 无数据上传 */
    @Excel(name = "无数据上传")
    private String wsjsc;

    /** 状态异常变化 */
    @Excel(name = "状态异常变化")
    private String ztyc;

    /** 抓拍量异常 */
    @Excel(name = "抓拍量异常")
    private String zplyc;

    /** 数据激增 */
    @Excel(name = "数据激增")
    private String sjjz;

    /** 数据巨减 */
    @Excel(name = "数据巨减")
    private String sjjj;

    /** 初审异常 */
    @Excel(name = "初审异常")
    private String csyc;

    /** 作废率 */
    private String zfl;
    private String zpl;
    private String cszfl;
    private String sblx;
    private String sbmc;
    private String zt;
    private String zt2;
    private Date preDate;
    private Date endDate;
    private String pjz;
    private String result;

    /** 比值 */
    private String bz;

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
    public void setYjllx(Integer yjllx) 
    {
        this.yjllx = yjllx;
    }

    public Integer getYjllx() 
    {
        return yjllx;
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
    public void setWfxw(String wfxw) 
    {
        this.wfxw = wfxw;
    }

    public String getWfxw() 
    {
        return wfxw;
    }
    public void setCjsj(Date cjsj) 
    {
        this.cjsj = cjsj;
    }

    public Date getCjsj() 
    {
        return cjsj;
    }
    public void setWsjsc(String wsjsc) 
    {
        this.wsjsc = wsjsc;
    }

    public String getWsjsc() 
    {
        return wsjsc;
    }
    public void setZtyc(String ztyc) 
    {
        this.ztyc = ztyc;
    }

    public String getZtyc() 
    {
        return ztyc;
    }
    public void setZplyc(String zplyc) 
    {
        this.zplyc = zplyc;
    }

    public String getZplyc() 
    {
        return zplyc;
    }
    public void setSjjz(String sjjz) 
    {
        this.sjjz = sjjz;
    }

    public String getSjjz() 
    {
        return sjjz;
    }
    public void setSjjj(String sjjj) 
    {
        this.sjjj = sjjj;
    }

    public String getSjjj() 
    {
        return sjjj;
    }
    public void setCsyc(String csyc) 
    {
        this.csyc = csyc;
    }

    public String getCsyc() 
    {
        return csyc;
    }
    public void setZfl(String zfl) 
    {
        this.zfl = zfl;
    }

    public String getZfl()
    {
        return zfl;
    }
    public void setBz(String bz)
    {
        this.bz = bz;
    }

    public String getZpl() {
        return zpl;
    }

    public void setZpl(String zpl) {
        this.zpl = zpl;
    }

    public String getCszfl() {
        return cszfl;
    }

    public void setCszfl(String cszfl) {
        this.cszfl = cszfl;
    }

    public String getSblx() {
        return sblx;
    }

    public void setSblx(String sblx) {
        this.sblx = sblx;
    }

    public String getSbmc() {
        return sbmc;
    }

    public void setSbmc(String sbmc) {
        this.sbmc = sbmc;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getZt2() {
        return zt2;
    }

    public void setZt2(String zt2) {
        this.zt2 = zt2;
    }

    public Date getPreDate() {
        return preDate;
    }

    public void setPreDate(Date preDate) {
        this.preDate = preDate;
    }

    public String getBz()
    {
        return bz;
    }

    public String getPjz() {
        return pjz;
    }

    public void setPjz(String pjz) {
        this.pjz = pjz;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("yjrq", getYjrq())
            .append("glbm", getGlbm())
            .append("sbbh", getSbbh())
            .append("yjllx", getYjllx())
            .append("yjlx", getYjlx())
            .append("shuliang", getShuliang())
            .append("wfxw", getWfxw())
            .append("cjsj", getCjsj())
            .append("wsjsc", getWsjsc())
            .append("ztyc", getZtyc())
            .append("zplyc", getZplyc())
            .append("sjjz", getSjjz())
            .append("sjjj", getSjjj())
            .append("csyc", getCsyc())
            .append("zfl", getZfl())
            .append("bz", getBz())
            .toString();
    }
}
