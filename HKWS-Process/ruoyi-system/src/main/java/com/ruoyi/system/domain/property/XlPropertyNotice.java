package com.ruoyi.system.domain.property;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 物业--公告通知对象 xl_property_notice
 *
 * @author ruoyi
 * @date 2021-05-26
 */
public class XlPropertyNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 通知类型(1：公告通知；2：活动通知) */
    @Excel(name = "通知类型(1：公告通知；2：活动通知)")
    private Integer noticType;

    /** 图片 */
    @Excel(name = "图片")
    private String fileCode;

    /** 通知内容 */
    @Excel(name = "通知内容")
    private String noticContent;

    /** 浏览次数 */
    @Excel(name = "浏览次数")
    private Long browseNumber;

    /** 小区id */
    @Excel(name = "小区id")
    private Long villageId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setNoticType(Integer noticType)
    {
        this.noticType = noticType;
    }

    public Integer getNoticType()
    {
        return noticType;
    }

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode;
    }

    public void setNoticContent(String noticContent)
    {
        this.noticContent = noticContent;
    }

    public String getNoticContent()
    {
        return noticContent;
    }
    public void setBrowseNumber(Long browseNumber)
    {
        this.browseNumber = browseNumber;
    }

    public Long getBrowseNumber()
    {
        return browseNumber;
    }
    public void setVillageId(Long villageId)
    {
        this.villageId = villageId;
    }

    public Long getVillageId()
    {
        return villageId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("noticType", getNoticType())
                .append("fileCode", getFileCode())
                .append("noticContent", getNoticContent())
                .append("browseNumber", getBrowseNumber())
                .append("villageId", getVillageId())
                .append("createTime", getCreateTime())
                .append("createBy", getCreateBy())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .toString();
    }
}
