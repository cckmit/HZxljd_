package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system
 * @ClassName: HkMapCover
 * @Author: guohailong
 * @Description: 地图覆盖物-地区关联表
 * @Date: 2021/3/16 1:38
 * @Version: 1.0
 */
public class HkMapCover extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 关联id(可以是社区,可以是街道,可以是网格)
     */
    @Excel(name = "关联id(可以是社区,可以是街道,可以是网格)")
    private Long parentId;

    /**
     * 关联名称
     */
    private String parentName;


    private String centerPoint;

    /**
     * 构造地图覆盖物的经纬度坐标数组
     */
    @Excel(name = "构造地图覆盖物的经纬度坐标数组")
    private String markerPoints;

    /**
     * $column.columnComment
     */
    private Integer delFlag;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentId() {
        return parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(String centerPoint) {
        this.centerPoint = centerPoint;
    }

    public void setMarkerPoints(String markerPoints) {
        this.markerPoints = markerPoints;
    }

    public String getMarkerPoints() {
        return markerPoints;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("parentId", getParentId())
                .append("parentName", getParentName())
                .append("centerPoint", getCenterPoint())
                .append("markerPoints", getMarkerPoints())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
