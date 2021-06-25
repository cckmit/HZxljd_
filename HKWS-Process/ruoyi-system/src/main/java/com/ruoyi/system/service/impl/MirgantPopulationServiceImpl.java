package com.ruoyi.system.service.impl;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.Daping.PercentResult;
import com.ruoyi.system.domain.Daping.PopulaStatiInfo;
import com.ruoyi.system.domain.HkEarlyWarning.MirgantPopulationVo;
import com.ruoyi.system.mapper.MirgantPopulationMapper;
import com.ruoyi.system.service.MirgantPopulationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author: 刘浩亮
 * @description:
 * @create: 2021-03-24 20:48
 **/
@Service
public class MirgantPopulationServiceImpl implements MirgantPopulationService {

    @Autowired
    private MirgantPopulationMapper mirgantPopulationMapper;

    @Override
    public int insertData(MirgantPopulationVo vo) {
        return mirgantPopulationMapper.insertData(vo);
    }

    @Override
    public int reportMirgantPopulation(MirgantPopulationVo vo) {
        MirgantPopulationVo dto = mirgantPopulationMapper.queryUserByOne(vo.getIdNumber());
        int count = 0;
        if(dto == null){
            count = mirgantPopulationMapper.insertData(vo);
        }else{
            BeanUtils.copyProperties(vo,dto);
            count = mirgantPopulationMapper.updateMirgantPopulationByUser(dto);
        }
        return count;
    }

    /**
     * 查询流口数量
     * @param params
     * @return
     */
    @Override
    public int allCount(Map<String, Object> params) {
        return mirgantPopulationMapper.allCount(params);
    }

    @Override
    public List<Map<String, Object>> queryOutStatistics() {
         return mirgantPopulationMapper.queryOutStatistics();
    }

    @Override
    public List<PopulaStatiInfo> queryPopulaInfoByRegion(Map<String, Object> params) {
        int total = mirgantPopulationMapper.allCount(params);
        List<PopulaStatiInfo> list = mirgantPopulationMapper.queryAllPopulaCount();
        for(PopulaStatiInfo info : list){
            Map<String,Object> param = new HashMap<>();
            if(info.getTotal() > 0){
                param.put("regionName",info.getRegionName());
                param.put("registerType","1");
                int ldCount = mirgantPopulationMapper.queryPopulaCountByParam(param);
                param.put("registerType","2");
                int flCount = mirgantPopulationMapper.queryPopulaCountByParam(param);
                info.setLdCount(ldCount);
                info.setRhCount(flCount);
            }
            info.setPercent(rate(new BigDecimal(info.getTotal()),new BigDecimal(total)).toString());
        }
        return list;
    }


    public Double rate(BigDecimal num, BigDecimal mum1){
        if(mum1.compareTo(BigDecimal.ZERO) < 1){
            return 0.00;
        }
        return num.divide(mum1,2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
