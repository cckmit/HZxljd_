package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 附件对象 sys_attachment
 *
 * @author ruoyi
 * @date 2021-06-17
 */
public class SysAttachment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Integer attachmentId;

    /** 文件编号 */
    @Excel(name = "文件编号")
    private String fileCode;

    /** 附件名称 */
    @Excel(name = "附件名称")
    private String attachmentName;

    /** 附件存储路径 */
    @Excel(name = "附件存储路径")
    private String attachmentUrl;

    public void setAttachmentId(Integer attachmentId)
    {
        this.attachmentId = attachmentId;
    }

    public Integer getAttachmentId()
    {
        return attachmentId;
    }
    public void setFileCode(String fileCode)
    {
        this.fileCode = fileCode;
    }

    public String getFileCode()
    {
        return fileCode;
    }
    public void setAttachmentName(String attachmentName)
    {
        this.attachmentName = attachmentName;
    }

    public String getAttachmentName()
    {
        return attachmentName;
    }
    public void setAttachmentUrl(String attachmentUrl)
    {
        this.attachmentUrl = attachmentUrl;
    }

    public String getAttachmentUrl()
    {
        return attachmentUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("attachmentId", getAttachmentId())
                .append("fileCode", getFileCode())
                .append("attachmentName", getAttachmentName())
                .append("attachmentUrl", getAttachmentUrl())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}