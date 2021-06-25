package com.ruoyi.web.controller.system.property.event;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.XlPropertyEvent;
import com.ruoyi.system.service.IXlPropertyEventService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: Riley
 * Date: 2021/5/29
 * Description: 街道派发事件
 */
@Controller
@RequestMapping("/system/property/event/distribute")
public class DistributeEventController extends BaseController {

    private String prefix = "system/property/event/distribute";

    @Autowired
    private IXlPropertyEventService xlPropertyEventService;


    @RequiresPermissions("system/property/event:distribute:view")
    @GetMapping()
    public String distribute()
    {
        return prefix + "/distribute";
    }

    /**
     * 查询物业--事件信息列表
     */
    @RequiresPermissions("system/property/event:distribute:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlPropertyEvent xlPropertyEvent)
    {
        startPage();
        //街道派发事件
        xlPropertyEvent.setEventSource(4);
        List<XlPropertyEvent> list = xlPropertyEventService.selectXlPropertyEventList(xlPropertyEvent);
        return getDataTable(list);
    }

    /**
     * 查看事件详情
     * @param eventId
     * @param mmap
     * @return
     */
    @GetMapping("/detail/{eventId}")
    public String detail(@PathVariable("eventId") Long eventId, ModelMap mmap){
        mmap.put("xlPropertyEvent", xlPropertyEventService.selectXlPropertyEventById(eventId));
        return prefix + "/detail";
    }
}
