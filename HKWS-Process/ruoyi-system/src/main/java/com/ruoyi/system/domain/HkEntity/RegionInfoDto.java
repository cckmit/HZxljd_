package com.ruoyi.system.domain.HkEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author FanKaibiao
 * @date 2020-12-21-15:01
 */
public class RegionInfoDto implements Serializable {
    /**
     * 区域编码
     */
    private String indexCode;
    /**
     *父区域编码
     */
    private String parentIndexCode;
    /**
     *区域名称
     */
    private String name;
    /**
     *区域范围坐标串
     */
    private String  rings;
    /**
     *区域范围中心点
     */
    private String centerPoint;
    /**
     *区域标签
     */
    private String tag;
    /**
     *区域标签名称
     */
    private String tagName;
    /**
     *区域关联的用户信息
     */
    private List  users;
    /**
     *区域关联的人员信息
     */
    private List persons;

    private List<UserDto> userDto;

    public List<UserDto> getUserDto() {
        return userDto;
    }

    public void setUserDto(List<UserDto> userDto) {
        this.userDto = userDto;
    }

    public String getIndexCode() {
        return indexCode;
    }

    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode;
    }

    public String getParentIndexCode() {
        return parentIndexCode;
    }

    public void setParentIndexCode(String parentIndexCode) {
        this.parentIndexCode = parentIndexCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRings() {
        return rings;
    }

    public void setRings(String rings) {
        this.rings = rings;
    }

    public String getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(String centerPoint) {
        this.centerPoint = centerPoint;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List getUsers() {
        return users;
    }

    public void setUsers(List users) {
        this.users = users;
    }

    public List getPersons() {
        return persons;
    }

    public void setPersons(List persons) {
        this.persons = persons;
    }

    public RegionInfoDto() {
    }

    public RegionInfoDto(String indexCode, String parentIndexCode, String name, String rings, String centerPoint, String tag, String tagName, List users, List persons) {
        this.indexCode = indexCode;
        this.parentIndexCode = parentIndexCode;
        this.name = name;
        this.rings = rings;
        this.centerPoint = centerPoint;
        this.tag = tag;
        this.tagName = tagName;
        this.users = users;
        this.persons = persons;
    }
}
