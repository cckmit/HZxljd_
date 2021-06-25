package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 居民/物业--申诉对象 xl_appeal_record
 *
 * @author ruoyi
 * @date 2021-06-03
 */
public class XlAppealRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 事件类型 */
    @Excel(name = "事件类型")
    private String eventType;

    /** 事件内容 */
    @Excel(name = "事件内容")
    private String eventContent;

    /** 居民申诉人 */
    @Excel(name = "居民申诉人")
    private String appealPerson;

    /** 居民申诉时间 */
    @Excel(name = "居民申诉时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date appealTime;

    /** 申诉内容 */
    @Excel(name = "申诉内容")
    private String appealContent;

    /** 申诉人联系方式 */
    @Excel(name = "申诉人联系方式")
    private String appealPersonPhone;

    /** 居民申诉图片 */
    @Excel(name = "居民申诉图片")
    private String appealImage;

    /** 小区名称 */
    @Excel(name = "小区名称")
    private String quartersName;

    /** 申诉物业 */
    @Excel(name = "申诉物业")
    private String appealProperty;

    /** 物业申诉时间 */
    @Excel(name = "物业申诉时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date appealPropertyTime;

    /** 物业申诉内容 */
    @Excel(name = "物业申诉内容")
    private String appealPropertyContent;

    /** 物业申诉图片 */
    @Excel(name = "物业申诉图片")
    private String appealPropertyImage;

    /** 申诉阶段 */
    @Excel(name = "申诉阶段")
    private String appealStage;

    /** 申诉结果 */
    @Excel(name = "申诉结果")
    private String appealResult;

    /** 申述结果时间 */
    @Excel(name = "申述结果时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date appealResultTime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setEventType(String eventType)
    {
        this.eventType = eventType;
    }

    public String getEventType()
    {
        return eventType;
    }
    public void setEventContent(String eventContent)
    {
        this.eventContent = eventContent;
    }

    public String getEventContent()
    {
        return eventContent;
    }
    public void setAppealPerson(String appealPerson)
    {
        this.appealPerson = appealPerson;
    }

    public String getAppealPerson()
    {
        return appealPerson;
    }
    public void setAppealTime(Date appealTime)
    {
        this.appealTime = appealTime;
    }

    public Date getAppealTime()
    {
        return appealTime;
    }
    public void setAppealContent(String appealContent)
    {
        this.appealContent = appealContent;
    }

    public String getAppealContent()
    {
        return appealContent;
    }
    public void setAppealPersonPhone(String appealPersonPhone)
    {
        this.appealPersonPhone = appealPersonPhone;
    }

    public String getAppealPersonPhone()
    {
        return appealPersonPhone;
    }
    public void setAppealImage(String appealImage)
    {
        this.appealImage = appealImage;
    }

    public String getAppealImage()
    {
        return appealImage;
    }
    public void setQuartersName(String quartersName)
    {
        this.quartersName = quartersName;
    }

    public String getQuartersName()
    {
        return quartersName;
    }
    public void setAppealProperty(String appealProperty)
    {
        this.appealProperty = appealProperty;
    }

    public String getAppealProperty()
    {
        return appealProperty;
    }
    public void setAppealPropertyTime(Date appealPropertyTime)
    {
        this.appealPropertyTime = appealPropertyTime;
    }

    public Date getAppealPropertyTime()
    {
        return appealPropertyTime;
    }
    public void setAppealPropertyContent(String appealPropertyContent)
    {
        this.appealPropertyContent = appealPropertyContent;
    }

    public String getAppealPropertyContent()
    {
        return appealPropertyContent;
    }
    public void setAppealPropertyImage(String appealPropertyImage)
    {
        this.appealPropertyImage = appealPropertyImage;
    }

    public String getAppealPropertyImage()
    {
        return appealPropertyImage;
    }
    public void setAppealStage(String appealStage)
    {
        this.appealStage = appealStage;
    }

    public String getAppealStage()
    {
        return appealStage;
    }
    public void setAppealResult(String appealResult)
    {
        this.appealResult = appealResult;
    }

    public String getAppealResult()
    {
        return appealResult;
    }
    public void setAppealResultTime(Date appealResultTime)
    {
        this.appealResultTime = appealResultTime;
    }

    public Date getAppealResultTime()
    {
        return appealResultTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("eventType", getEventType())
                .append("eventContent", getEventContent())
                .append("appealPerson", getAppealPerson())
                .append("appealTime", getAppealTime())
                .append("appealContent", getAppealContent())
                .append("appealPersonPhone", getAppealPersonPhone())
                .append("appealImage", getAppealImage())
                .append("quartersName", getQuartersName())
                .append("appealProperty", getAppealProperty())
                .append("appealPropertyTime", getAppealPropertyTime())
                .append("appealPropertyContent", getAppealPropertyContent())
                .append("appealPropertyImage", getAppealPropertyImage())
                .append("appealStage", getAppealStage())
                .append("appealResult", getAppealResult())
                .append("appealResultTime", getAppealResultTime())
                .toString();
    }
}
