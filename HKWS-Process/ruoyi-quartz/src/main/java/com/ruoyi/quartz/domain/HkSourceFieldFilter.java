package com.ruoyi.quartz.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 hk_source_field_filter
 * 
 * @author ruoyi
 * @date 2021-01-22
 */
public class HkSourceFieldFilter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 数据源ID */
    @Excel(name = "数据源ID")
    private Long sourceId;

    /** $column.columnComment */
    @Excel(name = "数据源ID")
    private String filterTitle;

    /** 过滤字段名称 */
    @Excel(name = "过滤字段名称")
    private String filterKey;

    /** 过滤值 */
    @Excel(name = "过滤值")
    private String filterValue;

    /** 运算符（大于、大于等于、等于、小于、小于等于） */
    @Excel(name = "运算符", readConverterExp = "大于、大于等于、等于、小于、小于等于")
    private String filterOperator;

    /** 值类型（1、字段，2、固定值） */
    @Excel(name = "值类型", readConverterExp = "1=、字段，2、固定值")
    private String valueSource;

    /** 是否必填（1：必填，0：非必填） */
    @Excel(name = "是否必填", readConverterExp = "1=：必填，0：非必填")
    private String isRequired;

    /** 源字段描述 */
    @Excel(name = "源字段描述")
    private String filterDesc;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSourceId(Long sourceId) 
    {
        this.sourceId = sourceId;
    }

    public Long getSourceId() 
    {
        return sourceId;
    }
    public void setFilterTitle(String filterTitle) 
    {
        this.filterTitle = filterTitle;
    }

    public String getFilterTitle() 
    {
        return filterTitle;
    }
    public void setFilterKey(String filterKey) 
    {
        this.filterKey = filterKey;
    }

    public String getFilterKey() 
    {
        return filterKey;
    }
    public void setFilterValue(String filterValue) 
    {
        this.filterValue = filterValue;
    }

    public String getFilterValue() 
    {
        return filterValue;
    }
    public void setFilterOperator(String filterOperator) 
    {
        this.filterOperator = filterOperator;
    }

    public String getFilterOperator() 
    {
        return filterOperator;
    }
    public void setValueSource(String valueSource) 
    {
        this.valueSource = valueSource;
    }

    public String getValueSource() 
    {
        return valueSource;
    }
    public void setIsRequired(String isRequired) 
    {
        this.isRequired = isRequired;
    }

    public String getIsRequired() 
    {
        return isRequired;
    }
    public void setFilterDesc(String filterDesc) 
    {
        this.filterDesc = filterDesc;
    }

    public String getFilterDesc() 
    {
        return filterDesc;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sourceId", getSourceId())
            .append("filterTitle", getFilterTitle())
            .append("filterKey", getFilterKey())
            .append("filterValue", getFilterValue())
            .append("filterOperator", getFilterOperator())
            .append("valueSource", getValueSource())
            .append("isRequired", getIsRequired())
            .append("filterDesc", getFilterDesc())
            .toString();
    }
}
