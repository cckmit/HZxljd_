package com.ruoyi.system.domain.honey;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 网格员--申诉对象 xl_appeal
 *
 * @author ruoyi
 * @date 2021-05-28
 */
public class XlAppeal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 扣分内容 */
    @Excel(name = "扣分内容")
    private String deductionContent;

    /** 扣分值 */
    @Excel(name = "扣分值")
    private String deductionNumber;

    /** 申诉人 */
    @Excel(name = "申诉人")
    private String appealPerson;

    /** 申诉人 */
    @Excel(name = "申诉人id")
    private String appealPersonId;

    /** 考核部门 */
    @Excel(name = "考核部门")
    private String assessmentDepartment;

    /** 考核时间 */
    @Excel(name = "考核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date assessmentDate;

    /** 申诉状态(1.未处理  2.已同意  3.已驳回) */
    @Excel(name = "申诉状态(1.未处理  2.已同意  3.已驳回)")
    private Integer appealStatus;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 申诉描述 */
    @Excel(name = "申诉描述")
    private String appealDescribe;
    /** 申诉描述 */
    @Excel(name = "申诉次数")
    private Integer  appealCount;
    /** 申请次数 */
    private Integer count;
    /** 联系电话 */
    private Integer phone;
    /** 申诉图片  */
    private Integer images;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getImages() {
        return images;
    }

    public void setImages(Integer images) {
        this.images = images;
    }

    public Integer getAppealCount() {
        return appealCount;
    }

    public void setAppealCount(Integer appealCount) {
        this.appealCount = appealCount;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setDeductionContent(String deductionContent)
    {
        this.deductionContent = deductionContent;
    }

    public String getDeductionContent()
    {
        return deductionContent;
    }
    public void setDeductionNumber(String deductionNumber)
    {
        this.deductionNumber = deductionNumber;
    }

    public String getDeductionNumber()
    {
        return deductionNumber;
    }
    public void setAppealPerson(String appealPerson)
    {
        this.appealPerson = appealPerson;
    }

    public String getAppealPerson()
    {
        return appealPerson;
    }
    public void setAssessmentDepartment(String assessmentDepartment)
    {
        this.assessmentDepartment = assessmentDepartment;
    }

    public String getAssessmentDepartment()
    {
        return assessmentDepartment;
    }
    public void setAssessmentDate(Date assessmentDate)
    {
        this.assessmentDate = assessmentDate;
    }

    public Date getAssessmentDate()
    {
        return assessmentDate;
    }
    public void setAppealStatus(Integer appealStatus)
    {
        this.appealStatus = appealStatus;
    }

    public Integer getAppealStatus()
    {
        return appealStatus;
    }
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public Date getCreateDate()
    {
        return createDate;
    }
    public void setAppealDescribe(String appealDescribe)
    {
        this.appealDescribe = appealDescribe;
    }

    public String getAppealDescribe()
    {
        return appealDescribe;
    }

    public String getAppealPersonId() {
        return appealPersonId;
    }

    public void setAppealPersonId(String appealPersonId) {
        this.appealPersonId = appealPersonId;
    }



}
