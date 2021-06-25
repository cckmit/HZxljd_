package com.ruoyi.web.controller.hkApi;


import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import com.ruoyi.common.config.HkwsConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.map.GPSUtils;
import com.ruoyi.quartz.domain.SysJobLog;
import com.ruoyi.quartz.service.ISysJobLogService;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.domain.HkEntity.*;
import com.ruoyi.system.domain.platform.camera.cameraParm;
import com.ruoyi.system.domain.platform.zheLiFang.ZheLiFangDto;
import com.ruoyi.system.service.HkEarlyWarning.HkEventService;
import com.ruoyi.system.service.IHkMapService;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.IXlEquipmentInfoService;
import com.ruoyi.system.service.app.AppEventDetailService;
import com.ruoyi.system.utils.MD5Util;
import com.ruoyi.system.domain.platform.managementCM.management;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/hkapi")
public class HkApi {
    @Autowired
    private ISysDeptService iSysDeptService;
    @Autowired
    private HkEventService hkEventService;
    @Autowired
    private IXlEquipmentInfoService iXlEquipmentInfoService;
    @Autowired
    private  IHkMapService hkMapService;


    @Value("${hkapi.ak}")
    public String ak;

    @Value("${hkapi.sk}")
    public String sk;


    /**
     * 订阅接口
     * */
    @GetMapping("/subscribe")
    @ResponseBody
    public AjaxResult appSubscribe(){
        ces();
        return AjaxResult.success("成功");

    }


    /**
     * 获取当前区域信息
     * */
    @GetMapping("/qyinfo")
    @ResponseBody
    public AjaxResult hkqyinfo(){
        //通过qyinfo() 去调deptAll()方法进行添加数据
        qyinfo();
        return AjaxResult.success("成功");

    }


    /**
     * 获取当前区域信息
     * */
    @PostMapping("/beedback")
    @ResponseBody
    public AjaxResult qyinfoList(){
//        eventFeedback();
        return AjaxResult.success("成功");

    }



    public static void main(String[] args) throws ParseException {
        HkApi api = new HkApi();
//        api.hkinfo();
        api.sheAll();
//        api.ces();
//        storeFetch();
//        api.qyinfo();
//        api.eventFeedback();
        /*qyinfouser();
        pointproposal();
        pointproposal();*/
//        api.eventFeedback();
    }
    private  void ces() {
        ArtemisConfig.host=HkwsConfig.host;
        ArtemisConfig.appKey = HkwsConfig.appKey;
        ArtemisConfig.appSecret = HkwsConfig.appSecret;
        final String getSecurityApi = HkwsConfig.subscribe; // 接口路径
        Map<String, String> path = new HashMap<String,String>(2) {
            {
                put("https://", getSecurityApi);
            }
        };
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isSubscribe",true);
        jsonObject.put("subscribeId","上海泺冉");
        jsonObject.put("callbackAddress","http://172.45.4.111:80/hkapi/callbackUrl");
        String body = jsonObject.toJSONString();
        String res = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, "application/json");
        System.out.println("==============="+res);
    }
    //获取实时视频播放流
    private  void previewUrl() {
        ArtemisConfig.host=HkwsConfig.host;
        ArtemisConfig.appKey = HkwsConfig.appKey;
        ArtemisConfig.appSecret = HkwsConfig.appSecret;
        final String getSecurityApi = HkwsConfig.previewUrl; // 接口路径
        Map<String, String> path = new HashMap<String,String>(2) {
            {
                put("https://", getSecurityApi);
            }
        };
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cameraIndexCode", "33011068001321112507");
        jsonObject.put("protocol", "hls");
        jsonObject.put("expand","transcode=1&videotype=h264");
        String body = jsonObject.toJSONString();
        String res = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, "application/json");
        System.out.println("==============="+res);
    }
    //海康城管
//    @Scheduled(cron="0 */10 * * * ?")
    public void cg() throws ParseException {
        ArtemisConfig.host=HkwsConfig.host;
        ArtemisConfig.appKey = HkwsConfig.appKey;
        ArtemisConfig.appSecret = HkwsConfig.appSecret;
        final String getSecurityApi = HkwsConfig.eventcg; // 接口路径
        Map<String, String> path = new HashMap<String,String>(2) {
            {
                put("https://", getSecurityApi);
            }
        };
        JSONObject jsonbody = new JSONObject();
        DateFormat datef =  new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH,0);
        String StartTime=datef.format(cal.getTime())+"T00:00:00.000+08:00";
        String EndTime=datef.format(cal.getTime())+"T023:59:59.999+08:00";
        jsonbody.put("beginTime",StartTime);
        jsonbody.put("endTime",EndTime);
        String body = jsonbody.toJSONString();
        String res = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, "application/json");
        JSONObject jsonObject = JSONObject.parseObject(res);
