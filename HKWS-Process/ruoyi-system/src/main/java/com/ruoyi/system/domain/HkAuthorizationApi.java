package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 *  hk_authorization_api
 * 
 * @author ruoyi
 * @date 2021-01-11
 */
public class HkAuthorizationApi extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** apiID */
    private Long aId;

    /** api名称 */
    @Excel(name = "api名称")
    private String aName;

    /** api地址 */
    @Excel(name = "api地址")
    private String aAddress;

    /** api备注 */
    @Excel(name = "api备注")
    private String aDescription;

    /** api创建时间 */
    @Excel(name = "api创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date aCreateTime;

    /** api修改时间 */
    @Excel(name = "api修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date aUpdateTime;

    /** api创建人 */
    @Excel(name = "api创建人")
    private String aCreateAdmin;

    /** api类型 */
    @Excel(name = "api类型")
    private String aType;

    public void setaId(Long aId) 
    {
        this.aId = aId;
    }

    public Long getaId() 
    {
        return aId;
    }
    public void setaName(String aName) 
    {
        this.aName = aName;
    }

    public String getaName() 
    {
        return aName;
    }
    public void setaAddress(String aAddress) 
    {
        this.aAddress = aAddress;
    }

    public String getaAddress() 
    {
        return aAddress;
    }
    public void setaDescription(String aDescription) 
    {
        this.aDescription = aDescription;
    }

    public String getaDescription() 
    {
        return aDescription;
    }
    public void setaCreateTime(Date aCreateTime) 
    {
        this.aCreateTime = aCreateTime;
    }

    public Date getaCreateTime() 
    {
        return aCreateTime;
    }
    public void setaUpdateTime(Date aUpdateTime) 
    {
        this.aUpdateTime = aUpdateTime;
    }

    public Date getaUpdateTime() 
    {
        return aUpdateTime;
    }
    public void setaCreateAdmin(String aCreateAdmin) 
    {
        this.aCreateAdmin = aCreateAdmin;
    }

    public String getaCreateAdmin() 
    {
        return aCreateAdmin;
    }
    public void setaType(String aType) 
    {
        this.aType = aType;
    }

    public String getaType() 
    {
        return aType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("aId", getaId())
            .append("aName", getaName())
            .append("aAddress", getaAddress())
            .append("aDescription", getaDescription())
            .append("aCreateTime", getaCreateTime())
            .append("aUpdateTime", getaUpdateTime())
            .append("aCreateAdmin", getaCreateAdmin())
            .append("aType", getaType())
            .toString();
    }
}
