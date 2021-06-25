package com.ruoyi.quartz.task;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.property.XlPropertyPatrolStatistic;
import com.ruoyi.system.service.property.IXlDeductionRecordService;
import com.ruoyi.system.service.property.IXlPropertyPatrolRecordService;
import com.ruoyi.system.service.property.IXlPropertyPatrolStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * author: Riley
 * Date: 2021/6/8
 * Description: 物业定时任务
 */
@Component("propertyTask")
public class PropertyTask {

    @Autowired
    private IXlPropertyPatrolStatisticService statisticService;

    @Autowired
    private IXlDeductionRecordService deductionRecordService;

    /**
     * 物业巡更统计定时任务
     * 每天凌晨2点执行一次 0 0 2 * * ?
     */
    public void patrolStatistic(){
       statisticService.statisticTask();
    }

    /**
     * 物业考核
     * 每30分钟执行一次 0 0/30 * * * ?
     */
    public void propertyExamine(){
        deductionRecordService.propertyEventExamine();
    }
}
