package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.XlPropertyEvent;
import com.ruoyi.system.domain.honey.PropertyEventVo;
import com.ruoyi.system.service.IXlPropertyEventService;
import com.ruoyi.system.service.IXlVillageService;
import com.ruoyi.system.service.honey.GeneralService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 物业--事件信息Controller
 *
 * @author ruoyi
 * @date 2021-05-20
 */
@Api(tags="物业--事件信息")
@Controller
@RequestMapping("/system/propertyEvent")
public class XlPropertyEventController extends BaseController
{
    private String prefix = "system/propertyEvent";

    @Autowired
    private IXlPropertyEventService xlPropertyEventService;
    @Autowired
    private IXlVillageService xlVillageService;
    @Autowired
    private GeneralService generalService;

    @RequiresPermissions("system:propertyEvent:view")
    @GetMapping()
    public String propertyEvent()
    {
        return prefix + "/propertyEvent";
    }

    /**
     * 查询物业--事件信息列表
     */
    @ApiOperation(value="事件信息列表", notes="小区物业事件信息列表")
    //@RequiresPermissions("system:propertyEvent:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PropertyEventVo propertyEventVo)
    {
        startPage();
        List<PropertyEventVo> list = xlPropertyEventService.selectPropertyEventVoList(propertyEventVo);
        return getDataTable(list);
    }

    /**
     * 导出物业--事件信息列表
     */
    @RequiresPermissions("system:propertyEvent:export")
    @Log(title = "物业--事件信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlPropertyEvent xlPropertyEvent)
    {
        List<XlPropertyEvent> list = xlPropertyEventService.selectXlPropertyEventList(xlPropertyEvent);
        ExcelUtil<XlPropertyEvent> util = new ExcelUtil<XlPropertyEvent>(XlPropertyEvent.class);
        return util.exportExcel(list, "propertyEvent");
    }

    /**
     * 新增物业--事件信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存物业--事件信息
     */
    @ApiOperation(value="事件信息新增", notes="事件信息新增")
  //  @RequiresPermissions("system:propertyEvent:add")
    @Log(title = "物业--事件信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlPropertyEvent xlPropertyEvent)
    {
        if (xlPropertyEvent.getReporter()!=null&&xlPropertyEvent.getReporter()!=""){
            xlPropertyEvent.setEventStatus(1);//待处理
        }
        return toAjax(xlPropertyEventService.insertXlPropertyEvent(xlPropertyEvent));
    }

    /**
     * 修改物业--事件信息
     */
    @GetMapping("/edit/{eventId}")
    public String edit(@PathVariable("eventId") Long eventId, ModelMap mmap)
    {
        XlPropertyEvent xlPropertyEvent = xlPropertyEventService.selectXlPropertyEventById(eventId);
        mmap.put("xlPropertyEvent", xlPropertyEvent);
        return prefix + "/edit";
    }

    /**
     * 修改保存物业--事件信息
     */
    @ApiOperation(value="事件信息修改", notes="事件信息修改")
 //   @RequiresPermissions("system:propertyEvent:edit")
    @Log(title = "物业--事件信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HttpServletRequest request, HttpServletResponse response, XlPropertyEvent xlPropertyEvent, @RequestParam("file") MultipartFile[] file)
    {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        resultMap=generalService.uploadImage(request,response,file);
        String imgs=resultMap.get("imgs").toString();
        if (xlPropertyEvent.getReporter()!=null&&xlPropertyEvent.getReporter()!=""){
            xlPropertyEvent.setEventStatus(1);//待处理
        }
        if (xlPropertyEvent.getHandler()!=null&&xlPropertyEvent.getHandler()!=""){
            xlPropertyEvent.setEventStatus(2);//处理中
        }
        if (xlPropertyEvent.getFinishContent()!=null&&xlPropertyEvent.getFinishContent()!=""){
            xlPropertyEvent.setEventStatus(3);//已处理
        }
        if (imgs!=null&&!imgs.trim().isEmpty()){
            xlPropertyEvent.setFinishImage(imgs);
        }
        return toAjax(xlPropertyEventService.updateXlPropertyEvent(xlPropertyEvent));
    }

    /**
     * 删除物业--事件信息
     */
    @RequiresPermissions("system:propertyEvent:remove")
    @Log(title = "物业--事件信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlPropertyEventService.deleteXlPropertyEventByIds(ids));
    }

//    @RequiresPermissions("system:propertyEvent:detail")
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id")String id, ModelMap mmap){
        PropertyEventVo propertyEventVo =xlPropertyEventService.selectPropertyEventVo(Long.valueOf(id));
        mmap.put("propertyEventVo", propertyEventVo);
        return prefix + "/detail";
    }

    @PostMapping("/details/{id}")
    @ResponseBody
    public AjaxResult details(@PathVariable("id") Long id)
    {
        return AjaxResult.success(xlPropertyEventService.selectPropertyEventVo(id));
    }

    /**
     * 当前物业下整改工程
     */
    @ApiOperation(value="当前物业下整改工程", notes="当前物业下整改工程")
    //@RequiresPermissions("system:propertyEvent:list")
    @PostMapping("/Projectlist")
    @ResponseBody
    public TableDataInfo Projectlist(String id,String propertyName,PropertyEventVo propertyEventVo)
    {
        startPage();
        Integer[] villageId=xlVillageService.selectVillageId(id,propertyName);
        List<PropertyEventVo> list = xlPropertyEventService.selectPropertyEventVoProjectList(villageId,propertyEventVo);
        return getDataTable(list);
    }
}
