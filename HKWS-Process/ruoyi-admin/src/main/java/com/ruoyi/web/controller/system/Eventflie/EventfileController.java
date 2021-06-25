package com.ruoyi.web.controller.system.Eventflie;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.quartz.domain.Source;
import com.ruoyi.system.domain.HkEClassification;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.service.HkEarlyWarning.HkEventService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: data-ruoyi
 * @description:事件档案
 * @author: Yang-Teng-Fei
 * @create: 2020-11-08 15:24
 **/
@Controller
@RequestMapping("system/eventFile")
public class EventfileController extends BaseController {

    private String prefix = "system/eventFile";

    @Autowired
    private HkEventService hkEventService;


    @RequiresPermissions("system/eventFile:view")
    @GetMapping()
    public String eventFlie()
    {
        return prefix + "/File";
    }

    @RequiresPermissions("system:eventFile:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HkEventInfo hkEventInfo)
    {
        startPage();
        List<HkEventInfo> list= hkEventService.queryHkEventInfo(hkEventInfo);
        return getDataTable(list);
    }

    @GetMapping("/detail/{id}")
    public String add(@PathVariable("id") Integer id,ModelMap mmap)
    {
        return prefix + "/detail";
    }
}