//        JSONArray data = jsonObject.getJSONArray("data");
        management Passinfo= JSONObject.parseObject(jsonObject.toString(), management.class);
        geteventcg(Passinfo);
    }
    @RequestMapping("cameraAll")
    @ResponseBody
    public void sheAll() throws ParseException {
        ArtemisConfig.host=HkwsConfig.host;
        ArtemisConfig.appKey = HkwsConfig.appKey;
        ArtemisConfig.appSecret = HkwsConfig.appSecret;
        final String getSecurityApi = HkwsConfig.sheXiangAll; // 接口路径
        Map<String, String> path = new HashMap<String,String>(2) {
            {
                put("https://", getSecurityApi);
            }
        };
        JSONObject jsonbody = new JSONObject();
        jsonbody.put("pageNo",3);
        jsonbody.put("pageSize",100);
        String body = jsonbody.toJSONString();
        String res = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, "application/json");
        JSONObject jsonObject = JSONObject.parseObject(res);
        System.out.println(res);
//        JSONArray data = jsonObject.getJSONArray("data");
        cameraParm camera= JSONObject.parseObject(jsonObject.toString(), cameraParm.class);
        cameraList(camera);
    }

    //设备信息
    private AjaxResult cameraList(cameraParm camera) {
        XlEquipmentInfo xlEquipmentInfo = new XlEquipmentInfo();
        for(int i=0;i<camera.getData().getList().size();i++){
            String cameraIndexCode = camera.getData().getList().get(i).getCameraIndexCode();
            int count=iXlEquipmentInfoService.queryEquipmentCamindexCode(cameraIndexCode);
            if(count==0){
                //监控点名称
                xlEquipmentInfo.setEquipmentName(camera.getData().getList().get(i).getName());
                //设备类型
                xlEquipmentInfo.setEquipmentType(String.valueOf(camera.getData().getList().get(i).getCameraType()));
                //设备序列号
                xlEquipmentInfo.setEquipmentSerialNumber(camera.getData().getList().get(i).getCameraIndexCode());
                //设备型号
                xlEquipmentInfo.setEquipmentModel(camera.getData().getList().get(i).getDeviceResourceType());
                //设备位置
                xlEquipmentInfo.setEquipmentAdress(camera.getData().getList().get(i).getName());
                //经度
                xlEquipmentInfo.setLongitude(camera.getData().getList().get(i).getLongitude());
                //纬度
                xlEquipmentInfo.setLatitude(camera.getData().getList().get(i).getLatitude());
                //状态
                xlEquipmentInfo.setEquipmentStatus(camera.getData().getList().get(i).getStatus());
                //所属组织
                xlEquipmentInfo.setEquipmentOrganization(camera.getData().getList().get(i).getUnitIndexCode());
                String recordLocation = camera.getData().getList().get(i).getRecordLocation();
                if(recordLocation.equals("")){

                }else{
                    //存储位置
                    xlEquipmentInfo.setEquipmentStorage(Integer.parseInt(recordLocation));
                }
                //创建时间
                xlEquipmentInfo.setCreateTime(new Date());
                //创建人
                xlEquipmentInfo.setCreateBy("admin");
                iXlEquipmentInfoService.insertXlEquipmentInfo(xlEquipmentInfo);
            }
        }
        return AjaxResult.success();
    }


    public  void qyinfo(){
        ArtemisConfig.host=HkwsConfig.host;
        ArtemisConfig.appKey = HkwsConfig.appKey;
        ArtemisConfig.appSecret = HkwsConfig.appSecret;
        final String getSecurityApi = HkwsConfig.qyinfo; // 区域接口路径
        Map<String, String> path = new HashMap<String,String>(2) {
            {
                put("https://", getSecurityApi);
            }
        };

        JSONObject jsonBody = new JSONObject();
        String body = jsonBody.toJSONString();
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null,
                null,"application/json");
        //海康传过来是数据转为对象
        JSONObject jsonObject = JSONObject.parseObject(result);
        JSONArray data = jsonObject.getJSONArray("data");
        //RegionInfoDto 声明一个实体类  先将数据转成这个对象,再从这个对象取数据保存到数据库中
        List<RegionInfoDto> regionInfoDtos = JSON.parseArray(data.toString(),RegionInfoDto.class);

        for(int i=0;i<regionInfoDtos.size();i++){
            List users = regionInfoDtos.get(i).getUsers();
            List<UserDto> userDtos = JSON.parseArray(users.toString(), UserDto.class);
            regionInfoDtos.get(i).setUserDto(userDtos);
        }
        //调用下面区域方法
