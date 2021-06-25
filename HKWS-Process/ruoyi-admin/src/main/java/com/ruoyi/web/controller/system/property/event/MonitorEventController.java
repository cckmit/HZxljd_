package com.ruoyi.web.controller.system.property.event;

import com.ruoyi.common.config.Global;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.XlPropertyEvent;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.IXlPropertyEventService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * author: Riley
 * Date: 2021/5/29
 * Description: 智慧监测事件
 */
@Controller
@RequestMapping("/system/property/event/monitor")
public class MonitorEventController extends BaseController {

    private String prefix = "system/property/event/monitor";

    @Autowired
    private IXlPropertyEventService xlPropertyEventService;

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private ISysUserService userService;

    @RequiresPermissions("system/property/event:monitor:view")
    @GetMapping()
    public String monitor()
    {
        return prefix + "/monitor";
    }

    /**
     * 查询物业--事件信息列表
     */
    @RequiresPermissions("system/property/event:monitor:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlPropertyEvent xlPropertyEvent)
    {
        startPage();
        //智慧监测事件
        xlPropertyEvent.setEventSource(1);
        List<XlPropertyEvent> list = xlPropertyEventService.selectXlPropertyEventList(xlPropertyEvent);
        return getDataTable(list);
    }

    /**
     * 立即处理
     * @param eventId
     * @return
     */
    @GetMapping("/handle/{eventId}")
    public String goHandle(@PathVariable("eventId") Long eventId, ModelMap mmap){
        //查询所有物业人员
        List<SysUser> userList = userService.selectUserByRoleName("物业");
        mmap.put("eventId",eventId);
        mmap.put("userList",userList);
        return prefix + "/handle";
    }

    /**
     * 保存处理
     * @param xlPropertyEvent
     * @return
     */
    @ResponseBody
    @PostMapping("/handle")
    public AjaxResult handle(XlPropertyEvent xlPropertyEvent){
        if(null == xlPropertyEvent.getHandlerId()){
            return AjaxResult.error("请选择处理人！");
        }
        //修改处理状态为处理中
        xlPropertyEvent.setEventStatus(2);
        //处理时间
        xlPropertyEvent.setHandleTime(DateUtils.getNowDate());
        return toAjax(xlPropertyEventService.updateXlPropertyEvent(xlPropertyEvent));
    }

    /**
     * 完成处理
     * @param eventId
     * @param mmap
     * @return
     */
    @GetMapping("/completion/{eventId}")
    public String completion(@PathVariable("eventId") Long eventId, ModelMap mmap){
        mmap.put("xlPropertyEvent",xlPropertyEventService.selectXlPropertyEventById(eventId));
        return prefix + "/completion";
    }

    /**
     * 保存完成处理
     * @param xlPropertyEvent
     * @return
     */
    @ResponseBody
    @PostMapping("/completion")
    public AjaxResult saveCompletion(XlPropertyEvent xlPropertyEvent){
        //事件状态修改为已处理
        xlPropertyEvent.setEventStatus(3);
        //事件完成时间
        xlPropertyEvent.setFinishTime(DateUtils.getNowDate());
        return toAjax(xlPropertyEventService.updateXlPropertyEvent(xlPropertyEvent));
    }

    //多文件上传
    @ResponseBody
    @RequestMapping("/upload")
    public AjaxResult  batchUpload(MultipartFile[] files){
        try
        {
            // 上传文件路径
            String filePath = Global.getUploadPath();
            //上传并返回新文件名称
            StringBuilder sb = new StringBuilder();
            for(MultipartFile file:files){
                String fileName = FileUploadUtils.upload(filePath, file);
                String url = serverConfig.getUrl() + fileName;
                sb.append(url + ",");
            }
            //移除最后一个逗号
            String fileUrl = sb.toString().substring(0,sb.toString().length()-1);
            return AjaxResult.success(fileUrl);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return AjaxResult.error();
        }
    }

    /**
     * 查看处理流程
     * @return
     */
    @GetMapping("/process/{eventId}")
    public String process(@PathVariable("eventId") Long eventId, ModelMap mmap){
        XlPropertyEvent xlPropertyEvent =
                xlPropertyEventService.selectXlPropertyEventById(eventId);
        //处理人信息
        SysUser user = userService.selectUserById(xlPropertyEvent.getHandlerId());
        mmap.put("xlPropertyEvent", xlPropertyEvent);
        mmap.put("user",user);
        return prefix + "/process";
    }
}
