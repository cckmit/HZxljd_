package com.ruoyi.system.mapper.property;

import com.ruoyi.system.domain.property.XlPropertyPatrolPlan;

import java.util.HashMap;
import java.util.List;

/**
 * 物业-巡更计划Mapper接口
 *
 * @author ruoyi
 * @date 2021-06-04
 */
public interface XlPropertyPatrolPlanMapper
{
    /**
     * 查询物业-巡更计划
     *
     * @param planId 物业-巡更计划ID
     * @return 物业-巡更计划
     */
    public XlPropertyPatrolPlan selectXlPropertyPatrolPlanById(Long planId);

    /**
     * 查询物业-巡更计划列表
     *
     * @param xlPropertyPatrolPlan 物业-巡更计划
     * @return 物业-巡更计划集合
     */
    public List<XlPropertyPatrolPlan> selectXlPropertyPatrolPlanList(XlPropertyPatrolPlan xlPropertyPatrolPlan);

    /**
     * 新增物业-巡更计划
     *
     * @param xlPropertyPatrolPlan 物业-巡更计划
     * @return 结果
     */
    public int insertXlPropertyPatrolPlan(XlPropertyPatrolPlan xlPropertyPatrolPlan);

    /**
     * 修改物业-巡更计划
     *
     * @param xlPropertyPatrolPlan 物业-巡更计划
     * @return 结果
     */
    public int updateXlPropertyPatrolPlan(XlPropertyPatrolPlan xlPropertyPatrolPlan);

    /**
     * 删除物业-巡更计划
     *
     * @param planId 物业-巡更计划ID
     * @return 结果
     */
    public int deleteXlPropertyPatrolPlanById(Long planId);

    /**
     * 批量删除物业-巡更计划
     *
     * @param planIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlPropertyPatrolPlanByIds(String[] planIds);

    /**
     * 通过巡更路线id,修改巡更计划的执行状态
     * @param xlPropertyPatrolPlan
     * @return
     */
    public int updatePlanStatusByPathId(XlPropertyPatrolPlan xlPropertyPatrolPlan);

    /**
     * 删除巡更计划 仅修改巡更计划的删除标识，保留数据 单删
     * @param planId
     * @return
     */
    public int deletePlanById(Long planId);

    /**
     * 删除巡更计划 仅修改巡更计划的删除标识，保留数据 批删
     * @param planIds
     * @return
     */
    public int deletePlanByIds(String[] planIds);

    /**
     * 连表查询
     * @param xlPropertyPatrolPlan
     * @return
     */
    public List<XlPropertyPatrolPlan> selectXlPropertyPatrolPlanVoList(XlPropertyPatrolPlan xlPropertyPatrolPlan);

    /**
     * 连表主键查询
     * @param planId
     * @return
     */
    public XlPropertyPatrolPlan selectXlPropertyPatrolPlanVoById(Long planId);

    List<XlPropertyPatrolPlan> selectXlPropertyPatrolPlanListByproperty(HashMap map);
}
