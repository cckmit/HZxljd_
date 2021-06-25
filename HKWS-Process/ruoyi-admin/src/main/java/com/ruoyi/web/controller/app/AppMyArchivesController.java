package com.ruoyi.web.controller.app;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.app.appRole;
import com.ruoyi.system.domain.app.hkEvent;
import com.ruoyi.system.service.app.AppArchivesService;
import com.ruoyi.system.service.app.AppLoginService;
import com.ruoyi.system.service.app.AppMyWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.text.SimpleDateFormat;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: data-ruoyi
 * @description: app-我的档案
 * @author: Yang-Teng-Fei
 * @create: 2020-12-08 19:27
 **/
@Controller
@RequestMapping("/appArchives")
public class AppMyArchivesController extends BaseController {

    @Autowired
    private AppArchivesService appArchivesService;
    @Autowired
    private AppMyWorkService appMyWorkService;
    @Autowired
    private AppLoginService appLoginService;
    /**
     *  获取当前普通用户所有事件类型
     * @param date 前台传入的日，周，月，年
     * @param userId 用户id
     * @return
     */
    /*@GetMapping("/appArchivesCount")
    @ResponseBody
    public AjaxResult appArchivesCount(String date, Long userId){
        Map res = new HashMap();
        // 判断前台传入的日，周，月，年
        if(userId==null){
            return AjaxResult.error("用户id不能为空");
        }
        if( date.equals("")){
            return AjaxResult.error("日期不能为空");
        }
        if( date.equals("日") ||  date.equals("周") ||  date.equals("月") || date.equals("年")){
            System.out.println(11);
        }else {
            return AjaxResult.error("日期格式为日，周，月，年");
        }
        // 判断是否管理员
        appRole appRole= appLoginService.checkRole(userId);
        int role=appRole.getRoleId();
        if(role == 1){
            return AjaxResult.success(appAdminEventType(date, userId));
        }
        if(date.equals("日")){
            // 当天开始时间
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            String nowDay = format.format(c.getTime())+" 00:00:00";
            // 当天结束时间

            Calendar calendar = Calendar.getInstance();
            String lastDay = format.format(calendar.getTime())+" 23:59:59";
            res.put("nowDay",lastDay);
            res.put("lastDay",nowDay);
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
            // 获取当前人的所有事件类型
            List<hkEvent> appBizTodoItemList =appArchivesService.queryEventType(res);
            if(appBizTodoItemList.size()==0){
                // 获取全部事件类型
                hkEvent hk=new hkEvent();
                List<hkEvent> hkEventList=appArchivesService.allEventType(hk);
                for (int i = 0; i <hkEventList.size() ; i++) {
                    hkEventList.get(i).setEventCount(0);
                }
                res.put("list",hkEventList);
            }else {
                // 获取全部事件类型
                hkEvent hk=new hkEvent();
                List<hkEvent> hkEventList=appArchivesService.allEventType(hk);
                for (int j = 0; j <hkEventList.size() ; j++) {
                    for (int i = 0; i <appBizTodoItemList.size() ; i++) {
                        if(hkEventList.get(j).getEventTypeName().equals(appBizTodoItemList.get(i).getEventTypeName())){
                            hkEventList.get(j).setEventCount(appBizTodoItemList.get(i).getEventCount());
                        }
                    }

                }
                res.put("list",hkEventList);
            }


        }else if(date.equals("周")){
            // 获取当前人的所有事件类型
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar c = Calendar.getInstance();
            // 当前时间
            String nowDay = format.format(c.getTime())+" 00:00:00";
            // 过去七天
            c.setTime(new Date());
            c.add(Calendar.DATE, - 7);
            Date d = c.getTime();
            String lastDay = format.format(d);
            res.put("nowDay", nowDay);
            res.put("lastDay",lastDay);
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
            // 获取当前人的所有事件类型
            List<hkEvent> appBizTodoItemList =appArchivesService.queryEventType(res);
            if(appBizTodoItemList.size()==0){
                // 获取全部事件类型
                hkEvent hk=new hkEvent();
                List<hkEvent> hkEventList=appArchivesService.allEventType(hk);
                for (int i = 0; i <hkEventList.size() ; i++) {
                    hkEventList.get(i).setEventCount(0);
                }
                res.put("list",hkEventList);
            }else {
                // 获取全部事件类型
                hkEvent hk=new hkEvent();
                List<hkEvent> hkEventList=appArchivesService.allEventType(hk);
                for (int j = 0; j <hkEventList.size() ; j++) {
                    for (int i = 0; i <appBizTodoItemList.size() ; i++) {
                        if(hkEventList.get(j).getEventTypeName().equals(appBizTodoItemList.get(i).getEventTypeName())){
                            hkEventList.get(j).setEventCount(appBizTodoItemList.get(i).getEventCount());
                        }
                    }

                }
                res.put("list",hkEventList);
            }
        }else if(date.equals("月")){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar c = Calendar.getInstance();
            // 当前时间
            String nowDay = format.format(c.getTime())+" 00:00:00";
            // 过去一月
            c.setTime(new Date());
            c.add(Calendar.MONTH, -1);
            Date m = c.getTime();
            String lastDay = format.format(m);
            res.put("nowDay",nowDay);
            res.put("lastDay",lastDay);
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
            // 获取当前人的所有事件类型
            List<hkEvent> appBizTodoItemList =appArchivesService.queryEventType(res);
            if(appBizTodoItemList.size()==0){
                // 获取全部事件类型
                hkEvent hk=new hkEvent();
                List<hkEvent> hkEventList=appArchivesService.allEventType(hk);
                for (int i = 0; i <hkEventList.size() ; i++) {
                    hkEventList.get(i).setEventCount(0);
                }
                res.put("list",hkEventList);
            }else {
                // 获取全部事件类型
                hkEvent hk=new hkEvent();
                List<hkEvent> hkEventList=appArchivesService.allEventType(hk);
                for (int j = 0; j <hkEventList.size() ; j++) {
                for (int i = 0; i <appBizTodoItemList.size() ; i++) {
                        if(hkEventList.get(j).getEventTypeName().equals(appBizTodoItemList.get(i).getEventTypeName())){
                            hkEventList.get(j).setEventCount(appBizTodoItemList.get(i).getEventCount());
                        }
                    }

                }
                res.put("list",hkEventList);
            }
        }else if(date.equals("年")){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar c = Calendar.getInstance();
            // 当前时间
            String nowDay = format.format(c.getTime())+" 00:00:00";
            // 过去一年
            c.setTime(new Date());
            c.add(Calendar.YEAR, -1);
            Date y = c.getTime();
            String lastDay = format.format(y);
            res.put("nowDay",nowDay);
            res.put("lastDay",lastDay);
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

            // 获取当前人的所有事件类型
            List<hkEvent> appBizTodoItemList =appArchivesService.queryEventType(res);
            if(appBizTodoItemList.size()==0){
                // 获取全部事件类型
                hkEvent hk=new hkEvent();
                List<hkEvent> hkEventList=appArchivesService.allEventType(hk);
                for (int i = 0; i <hkEventList.size() ; i++) {
                    hkEventList.get(i).setEventCount(0);
                }
                res.put("list",hkEventList);
            }else {
                // 获取全部事件类型
                hkEvent hk=new hkEvent();
                List<hkEvent> hkEventList=appArchivesService.allEventType(hk);
                for (int j = 0; j <hkEventList.size() ; j++) {
                    for (int i = 0; i <appBizTodoItemList.size() ; i++) {
                        if(hkEventList.get(j).getEventTypeName().equals(appBizTodoItemList.get(i).getEventTypeName())){
                            hkEventList.get(j).setEventCount(appBizTodoItemList.get(i).getEventCount());
                        }
                    }

                }
                res.put("list",hkEventList);
            }

        }
     return AjaxResult.success(res);
    }
    *//**
     *  获取当前管理员用户所有事件类型
     * @param date 前台传入的日，周，月，年
     * @param userId 用户id
     * @return
     *//*


    @ResponseBody
    public AjaxResult appAdminEventType(String date, Long userId){
        Map res = new HashMap();
        // 判断前台传入的日，周，月，年

        if(userId==null){
            return AjaxResult.error("用户id不能为空");
        }
        if( date.equals("")){
            return AjaxResult.error("日期不能为空");
        }
        if( date.equals("日") ||  date.equals("周") ||  date.equals("月") || date.equals("年")){
            System.out.println(11);
        }else {
            return AjaxResult.error("日期格式为日，周，月，年");
        }
        if(date.equals("日")){
            // 当天开始时间
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            String nowDay = format.format(c.getTime())+" 00:00:00";
            // 当天结束时间

            Calendar calendar = Calendar.getInstance();
            String lastDay = format.format(calendar.getTime())+" 23:59:59";
            res.put("nowDay",lastDay);
            res.put("lastDay",nowDay);
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
            List<hkEvent> appBizTodoItemList =appArchivesService.appAdminEventType(res);
            if(appBizTodoItemList.size()==0){
                // 获取全部事件类型
                hkEvent hk=new hkEvent();
                List<hkEvent> hkEventList=appArchivesService.allEventType(hk);
                for (int i = 0; i <hkEventList.size() ; i++) {
                    hkEventList.get(i).setEventCount(0);
                }
                res.put("list",hkEventList);
            }else {
                // 获取全部事件类型
                hkEvent hk=new hkEvent();
                List<hkEvent> hkEventList=appArchivesService.allEventType(hk);
                for (int j = 0; j <hkEventList.size() ; j++) {
                    for (int i = 0; i <appBizTodoItemList.size() ; i++) {
                        if(hkEventList.get(j).getEventTypeName().equals(appBizTodoItemList.get(i).getEventTypeName())){
                            hkEventList.get(j).setEventCount(appBizTodoItemList.get(i).getEventCount());
                        }
                    }

                }
                res.put("list",hkEventList);
            }

        }else if(date.equals("周")){
            // 获取当前人的所有事件类型
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar c = Calendar.getInstance();
            // 当前时间
            String nowDay = format.format(c.getTime())+" 00:00:00";
            // 过去七天
            c.setTime(new Date());
            c.add(Calendar.DATE, - 7);
            Date d = c.getTime();
            String lastDay = format.format(d);
            res.put("nowDay", nowDay);
            res.put("lastDay",lastDay);
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
            // 获取当前人的所有事件类型
            List<hkEvent> appBizTodoItemList =appArchivesService.appAdminEventType(res);
            if(appBizTodoItemList.size()==0){
                // 获取全部事件类型
                hkEvent hk=new hkEvent();
                List<hkEvent> hkEventList=appArchivesService.allEventType(hk);
                for (int i = 0; i <hkEventList.size() ; i++) {
                    hkEventList.get(i).setEventCount(0);
                }
                res.put("list",hkEventList);
            }else {
                // 获取全部事件类型
                hkEvent hk=new hkEvent();
                List<hkEvent> hkEventList=appArchivesService.allEventType(hk);
                for (int j = 0; j <hkEventList.size() ; j++) {
                    for (int i = 0; i <appBizTodoItemList.size() ; i++) {
                        if(hkEventList.get(j).getEventTypeName().equals(appBizTodoItemList.get(i).getEventTypeName())){
                            hkEventList.get(j).setEventCount(appBizTodoItemList.get(i).getEventCount());
                        }
                    }

                }
                res.put("list",hkEventList);
            }
        }else if(date.equals("月")){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar c = Calendar.getInstance();
            // 当前时间
            String nowDay = format.format(c.getTime())+" 00:00:00";
            // 过去一月
            c.setTime(new Date());
            c.add(Calendar.MONTH, -1);
            Date m = c.getTime();
            String lastDay = format.format(m);
            res.put("nowDay",nowDay);
            res.put("lastDay",lastDay);
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
            // 获取当前人的所有事件类型
            List<hkEvent> appBizTodoItemList =appArchivesService.appAdminEventType(res);
            if(appBizTodoItemList.size()==0){
                // 获取全部事件类型
                hkEvent hk=new hkEvent();
                List<hkEvent> hkEventList=appArchivesService.allEventType(hk);
                for (int i = 0; i <hkEventList.size() ; i++) {
                    hkEventList.get(i).setEventCount(0);
                }
                res.put("list",hkEventList);
            }else {
                // 获取全部事件类型
                hkEvent hk=new hkEvent();
                List<hkEvent> hkEventList=appArchivesService.allEventType(hk);
                for (int j = 0; j <hkEventList.size() ; j++) {
                    for (int i = 0; i <appBizTodoItemList.size() ; i++) {
                        if(hkEventList.get(j).getEventTypeName().equals(appBizTodoItemList.get(i).getEventTypeName())){
                            hkEventList.get(j).setEventCount(appBizTodoItemList.get(i).getEventCount());
                        }
                    }

                }
                res.put("list",hkEventList);
            }
        }else if(date.equals("年")){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar c = Calendar.getInstance();
            // 当前时间
            String nowDay = format.format(c.getTime())+" 00:00:00";
            // 过去一年
            c.setTime(new Date());
            c.add(Calendar.YEAR, -1);
            Date y = c.getTime();
            String lastDay = format.format(y);
            res.put("nowDay",nowDay);
            res.put("lastDay",lastDay);
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
            // 获取当前人的所有事件类型
            List<hkEvent> appBizTodoItemList =appArchivesService.appAdminEventType(res);
            if(appBizTodoItemList.size()==0){
                // 获取全部事件类型
                hkEvent hk=new hkEvent();
                List<hkEvent> hkEventList=appArchivesService.allEventType(hk);
                for (int i = 0; i <hkEventList.size() ; i++) {
                    hkEventList.get(i).setEventCount(0);
                }
                res.put("list",hkEventList);
            }else {
                // 获取全部事件类型
                hkEvent hk=new hkEvent();
                List<hkEvent> hkEventList=appArchivesService.allEventType(hk);
                for (int j = 0; j <hkEventList.size() ; j++) {
                    for (int i = 0; i <appBizTodoItemList.size() ; i++) {
                        if(hkEventList.get(j).getEventTypeName().equals(appBizTodoItemList.get(i).getEventTypeName())){
                            hkEventList.get(j).setEventCount(appBizTodoItemList.get(i).getEventCount());
                        }
                    }

                }
                res.put("list",hkEventList);
            }

        }
        return AjaxResult.success(res);
    }*/




}
