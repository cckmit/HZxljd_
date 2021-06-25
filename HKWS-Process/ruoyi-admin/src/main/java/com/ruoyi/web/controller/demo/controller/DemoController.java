package com.ruoyi.web.controller.demo.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.service.IHkMapCoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.demo.controller
 * @ClassName: DemoController
 * @Author: guohailong
 * @Description: 前端组件实例入口
 * @Date: 2021/4/25 20:31
 * @Version: 1.0
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping
    public String index(){
        return "demo/demo";
    }

    @Autowired
    private IHkMapCoverService hkMapCoverService;

    @GetMapping("/getALLMapCoverList")
    @ResponseBody
    public AjaxResult getALLMapCoverList(){
        return AjaxResult.success(hkMapCoverService.getALLMapCoverList());
    }

}
