package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 街道管理-知识库对象 xl_knowledge
 * 
 * @author ruoyi
 * @date 2021-05-19
 */
public class XlKnowledge extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** uuid */
    @Excel(name = "uuid")
    private String uuid;

    /** 名称标题 */
    @Excel(name = "名称标题")
    private String knowledgeName;

    /** 内容 */
    @Excel(name = "内容")
    private String knowledgeContent;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    /** 创建日期 */
    @Excel(name = "创建日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 修改人 */
    @Excel(name = "修改人")
    private String updateName;

    /** 修改日期 */
    @Excel(name = "修改日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUuid(String uuid) 
    {
        this.uuid = uuid;
    }

    public String getUuid() 
    {
        return uuid;
    }
    public void setKnowledgeName(String knowledgeName) 
    {
        this.knowledgeName = knowledgeName;
    }

    public String getKnowledgeName() 
    {
        return knowledgeName;
    }
    public void setKnowledgeContent(String knowledgeContent) 
    {
        this.knowledgeContent = knowledgeContent;
    }

    public String getKnowledgeContent() 
    {
        return knowledgeContent;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setUpdateName(String updateName) 
    {
        this.updateName = updateName;
    }

    public String getUpdateName() 
    {
        return updateName;
    }
    public void setUpdateDate(Date updateDate) 
    {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() 
    {
        return updateDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uuid", getUuid())
            .append("knowledgeName", getKnowledgeName())
            .append("knowledgeContent", getKnowledgeContent())
            .append("createUser", getCreateUser())
            .append("createDate", getCreateDate())
            .append("updateName", getUpdateName())
            .append("updateDate", getUpdateDate())
            .toString();
    }
}
