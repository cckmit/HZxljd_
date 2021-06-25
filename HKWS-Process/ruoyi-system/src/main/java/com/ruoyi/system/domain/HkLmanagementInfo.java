package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 自定义标签对象 hk_custom_lmanagement_info
 * 
 * @author ruoyi
 * @date 2021-05-07
 */
public class HkLmanagementInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标签ID */
    private Long lmId;

    /** 标签名称 */
    @Excel(name = "标签名称")
    private String lmName;

    /** 标签区域配置 */
    @Excel(name = "标签区域配置")
    private String lmRegion;

    /** 标签事件类型配置 */
    @Excel(name = "标签事件类型配置")
    private String lmEventType;

    /** 标签权限配置 */
    @Excel(name = "标签权限配置")
    private String lmAuth;

    public void setLmId(Long lmId) 
    {
        this.lmId = lmId;
    }

    public Long getLmId() 
    {
        return lmId;
    }
    public void setLmName(String lmName) 
    {
        this.lmName = lmName;
    }

    public String getLmName() 
    {
        return lmName;
    }
    public void setLmRegion(String lmRegion) 
    {
        this.lmRegion = lmRegion;
    }

    public String getLmRegion() 
    {
        return lmRegion;
    }
    public void setLmEventType(String lmEventType) 
    {
        this.lmEventType = lmEventType;
    }

    public String getLmEventType() 
    {
        return lmEventType;
    }
    public void setLmAuth(String lmAuth) 
    {
        this.lmAuth = lmAuth;
    }

    public String getLmAuth() 
    {
        return lmAuth;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("lmId", getLmId())
            .append("lmName", getLmName())
            .append("remark", getRemark())
            .append("lmRegion", getLmRegion())
            .append("lmEventType", getLmEventType())
            .append("lmAuth", getLmAuth())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
