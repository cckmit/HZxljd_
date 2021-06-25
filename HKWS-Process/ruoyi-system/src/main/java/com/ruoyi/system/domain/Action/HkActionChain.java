package com.ruoyi.system.domain.Action;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.annotation.Excel.ColumnType;

import java.util.Date;

/**
 * @author FanKaibiao
 * @date 2020-12-09-23:00
 * 行动链表
 */
public class HkActionChain extends BaseEntity {
    /**
     * 自增id
     */
    @Excel(name = "用户序号", cellType = ColumnType.NUMERIC, prompt = "行动链编号")
    private Integer id;
    /**
     * 行动链名称
     */
    @Excel(name = "行动链名称")
    private String actionName;
    /**
     * 行动链ID
     */
    @Excel(name = "行动链ID")
    private String actionChainId;
    /**
     * 事件类型
     */
    @Excel(name = "事件类型")

    private String actionStandard;
    /**
     * 设置超时时间
     */
    @Excel(name = "设置超时时间")
    private String  expectedEvents;
    /**
     * 区域code
     */
    private String actionRegionCode;
    /**
     * 区域
     */
    @Excel(name = "区域")
    private String actionRegion;
    /**
     * 创建人
     */
    @Excel(name = "创建人")
    private String createUser;
    /**
     * 创建时间
     */
    @Excel(name = "创建时间")
    private Date createTime;
    /**
     * 修改人
     */
    private String updateUser;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 描述
     */
    @Excel(name = "描述")
    private String actionRemark;
    /**
     * 是否共治
     */
    @Excel(name = "是否共治", readConverterExp = "0=否,1=是")
    private Integer isGovernance;

    private String time;

    private String num;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionChainId() {
        return actionChainId;
    }

    public void setActionChainId(String actionChainId) {
        this.actionChainId = actionChainId;
    }

    public String getActionStandard() {
        return actionStandard;
    }

    public void setActionStandard(String actionStandard) {
        this.actionStandard = actionStandard;
    }

    public String getExpectedEvents() {
        return expectedEvents;
    }

    public void setExpectedEvents(String expectedEvents) {
        this.expectedEvents = expectedEvents;
    }

    public String getActionRegionCode() {
        return actionRegionCode;
    }

    public void setActionRegionCode(String actionRegionCode) {
        this.actionRegionCode = actionRegionCode;
    }

    public String getActionRegion() {
        return actionRegion;
    }

    public void setActionRegion(String actionRegion) {
        this.actionRegion = actionRegion;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getActionRemark() {
        return actionRemark;
    }

    public void setActionRemark(String actionRemark) {
        this.actionRemark = actionRemark;
    }

    public Integer getIsGovernance() {
        return isGovernance;
    }

    public void setIsGovernance(Integer isGovernance) {
        this.isGovernance = isGovernance;
    }
}
