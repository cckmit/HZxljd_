package com.ruoyi.web.controller.ding;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.app.hkAdminEvent;
import com.ruoyi.system.domain.app.hkEvent;
import com.ruoyi.system.service.app.AppArchivesService;
import com.ruoyi.system.service.app.AppLoginService;
import com.ruoyi.system.service.app.AppMyWorkService;
import com.ruoyi.system.service.ding.DingMyResultService;
import com.ruoyi.web.annotation.IdentityVerify;
import com.ruoyi.web.annotation.IdentityVerifys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.ding
 * @ClassName: DingMyResultController
 * @Author: guohailong
 * @Description: 浙政钉-我的成果
 * @Date: 2021/3/12 0:53
 * @Version: 1.0
 */
@RestController
@RequestMapping("/ding")
public class DingMyResultController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DingMyResultController.class);

    @Autowired
    private AppArchivesService appArchivesService;

    @Autowired
    private AppMyWorkService appMyWorkService;

    @Autowired
    private AppLoginService appLoginService;

    @Autowired
    private DingMyResultService dingMyResultService;


    /**
     * 当前普通用户我的成果
     *
     * @param type   前台传入的日 0，周 1，月 2，年 3
     * @param userId 用户id
     * @return
     */
    @GetMapping("/result/detail/{userId}/{type}")
    @IdentityVerify
    public AjaxResult eventDetail(@PathVariable @IdentityVerifys Long userId, @PathVariable int type) {
        Map<String, Object> res = new HashMap<>();
        //开始时间
        String startTime = "";
        //结束时间.当前时间
        String endTime = DateUtils.getTime();
        //当前日历时间.
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        if (type == 0) {
            c.add(Calendar.DATE, -1);
            // 24小时内
            startTime = DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss", c.getTime());
        } else if (type == 1) {
            c.add(Calendar.DATE, -7);
            // 七天前
            startTime = DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss", c.getTime());
        } else if (type == 2) {
            // 一月前
            c.add(Calendar.MONTH, -1);
            startTime = DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss", c.getTime());
        } else if (type == 3) {
            // 一年前
            c.add(Calendar.YEAR, -1);
            startTime = DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss", c.getTime());
        }
        res.put("lastDay", startTime);
        res.put("nowDay", endTime);
        res.put("userId", userId);
        //查询
        return searchResultData(res);
    }


    /**
     * 查询成果数据并返回
     *
     * @param res
     */
    private AjaxResult searchResultData(Map<String, Object> res) {
        //待处理
        int pendingCount = appMyWorkService.pendingCount(res);
        res.put("pendCount", pendingCount);
        //统计已逾期事件的总数
        int overdueCount = appMyWorkService.overdueCount(res);
        res.put("overCount", overdueCount);
        //统计已完成事件的总数
        /*
        统计已完成事件的总数(普通人员) 处置事件页面选择未处置提交的事件也算到该用户的已处置事件列表
        此处以人的维度查询，只要参与过且非退回的事件都算当前人的已完成事件
        */
        int completedCount = appMyWorkService.completedCount(res);
        res.put("completedCount", completedCount);
        // 获取当前人的所有事件类型名称和数量
        List<hkEvent> appBizTodoItemList = appArchivesService.queryEventType(res);
        // 获取全部事件类型-名称
        List<hkEvent> hkEventList = appArchivesService.allEventType(null);
        if (appBizTodoItemList.size() == 0) {
            for (com.ruoyi.system.domain.app.hkEvent hkEvent : hkEventList) {
                //初始化每种事件的数量为0
                hkEvent.setEventCount(0);
                hkEvent.setPercentage(0f);
            }
        } else {
            //统计总数量
            long total = 0L;
            //遍历每种事件类型
            for (hkEvent event : hkEventList) {
                for (com.ruoyi.system.domain.app.hkEvent hkEvent : appBizTodoItemList) {
                    //比对同类事件
                    if (event.getEventTypeName().equals(hkEvent.getEventTypeName())) {
                        //设置此类事件数量
                        event.setEventCount(hkEvent.getEventCount());
                        //累加总数量
                        total += event.getEventCount();
                        //找到相应数量后需跳出当前循环,防止被覆盖.
                        break;
                    } else {
                        event.setEventCount(0);
                    }
                }
            }
            //设置百分比
            for (hkEvent hkEvent : hkEventList) {
                if (total == 0) {
                    hkEvent.setPercentage(0f);
                } else {
                    hkEvent.setPercentage(hkEvent.getEventCount() * 1f / total);
                }
            }

        }
        res.put("list", hkEventList);
        return AjaxResult.success(res);
    }


    /**
     * 获取管理员查看所有用户的事件
     *
     * @param type
     * @param userId
     * @return
     */
    @GetMapping("/result/allDetail/{userId}/{type}")
    @IdentityVerify
    public AjaxResult allEventDetail(@PathVariable @IdentityVerifys Long userId, @PathVariable int type) {
        Map<String, Object> res = new HashMap<>();
        //开始时间
        String startTime = "";
        //结束时间.当前时间
        String endTime = DateUtils.getTime();
        //当前日历时间.
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        if (type == 0) {
            c.add(Calendar.DATE, -1);
            // 近一天
            startTime = DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss", c.getTime());
        } else if (type == 1) {
            c.add(Calendar.DATE, -7);
            // 近7天
            startTime = DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss", c.getTime());
        } else if (type == 2) {
            c.add(Calendar.DATE, -30);
            // 近30天
            startTime = DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss", c.getTime());
        } else if (type == 3) {
            c.add(Calendar.YEAR, -1);
            // 近一年
            startTime = DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss", c.getTime());
        }
        res.put("lastDay", startTime);
        res.put("nowDay", endTime);
        res.put("userId", userId);
        return searchAdminResultData(res);
    }

    /**
     *
     * @param res
     * @return
     */
    private AjaxResult searchAdminResultData( Map<String, Object> res) {
        int pendingCount = appMyWorkService.adminPendingCount(res);
        res.put("pendCount", pendingCount);
        //统计已逾期事件的总数
        int overdueCount = appMyWorkService.adminOverdueCount(res);
        res.put("overCount", overdueCount);
        //统计已完成事件的总数
        int completedCount = appMyWorkService.adminCompletedCount(res);
        res.put("completedCount", completedCount);
        // 获取管理员查看用户待处理所有的事件
        List<hkAdminEvent> hkAdminEventList = appArchivesService.AdminEventType(res);
        // 获取管理员查看用户已逾期所有的事件
        List<hkAdminEvent> hkAdminEventList1 = appArchivesService.AdminOverEvent(res);
        if (hkAdminEventList.size() == 0 && hkAdminEventList1.size() == 0) {
            //  拿到区域下所有人员
            List<hkAdminEvent> appSysUserList = appLoginService.allUserName((Long) res.get("userId"));
            for (int i = 0; i < appSysUserList.size(); i++) {
                appSysUserList.get(i).setPengNum(0);
                appSysUserList.get(i).setOverNum(0);
            }
            res.put("list", appSysUserList);
        } else if (hkAdminEventList.size() != 0 && hkAdminEventList1.size() == 0) {
            //  拿到区域下所有人员
            List<hkAdminEvent> appSysUserList = appLoginService.allUserName((Long) res.get("userId"));
            for (int i = 0; i < appSysUserList.size(); i++) {
                for (int j = 0; j < hkAdminEventList.size(); j++) {
                    if (hkAdminEventList.get(j).getUserName().equals(appSysUserList.get(i).getUserName())) {
                        appSysUserList.get(i).setPengNum(hkAdminEventList.get(j).getPengNum());
                    }
                }
            }
            res.put("list", appSysUserList);
        } else if (hkAdminEventList.size() == 0 && hkAdminEventList1.size() != 0) {
            //  拿到区域下所有人员
            List<hkAdminEvent> appSysUserList = appLoginService.allUserName((Long) res.get("userId"));
            for (int i = 0; i < appSysUserList.size(); i++) {
                for (int j = 0; j < hkAdminEventList1.size(); j++) {
                    if (hkAdminEventList1.get(j).getUserName().equals(appSysUserList.get(i).getUserName())) {
                        appSysUserList.get(i).setOverNum(hkAdminEventList1.get(j).getOverNum());
                    }
                }
            }
            res.put("list", appSysUserList);
        } else {
            //  拿到区域下所有人员
            List<hkAdminEvent> appSysUserList = appLoginService.allUserName((Long) res.get("userId"));
            for (int k = 0; k < appSysUserList.size(); k++) {
                for (int i = 0; i < hkAdminEventList.size(); i++) {
                    for (int j = 0; j < hkAdminEventList1.size(); j++) {
                        if (hkAdminEventList.get(i).getUserName().equals(appSysUserList.get(k).getUserName())) {
                            appSysUserList.get(k).setPengNum(hkAdminEventList.get(i).getPengNum());
                        }
                        if (hkAdminEventList1.get(j).getUserName().equals(appSysUserList.get(k).getUserName())) {
                            appSysUserList.get(k).setOverNum(hkAdminEventList1.get(j).getOverNum());
                        }

                    }
                }
            }
            res.put("list", appSysUserList);
        }
        return AjaxResult.success(res);
    }



}
