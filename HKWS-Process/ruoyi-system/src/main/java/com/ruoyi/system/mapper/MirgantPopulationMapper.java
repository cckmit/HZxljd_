package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Daping.PercentResult;
import com.ruoyi.system.domain.Daping.PopulaStatiInfo;
import com.ruoyi.system.domain.HkEarlyWarning.MirgantPopulationVo;

import java.util.List;
import java.util.Map;

/**
 * @author: 刘浩亮
 * @description:
 * @create: 2021-03-24 20:53
 **/
public interface MirgantPopulationMapper {


    int insertData(MirgantPopulationVo vo);

    MirgantPopulationVo queryUserByOne(String idNumber);

    int updateMirgantPopulationByUser(MirgantPopulationVo vo);

    int allCount(Map<String,Object> params);

    List<Map<String,Object>> queryOutStatistics();

    /*List<PercentResult> queryPopulaInfoByRegion();*/

    List<PopulaStatiInfo> queryAllPopulaCount();

    int queryPopulaCountByParam(Map<String,Object> params);
}
