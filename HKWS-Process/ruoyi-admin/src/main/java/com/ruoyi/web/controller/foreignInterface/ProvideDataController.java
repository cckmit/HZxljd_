package com.ruoyi.web.controller.foreignInterface;


import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicResponseParameters;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.EventTypeStatus;
import com.ruoyi.common.utils.*;
import com.ruoyi.common.utils.map.GPSUtils;
import com.ruoyi.quartz.domain.SysJobLog;
import com.ruoyi.quartz.service.ISysJobLogService;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Action.HkActionProcess;
import com.ruoyi.system.domain.Daping.PercentResult;
import com.ruoyi.system.domain.Daping.PopulaStatiInfo;
import com.ruoyi.system.domain.Daping.ShowEventVo;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.domain.HkEarlyWarning.SysRanksVo;
import com.ruoyi.system.domain.HkEarlyWarning.SysUserVo;
import com.ruoyi.system.domain.HkEntity.EventBackVo;
import com.ruoyi.system.domain.HkEntity.EventReportVo;
import com.ruoyi.system.domain.HkEntity.PointDTO;
import com.ruoyi.system.domain.app.AppActionInfo;
import com.ruoyi.system.domain.app.appField;
import com.ruoyi.system.domain.platform.gpsWeigh.XlGpsWeigh;
import com.ruoyi.system.domain.property.XlPropertyAndVillageVo;
import com.ruoyi.system.domain.vo.CameraIndexCodeVo;
import com.ruoyi.system.domain.vo.EventListCountVo;
import com.ruoyi.system.service.*;
import com.ruoyi.system.service.HkEarlyWarning.HkEventRecordService;
import com.ruoyi.system.service.HkEarlyWarning.HkEventService;
import com.ruoyi.system.service.app.AppEventDetailService;
import com.ruoyi.system.service.app.AppMyWorkService;
import com.ruoyi.system.service.garbageCar.LocationReqService;
import com.ruoyi.system.service.property.XlPropertyAndVillageVoService;
import com.ruoyi.system.service.statistics.HkEventStatisticsService;
import com.ruoyi.web.controller.common.utils.TimeField;
import com.ruoyi.web.controller.common.utils.TimeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/hkapi")
@Api(tags = "大屏接口")
public class ProvideDataController extends BaseController {

    @Autowired
    private ISysRanksService ranksService;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private HkEventService eventService;

    @Autowired
    private HkEventStatisticsService statisticsService;

    @Autowired
    private ISysJobLogService jobLogService;

    @Autowired
    private IHkMapService hkMapService;

    @Autowired
    private MirgantPopulationService populationService;

    @Autowired
    private IHkRentHouseInfoService houseInfoService;

    @Autowired
    private ISysConfigService configService;
    //区域
    @Autowired
    private ISysRegionService iSysRegionService;
    //人口
    @Autowired
    private IXlPersonnelService iXlPersonnelService;
    //房屋
    @Autowired
    private IXlRoomService iXlRoomService;
    //企业
    @Autowired
    private IXlEnterpriseInfoService iXlEnterpriseInfoService;
    @Autowired
    private IXlEquipmentInfoService iXlEquipmentInfoService;
    //物业
    @Autowired
    private IXlEstateManagementService estateManagementService;
    //小区
    @Autowired
    private IXlVillageService villageService;
    //物业事件
    @Autowired
    private XlPropertyAndVillageVoService propertyEventService;
    //出租房
    @Autowired
    private IXlLeaseService xlLeaseService;
    //垃圾车
    @Autowired
    private LocationReqService locationReqService;
    @Autowired
    private HkEventRecordService hkEventRecordService;
    @Autowired
    private AppMyWorkService appMyWorkService;
    @Autowired
    private AppEventDetailService appEventDetailService;

    @Value("${token.plat.zhzl}")
    private String zhzlToken;

    @Value("${token.plat.cgsj}")
    private String cgsjToken;

    @Value("${token.plat.yjxf}")
    private String yjxfToken;

    @Value("${token.plat.qsy}")
    private String qsyToken;

    @Value("${img.file-url}")
    private String fileUrl;

    @Value("${img.event-img-path}")
    private String imgPath;

    @Value("${replace.target-url.part4}")
    private String targetUrl;

    /**机动车编号**/
    @Value("${platform.cg.eventType.motorVehicle}")
    private String motorVehicleCode;

    /**
     * 队伍查询
     * @param vo
     * @return
     */
    @GetMapping("/hkdata/queryRanks")
    @ResponseBody
    public AjaxResult queryRanks(SysRanksVo vo){
        /*String[] arr = new String[]{zhzlToken,cgsjToken,yjxfToken,qsyToken};
        Map<String, Object> map = new CheckApiUtil().checkApi(arr);
        if(!(Boolean)map.get("success")){
            return AjaxResult.error((String)map.get("msg"));
        }*/
        if(vo.getPageNum() == null || vo.getPageNum() == 0){
            vo.setPageNum(1);
        }
        if(vo.getPageSize() == null || vo.getPageSize() > 10){
            vo.setPageSize(10);
        }
        return AjaxResult.success(ranksService.queryRanks(vo));
    }

    /**
     * 用户查询
     * @param vo
     * @return
     */
    @GetMapping("/hkdata/queryUser")
    @ResponseBody
    public AjaxResult queryUser(SysUserVo vo){
        /*String[] arr = new String[]{zhzlToken,cgsjToken,yjxfToken,qsyToken};
        Map<String, Object> map = new CheckApiUtil().checkApi(arr);
        if(!(Boolean)map.get("success")){
            return AjaxResult.error((String)map.get("msg"));
        }*/
        if(vo.getPageNum() == null || vo.getPageNum() == 0){
            vo.setPageNum(1);
        }
        if(vo.getPageSize() == null){
            vo.setPageSize(10);
        }
        return AjaxResult.success(userService.queryUser(vo));
    }

    /**
     * 事件上报
     * @param vo
     * @return
     */
    @PostMapping("/appEventInfo/addReportEvent")
    @ResponseBody
    public AjaxResult reportEvent(@RequestBody EventReportVo vo){
        String[] arr = new String[]{zhzlToken,cgsjToken,yjxfToken,qsyToken};
        Map<String, Object> map = new CheckApiUtil().checkApi(arr);
        if(!(Boolean)map.get("success")){
            return AjaxResult.error((String)map.get("msg"));
        }
        HkEventInfo event = vo.getEvent();
        PointDTO point = vo.getPoint();
        logger.info("--------------------上报事件详细参数-----------------------");
        logger.info(JSONObject.toJSONString(vo));
        SysJobLog joblog = new SysJobLog();
        joblog.setInvokeTarget("数据异常");
        joblog.setJobMessage("事件内容:"+ JSONObject.toJSONString(vo));
        joblog.setJobName("获取"+map.get("platName")+"事件");
        joblog.setJobGroup("事件上报");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(event == null){
            joblog.setStatus("1");
            joblog.setExceptionInfo("错误日志：事件信息为空");
            jobLogService.addJobLog(joblog);
            return AjaxResult.error("事件信息不能为空");
        }
        event.setEventId(UUID.randomUUID().toString().replaceAll("-",""));
        if(StringUtils.isEmpty(event.getEventTitle())){
            joblog.setStatus("1");
            joblog.setExceptionInfo("错误日志：事件标题为空");
            jobLogService.addJobLog(joblog);
            return AjaxResult.error("事件标题不能为空");
        }
        if(StringUtils.isEmpty(event.getEventAddress())){
            joblog.setStatus("1");
            joblog.setExceptionInfo("错误日志：事件地址为空");
            jobLogService.addJobLog(joblog);
            return AjaxResult.error("事件地址不能为空");
        }
        if(StringUtils.isEmpty(event.getReportTime())){
            joblog.setStatus("1");
            joblog.setExceptionInfo("错误日志：事件上报时间为空");
            jobLogService.addJobLog(joblog);
            return AjaxResult.error("事件上报时间不能为空");
        }
        Date eventCreateTime = DateUtils.parseDate(event.getReportTime());
        event.setEventCreateTime(dateFormat.format(eventCreateTime));
        String componentId = map.get("platCode")+"";
        event.setComponentId(componentId);
        //1001城管事件 1002应急消防 1003综合治理 1004青山云
        /*****************综治图片文件访问ip暂替换为风控外网域名 供浙政钉使用*********************/
        if("1003".equals(componentId) && !StringUtils.isEmpty(event.getEventImage())){
            event.setEventImage(UrlReplaceUtil.replaceFileUrl(event.getEventImage()));
            if(event.getExtendInt3() == null){
                event.setExtendInt3(3);//大屏显示弹窗配置项
            }
        }else if("1001".equals(componentId) && !StringUtils.isEmpty(event.getEventImage())){
            /*String filePath = new UploadUrlUtil().getFilePath(event.getExtendInt1()+"",event.getEventImage(),imgPath,targetUrl);
            event.setEventImage(filePath);*/
            event.setEventImage(UrlReplaceUtil.replaceFileUrl(event.getEventImage()));
            if(event.getExtendInt3() == null){
                event.setExtendInt3(1);//大屏显示弹窗配置项
            }
        }else if("1002".equals(componentId) && !StringUtils.isEmpty(event.getEventImage())) {
            event.setEventImage(UrlReplaceUtil.replaceFileUrl(event.getEventImage()));
            if(event.getExtendInt3() == null){
                event.setExtendInt3(2);//大屏显示弹窗配置项
            }
        }else if("1004".equals(componentId)){
            if(event.getExtendInt3() == null){
                event.setExtendInt3(4);//大屏显示弹窗配置项
            }
            //将腾讯地图坐标系转换为百度坐标系
            if(point != null && !StringUtils.isEmpty(point.getLongitude()) && !StringUtils.isEmpty(point.getLatitude())){
                double[] doubles = GPSUtils.gcj02_To_Bd09(Double.valueOf(point.getLongitude()), Double.valueOf(point.getLatitude()));
                point.setLongitude(doubles[0]+"");
                point.setLatitude(doubles[1]+"");
            }
        }

        if(event.getReportType() == null){
            return AjaxResult.error("事件上报类型不能为空");
        }
        if(StringUtils.isEmpty(event.getReportTypeName())){
            return AjaxResult.error("事件上报类型名称不能为空");
        }
        if("智能上报".equals(event.getReportTypeName())){
            event.setReportType(1);
            if(StringUtils.isEmpty(event.getCameraIndexCode())){
                return AjaxResult.error("设备ID不能为空");
            }
            if(StringUtils.isEmpty(event.getCameraName())){
                return AjaxResult.error("设备地址不能为空");
            }
        }else{
            event.setReportType(2);
        }
        if(StringUtils.isNull(event.getRiskLevel())){
            return AjaxResult.error("事件风险等级不能为空");
        }

        if(event.getEventStatus()==null || event.getEventStatus() == 1){
            event.setEventStatus(5);
            event.setEventAlertStatus(2);
            event.setEventAlertStatusName("研判中");
        }
        else if(event.getEventStatus() == 3){
            event.setEventAlertStatus(6);
            event.setEventAlertStatusName("完结");
            //完结时直接更新update_time
        }
        if(StringUtils.isEmpty(event.getEventIndexCode())){
            return AjaxResult.error("事件唯一标识不能为空");
        }
        if("1001".equals(componentId) && motorVehicleCode.equals(event.getEventType())){
            if(StringUtils.isEmpty(event.getPlateNo())){
                joblog.setStatus("1");
                joblog.setExceptionInfo("错误日志：机动车牌号为空");
                jobLogService.addJobLog(joblog);
                return AjaxResult.error("机动车牌号不能为空");
            }
        }
        String regionCode = "100";
        String regionName = "青山湖街道";
        if(point != null){
            if(!StringUtils.isEmpty(point.getLongitude())){
                event.setLongitude(point.getLongitude());
            }
            if(!StringUtils.isEmpty(point.getLatitude())){
                event.setLatitude(point.getLatitude());
            }
            if(!StringUtils.isEmpty(point.getLongitude()) && !StringUtils.isEmpty(point.getLatitude())){
                Double[] points = {Double.valueOf(point.getLongitude()),Double.valueOf(point.getLatitude())};
                Map<String, Object> map1 = hkMapService.calculateRegionByLongitudeAndLatitude(points);
                regionCode = map1.get("regionId")+"";
                regionName = map1.get("regionName")+"";
            }
        }
        event.setRegionIndexCode(regionCode);
        event.setRegionName(regionName);
        event.setCreateTime(new Date());
        try{
            int count = eventService.reportEvent(event);
            if(count != 1){
                joblog.setInvokeTarget("数据导入失败");
                joblog.setStatus("1");
                joblog.setExceptionInfo("错误日志：数据保存失败");
                jobLogService.addJobLog(joblog);
                logger.info("--------------------事件上报失败-----------------------");
                return AjaxResult.error("上报失败");
            }
        }catch(Exception ex){
            joblog.setStatus("1");
            joblog.setExceptionInfo("错误日志："+ex.getMessage());
            jobLogService.addJobLog(joblog);
            ex.printStackTrace();
            return AjaxResult.error("上报失败");
        }
        return AjaxResult.success("上报成功");
    }

    /**
     * 事件反馈
     * @param vo
     * @return
     */
    @GetMapping("/appEventInfo/eventResult")
    @ResponseBody
    public AjaxResult eventResult(EventBackVo vo) {
        /**
         * {
         *      detail:{
         *          eventIndexCode:"",
         *          record:[
         *              processUserId:"1",
         *              processTime:"2021-05-14 00:00:01",
         *              processStatus:"状态（1重新指派 2 指派，3签收，4已处置 5退回,6中心处置，7忽略，8异常报送）"
         *              processResult:"已处置"，
         *              processOpinion:""
         *          ]
         *      },
         * }
         */
        String[] arr = new String[]{zhzlToken, cgsjToken, yjxfToken, qsyToken};
        Map<String, Object> map = new CheckApiUtil().checkApi(arr);
        if (!(Boolean) map.get("success")) {
            return AjaxResult.error((String) map.get("msg"));
        }
        if(vo.getPageNum() == null || vo.getPageNum() == 0){
            vo.setPageNum(1);
        }
        if(vo.getPageSize() == null){
            vo.setPageSize(10);
        }
        if(vo.getPageSize() > 50){
            vo.setPageSize(50);
        }
        vo.setComponentId((String)map.get("platCode"));
        PageInfo<EventBackVo> pageInfo = eventService.queryEventResult(vo);
        return AjaxResult.success(pageInfo);
    }




    private Double divideValue(BigDecimal value,BigDecimal toValue){
        Double divideValue = 0.0;
        if(toValue.compareTo(BigDecimal.ZERO) < 1){
            return  100.00;
        }
        divideValue = value.divide(toValue,2,BigDecimal.ROUND_UP).doubleValue();//百分比
        return divideValue;
    }

    /**
     * 青和力-治理事件数/同环/同比
     * @return
     */
    @GetMapping("index/eventCountAndRate")
    @ResponseBody
    public AjaxResult eventTypeRate(){
        String componentId = "";//事件类别

        /**
         * 1001-城管系统 1002-应急消防系统 1003-综治平台 1004-青山云系统
         */
        Map<String,Object> params1 = new HashMap<>();
        params1.put("componentId","1001");
        PercentResult plat_1001 = statisticsService.eventCountAndRate(params1);//青和力-事件数/同环/同比数
        Map<String,Object> params2 = new HashMap<>();
        params2.put("componentId","1002");
        PercentResult plat_1002 = statisticsService.eventCountAndRate(params2);//青和力-事件数/同环/同比数
        Map<String,Object> params3 = new HashMap<>();
        params3.put("componentId","1003");
        PercentResult plat_1003 = statisticsService.eventCountAndRate(params3);//青和力-事件数/同环/同比数
        Map<String,Object> params4 = new HashMap<>();
        params4.put("componentId","1004");
        PercentResult plat_1004 = statisticsService.eventCountAndRate(params4);//青和力-事件数/同环/同比数

        List<PercentResult> result= new ArrayList<>();
        result.add(plat_1001);
        result.add(plat_1002);
        result.add(plat_1003);
        result.add(plat_1004);
        return  AjaxResult.success(result);
    }

    /***
     *  大屏数据对接
     * 获取最新事件 top5
     */
    @GetMapping("index/getNewEvent")
    @ResponseBody
    public AjaxResult getNewEvent(@RequestParam(value = "Component_Code",required = false) String componentId) {
        Map<String,Object> result = new HashMap<>();
        //获取最新一条事件数据
        Map<String,Object> eventParams = DateUtils.eventDate("day");
        eventParams.put("componentId",componentId);//平台事件接入码
        eventParams.put("statusArr",new String[]{"2"});//事件状态
        List<ShowEventVo> list1 = statisticsService.getNewEvent(eventParams);//待处理事件
        result.put("noProcess",list1);
        eventParams.put("statusArr",new String[]{"6","7","9"});//事件状态
        List<ShowEventVo> list2 = statisticsService.getNewEvent(eventParams);//已处理事件
        result.put("process",list2);
        return AjaxResult.success(result);
    }


