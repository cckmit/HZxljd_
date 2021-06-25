package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 【请填写功能名称】对象 hk_event_process_record
 * 
 * @author ruoyi
 * @date 2021-04-15
 */
public class HkEventProcessRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 事件处理结果表 */
    private Long id;

    /** uuid */
    @Excel(name = "uuid")
    private String recordId;

    /** 关联的事件标识(事件uuid) */
    @Excel(name = "关联的事件标识(事件uuid)")
    private String eventId;

    /** 事件处理人关联的区域标识 */
    @Excel(name = "事件处理人关联的区域标识")
    private String regionIndexCode;

    /** 事件处理人关联的区域名称 */
    @Excel(name = "事件处理人关联的区域名称")
    private String regionName;

    /** 传入的事件处理记录标识 */
    @Excel(name = "传入的事件处理记录标识")
    private String handlerRecordIndexCode;

    /** 事件处理人标识 */
    @Excel(name = "事件处理人标识")
    private String handlerIndexCode;

    /** 事件处理人 */
    @Excel(name = "事件处理人")
    private String handlerName;

    /** 处理人电话 */
    @Excel(name = "处理人电话")
    private String handlerPhone;

    /** 处理内容 */
    @Excel(name = "处理内容")
    private String handlerContent;

    /** 处理人处置事件的状态（2 指派，3签收，4已处置 5退回） */
    @Excel(name = "处理人处置事件的状态", readConverterExp = "2=,指=派，3签收，4已处置,5=退回")
    private String processStatus;

    /** 处理人处置事件的状态名称（审核超时，处置超时，超时处置，已处理） */
    @Excel(name = "处理人处置事件的状态名称", readConverterExp = "审=核超时，处置超时，超时处置，已处理")
    private String processStatusName;

    /** 处理时间 */
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date processTime;

    /** $column.columnComment */
    @Excel(name = "处理时间")
    private Integer extendInt1;

    /** $column.columnComment */
    @Excel(name = "处理时间")
    private Integer extendInt2;

    /** $column.columnComment */
    @Excel(name = "处理时间")
    private Integer extendInt3;

    /** $column.columnComment */
    @Excel(name = "处理时间")
    private String extendStr1;

    /** $column.columnComment */
    @Excel(name = "处理时间")
    private String extendStr2;

    /** $column.columnComment */
    @Excel(name = "处理时间")
    private String extendStr3;

    /** $column.columnComment */
    @Excel(name = "处理时间")
    private String extendjson;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRecordId(String recordId) 
    {
        this.recordId = recordId;
    }

    public String getRecordId() 
    {
        return recordId;
    }
    public void setEventId(String eventId) 
    {
        this.eventId = eventId;
    }

    public String getEventId() 
    {
        return eventId;
    }
    public void setRegionIndexCode(String regionIndexCode) 
    {
        this.regionIndexCode = regionIndexCode;
    }

    public String getRegionIndexCode() 
    {
        return regionIndexCode;
    }
    public void setRegionName(String regionName) 
    {
        this.regionName = regionName;
    }

    public String getRegionName() 
    {
        return regionName;
    }
    public void setHandlerRecordIndexCode(String handlerRecordIndexCode) 
    {
        this.handlerRecordIndexCode = handlerRecordIndexCode;
    }

    public String getHandlerRecordIndexCode() 
    {
        return handlerRecordIndexCode;
    }
    public void setHandlerIndexCode(String handlerIndexCode) 
    {
        this.handlerIndexCode = handlerIndexCode;
    }

    public String getHandlerIndexCode() 
    {
        return handlerIndexCode;
    }
    public void setHandlerName(String handlerName) 
    {
        this.handlerName = handlerName;
    }

    public String getHandlerName() 
    {
        return handlerName;
    }
    public void setHandlerPhone(String handlerPhone) 
    {
        this.handlerPhone = handlerPhone;
    }

    public String getHandlerPhone() 
    {
        return handlerPhone;
    }
    public void setHandlerContent(String handlerContent) 
    {
        this.handlerContent = handlerContent;
    }

    public String getHandlerContent() 
    {
        return handlerContent;
    }
    public void setProcessStatus(String processStatus) 
    {
        this.processStatus = processStatus;
    }

    public String getProcessStatus() 
    {
        return processStatus;
    }
    public void setProcessStatusName(String processStatusName) 
    {
        this.processStatusName = processStatusName;
    }

    public String getProcessStatusName() 
    {
        return processStatusName;
    }
    public void setProcessTime(Date processTime) 
    {
        this.processTime = processTime;
    }

    public Date getProcessTime() 
    {
        return processTime;
    }
    public void setExtendInt1(Integer extendInt1) 
    {
        this.extendInt1 = extendInt1;
    }

    public Integer getExtendInt1() 
    {
        return extendInt1;
    }
    public void setExtendInt2(Integer extendInt2) 
    {
        this.extendInt2 = extendInt2;
    }

    public Integer getExtendInt2() 
    {
        return extendInt2;
    }
    public void setExtendInt3(Integer extendInt3) 
    {
        this.extendInt3 = extendInt3;
    }

    public Integer getExtendInt3() 
    {
        return extendInt3;
    }
    public void setExtendStr1(String extendStr1) 
    {
        this.extendStr1 = extendStr1;
    }

    public String getExtendStr1() 
    {
        return extendStr1;
    }
    public void setExtendStr2(String extendStr2) 
    {
        this.extendStr2 = extendStr2;
    }

    public String getExtendStr2() 
    {
        return extendStr2;
    }
    public void setExtendStr3(String extendStr3) 
    {
        this.extendStr3 = extendStr3;
    }

    public String getExtendStr3() 
    {
        return extendStr3;
    }
    public void setExtendjson(String extendjson) 
    {
        this.extendjson = extendjson;
    }

    public String getExtendjson() 
    {
        return extendjson;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("recordId", getRecordId())
            .append("eventId", getEventId())
            .append("regionIndexCode", getRegionIndexCode())
            .append("regionName", getRegionName())
            .append("handlerRecordIndexCode", getHandlerRecordIndexCode())
            .append("handlerIndexCode", getHandlerIndexCode())
            .append("handlerName", getHandlerName())
            .append("handlerPhone", getHandlerPhone())
            .append("handlerContent", getHandlerContent())
            .append("processStatus", getProcessStatus())
            .append("processStatusName", getProcessStatusName())
            .append("processTime", getProcessTime())
            .append("extendInt1", getExtendInt1())
            .append("extendInt2", getExtendInt2())
            .append("extendInt3", getExtendInt3())
            .append("extendStr1", getExtendStr1())
            .append("extendStr2", getExtendStr2())
            .append("extendStr3", getExtendStr3())
            .append("extendjson", getExtendjson())
            .append("createTime", getCreateTime())
            .toString();
    }
}
