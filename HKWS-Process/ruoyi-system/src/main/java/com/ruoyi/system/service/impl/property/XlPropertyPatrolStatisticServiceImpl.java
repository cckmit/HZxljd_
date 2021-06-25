package com.ruoyi.system.service.impl.property;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.property.XlPropertyPatrolStatistic;
import com.ruoyi.system.mapper.property.XlPropertyPatrolRecordMapper;
import com.ruoyi.system.mapper.property.XlPropertyPatrolStatisticMapper;
import com.ruoyi.system.service.property.IXlPropertyPatrolStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 物业-巡更统计Service业务层处理
 *
 * @author ruoyi
 * @date 2021-06-08
 */
@Service
public class XlPropertyPatrolStatisticServiceImpl implements IXlPropertyPatrolStatisticService
{
    @Autowired
    private XlPropertyPatrolStatisticMapper xlPropertyPatrolStatisticMapper;

    @Autowired
    private XlPropertyPatrolRecordMapper xlPropertyPatrolRecordMapper;

    /**
     * 查询物业-巡更统计
     *
     * @param statisticId 物业-巡更统计ID
     * @return 物业-巡更统计
     */
    @Override
    public XlPropertyPatrolStatistic selectXlPropertyPatrolStatisticById(Long statisticId)
    {
        return xlPropertyPatrolStatisticMapper.selectXlPropertyPatrolStatisticById(statisticId);
    }

    /**
     * 查询物业-巡更统计列表
     *
     * @param xlPropertyPatrolStatistic 物业-巡更统计
     * @return 物业-巡更统计
     */
    @Override
    public List<XlPropertyPatrolStatistic> selectXlPropertyPatrolStatisticList(XlPropertyPatrolStatistic xlPropertyPatrolStatistic)
    {
        return xlPropertyPatrolStatisticMapper.selectXlPropertyPatrolStatisticList(xlPropertyPatrolStatistic);
    }

    /**
     * 新增物业-巡更统计
     *
     * @param xlPropertyPatrolStatistic 物业-巡更统计
     * @return 结果
     */
    @Override
    public int insertXlPropertyPatrolStatistic(XlPropertyPatrolStatistic xlPropertyPatrolStatistic)
    {
        xlPropertyPatrolStatistic.setCreateTime(DateUtils.getNowDate());
        return xlPropertyPatrolStatisticMapper.insertXlPropertyPatrolStatistic(xlPropertyPatrolStatistic);
    }

    /**
     * 修改物业-巡更统计
     *
     * @param xlPropertyPatrolStatistic 物业-巡更统计
     * @return 结果
     */
    @Override
    public int updateXlPropertyPatrolStatistic(XlPropertyPatrolStatistic xlPropertyPatrolStatistic)
    {
        xlPropertyPatrolStatistic.setUpdateTime(DateUtils.getNowDate());
        return xlPropertyPatrolStatisticMapper.updateXlPropertyPatrolStatistic(xlPropertyPatrolStatistic);
    }

    /**
     * 删除物业-巡更统计对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlPropertyPatrolStatisticByIds(String ids)
    {
        return xlPropertyPatrolStatisticMapper.deleteXlPropertyPatrolStatisticByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业-巡更统计信息
     *
     * @param statisticId 物业-巡更统计ID
     * @return 结果
     */
    @Override
    public int deleteXlPropertyPatrolStatisticById(Long statisticId)
    {
        return xlPropertyPatrolStatisticMapper.deleteXlPropertyPatrolStatisticById(statisticId);
    }

    /**
     * 定时统计
     * @return
     */
    @Override
    @Transactional
    public int statisticTask() {
        //巡更统计
        XlPropertyPatrolStatistic statistic = new XlPropertyPatrolStatistic();
        //前一天
        Date yesterday = DateUtils.addDays(new Date(), -1);
        statistic.setStatisticDate(yesterday);
        //查询前一天完成的任务数
        Long finishCount = xlPropertyPatrolRecordMapper.selectYesterdayFinishCount();
        statistic.setFinishCount(finishCount);
        //查询前一天未完成的任务数
        Long unfinishCount = xlPropertyPatrolRecordMapper.selectYesterdayUnFinishCount();
        statistic.setUnfinishCount(unfinishCount);
        //查询前一天巡更记录总数
        Long patrolCount = xlPropertyPatrolRecordMapper.selectYesterdayCount();
        statistic.setPatrolCount(patrolCount);
        //完成率
        Double finishRate = finishCount * 1.0 / patrolCount;
        statistic.setFinishRate(finishRate * 100 + "%");
        //添加
        Integer count = xlPropertyPatrolStatisticMapper.insertXlPropertyPatrolStatistic(statistic);
        return count;
    }
}
