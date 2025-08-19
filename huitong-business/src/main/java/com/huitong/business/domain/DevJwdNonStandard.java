package com.huitong.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.huitong.common.annotation.Excel;
import com.huitong.common.core.domain.BaseEntity;

/**
 * 卡口经纬度不规范统计对象 dev_jwd_non_standard
 * 
 * @author huitong
 * @date 2025-04-01
 */
public class DevJwdNonStandard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 卡口编号 */
    @Excel(name = "卡口编号")
    private String kkbh;

    /** 卡口类型 */
    @Excel(name = "卡口类型")
    private String kklx;

    /** 卡口名称 */
    @Excel(name = "卡口名称")
    private String kkmc;

    /** 管理部门 */
    @Excel(name = "管理部门")
    private String glbm;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String bmmc;

    /** 行政区划 */
    @Excel(name = "行政区划")
    private String xzqh;

    /** 道路代码 */
    @Excel(name = "道路代码")
    private String dldm;

    /** 道路类型 */
    @Excel(name = "道路类型")
    private String dllx;

    /** 路口号 */
    @Excel(name = "路口号")
    private String lkh;

    /** 道路名称 */
    @Excel(name = "道路名称")
    private String dlmc;

    /** 经度 */
    @Excel(name = "经度")
    private String kkjd;

    /** 纬度 */
    @Excel(name = "纬度")
    private String kkwd;

    /** 抓拍方向 */
    @Excel(name = "抓拍方向")
    private String zpfx;

    /** 设备状态 */
    @Excel(name = "设备状态")
    private String kkzt;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date gxsj;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setKkbh(String kkbh) 
    {
        this.kkbh = kkbh;
    }

    public String getKkbh() 
    {
        return kkbh;
    }
    public void setKklx(String kklx) 
    {
        this.kklx = kklx;
    }

    public String getKklx() 
    {
        return kklx;
    }
    public void setKkmc(String kkmc) 
    {
        this.kkmc = kkmc;
    }

    public String getKkmc() 
    {
        return kkmc;
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
    public void setXzqh(String xzqh) 
    {
        this.xzqh = xzqh;
    }

    public String getXzqh() 
    {
        return xzqh;
    }
    public void setDldm(String dldm) 
    {
        this.dldm = dldm;
    }

    public String getDldm() 
    {
        return dldm;
    }
    public void setDllx(String dllx) 
    {
        this.dllx = dllx;
    }

    public String getDllx() 
    {
        return dllx;
    }
    public void setLkh(String lkh) 
    {
        this.lkh = lkh;
    }

    public String getLkh() 
    {
        return lkh;
    }
    public void setDlmc(String dlmc) 
    {
        this.dlmc = dlmc;
    }

    public String getDlmc() 
    {
        return dlmc;
    }
    public void setKkjd(String kkjd) 
    {
        this.kkjd = kkjd;
    }

    public String getKkjd() 
    {
        return kkjd;
    }
    public void setKkwd(String kkwd) 
    {
        this.kkwd = kkwd;
    }

    public String getKkwd() 
    {
        return kkwd;
    }
    public void setZpfx(String zpfx) 
    {
        this.zpfx = zpfx;
    }

    public String getZpfx() 
    {
        return zpfx;
    }
    public void setKkzt(String kkzt) 
    {
        this.kkzt = kkzt;
    }

    public String getKkzt() 
    {
        return kkzt;
    }
    public void setGxsj(Date gxsj) 
    {
        this.gxsj = gxsj;
    }

    public Date getGxsj() 
    {
        return gxsj;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("kkbh", getKkbh())
            .append("kklx", getKklx())
            .append("kkmc", getKkmc())
            .append("glbm", getGlbm())
            .append("bmmc", getBmmc())
            .append("xzqh", getXzqh())
            .append("dldm", getDldm())
            .append("dllx", getDllx())
            .append("lkh", getLkh())
            .append("dlmc", getDlmc())
            .append("kkjd", getKkjd())
            .append("kkwd", getKkwd())
            .append("zpfx", getZpfx())
            .append("kkzt", getKkzt())
            .append("gxsj", getGxsj())
            .toString();
    }
}
