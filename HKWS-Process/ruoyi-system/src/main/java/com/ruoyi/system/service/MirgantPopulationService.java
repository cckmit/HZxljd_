package com.ruoyi.system.service;


import com.ruoyi.system.domain.Daping.PopulaStatiInfo;
import com.ruoyi.system.domain.HkEarlyWarning.MirgantPopulationVo;

import java.util.List;
import java.util.Map;

/**
 * @author: 刘浩亮
 * @description:
 * @create: 2021-03-24 20:47
 **/

public interface MirgantPopulationService {


    int insertData(MirgantPopulationVo vo);



    int reportMirgantPopulation(MirgantPopulationVo vo);

    int allCount(Map<String,Object> params);

    List<Map<String,Object>> queryOutStatistics();

    List<PopulaStatiInfo> queryPopulaInfoByRegion(Map<String,Object> params);
}
