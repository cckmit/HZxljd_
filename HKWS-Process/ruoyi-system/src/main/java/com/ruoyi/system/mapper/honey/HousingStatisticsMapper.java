package com.ruoyi.system.mapper.honey;

import org.apache.ibatis.annotations.Param;

/**
 * @author: Wu
 * @date: 2021-06-10 15:46
 * @description:
 */
public interface HousingStatisticsMapper {
    /**
     * 常住人口统计
     */
     Long livePeopleCont(@Param("deptId") String deptId);
    /**
     * 流动人口统计
     */
     Long movingPeopleCont(@Param("deptId")String deptId);
    /**
     * 重点人口统计
     */
     Long keyPointPeopleCont(@Param("deptId")String deptId);
    /**
     * 房屋信息统计
     */
     Long housInfoCont(@Param("deptId")String deptId);
    /**
     * 店铺信息统计
     */
     Long shopInfoCont(@Param("deptId")String deptId);
    /**
     * 企业信息统计
     */
     Long companyInfoCont(@Param("deptId")String deptId);
    /**
     * 救援物资统计
     */
     long reliefMateriaCont(@Param("deptId")String deptId);
}
