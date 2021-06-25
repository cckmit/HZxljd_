package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 街道管理--会议记录对象 xl_meeting
 *
 * @author ruoyi
 * @date 2021-05-19
 */
public class XlMeeting extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 会议标题 */
    @Excel(name = "会议标题")
    private String meetingTitle;

    /** 会议地址 */
    @Excel(name = "会议地址")
    private String meetingAddress;

    /** 会议内容 */
    @Excel(name = "会议内容")
    private String meetingContent;

    /** 会议记录人 */
    @Excel(name = "会议记录人")
    private String meetingRecordPerson;

    /** 会议时间 */
    @Excel(name = "会议时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date meetingDate;

    /** 会议创建人 */
    @Excel(name = "会议创建人")
    private String meetingUser;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 修改人 */
    @Excel(name = "修改人")
    private String updateUser;

    /** 修改时间 */
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    /** 会议图片 */
    @Excel(name = "会议图片")
    private String meetingImage;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setMeetingTitle(String meetingTitle)
    {
        this.meetingTitle = meetingTitle;
    }

    public String getMeetingTitle()
    {
        return meetingTitle;
    }
    public void setMeetingAddress(String meetingAddress)
    {
        this.meetingAddress = meetingAddress;
    }

    public String getMeetingAddress()
    {
        return meetingAddress;
    }
    public void setMeetingContent(String meetingContent)
    {
        this.meetingContent = meetingContent;
    }

    public String getMeetingContent()
    {
        return meetingContent;
    }
    public void setMeetingRecordPerson(String meetingRecordPerson)
    {
        this.meetingRecordPerson = meetingRecordPerson;
    }

    public String getMeetingRecordPerson()
    {
        return meetingRecordPerson;
    }
    public void setMeetingDate(Date meetingDate)
    {
        this.meetingDate = meetingDate;
    }

    public Date getMeetingDate()
    {
        return meetingDate;
    }
    public void setMeetingUser(String meetingUser)
    {
        this.meetingUser = meetingUser;
    }

    public String getMeetingUser()
    {
        return meetingUser;
    }
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public Date getCreateDate()
    {
        return createDate;
    }
    public void setUpdateUser(String updateUser)
    {
        this.updateUser = updateUser;
    }

    public String getUpdateUser()
    {
        return updateUser;
    }
    public void setUpdateDate(Date updateDate)
    {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate()
    {
        return updateDate;
    }
    public void setMeetingImage(String meetingImage)
    {
        this.meetingImage = meetingImage;
    }

    public String getMeetingImage()
    {
        return meetingImage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("meetingTitle", getMeetingTitle())
                .append("meetingAddress", getMeetingAddress())
                .append("meetingContent", getMeetingContent())
                .append("meetingRecordPerson", getMeetingRecordPerson())
                .append("meetingDate", getMeetingDate())
                .append("meetingUser", getMeetingUser())
                .append("createDate", getCreateDate())
                .append("updateUser", getUpdateUser())
                .append("updateDate", getUpdateDate())
                .append("meetingImage", getMeetingImage())
                .toString();
    }
}
