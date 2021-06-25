package com.ruoyi.system.mapper.property;

import com.ruoyi.system.domain.property.XlPropertyPatrolStatistic;

import java.util.List;

/**
 * 物业-巡更统计Mapper接口
 *
 * @author ruoyi
 * @date 2021-06-08
 */
public interface XlPropertyPatrolStatisticMapper
{
    /**
     * 查询物业-巡更统计
     *
     * @param statisticId 物业-巡更统计ID
     * @return 物业-巡更统计
     */
    public XlPropertyPatrolStatistic selectXlPropertyPatrolStatisticById(Long statisticId);

    /**
     * 查询物业-巡更统计列表
     *
     * @param xlPropertyPatrolStatistic 物业-巡更统计
     * @return 物业-巡更统计集合
     */
    public List<XlPropertyPatrolStatistic> selectXlPropertyPatrolStatisticList(XlPropertyPatrolStatistic xlPropertyPatrolStatistic);

    /**
     * 新增物业-巡更统计
     *
     * @param xlPropertyPatrolStatistic 物业-巡更统计
     * @return 结果
     */
    public int insertXlPropertyPatrolStatistic(XlPropertyPatrolStatistic xlPropertyPatrolStatistic);

    /**
     * 修改物业-巡更统计
     *
     * @param xlPropertyPatrolStatistic 物业-巡更统计
     * @return 结果
     */
    public int updateXlPropertyPatrolStatistic(XlPropertyPatrolStatistic xlPropertyPatrolStatistic);

    /**
     * 删除物业-巡更统计
     *
     * @param statisticId 物业-巡更统计ID
     * @return 结果
     */
    public int deleteXlPropertyPatrolStatisticById(Long statisticId);

    /**
     * 批量删除物业-巡更统计
     *
     * @param statisticIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlPropertyPatrolStatisticByIds(String[] statisticIds);
}
