package com.ruoyi.system.domain.HkEntity;


import java.io.Serializable;

/**
 * 事件详情
 * @author: Lijiajia8
 * @date: 2020/4/30 9:51
 * @since: jdk1.8
 */
public class EventInfoDTO  implements Serializable {
    /** 事件信息 */
    private EventDTO event;

    /** 事件上报者 */
    private EventReportProviderDTO reportProvider;

    /** 点位 */
    private PointDTO point;

    /** 场所所在的区域 */
    private String regionIndexCode;

    /** 事件发生的区域名称 */
    private String regionName;

    /** 场所类型 */
    private String placeType;

    /** 场所类型名称 */
    private String placeTypeName;

    /** 场所标识 */
    private String placeIndexCode;

    /** 场所名称 */
    private String placeName;

    /** 路由地址，用于工作台页面跳转 */
    private String routingAddress;

    private Integer extendInt1;

    private Integer extendInt2;

    private Integer extendInt3;

    /** 社区区域code */
    private String extendStr1;

    private String extendStr2;

    private String extendStr3;

    private String extendJson;

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }

    public EventReportProviderDTO getReportProvider() {
        return reportProvider;
    }

    public void setReportProvider(EventReportProviderDTO reportProvider) {
        this.reportProvider = reportProvider;
    }

    public PointDTO getPoint() {
        return point;
    }

    public void setPoint(PointDTO point) {
        this.point = point;
    }

    public String getRegionIndexCode() {
        return regionIndexCode;
    }

    public void setRegionIndexCode(String regionIndexCode) {
        this.regionIndexCode = regionIndexCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public String getPlaceTypeName() {
        return placeTypeName;
    }

    public void setPlaceTypeName(String placeTypeName) {
        this.placeTypeName = placeTypeName;
    }

    public String getPlaceIndexCode() {
        return placeIndexCode;
    }

    public void setPlaceIndexCode(String placeIndexCode) {
        this.placeIndexCode = placeIndexCode;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getRoutingAddress() {
        return routingAddress;
    }

    public void setRoutingAddress(String routingAddress) {
        this.routingAddress = routingAddress;
    }

    public Integer getExtendInt1() {
        return extendInt1;
    }

    public void setExtendInt1(Integer extendInt1) {
        this.extendInt1 = extendInt1;
    }

    public Integer getExtendInt2() {
        return extendInt2;
    }

    public void setExtendInt2(Integer extendInt2) {
        this.extendInt2 = extendInt2;
    }

    public Integer getExtendInt3() {
        return extendInt3;
    }

    public void setExtendInt3(Integer extendInt3) {
        this.extendInt3 = extendInt3;
    }

    public String getExtendStr1() {
        return extendStr1;
    }

    public void setExtendStr1(String extendStr1) {
        this.extendStr1 = extendStr1;
    }

    public String getExtendStr2() {
        return extendStr2;
    }

    public void setExtendStr2(String extendStr2) {
        this.extendStr2 = extendStr2;
    }

    public String getExtendStr3() {
        return extendStr3;
    }

    public void setExtendStr3(String extendStr3) {
        this.extendStr3 = extendStr3;
    }

    public String getExtendJson() {
        return extendJson;
    }

    public void setExtendJson(String extendJson) {
        this.extendJson = extendJson;
    }





}
