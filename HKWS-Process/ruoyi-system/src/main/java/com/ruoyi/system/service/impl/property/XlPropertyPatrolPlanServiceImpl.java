package com.ruoyi.system.service.impl.property;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.property.XlPropertyPatrolPath;
import com.ruoyi.system.domain.property.XlPropertyPatrolPlan;
import com.ruoyi.system.domain.property.XlPropertyPatrolRecord;
import com.ruoyi.system.domain.property.XlUserPlanRel;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.mapper.property.*;
import com.ruoyi.system.service.property.IXlPropertyPatrolPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 物业-巡更计划Service业务层处理
 *
 * @author ruoyi
 * @date 2021-05-27
 */
@Service
public class XlPropertyPatrolPlanServiceImpl implements IXlPropertyPatrolPlanService
{
    @Autowired
    private XlPropertyPatrolPlanMapper xlPropertyPatrolPlanMapper;

    @Autowired
    private XlUserPlanRelMapper xlUserPlanRelMapper;

    @Autowired
    private XlPropertyPatrolScheduleMapper xlPropertyPatrolScheduleMapper;

    @Autowired
    private XlPropertyPatrolRecordMapper xlPropertyPatrolRecordMapper;

    @Autowired
    private XlPropertyPatrolPathMapper xlPropertyPatrolPathMapper;

    @Autowired
    private SysUserMapper userMapper;

    /**
     * 查询物业-巡更计划
     *
     * @param planId 物业-巡更计划ID
     * @return 物业-巡更计划
     */
    @Override
    public XlPropertyPatrolPlan selectXlPropertyPatrolPlanById(Long planId)
    {
        return xlPropertyPatrolPlanMapper.selectXlPropertyPatrolPlanById(planId);
    }

    /**
     * 查询物业-巡更计划列表
     *
     * @param xlPropertyPatrolPlan 物业-巡更计划
     * @return 物业-巡更计划
     */
    @Override
    public List<XlPropertyPatrolPlan> selectXlPropertyPatrolPlanList(XlPropertyPatrolPlan xlPropertyPatrolPlan)
    {
        return xlPropertyPatrolPlanMapper.selectXlPropertyPatrolPlanList(xlPropertyPatrolPlan);
    }

    /**
     * 新增物业-巡更计划
     *
     * @param xlPropertyPatrolPlan 物业-巡更计划
     * @return 结果
     */
    @Override
    @Transactional
    public int insertXlPropertyPatrolPlan(XlPropertyPatrolPlan xlPropertyPatrolPlan)
    {
        xlPropertyPatrolPlan.setCreateTime(DateUtils.getNowDate());
        Integer count = xlPropertyPatrolPlanMapper.insertXlPropertyPatrolPlan(xlPropertyPatrolPlan);
        List<Long> userIds = xlPropertyPatrolPlan.getUserIds(); //巡更员id
        Long planId = xlPropertyPatrolPlan.getPlanId(); //巡更计划id
        if(count > 0){
            //新增巡更计划与巡更员关联
            XlUserPlanRel xlUserPlanRel = new XlUserPlanRel();
            xlUserPlanRel.setPlanId(planId); //巡更计划id
            for(Long userId: userIds){
                xlUserPlanRel.setUserId(userId);
                //添加
                xlUserPlanRelMapper.insertXlUserPlanRel(xlUserPlanRel);
            }
        }

        //生成巡更任务
        XlPropertyPatrolRecord record =  new XlPropertyPatrolRecord();
        //巡更路线
        Long pathId = xlPropertyPatrolPlan.getPathId();
        XlPropertyPatrolPath path = xlPropertyPatrolPathMapper.selectXlPropertyPatrolPathById(pathId);
        record.setPathId(path.getPathId());
        record.setPathName(path.getPathName());
        //巡更时长
        record.setPatrolDuration(path.getPatrolDuration());
        //巡更计划
        record.setPlanName(xlPropertyPatrolPlan.getPlanName());
        record.setPlanId(xlPropertyPatrolPlan.getPlanId());
        //巡更员
        for(Long userId: userIds){
            SysUser user = userMapper.selectUserById(userId);
            record.setUserName(user.getUserName());
            record.setUserId(userId);
            //开始时间
            Date startTime = xlPropertyPatrolPlan.getPlanStartTime();
            //结束时间
            Date endTime = xlPropertyPatrolPlan.getPlanEndTime();
            //巡更周期
            Integer cycle = Integer.valueOf(xlPropertyPatrolPlan.getPlanCycle());
            //巡更时间点
            Integer[] timings = Convert.toIntArray(xlPropertyPatrolPlan.getPlanCycleTiming());
            //开始时间在结束时间之前,且结束日期当天也要分配任务
            while(startTime.before(DateUtils.addDays(endTime, 1))){
                for(Integer timing : timings){
                    //计划执行巡更任务的时间
                    Date date = DateUtils.addHours(startTime, timing);
                    if(date.after(new Date())){ //计划时间在当前时间之后
                        //巡更开始时间
                        record.setPatrolTime(date);
                        record.setCreateTime(DateUtils.getNowDate());
                        record.setUpdateTime(DateUtils.getNowDate());
                        xlPropertyPatrolRecordMapper.insertXlPropertyPatrolRecord(record);
                    }
                }
                startTime = DateUtils.addDays(startTime, cycle);
            }
        }
        return count;
    }

