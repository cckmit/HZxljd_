package com.ruoyi.system.domain.property;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 物业-巡更打卡记录对象 xl_property_patrol_sign
 *
 * @author ruoyi
 * @date 2021-06-08
 */
public class XlPropertyPatrolSign extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long signId;

    /** 巡更记录id */
    @Excel(name = "巡更记录id")
    private Long recordId;

    /** 巡更点 */
    @Excel(name = "巡更点")
    private String pointName;

    /** 巡更时间 */
    @Excel(name = "巡更时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date patrolTime;

    /** 巡更状态（0：正常：1：异常） */
    @Excel(name = "巡更状态", readConverterExp = "0=：正常：1：异常")
    private Integer patrolStatus;

    /** 现场照片 */
    @Excel(name = "现场照片")
    private String image;
    /** 巡更物业id */
    @Excel(name = "巡更物业id")
    private Long patrolPropertyId;

    /** 巡更物业 */
    @Excel(name = "巡更物业")
    private String patrolProperty;
    /** 物业-巡更任务 */
    private XlPropertyPatrolRecord xlPropertyPatrolRecord;

    public XlPropertyPatrolRecord getXlPropertyPatrolRecord() {
        return xlPropertyPatrolRecord;
    }

    public void setXlPropertyPatrolRecord(XlPropertyPatrolRecord xlPropertyPatrolRecord) {
        this.xlPropertyPatrolRecord = xlPropertyPatrolRecord;
    }

    public Long getPatrolPropertyId() {
        return patrolPropertyId;
    }

    public void setPatrolPropertyId(Long patrolPropertyId) {
        this.patrolPropertyId = patrolPropertyId;
    }

    public String getPatrolProperty() {
        return patrolProperty;
    }

    public void setPatrolProperty(String patrolProperty) {
        this.patrolProperty = patrolProperty;
    }

    public void setSignId(Long signId)
    {
        this.signId = signId;
    }

    public Long getSignId()
    {
        return signId;
    }
    public void setRecordId(Long recordId)
    {
        this.recordId = recordId;
    }

    public Long getRecordId()
    {
        return recordId;
    }
    public void setPointName(String pointName)
    {
        this.pointName = pointName;
    }

    public String getPointName()
    {
        return pointName;
    }
    public void setPatrolTime(Date patrolTime)
    {
        this.patrolTime = patrolTime;
    }

    public Date getPatrolTime()
    {
        return patrolTime;
    }
    public void setPatrolStatus(Integer patrolStatus)
    {
        this.patrolStatus = patrolStatus;
    }

    public Integer getPatrolStatus()
    {
        return patrolStatus;
    }
    public void setImage(String image)
    {
        this.image = image;
    }

    public String getImage()
    {
        return image;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("signId", getSignId())
                .append("recordId", getRecordId())
                .append("pointName", getPointName())
                .append("patrolTime", getPatrolTime())
                .append("patrolStatus", getPatrolStatus())
                .append("remark", getRemark())
                .append("image", getImage())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
