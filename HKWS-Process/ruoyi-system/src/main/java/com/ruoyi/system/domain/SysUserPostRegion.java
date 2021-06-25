package com.ruoyi.system.domain;



import java.io.Serializable;
import java.util.Set;

/**
 * (SysUserPostRegion)表实体类
 *
 * @author makejava
 * @since 2021-03-27 16:11:42
 */
@SuppressWarnings("serial")
public class SysUserPostRegion implements Serializable{
    //用户id
    private Integer userId;
    //职能id
    private Integer postId;
    //区域id
    private Integer regionId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }
    public SysUserPostRegion(Integer postId, String regionId) {
        this.postId = postId;
        this.regionId = Integer.valueOf(regionId);
    }
    public SysUserPostRegion(Integer userId, Integer postId, Integer regionId) {
        this.userId = userId;
        this.postId = postId;
        this.regionId = regionId;
    }
}
