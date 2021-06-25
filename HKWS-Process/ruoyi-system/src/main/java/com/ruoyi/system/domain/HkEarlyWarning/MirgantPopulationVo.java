package com.ruoyi.system.domain.HkEarlyWarning;



import java.io.Serializable;
import java.util.Date;

/**
 * 流动人口表(MirgantPopulation)表实体类
 *
 * @author makejava
 * @since 2021-03-25 10:25:53
 */
public class MirgantPopulationVo implements Serializable {
    //自增id
    private Long id;
    //租客姓名
    private String name;
    //身份证号
    private String idNumber;
    //性别（0：男，1：女）
    private Integer sex;
    //年龄
    private Integer age;
    //联系电话
    private String phone;
    //租客籍贯
    private String nativePlace;
    //文化程度
    private String degreeOfEducation;
    //婚姻状况
    private Integer maritalStatus;
    //居住处所
    private String abodePlace;
    //工作单位
    private String workPlace;
    //登记类型
    private String registType;
    //租住状态（1：在租 2：退租）
    private String status;
    //证件种类（1：身份证，2：护照）
    private Integer certificateType;
    //租客民族
    private String tenantNationality;
    //出生日期
    private Date date;
    //国籍地区
    private String nationality;
    //户口详细地址
    private String address;
    //政治面貌
    private String politicalOutlook;
    //居住事由
    private String residence;
    //从事职业
    private String occupation;
    //单位联系电话
    private String workPhone;
    //工作地址
    private String workAddress;
    //来临时间
    private Date comeTime;
    //退租时间
    private Date refundTime;
    //登记时间
    private Date registerTime;
    //在临安状态（1：在临安 2：离临安）
    private String staystatus;
    //登记类型（1：流动人口  2：人户分离）
    private String registerType;
    //申报类型（1：租客端 2：房东端 3：网格员端）
    private String declareType;
    /**房屋编号**/
    private String houseCode;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getDegreeOfEducation() {
        return degreeOfEducation;
    }

    public void setDegreeOfEducation(String degreeOfEducation) {
        this.degreeOfEducation = degreeOfEducation;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getAbodePlace() {
        return abodePlace;
    }

    public void setAbodePlace(String abodePlace) {
        this.abodePlace = abodePlace;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getRegistType() {
        return registType;
    }

    public void setRegistType(String registType) {
        this.registType = registType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(Integer certificateType) {
        this.certificateType = certificateType;
    }

    public String getTenantNationality() {
        return tenantNationality;
    }

    public void setTenantNationality(String tenantNationality) {
        this.tenantNationality = tenantNationality;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPoliticalOutlook() {
        return politicalOutlook;
    }

    public void setPoliticalOutlook(String politicalOutlook) {
        this.politicalOutlook = politicalOutlook;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public Date getComeTime() {
        return comeTime;
    }

    public void setComeTime(Date comeTime) {
        this.comeTime = comeTime;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getStaystatus() {
        return staystatus;
    }

    public void setStaystatus(String staystatus) {
        this.staystatus = staystatus;
    }

    public String getRegisterType() {
        return registerType;
    }

    public void setRegisterType(String registerType) {
        this.registerType = registerType;
    }

    public String getDeclareType() {
        return declareType;
    }

    public void setDeclareType(String declareType) {
        this.declareType = declareType;
    }

    @Override
    public String toString() {
        return "MirgantPopulation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", degreeOfEducation='" + degreeOfEducation + '\'' +
                ", maritalStatus=" + maritalStatus +
                ", abodePlace='" + abodePlace + '\'' +
                ", workPlace='" + workPlace + '\'' +
                ", registType='" + registType + '\'' +
                ", status='" + status + '\'' +
                ", certificateType=" + certificateType +
                ", tenantNationality='" + tenantNationality + '\'' +
                ", date=" + date +
                ", nationality='" + nationality + '\'' +
                ", address='" + address + '\'' +
                ", politicalOutlook='" + politicalOutlook + '\'' +
                ", residence='" + residence + '\'' +
                ", occupation='" + occupation + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", workAddress='" + workAddress + '\'' +
                ", comeTime=" + comeTime +
                ", refundTime=" + refundTime +
                ", registerTime=" + registerTime +
                ", staystatus='" + staystatus + '\'' +
                ", registerType='" + registerType + '\'' +
                ", declareType='" + declareType + '\'' +
                '}';
    }


}
