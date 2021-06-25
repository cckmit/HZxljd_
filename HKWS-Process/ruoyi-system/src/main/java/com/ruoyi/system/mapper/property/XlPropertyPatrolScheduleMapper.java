package com.ruoyi.system.mapper.property;

import com.ruoyi.system.domain.property.XlPropertyPatrolPlan;
import com.ruoyi.system.domain.property.XlPropertyPatrolSchedule;

import java.util.List;

/**
 * 物业-巡更排班Mapper接口
 *
 * @author ruoyi
 * @date 2021-06-06
 */
public interface XlPropertyPatrolScheduleMapper
{
    /**
     * 查询物业-巡更排班
     *
     * @param scheduleId 物业-巡更排班ID
     * @return 物业-巡更排班
     */
    public XlPropertyPatrolSchedule selectXlPropertyPatrolScheduleById(Long scheduleId);

    /**
     * 查询物业-巡更排班列表
     *
     * @param xlPropertyPatrolSchedule 物业-巡更排班
     * @return 物业-巡更排班集合
     */
    public List<XlPropertyPatrolSchedule> selectXlPropertyPatrolScheduleList(XlPropertyPatrolSchedule xlPropertyPatrolSchedule);

    /**
     * 新增物业-巡更排班
     *
     * @param xlPropertyPatrolSchedule 物业-巡更排班
     * @return 结果
     */
    public int insertXlPropertyPatrolSchedule(XlPropertyPatrolSchedule xlPropertyPatrolSchedule);

    /**
     * 修改物业-巡更排班
     *
     * @param xlPropertyPatrolSchedule 物业-巡更排班
     * @return 结果
     */
    public int updateXlPropertyPatrolSchedule(XlPropertyPatrolSchedule xlPropertyPatrolSchedule);

    /**
     * 删除物业-巡更排班
     *
     * @param scheduleId 物业-巡更排班ID
     * @return 结果
     */
    public int deleteXlPropertyPatrolScheduleById(Long scheduleId);

    /**
     * 批量删除物业-巡更排班
     *
     * @param scheduleIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlPropertyPatrolScheduleByIds(String[] scheduleIds);

    /**
     * 根据巡更计划id修改巡更排班
     * @param xlPropertyPatrolPlan
     * @return
     */
    public int updateScheduleByPlanId(XlPropertyPatrolSchedule xlPropertyPatrolSchedule);

    /**
     * 通过巡更计划id删除排班
     * @param planId
     * @return
     */
    public int deleteScheduleByPlanId(Long planId);
}