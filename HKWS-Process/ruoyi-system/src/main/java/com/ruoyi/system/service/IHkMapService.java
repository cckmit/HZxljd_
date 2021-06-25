package com.ruoyi.system.service;

import java.util.Map;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.service
 * @ClassName: IHkMapService
 * @Author: guohailong
 * @Description: 地图服务
 * @Date: 2021/3/17 11:39
 * @Version: 1.0
 */
public interface IHkMapService {


    /**
     * 根据经纬度计算出所属区域
     * points[0] 经度
     * points[1] 纬度
     *
     * @param points
     * @return
     */
    Map<String, Object> calculateRegionByLongitudeAndLatitude(Double[] points);

}
