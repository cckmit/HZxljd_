package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 网格员--工作检查记录对象 xl_work_record
 *
 * @author ruoyi
 * @date 2021-05-22
 */
public class XlWorkRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long workId;

    /** 检查时间 */
    @Excel(name = "检查时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date inspectDate;

    /** 检查人 */
    @Excel(name = "检查人")
    private String inspectUser;

    /** 所属社区id */
    @Excel(name = "所属社区id")
    private String communityId;

    /** 社区名称 */
    @Excel(name = "社区名称")
    private String communityName;

    /** 所属网格id */
    @Excel(name = "所属网格id")
    private String gridId;

    /** 网格名称 */
    @Excel(name = "网格名称")
    private String gridName;

    /** 检查结果 */
    @Excel(name = "检查结果")
    private String inspectResult;

    /** 整改结果 */
    @Excel(name = "整改结果")
    private String rectificationResult;

    /** 巡查类型 */
    @Excel(name = "巡查类型")
    private Integer inspectionType;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 检查定位 */
    @Excel(name = "检查定位")
    private String inspectLoction;
    /** 企业-商铺-单位-人员 通用Id */
    @Excel(name = "企业-商铺-单位-人员 通用Id")
    private Integer generalId;
    /** 检查图片 */
    @Excel(name = "检查图片")
    private String inspectImage;

    /** 检查图片 */
    @Excel(name = "检查内容描述")
    private String inspectContent;
    public Integer getGeneralId() {
        return generalId;
    }

    public void setGeneralId(Integer generalId) {
        this.generalId = generalId;
    }

    public String getInspectImage() {
        return inspectImage;
    }

    public void setInspectImage(String inspectImage) {
        this.inspectImage = inspectImage;
    }

    public String getInspectContent() {
        return inspectContent;
    }

    public void setInspectContent(String inspectContent) {
        this.inspectContent = inspectContent;
    }

    public void setWorkId(Long workId)
    {
        this.workId = workId;
    }

    public Long getWorkId()
    {
        return workId;
    }
    public void setInspectDate(Date inspectDate)
    {
        this.inspectDate = inspectDate;
    }

    public Date getInspectDate()
    {
        return inspectDate;
    }
    public void setInspectUser(String inspectUser)
    {
        this.inspectUser = inspectUser;
    }

    public String getInspectUser()
    {
        return inspectUser;
    }
    public void setCommunityId(String communityId)
    {
        this.communityId = communityId;
    }

    public String getCommunityId()
    {
        return communityId;
    }
    public void setCommunityName(String communityName)
    {
        this.communityName = communityName;
    }

    public String getCommunityName()
    {
        return communityName;
    }
    public void setGridId(String gridId)
    {
        this.gridId = gridId;
    }

    public String getGridId()
    {
        return gridId;
    }
    public void setGridName(String gridName)
    {
        this.gridName = gridName;
    }

    public String getGridName()
    {
        return gridName;
    }
    public void setInspectResult(String inspectResult)
    {
        this.inspectResult = inspectResult;
    }

    public String getInspectResult()
    {
        return inspectResult;
    }
    public void setRectificationResult(String rectificationResult)
    {
        this.rectificationResult = rectificationResult;
    }

    public String getRectificationResult()
    {
        return rectificationResult;
    }
    public void setInspectionType(Integer inspectionType)
    {
        this.inspectionType = inspectionType;
    }

    public Integer getInspectionType()
    {
        return inspectionType;
    }
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public Date getCreateDate()
    {
        return createDate;
    }
    public void setInspectLoction(String inspectLoction)
    {
        this.inspectLoction = inspectLoction;
    }

    public String getInspectLoction()
    {
        return inspectLoction;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("workId", getWorkId())
            .append("inspectDate", getInspectDate())
            .append("inspectUser", getInspectUser())
            .append("communityId", getCommunityId())
            .append("communityName", getCommunityName())
            .append("gridId", getGridId())
            .append("gridName", getGridName())
            .append("inspectResult", getInspectResult())
            .append("rectificationResult", getRectificationResult())
            .append("inspectionType", getInspectionType())
            .append("createDate", getCreateDate())
            .append("inspectLoction", getInspectLoction())
            .toString();
    }
}
