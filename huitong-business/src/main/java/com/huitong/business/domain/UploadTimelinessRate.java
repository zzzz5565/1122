package com.huitong.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.huitong.common.annotation.Excel;
import com.huitong.common.core.domain.BaseEntity;

/**
 * 上传及时率统计对象 upload_timeliness_rate
 * 
 * @author huitong
 * @date 2025-04-21
 */
public class UploadTimelinessRate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String bmmc;

    /** 卡口编号 */
    @Excel(name = "卡口编号")
    private String kkbh;

    /** 卡口名称 */
    @Excel(name = "卡口名称")
    private String kkmc;

    /** 上传及时数 */
    @Excel(name = "上传及时数")
    private Long timenum;

    /** 过车总数 */
    @Excel(name = "过车总数")
    private Long totalnum;

    /** 占比 */
    @Excel(name = "占比")
    private String timerate;

    /** 统计天数 */
    @Excel(name = "统计天数")
    private Long tjts;

    /** 统计日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "统计日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date tjrq;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBmmc(String bmmc) 
    {
        this.bmmc = bmmc;
    }

    public String getBmmc() 
    {
        return bmmc;
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
    public void setTimenum(Long timenum) 
    {
        this.timenum = timenum;
    }

    public Long getTimenum() 
    {
        return timenum;
    }
    public void setTotalnum(Long totalnum) 
    {
        this.totalnum = totalnum;
    }

    public Long getTotalnum() 
    {
        return totalnum;
    }
    public void setTimerate(String timerate) 
    {
        this.timerate = timerate;
    }

    public String getTimerate() 
    {
        return timerate;
    }
    public void setTjts(Long tjts) 
    {
        this.tjts = tjts;
    }

    public Long getTjts() 
    {
        return tjts;
    }
    public void setTjrq(Date tjrq) 
    {
        this.tjrq = tjrq;
    }

    public Date getTjrq() 
    {
        return tjrq;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bmmc", getBmmc())
            .append("kkbh", getKkbh())
            .append("kkmc", getKkmc())
            .append("timenum", getTimenum())
            .append("totalnum", getTotalnum())
            .append("timerate", getTimerate())
            .append("tjts", getTjts())
            .append("tjrq", getTjrq())
            .toString();
    }
}
