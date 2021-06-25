package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 流程档案对象 hk_process_document
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
public class HkProcessDocument extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 关联id */
    @Excel(name = "关联id")
    private Long relationId;

    /** 关联表名 */
    @Excel(name = "关联表名")
    private String relationTable;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 源文件名 */
    @Excel(name = "源文件名")
    private String originalFileName;

    /** $column.columnComment */
    @Excel(name = "源文件名")
    private String originalFilePath;

    /** 文件名 */
    @Excel(name = "文件名")
    private String fileName;

    /** 文件地址 */
    @Excel(name = "文件地址")
    private String filePath;

    /** 预览url */
    @Excel(name = "预览url")
    private String url;

    /** $column.columnComment */
    @Excel(name = "预览url")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRelationId(Long relationId) 
    {
        this.relationId = relationId;
    }

    public Long getRelationId() 
    {
        return relationId;
    }
    public void setRelationTable(String relationTable) 
    {
        this.relationTable = relationTable;
    }

    public String getRelationTable() 
    {
        return relationTable;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setOriginalFileName(String originalFileName) 
    {
        this.originalFileName = originalFileName;
    }

    public String getOriginalFileName() 
    {
        return originalFileName;
    }
    public void setOriginalFilePath(String originalFilePath) 
    {
        this.originalFilePath = originalFilePath;
    }

    public String getOriginalFilePath() 
    {
        return originalFilePath;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("relationId", getRelationId())
            .append("relationTable", getRelationTable())
            .append("title", getTitle())
            .append("originalFileName", getOriginalFileName())
            .append("originalFilePath", getOriginalFilePath())
            .append("fileName", getFileName())
            .append("filePath", getFilePath())
            .append("url", getUrl())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
