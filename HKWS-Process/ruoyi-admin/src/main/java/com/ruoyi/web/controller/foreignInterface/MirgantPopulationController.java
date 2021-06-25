package com.ruoyi.web.controller.foreignInterface;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.CheckApiUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.quartz.domain.SysJobLog;
import com.ruoyi.quartz.service.ISysJobLogService;
import com.ruoyi.system.domain.HkEarlyWarning.MirgantPopulationVo;
import com.ruoyi.system.domain.HkRentHouseDoor;
import com.ruoyi.system.domain.HkRentHouseInfo;
import com.ruoyi.system.service.HkRentHouseDoorService;
import com.ruoyi.system.service.IHkRentHouseInfoService;
import com.ruoyi.system.service.MirgantPopulationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import java.util.Map;

/**
 *
 * @description:
 * @create: 2021-03-24 20:34
 **/
@Controller
@RequestMapping("/hkapi")
public class MirgantPopulationController {

    private Logger logger = LoggerFactory.getLogger(MirgantPopulationController.class);

    @Autowired
    private ISysJobLogService jobLogService;

    @Autowired
    private MirgantPopulationService populationService;

    @Autowired
    private IHkRentHouseInfoService houseInfoService;

    @Autowired
    private HkRentHouseDoorService  hkRentHouseDoorService;

    @Value("${token.plat.xlj}")
    private String xljToken;
    /**
     * 流动人口数据上报
     * @param vo
     * @return
     */
    @PostMapping("/popula/reportMirgantPopula")
    @ResponseBody
    public AjaxResult getData(@RequestBody MirgantPopulationVo vo){
        String[] arr = new String[]{xljToken};
        Map<String, Object> map = new CheckApiUtil().checkApi(arr);
        if(!(Boolean)map.get("success")){
            return AjaxResult.error((String)map.get("msg"));
        }
        SysJobLog joblog = new SysJobLog();
        joblog.setInvokeTarget("数据异常");
        joblog.setJobMessage("事件内容:"+ JSONObject.toJSONString(vo));
        joblog.setJobName("获取新临居事件--租客");
        joblog.setJobGroup("事件上报");
        joblog.setStatus("1");
        if (StringUtils.isEmpty(vo.getName())){
            return AjaxResult.error("租客姓名不能为空");
        }
        if (StringUtils.isEmpty(vo.getIdNumber())){
            return AjaxResult.error("租客身份证号不能为空");
        }
        if (StringUtils.isEmpty(vo.getPhone())){
            return  AjaxResult.error("联系电话不能为空");
        }
        /*if (StringUtils.isEmpty(vo.getHouseCode())){
            return  AjaxResult.error("房屋信息不能为空");
        }*/
        try{
            int count = populationService.reportMirgantPopulation(vo);
            if(count == 0){
                joblog.setExceptionInfo("错误日志：事件信息保存失败");
                jobLogService.addJobLog(joblog);
            }
        }catch(Exception ex){
            logger.info("错误日志：{}",ex);
            joblog.setExceptionInfo("错误日志："+ex.getMessage());
            jobLogService.addJobLog(joblog);
            return AjaxResult.error("上报失败");
        }
        return AjaxResult.success("上报成功");
    }

    /**
     * 出租屋信息上报
     * @param houseInfo
     * @return
     */
    @PostMapping("/popula/reportHouseInfo")
    @ResponseBody
    public AjaxResult reportHouseInfo(@RequestBody HkRentHouseInfo houseInfo){
        String[] arr = new String[]{xljToken};
        Map<String, Object> map = new CheckApiUtil().checkApi(arr);
        if(!(Boolean)map.get("success")){
            return AjaxResult.error((String)map.get("msg"));
        }
        SysJobLog joblog = new SysJobLog();
        joblog.setInvokeTarget("数据异常");
        joblog.setJobMessage("事件内容:"+ JSONObject.toJSONString(houseInfo));
        joblog.setJobName("获取新临居事件--房屋");
        joblog.setJobGroup("事件上报");
        joblog.setStatus("1");
        if(StringUtils.isEmpty(houseInfo.getHouseCode())){
            return AjaxResult.error("房屋编号不能为空");
        }
        if(StringUtils.isEmpty(houseInfo.getHouseAddress())){
            return AjaxResult.error("房屋地址不能为空");
        }
        if(StringUtils.isEmpty(houseInfo.getRegionName())){
            return AjaxResult.error("房屋所属区域不能为空");
        }
        if(StringUtils.isEmpty(houseInfo.getHouseOwnerName())){
            return AjaxResult.error("房东姓名不能为空");
        }
        if(StringUtils.isEmpty(houseInfo.getHouseOwnerPhone())){
            return AjaxResult.error("房东电话不能为空");
        }
        try{
            int count = houseInfoService.reportHouseInfo(houseInfo);
            if(count == 0){
                joblog.setExceptionInfo("错误日志：事件信息保存失败");
                jobLogService.addJobLog(joblog);
            }
        }catch(Exception ex){
            logger.info("错误日志："+ex.getMessage());
            joblog.setExceptionInfo("错误日志："+ex.getMessage());
            jobLogService.addJobLog(joblog);
            return AjaxResult.error("上报失败");
        }
        return AjaxResult.success("上报成功");
    }
    /**
     *
     * 房源信息上报
     */
    @PostMapping("/popula/reportHouseDoor")
    @ResponseBody
    public AjaxResult reportHouseDoor(@RequestBody HkRentHouseDoor hkRentHouseDoor){
            if (StringUtils.isEmpty(hkRentHouseDoor.getHouseCode())){
                return AjaxResult.error("房源编号不能为空");
            }
            if (StringUtils.isEmpty(hkRentHouseDoor.getDoorStatus())){
                    return AjaxResult.error("状态不能为空");
            }
            if (StringUtils.isEmpty(hkRentHouseDoor.getProcessTime().toString())){
                    return  AjaxResult.error("发生时间不能为空");
            }

        int i=hkRentHouseDoorService.insertDoor(hkRentHouseDoor);
        if (i>0){
           return   AjaxResult.success("添加成功");
        }

           return  AjaxResult.error("添加失败");
    }



}
