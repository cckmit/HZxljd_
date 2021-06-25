package com.ruoyi.web.controller.app;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.app.hkAdminEvent;
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

/**
 * @program: data-ruoyi
 * @description: app -获取管理员查看用户所有的事件(按人员)
 * @author: Yang-Teng-Fei
 * @create: 2020-12-11 16:00
 **/
@Controller
//@RequestMapping("/appAdminPersonnel")
public class AppAdminPersonnelController extends BaseController {

    @Autowired
    private AppArchivesService appArchivesService;

    @Autowired
    private AppLoginService appLoginService;

    @Autowired
    private AppMyWorkService appMyWorkService;

    /**
     * 获取管理员查看用户所有的事件(按人员)
     * @param date
     * @param userId
     * @return
     */
    /*@GetMapping("/adminPersonnel")
    @ResponseBody
    public AjaxResult AdminEventType(String date, Long userId){
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

            // 获取管理员查看用户待处理所有的事件
            List<hkAdminEvent> hkAdminEventList =appArchivesService.AdminEventType(res);

            // 获取管理员查看用户已逾期所有的事件
            List<hkAdminEvent> hkAdminEventList1 =appArchivesService.AdminOverEvent(res);
            if(hkAdminEventList.size()==0 && hkAdminEventList1.size()==0 ){
                //  拿到区域下所有人员
                List<hkAdminEvent> appSysUserList=appLoginService.allUserName(userId);
                for (int i = 0; i <appSysUserList.size() ; i++) {
                    appSysUserList.get(i).setPengNum(0);
                    appSysUserList.get(i).setOverNum(0);
                }
                res.put("list",appSysUserList);
                return AjaxResult.success(res);
            }else if(hkAdminEventList.size()!=0 && hkAdminEventList1.size()==0) {
                    //  拿到区域下所有人员
                    List<hkAdminEvent> appSysUserList=appLoginService.allUserName(userId);
                    for (int i = 0; i <appSysUserList.size() ; i++) {
                        for (int j = 0; j <hkAdminEventList.size() ; j++) {
                            if(hkAdminEventList.get(j).getUserName().equals(appSysUserList.get(i).getUserName())){
                                appSysUserList.get(i).setPengNum(hkAdminEventList.get(j).getPengNum());

                            }
                        }

                    }
                    res.put("list",appSysUserList);
            }else if(hkAdminEventList.size()==0 && hkAdminEventList1.size()!=0){
                //  拿到区域下所有人员
                List<hkAdminEvent> appSysUserList=appLoginService.allUserName(userId);
                for (int i = 0; i <appSysUserList.size() ; i++) {
                    for (int j = 0; j <hkAdminEventList1.size() ; j++) {
                        if(hkAdminEventList1.get(j).getUserName().equals(appSysUserList.get(i).getUserName())){
                            appSysUserList.get(i).setOverNum(hkAdminEventList1.get(j).getOverNum());
                        }
                    }

                }
                res.put("list",appSysUserList);
            }else {
                //  拿到区域下所有人员
                List<hkAdminEvent> appSysUserList=appLoginService.allUserName(userId);
                for (int k = 0; k <appSysUserList.size() ; k++) {
                    for (int i = 0; i < hkAdminEventList.size(); i++) {
                        for (int j = 0; j < hkAdminEventList1.size(); j++) {
                            if(hkAdminEventList.get(i).getUserName().equals(appSysUserList.get(k).getUserName())){
                                appSysUserList.get(k).setPengNum(hkAdminEventList.get(i).getPengNum());
                            }
                            if(hkAdminEventList1.get(j).getUserName().equals(appSysUserList.get(k).getUserName())){
                                appSysUserList.get(k).setOverNum(hkAdminEventList1.get(j).getOverNum());
                            }

                        }
                    }
                }

                res.put("list",appSysUserList);
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

            // 获取管理员查看用户待处理所有的事件
            List<hkAdminEvent> hkAdminEventList =appArchivesService.AdminEventType(res);

            // 获取管理员查看用户已逾期所有的事件
            List<hkAdminEvent> hkAdminEventList1 =appArchivesService.AdminOverEvent(res);
            if(hkAdminEventList.size()==0 && hkAdminEventList1.size()==0 ){
                //  拿到区域下所有人员
                List<hkAdminEvent> appSysUserList=appLoginService.allUserName(userId);
                for (int i = 0; i <appSysUserList.size() ; i++) {
                    appSysUserList.get(i).setPengNum(0);
                    appSysUserList.get(i).setOverNum(0);
                }
                res.put("list",appSysUserList);
                return AjaxResult.success(res);
            }else if(hkAdminEventList.size()!=0 && hkAdminEventList1.size()==0) {
                //  拿到区域下所有人员
                List<hkAdminEvent> appSysUserList=appLoginService.allUserName(userId);
                for (int i = 0; i <appSysUserList.size() ; i++) {
                    for (int j = 0; j <hkAdminEventList.size() ; j++) {
                        if(hkAdminEventList.get(j).getUserName().equals(appSysUserList.get(i).getUserName())){
                            appSysUserList.get(i).setPengNum(hkAdminEventList.get(j).getPengNum());

                        }
                    }

                }
                res.put("list",appSysUserList);
            }else if(hkAdminEventList.size()==0 && hkAdminEventList1.size()!=0){
                //  拿到区域下所有人员
                List<hkAdminEvent> appSysUserList=appLoginService.allUserName(userId);
                for (int i = 0; i <appSysUserList.size() ; i++) {
                    for (int j = 0; j <hkAdminEventList1.size() ; j++) {
                        if(hkAdminEventList1.get(j).getUserName().equals(appSysUserList.get(i).getUserName())){
                            appSysUserList.get(i).setOverNum(hkAdminEventList1.get(j).getOverNum());
                        }
                    }

                }
                res.put("list",appSysUserList);
            }else {
                //  拿到区域下所有人员
                List<hkAdminEvent> appSysUserList=appLoginService.allUserName(userId);
                for (int k = 0; k <appSysUserList.size() ; k++) {
                    for (int i = 0; i < hkAdminEventList.size(); i++) {
                        for (int j = 0; j < hkAdminEventList1.size(); j++) {
                            if(hkAdminEventList.get(i).getUserName().equals(appSysUserList.get(k).getUserName())){
                                appSysUserList.get(k).setPengNum(hkAdminEventList.get(i).getPengNum());
                            }
                            if(hkAdminEventList1.get(j).getUserName().equals(appSysUserList.get(k).getUserName())){
                                appSysUserList.get(k).setOverNum(hkAdminEventList1.get(j).getOverNum());
                            }
                        }
                    }
                }

                res.put("list",appSysUserList);
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

            // 获取管理员查看用户待处理所有的事件
            List<hkAdminEvent> hkAdminEventList =appArchivesService.AdminEventType(res);

            // 获取管理员查看用户已逾期所有的事件
            List<hkAdminEvent> hkAdminEventList1 =appArchivesService.AdminOverEvent(res);
            if(hkAdminEventList.size()==0 && hkAdminEventList1.size()==0 ){
                //  拿到区域下所有人员
                List<hkAdminEvent> appSysUserList=appLoginService.allUserName(userId);
                for (int i = 0; i <appSysUserList.size() ; i++) {
                    appSysUserList.get(i).setPengNum(0);
                    appSysUserList.get(i).setOverNum(0);
                }
                res.put("list",appSysUserList);
                return AjaxResult.success(res);
            }else if(hkAdminEventList.size()!=0 && hkAdminEventList1.size()==0) {
                //  拿到区域下所有人员
                List<hkAdminEvent> appSysUserList=appLoginService.allUserName(userId);
                for (int i = 0; i <appSysUserList.size() ; i++) {
                    for (int j = 0; j <hkAdminEventList.size() ; j++) {
                        if(hkAdminEventList.get(j).getUserName().equals(appSysUserList.get(i).getUserName())){
                            appSysUserList.get(i).setPengNum(hkAdminEventList.get(j).getPengNum());

                        }
                    }

                }
                res.put("list",appSysUserList);
            }else if(hkAdminEventList.size()==0 && hkAdminEventList1.size()!=0){
                //  拿到区域下所有人员
                List<hkAdminEvent> appSysUserList=appLoginService.allUserName(userId);
                for (int i = 0; i <appSysUserList.size() ; i++) {
                    for (int j = 0; j <hkAdminEventList1.size() ; j++) {
                        if(hkAdminEventList1.get(j).getUserName().equals(appSysUserList.get(i).getUserName())){
                            appSysUserList.get(i).setOverNum(hkAdminEventList1.get(j).getOverNum());
                        }
                    }

                }
                res.put("list",appSysUserList);
            }else {
                //  拿到区域下所有人员
                List<hkAdminEvent> appSysUserList=appLoginService.allUserName(userId);
                for (int k = 0; k <appSysUserList.size() ; k++) {
                    for (int i = 0; i < hkAdminEventList.size(); i++) {
                        for (int j = 0; j < hkAdminEventList1.size(); j++) {
                            if(hkAdminEventList.get(i).getUserName().equals(appSysUserList.get(k).getUserName())){
                                appSysUserList.get(k).setPengNum(hkAdminEventList.get(i).getPengNum());
                            }
                            if(hkAdminEventList1.get(j).getUserName().equals(appSysUserList.get(k).getUserName())){
                                appSysUserList.get(k).setOverNum(hkAdminEventList1.get(j).getOverNum());
                            }

                        }
                    }
                }

                res.put("list",appSysUserList);
            }
        }else if(date.equals("年")) {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar c = Calendar.getInstance();
            // 当前时间
            String nowDay = format.format(c.getTime()) + " 00:00:00";
            // 过去一年
            c.setTime(new Date());
            c.add(Calendar.YEAR, -1);
            Date y = c.getTime();
            String lastDay = format.format(y);
            res.put("nowDay", nowDay);
            res.put("lastDay", lastDay);
            res.put("userId", userId);
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
            // 获取管理员查看用户待处理所有的事件
            List<hkAdminEvent> hkAdminEventList =appArchivesService.AdminEventType(res);

            // 获取管理员查看用户已逾期所有的事件
            List<hkAdminEvent> hkAdminEventList1 =appArchivesService.AdminOverEvent(res);
            if(hkAdminEventList.size()==0 && hkAdminEventList1.size()==0 ){
                //  拿到区域下所有人员
                List<hkAdminEvent> appSysUserList=appLoginService.allUserName(userId);
                for (int i = 0; i <appSysUserList.size() ; i++) {
                    appSysUserList.get(i).setPengNum(0);
                    appSysUserList.get(i).setOverNum(0);
                }
                res.put("list",appSysUserList);
                return AjaxResult.success(res);
            }else if(hkAdminEventList.size()!=0 && hkAdminEventList1.size()==0) {
                //  拿到区域下所有人员
                List<hkAdminEvent> appSysUserList=appLoginService.allUserName(userId);
                for (int i = 0; i <appSysUserList.size() ; i++) {
                    for (int j = 0; j <hkAdminEventList.size() ; j++) {
                        if(hkAdminEventList.get(j).getUserName().equals(appSysUserList.get(i).getUserName())){
                            appSysUserList.get(i).setPengNum(hkAdminEventList.get(j).getPengNum());

                        }
                    }

                }
                res.put("list",appSysUserList);
            }else if(hkAdminEventList.size()==0 && hkAdminEventList1.size()!=0){
                //  拿到区域下所有人员
                List<hkAdminEvent> appSysUserList=appLoginService.allUserName(userId);
                for (int i = 0; i <appSysUserList.size() ; i++) {
                    for (int j = 0; j <hkAdminEventList1.size() ; j++) {
                        if(hkAdminEventList1.get(j).getUserName().equals(appSysUserList.get(i).getUserName())){
                            appSysUserList.get(i).setOverNum(hkAdminEventList1.get(j).getOverNum());
                        }
                    }

                }
                res.put("list",appSysUserList);
            }else {
                //  拿到区域下所有人员
                List<hkAdminEvent> appSysUserList=appLoginService.allUserName(userId);
                for (int k = 0; k <appSysUserList.size() ; k++) {
                    for (int i = 0; i < hkAdminEventList.size(); i++) {
                        for (int j = 0; j < hkAdminEventList1.size(); j++) {
                            if(hkAdminEventList.get(i).getUserName().equals(appSysUserList.get(k).getUserName())){
                                appSysUserList.get(k).setPengNum(hkAdminEventList.get(i).getPengNum());
                            }
                            if(hkAdminEventList1.get(j).getUserName().equals(appSysUserList.get(k).getUserName())){
                                appSysUserList.get(k).setOverNum(hkAdminEventList1.get(j).getOverNum());
                            }

                        }
                    }
                }

                res.put("list",appSysUserList);
            }
        }

        return AjaxResult.success(res);
    }*/

}
