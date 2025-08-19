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
 * 重要点位卡口运行稳定情况对象 dev_operation
 *
 * @author huitong
 * @date 2025-04-01
 */
public class DevOperation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 卡口编号 */
    @Excel(name = "卡口编号")
    private String kkbh;

    /** 卡口名称 */
    @Excel(name = "卡口名称")
    private String kkmc;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private String timeMin;

    /** 管理部门 */
    @Excel(name = "管理部门")
    private String glbm;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String bmmc;

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
    public void setKkbh(String kkbh)
    {
        this.kkbh = kkbh;
    }

    public String getKkbh()
    {
        return kkbh;
    }
    public void setKkmc(String kkmc)
    {
        this.kkmc = kkmc;
    }

    public String getKkmc()
    {
        return kkmc;
    }
    public void setTimeMin(String timeMin)
    {
        this.timeMin = timeMin;
    }

    public String getTimeMin()
    {
        return timeMin;
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
            .append("kkbh", getKkbh())
            .append("kkmc", getKkmc())
            .append("timeMin", getTimeMin())
            .append("glbm", getGlbm())
            .append("bmmc", getBmmc())
            .toString();
    }
}
