package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.XlPatrolPlan;

/**
 * 网格员--巡查计划Service接口
 * 
 * @author ruoyi
 * @date 2021-05-22
 */
public interface IXlPatrolPlanService 
{
    /**
     * 查询网格员--巡查计划
     * 
     * @param id 网格员--巡查计划ID
     * @return 网格员--巡查计划
     */
    public XlPatrolPlan selectXlPatrolPlanById(Long id);

    /**
     * 查询网格员--巡查计划列表
     * 
     * @param xlPatrolPlan 网格员--巡查计划
     * @return 网格员--巡查计划集合
     */
    public List<XlPatrolPlan> selectXlPatrolPlanList(XlPatrolPlan xlPatrolPlan);

    /**
     * 新增网格员--巡查计划
     * 
     * @param xlPatrolPlan 网格员--巡查计划
     * @return 结果
     */
    public int insertXlPatrolPlan(XlPatrolPlan xlPatrolPlan);

    /**
     * 修改网格员--巡查计划
     * 
     * @param xlPatrolPlan 网格员--巡查计划
     * @return 结果
     */
    public int updateXlPatrolPlan(XlPatrolPlan xlPatrolPlan);

    /**
     * 批量删除网格员--巡查计划
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlPatrolPlanByIds(String ids);

    /**
     * 删除网格员--巡查计划信息
     * 
     * @param id 网格员--巡查计划ID
     * @return 结果
     */
    public int deleteXlPatrolPlanById(Long id);
}
