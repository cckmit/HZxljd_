package com.ruoyi.system.service.garbageCar;

import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.domain.platform.garbageCarLocation.LocationReq;
import com.ruoyi.system.domain.platform.gpsWeigh.XlGpsWeigh;

import java.util.List;
import java.util.Map;

/**
 * @author FanKaibiao
 * @date 2021-05-26-22:01
 */
public interface LocationReqService {

    void localhost(XlGpsWeigh xlGpsWeigh);

    void weight(XlGpsWeigh xlGpsWeigh);
    //查询垃圾车GPS定位
    List<XlGpsWeigh> queryGarbageList(Map<String, Object> policeParams);
    //查询全部的定位
    List<XlGpsWeigh> queryGarbageListAll(Map<String, Object> policeParams);
}
