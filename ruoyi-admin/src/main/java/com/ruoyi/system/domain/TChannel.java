package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 t_channel
 * 
 * @author ruoyi
 * @date 2021-06-23
 */
public class TChannel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 频道ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String Cid;

    /** 频道名称 */
    @Excel(name = "频道名称")
    private String Name;

    /** 频道portrait */
    @Excel(name = "频道portrait")
    private String Portrait;

    /** 频道拥有者 */
    @Excel(name = "频道拥有者")
    private String Owner;

    /** 频道状态 */
    @Excel(name = "频道状态")
    private Long Status;

    /** 频道描述 */
    @Excel(name = "频道描述")
    private String Desc;

    /** 频道验证码 */
    @Excel(name = "频道验证码")
    private String Secret;

    /** 频道回调 */
    @Excel(name = "频道回调")
    private String Callback;

    /** 频道extra */
    @Excel(name = "频道extra")
    private String Extra;

    /** 自动 */
    @Excel(name = "自动")
    private Integer Automatic;

    /** 时间 */
    @Excel(name = "时间")
    private Long Dt;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCid(String Cid) 
    {
        this.Cid = Cid;
    }

    public String getCid() 
    {
        return Cid;
    }
    public void setName(String Name) 
    {
        this.Name = Name;
    }

    public String getName() 
    {
        return Name;
    }
    public void setPortrait(String Portrait) 
    {
        this.Portrait = Portrait;
    }

    public String getPortrait() 
    {
        return Portrait;
    }
    public void setOwner(String Owner) 
    {
        this.Owner = Owner;
    }

    public String getOwner() 
    {
        return Owner;
    }
    public void setStatus(Long Status) 
    {
        this.Status = Status;
    }

    public Long getStatus() 
    {
        return Status;
    }
    public void setDesc(String Desc) 
    {
        this.Desc = Desc;
    }

    public String getDesc() 
    {
        return Desc;
    }
    public void setSecret(String Secret) 
    {
        this.Secret = Secret;
    }

    public String getSecret() 
    {
        return Secret;
    }
    public void setCallback(String Callback) 
    {
        this.Callback = Callback;
    }

    public String getCallback() 
    {
        return Callback;
    }
    public void setExtra(String Extra) 
    {
        this.Extra = Extra;
    }

    public String getExtra() 
    {
        return Extra;
    }
    public void setAutomatic(Integer Automatic) 
    {
        this.Automatic = Automatic;
    }

    public Integer getAutomatic() 
    {
        return Automatic;
    }
    public void setDt(Long Dt) 
    {
        this.Dt = Dt;
    }

    public Long getDt() 
    {
        return Dt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("Cid", getCid())
            .append("Name", getName())
            .append("Portrait", getPortrait())
            .append("Owner", getOwner())
            .append("Status", getStatus())
            .append("Desc", getDesc())
            .append("Secret", getSecret())
            .append("Callback", getCallback())
            .append("Extra", getExtra())
            .append("Automatic", getAutomatic())
            .append("Dt", getDt())
            .toString();
    }
}