    /**
     * 修改物业-巡更计划
     *
     * @param xlPropertyPatrolPlan 物业-巡更计划
     * @return 结果
     */
    @Override
    @Transactional
    public int updateXlPropertyPatrolPlan(XlPropertyPatrolPlan xlPropertyPatrolPlan)
    {
        xlPropertyPatrolPlan.setUpdateTime(DateUtils.getNowDate());
        //修改巡更计划与巡更员的关联
        Long planId = xlPropertyPatrolPlan.getPlanId(); //巡更计划id
        List<Long> userIds = xlPropertyPatrolPlan.getUserIds();
        //删除原关联
        xlUserPlanRelMapper.deleteXlUserPlanRelByPlanId(planId);
        //重新保存关联信息
        XlUserPlanRel xlUserPlanRel = new XlUserPlanRel();
        xlUserPlanRel.setPlanId(planId);
        for(Long userId: userIds){
            xlUserPlanRel.setUserId(userId);
            //添加
            xlUserPlanRelMapper.insertXlUserPlanRel(xlUserPlanRel);
        }
        xlPropertyPatrolPlan.setPlanStatus(0); //巡更计划改为可执行

        //任务
        XlPropertyPatrolRecord record =  new XlPropertyPatrolRecord();
        //删除原记录，只删除待处理的任务
        xlPropertyPatrolRecordMapper.deleteRecordByPlanId(planId);

        //巡更计划
        record.setPlanId(xlPropertyPatrolPlan.getPlanId()); //记录
        List<XlPropertyPatrolRecord> recordList =
                xlPropertyPatrolRecordMapper.selectXlPropertyPatrolRecordList(record); //原巡更记录
        record.setPlanName(xlPropertyPatrolPlan.getPlanName());
        //巡更路线
        Long pathId = xlPropertyPatrolPlan.getPathId();
        XlPropertyPatrolPath path = xlPropertyPatrolPathMapper.selectXlPropertyPatrolPathById(pathId);
        record.setPathId(path.getPathId());  //记录
        record.setPathName(path.getPathName());
        //巡更员
        for(Long userId: userIds){
            SysUser user = userMapper.selectUserById(userId);
            record.setUserName(user.getUserName()); //记录
            record.setUserId(userId);
            //开始时间
            Date startTime = xlPropertyPatrolPlan.getPlanStartTime();
            //结束时间
            Date endTime = xlPropertyPatrolPlan.getPlanEndTime();
            //巡更时长
            record.setPatrolDuration(path.getPatrolDuration());
            //巡更周期
            Integer cycle = Integer.valueOf(xlPropertyPatrolPlan.getPlanCycle());
            //巡更时间点
            Integer[] timings = Convert.toIntArray(xlPropertyPatrolPlan.getPlanCycleTiming());
            //开始时间在结束时间之前,且结束日期当天分配任务也要修改
            while(startTime.before(DateUtils.addDays(endTime, 1))){
                for(Integer timing : timings){
                    //计划执行巡更任务的时间
                    Date date = DateUtils.addHours(startTime, timing);
                    if(date.after(new Date())){ //计划时间在当前时间之后
                        //巡更开始时间
                        record.setPatrolTime(date);
                        record.setCreateTime(DateUtils.getNowDate());
                        record.setUpdateTime(DateUtils.getNowDate());
                        xlPropertyPatrolRecordMapper.insertXlPropertyPatrolRecord(record);
                    }
                }
                startTime = DateUtils.addDays(startTime, cycle);
            }
        }
        return xlPropertyPatrolPlanMapper.updateXlPropertyPatrolPlan(xlPropertyPatrolPlan);
    }

