package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 街道管理--物业信息对象 xl_estate_management
 * 
 * @author ruoyi
 * @date 2021-05-20
 */
public class XlEstateManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 物业公司名称 */
    @Excel(name = "物业公司名称")
    private String estateName;

    /** 物业星级 */
    @Excel(name = "物业星级")
    private String estateStar;

    /** 小区编号 */
    @Excel(name = "小区编号")
    private String quartersId;

    /** 小区名称 */
    @Excel(name = "小区名称")
    private String quartersName;

    /** 物业经理 */
    @Excel(name = "物业经理")
    private String estateManager;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String estatePhone;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEstateName(String estateName) 
    {
        this.estateName = estateName;
    }

    public String getEstateName() 
    {
        return estateName;
    }
    public void setEstateStar(String estateStar) 
    {
        this.estateStar = estateStar;
    }

    public String getEstateStar() 
    {
        return estateStar;
    }
    public void setQuartersId(String quartersId) 
    {
        this.quartersId = quartersId;
    }

    public String getQuartersId() 
    {
        return quartersId;
    }
    public void setQuartersName(String quartersName) 
    {
        this.quartersName = quartersName;
    }

    public String getQuartersName() 
    {
        return quartersName;
    }
    public void setEstateManager(String estateManager) 
    {
        this.estateManager = estateManager;
    }

    public String getEstateManager() 
    {
        return estateManager;
    }
    public void setEstatePhone(String estatePhone) 
    {
        this.estatePhone = estatePhone;
    }

    public String getEstatePhone() 
    {
        return estatePhone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("estateName", getEstateName())
            .append("estateStar", getEstateStar())
            .append("quartersId", getQuartersId())
            .append("quartersName", getQuartersName())
            .append("estateManager", getEstateManager())
            .append("estatePhone", getEstatePhone())
            .toString();
    }
}
