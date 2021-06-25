package com.ruoyi.web.controller.system.property.patrol;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.XianLinConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.property.XlPropertyPatrolPath;
import com.ruoyi.system.domain.property.XlPropertyPatrolPlan;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.IXlVillageService;
import com.ruoyi.system.service.property.IXlPropertyPatrolPathService;
import com.ruoyi.system.service.property.IXlPropertyPatrolPlanService;
import com.ruoyi.system.service.property.IXlPropertyPatrolRecordService;
import com.ruoyi.system.service.property.IXlPropertyPatrolScheduleService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 物业-巡更计划Controller
 *
 * @author ruoyi
 * @date 2021-06-02
 */
@Controller
@RequestMapping("/system/property/patrol/plan")
public class XlPropertyPatrolPlanController extends BaseController
{
    private String prefix = "system/property/patrol/plan";

    @Autowired
    private IXlPropertyPatrolPlanService xlPropertyPatrolPlanService;

    @Autowired
    private IXlPropertyPatrolPathService xlPropertyPatrolPathService;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private IXlPropertyPatrolScheduleService xlPropertyPatrolScheduleService;

    @Autowired
    private IXlPropertyPatrolRecordService xlPropertyPatrolRecordService;

    @Autowired
    private IXlVillageService xlVillageService;

    @RequiresPermissions("system/property/patrol:plan:view")
    @GetMapping()
    public String plan()
    {
        return prefix + "/plan";
    }

    /**
     * 查询物业-巡更计划列表
     */
  //  @RequiresPermissions("system/property/patrol:plan:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlPropertyPatrolPlan xlPropertyPatrolPlan)
    {
        startPage();
        xlPropertyPatrolPlan.setDelFlag(0); //未删除的
        List<XlPropertyPatrolPlan> list =
                xlPropertyPatrolPlanService.selectXlPropertyPatrolPlanVoList(xlPropertyPatrolPlan);
        //巡更周期
        for(XlPropertyPatrolPlan plan: list){
            List<String> timingList = getTiming(plan);
            plan.setPlanCycleTiming(timingList.toString());
        }
        return getDataTable(list);
    }

    /**
     * 新增物业-巡更计划
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        //巡更路线
        XlPropertyPatrolPath xlPropertyPatrolPath  = new XlPropertyPatrolPath();
        xlPropertyPatrolPath.setPathStatus(0); //可用
        xlPropertyPatrolPath.setDelFlag(0); //未删除的
        List<XlPropertyPatrolPath> xlPropertyPatrolPathList =
                xlPropertyPatrolPathService.selectXlPropertyPatrolPathList(xlPropertyPatrolPath);
        //巡更员
        List<SysUser> userList = userService.selectUserByRoleName("物业");
        mmap.put("xlPropertyPatrolPathList",xlPropertyPatrolPathList);
        mmap.put("userList",userList);
        return prefix + "/add";
    }

    /**
     * 新增保存物业-巡更计划
     */
    @RequiresPermissions("system/property/patrol:plan:add")
    @Log(title = "物业-巡更计划", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlPropertyPatrolPlan xlPropertyPatrolPlan)
    {
        return toAjax(xlPropertyPatrolPlanService.insertXlPropertyPatrolPlan(xlPropertyPatrolPlan));
    }

    /**
     * 修改物业-巡更计划
     */
    @GetMapping("/edit/{planId}")
    public String edit(@PathVariable("planId") Long planId, ModelMap mmap)
    {
        //修改的巡更计划
        XlPropertyPatrolPlan xlPropertyPatrolPlan =
                xlPropertyPatrolPlanService.selectXlPropertyPatrolPlanVoById(planId);
        //关联的巡更员
        List<SysUser> users = xlPropertyPatrolPlan.getUsers();
        List<Long> userIds = new ArrayList<>();
        for(SysUser user: users){
            userIds.add(user.getUserId());
        }
        xlPropertyPatrolPlan.setUserIds(userIds);

        //巡更路线
        XlPropertyPatrolPath xlPropertyPatrolPath  = new XlPropertyPatrolPath();
        xlPropertyPatrolPath.setPathStatus(0); //可用
        xlPropertyPatrolPath.setDelFlag(0); //未删除的
        List<XlPropertyPatrolPath> xlPropertyPatrolPathList = xlPropertyPatrolPathService.selectXlPropertyPatrolPathList(xlPropertyPatrolPath);
        //所有巡更员
        List<SysUser> userList = userService.selectUserByRoleName("物业");
        mmap.put("xlPropertyPatrolPathList",xlPropertyPatrolPathList);
        mmap.put("userList",userList);
        mmap.put("xlPropertyPatrolPlan", xlPropertyPatrolPlan);
        return prefix + "/edit";
    }

