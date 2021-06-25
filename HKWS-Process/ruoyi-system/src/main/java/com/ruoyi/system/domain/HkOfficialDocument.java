package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 公文管理对象 hk_official _document
 *
 * @author ruoyi
 * @date 2021-03-10
 */
public class HkOfficialDocument extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String title;

    /**
     * 内容
     */
    @Excel(name = "内容")
    private String content;

    /**
     * 发布部门
     */
    @Excel(name = "发布部门")
    private String publishDept;

    /**
     * 发布部门id
     */
    @Excel(name = "发布部门id")
    private Long publishDeptId;

    /**
     * 公开标识(1.公开,0不公开)
     */
    @Excel(name = "公开标识(1.公开,0不公开)")
    private Integer publicFlag;

    /**
     * 删除标识(1.删除,0.正常)
     */
    private Integer delFlag;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setPublishDept(String publishDept) {
        this.publishDept = publishDept;
    }

    public String getPublishDept() {
        return publishDept;
    }

    public void setPublishDeptId(Long publishDeptId) {
        this.publishDeptId = publishDeptId;
    }

    public Long getPublishDeptId() {
        return publishDeptId;
    }

    public void setPublicFlag(Integer publicFlag) {
        this.publicFlag = publicFlag;
    }

    public Integer getPublicFlag() {
        return publicFlag;
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
                .append("title", getTitle())
                .append("content", getContent())
                .append("createTime", getCreateTime())
                .append("publishDept", getPublishDept())
                .append("publishDeptId", getPublishDeptId())
                .append("publicFlag", getPublicFlag())
                .append("delFlag", getDelFlag())
                .append("updateTime", getUpdateTime())
                .append("createby", getCreateBy())
                .append("updateby", getUpdateBy())
                .toString();
    }
}
