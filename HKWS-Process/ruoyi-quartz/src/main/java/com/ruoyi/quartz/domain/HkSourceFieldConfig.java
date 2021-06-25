package com.ruoyi.quartz.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 数据接入字段配置对象 hk_source_field_config
 * 
 * @author liuf
 * @date 2021-01-14
 */
public class HkSourceFieldConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Integer id;

    /** 数据源ID */
    @Excel(name = "数据源ID")
    private Integer sourceId;

    /**是否显示*/
    private String isShow; 
    
    /** 列名称 */
    @Excel(name = "列名称")
    private String columnName;
    
    /** 列描述 */
    @Excel(name = "列描述")
    private String columnComment;

    /** 列类型 */
    @Excel(name = "列类型")
    private String columnType;

    /** java类型 */
    @Excel(name = "java类型")
    private String javaType;

    /** 是否必填 */
    @Excel(name = "是否必填")
    private String isRequired;

    /** 来源列名称 */
    @Excel(name = "来源列名称")
    private String sourceColumnName;
    

    /** 来源列描述 */
    @Excel(name = "来源列描述")
    private String sourceColumnComment;

    /** 来源列类型 */
    @Excel(name = "来源列类型")
    private String sourceColumnType;

    /** 来源列java类型 */
    @Excel(name = "来源列java类型")
    private String sourceColumnJavaType;

    /** 默认值 */
    @Excel(name = "默认值")
    private String defaultValue;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    
    
    
    public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public void setSourceId(Integer sourceId) 
    {
        this.sourceId = sourceId;
    }

    public Integer getSourceId() 
    {
        return sourceId;
    }
    public void setColumnName(String columnName) 
    {
        this.columnName = columnName;
    }

    public String getColumnName() 
    {
        return columnName;
    }
    public void setColumnComment(String columnComment) 
    {
        this.columnComment = columnComment;
    }

    public String getColumnComment() 
    {
        return columnComment;
    }
    public void setColumnType(String columnType) 
    {
        this.columnType = columnType;
    }

    public String getColumnType() 
    {
        return columnType;
    }
    public void setJavaType(String javaType) 
    {
        this.javaType = javaType;
    }

    public String getJavaType() 
    {
        return javaType;
    }
    public void setIsRequired(String isRequired) 
    {
        this.isRequired = isRequired;
    }

    public String getIsRequired() 
    {
        return isRequired;
    }
    public void setSourceColumnName(String sourceColumnName) 
    {
        this.sourceColumnName = sourceColumnName;
    }

    public String getSourceColumnName() 
    {
        return sourceColumnName;
    }
    public void setSourceColumnComment(String sourceColumnComment) 
    {
        this.sourceColumnComment = sourceColumnComment;
    }

    public String getSourceColumnComment() 
    {
        return sourceColumnComment;
    }
    public void setSourceColumnType(String sourceColumnType) 
    {
        this.sourceColumnType = sourceColumnType;
    }

    public String getSourceColumnType() 
    {
        return sourceColumnType;
    }
    public void setSourceColumnJavaType(String sourceColumnJavaType) 
    {
        this.sourceColumnJavaType = sourceColumnJavaType;
    }

    public String getSourceColumnJavaType() 
    {
        return sourceColumnJavaType;
    }
    public void setDefaultValue(String defaultValue) 
    {
        this.defaultValue = defaultValue;
    }

    public String getDefaultValue() 
    {
        return defaultValue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sourceId", getSourceId())
            .append("columnName", getColumnName())
            .append("columnComment", getColumnComment())
            .append("columnType", getColumnType())
            .append("javaType", getJavaType())
            .append("isRequired", getIsRequired())
            .append("sourceColumnName", getSourceColumnName())
            .append("sourceColumnComment", getSourceColumnComment())
            .append("sourceColumnType", getSourceColumnType())
            .append("sourceColumnJavaType", getSourceColumnJavaType())
            .append("defaultValue", getDefaultValue())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
