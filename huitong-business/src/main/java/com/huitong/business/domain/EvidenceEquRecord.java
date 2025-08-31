package com.huitong.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.huitong.common.annotation.Excel;
import com.huitong.common.core.domain.BaseEntity;

/**
 * 执法取证设备备案统计对象 evidence_equ_record
 * 
 * @author hairun
 * @date 2025-03-20
 */
public class EvidenceEquRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 大队编号 */
    @Excel(name = "大队编号")
    private String glbm;

    @Excel(name="部门编号")
    private String bmbm;

    /** 大队名称 */
    @Excel(name = "大队名称")
    private String bmmc;

    /** 备案数量 */
    @Excel(name = "备案数量")
    private String basl;

    /** 启用数量 */
    @Excel(name = "启用数量")
    private String qysl;

    /** 作废数量 */
    @Excel(name = "作废数量")
    private String zfsl;

    /** 停用数量 */
    @Excel(name = "停用数量")
    private String tysl;

    /** 新增待审批数量 */
    @Excel(name = "新增待审批数量")
    private String xzdspsl;

    /** 状态正常设备审批中数量 */
    @Excel(name = "状态正常设备审批中数量")
    private String ztzcsbspzsl;

    /** 其它状态(上级停用)数量 */
    @Excel(name = "其它状态(上级停用)数量")
    private String qtztsl;

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
    public void setBasl(String basl) 
    {
        this.basl = basl;
    }

    public String getBasl() 
    {
        return basl;
    }
    public void setQysl(String qysl) 
    {
        this.qysl = qysl;
    }

    public String getQysl() 
    {
        return qysl;
    }
    public void setZfsl(String zfsl) 
    {
        this.zfsl = zfsl;
    }

    public String getZfsl() 
    {
        return zfsl;
    }
    public void setTysl(String tysl) 
    {
        this.tysl = tysl;
    }

    public String getTysl() 
    {
        return tysl;
    }
    public void setXzdspsl(String xzdspsl) 
    {
        this.xzdspsl = xzdspsl;
    }

    public String getXzdspsl() 
    {
        return xzdspsl;
    }
    public void setZtzcsbspzsl(String ztzcsbspzsl) 
    {
        this.ztzcsbspzsl = ztzcsbspzsl;
    }

    public String getZtzcsbspzsl() 
    {
        return ztzcsbspzsl;
    }
    public void setQtztsl(String qtztsl) 
    {
        this.qtztsl = qtztsl;
    }

    public String getQtztsl() 
    {
        return qtztsl;
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
            .append("glbm", getGlbm())
            .append("bmmc", getBmmc())
            .append("basl", getBasl())
            .append("qysl", getQysl())
            .append("zfsl", getZfsl())
            .append("tysl", getTysl())
            .append("xzdspsl", getXzdspsl())
            .append("ztzcsbspzsl", getZtzcsbspzsl())
            .append("qtztsl", getQtztsl())
            .toString();
    }
}
