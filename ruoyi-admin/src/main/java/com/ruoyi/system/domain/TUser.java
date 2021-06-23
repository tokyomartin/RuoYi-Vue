package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 t_user
 * 
 * @author ruoyi
 * @date 2021-06-23
 */
public class TUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long id;

    /** 用户UID */
    @Excel(name = "用户UID")
    private String Uid;

    /** 用户名 */
    @Excel(name = "用户名")
    private String Name;

    /** 用户显示昵称 */
    @Excel(name = "用户显示昵称")
    private String DisplayName;

    /** 性别 */
    @Excel(name = "性别")
    private Long Gender;

    /** 用户portrait */
    @Excel(name = "用户portrait")
    private String Portrait;

    /** 手机号 */
    @Excel(name = "手机号")
    private String Mobile;

    /** 邮件 */
    @Excel(name = "邮件")
    private String Email;

    /** 地址 */
    @Excel(name = "地址")
    private String Address;

    /** 公司名 */
    @Excel(name = "公司名")
    private String Company;

    /** 社交 */
    @Excel(name = "社交")
    private String Social;

    /** 密码 */
    @Excel(name = "密码")
    private String PasswdMd5;

    /** 密码salt */
    @Excel(name = "密码salt")
    private String Salt;

    /** 额外的 */
    @Excel(name = "额外的")
    private String Extra;

    /** 用户类型 */
    @Excel(name = "用户类型")
    private Integer Type;

    /** 时间 */
    @Excel(name = "时间")
    private Long Dt;

    /** 删除 */
    @Excel(name = "删除")
    private Integer Deleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUid(String Uid) 
    {
        this.Uid = Uid;
    }

    public String getUid() 
    {
        return Uid;
    }
    public void setName(String Name) 
    {
        this.Name = Name;
    }

    public String getName() 
    {
        return Name;
    }
    public void setDisplayName(String DisplayName) 
    {
        this.DisplayName = DisplayName;
    }

    public String getDisplayName() 
    {
        return DisplayName;
    }
    public void setGender(Long Gender) 
    {
        this.Gender = Gender;
    }

    public Long getGender() 
    {
        return Gender;
    }
    public void setPortrait(String Portrait) 
    {
        this.Portrait = Portrait;
    }

    public String getPortrait() 
    {
        return Portrait;
    }
    public void setMobile(String Mobile) 
    {
        this.Mobile = Mobile;
    }

    public String getMobile() 
    {
        return Mobile;
    }
    public void setEmail(String Email) 
    {
        this.Email = Email;
    }

    public String getEmail() 
    {
        return Email;
    }
    public void setAddress(String Address) 
    {
        this.Address = Address;
    }

    public String getAddress() 
    {
        return Address;
    }
    public void setCompany(String Company) 
    {
        this.Company = Company;
    }

    public String getCompany() 
    {
        return Company;
    }
    public void setSocial(String Social) 
    {
        this.Social = Social;
    }

    public String getSocial() 
    {
        return Social;
    }
    public void setPasswdMd5(String PasswdMd5) 
    {
        this.PasswdMd5 = PasswdMd5;
    }

    public String getPasswdMd5() 
    {
        return PasswdMd5;
    }
    public void setSalt(String Salt) 
    {
        this.Salt = Salt;
    }

    public String getSalt() 
    {
        return Salt;
    }
    public void setExtra(String Extra) 
    {
        this.Extra = Extra;
    }

    public String getExtra() 
    {
        return Extra;
    }
    public void setType(Integer Type) 
    {
        this.Type = Type;
    }

    public Integer getType() 
    {
        return Type;
    }
    public void setDt(Long Dt) 
    {
        this.Dt = Dt;
    }

    public Long getDt() 
    {
        return Dt;
    }
    public void setDeleted(Integer Deleted) 
    {
        this.Deleted = Deleted;
    }

    public Integer getDeleted() 
    {
        return Deleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("Uid", getUid())
            .append("Name", getName())
            .append("DisplayName", getDisplayName())
            .append("Gender", getGender())
            .append("Portrait", getPortrait())
            .append("Mobile", getMobile())
            .append("Email", getEmail())
            .append("Address", getAddress())
            .append("Company", getCompany())
            .append("Social", getSocial())
            .append("PasswdMd5", getPasswdMd5())
            .append("Salt", getSalt())
            .append("Extra", getExtra())
            .append("Type", getType())
            .append("Dt", getDt())
      //      .append("Createtime", getCreatetime())
            .append("Deleted", getDeleted())
            .toString();
    }
}
