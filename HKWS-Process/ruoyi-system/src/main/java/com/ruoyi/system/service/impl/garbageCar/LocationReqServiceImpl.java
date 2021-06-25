package com.ruoyi.system.service.impl.garbageCar;

import com.ruoyi.system.domain.platform.gpsWeigh.XlGpsWeigh;
import com.ruoyi.system.mapper.LocationReqMapper;
import com.ruoyi.system.service.garbageCar.LocationReqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author FanKaibiao
 * @date 2021-05-26-22:05
 */
@Service
public class LocationReqServiceImpl implements LocationReqService {

    @Autowired
    private LocationReqMapper locationMapper;

    //垃圾车定位
    @Override
    public void localhost(XlGpsWeigh xlGpsWeigh) {
        locationMapper.localhost(xlGpsWeigh);
    }
    //垃圾车定位
    @Override
    public void weight(XlGpsWeigh xlGpsWeigh) {
        locationMapper.weight(xlGpsWeigh);
    }

    @Override
    public List<XlGpsWeigh> queryGarbageList(Map<String, Object> policeParams) {
        return locationMapper.queryGarbageList(policeParams);
    }

    @Override
    public List<XlGpsWeigh> queryGarbageListAll(Map<String, Object> policeParams) {
        return locationMapper.queryGarbageListAll(policeParams);
    }
}
