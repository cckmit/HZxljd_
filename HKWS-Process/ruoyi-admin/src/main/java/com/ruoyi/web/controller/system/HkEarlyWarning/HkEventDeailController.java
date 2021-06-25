package com.ruoyi.web.controller.system.HkEarlyWarning;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.service.HkEarlyWarning.HkEventService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author FanKaibiao
 * @date 2021-06-01-16:46
 */
@Controller
@RequestMapping("/system/eventDeal")
public class HkEventDeailController extends BaseController {

    private String prefix = "system/event";

    @Autowired
    private HkEventService hkEventService;

    @RequiresPermissions("system:event:view")
    @GetMapping()
    public String xleventinfo()
    {
        return prefix + "/eventList";
    }

    /**
     * 查询事件信息列表
     */
    @RequiresPermissions("system:event:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HkEventInfo xlEventInfo)
    {
        startPage();
        List<HkEventInfo> list = hkEventService.selectEventList(xlEventInfo);
        return getDataTable(list);
    }

    /**
     * 新增事件信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存事件信息
     */
    @RequiresPermissions("system/xianlin:xleventinfo:add")
    @Log(title = "事件信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HkEventInfo xlEventInfo)
    {
        return toAjax(hkEventService.addHKEventInfo(xlEventInfo));
    }
}
