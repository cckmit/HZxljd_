package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.domain.platform.gpsWeigh.XlGpsWeigh;

import java.util.List;
import java.util.Map;

/**
 * @author FanKaibiao
 * @date 2021-05-26-22:09
 */
public interface LocationReqMapper {

    void localhost(XlGpsWeigh xlGpsWeigh);

    void weight(XlGpsWeigh xlGpsWeigh);
    //查询GPS定位
    List<XlGpsWeigh> queryGarbageList(Map<String, Object> policeParams);
    //查询全部的定位
    List<XlGpsWeigh> queryGarbageListAll(Map<String, Object> policeParams);
}
