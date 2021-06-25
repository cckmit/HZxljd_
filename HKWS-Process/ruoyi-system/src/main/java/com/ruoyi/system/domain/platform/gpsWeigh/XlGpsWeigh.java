package com.ruoyi.system.domain.platform.gpsWeigh;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 垃圾车定位及称重对象 xl_gps_weigh
 * 
 * @author ruoyi
 * @date 2021-06-11
 */
public class XlGpsWeigh extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 事件名称 */
    @Excel(name = "事件名称")
    private String tripartName;

    /** 事件类型（GPS定位或垃圾称重） */
    @Excel(name = "事件类型", readConverterExp = "G=PS定位或垃圾称重")
    private String tripartType;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String licensePlate;

    /** 车辆编码 */
    @Excel(name = "车辆编码")
    private String locationSim;

    /** 经度 */
    @Excel(name = "经度")
    private String tripartLng;

    /** 纬度 */
    @Excel(name = "纬度")
    private String tripartLat;

    /** 高度 */
    @Excel(name = "高度")
    private Integer tripartHeight;

    /** 重量 */
    @Excel(name = "重量")
    private Integer tripartWeight;

    /** 车速 */
    @Excel(name = "车速")
    private String tripartSpeed;

    /** 方向 */
    @Excel(name = "方向")
    private String tripartDirection;

    /** 上报事件 */
    @Excel(name = "定位时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String recortTime;

    private Date createTime;

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTripartName(String tripartName) 
    {
        this.tripartName = tripartName;
    }

    public String getTripartName() 
    {
        return tripartName;
    }
    public void setTripartType(String tripartType) 
    {
        this.tripartType = tripartType;
    }

    public String getTripartType() 
    {
        return tripartType;
    }
    public void setLicensePlate(String licensePlate) 
    {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() 
    {
        return licensePlate;
    }
    public void setLocationSim(String locationSim) 
    {
        this.locationSim = locationSim;
    }

    public String getLocationSim() 
    {
        return locationSim;
    }
    public void setTripartLng(String tripartLng) 
    {
        this.tripartLng = tripartLng;
    }

    public String getTripartLng() 
    {
        return tripartLng;
    }
    public void setTripartLat(String tripartLat) 
    {
        this.tripartLat = tripartLat;
    }

    public String getTripartLat() 
    {
        return tripartLat;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getTripartHeight() {
        return tripartHeight;
    }

    public void setTripartHeight(Integer tripartHeight) {
        this.tripartHeight = tripartHeight;
    }

    public Integer getTripartWeight() {
        return tripartWeight;
    }

    public void setTripartWeight(Integer tripartWeight) {
        this.tripartWeight = tripartWeight;
    }

    public void setTripartSpeed(String tripartSpeed)
    {
        this.tripartSpeed = tripartSpeed;
    }

    public String getTripartSpeed() 
    {
        return tripartSpeed;
    }
    public void setTripartDirection(String tripartDirection) 
    {
        this.tripartDirection = tripartDirection;
    }

    public String getTripartDirection() 
    {
        return tripartDirection;
    }

    public String getRecortTime() {
        return recortTime;
    }

    public void setRecortTime(String recortTime) {
        this.recortTime = recortTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("tripartName", getTripartName())
            .append("tripartType", getTripartType())
            .append("licensePlate", getLicensePlate())
            .append("locationSim", getLocationSim())
            .append("tripartLng", getTripartLng())
            .append("tripartLat", getTripartLat())
            .append("tripartHeight", getTripartHeight())
            .append("tripartWeight", getTripartWeight())
            .append("tripartSpeed", getTripartSpeed())
            .append("tripartDirection", getTripartDirection())
            .append("recortTime", getRecortTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
