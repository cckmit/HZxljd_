package com.ruoyi.system.domain.HkEarlyWarning;

/**
 *
 * @description:
 * @create: 2021-03-27 20:43
 **/
public class SysUserPostRegionVo {

    /** 区域id */
    private  Integer id;
    /** 区域名字*/
    private String name;
    /**区域的标题 */
    private String title;

    //用户id
    private Integer userId;

    //职能id
    private Integer postId;

    //区域id
    private Integer regionId;

    //职能名称
    private String postName;

    //区域名称
    private String regionName;

    //区域-职能对应的用户数量
    private Integer regionPostUserCount;

    /**   是否选中 */
    private  float  checked;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getChecked() {
        return checked;
    }

    public void setChecked(float checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "SysUserPostRegionVo{" +
                "id=" + id +
                ", postId=" + postId +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", checked=" + checked +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Integer getRegionPostUserCount() {
        return regionPostUserCount;
    }

    public void setRegionPostUserCount(Integer regionPostUserCount) {
        this.regionPostUserCount = regionPostUserCount;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