    /***
     * 大屏接口
     * 首页--全域赋能
     *
     */
    @GetMapping("index/energizeAll")
    @ResponseBody
    public AjaxResult energizeAll(@RequestParam(value = "today",required = false) String today) {
        //查询各平台数据总数
        Map<String,Object> result = new HashMap<>();
        List<PercentResult> part_2 = new ArrayList<>();
        //平台事件告警总数
        Map<String,Object> params1 = new HashMap<>();
        params1.put("componentId","1001");
        if("1".equals(today)){
            params1.put("currentDate",DateUtils.getDate());
        }
        PercentResult plat_1001 = statisticsService.eventCountAndRate(params1);//青和力-事件数/同环/同比数
        Map<String,Object> params2 = new HashMap<>();
        params2.put("componentId","1002");
        if("1".equals(today)){
            params2.put("currentDate",DateUtils.getDate());
        }
        PercentResult plat_1002 = statisticsService.eventCountAndRate(params2);//青和力-事件数/同环/同比数
        Map<String,Object> params3 = new HashMap<>();
        params3.put("componentId","1003");
        if("1".equals(today)){
            params3.put("currentDate",DateUtils.getDate());
        }
        PercentResult plat_1003 = statisticsService.eventCountAndRate(params3);//青和力-事件数/同环/同比数
        Map<String,Object> params4 = new HashMap<>();
        params4.put("componentId","1004");
        if("1".equals(today)){
            params4.put("currentDate",DateUtils.getDate());
        }
        PercentResult plat_1004 = statisticsService.eventCountAndRate(params4);//青和力-事件数/同环/同比数
        List<PercentResult> part_1= new ArrayList<>();
        part_1.add(plat_1001);
        part_1.add(plat_1002);
        part_1.add(plat_1003);
        part_1.add(plat_1004);
        List<PercentResult> list = statisticsService.queryCountByEventType(DateUtils.eventDate("day"));
        Long other = 0L;
        Long another = 0L;
        list.sort(Comparator.comparing(PercentResult::getValue).reversed());
        for(int i=0;i<list.size();i++){
            if(list.size() > 4 && i > 4){
                //将五条后的数据合并为其他
                Long value = list.get(i).getValue();
                other += value;
            }else{
                Long value = list.get(i).getValue();
                another += value;
                part_2.add(list.get(i));
            }
        }
        PercentResult param = new PercentResult();
        param.setName("other");
        param.setValue(other);
        part_2.add(param);
        for(PercentResult dto : part_2){
            Long count = other+another;
            Double percent = rate(new BigDecimal(dto.getValue()), new BigDecimal(count));
            dto.setPercent(percent);
        }
        result.put("part_1",part_1);
        result.put("part_2",part_2);
        return AjaxResult.success(result);
    }


    /***
     * 大屏接口
     * 首页--全域流转
     *
     */
    @GetMapping("index/transferAll")
    @ResponseBody
    public AjaxResult transferAll(@RequestParam(value = "Component_Code",required = false) String componentId) {
        Map<String,Object> eventParams = DateUtils.eventDate("day");
        eventParams.put("componentId",componentId);
        return AjaxResult.success(statisticsService.queryCountByAlertStatus(eventParams));
    }

    /***
     * 大屏接口
     * 首页--全域智治
     *
     */
    @GetMapping("index/governAll")
    @ResponseBody
    public AjaxResult governAll() {
        Map<String,Object> result = new HashMap<>();
        String twentyFour= DateFormatUtils.format(DateUtils.getTwentyFour(),"yyyy-MM-dd HH:mm:ss");//过去24小时对应时间
        String createTime = DateFormatUtils.format(new Date(),"yyyy-MM-dd");//当天时间
        try{
            Map<String,Object> params = new HashMap<>();
            params.put("statusArr",new String[]{"6","7","8","9"});//已完成事件
            List<Integer> intList = new ArrayList<>();
            for(long i = 1L;i <= 24L; i++) {
                params.put("hourBegin",twentyFour);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//起始时间
                long time = sdf.parse(twentyFour).getTime()+3600000L;
                String nextTime= DateFormatUtils.format(new Date(time),"yyyy-MM-dd HH:mm:ss");//起始时间的一小时后
                params.put("hourEnd",nextTime);
                Integer doneCount = statisticsService.countAllByParams(params);
                twentyFour = nextTime;
                intList.add(doneCount);
            }

            Map<String,Object> curretParams = new HashMap<>();
            curretParams.put("currentDate",createTime);//当天
            curretParams.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
            int currentCount = statisticsService.countAllByParams(curretParams);//当天事件总数
            Map<String,Object> doneParams = new HashMap<>();
            doneParams.put("currentDate",createTime);//当天
            doneParams.put("statusArr",new String[]{"6","7","8","9"});//已完成事件
            Integer doneCount = statisticsService.countAllByParams(doneParams);//今日已完成事件数
            Double doneRate = rate(new BigDecimal(doneCount),new BigDecimal(currentCount));//今日事件完成率
            Map<String,Object> param1 = new HashMap<>();
            param1.put("currentDate",createTime);//当天
            param1.put("statusArr",new String[]{"6","7","9"});
            param1.put("notEventStatus",3);
            int machineDis = statisticsService.countAllByParams(param1);
            result.put(EventTypeStatus.EVENT_DONE_WAY01.desc(),rate(new BigDecimal(machineDis+""),new BigDecimal(doneCount+"")));//基层处置
            Map<String,Object> param2 = new HashMap<>();
            param2.put("currentDate",createTime);//当天
            param2.put("eventAlterStatus",8);
            int errorDis = statisticsService.countAllByParams(param2);
            result.put(EventTypeStatus.EVENT_DONE_WAY02.desc(),rate(new BigDecimal(errorDis+""),new BigDecimal(doneCount+"")));//异常关闭
            Map<String,Object> param3 = new HashMap<>();
            param3.put("currentDate",createTime);//当天
            param3.put("eventStatus",3);
            int centerDis = statisticsService.countAllByParams(param3);//中心处置
            result.put(EventTypeStatus.EVENT_DONE_WAY03.desc(),rate(new BigDecimal(centerDis+""),new BigDecimal(doneCount+"")));//中心处置
            /*Map<String,Object> param4 = new HashMap<>();
            param4.put("eventAlterStatus",6);
            param4.put("notEventStatus",3);
            int lawDis = statisticsService.countAllByParams(param4);//执法处置*/
            int lawDis = 0;
            result.put(EventTypeStatus.EVENT_DONE_WAY04.desc(),rate(new BigDecimal(lawDis+""),new BigDecimal(doneCount+"")));//执法处置
            result.put("doneRate",doneRate);
            result.put("activeCount",intList);
        }catch(Exception ex){
            logger.info(ex.getMessage());
            ex.printStackTrace();
        }
        return AjaxResult.success(result);
    }


    /***
     *  大屏数据对接
     * 智慧城管-城市眼-近24小事告警事件发生数
     */
    @GetMapping("index/cityEye")
    @ResponseBody
    public AjaxResult getCityEye(@RequestParam(value = "Component_Code",required = false) String componentId) {
        String twentyFour= DateFormatUtils.format(DateUtils.getTwentyFour(),"yyyy-MM-dd HH:mm:ss");//过去24小时对应时间
        String createTime = DateFormatUtils.format(new Date(),"yyyy-MM-dd");//当天时间
        Map<String,Object> response = new HashMap<>();
        try{
            Map<String,Object> twentyFourParams = new HashMap<>();
            twentyFourParams.put("lastDay",twentyFour);//过去24小时时间
            twentyFourParams.put("componentId",componentId);//事件发生区域
            twentyFourParams.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
            List<HkEventInfo> list = statisticsService.getEventByParams(twentyFourParams);//过去24小时事件总数
            List<TimeField> timeUtils = new TimeUtil().getTime("24hours");
            List<Integer> twentyFourCounts = DataFormat(list,null, timeUtils);//事件数

            Map<String,Object> countParams = new HashMap<>();
            countParams.put("componentId",componentId);
            countParams.put("currentDate",createTime);//当前日
            countParams.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
            Integer count = statisticsService.countAllByParams(countParams);//今日事件数

            Map<String,Object> exceptionParams = new HashMap<>();
            exceptionParams.put("eventAlterStatus","8");//异常报送
            exceptionParams.put("currentDate",createTime);//当前日
            Integer exceptionCount = statisticsService.countAllByParams(exceptionParams);

            Map<String,Object> transferParams = new HashMap<>();
            transferParams.put("statusArr",new String[]{"3","4","5","6","7","8","9"});//流转数
            transferParams.put("currentDate",createTime);//当前日
            Integer changeCount = statisticsService.countAllByParams(transferParams);

            Double changeRate = rate(new BigDecimal(changeCount),new BigDecimal(count));//今日流转率

            Map<String,Object> signParams = new HashMap<>();
            signParams.put("currentDate",createTime);//当前日
            signParams.put("eventAlterStatus","5");//签收状态
            Integer signCount = statisticsService.countAllByParams(signParams);//今日签收数
            //Double signRate = rate(new BigDecimal(signCount),new BigDecimal(count));//今日签收率

            Map<String,Object> closeParams = new HashMap<>();
            closeParams.put("statusArr",new String[]{"6","7","9"});//事件关闭
            closeParams.put("currentDate",createTime);//当前日
            Integer closeCount = statisticsService.countAllByParams(closeParams);
            response.put("twentyFourCounts",twentyFourCounts);       //近24小时告警事件发生数
            response.put("changeRate",changeRate);  //事件流转率
            response.put("signCount",signCount);    //事件签收数
            response.put("closeCount",closeCount);  //事件关闭数
            response.put("exceptionCount",exceptionCount);//事件异常报送数量
        }catch(Exception ex){
            logger.info(ex.getMessage());
            ex.printStackTrace();
        }
        return AjaxResult.success(response);
    }


    /***
     *  大屏数据对接
     * 资源上图-网格员、执法力量分布情况
     *
     */
    @GetMapping("index/DistributionOfMember")
    @ResponseBody
    public AjaxResult getDistributionOfMember() {
        //获取网格员，执法力量分布情况

        Map<String,Object> param = new HashMap<>();
        statisticsService.getDistributionOfMember(param);
        List<PercentResult> distributionOfMemberVOS = deptService.getUserByDeptLevel();
        return AjaxResult.success(distributionOfMemberVOS);
    }


    /**
     * 民声直达
     *
     */
    @GetMapping("index/voxPopuliNonstop")
    @ResponseBody
    public AjaxResult voxPopuliNonstop(@RequestParam("Component_Code") String componentId) {
        Map<String, Object> param = DateUtils.eventDate("day");//当天时间
        param.put("componentId",componentId);
        param.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
        return AjaxResult.success(statisticsService.getMapByEventType(param));
    }



    /**
     * 民事直面
     *
     */
    @GetMapping("index/thingPopuliNonstop")
    @ResponseBody
    public AjaxResult thingPopuliNonstop(@RequestParam("Component_Code") String componentId) {
        Map<String, Object> param = new HashMap<>();
        param.put("componentId",componentId);
        param.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
       return AjaxResult.success(statisticsService.getMouthEventCount(param));
    }


    /**
     * 民意直通
     */
    @GetMapping("index/popularWillNonstop")
    @ResponseBody
    public AjaxResult popularWillNonstop(@RequestParam("Component_Code") String componentId) {
        Map<String, Object> param = DateUtils.eventDate("day");//当天时间
        param.put("componentId",componentId);
       return AjaxResult.success(statisticsService.getEventDoneInfo(param));
    }



    /**
     * 各事件类型事件数量统计
     * @param componentId
     *
     *
     * 取数量最多的七条和其他
     * @return
     */
    @GetMapping("index/eventTypeCountByCG")
    @ResponseBody
    public AjaxResult getEventTypeCountByCG(@RequestParam("Component_Code") String componentId) {
        String createTime = DateFormatUtils.format(new Date(),"yyyy-MM-dd");//当天时间
        String[] strArr = EventTypeStatus.EVENT_PLAT_1001_CODE.desc().split(",");
        Map<String,Object> result = new HashMap<>();
        List<PercentResult> list = new ArrayList<>();
        for(String str : strArr){
            PercentResult dto = new PercentResult();
            String[] statusArr = {"1","2","3","4","5","6","7","8","9"};
            int count = statisticsService.todayEventTypeCount(componentId,str,null,createTime,statusArr);
            dto.setValue((long)count);
            dto.setName(str);
            list.add(dto);
        }
        list.sort(Comparator.comparing(PercentResult::getValue).reversed());
        Long other = 0L;
        for(int i=0;i<list.size();i++) {
            if (i > 6) {
                //将五条后的数据合并为其他
                Long value = list.get(i).getValue();
                other += value;
            } else {
                Long value = list.get(i).getValue();
                String name = list.get(i).getName();
                if(name.equals(EventTypeStatus.EVENT_PLAT_1001_CODE001.code())){
                    result.put(EventTypeStatus.EVENT_PLAT_1001_CODE001.desc(),value);
                }else if(name.equals(EventTypeStatus.EVENT_PLAT_1001_CODE002.code())){
                    result.put(EventTypeStatus.EVENT_PLAT_1001_CODE002.desc(),value);
                }else if(name.equals(EventTypeStatus.EVENT_PLAT_1001_CODE003.code())){
                    result.put(EventTypeStatus.EVENT_PLAT_1001_CODE003.desc(),value);
                }else if(name.equals(EventTypeStatus.EVENT_PLAT_1001_CODE004.code())){
                    result.put(EventTypeStatus.EVENT_PLAT_1001_CODE004.desc(),value);
                }else if(name.equals(EventTypeStatus.EVENT_PLAT_1001_CODE005.code())){
                    result.put(EventTypeStatus.EVENT_PLAT_1001_CODE005.desc(),value);
                }else if(name.equals(EventTypeStatus.EVENT_PLAT_1001_CODE006.code())){
                    result.put(EventTypeStatus.EVENT_PLAT_1001_CODE006.desc(),value);
                }else if(name.equals(EventTypeStatus.EVENT_PLAT_1001_CODE007.code())){
                    result.put(EventTypeStatus.EVENT_PLAT_1001_CODE007.desc(),value);
                }else if(name.equals(EventTypeStatus.EVENT_PLAT_1001_CODE008.code())){
                    result.put(EventTypeStatus.EVENT_PLAT_1001_CODE008.desc(),value);
                }else if(name.equals(EventTypeStatus.EVENT_PLAT_1001_CODE009.code())){
                    result.put(EventTypeStatus.EVENT_PLAT_1001_CODE009.desc(),value);
                }else if(name.equals(EventTypeStatus.EVENT_PLAT_1001_CODE010.code())){
                    result.put(EventTypeStatus.EVENT_PLAT_1001_CODE010.desc(),value);
                }else if(name.equals(EventTypeStatus.EVENT_PLAT_1001_CODE011.code())){
                    result.put(EventTypeStatus.EVENT_PLAT_1001_CODE011.desc(),value);
                }
            }
        }
        PercentResult percentResult = new PercentResult();
        percentResult.setName("other");
        percentResult.setValue(other);
        result.put("other",other);
        return AjaxResult.success(result);
    }


    /**
     * 各事件类型事件的处置数和处置率
     * @param componentId
     * @return
     */
    @GetMapping("index/eventTypeRateByCG")
    @ResponseBody
    public AjaxResult eventTypeRateByCG(@RequestParam("Component_Code") String componentId) {
        String createTime = DateFormatUtils.format(new Date(),"yyyy-MM-dd");//当天时间
        String[]arr = {"6","7","8","9"};//5:处置 6:完结 7:已忽略 8已关闭 9:系统自动完成
        String[]allArr = {"1","2","3","4","5","6","7","8","9"};
        String[] strArr = EventTypeStatus.EVENT_PLAT_1001_CODE.desc().split(",");
        List<PercentResult> result = new ArrayList<>();
        List<PercentResult> list = new ArrayList<>();
        for(String str : strArr){
            PercentResult dto = new PercentResult();
            int count = statisticsService.todayEventTypeCount(componentId,str,null,createTime,allArr);
            int doneCount = statisticsService.todayEventTypeCount(componentId,str,null,createTime,arr);
            Double doneRate = rate(new BigDecimal(doneCount), new BigDecimal(count));
            dto.setValue((long)count);
            dto.setCode(str);
            if(str.equals(EventTypeStatus.EVENT_PLAT_1001_CODE001.code())){
                dto.setName(EventTypeStatus.EVENT_PLAT_1001_CODE001.desc());
            }else if(str.equals(EventTypeStatus.EVENT_PLAT_1001_CODE002.code())){
                dto.setName(EventTypeStatus.EVENT_PLAT_1001_CODE002.desc());
            }else if(str.equals(EventTypeStatus.EVENT_PLAT_1001_CODE003.code())){
                dto.setName(EventTypeStatus.EVENT_PLAT_1001_CODE003.desc());
            }else if(str.equals(EventTypeStatus.EVENT_PLAT_1001_CODE004.code())){
                dto.setName(EventTypeStatus.EVENT_PLAT_1001_CODE004.desc());
            }else if(str.equals(EventTypeStatus.EVENT_PLAT_1001_CODE005.code())){
                dto.setName(EventTypeStatus.EVENT_PLAT_1001_CODE005.desc());
            }else if(str.equals(EventTypeStatus.EVENT_PLAT_1001_CODE006.code())){
                dto.setName(EventTypeStatus.EVENT_PLAT_1001_CODE006.desc());
            }else if(str.equals(EventTypeStatus.EVENT_PLAT_1001_CODE007.code())){
                dto.setName(EventTypeStatus.EVENT_PLAT_1001_CODE007.desc());
            }else if(str.equals(EventTypeStatus.EVENT_PLAT_1001_CODE008.code())){
                dto.setName(EventTypeStatus.EVENT_PLAT_1001_CODE008.desc());
            }else if(str.equals(EventTypeStatus.EVENT_PLAT_1001_CODE009.code())){
                dto.setName(EventTypeStatus.EVENT_PLAT_1001_CODE009.desc());
            }else if(str.equals(EventTypeStatus.EVENT_PLAT_1001_CODE010.code())){
                dto.setName(EventTypeStatus.EVENT_PLAT_1001_CODE010.desc());
            }else if(str.equals(EventTypeStatus.EVENT_PLAT_1001_CODE011.code())){
                dto.setName(EventTypeStatus.EVENT_PLAT_1001_CODE011.desc());
            }
            dto.setPercent(doneRate);
            list.add(dto);
        }
        list.sort(Comparator.comparing(PercentResult::getValue).reversed());
        for(int i=0;i<list.size();i++) {
            if(i < 7){
                result.add(list.get(i));
            }
        }
        return AjaxResult.success(result);
    }


