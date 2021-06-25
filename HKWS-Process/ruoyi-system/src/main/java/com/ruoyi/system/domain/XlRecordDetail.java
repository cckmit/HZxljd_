package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 网格管理-工作记录关联详情对象 xl_record_detail
 * 
 * @author ruoyi
 * @date 2021-06-04
 */
public class XlRecordDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 关联工作记录id */
    private Long recordId;

    /** 描述 */
    @Excel(name = "描述")
    private String describes;

    /** 处理结果 */
    @Excel(name = "处理结果")
    private String result;

    /** 处理意见 */
    @Excel(name = "处理意见")
    private String suggestion;

    /** 照片 */
    @Excel(name = "照片")
    private String picture;

    /** 反馈意见 */
    @Excel(name = "反馈意见")
    private String feedback;

    /** 创建日期 */
    @Excel(name = "创建日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }
    public void setDescribes(String describes) 
    {
        this.describes = describes;
    }

    public String getDescribes() 
    {
        return describes;
    }
    public void setResult(String result) 
    {
        this.result = result;
    }

    public String getResult() 
    {
        return result;
    }
    public void setSuggestion(String suggestion) 
    {
        this.suggestion = suggestion;
    }

    public String getSuggestion() 
    {
        return suggestion;
    }
    public void setPicture(String picture) 
    {
        this.picture = picture;
    }

    public String getPicture() 
    {
        return picture;
    }
    public void setFeedback(String feedback) 
    {
        this.feedback = feedback;
    }

    public String getFeedback() 
    {
        return feedback;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("recordId", getRecordId())
            .append("describes", getDescribes())
            .append("result", getResult())
            .append("suggestion", getSuggestion())
            .append("picture", getPicture())
            .append("feedback", getFeedback())
            .append("createDate", getCreateDate())
            .toString();
    }
}
