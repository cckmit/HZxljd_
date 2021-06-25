package com.ruoyi.web.controller.system.HkEarlyWarning;

import cn.hutool.core.date.DateUtil;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.NumUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.service.HkEarlyWarning.HkEventService;
import com.ruoyi.system.service.ISysRanksService;
import com.ruoyi.system.service.ISysRegionService;
import com.ruoyi.system.service.statistics.HkEventStatisticsService;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author FanKaibiao
 * @date 2020-11-15-1:49
 */
@Controller
@RequestMapping("system/work")
public class WorkController extends BaseController {
    private String prefix = "system/work";

    @Autowired
    private ISysRanksService ranksService;

    @Autowired
    private HkEventService hkEventService;

    @Autowired
    private ISysRegionService regionService;

    @Autowired
    private HkEventStatisticsService statisticsService;

    @GetMapping()
    public String work(ModelMap mmap)
    {
        try{
            List<HkEventInfo> list=hkEventService.queryEventOrder();
            for (HkEventInfo event : list){
                Date createTime = event.getCreateTime();
                event.setDate(DateUtils.subStrDateStringRetainOne(DateUtil.formatBetween(new Date(),createTime))+"前");
            }
            List<HkEventInfo> endList=hkEventService.queryEventOrderEnd();
            for (HkEventInfo event : endList){
                Integer eventAlertStatus = event.getEventAlertStatus();
                if(eventAlertStatus == 6){
                    Date createTime = event.getUpdateTime();
                    event.setDateNow(DateUtils.subStrDateStringRetainOne(DateUtil.formatBetween(new Date(),createTime))+"前");
                }else if(eventAlertStatus == 9){
                    Date createTime = event.getCreateTime();
                    event.setDateNow(DateUtils.subStrDateStringRetainOne(DateUtil.formatBetween(new Date(),createTime))+"前");
                }
            }
            mmap.put("list",list);
            mmap.put("endList",endList);
        }catch(Exception ex){
            logger.info("错误信息："+ex.getMessage());
            ex.printStackTrace();
        }
        return prefix + "/work";
    }


    @GetMapping("eventInfoStatistics")
    @ResponseBody
    public AjaxResult eventInfoStatistics(){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> params = new HashMap<>();
        params.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
        int eventCount = statisticsService.countAllByParams(params);//事件总数
        params.put("statusArr",new String[]{"6","7","8","9"});
        int doneCount = statisticsService.countAllByParams(params);//完结事件总数
        params.put("statusArr",new String[]{"3","4","5","6","7","8","9"});
        int transferCount = statisticsService.countAllByParams(params);//流转事件总数
        params.put("statusArr",new String[]{"10"});
        int repetitionCount = statisticsService.countAllByParams(params);//重复报警
        params.put("statusArr",new String[]{"8"});
        int errorCount = statisticsService.countAllByParams(params);//异常报警
        Map<String,Object> curretParams = new HashMap<>();
        curretParams.put("currentDate",DateFormatUtils.format(new Date(),"yyyy-MM-dd"));
        curretParams.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
        int dayEventCount = statisticsService.countAllByParams(curretParams);//当日告警数
        Map<String,Object> param = new HashMap<>();
        param.put("level",2);
        int regionCount = regionService.queryRegionCountByParam(param);
        param.put("level",3);
        int gridCount = regionService.queryRegionCountByParam(param);
        result.put("regionCount",regionCount);
        result.put("gridCount",gridCount);
        result.put("eventCount",eventCount);
        result.put("dayEventCount",dayEventCount);
        result.put("repetitionCount",repetitionCount);
        result.put("errorCount",errorCount);
        result.put("doneCount",doneCount);
        result.put("transferRate", NumUtils.rate(new BigDecimal(transferCount),new BigDecimal(eventCount)));
        result.put("governanceRate",NumUtils.rate(new BigDecimal(doneCount),new BigDecimal(eventCount)));
        return AjaxResult.success(result);
    }

    @GetMapping("platMessage")
    @ResponseBody
    public AjaxResult platMessage(){

        //查询未绑定网格的用户
        List<Map<String, Object>> someOneNoRegion = ranksService.getSomeOneNoRegion();
        if(someOneNoRegion != null && someOneNoRegion.size() > 0){

        }
        //查询未绑定用户的网格
        List<Map<String, Object>> ranksCountByRegion = regionService.getSomeRegionNoUser();


        return AjaxResult.success("");
    }



    /**
     * 工作概览  定时刷新待处理事件模块
     * @param mmap
     * @return
     */
    @GetMapping("/refresh1")
    public String refresh1(ModelMap mmap){
        List<HkEventInfo> list=hkEventService.queryEventOrder();
        for (HkEventInfo event : list){
            Date createTime = event.getCreateTime();
            event.setDate(DateUtils.subStrDateStringRetainOne(DateUtil.formatBetween(new Date(),createTime))+"前");
        }
        mmap.put("list",list);
        return prefix + "/work::refresh1";
    }

    /**
     * 工作概览  定时刷新消息通知模块
     * @param mmap
     * @return
     */
    @GetMapping("/refresh2")
    public String refresh2(ModelMap mmap){
        try{
            List<HkEventInfo> endList=hkEventService.queryEventOrderEnd();
            for (HkEventInfo event : endList){
                Integer eventAlertStatus = event.getEventAlertStatus();
                if(eventAlertStatus == 6){
                    Date createTime = event.getUpdateTime();
                    event.setDateNow(DateUtils.subStrDateStringRetainOne(DateUtil.formatBetween(new Date(),createTime))+"前");
                }else if(eventAlertStatus == 9){
                    Date createTime = event.getCreateTime();
                    event.setDateNow(DateUtils.subStrDateStringRetainOne(DateUtil.formatBetween(new Date(),createTime))+"前");
                }
            }
            mmap.put("endList",endList);
        }catch(Exception ex){
            logger.info("定时刷新错误信息："+ex.getMessage());
            ex.printStackTrace();
        }
        return prefix + "/work::refresh2";
    }
}
