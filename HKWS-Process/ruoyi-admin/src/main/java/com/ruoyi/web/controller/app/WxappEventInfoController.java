package com.ruoyi.web.controller.app;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.app.WxHkEventVo;
import com.ruoyi.system.domain.app.appHkevent;
import com.ruoyi.system.service.app.AppEventInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信小程序
 */
@Controller
@RequestMapping("/wxappEventInfo")
public class WxappEventInfoController {

    /**图片显示地址**/
    @Value("${img.show-url}")
    private String imgUrls;

    @Autowired
    private AppEventInfoService appEventInfoService;

    /**当前接口需要经过拦截器，访问此接口时，在线记录表会更新session最后访问时间**/


    /**
     * 小程序待处理事件列表
     * @param vo
     * @return
     */
    @PostMapping("/selectTwoHkEvent")
    @ResponseBody
    public AjaxResult selectTwoHkEvent(WxHkEventVo vo){
        Map<String,Object> param = new HashMap<>();
        Page<appHkevent> pages = PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        if(StringUtils.isNull(vo.getUserId())){
            return AjaxResult.error("用户id不能为空");
        }
        List<appHkevent> appHkeventList = appEventInfoService.selectTwoHkEvent(vo);
        for(appHkevent event : appHkeventList){
            // 获取当前时间
            Date date1 = new Date();
            String nowDayTime = String.valueOf(date1.getTime()/1000);
            // 获取逾期时间
            Date date=event.getTimeOut();
            String timestamp = String.valueOf(date.getTime()/1000);
            Integer time=Integer.valueOf(timestamp);
            Integer times=Integer.valueOf(nowDayTime);
            // 得出逾期时间
            Integer overTime=times-time;
            event.setOverTime(overTime);
        }
        param.put("appHkeventList", appHkeventList);
        param.put("pageTotal", pages.getTotal());
        param.put("pageNum", vo.getPageNum());
        param.put("pageSize",vo.getPageSize());
        param.put("page", pages.getPages());
        return AjaxResult.success(param);
    }
}
