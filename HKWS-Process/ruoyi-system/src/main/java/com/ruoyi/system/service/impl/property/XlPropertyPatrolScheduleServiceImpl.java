package com.ruoyi.system.service.impl.property;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.property.XlPropertyPatrolPlan;
import com.ruoyi.system.domain.property.XlPropertyPatrolSchedule;
import com.ruoyi.system.mapper.property.XlPropertyPatrolScheduleMapper;
import com.ruoyi.system.service.property.IXlPropertyPatrolScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 物业-巡更排班Service业务层处理
 *
 * @author ruoyi
 * @date 2021-06-06
 */
@Service
public class XlPropertyPatrolScheduleServiceImpl implements IXlPropertyPatrolScheduleService
{
    @Autowired
    private XlPropertyPatrolScheduleMapper xlPropertyPatrolScheduleMapper;

    /**
     * 查询物业-巡更排班
     *
     * @param scheduleId 物业-巡更排班ID
     * @return 物业-巡更排班
     */
    @Override
    public XlPropertyPatrolSchedule selectXlPropertyPatrolScheduleById(Long scheduleId)
    {
        return xlPropertyPatrolScheduleMapper.selectXlPropertyPatrolScheduleById(scheduleId);
    }

    /**
     * 查询物业-巡更排班列表
     *
     * @param xlPropertyPatrolSchedule 物业-巡更排班
     * @return 物业-巡更排班
     */
    @Override
    public List<XlPropertyPatrolSchedule> selectXlPropertyPatrolScheduleList(XlPropertyPatrolSchedule xlPropertyPatrolSchedule)
    {
        return xlPropertyPatrolScheduleMapper.selectXlPropertyPatrolScheduleList(xlPropertyPatrolSchedule);
    }

    /**
     * 新增物业-巡更排班
     *
     * @param xlPropertyPatrolSchedule 物业-巡更排班
     * @return 结果
     */
    @Override
    public int insertXlPropertyPatrolSchedule(XlPropertyPatrolSchedule xlPropertyPatrolSchedule)
    {
        xlPropertyPatrolSchedule.setCreateTime(DateUtils.getNowDate());
        return xlPropertyPatrolScheduleMapper.insertXlPropertyPatrolSchedule(xlPropertyPatrolSchedule);
    }

    /**
     * 修改物业-巡更排班
     *
     * @param xlPropertyPatrolSchedule 物业-巡更排班
     * @return 结果
     */
    @Override
    public int updateXlPropertyPatrolSchedule(XlPropertyPatrolSchedule xlPropertyPatrolSchedule)
    {
        xlPropertyPatrolSchedule.setUpdateTime(DateUtils.getNowDate());
        return xlPropertyPatrolScheduleMapper.updateXlPropertyPatrolSchedule(xlPropertyPatrolSchedule);
    }

    /**
     * 删除物业-巡更排班对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlPropertyPatrolScheduleByIds(String ids)
    {
        return xlPropertyPatrolScheduleMapper.deleteXlPropertyPatrolScheduleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业-巡更排班信息
     *
     * @param scheduleId 物业-巡更排班ID
     * @return 结果
     */
    @Override
    public int deleteXlPropertyPatrolScheduleById(Long scheduleId)
    {
        return xlPropertyPatrolScheduleMapper.deleteXlPropertyPatrolScheduleById(scheduleId);
    }

    /**
     * 根据巡更计划id修改巡更排班
     * @param xlPropertyPatrolPlan
     * @return
     */
    @Override
    public int updateScheduleByPlanId(XlPropertyPatrolSchedule xlPropertyPatrolSchedule) {
        return xlPropertyPatrolScheduleMapper.updateScheduleByPlanId(xlPropertyPatrolSchedule);
    }

    /**
     * 通过巡更计划id删除排班
     * @param planId
     * @return
     */
    @Override
    public int deleteScheduleByPlanId(Long planId) {
        return xlPropertyPatrolScheduleMapper.deleteScheduleByPlanId(planId);
    }
}