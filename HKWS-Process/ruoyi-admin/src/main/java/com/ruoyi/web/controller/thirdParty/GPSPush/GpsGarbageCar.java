package com.ruoyi.web.controller.thirdParty.GPSPush;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.platform.garbageCarLocation.LocationReq;
import com.ruoyi.system.domain.platform.garbageCarLocation.WeightReq;
import com.ruoyi.system.domain.platform.gpsWeigh.XlGpsWeigh;
import com.ruoyi.system.service.garbageCar.LocationReqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author FanKaibiao
 * @date 2021-05-26-15:40
 */
@Controller
@RequestMapping("/push")
public class GpsGarbageCar extends BaseController {

    @Autowired
    private LocationReqService locationReqService;

    //垃圾车定位推送
    @RequestMapping(value = "location",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult localhost(@RequestBody List<LocationReq> req){
        XlGpsWeigh xlGpsWeigh = new XlGpsWeigh();
        for(int i=0;i<req.size();i++){
            xlGpsWeigh.setTripartName("垃圾车定位推送");//事件类型
            xlGpsWeigh.setTripartType("GPS定位");//GPS或称重
            xlGpsWeigh.setLicensePlate(req.get(i).getLicensePlate());//车牌号
            xlGpsWeigh.setLocationSim(req.get(i).getLocationSim());//车辆编码
            xlGpsWeigh.setTripartLng(req.get(i).getLng());//经度
            xlGpsWeigh.setTripartLat(req.get(i).getLat());//纬度
            xlGpsWeigh.setTripartHeight(req.get(i).getHeight());//高度
            xlGpsWeigh.setTripartSpeed(req.get(i).getSpeed());//车速
            xlGpsWeigh.setTripartDirection(String.valueOf(req.get(i).getDirection()));//方向
            xlGpsWeigh.setRecortTime(req.get(i).getLocationTime());//定位时间
            locationReqService.localhost(xlGpsWeigh);
        }
        return AjaxResult.success("成功");
    }

    //垃圾车称重
    @RequestMapping(value = "weight",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult weight(@RequestBody  List<WeightReq> req){
        XlGpsWeigh xlGpsWeigh = new XlGpsWeigh();
        for(int i=0;i<req.size();i++){
            xlGpsWeigh.setTripartName("垃圾车称重推送");
            xlGpsWeigh.setTripartType("垃圾车称重");
            xlGpsWeigh.setLicensePlate(req.get(i).getLicensePlate());//车牌号
            xlGpsWeigh.setTripartWeight(req.get(i).getWeight());//重量
            xlGpsWeigh.setRecortTime(req.get(i).getWeightTime());//称重时间
            locationReqService.weight(xlGpsWeigh);
        }
        return AjaxResult.success("成功");
    }

   /* public static void main(String[] args) throws ParseException {
        String date="2021-05-27 10:23:32";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = dateFormat.parse(date);
        System.out.println(parse);
    }*/
}
