package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 标签对象 hk_lmanagement
 * 
 * @author ruoyi
 * @date 2021-04-19
 */
public class HkLmanagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标签ID */
    private Long lmId;

    /** 标签名称 */
    @Excel(name = "标签名称")
    private String lmName;

    /** 类型 */
    @Excel(name = "类型")
    private String lmType;

    /** 类型 */
    @Excel(name = "等级")
    private Integer level;

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
    public void setLmType(String lmType) 
    {
        this.lmType = lmType;
    }

    public String getLmType() 
    {
        return lmType;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("lmId", getLmId())
            .append("lmName", getLmName())
            .append("remark", getRemark())
            .append("lmType", getLmType())
            .append("level", getLevel())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
