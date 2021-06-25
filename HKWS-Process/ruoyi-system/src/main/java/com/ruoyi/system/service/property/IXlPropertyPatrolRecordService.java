package com.ruoyi.system.service.property;

import com.ruoyi.system.domain.property.XlPropertyPatrolPlan;
import com.ruoyi.system.domain.property.XlPropertyPatrolRecord;

import java.util.List;

/**
 * 物业-巡更记录Service接口
 *
 * @author ruoyi
 * @date 2021-05-27
 */
public interface IXlPropertyPatrolRecordService {
    /**
     * 查询物业-巡更记录
     *
     * @param recordId 物业-巡更记录ID
     * @return 物业-巡更记录
     */
    public XlPropertyPatrolRecord selectXlPropertyPatrolRecordById(Long recordId);

    /**
     * 查询物业-巡更记录列表
     *
     * @param xlPropertyPatrolRecord 物业-巡更记录
     * @return 物业-巡更记录集合
     */
    public List<XlPropertyPatrolRecord> selectXlPropertyPatrolRecordList(XlPropertyPatrolRecord xlPropertyPatrolRecord);

    /**
     * 新增物业-巡更记录
     *
     * @param xlPropertyPatrolRecord 物业-巡更记录
     * @return 结果
     */
    public int insertXlPropertyPatrolRecord(XlPropertyPatrolRecord xlPropertyPatrolRecord);

    /**
     * 修改物业-巡更记录
     *
     * @param xlPropertyPatrolRecord 物业-巡更记录
     * @return 结果
     */
    public int updateXlPropertyPatrolRecord(XlPropertyPatrolRecord xlPropertyPatrolRecord);

    /**
     * 批量删除物业-巡更记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlPropertyPatrolRecordByIds(String ids);

    /**
     * 删除物业-巡更记录信息
     *
     * @param recordId 物业-巡更记录ID
     * @return 结果
     */
    public int deleteXlPropertyPatrolRecordById(Long recordId);

    /**
     * 通过巡更计划id修改记录
     *
     * @param xlPropertyPatrolPlan
     * @return
     */
    public int updateRecordByPlanId(XlPropertyPatrolRecord xlPropertyPatrolRecord);

    /**
     * 通过巡更计划id删除记录，只删除待处理的任务
     *
     * @param planId
     * @return
     */
    public int deleteRecordByPlanId(Long planId);

    /**
     * 查询前一天完成的巡更记录数
     * @return
     */
    public Long selectYesterdayFinishCount();

    /**
     * 查询前一天未完成的巡更记录数
     * @return
     */
    public Long selectYesterdayUnFinishCount();

    /**
     * 查询前一天巡更记录总数
     * @return
     */
    public Long selectYesterdayCount();
}
