package com.huitong.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.huitong.common.annotation.Excel;
import com.huitong.common.core.domain.BaseEntity;

/**
 * 执法设备无备案图片统计对象 device_no_pic
 * 
 * @author huitong
 * @date 2025-04-01
 */
public class DeviceNoPic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String sbbh;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String sbmc;

    /** 管理部门 */
    @Excel(name = "管理部门")
    private String glbm;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
    public void setGlbm(String glbm) 
    {
        this.glbm = glbm;
    }

    public String getGlbm() 
    {
        return glbm;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sbbh", getSbbh())
            .append("sbmc", getSbmc())
            .append("glbm", getGlbm())
            .toString();
    }
}
