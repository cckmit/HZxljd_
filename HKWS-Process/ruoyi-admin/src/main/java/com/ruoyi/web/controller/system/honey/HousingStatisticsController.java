package com.ruoyi.web.controller.system.honey;

import com.ruoyi.system.domain.honey.HousingStatistics;
import com.ruoyi.system.service.honey.HousingStatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Wu
 * @date: 2021-06-10 16:15
 * @description: 人口及房屋等总数统计
 */
@Api(tags="信息总数统计")
@Controller
@RequestMapping("/system/HousingStatistics")
public class HousingStatisticsController {
    @Autowired
    private HousingStatisticsService housingStatisticsService;
    /*
     * @return: java.lang.Long
     * @author:Wu
     * @date: 2021-06-10 16:25
     * @description:统计管理台人口房屋等信息总数
     */
    @ApiOperation(value="统计管理台人口房屋等信息总数", notes="统计管理台人口房屋等信息总数")
    @PostMapping(value = "/selectAllCount")
    @ResponseBody
    public HousingStatistics selectAllCount(String deptId){
        return housingStatisticsService.selectAllCount(deptId);
    }
}
