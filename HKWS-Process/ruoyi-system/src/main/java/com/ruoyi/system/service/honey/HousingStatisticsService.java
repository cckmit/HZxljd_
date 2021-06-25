package com.ruoyi.system.service.honey;

import com.ruoyi.system.domain.honey.HousingStatistics;

/**
 * @author: Wu
 * @date: 2021-06-10 16:10
 * @description:
 */
public interface HousingStatisticsService {


    /**
     * 统计管理台人口房屋等信息总数
     */
    HousingStatistics selectAllCount(String deptId);
}
