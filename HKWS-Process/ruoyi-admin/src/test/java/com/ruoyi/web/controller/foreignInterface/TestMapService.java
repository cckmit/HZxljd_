package com.ruoyi.web.controller.foreignInterface;

import com.ruoyi.common.utils.map.GPSUtils;
import com.ruoyi.system.service.IHkMapService;
import com.ruoyi.system.service.ISysRanksService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMapService {

    @Resource
    private IHkMapService hkMapService;

    @Resource
    private ISysRanksService ranksService;


    @Test
    public void run(){
//        Double[] data = {119.82726743948446,30.255378834257588};

        /*double lat = 30.246655;
        double lon = 119.83079;
        double[] doubles1 = GPSUtils.gcj02_To_Bd09(lon, lat);
        Double[] data = {doubles1[0],doubles1[1]};
        System.out.println("转换后的坐标系 = "+doubles1[0]+","+doubles1[1]);
        Map<String, Object> stringObjectMap = hkMapService.calculateRegionByLongitudeAndLatitude(data);
        System.out.println(stringObjectMap);*/


        ranksService.getSomeOneNoRegion();
    }



}
