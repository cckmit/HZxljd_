package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 公共管理--企业信息对象 xl_enterprise_info
 *
 * @author ruoyi
 * @date 2021-05-25
 */
public class XlEnterpriseInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String enterpriseName;

    /** 企业地址 */
    @Excel(name = "企业地址")
    private String enterpriseAdress;
    /** 经营状态(1.存续 2注销 3存续(在营、开业、在册)4吊销,已注销 5,吊销,未注销) */
    @Excel(name = "经营状态(1.存续 2注销 3存续(在营、开业、在册)4吊销,已注销 5,吊销,未注销)")
    private Integer enterpriseStatus;

    /** 状态名称 */
    @Excel(name = "状态名称")
    private String enterpriseStatusName;

    /** 企业类型 */
    @Excel(name = "企业类型")
    private String enterpriseType;
    /** 企业类型（1.个体工商户2.企业） */
        @Excel(name = "企业类型编码1.个体工商户2.企业", readConverterExp = "1.个体工商户2.企业")
    private Integer enterpriseTypeNum;

    /** 成立日期 */
    @Excel(name = "成立日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date establishDate;

    /** 法人代表 */
    @Excel(name = "法人代表")
    private String establishPerson;

    /** 公司更新时间 */
    @Excel(name = "公司更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date enterpriseUpdateDate;

    /** 信息状态(1.待确认 2.已确认) */
    @Excel(name = "信息状态(1.待确认 2.已确认)")
    private Integer informationStatus;

    /** 邮箱地址 */
    @Excel(name = "邮箱地址")
    private String mailbox;

    /** 注册资金 */
    @Excel(name = "注册资金")
    private String registeredCapital;

    /** 登记机关 */
    @Excel(name = "登记机关")
    private String registrationAuthority;

    /** 统一信用代码 */
    @Excel(name = "统一信用代码")
    private String unifiedCreditCode;

    /** 注册号 */
    @Excel(name = "注册号")
    private String registrationNumber;

    /** 组织结构 */
    @Excel(name = "组织结构")
    private String organization;

    /** 经营范围 */
    @Excel(name = "经营范围")
    private String natureBusiness;

    /** 营业开始日期 */
    @Excel(name = "营业开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date termstart;

    /** 营业结束日期 */
    @Excel(name = "营业结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date teamend;

    /** 发照日期 */
    @Excel(name = "发照日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkdata;

    //是否上市0未上市 1上市
    private Integer isOnStock;

    /** 企业logo */
    @Excel(name = "企业logo")
    private String enterpriseLogo;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    /** 修改时间 */
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    /** 修改人 */
    @Excel(name = "修改人")
    private String updateUser;

    /** 所属村社网格id */
    @Excel(name = "所属村社网格id")
    private Long regionId;

    private Long parentId;
    /**
     * 网格名称
     */
    private String regionName;
    /**
     * 区域名称
     */
    private String  parentregionName;
    /**
     * 区域名称
     */
    private Date  inspectDate;

    public Date getInspectDate() {
        return inspectDate;
    }

    public void setInspectDate(Date inspectDate) {
        this.inspectDate = inspectDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseAdress() {
        return enterpriseAdress;
    }

    public void setEnterpriseAdress(String enterpriseAdress) {
        this.enterpriseAdress = enterpriseAdress;
    }

    public Integer getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(Integer enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getEnterpriseStatusName() {
        return enterpriseStatusName;
    }

    public void setEnterpriseStatusName(String enterpriseStatusName) {
        this.enterpriseStatusName = enterpriseStatusName;
    }

    public String getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public Integer getEnterpriseTypeNum() {
        return enterpriseTypeNum;
    }

    public void setEnterpriseTypeNum(Integer enterpriseTypeNum) {
        this.enterpriseTypeNum = enterpriseTypeNum;
    }

    public Date getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(Date establishDate) {
        this.establishDate = establishDate;
    }

    public String getEstablishPerson() {
        return establishPerson;
    }

    public void setEstablishPerson(String establishPerson) {
        this.establishPerson = establishPerson;
    }

    public Date getEnterpriseUpdateDate() {
        return enterpriseUpdateDate;
    }

    public void setEnterpriseUpdateDate(Date enterpriseUpdateDate) {
        this.enterpriseUpdateDate = enterpriseUpdateDate;
    }

    public Integer getInformationStatus() {
        return informationStatus;
    }

    public void setInformationStatus(Integer informationStatus) {
        this.informationStatus = informationStatus;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getRegistrationAuthority() {
        return registrationAuthority;
    }

    public void setRegistrationAuthority(String registrationAuthority) {
        this.registrationAuthority = registrationAuthority;
    }

    public String getUnifiedCreditCode() {
        return unifiedCreditCode;
    }

    public void setUnifiedCreditCode(String unifiedCreditCode) {
        this.unifiedCreditCode = unifiedCreditCode;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getNatureBusiness() {
        return natureBusiness;
    }

    public void setNatureBusiness(String natureBusiness) {
        this.natureBusiness = natureBusiness;
    }

    public Date getTermstart() {
        return termstart;
    }

    public void setTermstart(Date termstart) {
        this.termstart = termstart;
    }

    public Date getTeamend() {
        return teamend;
    }

    public void setTeamend(Date teamend) {
        this.teamend = teamend;
    }

    public Date getCheckdata() {
        return checkdata;
    }

    public void setCheckdata(Date checkdata) {
        this.checkdata = checkdata;
    }

    public Integer getIsOnStock() {
        return isOnStock;
    }

    public void setIsOnStock(Integer isOnStock) {
        this.isOnStock = isOnStock;
    }

    public String getEnterpriseLogo() {
        return enterpriseLogo;
    }

    public void setEnterpriseLogo(String enterpriseLogo) {
        this.enterpriseLogo = enterpriseLogo;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getParentregionName() {
        return parentregionName;
    }

    public void setParentregionName(String parentregionName) {
        this.parentregionName = parentregionName;
    }

    @Override
    public String toString() {
        return "XlEnterpriseInfo{" +
                "id=" + id +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", enterpriseAdress='" + enterpriseAdress + '\'' +
                ", enterpriseStatus=" + enterpriseStatus +
                ", enterpriseStatusName='" + enterpriseStatusName + '\'' +
                ", enterpriseType='" + enterpriseType + '\'' +
                ", enterpriseTypeNum=" + enterpriseTypeNum +
                ", establishDate=" + establishDate +
                ", establishPerson='" + establishPerson + '\'' +
                ", enterpriseUpdateDate=" + enterpriseUpdateDate +
                ", informationStatus=" + informationStatus +
                ", mailbox='" + mailbox + '\'' +
                ", registeredCapital='" + registeredCapital + '\'' +
                ", registrationAuthority='" + registrationAuthority + '\'' +
                ", unifiedCreditCode='" + unifiedCreditCode + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", organization='" + organization + '\'' +
                ", natureBusiness='" + natureBusiness + '\'' +
                ", termstart=" + termstart +
                ", teamend=" + teamend +
                ", checkdata=" + checkdata +
                ", isOnStock=" + isOnStock +
                ", enterpriseLogo='" + enterpriseLogo + '\'' +
                ", createUser='" + createUser + '\'' +
                ", updateDate=" + updateDate +
                ", updateUser='" + updateUser + '\'' +
                ", regionId=" + regionId +
                ", parentId=" + parentId +
                ", regionName='" + regionName + '\'' +
                ", parentregionName='" + parentregionName + '\'' +
                '}';
    }
}