//        deptAll(regionInfoDtos);
    }

    //区域绑定的用户信息(目前还没用到)
    public  void qyinfouser(){
        ArtemisConfig.host=HkwsConfig.host;
        ArtemisConfig.appKey = HkwsConfig.appKey;
        ArtemisConfig.appSecret = HkwsConfig.appSecret;
        final String getSecurityApi = HkwsConfig.qyinfouser; // 区域绑定的用户信息接口路径
        Map<String, String> path = new HashMap<String,String>(2) {
            {
                put("https://", getSecurityApi);
            }
        };

        JSONObject jsonBody = new JSONObject();

        String body = jsonBody.toJSONString();
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null,
                null,"application/json");
        System.out.println(result);
    }
    //点位增设
    public  void pointproposal(){
        ArtemisConfig.host=HkwsConfig.host;
        ArtemisConfig.appKey = HkwsConfig.appKey;
        ArtemisConfig.appSecret = HkwsConfig.appSecret;
        final String getSecurityApi = HkwsConfig.pointproposal; // 接口路径
        Map<String, String> path = new HashMap<String,String>(2) {
            {
                put("https://", getSecurityApi);
            }
        };

        JSONObject jsonBody = new JSONObject();

        String body = jsonBody.toJSONString();
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null,
                null,"application/json");
        System.out.println(result);
    }
    //反馈意见(目前还没用到)
        public  void pointproposalback(){
        ArtemisConfig.host=HkwsConfig.host;
        ArtemisConfig.appKey = HkwsConfig.appKey;
        ArtemisConfig.appSecret = HkwsConfig.appSecret;
        final String getSecurityApi = HkwsConfig.pointproposalback; // 接口路径
        Map<String, String> path = new HashMap<String,String>(2) {
            {
                put("https://", getSecurityApi);
            }
        };

        JSONObject jsonBody = new JSONObject();
        String body = jsonBody.toJSONString();
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null,
                null,"application/json");
        System.out.println(result);
    }


    //事件反馈(目前还没用到)
    @PostMapping("/eventFeedback")
    @ResponseBody
    public  String eventFeedback(String evenid){
        ArtemisConfig.host=HkwsConfig.host;
        ArtemisConfig.appKey = HkwsConfig.appKey;
        ArtemisConfig.appSecret = HkwsConfig.appSecret;
        final String getSecurityApi = HkwsConfig.eventFeedback; // 接口路径
        Map<String, String> path = new HashMap<String,String>(2) {
            {
                put("https://", getSecurityApi);
            }
        };
//        configService.selectConfigByKey("sys.index.skinName")

        EventAnalysisDTO eventAnalysisDTO = new EventAnalysisDTO();
        feedbck(eventAnalysisDTO,evenid);
        String body = JSONObject.toJSON(eventAnalysisDTO).toString();
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null,
                null,"application/json");
        return result;
    }

    private  void storeFetch(){
        ArtemisConfig.host=HkwsConfig.host;
        ArtemisConfig.appKey = HkwsConfig.appKey;
        ArtemisConfig.appSecret = HkwsConfig.appSecret;
        final String getSecurityApi = HkwsConfig.storefetch; // 接口路径
        Map<String, String> path = new HashMap<String,String>(2) {
            {
                put("https://", getSecurityApi);
            }
        };
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("pageNo",0);
        jsonBody.put("pageSize",20);
        jsonBody.put("placeTypeNum","ocos");
        String body = jsonBody.toJSONString();
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null,
                null,"application/json");
        System.out.println(result);

    }

    private static final Logger log = LoggerFactory.getLogger(HkApi.class);


    @Autowired
    private AppEventDetailService appEventDetailService;

    @Autowired
    private ISysUserService iSysUserService;

    @Autowired
    private ISysJobLogService iSysJobLogService;
    /**
     * 海康接收接口
     * */
    @PostMapping("/callbackUrl")
    @ResponseBody
    public AjaxResult callbackUrl(@RequestBody EventAnalysisDTO obj){

        log.info("获取信息:==="+JSON.toJSONString(obj));
//        System.out.println("获取信息"+obj.getComponentId()+"========="+obj.getEventInfo());
        SysJobLog joblog = new SysJobLog();
        joblog.setJobName("获取海康事件");
        joblog.setJobGroup(obj.getComponentId());
        try{
            if(obj.getEventInfo()== null){
                return AjaxResult.error("事件为空");
            }
            HkEventInfo hkEventInfo = infoHkwsinfo(obj.getEventInfo());
            hkEventInfo.setComponentId(obj.getComponentId());
            String regionIndexCode = obj.getEventInfo().getRegionIndexCode();
            int sysDeptCount = iSysDeptService.findSysDeptCount(regionIndexCode);
            if(sysDeptCount !=0){
                hkEventService.addHKEventInfo(hkEventInfo);
                joblog.setInvokeTarget("数据导入成功");
                joblog.setStatus("0");
                joblog.setJobMessage("海康事件:"+JSON.toJSONString(obj));
                iSysJobLogService.addJobLog(joblog);
            }else{
                joblog.setInvokeTarget("没有社区数据");
                joblog.setStatus("1");
                joblog.setExceptionInfo("海康事件:"+JSON.toJSONString(obj));
                iSysJobLogService.addJobLog(joblog);
            }
        }catch (Exception e){
            e.printStackTrace();
            joblog.setStatus("1");
            joblog.setInvokeTarget("数据异常");
            joblog.setExceptionInfo("错误日志："+e.getMessage());
            iSysJobLogService.addJobLog(joblog);
        }

        return AjaxResult.success();
    }

   /* private void  hkinfo(){
        ArtemisConfig.host=HkwsConfig.host;
        ArtemisConfig.appKey = HkwsConfig.appKey;
        ArtemisConfig.appSecret = HkwsConfig.appSecret;
        String getSecurityApi = HkwsConfig.fetchAll; // 接口路径
        Map<String, String> path = new HashMap<String,String>(2) {
            {
                put("https://", getSecurityApi);
            }
        };

        JSONObject jsonBody = new JSONObject();
        jsonBody.put("pageNo",0);
        jsonBody.put("pageSize",20);
        jsonBody.put("eventType","fireExitOccupy");
        String body = jsonBody.toJSONString();
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null,
                null,"application/json");
        JSONObject jsonObject = JSONObject.parseObject(result);
        JSONObject jsonlist = JSONObject.parseObject(jsonObject.get("data").toString());
        List<EventInfoDTOOne> list = JSONArray.parseArray(jsonlist.get("list").toString(),EventInfoDTOOne.class);
        HkEventInfo hkEventInfo = infoHkwsinfo(list.get(0));
        //hkEventService.addHKEventInfo(hkEventInfo);
        System.out.println(result);
    }*/

    private HkEventInfo infoHkwsinfo(EventInfoDTO eventInfo) throws ParseException {
        EventDTO eventinfo = eventInfo.getEvent();
        HkEventInfo hkEventInfo = new HkEventInfo();
        if(eventInfo.getReportProvider()!=null && eventInfo.getReportProvider().getReportDevice()!=null){
            hkEventInfo.setCameraIndexCode(eventInfo.getReportProvider().getReportDevice().getCameraIndexCode());
            hkEventInfo.setCameraName(eventInfo.getReportProvider().getReportDevice().getCameraName());
        }

        hkEventInfo.setRegionIndexCode(eventInfo.getRegionIndexCode());
        hkEventInfo.setRegionName(eventInfo.getRegionName());
        hkEventInfo.setPlaceName(eventInfo.getPlaceName());
        hkEventInfo.setEventId(UUID.randomUUID().toString().trim().replaceAll("-", ""));
        hkEventInfo.setEventIndexCode(eventinfo.getEventIndexCode());//海康事件唯一标识
        hkEventInfo.setEventTitle(eventinfo.getEventTitle());
        hkEventInfo.setEventAddress(eventinfo.getEventAddress());
        hkEventInfo.setReportTime(eventinfo.getReportTime());
        hkEventInfo.setEventType(eventinfo.getEventType());
        hkEventInfo.setEventTypeName(eventinfo.getEventTypeName());
        hkEventInfo.setEventImage(eventinfo.getEventImage());
        hkEventInfo.setEventThumbnailImage(eventinfo.getEventImage());
        hkEventInfo.setStorageId(eventinfo.getStorageId());
        if(eventinfo.getEventStatus() == 3){
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = dateFormat.format(date);
            hkEventInfo.setEventCreateTime(format);
            hkEventInfo.setEventAlertStatus(9);
            hkEventInfo.setEventAlertStatusName("系统自动完成");
        }else{
            //事件重复报警
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String eventUpdateTime = eventinfo.getEventUpdateTime();
            if( eventUpdateTime == null  || eventUpdateTime.equals("") ){
                Date date1 = new Date();
                String format1 = dateFormat.format(date1);
                hkEventInfo.setEventCreateTime(format1);
                String eventType = eventinfo.getEventType();
                String eventTitle = eventinfo.getEventTitle();
                String regionIndexCode = eventInfo.getRegionIndexCode();
                HkEventInfo hkEventInfo1 = new HkEventInfo();
                hkEventInfo1.setEventCreateTime(format1);
                hkEventInfo1.setEventType(eventType);
                hkEventInfo1.setRegionIndexCode(regionIndexCode);
                hkEventInfo1.setEventTitle(eventTitle);
                /*根据事件的当天时间、事件的类别、事件的区域code、状态是否为2 进行判断，
                如果为查出的数量为0则正常添加，如果查出来的数据不为0 则将这条事件的状态改为10(重复报警)*/
                int eventcount=hkEventService.selectEventRepeat(hkEventInfo1);
                if(eventcount !=0){
                    hkEventInfo.setEventAlertStatus(10);
                    hkEventInfo.setEventAlertStatusName("重复报警");
                }else{
                    hkEventInfo.setEventAlertStatus(eventinfo.getEventStatus());
                    hkEventInfo.setEventAlertStatusName("研判中");
                }
            }else{
                Date parse = dateFormat1.parse(eventUpdateTime);
                String format1 = dateFormat.format(parse);
                hkEventInfo.setEventCreateTime(format1);
                String eventType = eventinfo.getEventType();
                String eventTitle = eventinfo.getEventTitle();
                String regionIndexCode = eventInfo.getRegionIndexCode();
                HkEventInfo hkEventInfo1 = new HkEventInfo();
                hkEventInfo1.setEventCreateTime(format1);
                hkEventInfo1.setEventType(eventType);
                hkEventInfo1.setRegionIndexCode(regionIndexCode);
                hkEventInfo1.setEventTitle(eventTitle);
            /*根据事件的当天时间、事件的类别、事件的区域code、状态是否为2 进行判断，
            如果为查出的数量为0则正常添加，如果查出来的数据不为0 则将这条事件的状态改为10(重复报警)*/
                int eventcount=hkEventService.selectEventRepeat(hkEventInfo1);
                if(eventcount !=0){
                    hkEventInfo.setEventAlertStatus(10);
                    hkEventInfo.setEventAlertStatusName("重复报警");
                }else{
                    hkEventInfo.setEventAlertStatus(eventinfo.getEventStatus());
                    hkEventInfo.setEventAlertStatusName("研判中");
                }
            }
        }
        hkEventInfo.setReportType(eventinfo.getReportType());
        hkEventInfo.setReportTypeName(eventinfo.getReportTypeName());
        hkEventInfo.setLawEnforcementType(eventinfo.getLawEnforcementType());
        hkEventInfo.setLawEnforcementTypeName(eventinfo.getLawEnforcementTypeName());
        hkEventInfo.setRiskLevel(eventinfo.getRiskLevel());
        hkEventInfo.setCurrentProcessorId(eventinfo.getCurrentProcessorId());
        hkEventInfo.setCurrentProcessorName(eventinfo.getCurrentProcessorName());
        hkEventInfo.setEventUpdateTime(eventinfo.getEventUpdateTime());
        hkEventInfo.setCreateTime(new Date());
        if(eventInfo.getPoint()!=null){
            hkEventInfo.setLongitude(eventInfo.getPoint().getLongitude());
            hkEventInfo.setLatitude(eventInfo.getPoint().getLatitude());
        }
//        hkEventInfo.setGeometry(eventinfo.getGeometry());
        return hkEventInfo;
    }

    /**
     * 拿到义乌市下所有的社区,社区下的人员 进行保存
     *  regionInfoDtos 把数据拿出来 放到数据库中
     * @param regionInfoDtos
     * @return
     */
    public AjaxResult deptAll(List<RegionInfoDto> regionInfoDtos){
        SysDept sysDept = new SysDept();
        for(int i=0;i<regionInfoDtos.size();i++){
            String parentIndexCode = regionInfoDtos.get(i).getParentIndexCode();
            if(parentIndexCode.equals("-1")){
                String indexCode = regionInfoDtos.get(i).getIndexCode();
                String name = regionInfoDtos.get(i).getName();
                sysDept.setDeptUuid(indexCode);
                sysDept.setParentId("0");
                sysDept.setDeptName(name);
                int depeId=iSysDeptService.insertSysDept(sysDept);
                Long id = (Long) sysDept.getDeptId();
            }

        }
        for(int j=0;j<regionInfoDtos.size();j++){
            String parentIndexCode = regionInfoDtos.get(j).getParentIndexCode();
            if(!parentIndexCode.equals("-1")){
               List<SysDept> sysDepts= iSysDeptService.findsysDeptUuid(parentIndexCode);
               if(sysDepts.size()!=0){
                   Long deptId = sysDepts.get(0).getDeptId();
                   sysDept.setParentId(deptId.toString());
                   sysDept.setDeptUuid(regionInfoDtos.get(j).getIndexCode());
                   sysDept.setDeptName(regionInfoDtos.get(j).getName());
                   sysDept.setCreateTime(new Date());
                   int depeId=iSysDeptService.insertSysDept(sysDept);
                   Long id1 = (Long) sysDept.getDeptId();
                   List<UserDto> userDto = regionInfoDtos.get(j).getUserDto();
                   SysUser sysUser = new SysUser();
                   for(int m=0;m<userDto.size();m++){
                       String userId = userDto.get(m).getUserId();
                       String userName = userDto.get(m).getUserName();
                       String realName = userDto.get(m).getRealName();
                       String phoneNum = userDto.get(m).getPhoneNum();
                           String md5 = MD5Util.getMD5(userName + "123123");
                           sysUser.setDeptId(id1);
                           sysUser.setUserName(realName);
                           if(phoneNum == null){
                               sysUser.setPhonenumber("");
                           }else{
                               sysUser.setPhonenumber(phoneNum);
                           }
                           sysUser.setLoginName(userName);
                           sysUser.setPassword(md5);
                           sysUser.setCreateTime(new Date());
                           int userCount =iSysUserService.findUserCount(sysUser);
                           if(userCount == 0){
                               int user=iSysUserService.insertSysuser(sysUser);
                               Long userId1 = sysUser.getUserId();
                               SysUserRole sysUserRole = new SysUserRole();
                               sysUserRole.setUserId(userId1);
                               String roleId="2";
                               sysUserRole.setRoleId(Long.valueOf(roleId).longValue());
                               iSysUserService.insertUserRole(sysUserRole);
                           }
                   }

               }
            }
        }

        for(int y=0;y<regionInfoDtos.size();y++){
            String parentIndexCode = regionInfoDtos.get(y).getParentIndexCode();
            if(!parentIndexCode.equals("-1")){
                String indexCode = regionInfoDtos.get(y).getIndexCode();
                int count=iSysDeptService.findSysDeptCount(indexCode);
                if(count ==0){
                    List<SysDept> sysDepts= iSysDeptService.findsysDeptUuid(parentIndexCode);
                    if(sysDepts.size()!=0){
                        Long deptId = sysDepts.get(0).getDeptId();
                        sysDept.setParentId(deptId.toString());
                        sysDept.setDeptUuid(regionInfoDtos.get(y).getIndexCode());
                        sysDept.setDeptName(regionInfoDtos.get(y).getName());
                        sysDept.setCreateTime(new Date());
                        int depeId=iSysDeptService.insertSysDept(sysDept);
                        Long id2 = (Long) sysDept.getDeptId();
                        List<UserDto> userDto = regionInfoDtos.get(y).getUserDto();
                        SysUser sysUser = new SysUser();
                        for(int m=0;m<userDto.size();m++){
                            String userId = userDto.get(m).getUserId();
                            String userName = userDto.get(m).getUserName();
                            String realName = userDto.get(m).getRealName();
                            String phoneNum = userDto.get(m).getPhoneNum();
                            String md5 = MD5Util.getMD5(userName + "123123");
                            sysUser.setDeptId(id2);
                            sysUser.setUserName(realName);
                            if(phoneNum == null){
                                sysUser.setPhonenumber("");
                            }else{
                                sysUser.setPhonenumber(phoneNum);
                            }
                            sysUser.setLoginName(userName);
                            sysUser.setPassword(md5);
                            sysUser.setCreateTime(new Date());
                            int userCount =iSysUserService.findUserCount(sysUser);
                            if(userCount == 0){
                                int user=iSysUserService.insertSysuser(sysUser);
                                Long userId1 = sysUser.getUserId();
                                SysUserRole sysUserRole = new SysUserRole();
                                sysUserRole.setUserId(userId1);
                                String roleId="2";
                                sysUserRole.setRoleId(Long.valueOf(roleId).longValue());
                                iSysUserService.insertUserRole(sysUserRole);
                            }
                        }

                    }
                }
            }
        }
        for(int x=0;x<regionInfoDtos.size();x++){
            String parentIndexCode = regionInfoDtos.get(x).getParentIndexCode();
            if(!parentIndexCode.equals("-1")){
                String indexCode = regionInfoDtos.get(x).getIndexCode();
                int count=iSysDeptService.findSysDeptCount(indexCode);
                if(count ==0){
                    List<SysDept> sysDepts= iSysDeptService.findsysDeptUuid(parentIndexCode);
                    if(sysDepts.size()!=0){
                        Long deptId = sysDepts.get(0).getDeptId();
                        sysDept.setParentId(deptId.toString());
                        sysDept.setDeptUuid(regionInfoDtos.get(x).getIndexCode());
                        sysDept.setDeptName(regionInfoDtos.get(x).getName());
                        sysDept.setCreateTime(new Date());
                        int depeId=iSysDeptService.insertSysDept(sysDept);
                        Long id3 = (Long) sysDept.getDeptId();
                        List<UserDto> userDto = regionInfoDtos.get(x).getUserDto();
                        SysUser sysUser = new SysUser();
                        for(int m=0;m<userDto.size();m++){
                            String userId = userDto.get(m).getUserId();
                            String userName = userDto.get(m).getUserName();
                            String realName = userDto.get(m).getRealName();
                            String phoneNum = userDto.get(m).getPhoneNum();
                            String md5 = MD5Util.getMD5(userName + "123123");
                            sysUser.setDeptId(id3);
                            sysUser.setUserName(realName);
                            if(phoneNum == null){
                                sysUser.setPhonenumber("");
                            }else{
                                sysUser.setPhonenumber(phoneNum);
                            }
                            sysUser.setLoginName(userName);
                            sysUser.setPassword(md5);
                            sysUser.setCreateTime(new Date());
                            int userCount =iSysUserService.findUserCount(sysUser);
                            if(userCount == 0){
                                int user=iSysUserService.insertSysuser(sysUser);
                                Long userId1 = sysUser.getUserId();
                                SysUserRole sysUserRole = new SysUserRole();
                                sysUserRole.setUserId(userId1);
                                String roleId="2";
                                sysUserRole.setRoleId(Long.valueOf(roleId).longValue());
                                iSysUserService.insertUserRole(sysUserRole);
                            }
                        }

                    }
                }
            }
        }
        return AjaxResult.success();
    }

    public AjaxResult feedbck(EventAnalysisDTO eventAnalysisDTO,String evenid) {
        //获取数据 并返回
        EventInfoDTO eventInfoDTO = new EventInfoDTO();
        EventDTO eventDTO = new EventDTO();
        EventReportProviderDTO eventReportProviderDTO = new EventReportProviderDTO();
        HkEventInfo hkEventInfo = new HkEventInfo();
         hkEventInfo.setEventId(evenid);
        List<HkEventInfo> event=hkEventService.selectEventInfoAll(hkEventInfo);
        eventAnalysisDTO.setComponentId(event.get(0).getComponentId());
        eventDTO.setEventIndexCode(event.get(0).getEventIndexCode());
        eventDTO.setEventTitle(event.get(0).getEventTitle());
        eventDTO.setEventAddress(event.get(0).getEventAddress());
        eventDTO.setReportTime(event.get(0).getReportTime());
        eventDTO.setEventType(event.get(0).getEventType());
        eventDTO.setEventTypeName(event.get(0).getEventTypeName());
        eventDTO.setEventStatus(3);
        eventDTO.setEventStatusName("已完成");
        eventDTO.setEventSubStatus(event.get(0).getEventSubStatus());
        eventDTO.setEventSubStatusName(event.get(0).getEventSubStatusName());
        eventDTO.setReportType(event.get(0).getReportType());
        eventDTO.setReportTypeName(event.get(0).getReportTypeName());
        eventDTO.setLawEnforcementType(event.get(0).getLawEnforcementType());
        eventDTO.setLawEnforcementTypeName(event.get(0).getLawEnforcementTypeName());
        eventDTO.setCurrentProcessorId(event.get(0).getCurrentProcessorId());
        eventDTO.setCurrentProcessorName(event.get(0).getCurrentProcessorName());
        eventDTO.setEventImage(event.get(0).getEventImage());
        eventInfoDTO.setEvent(eventDTO);
        eventInfoDTO.setReportProvider(eventReportProviderDTO);
        eventInfoDTO.setRegionIndexCode(event.get(0).getRegionIndexCode());
        eventInfoDTO.setRegionName(event.get(0).getRegionName());
        eventInfoDTO.setPlaceType(event.get(0).getPlaceType());
        eventInfoDTO.setPlaceTypeName(event.get(0).getPlaceTypeName());
        eventInfoDTO.setPlaceIndexCode(event.get(0).getPlaceIndexCode());
        eventInfoDTO.setPlaceName(event.get(0).getPlaceName());
        eventInfoDTO.setExtendStr1(event.get(0).getExtendStr1());
        eventAnalysisDTO.setEventInfo(eventInfoDTO);
        EventProcessRecordDTO eventProcessRecordDTO=new EventProcessRecordDTO();
        HKrecord hk=new HKrecord();
        hk.setEventId(evenid);
        List<HKrecord> hKrecord=appEventDetailService.selectPro(hk);

        List<EventProcessRecordDTO> lists=new ArrayList<>();

        eventProcessRecordDTO.setExtendInt1(hKrecord.get(0).getExtendInt1());
        eventProcessRecordDTO.setExtendInt2(hKrecord.get(0).getExtendInt2());
        eventProcessRecordDTO.setExtendInt3(hKrecord.get(0).getExtendInt3());
        eventProcessRecordDTO.setExtendJson(hKrecord.get(0).getExtendjson());
//        eventProcessRecordDTO.setExtendStr1(hKrecord.get(i).getExtendStr1().toString());
        eventProcessRecordDTO.setExtendStr2(hKrecord.get(0).getExtendStr2());
        eventProcessRecordDTO.setExtendStr3(hKrecord.get(0).getExtendStr3());
        eventProcessRecordDTO.setHandlerName(hKrecord.get(0).getHandlerName());
        eventProcessRecordDTO.setProcessResult(appEventDetailService.result(hKrecord.get(0).getRecordId()));
//        eventProcessRecordDTO.setProcessStatus(Integer.parseInt(hKrecord.get(i).getProcessStatus()));
        eventProcessRecordDTO.setProcessStatusName(hKrecord.get(0).getProcessStatusName());
        eventProcessRecordDTO.setRegionName(hKrecord.get(0).getRegionName());
        eventProcessRecordDTO.setHandlerPhone(hKrecord.get(0).getHandlerPhone());
//        eventProcessRecordDTO.setHandlerIndexCode(hKrecord.get(0).getHandlerIndexCode());
//        eventProcessRecordDTO.setProcessTime(hKrecord.get(i).getProcessTime().toString());
        eventProcessRecordDTO.setHandlerRecordIndexCode(UUID.randomUUID().toString().trim().replaceAll("-", ""));
         lists.add(eventProcessRecordDTO);
        eventAnalysisDTO.setProcessRecord(lists);
        return AjaxResult.success();
    }


    //非机动车停放区增设建议
    @PostMapping("/applyParkingArea")
    @ResponseBody
