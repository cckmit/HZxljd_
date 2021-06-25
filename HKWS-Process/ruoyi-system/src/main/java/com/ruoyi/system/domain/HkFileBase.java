package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资料库对象 hk_file_base
 * 
 * @author ruoyi
 * @date 2021-03-11
 */
public class HkFileBase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 文件所有人id */
    @Excel(name = "文件所有人id")
    private Long userId;

    /** 源文件名称 */
    @Excel(name = "源文件名称")
    private String originalName;

    /** 文件名 */
    @Excel(name = "文件名")
    private String fileName;

    /** 真实地址 */
    @Excel(name = "真实地址")
    private String realPath;

    /** 资源地址 */
    @Excel(name = "资源地址")
    private String url;

    /** 文件大小 */
    @Excel(name = "文件大小")
    private Long size;

    /** 文件类型 */
    @Excel(name = "文件类型")
    private String fileType;

    /** 删除标识(1删,0正常) */
    private Integer delFlag;

    /** 分享标识(1分享,0不分享) */
    @Excel(name = "分享标识(1分享,0不分享)")
    private Integer shareFlag;

    /** MD5 */
    @Excel(name = "MD5")
    private String md5;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setOriginalName(String originalName) 
    {
        this.originalName = originalName;
    }

    public String getOriginalName() 
    {
        return originalName;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setRealPath(String realPath) 
    {
        this.realPath = realPath;
    }

    public String getRealPath() 
    {
        return realPath;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setSize(Long size) 
    {
        this.size = size;
    }

    public Long getSize() 
    {
        return size;
    }
    public void setFileType(String fileType) 
    {
        this.fileType = fileType;
    }

    public String getFileType() 
    {
        return fileType;
    }
    public void setDelFlag(Integer delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() 
    {
        return delFlag;
    }
    public void setShareFlag(Integer shareFlag) 
    {
        this.shareFlag = shareFlag;
    }

    public Integer getShareFlag() 
    {
        return shareFlag;
    }
    public void setMd5(String md5) 
    {
        this.md5 = md5;
    }

    public String getMd5() 
    {
        return md5;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("originalName", getOriginalName())
            .append("fileName", getFileName())
            .append("realPath", getRealPath())
            .append("url", getUrl())
            .append("size", getSize())
            .append("fileType", getFileType())
            .append("delFlag", getDelFlag())
            .append("shareFlag", getShareFlag())
            .append("md5", getMd5())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
