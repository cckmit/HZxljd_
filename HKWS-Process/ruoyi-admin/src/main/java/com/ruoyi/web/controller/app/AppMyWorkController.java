package com.ruoyi.web.controller.app;

import com.ruoyi.common.core.controller.BaseController;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.app.appRole;
import com.ruoyi.system.service.app.AppLoginService;
import com.ruoyi.system.service.app.AppMyWorkService;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: data-ruoyi
 * @description: app -我的工作
 * @author: Yang-Teng-Fei
 * @create: 2020-12-08 15:17
 **/
@Controller
@RequestMapping("/appwork")
public class AppMyWorkController extends BaseController {

    @Autowired
    private AppMyWorkService appMyWorkService;

    @Autowired
    private SysUserServiceImpl sysUserService;

    @Autowired
    private AppLoginService appLoginService;

    /**
     * 查询统计我的工作事件类型总数（普通用户）
     * @param
     * @return
     */

    /*@PostMapping("/pendingPageFive")
    @ResponseBody
    public AjaxResult PendingPageFive(Long userId){
        Map res = new HashMap();
        if(userId==null){
            return AjaxResult.error("用户id不能为空");
        }
        // 获取登陆人id
        SysUser sysUser=sysUserService.selectUserById(userId);
        if(sysUser==null){
            return AjaxResult.error("找不到该用户");
        }
        appRole appRole= appLoginService.checkRole(userId);
        int roleId=appRole.getRoleId();
        if(roleId==1){
            return AjaxResult.success(adminPendingPageFive(userId));
        }
        String userName=sysUser.getUserName();
        res.put("userName",userName);
        res.put("userId",userId);
        Integer PendingCount =appMyWorkService.PendingCount(res);
        if(PendingCount==null){
            return AjaxResult.success("暂无数据");
        }else {
            res.put("pendCount",PendingCount);
        }
        //统计已逾期事件的总数

        Integer OverdueCount =appMyWorkService.OverdueCount(res);
        if(OverdueCount==null){
            return AjaxResult.success("暂无数据");
        }else {
            res.put("overCount",OverdueCount);
        }
        //统计已完成事件的总数
        Integer Completedcount =appMyWorkService.CompletedCount(res);
        if(Completedcount==null){
            return AjaxResult.success("暂无数据");
        }else {
            res.put("completedCount", Completedcount);
        }
        return AjaxResult.success(res);

    }


    *//**
     * 查询统计我的工作事件类型总数（管理员）
     * @param
     * @return
     *//*
    @ResponseBody
    public AjaxResult adminPendingPageFive(Long userId){
        Map res = new HashMap();
        if(userId==null){
            return AjaxResult.error("用户id不能为空");
        }
        // 获取登陆人id
        SysUser sysUser=sysUserService.selectUserById(userId);
        if(sysUser==null){
            return AjaxResult.error("找不到该用户");
        }
        String userName=sysUser.getUserName();
        res.put("userName",userName);
        res.put("userId",userId);
        Integer PendingCount =appMyWorkService.adminPendingCount(res);
        if(PendingCount==null){
            return AjaxResult.success("暂无数据");
        }else {
            res.put("pendCount",PendingCount);
        }
        //统计已逾期事件的总数

        Integer OverdueCount =appMyWorkService.adminOverdueCount(res);
        if(OverdueCount==null){
            return AjaxResult.success("暂无数据");
        }else {
            res.put("overCount",OverdueCount);
        }
        //统计已完成事件的总数
        Integer Completedcount =appMyWorkService.adminCompletedCount(res);
        if(Completedcount==null){
            return AjaxResult.success("暂无数据");
        }else {
            res.put("completedCount", Completedcount);
        }
        return AjaxResult.success(res);

    }*/







}