public String applyParkingArea(){

        ArtemisConfig.host=HkwsConfig.host;
        ArtemisConfig.appKey = HkwsConfig.appKey;
        ArtemisConfig.appSecret = HkwsConfig.appSecret;
        final String getSecurityApi = HkwsConfig.applyparkingarea; // 接口路径
        Map<String, String> path = new HashMap<String,String>(2) {
            {
                put("https://", getSecurityApi);
            }
        };
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("userId","");
        jsonBody.put("imageUrls","http://10.13.172.10:6120/pic?aiuhrdhejasfdgghggh23dsasda");
        jsonBody.put("longitude", 120.1643513);
        jsonBody.put("latitude",30.1685413);
        jsonBody.put("applyAddressName","test");
        String body = jsonBody.toJSONString();
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null,
                null,"application/json");
        return result;
    }



    public void geteventcg(management passinfo) {
        for(int i=0;i<=passinfo.getData().getList().size()-1;i++){
            String id = passinfo.getData().getList().get(i).getId();
            int count=hkEventService.queryEventEventIndexCode(id);
            if(count==0){
                HkEventInfo hkEventInfo = new HkEventInfo();
                //生成事件唯一标识
                hkEventInfo.setEventId(UUID.randomUUID().toString().trim().replaceAll("-", "").trim().replaceAll("-", "").trim().replaceAll("-", ""));
                //接入的事件标识
                hkEventInfo.setEventIndexCode(passinfo.getData().getList().get(i).getId());
                //上报时间
                long collectTime = passinfo.getData().getList().get(i).getCollectTime();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String format = dateFormat.format(collectTime);
                hkEventInfo.setReportTime(format);
                Date date = new Date(collectTime);
                hkEventInfo.setCreateTime(date);
                System.out.println(date);
                //事件类型
                hkEventInfo.setEventType(passinfo.getData().getList().get(i).getIntelligentType());
                //事件类型名称
                hkEventInfo.setEventTypeName(passinfo.getData().getList().get(i).getIntelligentTypeName());
                //监控点编号
                hkEventInfo.setCameraIndexCode(passinfo.getData().getList().get(i).getIndexCode());
                //监控点地址
                hkEventInfo.setCameraName(passinfo.getData().getList().get(i).getCameraName());
                hkEventInfo.setEventAddress(passinfo.getData().getList().get(i).getCameraName());
                //标题
                hkEventInfo.setEventTitle(passinfo.getData().getList().get(i).getIntelligentTypeName());
                //图片
                hkEventInfo.setEventImage(passinfo.getData().getList().get(i).getPicUrl());
                //缩略图
                hkEventInfo.setEventThumbnailImage(passinfo.getData().getList().get(i).getThumbnailUrl());
                //上报日期
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                String format1 = dateFormat1.format(new Date());
                hkEventInfo.setEventCreateTime(format1);
                //状态
                hkEventInfo.setEventAlertStatus(2);
                hkEventInfo.setEventAlertStatusName("研判中");
                //经纬度数组. 纬度-经度
                double[] convertPoint = GPSUtils.gcj02_To_Bd09(Double.parseDouble(passinfo.getData().getList().get(i).getLatitude()), Double.parseDouble(passinfo.getData().getList().get(i).getLongitude()));
//                System.out.println(convertPoint[1]+"----------"+convertPoint[0]);
                Double[] points = {convertPoint[1], convertPoint[0]};
                Map<String, Object> map1 = hkMapService.calculateRegionByLongitudeAndLatitude(points);
                String regionCode = map1.get("regionId") + "";
                String regionName = map1.get("regionName") + "";
                System.out.println(regionCode+"------------"+regionName);
                //经度
                hkEventInfo.setLongitude(convertPoint[1]+"");
                //纬度
                hkEventInfo.setLatitude(convertPoint[0]+"");
                //网格code
                hkEventInfo.setRegionIndexCode(regionCode);
                //网格名称
                hkEventInfo.setRegionName(regionName);
                //车牌号
                String plateNo = passinfo.getData().getList().get(i).getPlateNo();
                if(plateNo!=null){
                    hkEventInfo.setPlateNo(plateNo);
                }
                //1001城管事件 100  1002应急事件
                hkEventInfo.setComponentId("1001");
                //智能上报
                hkEventInfo.setReportType(1);
                hkEventInfo.setReportTypeName("智能上报");
                hkEventInfo.setEventSourceName("CM城管");
                //所属组织编码
                hkEventInfo.setEventCategory(Integer.parseInt(passinfo.getData().getList().get(i).getOrgCode()));
                //所属组织名称
                hkEventInfo.setEventCategoryName(passinfo.getData().getList().get(i).getOrgName());
                hkEventService.addHKEventInfo(hkEventInfo);
            }
        }
    }

   /* @RequestMapping("zuobiao")
    @ResponseBody
    public AjaxResult zuobiao(){
        String Latitude="30.222858";
        String Longitude="119.98463";
        //经纬度数组. 纬度-经度
        double[] convertPoint = GPSUtils.gcj02_To_Bd09(Double.parseDouble(Latitude), Double.parseDouble(Longitude));
        System.out.println(convertPoint[1]+"----------"+convertPoint[0]);
        Double[] points = {convertPoint[1], convertPoint[0]};
        Map<String, Object> map1 = hkMapService.calculateRegionByLongitudeAndLatitude(points);
        String regionCode = map1.get("regionId") + "";
        String regionName = map1.get("regionName") + "";
        System.out.println(regionCode+"------------"+regionName);
        return AjaxResult.success();
    }*/

   @RequestMapping(value = "ZheLiFang",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult ceshi1(@RequestBody ZheLiFangDto zheLiFangDto){
       String storeid = zheLiFangDto.getStoreid();
       int count = hkEventService.queryEventEventIndexCode(storeid);
       if(count == 0){
           HkEventInfo hkEventInfo = new HkEventInfo();
           //生成事件唯一标识
           hkEventInfo.setEventId(UUID.randomUUID().toString().trim().replaceAll("-", "").trim().replaceAll("-", "").trim().replaceAll("-", ""));
           //信访事件唯一标识
           hkEventInfo.setEventIndexCode(zheLiFangDto.getStoreid());
           //事件分类
           hkEventInfo.setComponentId("1002");
           //事件上报状态
           hkEventInfo.setEventType("1102");
           //事件状态名称
           hkEventInfo.setEventTypeName("浙里访事件");
           //联系电话
           hkEventInfo.setCompanyContactInformation(zheLiFangDto.getSjhm());
           //上报人
           hkEventInfo.setCompanyLegalPerson(zheLiFangDto.getXm());
           //上报类型
           hkEventInfo.setReportType(2);
           //上报类型名称
           hkEventInfo.setReportTypeName("人工上报");
           //事件状态
           hkEventInfo.setEventAlertStatus(2);
           //事件状态名称
           hkEventInfo.setEventAlertStatusName("研判中");
           //预警地址
           hkEventInfo.setCameraName(zheLiFangDto.getQx());
           hkEventInfo.setEventAddress(zheLiFangDto.getQx());
           //时间
           hkEventInfo.setCreateTime(new Date());
           //上报时间
           hkEventInfo.setReportTime(zheLiFangDto.getXfrq());
           hkEventInfo.setEventCreateTime(zheLiFangDto.getXfrq());
           //事件标题
           hkEventInfo.setEventTitle(zheLiFangDto.getGk());
           hkEventService.addHKEventInfo(hkEventInfo);
       }
       return AjaxResult.success();
   }
}
