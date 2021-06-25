package com.ruoyi.web.controller.system.property.patrol;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.property.XlPropertyPatrolStatistic;
import com.ruoyi.system.service.property.IXlPropertyPatrolStatisticService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 物业-巡更统计Controller
 *
 * @author ruoyi
 * @date 2021-06-08
 */
@Api("物业-巡更统计")
@Controller
@RequestMapping("/system/property/patrol/statistic")
public class XlPropertyPatrolStatisticController extends BaseController
{
    private String prefix = "system/property/patrol/statistic";

    @Autowired
    private IXlPropertyPatrolStatisticService xlPropertyPatrolStatisticService;

    @RequiresPermissions("system/property/patrol:statistic:view")
    @GetMapping()
    public String statistic()
    {
        return prefix + "/statistic";
    }

    /**
     * 查询物业-巡更统计列表
     */
    //@RequiresPermissions("system/property/patrol:statistic:list")
    @ApiOperation(value = "查询物业-巡更统计列表" ,notes = "查询物业-巡更统计列表")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlPropertyPatrolStatistic xlPropertyPatrolStatistic)
    {
        startPage();
        List<XlPropertyPatrolStatistic> list = xlPropertyPatrolStatisticService.selectXlPropertyPatrolStatisticList(xlPropertyPatrolStatistic);
        return getDataTable(list);
    }
}