    /**
     * 修改保存物业-巡更计划
     */
    @RequiresPermissions("system/property/patrol:plan:edit")
    @Log(title = "物业-巡更计划", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlPropertyPatrolPlan xlPropertyPatrolPlan)
    {
        return toAjax(xlPropertyPatrolPlanService.updateXlPropertyPatrolPlan(xlPropertyPatrolPlan));
    }

    /**
     * 删除物业-巡更计划
     */
    @RequiresPermissions("system/property/patrol:plan:remove")
    @Log(title = "物业-巡更计划", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlPropertyPatrolPlanService.deletePlanByIds(ids));
    }


    /**
     * 查看巡更计划详情
     * @param planId
     * @param mmap
     * @return
     */
    @GetMapping("/detail/{planId}")
    public String detail(@PathVariable("planId") Long planId, ModelMap mmap){
        //需要查看详情的巡更计划
        XlPropertyPatrolPlan xlPropertyPatrolPlan =
                xlPropertyPatrolPlanService.selectXlPropertyPatrolPlanVoById(planId);
        //巡更员
        List<String> userNames = new ArrayList<>();
        List<SysUser> users = xlPropertyPatrolPlan.getUsers();
        for(SysUser user: users){
            userNames.add(user.getUserName());
        }
        //巡更周期
        List<String> timingList = getTiming(xlPropertyPatrolPlan);
        xlPropertyPatrolPlan.setPlanCycleTiming(timingList.toString());
        xlPropertyPatrolPlan.setUserNames(userNames);
        mmap.put("xlPropertyPatrolPlan",xlPropertyPatrolPlan);
        return prefix + "/detail";
    }

    /**
     * 校验巡更计划唯一性
     * @param xlPropertyPatrolPlan
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkPlanNameUnique")
    public String checkPlanNameUnique(XlPropertyPatrolPlan xlPropertyPatrolPlan){
        xlPropertyPatrolPlan.setDelFlag(0); //未删除的
        List<XlPropertyPatrolPlan> xlPropertyPatrolPlanList = xlPropertyPatrolPlanService.selectXlPropertyPatrolPlanList(xlPropertyPatrolPlan);
        if(xlPropertyPatrolPlanList.size() <= 0){
            //唯一
            return XianLinConstants.DATA_UNIQUE;
        }else{
            if(null != xlPropertyPatrolPlan.getPlanId()){//非空判断
                //判断是否是当前编辑的信息
                if(xlPropertyPatrolPlan.getPlanId().longValue() == xlPropertyPatrolPlanList.get(0).getPlanId().longValue()){
                    //唯一
                    return XianLinConstants.DATA_UNIQUE;
                }
            }
            //不唯一
            return XianLinConstants.DATA_NOT_UNIQUE;
        }
    }

    //获取巡更计划信息
    @ResponseBody
    @PostMapping("/getPlan")
    public AjaxResult getPlan(XlPropertyPatrolPlan xlPropertyPatrolPlan){
        List<XlPropertyPatrolPlan> xlPropertyPatrolPlanList =
                xlPropertyPatrolPlanService.selectXlPropertyPatrolPlanList(xlPropertyPatrolPlan);
        return AjaxResult.success(xlPropertyPatrolPlanList);
    }

    //巡更周期显示调整
    public List<String> getTiming(XlPropertyPatrolPlan xlPropertyPatrolPlan){

        List<String> timingList = new ArrayList<>();
        String[] timings = Convert.toStrArray(xlPropertyPatrolPlan.getPlanCycleTiming());

        //每天
        for(String timing: timings){
            StringBuffer sbf = new StringBuffer();
            sbf.append(timing).append(":00");
            timingList.add(sbf.toString());
        }

        return timingList;
    }

    /**
     * 查询当前物业下巡更巡查
     */
    @ApiOperation(value="当前物业下巡更巡查", notes="当前物业下巡更巡查")
    @PostMapping("/listPropertyEvent")
    @ResponseBody
    public TableDataInfo listPropertyEvent(String propertyId,String propertyName,XlPropertyPatrolPlan xlPropertyPatrolPlan)
    {//物业id：propertyId,物业名称：propertyName
        startPage();
        Integer[] villageId=xlVillageService.selectVillageId(propertyId,propertyName);
        xlPropertyPatrolPlan.setDelFlag(0); //未删除的
        List<XlPropertyPatrolPlan> list =xlPropertyPatrolPlanService.selectXlPropertyPatrolPlanListByproperty(villageId,xlPropertyPatrolPlan);

        return getDataTable(list);
    }
}
