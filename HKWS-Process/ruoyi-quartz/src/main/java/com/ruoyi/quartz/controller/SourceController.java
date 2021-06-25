package com.ruoyi.quartz.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.exception.job.TaskException;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.quartz.domain.Source;
import com.ruoyi.quartz.domain.SysJob;
import com.ruoyi.quartz.service.ISysJobService;
import com.ruoyi.quartz.service.SourceService;


import com.ruoyi.quartz.util.CronUtils;
import com.ruoyi.system.domain.SysUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @program: data-ruoyi
 * @description:数据源接入
 * @author: Yang-Teng-Fei
 * @create: 2020-11-06 11:38
 **/
@Controller
@RequestMapping("/monitor/source")
public class SourceController extends BaseController {

    private static Logger logger = LogManager.getLogger();

    private String prefix = "monitor/job";

    @Autowired
    private SourceService sourceService;

    @Autowired
    private ISysJobService iSysJobService;

    /**
     * 查询数据源信息
     */
    @RequiresPermissions("monitor:job:view")
    @GetMapping()
    public String config()
    {
        return prefix + "/source";
    }

    @RequiresPermissions("monitor:job:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Source Source)
    {
        startPage();
        List<Source> list=sourceService.querySourceInfo(Source);
        return getDataTable(list);
    }

    /**
     * 新增数据源信息
     */
    @GetMapping("/add")
    public String add(ModelMap mp)

    {
        // 取身份信息
        String user = ShiroUtils.getLoginName();
        mp.put("createUser",user);
        return prefix + "/sourceAdd";
    }

    @RequiresPermissions("monitor:job:add")
    @Log(title = "数据源添加", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addsave(@Validated Source source) throws TaskException, SchedulerException {
        return toAjax(sourceService.addHkSource(source));

    }
    
    

    /**
     * 数据源Excal接入
     * @param source
     * @param file
     * @return
     * @throws Exception
     */
    @RequiresPermissions("system:product:add")
    @Log(title = "添加数据源接入", businessType = BusinessType.INSERT)
    @PostMapping("/addExcal")
    @ResponseBody
    public AjaxResult addSave(@Validated Source source,@RequestParam("file") MultipartFile file) throws Exception
    {
        // 添加数据源id
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        source.setUuid(uuid);
        // 获取Excal地址
          String soureAddress=file.getOriginalFilename();
          source.setSourceAddress(soureAddress);
        return toAjax(sourceService.addHkSource(source));
    }
    /**
     * 修改数据源信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        // 判断同步频率
        Source source= sourceService.findHkSource(id);
//        String source1=source.getSourceSynchronize();
//        String time = source1.substring(source1.indexOf("/")+1);
//        source.setSourceSynchronize(time);
//        String AA = source1.substring(0,3);
//        source.setTime(AA);
//
//        // 判断接入方式
//        String sourceAccess=source.getSourceAccess();
//        if (sourceAccess.indexOf("/") == -1) {
//            source.setSourceAccess(sourceAccess);
//        }else {
//            String str1 = sourceAccess.substring(0, sourceAccess.indexOf("/"));
//            String str2 = sourceAccess.substring(str1.length() + 1, sourceAccess.length());
//            source.setSourceAccess(str1);
//            source.setSql(str2);
//        }
        // 查询所属定时任务
        String uuid=source.getUuid();
        SysJob sysJob=iSysJobService.findSysJobById(uuid);
        Long Sysid=sysJob.getJobId();
        source.setSysid(Sysid);
        mmap.put("source", source);
        // 取身份信息
        String user = ShiroUtils.getLoginName();
        mmap.put("updateUser",user);

        return prefix + "/sourceEdit";
    }

    @RequiresPermissions("monitor:job:edit")
    @Log(title = "数据源修改", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult updateSave(@Validated Source source) throws TaskException, SchedulerException
    {
        return AjaxResult.success(sourceService.updateHkSource(source));

    }

    /**
     * 删除数据源信息
     */
    @RequiresPermissions("monitor:job:remove")
    @Log(title = "数据源删除", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sourceService.deleteHkSource(ids));
    }

    /**
     * 校验数据源名称
     * @return
     */
    @PostMapping("/checkConfigKeyUnique")
    @ResponseBody
    public int checkConfigKeyUnique(Source source)
    {
        return sourceService.findHkSourceName(source);
    }

    /**
     * 检测测试数据库
     */
    @RequestMapping("/connection")
    @ResponseBody
    public AjaxResult connection(String sourceAccess,
                                 String sourceHost,
                                 String sourcePort,
                                 String sourceUsername,
                                 String sourcePassword){

        Map<String, Object> map=sourceService.connection(sourceAccess,sourceHost,sourcePort,sourceUsername,sourcePassword);
        if(map.get("conn") != null && map.get("conn")!=""){  //如果条件为真
            return AjaxResult.success("连接成功");
        }else{
            return AjaxResult.warn("连接失败");
        }
    }



    /**
     * 检测api接口
     * @param sourceAddress
     * @return
     */
    @RequestMapping("/apiCheck")
    @ResponseBody
    public AjaxResult connectingAddress(String sourceAddress){
        Map<String, Object> map=sourceService.apiTest(sourceAddress);
        if(map.get("flag") != null && !Boolean.parseBoolean((map.get("flag")).toString())){  //如果条件为真
            return AjaxResult.warn("连接失败");
        }else{
            return AjaxResult.success("连接成功");
        }
    }



    /**
     * 模板下载
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/download")
    public void download(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        OutputStream out = null;
        FileInputStream in = null;

        try {
            String fileName = "APP接口清单V1.4";
            // 读取模板
            String excelPath = request.getSession().getServletContext()
                    .getRealPath("/static/APP接口清单V1.4.xlsx");

            fileName = URLEncoder.encode(fileName, "UTF-8");

            response.reset();
            // 追加时间
            response.addHeader("Content-Disposition", "attachment;filename="
                    + fileName + ".xlsx");
            response.setContentType("application/octet-stream;charset=UTF-8");

            out = response.getOutputStream();
            in = new FileInputStream(excelPath);

            byte[] b = new byte[1024];
            int len;

            while ((len = in.read(b)) > 0) {
                response.getOutputStream().write(b, 0, len);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                in.close();
                in = null;
            }
            if (null != out) {
                out.close();
                out = null;
            }
        }

    }
}