    /**
     * 删除物业-巡更计划对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlPropertyPatrolPlanByIds(String ids)
    {
        return xlPropertyPatrolPlanMapper.deleteXlPropertyPatrolPlanByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业-巡更计划信息
     *
     * @param planId 物业-巡更计划ID
     * @return 结果
     */
    @Override
    public int deleteXlPropertyPatrolPlanById(Long planId)
    {
        return xlPropertyPatrolPlanMapper.deleteXlPropertyPatrolPlanById(planId);
    }


    /**
     * 通过巡更路线id,修改巡更计划的执行状态
     * @param xlPropertyPatrolPlan
     * @return
     */
    @Override
    public int updatePlanStatusByPathId(XlPropertyPatrolPlan xlPropertyPatrolPlan) {
        return xlPropertyPatrolPlanMapper.updatePlanStatusByPathId(xlPropertyPatrolPlan);
    }

    /**
     * 删除巡更计划 仅修改巡更计划的删除标识，保留数据 单删
     * @param planId
     * @return
     */
    @Override
    public int deletePlanById(Long planId) {
        return xlPropertyPatrolPlanMapper.deletePlanById(planId);
    }

    /**
     * 删除巡更计划 仅修改巡更计划的删除标识，保留数据 批删
     * @param planIds
     * @return
     */
    @Override
    public int deletePlanByIds(String ids) {
        return xlPropertyPatrolPlanMapper.deletePlanByIds(Convert.toStrArray(ids));
    }

    /**
     * 连表查询
     * @param xlPropertyPatrolPlan
     * @return
     */
    @Override
    public List<XlPropertyPatrolPlan> selectXlPropertyPatrolPlanVoList(XlPropertyPatrolPlan xlPropertyPatrolPlan) {
        return xlPropertyPatrolPlanMapper.selectXlPropertyPatrolPlanVoList(xlPropertyPatrolPlan);
    }

    /**
     * 连表主键查询
     * @param planId
     * @return
     */
    @Override
    public XlPropertyPatrolPlan selectXlPropertyPatrolPlanVoById(Long planId) {
        return xlPropertyPatrolPlanMapper.selectXlPropertyPatrolPlanVoById(planId);
    }

    @Override
    public List<XlPropertyPatrolPlan> selectXlPropertyPatrolPlanListByproperty(Integer[] villageId,XlPropertyPatrolPlan XlPropertyPatrolPlan) {
        HashMap map=new HashMap();
        map.put("villageId",villageId);
        map.put("XlPropertyPatrolPlan",XlPropertyPatrolPlan);
        return xlPropertyPatrolPlanMapper.selectXlPropertyPatrolPlanListByproperty(map);
    }
}
