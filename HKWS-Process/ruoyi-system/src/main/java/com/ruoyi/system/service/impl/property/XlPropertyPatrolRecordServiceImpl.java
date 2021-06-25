package com.ruoyi.system.service.impl.property;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.property.XlPropertyPatrolPlan;
import com.ruoyi.system.domain.property.XlPropertyPatrolRecord;
import com.ruoyi.system.mapper.property.XlPropertyPatrolRecordMapper;
import com.ruoyi.system.service.property.IXlPropertyPatrolRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 物业-巡更记录Service业务层处理
 *
 * @author ruoyi
 * @date 2021-05-27
 */
@Service
public class XlPropertyPatrolRecordServiceImpl implements IXlPropertyPatrolRecordService
{
    @Autowired
    private XlPropertyPatrolRecordMapper xlPropertyPatrolRecordMapper;

    /**
     * 查询物业-巡更记录
     *
     * @param recordId 物业-巡更记录ID
     * @return 物业-巡更记录
     */
    @Override
    public XlPropertyPatrolRecord selectXlPropertyPatrolRecordById(Long recordId)
    {
        return xlPropertyPatrolRecordMapper.selectXlPropertyPatrolRecordById(recordId);
    }

    /**
     * 查询物业-巡更记录列表
     *
     * @param xlPropertyPatrolRecord 物业-巡更记录
     * @return 物业-巡更记录
     */
    @Override
    public List<XlPropertyPatrolRecord> selectXlPropertyPatrolRecordList(XlPropertyPatrolRecord xlPropertyPatrolRecord)
    {
        return xlPropertyPatrolRecordMapper.selectXlPropertyPatrolRecordList(xlPropertyPatrolRecord);
    }

    /**
     * 新增物业-巡更记录
     *
     * @param xlPropertyPatrolRecord 物业-巡更记录
     * @return 结果
     */
    @Override
    public int insertXlPropertyPatrolRecord(XlPropertyPatrolRecord xlPropertyPatrolRecord)
    {
        xlPropertyPatrolRecord.setCreateTime(DateUtils.getNowDate());
        return xlPropertyPatrolRecordMapper.insertXlPropertyPatrolRecord(xlPropertyPatrolRecord);
    }

    /**
     * 修改物业-巡更记录
     *
     * @param xlPropertyPatrolRecord 物业-巡更记录
     * @return 结果
     */
    @Override
    public int updateXlPropertyPatrolRecord(XlPropertyPatrolRecord xlPropertyPatrolRecord)
    {
        xlPropertyPatrolRecord.setUpdateTime(DateUtils.getNowDate());
        return xlPropertyPatrolRecordMapper.updateXlPropertyPatrolRecord(xlPropertyPatrolRecord);
    }

    /**
     * 删除物业-巡更记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlPropertyPatrolRecordByIds(String ids)
    {
        return xlPropertyPatrolRecordMapper.deleteXlPropertyPatrolRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业-巡更记录信息
     *
     * @param recordId 物业-巡更记录ID
     * @return 结果
     */
    @Override
    public int deleteXlPropertyPatrolRecordById(Long recordId)
    {
        return xlPropertyPatrolRecordMapper.deleteXlPropertyPatrolRecordById(recordId);
    }

    /**
     * 通过巡更计划id修改记录
     * @param xlPropertyPatrolPlan
     * @return
     */
    @Override
    public int updateRecordByPlanId(XlPropertyPatrolRecord xlPropertyPatrolRecord) {
        return xlPropertyPatrolRecordMapper.updateRecordByPlanId(xlPropertyPatrolRecord);
    }

    /**
     * 通过巡更计划id删除记录，只删除待处理的任务
     * @param planId
     * @return
     */
    @Override
    public int deleteRecordByPlanId(Long planId) {
        return xlPropertyPatrolRecordMapper.deleteRecordByPlanId(planId);
    }

    /**
     * 查询前一天完成的巡更记录数
     * @return
     */
    @Override
    public Long selectYesterdayFinishCount() {
        return xlPropertyPatrolRecordMapper.selectYesterdayFinishCount();
    }

    /**
     * 查询前一天未完成的巡更记录数
     * @return
     */
    @Override
    public Long selectYesterdayUnFinishCount() {
        return xlPropertyPatrolRecordMapper.selectYesterdayUnFinishCount();
    }

    /**
     * 查询前一天巡更记录总数
     * @return
     */
    @Override
    public Long selectYesterdayCount() {
        return xlPropertyPatrolRecordMapper.selectYesterdayCount();
    }
}
