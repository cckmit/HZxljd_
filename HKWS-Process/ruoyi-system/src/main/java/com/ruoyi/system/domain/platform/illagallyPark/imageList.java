package com.ruoyi.system.domain.platform.illagallyPark;

import java.io.Serializable;
import java.util.Date;

/**
 * @author FanKaibiao
 * @date 2021-05-20-10:31
 */
/**
 * Copyright 2021 json.cn
 */

/**
 * Auto-generated: 2021-05-20 10:28:2
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class imageList implements Serializable{

    private String imageUrl;
    private String relationId;
    private String id;
    private Date uploadTime;
    private String imageType;
    private String imageSubType;
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }
    public String getRelationId() {
        return relationId;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
    public Date getUploadTime() {
        return uploadTime;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
    public String getImageType() {
        return imageType;
    }

    public void setImageSubType(String imageSubType) {
        this.imageSubType = imageSubType;
    }
    public String getImageSubType() {
        return imageSubType;
    }

}
