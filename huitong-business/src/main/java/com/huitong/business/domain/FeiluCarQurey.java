package com.huitong.business.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.huitong.common.annotation.Excel;
import com.huitong.common.core.domain.BaseEntity;

import java.util.Map;

/**
 * 查询非鲁车对象 feilu_car_qurey
 *
 * @author huitong
 * @date 2025-04-09
 */
public class FeiluCarQurey extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 账户 */
    @Excel(name = "账户")
    private String account;

    /** 非鲁车数量 */
    @Excel(name = "非鲁车数量")
    private Long num;

    /** 全部车数量 */
    @Excel(name = "全部车数量")
    private Long numall;

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
    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getAccount()
    {
        return account;
    }
    public void setNum(Long num)
    {
        this.num = num;
    }

    public Long getNum()
    {
        return num;
    }
    public void setNumall(Long numall)
    {
        this.numall = numall;
    }

    public Long getNumall()
    {
        return numall;
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
            .append("account", getAccount())
            .append("num", getNum())
            .append("numall", getNumall())
            .append("createTime", getCreateTime())
            .toString();
    }
}
