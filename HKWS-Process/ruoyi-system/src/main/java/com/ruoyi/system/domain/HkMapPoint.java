package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备地图点位对象 hk_map_point
 *
 * @author guohailong
 * @date 2021-04-12
 */
public class HkMapPoint extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * null
     */
    private Long id;

    /**
     * 设备类型(1.摄像头,2...)
     */
    @Excel(name = "设备类型(1.摄像头,2...)")
    private Integer deviceType;

    /**
     * 设备来源(1001,1002..)
     */
    @Excel(name = "设备来源(1001,1002..)")
    private Integer deviceSource;

    /**
     * 设备地址
     */
    @Excel(name = "设备地址")
    private String deviceAddress;

    /**
     * 经度
     */
    @Excel(name = "经度")
    private Double longitude;

    /**
     * 纬度
     */
    @Excel(name = "纬度")
    private Double latitude;

    /**
     * 联系人
     */
    @Excel(name = "联系人")
    private String linkman;

    /**
     * 联系人电话
     */
    @Excel(name = "联系人电话")
    private String linkmanPhone;

    /**
     * 删除标识(0.存在,2删除)
     */
    private String delFlag;

    /**
     * 状态标识(0.正常,1禁用)
     */
    @Excel(name = "状态标识(0.正常,1禁用)")
    private String status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceSource(Integer deviceSource) {
        this.deviceSource = deviceSource;
    }

    public Integer getDeviceSource() {
        return deviceSource;
    }

    public void setDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress;
    }

    public String getDeviceAddress() {
        return deviceAddress;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone;
    }

    public String getLinkmanPhone() {
        return linkmanPhone;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("deviceType", getDeviceType())
                .append("deviceSource", getDeviceSource())
                .append("deviceAddress", getDeviceAddress())
                .append("longitude", getLongitude())
                .append("latitude", getLatitude())
                .append("remark", getRemark())
                .append("linkman", getLinkman())
                .append("linkmanPhone", getLinkmanPhone())
                .append("delFlag", getDelFlag())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