    /**
     * 云共治-事件处理数-事件完成率
     *
     *
     * 查询事件类型前7条
     * @param componentId
     * @return
     */
    @GetMapping("index/eventTypeStatistics")
    @ResponseBody
    public AjaxResult getEventTypeStatistics(@RequestParam("Component_Code") String componentId) {
        String createTime = DateFormatUtils.format(new Date(),"yyyy-MM-dd");//当天时间
        Map<String,Object> result = new HashMap<>();
        try{
            Map<String,Object> curretParams = new HashMap<>();
            curretParams.put("currentDate",createTime);//当天
            curretParams.put("componentId",componentId);//事件发生区域
            curretParams.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});//所有事件数
            int currentCount = statisticsService.countAllByParams(curretParams);//当天事件总数
            Map<String,Object> doneParams = new HashMap<>();
            doneParams.put("currentDate",createTime);//当天
            doneParams.put("componentId",componentId);//事件发生区域
            doneParams.put("statusArr",new String[]{"6","7","8","9"});//已完成事件
            Integer doneCount = statisticsService.countAllByParams(doneParams);//今日已完成事件数
            Double doneRate = rate(new BigDecimal(doneCount),new BigDecimal(currentCount));//今日事件完成率
            Map<String,Object> param1 = new HashMap<>();
            param1.put("currentDate",createTime);//当天
            param1.put("componentId",componentId);//事件发生区域
            param1.put("statusArr",new String[]{"6","7","9"});
            param1.put("notEventStatus",3);
            int machineDis = statisticsService.countAllByParams(param1);
            result.put(EventTypeStatus.EVENT_DONE_WAY01.desc(),rate(new BigDecimal(machineDis+""),new BigDecimal(doneCount+"")));//基层处置
            Map<String,Object> param2 = new HashMap<>();
            param2.put("currentDate",createTime);//当天
            param2.put("componentId",componentId);//事件发生区域
            param2.put("eventAlterStatus",8);
            int errorDis = statisticsService.countAllByParams(param2);
            result.put(EventTypeStatus.EVENT_DONE_WAY02.desc(),rate(new BigDecimal(errorDis+""),new BigDecimal(doneCount+"")));//异常关闭
            Map<String,Object> param3 = new HashMap<>();
            param3.put("currentDate",createTime);//当天
            param3.put("componentId",componentId);//事件发生区域
            param3.put("eventStatus",3);
            int centerDis = statisticsService.countAllByParams(param3);//中心处置
            result.put(EventTypeStatus.EVENT_DONE_WAY03.desc(),rate(new BigDecimal(centerDis+""),new BigDecimal(doneCount+"")));//中心处置
            /*Map<String,Object> param4 = new HashMap<>();
            param4.put("currentDate",createTime);//当天
            param4.put("componentId",componentId);//事件发生区域
            param4.put("eventAlterStatus",6);
            param4.put("notEventStatus",3);
            int lawDis = statisticsService.countAllByParams(param4);//执法处置*/
            int lawDis = 0;
            result.put(EventTypeStatus.EVENT_DONE_WAY04.desc(),rate(new BigDecimal(lawDis+""),new BigDecimal(doneCount+"")));//执法处置
            result.put("doneRate",doneRate);
        }catch(Exception ex){
            logger.info(ex.getMessage());
            ex.printStackTrace();
        }
        return AjaxResult.success(result);
    }


    /***
     *  大屏数据对接
     * 智慧城管 - 今日告警数/未处理告警数 逾期处理数 处置率
     */
    @GetMapping("index/eventTarget")
    @ResponseBody
    public AjaxResult getEventTarget(@RequestParam("Component_Code") String componentId) {
        Map<String,Object> response = new HashMap<>();
        String eventCreatTime = DateFormatUtils.format(new Date(),"yyyy-MM-dd");//当天日期 yyyy-MM-dd
        String timeOut = DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");//当前时间

        Map<String,Object> eventParams = new HashMap<>();
        eventParams.put("eventCreatTime",eventCreatTime);
        eventParams.put("componentId",componentId);
        eventParams.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
        int eventCounts = statisticsService.queryTodayEventCounts(eventParams);//告警总数

        int unprocessedEventCounts = statisticsService.queryTodayUnprocessedEventCounts(eventParams);//未处理告警数

        Map<String,Object> timeOutParams = new HashMap<>();
        timeOutParams.put("timeOut",timeOut);
        timeOutParams.put("componentId",componentId);
        int eventTimeOutCounts = statisticsService.queryEventTimeOutCounts(timeOutParams);//逾期处理数

        response.put("eventCounts",eventCounts);//告警总数
        response.put("unprocessedEventCounts",unprocessedEventCounts);//未处理告警数
        response.put("eventTimeOutCounts",eventTimeOutCounts);//逾期处理数
        double achieveRate;
        if (eventCounts == 0){
            achieveRate = 0.0;
        }else {
            achieveRate = (100d*(eventCounts - unprocessedEventCounts)/eventCounts);
            achieveRate = Double.parseDouble(String.format("%.2f", achieveRate));
        }
        response.put("eventTimeOutCounts",eventTimeOutCounts);//逾期处理数
        response.put("achieveRate",achieveRate);
        return AjaxResult.success(response);
    }

    /**
     * 综合治理
     *
     * 页面大图显示的事件类型需确认====================================================================
     *
     *
     */
    @GetMapping("index/eventTypeCountByZZ")
    @ResponseBody
    public AjaxResult eventTypeCountByZZ(@RequestParam("Component_Code") String componentId){
        Map<String,Object> response = new HashMap<>();
        String createTime = DateFormatUtils.format(new Date(),"yyyy-MM-dd");//当天时间
        String[] statusArr = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        //今日 五水共治
        int typeCount01 = statisticsService.todayEventTypeCount(componentId,null,"02001",createTime,statusArr);
        //今日 食品安全
        int typeCount02 = statisticsService.todayEventTypeCount(componentId,null,"03003",createTime,statusArr);
        //今日 交通安全
        int typeCount03 = statisticsService.todayEventTypeCount(componentId,null,"02012",createTime,statusArr);
        //今日 物业管理
        int typeCount04 = statisticsService.todayEventTypeCount(componentId,null,"04010",createTime,statusArr);
        //今日 农村卫生
        int typeCount05 = statisticsService.todayEventTypeCount(componentId,null,"04012",createTime,statusArr);
        //今日 矛盾纠纷
        int typeCount06 = statisticsService.todayEventTypeCount(componentId,null,"01002",createTime,statusArr);
        //今日 消防安全
        int typeCount07 = statisticsService.todayEventTypeCount(componentId,null,"01007",createTime,statusArr);
        //今日 市容环境
        int typeCount08 = statisticsService.todayEventTypeCount(componentId,null,"02006",createTime,statusArr);
        //今日 党建宣传
        int typeCount09 = statisticsService.todayEventTypeCount(componentId,null,"04015",createTime,statusArr);
        //今日 城乡建设
        int typeCount10 = statisticsService.todayEventTypeCount(componentId,null,"02004",createTime,statusArr);
        response.put("typeCount01",typeCount01);
        response.put("typeCount02",typeCount02);
        response.put("typeCount03",typeCount03);
        response.put("typeCount04",typeCount04);
        response.put("typeCount05",typeCount05);
        response.put("typeCount06",typeCount06);
        response.put("typeCount07",typeCount07);
        response.put("typeCount08",typeCount08);
        response.put("typeCount09",typeCount09);
        response.put("typeCount10",typeCount10);
        return AjaxResult.success(response);
    }

    /**
     *  (暂无用，接口由综治提供)
     *
     * 综合治理
     *
     * 全域赋能
     */
    @GetMapping("index/energizeAllByZZ")
    @ResponseBody
    public AjaxResult energizeAllByZZ(@RequestParam("Component_Code") String componentId){
        String createTime = DateFormatUtils.format(new Date(),"yyyy-MM-dd");//当天时间
        Map<String,Object> params = new HashMap<>();
        params.put("componentId",componentId);
        params.put("currentDate",createTime);
        params.put("statusArr",new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"});
        return AjaxResult.success(statisticsService.getMapByCameraType(params));
    }



    /**
     * 综合治理
     *
     * 全域智治
     */
    @GetMapping("index/governAllByZZ")
    @ResponseBody
    public AjaxResult governAll(@RequestParam("Component_Code") String componentId) {
        Map<String,Object> result = new HashMap<>();
        try{
            String createTime = DateFormatUtils.format(new Date(),"yyyy-MM-dd");//当天时间
            String weekTime = DateFormatUtils.format(DateUtils.getThisWeekMonday(), DateUtils.YYYY_MM_DD);
            Map<String,Object> params = new HashMap<>();
            params.put("currentDate",createTime);
            params.put("componentId",componentId);
            params.put("statusArr",new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"});
            result = statisticsService.getMapByEventName(params);
            Map<String,Object> weekParams = new HashMap<>();
            weekParams.put("componentId",componentId);
            weekParams.put("trendWeekMonday",weekTime);
            weekParams.put("statusArr",new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"});
            List<HkEventInfo> weeList = statisticsService.getEventByParams(weekParams);//本周事件总数
            List<TimeField> timeUtils = new TimeUtil().getTime("week");
            List<Integer> weekCounts = DataFormat(weeList,"week",timeUtils);//事件数
            result.put("weekCount",weekCounts);
        }catch(Exception ex){
            logger.info(ex.getMessage());
            ex.printStackTrace();
        }
        return AjaxResult.success(result);
    }


    /**
     * 应急隐患
     *
     *  应急隐患数/应急隐患处置数/隐患处置率
     * @return
     */
    @GetMapping("index/hiddenTrouble")
    @ResponseBody
    public AjaxResult getHiddenTrouble(@RequestParam("Component_Code") String componentId){
        Map<String,Object> troubleParams = new HashMap<>();
        troubleParams.put("componentId",componentId);
        troubleParams.put("eventType","01");
        troubleParams.put("statusArr",new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"});
        int troubleCount = statisticsService.countAllByParams(troubleParams);//隐患总数
        troubleParams.put("eventType","01");
        troubleParams.put("statusArr",new String[]{"6","7","8","9"});
        int processCount = statisticsService.countAllByParams(troubleParams);//已处理隐患总数
        Map<String,Object> troubleParams1 = new HashMap<>();
        troubleParams1.put("componentId",componentId);
        troubleParams1.put("eventType","01");
        troubleParams1.put("statusArr",new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"});
        Map<String,Object> result = statisticsService.getMapBySubStatus(troubleParams1);
        result.put("processCount",processCount);
        result.put("troubleCount",troubleCount);
        return AjaxResult.success(result);
    }

    /**
     *  应急   处理率
     *  应急处置率/巡查处置率/隐患处置率
     * @return
     */
    @GetMapping("index/processRate")
    @ResponseBody
    public AjaxResult processRate(@RequestParam("Component_Code") String componentId){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> params = new HashMap<>();
        params.put("componentId",componentId);
        params.put("eventType","00");
        params.put("statusArr",new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"});
        int alarmCount = statisticsService.countAllByParams(params);//隐患总数
        params.put("statusArr",new String[]{"6","7","8","9"});
        int alarmDoneCount = statisticsService.countAllByParams(params);//隐患处置总数
        params.put("eventType","01");
        params.put("statusArr",new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"});
        int troubleCount = statisticsService.countAllByParams(params);//隐患总数
        params.put("statusArr",new String[]{"6","7","8","9"});
        int troubleDoneCount = statisticsService.countAllByParams(params);//隐患处置总数
        params.put("eventType","03");
        params.put("statusArr",new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"});
        int patrolCount = statisticsService.countAllByParams(params);//巡查总数
        params.put("statusArr",new String[]{"6","7","8","9"});
        int patrolDoneCount = statisticsService.countAllByParams(params);//巡查处置总数
        result.put("alarmRate",rate(new BigDecimal(alarmDoneCount),new BigDecimal(alarmCount)));//报警处理率
        result.put("troubleRate",rate(new BigDecimal(troubleDoneCount),new BigDecimal(troubleCount)));//隐患处理率
        result.put("patrolRate",rate(new BigDecimal(patrolDoneCount),new BigDecimal(patrolCount)));//巡查处理率
        return AjaxResult.success(result);
    }

    /**
     *  应急   报警事件详情
     *
     * @return
     */
    @GetMapping("index/eventInfoByYJ")
    @ResponseBody
    public AjaxResult eventInfoByYJ(@RequestParam(value = "Component_Code",required = false) String componentId,Long requestTime){
        Map<String,Object> params = new HashMap<>();
        params.put("componentId",componentId);
        if(requestTime != null){
            params.put("lastRequestTime",DateUtils.getLastRequestTime(requestTime));
        }
        String[] extendArr = null;
        if(StringUtils.isEmpty(componentId)){
            /**大屏弹窗显示项**/
            String accordingItem = configService.selectConfigByKey("dp.dialog.accordingItem");
            if(!StringUtils.isEmpty(accordingItem)){
                extendArr = accordingItem.split(",");
            }
        }
        int[] array = Arrays.asList(extendArr).stream().mapToInt(Integer::parseInt).toArray();
        params.put("extendInt3Arr",array);
        return AjaxResult.success(statisticsService.getNewEventByYJ(params));
    }

    /**
     *  事件处理个数
     *  服务时长
     *
     * @return
     */
    @GetMapping("index/eventServerInfo")
    @ResponseBody
    public AjaxResult eventServerInfo(@RequestParam("Component_Code") String componentId){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> params1 = new HashMap<>();
        params1.put("componentId",componentId);
        params1.put("statusArr",new String[]{"6","7","8","9"});
        PercentResult percentResult1 = statisticsService.eventCountAndRate(params1);
        Map<String,Object> params2 = new HashMap<>();
        params2.put("componentId",componentId);
        params2.put("statusArr",new String[]{"6","7","8","9"});
        PercentResult percentResult2 = statisticsService.eventActiveTime(params2);
        percentResult2.setName(componentId);
        result.put("serverCount",percentResult1);
        result.put("serverHours",percentResult2);
        return AjaxResult.success(result);
    }

    /**
     *  出租屋数量/流动人口数量
     *
     * @return
     */
    @GetMapping("index/populaHouseCount")
    @ResponseBody
    public AjaxResult populaHouseCount(){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        result.put("populaCount",populationService.allCount(param));
        result.put("houseCount",houseInfoService.allCount(param));
        return AjaxResult.success(result);
    }

    /**
     *  青和居
     * @return
     */
    @GetMapping("index/populaQhj")
    @ResponseBody
    public AjaxResult populaQhj(){
        //流出地
        Map<String,Object> result = new HashMap<>();
        result.put("part_1",populationService.queryOutStatistics());
        //辖区人数列表
        Map<String,Object> param = new HashMap<>();
        List<PopulaStatiInfo> list = populationService.queryPopulaInfoByRegion(param);
        result.put("part_2",list);
        return AjaxResult.success(result);
    }


    List<Integer>  DataFormat(List<HkEventInfo> eventInfos, String type,List<TimeField> timeFields) throws ParseException {
        for(HkEventInfo eventInfo : eventInfos){
            for(TimeField timeField:timeFields){
                Integer count = timeField.getCount();
                if(count == null){
                    count = 0;
                    timeField.setCount(count);
                }
                String format = timeField.getFormat();
                Date startDate =  DateUtils.parseDate(timeField.getStartTime(),format);
                Date endDate = DateUtils.parseDate(timeField.getEndTime(),format);
                String DateStr = DateUtils.parseDateToStr(format,eventInfo.getCreateTime());
                if(startDate.getTime()<= DateUtils.parseDate(DateStr,format).getTime() && endDate.getTime()>=DateUtils.parseDate(DateStr,format).getTime()){
                    timeField.setCount(++count);
                }
            }
        }
        return timeFields.stream().map(TimeField::getCount).collect(Collectors.toList());//事件数
    }

    public Double rate(BigDecimal num,BigDecimal mum1){
        if(mum1.compareTo(BigDecimal.ZERO) < 1){
            return 0.00;
        }
        return num.divide(mum1,4,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /*闲林-大屏首页接口
    * 概览组--村社数、网格数、管理人口*/
    @RequestMapping("index/overview")
    @ResponseBody
    public AjaxResult overview(){
        Map<String,Object> result = new HashMap<>();
        XlPersonnel xlPersonnel = new XlPersonnel();
        //查询村社总数
        int count = iSysRegionService.queryVillageCommunity();
        //查询网格数
        int gridCount=iSysRegionService.queryGridALl();
        //查询人员总数
        int personCount=iXlPersonnelService.queryPersonCount(xlPersonnel);
        result.put("count",count);
        result.put("gridCount",gridCount);
        result.put("personCount",personCount);
        return AjaxResult.success(result);
    }
    /**
     *闲林-大屏首页接口
     * 人员分析--人口、户籍人口、流动人口
     */
    @ApiOperation(value = "人员分析",notes = "人员分析")
//    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int", paramType = "path")
    @DynamicResponseParameters(name = "personnel",properties = {
           @DynamicParameter(name = "HouseholdRegister",value = "户籍人口数",required = true,dataTypeClass = Integer.class),
           @DynamicParameter(name = "personCount",value = "人员总数",required = true,dataTypeClass = Integer.class),
           @DynamicParameter(name = "flowcount",value = "流动人口",required = true,dataTypeClass = Integer.class),
    })
    @RequestMapping(value = "index/personnel",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult personnel(String nativePlace,String gender,String age,String polity){
        Map<String,Object> result = new HashMap<>();
        XlPersonnel xlPersonnel = new XlPersonnel();
        xlPersonnel.setNativePlace(nativePlace);
        if(gender==null){

        }else{
            xlPersonnel.setGender(gender);
        }
        xlPersonnel.setAge(age);
        xlPersonnel.setPolity(polity);
        //查询人员总数
        int personCount=iXlPersonnelService.queryPersonCount(xlPersonnel);
        //流动人口
        int flowcount= iXlPersonnelService.queryLiuPopulation(xlPersonnel);
        //户籍人口
        int HouseholdRegister=iXlPersonnelService.queryHuPopulation(xlPersonnel);
        result.put("personCount",personCount);
        result.put("flowcount",flowcount);
        result.put("HouseholdRegister",HouseholdRegister);
        return AjaxResult.success(result);
    }

    /**
     *闲林-大屏首页接口
     * 人员分析--人员列表
     */
    @RequestMapping(value = "index/personnelList",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult personnelList(String personName,String phone,String idcard,String liveType,String nativePlace,String polity,String villageName,String ethnicGroup, Integer pageNum,Integer pageSize ){
        if(pageNum==null){
            pageNum=1;
        }else if(pageSize==null){
            pageSize=20;
        }
        startPage();
        XlPersonnel xlPersonnel = new XlPersonnel();
        xlPersonnel.setNativePlace(nativePlace);
        xlPersonnel.setName(personName);
        xlPersonnel.setPhone(phone);
        xlPersonnel.setIdcard(idcard);
        xlPersonnel.setLiveType(liveType);
        xlPersonnel.setVillageName(villageName);
        xlPersonnel.setNation(ethnicGroup);
        xlPersonnel.setPolity(polity);
        List<XlPersonnel> xlPersonnelList=iXlPersonnelService.selectXlPersonnelList(xlPersonnel);
        return AjaxResult.success(xlPersonnelList);
    }


    /**
     * 闲林-大屏首页接口
     * 房屋分析--房屋总数、商品房、自建房
     */
    @RequestMapping("index/house")
    @ResponseBody
    public AjaxResult house(String communityName,String roomType,String roomLiveType){
        Map<String,Object> result = new HashMap<>();
        XlRoom xlRoom = new XlRoom();
        xlRoom.setCommunityName(communityName);
        xlRoom.setRoomType(roomType);
        if(roomLiveType!=null){
            xlRoom.setRoomLiveType(Integer.parseInt(roomLiveType));
        }
        //查询房屋总数
        int roomCount=iXlRoomService.queryRoomAll(xlRoom);
        //查询商品房总数
        int commercialHouse=iXlRoomService.queryCommercialCount(xlRoom);
        //查询自建房总数
        int selfBuiltHouse=iXlRoomService.querySelfBuiltCount(xlRoom);
        result.put("roomCount",roomCount);
        result.put("commercialHouse",commercialHouse);
        result.put("selfBuiltHouse",selfBuiltHouse);
        return AjaxResult.success(result);
    }

    /**
     * 闲林-大屏首页接口
     * 房屋分析--列表
     */
    @RequestMapping(value = "index/houseList",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult houseList(String communityName,String roomType,String roomLiveType,String villageName,String blurred,Integer pageNum,Integer pageSize){
        if(pageNum==null){
            pageNum=1;
        }else if(pageSize==null){
            pageSize=20;
        }
        startPage();
        Map<String,Object> result = new HashMap<>();
        XlRoom xlRoom = new XlRoom();
        xlRoom.setCommunityName(communityName);
        xlRoom.setRoomType(roomType);
        if(roomLiveType!=null){
            xlRoom.setRoomLiveType(Integer.parseInt(roomLiveType));
        }
        xlRoom.setVillageName(villageName);
        xlRoom.setAddress(blurred);
        List<XlRoom> xlRooms = iXlRoomService.selectXlRoomList(xlRoom);
        return AjaxResult.success(xlRooms);
    }

    /**
     * 闲林-大屏首页接口
     * 房屋分析--详情
     */
    @RequestMapping(value = "index/houseDetail",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult houseDetail(String id){
        Map<String,Object> result = new HashMap<>();
        List<XlEnterpriseInfo> xlEnterpriseInfos= iXlRoomService.queryRoomDetail(Integer.parseInt(id));
        return AjaxResult.success(xlEnterpriseInfos);
    }


    /**
     * 闲林-大屏首页接口
     * 企业分析--企业总数、上市企业、规上企业
     */
    @RequestMapping("index/enterprise")
    @ResponseBody
    public AjaxResult enterprise(Integer enterpriseType,String natureBusiness,String enterpriseName){
        Map<String,Object> result = new HashMap<>();
        XlEnterpriseInfo xlEnterpriseInfo = new XlEnterpriseInfo();
//        xlEnterpriseInfo.setEnterpriseType(enterpriseType);
        xlEnterpriseInfo.setEnterpriseTypeNum(enterpriseType);
        xlEnterpriseInfo.setNatureBusiness(natureBusiness);
        xlEnterpriseInfo.setEnterpriseName(enterpriseName);
        //企业总数
        int enterpriseCount =iXlEnterpriseInfoService.queryEnterpriseAll(xlEnterpriseInfo);
        //上市企业总数
        int ListedEnterpriseCount=iXlEnterpriseInfoService.queryListedEnterprise(xlEnterpriseInfo);
        //上市企业总数
        int geTiEnterpriseCount=iXlEnterpriseInfoService.queryListGeTiEnterprise(xlEnterpriseInfo);
        result.put("enterpriseCount",enterpriseCount);
        result.put("ListedEnterpriseCount",ListedEnterpriseCount);
        result.put("geTiEnterpriseCount",geTiEnterpriseCount);
        return AjaxResult.success(result);
    }
    /**
     * 闲林-大屏首页接口
     * 企业分析--企业列表
     */
    @RequestMapping("index/enterpriseList")
    @ResponseBody
    public AjaxResult enterpriseList(Integer enterpriseType,String enterpriseName,Integer isOnStock,Integer enterpriseStatus,String unifiedCreditCode,String establishPerson,String startTime,String endTime,Integer pageNum,Integer pageSize){
        if(pageNum==null){
            pageNum=1;
        }else if(pageSize==null){
            pageSize=20;
        }
        startPage();
        Map<String,Object> result = new HashMap<>();
        result.put("enterpriseType",enterpriseType);
        result.put("enterpriseName",enterpriseName);
        result.put("isOnStock",isOnStock);
        result.put("enterpriseStatus",enterpriseStatus);
        result.put("unifiedCreditCode",unifiedCreditCode);
        result.put("establishPerson",establishPerson);
        result.put("startTime",startTime);
        result.put("endTime",endTime);
        List<XlEnterpriseInfo> xlEnterpriseInfos = iXlEnterpriseInfoService.selectXlEnterpriseInfo(result);
        return AjaxResult.success(xlEnterpriseInfos);
    }

    /**
     * 三源治理指数--当月事件总量、同比增长率、当月事件处置率
     */
    @RequestMapping("index/event")
    @ResponseBody
    public AjaxResult event(){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> thingResult = new HashMap<>();
        Map<String,Object> params = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.add(Calendar.MONTH,0);
        Date time = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //本月第一天
        String format = dateFormat.format(time);
        thingResult.put("startTime",format);
        thingResult.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
        //本月事件总量
        int eventCount=eventService.queryEventAllCount(thingResult);
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(new Date());
        calendar1.set(Calendar.DAY_OF_MONTH,1);
        calendar1.add(Calendar.MONTH,-1);
        Date time1 = calendar1.getTime();
        calendar2.setTime(new Date());
        calendar2.set(Calendar.DAY_OF_MONTH,0);
        calendar2.add(Calendar.MONTH,0);
        Date time2 = calendar2.getTime();
        //上个月第一天
        String format1 = dateFormat.format(time1);
        //上个月最后一天
        String format2 = dateFormat.format(time2);
        thingResult.put("lastStartTime",format1);
        thingResult.put("lastEndTime",format2);
        //上个月事件总量
        int lastEventCount=eventService.queryLastEventAllCount(thingResult);
        //本月事件完成总数
        params.put("startTime",format);
        params.put("statusArr",new String[]{"6","7","8","9"});
        int endCount=eventService.queryEventAllCount(params);
        result.put("eventCount",eventCount);
        result.put("lastEventCount",lastEventCount);
        result.put("endCount",endCount);
        return AjaxResult.success(result);
    }

    /**
     *城市管理指数--当月事件总数、同比增长、当月事件处置数
     */
    @RequestMapping("index/urbanEvent")
    @ResponseBody
    public AjaxResult urbanEvent(){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> thingResult = new HashMap<>();
        Map<String,Object> params = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.add(Calendar.MONTH,0);
        Date time = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //本月第一天
        String format = dateFormat.format(time);
        thingResult.put("startTime",format);
        thingResult.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
        thingResult.put("componentId","1001");
        //本月事件总量
        int eventCount=eventService.queryEventAllCount(thingResult);
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(new Date());
        calendar1.set(Calendar.DAY_OF_MONTH,1);
        calendar1.add(Calendar.MONTH,-1);
        Date time1 = calendar1.getTime();
        calendar2.setTime(new Date());
        calendar2.set(Calendar.DAY_OF_MONTH,0);
        calendar2.add(Calendar.MONTH,0);
        Date time2 = calendar2.getTime();
        //上个月第一天
        String format1 = dateFormat.format(time1);
        //上个月最后一天
        String format2 = dateFormat.format(time2);
        thingResult.put("lastStartTime",format1);
        thingResult.put("lastEndTime",format2);
        thingResult.put("componentId","1001");
        //上个月事件总量
        int lastEventCount=eventService.queryLastEventAllCount(thingResult);
        //本月事件完成总数
        params.put("startTime",format);
        params.put("statusArr",new String[]{"6","7","8","9"});
        int endCount=eventService.queryEventAllCount(params);
        result.put("eventCount",eventCount);
        result.put("lastEventCount",lastEventCount);
        result.put("endCount",endCount);

        return AjaxResult.success(result);
    }

    /**
     * 大屏首页
     * 地图要素按钮--人员、房屋、企业、事件、设备
     */
    @RequestMapping("index/mapElement")
    @ResponseBody
    public AjaxResult mapElement(){
        Map<String,Object> thingResult = new HashMap<>();
        XlPersonnel xlPersonnel = new XlPersonnel();
        XlEnterpriseInfo xlEnterpriseInfo = new XlEnterpriseInfo();
        XlRoom xlRoom = new XlRoom();
        int personCount=iXlPersonnelService.queryPersonCount(xlPersonnel);
        int roomCount=iXlRoomService.queryRoomAll(xlRoom);
        int enterpriseCount =iXlEnterpriseInfoService.queryEnterpriseAll(xlEnterpriseInfo);
        int equipmentCount=iXlEquipmentInfoService.queryEquipmentCount();
        thingResult.put("personCount",personCount);
        thingResult.put("roomCount",roomCount);
        thingResult.put("enterpriseCount",enterpriseCount);
        thingResult.put("equipmentCount",equipmentCount);
        return AjaxResult.success(thingResult);
    }

    /**
     * 大屏首页
     * 事件中心--事件总计
     */
    @RequestMapping("index/eventSource")
    @ResponseBody
    public AjaxResult eventSource(String time,String deptName,String communityName,String gridName){
        Map<String,Object> thingResult = new HashMap<>();
        Map<String,Object> params = new HashMap<>();
        Date date = new Date();
        if(time==null){
           /* int deptId=deptService.queryDeptName(deptName);
            int deptCount=eventService.queryEventDept(String.valueOf(deptId));*/
            thingResult.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
            thingResult.put("nearlyAWeekBegin",DateUtil.offsetWeek(date, -1).toString());
            int eventAllCount=eventService.queryLastEventAllCount(thingResult);//本周事件总数
            thingResult.put("statusArr",new String[]{"2"});
            int studyEventCount=eventService.queryLastEventAllCount(thingResult);//近周研判事件总数
            thingResult.put("statusArr",new String[]{"3","4","5"});
            int dealEventCount=eventService.queryLastEventAllCount(thingResult);//近周处置中事件总数
            thingResult.put("statusArr",new String[]{"6","7","8","9"});
            int endEventCount=eventService.queryLastEventAllCount(thingResult);//近周完结事件总数
            thingResult.put("statusArr",new String[]{"7"});
            int neglectEventCount=eventService.queryLastEventAllCount(thingResult);//近周忽略事件总数
            //查看评价满意度
            int evaluateCount=eventService.queryEvaluate(thingResult);
//            String oneStarProportion=(float)evaluateCount/(float)eventAllCount*100.00+"%";//评价满意度占比
            String handleRate = divideTo(new BigDecimal(eventAllCount),new BigDecimal(evaluateCount))+"%";
            params.put("neglectEventCount",neglectEventCount);
            params.put("eventAllCount",eventAllCount);
            params.put("studyEventCount",studyEventCount);
            params.put("dealEventCount",dealEventCount);
            params.put("endEventCount",endEventCount);
            params.put("handleRate",handleRate);
            thingResult.put("componentId",new String[]{"1002","1004"});
            int platformCount=eventService.queryPlatformEvent(thingResult);//全平台平台事件（浙里访、四平台）
            thingResult.put("componentId",new String[]{"1005"});
            int streetCount=eventService.queryPlatformEvent(thingResult);//街道内部事件
            params.put("platformCount",platformCount);
            params.put("streetCount",streetCount);
        }else if (time.equals("月")){
            thingResult.put("nearlyAMonthBegin",DateUtil.offsetMonth(date, -1).toString());
            int eventAllCount=eventService.queryLastEventAllCount(thingResult);
            thingResult.put("statusArr",new String[]{"2"});
            int studyEventCount=eventService.queryLastEventAllCount(thingResult);//近月研判事件总数
            thingResult.put("statusArr",new String[]{"3","4","5"});
            int dealEventCount=eventService.queryLastEventAllCount(thingResult);//近周处置中事件总数
            thingResult.put("statusArr",new String[]{"6","7","8","9"});
            int endEventCount=eventService.queryLastEventAllCount(thingResult);//近周完结事件总数
            thingResult.put("statusArr",new String[]{"7"});
            int neglectEventCount=eventService.queryLastEventAllCount(thingResult);//近月忽略事件总数
            //查看评价满意度
            int evaluateCount=eventService.queryEvaluate(thingResult);
//            String oneStarProportion=(float)evaluateCount/(float)eventAllCount*100+"%";//评价满意度占比
            String handleRate = divideTo(new BigDecimal(eventAllCount),new BigDecimal(evaluateCount))+"%";
            params.put("neglectEventCount",neglectEventCount);
            params.put("eventAllCount",eventAllCount);
            params.put("studyEventCount",studyEventCount);
            params.put("dealEventCount",dealEventCount);
            params.put("endEventCount",endEventCount);
            params.put("handleRate",handleRate);
            thingResult.put("componentId",new String[]{"1002","1004"});
            int platformCount=eventService.queryPlatformEvent(thingResult);//全平台平台事件（浙里访、四平台）
            thingResult.put("componentId",new String[]{"1005"});
            int streetCount=eventService.queryPlatformEvent(thingResult);//街道内部事件
            params.put("platformCount",platformCount);
            params.put("streetCount",streetCount);
        }else if(time.equals("年")){
            thingResult.put("nearlyAYearBegin",DateUtils.getNearlyYear(date,-1));
            int eventAllCount=eventService.queryLastEventAllCount(thingResult);
            thingResult.put("statusArr",new String[]{"2"});
            int studyEventCount=eventService.queryLastEventAllCount(thingResult);//近年研判事件总数
            thingResult.put("statusArr",new String[]{"3","4","5"});
            int dealEventCount=eventService.queryLastEventAllCount(thingResult);//近年处置中事件总数
            thingResult.put("statusArr",new String[]{"6","7","8","9"});
            int endEventCount=eventService.queryLastEventAllCount(thingResult);//近年完结事件总数
            thingResult.put("statusArr",new String[]{"7"});
            int neglectEventCount=eventService.queryLastEventAllCount(thingResult);//近年忽略事件总数
            //查看评价满意度
            int evaluateCount=eventService.queryEvaluate(thingResult);
//            String oneStarProportion=(float)evaluateCount/(float)eventAllCount*100+"%";//评价满意度占比
            String handleRate = divideTo(new BigDecimal(eventAllCount),new BigDecimal(evaluateCount))+"%";

            params.put("neglectEventCount",neglectEventCount);
            params.put("eventAllCount",eventAllCount);
            params.put("studyEventCount",studyEventCount);
            params.put("dealEventCount",dealEventCount);
            params.put("endEventCount",endEventCount);
            params.put("handleRate",handleRate);
            thingResult.put("componentId",new String[]{"1002","1004"});
            int platformCount=eventService.queryPlatformEvent(thingResult);//全平台平台事件（浙里访、四平台）
            thingResult.put("componentId",new String[]{"1005"});
            int streetCount=eventService.queryPlatformEvent(thingResult);//街道内部事件
            params.put("platformCount",platformCount);
            params.put("streetCount",streetCount);
        }else if(time.equals("周")){
            thingResult.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
            thingResult.put("nearlyAWeekBegin",DateUtil.offsetWeek(date, -1).toString());
            int eventAllCount=eventService.queryLastEventAllCount(thingResult);//本周事件总数
            thingResult.put("statusArr",new String[]{"2"});
            int studyEventCount=eventService.queryLastEventAllCount(thingResult);//近周研判事件总数
            thingResult.put("statusArr",new String[]{"3","4","5"});
            int dealEventCount=eventService.queryLastEventAllCount(thingResult);//近周处置中事件总数
            thingResult.put("statusArr",new String[]{"6","7","8","9"});
            int endEventCount=eventService.queryLastEventAllCount(thingResult);//近周完结事件总数
            thingResult.put("statusArr",new String[]{"7"});
            int neglectEventCount=eventService.queryLastEventAllCount(thingResult);//近周忽略事件总数
            //查看评价满意度
            int evaluateCount=eventService.queryEvaluate(thingResult);
//            String oneStarProportion=(float)evaluateCount/(float)eventAllCount*100+"%";//评价满意度占比
            String handleRate = divideTo(new BigDecimal(eventAllCount),new BigDecimal(evaluateCount))+"%";
            params.put("neglectEventCount",neglectEventCount);
            params.put("eventAllCount",eventAllCount);
            params.put("studyEventCount",studyEventCount);
            params.put("dealEventCount",dealEventCount);
            params.put("endEventCount",endEventCount);
            params.put("handleRate",handleRate);
            thingResult.put("componentId",new String[]{"1002","1004"});
            int platformCount=eventService.queryPlatformEvent(thingResult);//全平台平台事件（浙里访、四平台）
            thingResult.put("componentId",new String[]{"1005"});
            int streetCount=eventService.queryPlatformEvent(thingResult);//街道内部事件
            params.put("platformCount",platformCount);
            params.put("streetCount",streetCount);
        }

        return AjaxResult.success(params);
    }
    //事件列表
    @RequestMapping(value = "index/eventList",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult eventList(String eventType,String startTime,String endTime,String status,String grade,Integer pageNum,Integer pageSize){
        if(pageNum==null){
            pageNum=1;
        }else if(pageSize==null){
            pageSize=20;
        }
        startPage();
        Map<String,Object> thingResult = new HashMap<>();
        thingResult.put("eventType",eventType);
        thingResult.put("startTime",startTime);
        thingResult.put("endTime",endTime);
        thingResult.put("status",status);
        String gradeType=null;
        if(grade==null){

        }else if(grade.equals("二级")){
            gradeType="99";
        }else if(grade.equals("三级")){
            gradeType="999";
        }else{
            gradeType="1";
        }
        thingResult.put("grade",gradeType);
        List<HkEventInfo> list= eventService.queryEventInfoAllList(thingResult);
        return AjaxResult.success(list);
    }
    //事件详情
    @RequestMapping("index/eventdeail")
    @ResponseBody
    public AjaxResult eventdeail(String eventId){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String,Object> result = new HashMap<>();
        HkEventInfo eventInfo = hkEventRecordService.findEventId(eventId);
        if(eventInfo == null){
            AjaxResult.error("事件不存在");
        }
        Date createTime = eventInfo.getCreateTime();
        Date updateTime = eventInfo.getUpdateTime();
        result.put("eventTitle",eventInfo.getEventTitle());
        result.put("timeOut",eventInfo.getTimeOut());
        result.put("eventTypeName",eventInfo.getEventTypeName());
        result.put("reportTypeName",eventInfo.getReportTypeName());
        result.put("createTime",eventInfo.getCreateTime());//事件上报事件暂定为事件上报到风控的时间
        result.put("updateTime",eventInfo.getUpdateTime());//事件完成时间
        result.put("regionName",eventInfo.getRegionName());
        result.put("eventAddress",eventInfo.getEventAddress());
        result.put("eventImage",eventInfo.getEventImage());
        result.put("evaluate",eventInfo.getEvaluate());
        if(updateTime!=null){
            result.put("allTime",DateUtils.subStrDateStringRetainTwo(DateUtil.formatBetween(createTime,updateTime)));

        }
        List<Map<String,Object>> list = new ArrayList<>();
        List<HkActionProcess> processes = appMyWorkService.findActionChainEventId(eventId);
        if(processes == null || processes.size() == 0){
            result.put("list",list);
            return AjaxResult.success(result);
        }
        /**对行动链顺序排列**/
        processes.sort(Comparator.comparing(HkActionProcess::getCreateTime));
        HkActionProcess process = processes.get(0);

        String handlerUserId = process.getHandlerUserId();
        SysUser user = userService.selectUserById(Long.parseLong(handlerUserId));
        String userName = user.getUserName();
        String phone = user.getPhonenumber();
        result.put("phone",phone);
        result.put("userName",userName);
        result.put("processTime",createTime);
        Map<String,Object> param = new HashMap<>();
        param.put("eventId",process.getEventId());
        param.put("statusArr",new String[]{"1","2","3","5","4","6"});
        List<HKrecord> hKrecords = appEventDetailService.selectProcessByParams(param);
        for(HKrecord record : hKrecords){
            Map<String,Object> map = new HashMap<>();
            SysUser user1 = userService.selectUserById(Long.parseLong(record.getHandlerIndexCode()));
            map.put("todoUserId",user1.getUserId());
            map.put("todoUserName",user1.getUserName());
            map.put("processStatus",record.getProcessStatus());
            map.put("processTime",dateFormat.format(record.getCreateTime()));
            /*if ("6".equals(record.getProcessStatus())){ //中心处置
                map.put("todoUserName","中心处置");
                map.put("phone","-");
                map.put("processTime",dateFormat.format(eventInfo.getUpdateTime()));
                map.put("zpUserName",eventInfo.getUpdateUser());//操作人
            }else*/
            if("5".equals(record.getProcessStatus())){//已退回信息
                String json = record.getHandlerContent();
                JSONObject voiceJson = JSON.parseObject(json);
                String handlerContent = voiceJson.getString("handlerContent");
                map.put("backReason",handlerContent);
                String nowTime = voiceJson.getString("nowTime");
                map.put("processTime",nowTime);
            } else {
                map.put("phone",user1.getPhonenumber());
                map.put("processTime",dateFormat.format(record.getCreateTime()));
                map.put("zpUserName",process.getCreateUser());//操作人
                if ("4".equals(record.getProcessStatus())){ //处置
                    for (HkActionProcess dto : processes){
                        if (dto.getHandlerUserId().equals(record.getHandlerIndexCode())){ //获取对应处置人的处置结果
                            AppActionInfo as  =  JSONObject.parseObject(record.getHandlerContent(), AppActionInfo.class);
                            if(!as.getActionName().equals("QS0001")){
                                List<appField> listInfo = JSONObject.parseArray(as.getAppField(), appField.class);
                                map.put("processResult",listInfo);
                                break;
                            }
                        }
                    }
                }
            }
            list.add(map);
        }
        result.put("list",list);

        return AjaxResult.success(result);
    }

    /**
     * 大屏首页--物业管理
     * 物业概况--物业星级、物业、自建房、商品房、户主、租客
     */
    @RequestMapping("index/propertysurvey")
    @ResponseBody
    public AjaxResult propertysurvey(){
        Map<String,Object> params = new HashMap<>();
        Map<String,Object> thingResult = new HashMap<>();
        int estateManagements=estateManagementService.queryPropert(thingResult);//物业总数
        XlPersonnel xlPersonnel = new XlPersonnel();
        XlRoom xlRoom = new XlRoom();
        //小区总数
        int villageCount=villageService.queryVillageCount();
        //查询商品房总数
        int commercialHouse=iXlRoomService.queryCommercialCount(xlRoom);
        //查询自建房总数
        int selfBuiltHouse=iXlRoomService.querySelfBuiltCount(xlRoom);
        //租客
        int tenantCount= iXlPersonnelService.queryLiuPopulation(xlPersonnel);
        //户主
        int ownerCount=iXlPersonnelService.queryHuPopulation(xlPersonnel);
        params.put("estateManagements",estateManagements);
        params.put("villageCount",villageCount);
        params.put("commercialHouse",commercialHouse);
        params.put("selfBuiltHouse",selfBuiltHouse);
        params.put("tenantCount",tenantCount);
        params.put("ownerCount",ownerCount);
        return AjaxResult.success(params);
    }

    /**
     * 大屏--应急智慧
     * 设备点位信息
     */
    @RequestMapping("index/equipmentPoints")
    @ResponseBody
    public AjaxResult equipmentPoints(@RequestParam(value = "eventType",required=false) List<String> eventType,String deviceType,Integer pageNum,Integer pageSize){
        if(pageNum==null){
            pageNum=1;
        }else if(pageSize==null){
            pageSize=20;
        }
        startPage();
        Map<String,Object> params = new HashMap<>();
        Map<String,Object> thingResult = new HashMap<>();
        String eventTypeAll=null;
        String cameraIndexCode=null;
        if(eventType!=null){
            for(int j=0;j<eventType.size();j++){
                String eventType1 = eventType.get(j);
                if(j==0){
                    eventTypeAll=eventType1;
                }else{
                    eventTypeAll=eventTypeAll+","+eventType1;
                }
            }
        }
        if(eventTypeAll!=null){
            String[] split1 = eventTypeAll.split(",");
            params.put("eventTypeAll",split1);
        }
        List<CameraIndexCodeVo> indexCodeDtos= eventService.querycameraIndexCode(params);
        for(int k=0;k<indexCodeDtos.size();k++){
            String cameraIndexCode1 = indexCodeDtos.get(k).getCameraIndexCode();
            if(k==0){
                cameraIndexCode=cameraIndexCode1;
            }else{
                cameraIndexCode=cameraIndexCode+","+cameraIndexCode1;
            }
        }
        if(cameraIndexCode!=null){
            String[] split = cameraIndexCode.split(",");
            thingResult.put("cameraIndexCode",split);
        }
        thingResult.put("deviceType",deviceType);
       List<XlEquipmentInfo> xlEquipmentInfos= iXlEquipmentInfoService.queryList(thingResult);
//        List<XlEquipmentInfo> list=iXlEquipmentInfoService.queryEquipmentList();
        return AjaxResult.success(xlEquipmentInfos);
    }

    /**
     *物业管理--共治通讯录(居委会、业委会、物业)
     */
    @RequestMapping("index/propertyrElevant")
    @ResponseBody
    public AjaxResult propertyrElevant(String neighborhood,Integer pageNum,Integer pageSize){
        if(pageNum==null){
            pageNum=1;
        }else if(pageSize==null){
            pageSize=20;
        }
        startPage();
        List<Map> list1 = new ArrayList<>();
        if(neighborhood==null){
            List<XlVillageModel> list=villageService.queryVillageList();
            for(int i=0;i<list.size();i++){
                Map map = new HashMap<>();
                String name = list.get(i).getName();
                String neighborhoodPerson = list.get(i).getNeighborhoodPerson();
                String neighborhoodPhone = list.get(i).getNeighborhoodPhone();
                map.put("quartersName",name);
                map.put("propertyName","居委会");
                map.put("neighborhoodPerson",neighborhoodPerson);
                map.put("neighborhoodPhone",neighborhoodPhone);
                list1.add(map);
            }
            return AjaxResult.success(list1);
        }else if(neighborhood.equals("社区居委会")){
            List<XlVillageModel> list=villageService.queryVillageList();
            for(int i=0;i<list.size();i++){
                Map map = new HashMap<>();
                String name = list.get(i).getName();
                String neighborhoodPerson = list.get(i).getNeighborhoodPerson();
                String neighborhoodPhone = list.get(i).getNeighborhoodPhone();
                map.put("quartersName",name);
                map.put("propertyName","居委会");
                map.put("neighborhoodPerson",neighborhoodPerson);
                map.put("neighborhoodPhone",neighborhoodPhone);
                list1.add(map);
            }
            return AjaxResult.success(list1);
        }else if(neighborhood.equals("小区业委会")){
            List<XlVillageModel> list=villageService.queryVillageComList();
            for(int i=0;i<list.size();i++){
                Map map = new HashMap<>();
                String name = list.get(i).getName();
                String quartersCommitteePerson = list.get(i).getQuartersCommitteePerson();
                String quartersCommitteePhone = list.get(i).getQuartersCommitteePhone();
                map.put("quartersName",name);
                map.put("propertyName",name+"业委会");
                map.put("neighborhoodPerson",quartersCommitteePerson);
                map.put("neighborhoodPhone",quartersCommitteePhone);
                list1.add(map);
            }
            return AjaxResult.success(list1);
        }else if(neighborhood.equals("物业公司")){
            List<XlVillageModel> list=villageService.queryPropertyList();
            for(int i=0;i<list.size();i++){
                Map map = new HashMap<>();
                String name = list.get(i).getName();
                String propertyName = list.get(i).getPropertyName();
                String propertyPerson = list.get(i).getPropertyPerson();
                String propertyPhone = list.get(i).getPropertyPhone();
                map.put("quartersName",name);
                map.put("propertyName",propertyName);
                map.put("neighborhoodPerson",propertyPerson);
                map.put("neighborhoodPhone",propertyPhone);
                list1.add(map);
            }
            return AjaxResult.success(list1);
        }
        return AjaxResult.success();
    }
    /**
     * 小区下拉框
     */
    @RequestMapping("index/dropDown")
    @ResponseBody
    public AjaxResult dropDown(String quartersName){
        XlVillageModel xlVillageModel = new XlVillageModel();
        xlVillageModel.setName(quartersName);
        List<XlVillageModel> xlVillageModels=villageService.queryvillageName(xlVillageModel);
        List<Map> list1 = new ArrayList<>();
        for(int i=0;i<xlVillageModels.size();i++){
            Map map = new HashMap<>();
            map.put("quartersName",xlVillageModels.get(i).getName());
            map.put("quartersId",xlVillageModels.get(i).getId());
            list1.add(map);
        }
        return AjaxResult.success(list1);
    }
    /**
     *物业事件列表
     */
    @RequestMapping("index/propertyEventList")
    @ResponseBody
    public AjaxResult propertyEventList(String eventSource,String eventType,Integer villageId,Integer eventStatus){
        startPage();
        Map<String,Object> thingResult = new HashMap<>();
        thingResult.put("eventSource",eventSource);
        thingResult.put("eventType",eventType);
        thingResult.put("residentialQuarters",villageId);
        thingResult.put("eventStatus",eventStatus);
       /* if(residentialQuarters==null){

        }else{
            XlVillageModel xlVillageModel = new XlVillageModel();
            xlVillageModel.setName(residentialQuarters);
            int id=villageService.queryVillageId(xlVillageModel);

        }*/
        List<XlPropertyAndVillageVo> xlPropertyEvents=propertyEventService.queryPropertyEventList(thingResult);
        List<Map> list1 = new ArrayList<>();
        for(int i=0;i<xlPropertyEvents.size();i++){
            Map map = new HashMap<>();
            map.put("eventId",xlPropertyEvents.get(i).getEventId());
            map.put("quartersName",xlPropertyEvents.get(i).getName());
            map.put("eventSource",xlPropertyEvents.get(i).getEventSource());
            map.put("eventType",xlPropertyEvents.get(i).getEventType());
            map.put("eventStatus",xlPropertyEvents.get(i).getEventStatus());
//            map.put("eventAddress",xlPropertyEvents.get(i).getEventAddress());
//            map.put("reporter",xlPropertyEvents.get(i).getReporter());
//            map.put("reporterPhone",xlPropertyEvents.get(i).getReporterPhone());
            map.put("reportTime",xlPropertyEvents.get(i).getReportTime());
//            map.put("reportContent",xlPropertyEvents.get(i).getReportContent());
//            map.put("reportImage",xlPropertyEvents.get(i).getReportImage());
//            map.put("propertyName",xlPropertyEvents.get(i).getPropertyName());
            list1.add(map);
        }

        return AjaxResult.success(list1);
    }
    /**
     * 大屏--事件中心
     * 事件中心-事件来源趋势图
     */
    @RequestMapping("index/trendChart")
    @ResponseBody
    public AjaxResult trendChart(String source,String type,String allStreet,String communityName,String dept){
        if(source==null || source.equals("all")){
        Map<String,Object> data = null;
        if(data == null){
            Date date = new Date();
            //查询日期范围Map
            Map<String,Object> params = EventDate(type,date);
            //店外违规事件 //无店外违规事件
//            List<Integer> eventTrendCount = new ArrayList<>();

           /* String nearlyADayBegin      =  (String)params.get("nearlyADayBegin");
            String nearlyADayEnd        =  (String)params.get("nearlyADayEnd");*/
            String nearlyAWeekBegin     =  (String)params.get("nearlyAWeekBegin");
            String nearlyAWeekEnd       =  (String)params.get("nearlyAWeekEnd");
            String nearlyAMonthBegin    =  (String)params.get("nearlyAMonthBegin");
            String nearlyAMonthEnd      =  (String)params.get("nearlyAMonthEnd");
            String nearlyAYearBegin     =  (String)params.get("nearlyAYearBegin");
            String nearlyAYearEnd       =  (String)params.get("nearlyAYearEnd");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            List<Integer> countList = new ArrayList<>();
            List<String> timeList = new ArrayList<>();
            try{
                if(!StringUtils.isEmpty(nearlyAWeekBegin) && StringUtils.isEmpty(nearlyAWeekEnd)){
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                    params.clear();
                    //周返回天数段
                    long time = sdf.parse(nearlyAWeekBegin).getTime();
                    String beginDateTime = nearlyAWeekBegin;
                    for(int i = 1; i <= 7; i++){
                        time += 3600000*24;
                        String endDateTime = sdf.format(new Date(time));
                        String endTime = sdf1.format(new Date(time));
                        params.put("endDateTime",endDateTime);
                        params.put("beginDateTime",beginDateTime);
                        params.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
                        Integer thingCount = statisticsService.countAllByParams(params);
                        beginDateTime = endDateTime;
                        countList.add(thingCount);
                        timeList.add(endTime);
                    }
                }
                if(!StringUtils.isEmpty(nearlyAMonthBegin) && StringUtils.isEmpty(nearlyAMonthEnd)){
                    long days = DateUtil.betweenDay(DateUtil.offsetMonth(date, -1), date, false);
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                    params.clear();
                    //月返回天数段
                    long time = sdf.parse(nearlyAMonthBegin).getTime();
                    String beginDateTime = nearlyAMonthBegin;
                    for(int i = 1; i <= days; i++){
                        time += 3600000*24;
                        String endDateTime = sdf.format(new Date(time));
                        String endTime = sdf1.format(new Date(time));
                        params.put("endDateTime",endDateTime);
                        params.put("beginDateTime",beginDateTime);
                        params.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
                        Integer thingCount = statisticsService.countAllByParams(params);
                        beginDateTime = endDateTime;
                        countList.add(thingCount);
                        timeList.add(endTime);
                    }
                }
                if(!StringUtils.isEmpty(nearlyAYearBegin) && StringUtils.isEmpty(nearlyAYearEnd)){
                    params.clear();
                    //年返回月数段
                    String beginDateTime = nearlyAYearBegin;
                    for(int i = 1; i <= 12; i++){
                        String endTime = DateUtil.offsetMonth(sdf.parse(beginDateTime), i).toString().substring(0,10);
                        params.put("endDateTime",DateUtil.offsetMonth(sdf.parse(beginDateTime), i).toString());
                        params.put("beginDateTime",DateUtil.offsetMonth(sdf.parse(beginDateTime), i-1).toString());
                        params.put("statusArr",new String[]{"1","2","3","4","5","6","7","8","9"});
                        Integer thingCount = statisticsService.countAllByParams(params);
                        countList.add(thingCount);
                        timeList.add(endTime);
                    }
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            data = new HashMap();
//            data.put("eventTrend",eventTrendCount);
            data.put("eventPlaceTypeTrends",countList);
            data.put("eventTrendDate",timeList);
            /*putEvents(eventType, data,type);*/
        }
        return AjaxResult.success(data);
        }else if(source.equals("visitSource")){
            Map<String,Object> data = new HashMap();
            return AjaxResult.success(data);
        }else if(source.equals("policeSource")){
            Map<String,Object> data = new HashMap();
            return AjaxResult.success(data);
        }else if(source.equals("sourceAction")){
            Map<String,Object> data = new HashMap();
            return AjaxResult.success(data);
        }else if(source.equals("other")){
            Map<String,Object> data = new HashMap();
            return AjaxResult.success(data);
        }
        return success();
    }
    /**
     * 物业--各事件趋势
     */
    @RequestMapping("index/procatTrend")
    @ResponseBody
    public AjaxResult procatTrend(String type){
        Map<String,Object> data = null;
        if(data == null){
            Date date = new Date();
            //查询日期范围Map
            Map<String,Object> params = EventDateType(type,date);
            //店外违规事件 //无店外违规事件
//            List<Integer> eventTrendCount = new ArrayList<>();

            String nearlyAWeekBegin     =  (String)params.get("nearlyAWeekBegin");
            String nearlyAWeekEnd       =  (String)params.get("nearlyAWeekEnd");
            String nearlyAMonthBegin    =  (String)params.get("nearlyAMonthBegin");
            String nearlyAMonthEnd      =  (String)params.get("nearlyAMonthEnd");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            List<Integer> countList = new ArrayList<>();
            List<String> timeList = new ArrayList<>();
            List<Integer> juList = new ArrayList<>();
            List<Map> chuList = new ArrayList<>();
            List<Integer> xunList = new ArrayList<>();
//            List<String> fangList = new ArrayList<>();
            String zhiHandleRate=null;
            String juHandleRate =null;
            String xunHandleRate=null;
            String zongHandleRate=null;
            try{
                //一周智慧监测
                if(!StringUtils.isEmpty(nearlyAWeekBegin) && StringUtils.isEmpty(nearlyAWeekEnd)){
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                    params.clear();
                    //周返回天数段
                    long time = sdf.parse(nearlyAWeekBegin).getTime();
                    String beginDateTime = nearlyAWeekBegin;
                    for(int i = 1; i <= 7; i++){
                        time += 3600000*24;
                        String endDateTime = sdf.format(new Date(time));
                        String endTime = sdf1.format(new Date(time));
                        params.put("endDateTime",endDateTime);
                        params.put("beginDateTime",beginDateTime);
                        params.put("statusArr",new String[]{"1"});
                        Integer thingCount = propertyEventService.countAllByParams(params);
                        beginDateTime = endDateTime;
                        countList.add(thingCount);
                        timeList.add(endTime);
                    }
                    //事件 处置率
                    Map<String,Object> eventPro = new HashMap<>();
                    Map<String,Object> thingResult = new HashMap<>();
                    thingResult.put("startTime",DateFormatUtils.format(DateUtils.getThisWeekMonday(),"yyyy-MM-dd HH:mm:ss"));
                    thingResult.put("statusArr","");
                    int propertyCount=propertyEventService.queryPropertyEventCount(thingResult);//物业事件总数
                    thingResult.put("eventSource",new String[]{"1"});
                    thingResult.put("eventStatus",new String[]{"3"});
                    int zhiEndCount=propertyEventService.queryPropertyEventCount(thingResult);//物业智慧检测
                    thingResult.put("eventSource",new String[]{"2","3"});
                    thingResult.put("eventStatus",new String[]{"3"});
                    int juEndCount=propertyEventService.queryPropertyEventCount(thingResult);//物业居民上报
                    thingResult.put("eventSource",new String[]{"5"});
                    thingResult.put("eventStatus",new String[]{"3"});
                    int xunEndCount=propertyEventService.queryPropertyEventCount(thingResult);//物业巡更巡防
                    //全部完成事件总数
                    int peopertyEndCount=zhiEndCount+juEndCount+xunEndCount;
                    if(propertyCount!=0){
                        zongHandleRate = divideTo(new BigDecimal(propertyCount),new BigDecimal(peopertyEndCount))+"%";//智慧检测事件处置占比
                        zhiHandleRate = divideTo(new BigDecimal(propertyCount),new BigDecimal(zhiEndCount))+"%";//智慧检测事件处置占比
                        juHandleRate = divideTo(new BigDecimal(propertyCount),new BigDecimal(juEndCount))+"%";//居民上报事件处置占比
                        xunHandleRate = divideTo(new BigDecimal(propertyCount),new BigDecimal(xunEndCount))+"%";//巡更巡防事件处置占比
                    }else{
                        zongHandleRate="0%";//总事件处置率
                        zhiHandleRate = "0%";//智慧检测事件处置占比
                        juHandleRate = "0%";//居民上报事件处置占比
                        xunHandleRate = "0%";//巡更巡防事件处置占比
                    }
                    eventPro.put("zhiHandleRate",zhiHandleRate);
                    eventPro.put("juHandleRate",juHandleRate);
                    eventPro.put("xunHandleRate",xunHandleRate);
                    chuList.add(eventPro);
                }
                //本月智慧监测
                if(!StringUtils.isEmpty(nearlyAMonthBegin) && StringUtils.isEmpty(nearlyAMonthEnd)){
                    long days = DateUtil.betweenDay(DateUtil.offsetMonth(date, -1), date, false);
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                    params.clear();
                    //月返回天数段
                    long time = sdf.parse(nearlyAMonthBegin).getTime();
                    String beginDateTime = nearlyAMonthBegin;
                    for(int i = 1; i <= days; i++){
                        time += 3600000*24;
                        String endDateTime = sdf.format(new Date(time));
                        String endTime = sdf1.format(new Date(time));
                        params.put("endDateTime",endDateTime);
                        params.put("beginDateTime",beginDateTime);
                        params.put("statusArr",new String[]{"1"});
                        Integer thingCount = propertyEventService.countAllByParams(params);
                        beginDateTime = endDateTime;
                        countList.add(thingCount);
                        timeList.add(endTime);
                    }
                    //事件 处置率
                    Map<String,Object> eventPro = new HashMap<>();
                    Map<String,Object> thingResult = new HashMap<>();
                    thingResult.put("startTime",DateFormatUtils.format(DateUtils.getThisMonthMonday(),"yyyy-MM-dd HH:mm:ss"));
                    thingResult.put("statusArr","");
                    int propertyCount=propertyEventService.queryPropertyEventCount(thingResult);//物业事件总数
                    thingResult.put("eventSource",new String[]{"1"});
                    thingResult.put("eventStatus",new String[]{"3"});
                    int zhiEndCount=propertyEventService.queryPropertyEventCount(thingResult);//物业智慧检测
                    thingResult.put("eventSource",new String[]{"2","3"});
                    thingResult.put("eventStatus",new String[]{"3"});
                    int juEndCount=propertyEventService.queryPropertyEventCount(thingResult);//物业居民上报
                    thingResult.put("eventSource",new String[]{"5"});
                    thingResult.put("eventStatus",new String[]{"3"});
                    int xunEndCount=propertyEventService.queryPropertyEventCount(thingResult);//物业巡更巡防
                    //全部完成事件总数
                    int peopertyEndCount=zhiEndCount+juEndCount+xunEndCount;
                    if(propertyCount!=0){
                        zongHandleRate = divideTo(new BigDecimal(propertyCount),new BigDecimal(peopertyEndCount))+"%";//智慧检测事件处置占比
                        zhiHandleRate = divideTo(new BigDecimal(propertyCount),new BigDecimal(zhiEndCount))+"%";//智慧检测事件处置占比
                        juHandleRate = divideTo(new BigDecimal(propertyCount),new BigDecimal(juEndCount))+"%";//居民上报事件处置占比
                        xunHandleRate = divideTo(new BigDecimal(propertyCount),new BigDecimal(xunEndCount))+"%";//巡更巡防事件处置占比
                    }else{
                        zongHandleRate="0%";//总事件处置率
                        zhiHandleRate = "0%";//智慧检测事件处置占比
                        juHandleRate = "0%";//居民上报事件处置占比
                        xunHandleRate = "0%";//巡更巡防事件处置占比
                    }
                    eventPro.put("zongHandleRate",zongHandleRate);
                    eventPro.put("zhiHandleRate",zhiHandleRate);
                    eventPro.put("juHandleRate",juHandleRate);
                    eventPro.put("xunHandleRate",xunHandleRate);
                    chuList.add(eventPro);
                }
                //本周居民上报
                if(!StringUtils.isEmpty(nearlyAWeekBegin) && StringUtils.isEmpty(nearlyAWeekEnd)){
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                    params.clear();
                    //周返回天数段
                    long time = sdf.parse(nearlyAWeekBegin).getTime();
                    String beginDateTime = nearlyAWeekBegin;
                    for(int i = 1; i <= 7; i++){
                        time += 3600000*24;
                        String endDateTime = sdf.format(new Date(time));
                        String endTime = sdf1.format(new Date(time));
                        params.put("endDateTime",endDateTime);
                        params.put("beginDateTime",beginDateTime);
                        params.put("statusArr",new String[]{"2","3"});
                        Integer thingCount = propertyEventService.countAllByParams(params);
                        beginDateTime = endDateTime;
                        juList.add(thingCount);
                    }
                }
                //本月居民上报
                if(!StringUtils.isEmpty(nearlyAMonthBegin) && StringUtils.isEmpty(nearlyAMonthEnd)){
                    long days = DateUtil.betweenDay(DateUtil.offsetMonth(date, -1), date, false);
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                    params.clear();
                    //月返回天数段
                    long time = sdf.parse(nearlyAMonthBegin).getTime();
                    String beginDateTime = nearlyAMonthBegin;
                    for(int i = 1; i <= days; i++){
                        time += 3600000*24;
                        String endDateTime = sdf.format(new Date(time));
                        String endTime = sdf1.format(new Date(time));
                        params.put("endDateTime",endDateTime);
                        params.put("beginDateTime",beginDateTime);
                        params.put("statusArr",new String[]{"1"});
                        Integer thingCount = propertyEventService.countAllByParams(params);
                        beginDateTime = endDateTime;
                        juList.add(thingCount);
                    }
                }
                //本周巡更巡防
                if(!StringUtils.isEmpty(nearlyAWeekBegin) && StringUtils.isEmpty(nearlyAWeekEnd)){
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                    params.clear();
                    //周返回天数段
                    long time = sdf.parse(nearlyAWeekBegin).getTime();
                    String beginDateTime = nearlyAWeekBegin;
                    for(int i = 1; i <= 7; i++){
                        time += 3600000*24;
                        String endDateTime = sdf.format(new Date(time));
                        String endTime = sdf1.format(new Date(time));
                        params.put("endDateTime",endDateTime);
                        params.put("beginDateTime",beginDateTime);
                        params.put("statusArr",new String[]{"2","3"});
                        Integer thingCount = propertyEventService.countAllByParams(params);
                        beginDateTime = endDateTime;
                        xunList.add(thingCount);
                    }
                }
                //本月巡更巡防
                if(!StringUtils.isEmpty(nearlyAMonthBegin) && StringUtils.isEmpty(nearlyAMonthEnd)){
                    long days = DateUtil.betweenDay(DateUtil.offsetMonth(date, -1), date, false);
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                    params.clear();
                    //月返回天数段
                    long time = sdf.parse(nearlyAMonthBegin).getTime();
                    String beginDateTime = nearlyAMonthBegin;
                    for(int i = 1; i <= days; i++){
                        time += 3600000*24;
                        String endDateTime = sdf.format(new Date(time));
                        String endTime = sdf1.format(new Date(time));
                        params.put("endDateTime",endDateTime);
                        params.put("beginDateTime",beginDateTime);
                        params.put("statusArr",new String[]{"1"});
                        Integer thingCount = propertyEventService.countAllByParams(params);
                        beginDateTime = endDateTime;
                        xunList.add(thingCount);
                    }
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            data = new HashMap();
//            data.put("eventTrend",eventTrendCount);
            data.put("zhiTypeTrends",countList);
            data.put("zhiTrendDate",timeList);
            data.put("juTypeTrends",juList);
            data.put("xunTypeTrends",xunList);
            data.put("chuEventTrends",chuList);
            /*putEvents(eventType, data,type);*/
        }
        return AjaxResult.success(data);
    }


    /**
     * 小区概况
     */
    @RequestMapping("index/general")
    @ResponseBody
    public AjaxResult general(String housingEstate){
        Map<String,Object> params = new HashMap<>();
        Map<String,Object> thingResult = new HashMap<>();
        thingResult.put("housingEstate",housingEstate);
        int roomCount=iXlRoomService.queryRoomCount(thingResult);
        int chuRoomCount=xlLeaseService.queryRoomListCount(thingResult);
        int housingEstateCount=iXlPersonnelService.queryPersonCountAll(thingResult);
        thingResult.put("liveType","1");
        int liuCount=iXlPersonnelService.queryPersonCountAll(thingResult);
        thingResult.put("liveType","2");
        int huCount=iXlPersonnelService.queryPersonCountAll(thingResult);
        params.put("roomCount",roomCount);
        params.put("chuRoomCount",chuRoomCount);
        params.put("housingEstateCount",housingEstateCount);
        params.put("zuCount",liuCount);
        params.put("yeCount",huCount);
        return AjaxResult.success(params);
    }

    /**
     * 大屏城管--事件上报来源
     */
    @RequestMapping("index/urbanEventSource")
    @ResponseBody
    public AjaxResult eventSource(){
        Map<String,Object> params = new HashMap<>();
        Map<String,Object> thingResult = new HashMap<>();
        thingResult.put("startTime",DateFormatUtils.format(DateUtils.getThisMonthMonday(),"yyyy-MM-dd HH:mm:ss"));
        int count=eventService.eventSource(thingResult);
        thingResult.put("reportType",1);
        int zhiCount=eventService.eventSource(thingResult);
        String zhiRate = divideTo(new BigDecimal(count),new BigDecimal(zhiCount))+"%";//巡更巡防事件处置占比
        thingResult.put("reportType",2);
        int renCount=eventService.eventSource(thingResult);
        String renRate = divideTo(new BigDecimal(count),new BigDecimal(renCount))+"%";//巡更巡防事件处置占比
        params.put("count",count);
        params.put("zhiCount",zhiCount);
        params.put("renCount",renCount);
        params.put("zhiRate",zhiRate);
        params.put("renRate",renRate);
        return AjaxResult.success(params);
    }
    /**
     *事件中心--事件通知
     */
    @RequestMapping("index/eventNotice")
    @ResponseBody
    public AjaxResult eventNotice(){
        List list = new ArrayList<>();
        List<HkEventInfo> hkEventInfos=eventService.queryEventOne();
        for(int i=0;i<hkEventInfos.size();i++){
            Map<String,Object> thingResult = new HashMap<>();
            thingResult.put("eventId",hkEventInfos.get(i).getEventId());
            thingResult.put("riskLevel",hkEventInfos.get(i).getRiskLevel());
            thingResult.put("longitude",hkEventInfos.get(i).getLongitude());
            thingResult.put("latitude",hkEventInfos.get(i).getLatitude());
            list.add(thingResult);
        }
        return AjaxResult.success(list);
    }

    /**
     * 大屏首页--物业效能指数
     */
    @RequestMapping("index/propertyEfficiency")
    @ResponseBody
    public AjaxResult propertyEfficiency(){
        Map<String,Object> thingResult = new HashMap<>();
        Map<String,Object> params = new HashMap<>();
        List<XlEstateManagement> estateManagements=estateManagementService.queryPropertEfficiency();//物业信息
        int estate=estateManagementService.queryPropert(thingResult);//物业总数
        Integer ping =0;
        for(int i=0;i<estateManagements.size();i++){
            if(estateManagements.get(i).getEstateStar()==null){

            }else if(estateManagements.get(i).getEstateStar().equals("一星")){
                ping = ping+1;
            }else if(estateManagements.get(i).getEstateStar().equals("二星")){
                ping=ping+2;
            }else if(estateManagements.get(i).getEstateStar().equals("三星")){
                ping=ping+3;
            }else if(estateManagements.get(i).getEstateStar().equals("四星")){
                ping=ping+4;
            }else if(estateManagements.get(i).getEstateStar().equals("五星")){
                ping=ping+5;
            }
        }
        int average=ping/estate;//物业平均星级
        //当月事件整改数据
        thingResult.put("eventSource",new String[]{"4"});
        thingResult.put("startTime",DateFormatUtils.format(DateUtils.getThisMonthMonday(),"yyyy-MM-dd HH:mm:ss"));
        int xunEndCount=propertyEventService.queryPropertyEventCount(thingResult);//物业整改工程
        int endCount=propertyEventService.queryPropertyEndCount();
        params.put("average",average);
        params.put("zhengCount",xunEndCount);
        params.put("endCount",endCount);
        return AjaxResult.success(params);
    }

    /**
     *数智城管--城管事件列表
     */
    @RequestMapping("index/managementList")
    @ResponseBody
    public AjaxResult managementList(String reportType,String startTime,String endTime,Integer eventAlertStatus,String riskLevel){
        startPage();
       List list= new ArrayList<>();
        Map<String,Object> thingResult = new HashMap<>();
        thingResult.put("reportType",reportType);
        thingResult.put("startTime",startTime);
        thingResult.put("endTime",endTime);
        thingResult.put("eventAlertStatus",eventAlertStatus);
        if(riskLevel!=null &&reportType.equals("二级")){
            thingResult.put("riskLevel","99");
        }else if(riskLevel!=null &&reportType.equals("三级")){
            thingResult.put("riskLevel","999");
        }else{
            thingResult.put("riskLevel","1");
        }
        thingResult.put("riskLevel",riskLevel);
        List<HkEventInfo> hkEventInfos= eventService.queryeventChengInfo(thingResult);
        for(int i=0;i<hkEventInfos.size();i++){
            Map<String,Object> params = new HashMap<>();
            params.put("eventType",hkEventInfos.get(i).getEventType());
            params.put("cameraName",hkEventInfos.get(i).getCameraName());
            params.put("createTime",hkEventInfos.get(i).getCreateTime());
            params.put("longitude",hkEventInfos.get(i).getLongitude());
            params.put("latitude",hkEventInfos.get(i).getLatitude());
            params.put("eventStatus",hkEventInfos.get(i).getEventAlertStatus());
            params.put("cameraIndexCode",hkEventInfos.get(i).getCameraIndexCode());
            params.put("image",hkEventInfos.get(i).getEventImage());
            list.add(params);
        }
        return AjaxResult.success(list);
    }

    /**
     * 社区下拉框
     * @return
     */
    @RequestMapping("index/communityGrid")
    @ResponseBody
    public AjaxResult communityGrid(String communityName){
        List list = new ArrayList<>();
        //查询社区
//        Integer s=iSysRegionService.queryCommunit();
        SysRegion sysRegion = new SysRegion();
        sysRegion.setRegionName(communityName);
        List<SysRegion> regions=iSysRegionService.queryCommunitList(sysRegion);
        for(int i=0;i<regions.size();i++){
            Map<String,Object> thingResult = new HashMap<>();
            thingResult.put("deptName",regions.get(i).getRegionName());
            thingResult.put("deptId",regions.get(i).getRegionId());
            list.add(thingResult);
        }
        return AjaxResult.success(list);
    }

    /**
     * 根据社区选择网格
     */
    @RequestMapping("index/GridList")
    @ResponseBody
    public AjaxResult GridList(String grilName,Integer deptId){
        if(deptId == null){
            List list = new ArrayList<>();
            SysRegion sysRegion = new SysRegion();
            sysRegion.setRegionName(grilName);
            List<SysRegion> sysRegions = iSysRegionService.queryCommunitWangListAll(sysRegion);
            for(int i=0;i<sysRegions.size();i++){
                Map<String,Object> thingResult = new HashMap<>();
                thingResult.put("deptName",sysRegions.get(i).getRegionName());
                thingResult.put("deptId",sysRegions.get(i).getRegionId());
                list.add(thingResult);
            }
            return AjaxResult.success(list);
        }else{
            List list = new ArrayList<>();
            SysRegion sysRegion = new SysRegion();
            sysRegion.setParentId(String.valueOf(deptId));
            sysRegion.setRegionName(grilName);
            List<SysRegion> regions=iSysRegionService.queryCommunitWangList(sysRegion);
            for(int i=0;i<regions.size();i++){
                Map<String,Object> thingResult = new HashMap<>();
                thingResult.put("deptName",regions.get(i).getRegionName());
                thingResult.put("deptId",regions.get(i).getRegionId());
                list.add(thingResult);
            }
            return AjaxResult.success(list);
        }
    }

    /**
     * 数智城管--视频联动
     */
    @RequestMapping("index/managementEquipment")
    @ResponseBody
    public AjaxResult managementEquipment(){
        List list = new ArrayList<>();
        Map<String,Object> params = new HashMap<>();
        Map<String,Object> policeParams = new HashMap<>();
        List<XlEquipmentInfo> equipmentInfos=iXlEquipmentInfoService.queryEquipmentPoliceList();//城管设备信息
        for(int i=0;i<equipmentInfos.size();i++){
            Map<String,Object> thingResult = new HashMap<>();
            thingResult.put("equipmentName",equipmentInfos.get(i).getEquipmentName());
            thingResult.put("equipmentType",equipmentInfos.get(i).getEquipmentType());
            thingResult.put("deviceType",equipmentInfos.get(i).getDeviceType());
            thingResult.put("equipmentSerialNumber",equipmentInfos.get(i).getEquipmentSerialNumber());
            thingResult.put("equipmentModel",equipmentInfos.get(i).getEquipmentModel());
            thingResult.put("equipmentAdress",equipmentInfos.get(i).getEquipmentAdress());
            thingResult.put("longitude",equipmentInfos.get(i).getLongitude());
            thingResult.put("latitude",equipmentInfos.get(i).getLatitude());
            list.add(thingResult);
        }
        //城管设备总数
        params.put("equipmentOrganization","33011068");
        int policeCount=iXlEquipmentInfoService.queryEquipmentPoliceCount(params);
        //在线数
        params.put("equipmentStatus",1);
        int onLineCount=iXlEquipmentInfoService.queryEquipmentPoliceCount(params);
        //离线数
        params.put("equipmentStatus",0);
        int offLineCount=iXlEquipmentInfoService.queryEquipmentPoliceCount(params);
        policeParams.put("policeCount",policeCount);
        policeParams.put("onLineCount",onLineCount);
        policeParams.put("offLineCount",offLineCount);
        list.add(policeParams);
        return AjaxResult.success(list);
    }

    /**
     * 垃圾车定位推动
     */
    @RequestMapping("index/garbageTruck")
    @ResponseBody
    public AjaxResult garbageTruck(String startTime,String endTime){
            Map<String,Object> policeParams = new HashMap<>();
            policeParams.put("startTime",startTime);
            policeParams.put("endTime",endTime);
            List list=new ArrayList<>();
            List<XlGpsWeigh>  xlGpsWeighs=locationReqService.queryGarbageList(policeParams);
            for(int i=0;i<xlGpsWeighs.size();i++){
                Map<String,Object> params = new HashMap<>();
                params.put("licensePlate",xlGpsWeighs.get(i).getLicensePlate());
                params.put("locationSim",xlGpsWeighs.get(i).getLocationSim());
                params.put("tripartLng",xlGpsWeighs.get(i).getTripartLng());
                params.put("tripartLat",xlGpsWeighs.get(i).getTripartLat());
                params.put("tripartHeight",xlGpsWeighs.get(i).getTripartHeight());
                params.put("tripartSpeed",xlGpsWeighs.get(i).getTripartSpeed());
                params.put("tripartDirection",xlGpsWeighs.get(i).getTripartDirection());
                params.put("recortTime",xlGpsWeighs.get(i).getRecortTime());
                list.add(params);
            }
            return AjaxResult.success(list);
    }

    /**
     * 2D--车辆
     */
    @RequestMapping("index/vehicleInfo")
    @ResponseBody
    public AjaxResult vehicleInfo(String startTime,String endTime,String tripartName){
        if(tripartName==null){
            Map<String,Object> policeParams = new HashMap<>();
            policeParams.put("startTime",startTime);
            policeParams.put("endTime",endTime);
            List list=new ArrayList<>();
            List<XlGpsWeigh>  xlGpsWeighs=locationReqService.queryGarbageListAll(policeParams);
            for(int i=0;i<xlGpsWeighs.size();i++){
                Map<String,Object> params = new HashMap<>();
                params.put("licensePlate",xlGpsWeighs.get(i).getLicensePlate());
                params.put("locationSim",xlGpsWeighs.get(i).getLocationSim());
                params.put("tripartLng",xlGpsWeighs.get(i).getTripartLng());
                params.put("tripartLat",xlGpsWeighs.get(i).getTripartLat());
                //经纬度数组. 纬度-经度
                double[] convertPoint = GPSUtils.gcj02_To_Bd09(Double.parseDouble(xlGpsWeighs.get(i).getTripartLat()), Double.parseDouble(xlGpsWeighs.get(i).getTripartLng()));
//                System.out.println(convertPoint[1]+"----------"+convertPoint[0]);
                Double[] points = {convertPoint[1], convertPoint[0]};
                Map<String, Object> map1 = hkMapService.calculateRegionByLongitudeAndLatitude(points);
                String regionCode = map1.get("regionId") + "";
                String regionName = map1.get("regionName") + "";
                params.put("regionName",regionName);
                params.put("tripartHeight",xlGpsWeighs.get(i).getTripartHeight());
                params.put("tripartSpeed",xlGpsWeighs.get(i).getTripartSpeed());
                params.put("tripartDirection",xlGpsWeighs.get(i).getTripartDirection());
                params.put("recortTime",xlGpsWeighs.get(i).getRecortTime());
                params.put("wasteCar",xlGpsWeighs.get(i).getTripartName());
                list.add(params);
            }
            return AjaxResult.success(list);
        }else if(tripartName.equals("waste")){
            Map<String,Object> policeParams = new HashMap<>();
            policeParams.put("startTime",startTime);
            policeParams.put("endTime",endTime);
            List list=new ArrayList<>();
            List<XlGpsWeigh>  xlGpsWeighs=locationReqService.queryGarbageList(policeParams);
            for(int i=0;i<xlGpsWeighs.size();i++){
                Map<String,Object> params = new HashMap<>();
                params.put("licensePlate",xlGpsWeighs.get(i).getLicensePlate());
                params.put("locationSim",xlGpsWeighs.get(i).getLocationSim());
                params.put("tripartLng",xlGpsWeighs.get(i).getTripartLng());
                params.put("tripartLat",xlGpsWeighs.get(i).getTripartLat());
                //经纬度数组. 纬度-经度
                double[] convertPoint = GPSUtils.gcj02_To_Bd09(Double.parseDouble(xlGpsWeighs.get(i).getTripartLat()), Double.parseDouble(xlGpsWeighs.get(i).getTripartLng()));
//                System.out.println(convertPoint[1]+"----------"+convertPoint[0]);
                Double[] points = {convertPoint[1], convertPoint[0]};
                Map<String, Object> map1 = hkMapService.calculateRegionByLongitudeAndLatitude(points);
                String regionCode = map1.get("regionId") + "";
                String regionName = map1.get("regionName") + "";
                params.put("regionName",regionName);
                params.put("tripartHeight",xlGpsWeighs.get(i).getTripartHeight());
                params.put("tripartSpeed",xlGpsWeighs.get(i).getTripartSpeed());
                params.put("tripartDirection",xlGpsWeighs.get(i).getTripartDirection());
                params.put("recortTime",xlGpsWeighs.get(i).getRecortTime());
                params.put("wasteCar",xlGpsWeighs.get(i).getTripartName());
                list.add(params);
            }
            return AjaxResult.success(list);
        }else if(tripartName.equals("sprinkle")){
            List list=new ArrayList<>();
            return AjaxResult.success(list);
        }
        return AjaxResult.success();
    }

    /**
     *户主下拉框
     */
    @RequestMapping("index/householder")
    @ResponseBody
    public AjaxResult householder(String name){
//        startPage();
        List list=new ArrayList<>();
        Map<String,Object> params = new HashMap<>();
        params.put("name",name);
        List<XlPersonnel> xlPersonnels=iXlPersonnelService.queryPersonHu(params);
        for(int i=0;i<xlPersonnels.size();i++){
            Map<String,Object> thingResult = new HashMap<>();
            thingResult.put("name",xlPersonnels.get(i).getName());
            thingResult.put("nameId",xlPersonnels.get(i).getId());
            list.add(thingResult);
        }
        return AjaxResult.success(list);
    }

    /**
     * 查询房屋地址
     */
    @RequestMapping("index/rommAdress")
    @ResponseBody
    public AjaxResult rommAdress(Integer nameId){
        if(nameId ==null){
            return AjaxResult.success("请填写用户id");
        }else{
            Map<String,Object> params = new HashMap<>();
            String villageCode=iXlPersonnelService.queryPersonVillageCode(nameId);
            if(villageCode == null){
                return AjaxResult.success(params);
            }else{
                Integer roomId=Integer.parseInt(villageCode);
                String adress=iXlRoomService.queryRoomAdress(roomId);
                params.put("adress",adress);
                return AjaxResult.success(params);
            }

        }
    }

    /**
     * 查询物业下拉框
     */
    @RequestMapping("index/propertyDown")
    @ResponseBody
    public AjaxResult propertyDown(String propertyName){
        XlEstateManagement xlEstateManagement = new XlEstateManagement();
        xlEstateManagement.setEstateName(propertyName);
        List<XlEstateManagement> estateManagements=estateManagementService.queryPropertyDownName(xlEstateManagement);
        List list = new ArrayList<>();
        for(int i=0;i<estateManagements.size();i++){
            Map<String,Object> params = new HashMap<>();
            params.put("propertyName",estateManagements.get(i).getEstateName());
            params.put("propertyId",estateManagements.get(i).getId());
            list.add(params);
        }
        return AjaxResult.success(list);
    }
    /**
     * 星级统计
     */
    @RequestMapping("index/starStatistics")
    @ResponseBody
    public AjaxResult starStatistics(){
        List list = new ArrayList<>();
        Map<String,Object> paramsAll = new HashMap<>();
        Map<String,Object> paramsOne = new HashMap<>();
        Map<String,Object> paramsTwo = new HashMap<>();
        Map<String,Object> paramsThree = new HashMap<>();
        Map<String,Object> paramsFour = new HashMap<>();
        Map<String,Object> paramsFive = new HashMap<>();
        Map<String,Object> params = new HashMap<>();
        Map<String,Object> thingResult = new HashMap<>();
        int estateManagements=estateManagementService.queryPropert(thingResult);//物业总数
        thingResult.put("statusArr","一星");//一星物业总数
        int oneStar=estateManagementService.queryPropert(thingResult);
        thingResult.put("statusArr","二星");//二星物业总数
        int twoStar=estateManagementService.queryPropert(thingResult);
        thingResult.put("statusArr","三星");//三星物业总数
        int threeStar=estateManagementService.queryPropert(thingResult);
        thingResult.put("statusArr","四星");//四星物业总数
        int fourStar=estateManagementService.queryPropert(thingResult);
        thingResult.put("statusArr","五星");//五星物业总数
        int fiveStar=estateManagementService.queryPropert(thingResult);
        String oneStarProportion = divideTo(new BigDecimal(estateManagements),new BigDecimal(oneStar))+"%";
//        String twoStarProportion=(float)twoStar/(float)estateManagements*100+"%";//二星占比
        String twoStarProportion = divideTo(new BigDecimal(estateManagements),new BigDecimal(twoStar))+"%";
//        String threeStarProportion=(float)threeStar/(float)estateManagements*100+"%";//三星占比
        String threeStarProportion = divideTo(new BigDecimal(estateManagements),new BigDecimal(threeStar))+"%";
//        String fourStarProportion=(float)fourStar/(float)estateManagements*100+"%";//四星占比
        String fourStarProportion = divideTo(new BigDecimal(estateManagements),new BigDecimal(fourStar))+"%";
//        String fiveStarProportion=(float)fiveStar/(float)estateManagements*100+"%";//五星占比
        String fiveStarProportion = divideTo(new BigDecimal(estateManagements),new BigDecimal(fiveStar))+"%";
        paramsOne.put("star","一星");
        paramsOne.put("count",oneStar);
        paramsOne.put("starProportion",oneStarProportion);
        paramsTwo.put("star","二星");
        paramsTwo.put("count",twoStar);
        paramsTwo.put("starProportion",twoStarProportion);
        paramsThree.put("star","三星");
        paramsThree.put("count",threeStar);
        paramsThree.put("starProportion",threeStarProportion);
        paramsFour.put("star","四星");
        paramsFour.put("count",fourStar);
        paramsFour.put("starProportion",fourStarProportion);
        paramsFive.put("star","五星");
        paramsFive.put("count",fiveStar);
        paramsFive.put("starProportion",fiveStarProportion);
        list.add(paramsOne);
        list.add(paramsTwo);
        list.add(paramsThree);
        list.add(paramsFour);
        list.add(paramsFive);
        return AjaxResult.success(list);
    }

    /**
     * 部门下拉框
     */
    @RequestMapping("index/deptDown")
    @ResponseBody
    public AjaxResult deptDown(String deptName){
        SysDept sysDept = new SysDept();
        sysDept.setDeptName(deptName);
        List<SysDept> depts=deptService.queryDeptNameAll(sysDept);
        List list = new ArrayList<>();
        for(int i=0;i<depts.size();i++){
            Map<String,Object> params = new HashMap<>();
            params.put("deptALlName",depts.get(i).getDeptName());
            params.put("deptAllId",depts.get(i).getDeptId());
            list.add(params);
        }
        return AjaxResult.success(list);
    }

    /**
     * 五色图-事件
     */
    @RequestMapping("index/wanggeEventCount")
    @ResponseBody
    public AjaxResult wanggeEventCount(String eventType,String startTime,String endTime,String status,String grade){
        SysRegion sysRegion = new SysRegion();
        List list = new ArrayList<>();
        List<SysRegion> sysRegions=iSysRegionService.queryCommunitList(sysRegion);
        for(int i=0;i<sysRegions.size();i++){
            Long regionId = sysRegions.get(i).getRegionId();
            sysRegion.setParentId(String.valueOf(regionId));
            List<SysRegion> grilList= iSysRegionService.queryGrilName(sysRegion);
            for(int j=0;j<grilList.size();j++){
                String gradeType=null;
                Map<String,Object> paramsAll = new HashMap<>();
                Map<String,Object> params = new HashMap<>();
                Long regionCode = grilList.get(j).getRegionId();
                paramsAll.put("eventType",eventType);
                paramsAll.put("startTime",startTime);
                paramsAll.put("endTime",endTime);
                paramsAll.put("status",status);
                if(grade==null){

                }else if(grade.equals("二级")){
                    gradeType="99";
                }else if(grade.equals("三级")){
                    gradeType="999";
                }else{
                    gradeType="1";
                }
                paramsAll.put("grade",gradeType);
                paramsAll.put("regionIndexCode",regionCode);
                int count=eventService.queryeventCountAll(paramsAll);
                paramsAll.put("statusArr",new String[]{"2"});
                int weiCount=eventService.queryeventCountAll(paramsAll);
                paramsAll.put("statusArr",new String[]{"3","5"});
                int chuCount=eventService.queryeventCountAll(paramsAll);
                paramsAll.put("statusArr",new String[]{"6","7","9"});
                int endCount=eventService.queryeventCountAll(paramsAll);
                params.put("regionId",grilList.get(j).getRegionId());
                params.put("grilName",grilList.get(j).getRegionName());
                params.put("eventCount",count);
                params.put("weiCount",weiCount);
                params.put("chuCount",chuCount);
                params.put("endCount",endCount);
                list.add(params);
            }
        }
        return AjaxResult.success(list);
    }

    /**
     * 五色图--人员

     * @return
     */
    @RequestMapping("index/fiveColorDiagramPerson")
    @ResponseBody
    public AjaxResult fiveColorDiagramPerson(String personName,String phone,String idcard,String liveType,String nativePlace,String polity,String villageName,String ethnicGroup){
        SysRegion sysRegion = new SysRegion();
        List list = new ArrayList<>();
        List<SysRegion> sysRegions=iSysRegionService.queryCommunitList(sysRegion);
        for(int i=0;i<sysRegions.size();i++){
            Long regionId = sysRegions.get(i).getRegionId();
            sysRegion.setParentId(String.valueOf(regionId));
            List<SysRegion> grilList= iSysRegionService.queryGrilName(sysRegion);
            for(int j=0;j<grilList.size();j++){
                Long regionCode = grilList.get(j).getRegionId();
                Map<String,Object> paramsAll = new HashMap<>();
                Map<String,Object> params = new HashMap<>();
                paramsAll.put("personName",personName);
                paramsAll.put("phone",phone);
                paramsAll.put("idcard",idcard);
                paramsAll.put("liveType",liveType);
                paramsAll.put("nativePlace",nativePlace);
                paramsAll.put("polity",polity);
                paramsAll.put("villageName",villageName);
                paramsAll.put("ethnicGroup",ethnicGroup);
                paramsAll.put("regionIndexCode",regionCode);
                Integer personnels=iXlPersonnelService.queryPersonAllList(paramsAll);
                paramsAll.put("statusArr",new String[]{"1"});
                Integer liupersonnels=iXlPersonnelService.queryPersonAllList(paramsAll);
                paramsAll.put("statusArr",new String[]{"2"});
                Integer hupersonnels=iXlPersonnelService.queryPersonAllList(paramsAll);
                params.put("regionId",regionCode);
                params.put("grilName",grilList.get(j).getRegionName());
                params.put("personnelsCount",personnels);
                params.put("liupersonnels",liupersonnels);
                params.put("hupersonnels",hupersonnels);
                list.add(params);
            }
        }
        return AjaxResult.success(list);
    }

    /**
     * 五色图--房屋
     */
    @RequestMapping("index/fiveColorDiagramRoom")
    @ResponseBody
    public AjaxResult fiveColorDiagramRoom(String communityName,String roomType,String roomLiveType,String villageName,String blurred){
        SysRegion sysRegion = new SysRegion();
        List list = new ArrayList<>();
        List<SysRegion> sysRegions=iSysRegionService.queryCommunitList(sysRegion);
        for(int i=0;i<sysRegions.size();i++){
            Long regionId = sysRegions.get(i).getRegionId();
            sysRegion.setParentId(String.valueOf(regionId));
            List<SysRegion> grilList= iSysRegionService.queryGrilName(sysRegion);
            for(int j=0;j<grilList.size();j++){
                Long regionCode = grilList.get(j).getRegionId();
                Map<String,Object> paramsAll = new HashMap<>();
                Map<String,Object> params = new HashMap<>();
                paramsAll.put("communityName",communityName);
                paramsAll.put("roomType",roomType);
                paramsAll.put("roomLiveType",roomLiveType);
                paramsAll.put("villageName",villageName);
                paramsAll.put("blurred",blurred);
                paramsAll.put("regionIndexCode",regionCode);
                Integer xlRoomsCount=iXlRoomService.queryRoomListCount(paramsAll);
                paramsAll.put("statusArr",new String[]{"1"});
                Integer sahngXlRooms=iXlRoomService.queryRoomListCount(paramsAll);
                paramsAll.put("statusArr",new String[]{"2"});
                Integer ziXlRooms=iXlRoomService.queryRoomListCount(paramsAll);
                params.put("regionId",regionCode);
                params.put("grilName",grilList.get(j).getRegionName());
                params.put("xlRoomsCount",xlRoomsCount);
                params.put("sahngXlRooms",sahngXlRooms);
                params.put("ziXlRooms",ziXlRooms);
                list.add(params);
            }
        }
        return AjaxResult.success(list);
    }

    /**
     * 五色图---企业
     */
    @RequestMapping("index/fiveColorDiagramEnterprise")
    @ResponseBody
    public AjaxResult fiveColorDiagramEnterprise(){

        return AjaxResult.success();
    }

    /**
     * 五色图---设备
     */
    @RequestMapping("index/fiveColorDiagramEquipment")
    @ResponseBody
    public AjaxResult fiveColorDiagramEquipment(){
        return AjaxResult.success();
    }

    /**
     * 热力图--事件
     */
    @RequestMapping("index/heatingPowerEvent")
    @ResponseBody
    public AjaxResult heatingPowerEvent(String status){
        Map<String,Object> thingResult = new HashMap<>();
        thingResult.put("eventType",status);
        List list = new ArrayList<>();
        List<EventListCountVo> eventListCountVos=eventService.queryLongitude(thingResult);
        for(int i=0;i<eventListCountVos.size();i++){
            Map<String,Object> params = new HashMap<>();
            params.put("count",eventListCountVos.get(i).getCount());
            params.put("longitude",eventListCountVos.get(i).getLongitude());
            params.put("latitude",eventListCountVos.get(i).getLatitude());
            list.add(params);
        }
        return AjaxResult.success(list);
    }

    /**
     * 热力图--房屋
     */
    @RequestMapping("index/heatingPowerRoom")
    @ResponseBody
    public AjaxResult heatingPowerRoom(){
        return AjaxResult.success();
    }

    /**
     * 热力图--人员
     */
    @RequestMapping("index/heatingPowerPerson")
    @ResponseBody
    public AjaxResult heatingPowerPerson(){
        return AjaxResult.success();
    }

    /**
     * 热力图--企业
     */
    @RequestMapping("index/heatingPowerEnterprise")
    @ResponseBody
    public AjaxResult heatingPowerEnterprise(){
        return AjaxResult.success();
    }

    /**
     * 热力图--设备
     */
    @RequestMapping("index/heatingPowerEquipment")
    @ResponseBody
    public AjaxResult heatingPowerEquipment(String type){
        Map<String,Object> thingResult = new HashMap<>();
        thingResult.put("eventType",type);
        List list = new ArrayList<>();
        List<EventListCountVo> eventListCountVos=iXlEquipmentInfoService.queryEquipmentLongitude(thingResult);
        for(int i=0;i<eventListCountVos.size();i++){
            Map<String,Object> params = new HashMap<>();
            params.put("count",eventListCountVos.get(i).getCount());
            params.put("longitude",eventListCountVos.get(i).getLongitude());
            params.put("latitude",eventListCountVos.get(i).getLatitude());
            list.add(params);
        }
        return AjaxResult.success(list);
    }


    /**
     * 事件中心-事件量排名，按事件总数倒序
     */
    @RequestMapping("index/eventCountSort")
    @ResponseBody
    public AjaxResult eventCountSort(String type,Integer showCount){
        if(type.equals("community")){
            SysRegion sysRegion = new SysRegion();
            List list = new ArrayList<>();
            List<SysRegion> sysRegions=iSysRegionService.queryCommunitList(sysRegion);
            Integer communityCount=0;
            for(int i=0;i<sysRegions.size();i++){
                Long regionId = sysRegions.get(i).getRegionId();
                sysRegion.setParentId(String.valueOf(regionId));
                List<SysRegion> grilList= iSysRegionService.queryGrilName(sysRegion);
                for(int j=0;j<grilList.size();j++){
                    Long regionCode = grilList.get(j).getRegionId();
                    Map<String,Object> paramsAll = new HashMap<>();
                    Map<String,Object> params = new HashMap<>();
                    paramsAll.put("regionIndexCode",regionCode);
                    int count=eventService.queryeventCountAll(paramsAll);
                    communityCount = communityCount+count;
                    if(j==grilList.size()-1){
                        params.put("communityName",sysRegions.get(i).getRegionName());
                        params.put("communityEventCount",communityCount);
                        list.add(params);
                        communityCount=0;
                        if(showCount !=null && showCount !=0){
                            showCount = showCount-1;
                            if(showCount == 0){
                                return AjaxResult.success(list);
                            }
                        }

                    }
                }
            }
            return AjaxResult.success(list);
        }else if(type.equals("department")){
            return AjaxResult.success();
        }
        return AjaxResult.success();
    }

    /**
     * 事件处置率
     */
    @RequestMapping("index/disposalRate")
    @ResponseBody
    public AjaxResult disposalRate(String type,Integer showCount){
        if(type.equals("community")){
            SysRegion sysRegion = new SysRegion();
            List list = new ArrayList<>();
            List<SysRegion> sysRegions=iSysRegionService.queryCommunitList(sysRegion);
            Integer communityCount=0;
            Integer EndEventCount = 0;
            for(int i=0;i<sysRegions.size();i++){
                Long regionId = sysRegions.get(i).getRegionId();
                sysRegion.setParentId(String.valueOf(regionId));
                List<SysRegion> grilList= iSysRegionService.queryGrilName(sysRegion);
                for(int j=0;j<grilList.size();j++){
                    Long regionCode = grilList.get(j).getRegionId();
                    Map<String,Object> paramsAll = new HashMap<>();
                    Map<String,Object> params = new HashMap<>();
                    paramsAll.put("regionIndexCode",regionCode);
                    int count=eventService.queryeventCountAll(paramsAll);
                    communityCount = communityCount+count;
                    paramsAll.put("statusArr",new String[]{"6","7","9"});
                    int endcount=eventService.queryeventCountAll(paramsAll);
                    EndEventCount=EndEventCount+endcount;
                    if(j==grilList.size()-1){
                        String eventProportion="";
                        params.put("communityName",sysRegions.get(i).getRegionName());
                        if(communityCount == 0){
                           eventProportion="0%";
                            params.put("eventProportion",eventProportion);
                        }else{
                            eventProportion = divideTo(new BigDecimal(communityCount),new BigDecimal(EndEventCount))+"%";
                            params.put("eventProportion",eventProportion);
                        }
                        list.add(params);
                        communityCount=0;
                        if(showCount !=null && showCount !=0){
                            showCount = showCount-1;
                            if(showCount == 0){
                                return AjaxResult.success(list);
                            }
                        }

                    }
                }
            }
            return AjaxResult.success(list);
        }else if(type.equals("department")){
            List list = new ArrayList<>();
            return AjaxResult.success(list);
        }
        return AjaxResult.success();
    }

    /**
     * 小区分页查询事件
     */
    @RequestMapping("index/villageEventAll")
    @ResponseBody
    public AjaxResult villageEventAll(Integer villageId,String startTime,String endTime,Integer eventSource){
        startPage();
        Map<String,Object> paramsAll = new HashMap<>();
        List list = new ArrayList<>();
        paramsAll.put("villageId",villageId);
        paramsAll.put("startTime",startTime);
        paramsAll.put("endTime",endTime);
        paramsAll.put("eventSource",eventSource);
        List<XlPropertyAndVillageVo> xlPropertyAndVillageVos= propertyEventService.queryVillageEvent(paramsAll);
        for(int i=0;i<xlPropertyAndVillageVos.size();i++){
            Map<String,Object> params = new HashMap<>();
            params.put("propertyEventSource",xlPropertyAndVillageVos.get(i).getEventSource());
            params.put("propertyEventType",xlPropertyAndVillageVos.get(i).getEventType());
            params.put("propertyEventStatus",xlPropertyAndVillageVos.get(i).getEventStatus());
            params.put("createTime",xlPropertyAndVillageVos.get(i).getCreateTime());
            list.add(params);
        }
        return AjaxResult.success(list);
    }


/*    @RequestMapping("ceshi")
    @ResponseBody
    public AjaxResult ceshi (@RequestParam("list[]") String[] list){
        System.out.println(list);
        return AjaxResult.success();
    }*/
    /**
     * 组装查询日期范围
     * @param type
     * @return
     */
    public Map<String,Object> EventDate(String type,Date date){
        Map<String,Object> map = new HashMap<>();
        if("day".equals(type)){
            //当天日期
            //map.put("currentDate",DateFormatUtils.format(new Date(),"yyyy-MM-dd"));
            //近一天
            map.put("nearlyADayBegin",DateUtil.offsetDay(date, -1).toString());
        }else if("week".equals(type)){
            //本周一
//            map.put("nearlyAWeekBegin",DateFormatUtils.format(DateUtils.getThisWeekMonday(),"yyyy-MM-dd HH:mm:ss"));
            //近一周
            map.put("nearlyAWeekBegin",DateUtil.offsetWeek(date, -1).toString());
        }else if("month".equals(type)){
            //本月一号
//            map.put("nearlyAMonthBegin",DateFormatUtils.format(DateUtils.getThisMonthMonday(),"yyyy-MM-dd HH:mm:ss"));
            //近一月
            map.put("nearlyAMonthBegin",DateUtil.offsetMonth(date, -1).toString());
        }else if("year".equals(type)){
            //近一年
            map.put("nearlyAYearBegin",DateUtils.getNearlyYear(date,-1));
        }
        return map;
    }


    /**
     * 组装查询日期范围
     * @param type
     * @return
     */
    public Map<String,Object> EventDateType(String type,Date date){
        Map<String,Object> map = new HashMap<>();
        if("day".equals(type)){
            //当天日期
            //map.put("currentDate",DateFormatUtils.format(new Date(),"yyyy-MM-dd"));
            //近一天
            map.put("nearlyADayBegin",DateUtil.offsetDay(date, -1).toString());
        }else if("week".equals(type)){
            //本周一
            map.put("nearlyAWeekBegin",DateFormatUtils.format(DateUtils.getThisWeekMonday(),"yyyy-MM-dd HH:mm:ss"));
            //近一周
//            map.put("nearlyAWeekBegin",DateUtil.offsetWeek(date, -1).toString());
        }else if("month".equals(type)){
            //本月一号
            map.put("nearlyAMonthBegin",DateFormatUtils.format(DateUtils.getThisMonthMonday(),"yyyy-MM-dd HH:mm:ss"));
            //近一月
//            map.put("nearlyAMonthBegin",DateUtil.offsetMonth(date, -1).toString());
        }else if("year".equals(type)){
            //近一年
            map.put("nearlyAYearBegin",DateUtils.getNearlyYear(date,-1));
        }
        return map;
    }
    private String divideTo(BigDecimal num,BigDecimal num1){
        BigDecimal divide = num1.divide(num,4, RoundingMode.HALF_UP);
        BigDecimal bigDecimal = new BigDecimal(100);
        BigDecimal bignum3 = divide.multiply(bigDecimal);
        BigDecimal bigDecimal1 = bignum3.setScale(2, BigDecimal.ROUND_HALF_UP);
//        BigDecimal bigDecimal = divide.setScale(2, BigDecimal.ROUND_HALF_UP);
//        System.out.println(bigDecimal);
        return bigDecimal1.toString();
    }

    /*@RequestMapping("shuju")
    @ResponseBody
    public AjaxResult shuju(){
        List<XlRoom> xlRooms=iXlRoomService.selectXlPersonnelListAll();
        for(int i=0;i<xlRooms.size();i++){
            if(xlRooms.get(i).getVillageName() !=null){
                String villageName = xlRooms.get(i).getVillageName();
                List<XlVillageModel> xlVillageModels=villageService.selectVillageId(villageName);
                if(xlVillageModels.size() ==1){
                    Long id = xlVillageModels.get(0).getId();
                    Map<String,Object> thingResult = new HashMap<>();
                    thingResult.put("villageName",villageName);
                    thingResult.put("villageid",id);
                    iXlRoomService.updatePersonVillageId(thingResult);
                }
            }
        }
        return AjaxResult.success();
    }*/

    /*@RequestMapping("shuju1")
    @ResponseBody
    public AjaxResult shuju1(){
        XlPersonnel xlPersonnel = new XlPersonnel();
        List<XlPersonnel> xlPersonnelList=iXlPersonnelService.selectXlPersonnelListAll();
        for(int i=0;i<xlPersonnelList.size();i++){
            String address = xlPersonnelList.get(i).getAddress();
            List<XlRoom> xlRooms=iXlRoomService.queryRoomId(address);
            if(xlRooms.size()==1){
                Long id = xlRooms.get(0).getId();
                Map<String,Object> thingResult = new HashMap<>();
                thingResult.put("address",address);
                thingResult.put("villageCode",id);
                iXlPersonnelService.updatePersonVillageId(thingResult);
            }
        }
        return AjaxResult.success();
    }*/
    //
   /* public static void main(String[] args) {
        *//*String time ="年";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_YEAR,1);
        calendar.add(Calendar.YEAR,-1);
        Date time = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(time);
        System.out.println(format);
        if(time.equals("月")){
            System.out.println("月");
        }else if(time.equals("年")){
            System.out.println("年");
        }else{
            System.out.println("周");
        }*//*
    }*/
}
