package com.ruoyi.system.service.impl.honey;

import com.ruoyi.system.domain.honey.HousingStatistics;
import com.ruoyi.system.mapper.honey.HousingStatisticsMapper;
import com.ruoyi.system.service.honey.HousingStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Wu
 * @date: 2021-06-10 16:11
 * @description:
 */
@Service
public class HousingStatisticsServiceImpl implements HousingStatisticsService {
    @Autowired
    private HousingStatisticsMapper housingStatisticsMapper;

    @Override
    public HousingStatistics selectAllCount(String deptId) {
        HousingStatistics housingStatistics=new HousingStatistics();
        housingStatistics.setLivePeopleCont(housingStatisticsMapper.livePeopleCont(deptId));//常住人口
        housingStatistics.setMovingPeopleCont(housingStatisticsMapper.movingPeopleCont(deptId));//流动人口
  //      housingStatistics.setKeyPointPeopleCont(housingStatisticsMapper.keyPointPeopleCont());//重点人口
        housingStatistics.setHousInfoCont(housingStatisticsMapper.housInfoCont(deptId));//房屋信息
        housingStatistics.setShopInfoCont(housingStatisticsMapper.shopInfoCont(deptId));//店铺信息
        housingStatistics.setCompanyInfoCont(housingStatisticsMapper.companyInfoCont(deptId));//企业信息
  //      housingStatistics.setReliefMateriaCont(housingStatisticsMapper.reliefMateriaCont());//救援物资
        return housingStatistics;
    }


}
