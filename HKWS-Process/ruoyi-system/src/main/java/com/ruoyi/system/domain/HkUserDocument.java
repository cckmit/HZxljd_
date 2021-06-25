package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.system
 * @ClassName: HkUserDocument
 * @Author: guohailong
 * @Description: 浙政钉-用户公文收藏表
 * @Date: 2021/3/10 20:37
 * @Version: 1.0
 */
public class HkUserDocument extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 公文id
     */
    private Long documentId;

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public Long getDocumentId() {
        return documentId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("userId", getUserId())
                .append("documentId", getDocumentId())
                .toString();
    }
}

