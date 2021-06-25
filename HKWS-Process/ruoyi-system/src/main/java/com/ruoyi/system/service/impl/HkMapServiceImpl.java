package com.ruoyi.system.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.map.MapPoint;
import com.ruoyi.common.utils.map.MapUtils;
import com.ruoyi.system.domain.HkMapCover;
import com.ruoyi.system.domain.dto.RegionDto;
import com.ruoyi.system.domain.dto.RegionLocationInfo;
import com.ruoyi.system.mapper.HkMapCoverMapper;
import com.ruoyi.system.mapper.SysDeptMapper;
import com.ruoyi.system.service.IHkMapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.service.impl
 * @ClassName: HkMapServiceImpl
 * @Author: guohailong
 * @Description: 地图服务接口
 * @Date: 2021/3/17 11:40
 * @Version: 1.0
 */
@Service
public class
HkMapServiceImpl implements IHkMapService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HkMapServiceImpl.class);

    @Autowired
    private HkMapCoverMapper hkMapCoverMapper;

    /**
     * 根据经纬度计算出所属区域
     * points[0] 经度
     * points[1] 纬度
     * 中国的经纬度范围大约为:纬度3.86~53.55,经度73.66~135.05
     *
     * @param points
     * @return
     */
    @Override
    public Map<String, Object> calculateRegionByLongitudeAndLatitude(Double[] points) {
        if (StringUtils.isEmpty(points)
                || points.length != 2
                || points[0] < 70 || points[0] > 140
                || points[1] < 3 || points[1] > 54) {
            throw new BusinessException("参数不合法");
        }
        //获取当前系统所有的地区网格坐标集
//        List<RegionLocationInfo> list = hkMapCoverMapper.getRegionLocationInfoList();
        List<RegionDto> regions = hkMapCoverMapper.getAllRegions();
        List<RegionLocationInfo> regionLocationInfoList = new ArrayList<>();
        //遍历街道列表 获取其下所有社区.
        for (RegionDto rootRegion : regions) {
            List<RegionDto> childrenList = rootRegion.getChildrenList();
            //遍历社区
            for (RegionDto childRegion : childrenList) {
                List<RegionDto> childrenList1 = childRegion.getChildrenList();
                //遍历网格
                for (RegionDto gridRegionDto : childrenList1) {
                    //根据网格id.获取地图覆盖物
                    HkMapCover hkMapCover = hkMapCoverMapper.getHkMapCover(gridRegionDto.getId());
                    if (null != hkMapCover) {
                        //网格区域位置信息
                        RegionLocationInfo regionLocationInfo = new RegionLocationInfo();
                        regionLocationInfo.setRegionName(gridRegionDto.getName());
                        regionLocationInfo.setRegionId(hkMapCover.getParentId());
                        regionLocationInfo.setParentRegionId(childRegion.getId());
                        regionLocationInfo.setParentRegionName(childRegion.getName());
                        regionLocationInfo.setMarkerPoints(hkMapCover.getMarkerPoints());
                        regionLocationInfoList.add(regionLocationInfo);
                    } else {
                        LOGGER.error("ID:[{}] - 名称:[{}]地图网格点不存在,请及时初始化", gridRegionDto.getId(), gridRegionDto.getName());
                    }
                }

            }
        }
//        checkLongitudeAndLatitude(regionLocationInfoList, points);
//        System.err.println(regionLocationInfoList);

        return checkLongitudeAndLatitude(regionLocationInfoList, points);
    }


    /**
     * 经纬度检查返回社区/网格信息
     *
     * @param regionLocationInfoList
     * @param points
     * @return
     */
    private Map<String, Object> checkLongitudeAndLatitude(List<RegionLocationInfo> regionLocationInfoList, Double[] points) {
        Map<String, Object> resultMap = new HashMap<>();
        //遍历获取所有经纬度
        for (RegionLocationInfo regionLocationInfo : regionLocationInfoList) {
            String markerPoints = regionLocationInfo.getMarkerPoints();
            JSONArray markerPointsJsonArray = JSONArray.parseArray(markerPoints);
            MapPoint[] standardPoint = new MapPoint[markerPointsJsonArray.size()];

            for (int i = 0; i < markerPointsJsonArray.size(); i++) {
                Object object = markerPointsJsonArray.get(i);
                JSONArray markerPointJsonArray = JSONArray.parseArray(object.toString());
                //拿到经度和纬度
                Double longitude = Double.parseDouble(markerPointJsonArray.get(0).toString());
                Double latitude = Double.parseDouble(markerPointJsonArray.get(1).toString());
                //构造地图标记点对象
                MapPoint mapPoint = new MapPoint(longitude, latitude);
                standardPoint[i] = mapPoint;
            }
            //校验传过来的经纬度是否属于该区域
            if (MapUtils.isPointInPolys(points[0], points[1], standardPoint)) {
                resultMap.put("regionId", regionLocationInfo.getRegionId());
                resultMap.put("regionName", regionLocationInfo.getRegionName());
                resultMap.put("parentRegionId", regionLocationInfo.getParentRegionId());
                resultMap.put("parentRegionName", regionLocationInfo.getParentRegionName());
                break;
            }
        }

        if (resultMap.isEmpty()) {
            resultMap.put("regionId", "100");
            resultMap.put("regionName", "闲林街道");
            resultMap.put("parentRegionId", "");
            resultMap.put("parentRegionName", "");
        }

        return resultMap;
    }

}
