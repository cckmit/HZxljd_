package com.ruoyi.quartz.task;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.spring.SpringUtils;

import com.ruoyi.quartz.service.SourceService;


import com.ruoyi.quartz.util.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * 定时任务调度测试
 * 
 * @author ruoyi
 */
@Component("ryTask")
public class RyTask
{


//    private  SourceService sourceService= SpringContextUtil.getContext().getBean(SourceService.class);
    @Autowired
    private SourceService sourceService;

    /**
     * api定时器
     * @param params
     */
    public void ryParams(String params)
    {
        System.out.println("执行有参方法：" + params);
        sourceService.findHkAddress(params);


    }

    /**
     * 数据库定时器
     * @param params
     */
    public void sqlParams(String params){
        System.out.println("执行有参方法：" + params);
        sourceService.findHkAddress(params);

    }



}
