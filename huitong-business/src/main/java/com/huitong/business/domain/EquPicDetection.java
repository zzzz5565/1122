package com.huitong.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.huitong.common.annotation.Excel;
import com.huitong.common.core.domain.BaseEntity;

/**
 * 执法设备备案图片检测对象 equ_pic_detection
 * 
 * @author hairun
 * @date 2025-03-25
 */
public class EquPicDetection extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 管理编号 */
    @Excel(name = "管理编号")
    private String glbm;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String sbbh;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String sbmc;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("glbm", getGlbm())
            .append("sbbh", getSbbh())
            .append("sbmc", getSbmc())
            .toString();
    }
}
