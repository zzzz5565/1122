package com.huitong.business.domain;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.huitong.common.annotation.Excel;
import com.huitong.common.core.domain.BaseEntity;

/**
 * 设备信息对象 dev_vio_equipment
 *
 * @author huitong
 * @date 2025-06-18
 */
public class DevVioEquipment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 管理部门 */
    @Excel(name = "管理部门")
    private String glbm;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String bmmc;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String sbbh;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String sblx;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String sbmc;

    /** 状态 */
    @Excel(name = "状态")
    private Integer zt;
    private Integer zt2;

    /** 地址 */
    @Excel(name = "地址")
    private String szdd;

    /** 设备品牌 */
//    @Excel(name = "设备品牌")
    private String sbpp;

    /** 启用日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Excel(name = "启用日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date qyrq;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date shsj;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date gxsj;

    /** 违法数量 */
    @Excel(name = "违法数量")
    private String shuliang;

    /** 预警日期 */
    @Excel(name = "预警日期", width = 30, dateFormat = "yyyy-MM-dd")
    private String yjrq;

    /** 预警类型 */
    @Excel(name = "预警类型")
    private String yjlx;

    /** 每天日期 */
    private String daily;

    private Map<String, Object> params;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setGlbm(String glbm)
    {
        this.glbm = glbm;
    }

    public String getGlbm()
    {
        return glbm;
    }
    public void setBmmc(String bmmc)
    {
        this.bmmc = bmmc;
    }

    public String getBmmc()
    {
        return bmmc;
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
    public void setSbmc(String sbmc)
    {
        this.sbmc = sbmc;
    }

    public String getSbmc()
    {
        return sbmc;
    }
    public void setZt(Integer zt)
    {
        this.zt = zt;
    }

    public Integer getZt()
    {
        return zt;
    }

    public Integer getZt2() {
        return zt2;
    }

    public void setZt2(Integer zt2) {
        this.zt2 = zt2;
    }

    public void setSzdd(String szdd)
    {
        this.szdd = szdd;
    }

    public String getSzdd()
    {
        return szdd;
    }
    public void setSbpp(String sbpp)
    {
        this.sbpp = sbpp;
    }

    public String getSbpp()
    {
        return sbpp;
    }
    public void setQyrq(Date qyrq)
    {
        this.qyrq = qyrq;
    }

    public Date getQyrq()
    {
        return qyrq;
    }

    public String getShuliang() {
        return shuliang;
    }

    public void setShuliang(String shuliang) {
        this.shuliang = shuliang;
    }

    public String getYjrq() {
        return yjrq;
    }

    public void setYjrq(String yjrq) {
        this.yjrq = yjrq;
    }

    public String getYjlx() {
        return yjlx;
    }

    public void setYjlx(String yjlx) {
        this.yjlx = yjlx;
    }

    public String getDaily() {
        return daily;
    }

    public void setDaily(String daily) {
        this.daily = daily;
    }

    public Date getShsj() {
        return shsj;
    }

    public void setShsj(Date shsj) {
        this.shsj = shsj;
    }

    public Date getGxsj() {
        return gxsj;
    }

    public void setGxsj(Date gxsj) {
        this.gxsj = gxsj;
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
            .append("glbm", getGlbm())
            .append("bmmc", getBmmc())
            .append("sbbh", getSbbh())
            .append("sblx", getSblx())
            .append("sbmc", getSbmc())
            .append("zt", getZt())
            .append("szdd", getSzdd())
            .append("sbpp", getSbpp())
            .append("qyrq", getQyrq())
            .toString();
    }
}
