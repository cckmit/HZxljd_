package com.ruoyi.web.controller.system.property.patrol;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.property.XlPropertyPatrolPlan;
import com.ruoyi.system.domain.property.XlPropertyPatrolRecord;
import com.ruoyi.system.domain.property.XlPropertyPatrolSign;
import com.ruoyi.system.service.property.IXlPropertyPatrolPlanService;
import com.ruoyi.system.service.property.IXlPropertyPatrolRecordService;
import com.ruoyi.system.service.property.IXlPropertyPatrolSignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 物业-巡更记录Controller
 *
 * @author ruoyi
 * @date 2021-06-03
 */
@Api("物业-巡更记录")
@Controller
@RequestMapping("/system/property/patrol/record")
public class XlPropertyPatrolRecordController extends BaseController
{
    private String prefix = "system/property/patrol/record";

    @Autowired
    private IXlPropertyPatrolRecordService xlPropertyPatrolRecordService;

    @Autowired
    private IXlPropertyPatrolSignService xlPropertyPatrolSignService;

    @Autowired
    private IXlPropertyPatrolPlanService xlPropertyPatrolPlanService;

    @RequiresPermissions("system/property/patrol:record:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/record";
    }

    /**
     * 查询物业-巡更记录列表
     */
    @RequiresPermissions("system/property/patrol:record:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlPropertyPatrolRecord xlPropertyPatrolRecord)
    {
        startPage();
        List<XlPropertyPatrolRecord> list = xlPropertyPatrolRecordService.selectXlPropertyPatrolRecordList(xlPropertyPatrolRecord);
        return getDataTable(list);
    }

    /**
     * 新增物业-巡更记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存物业-巡更记录
     */
    @RequiresPermissions("system/property/patrol:record:add")
    @Log(title = "物业-巡更记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlPropertyPatrolRecord xlPropertyPatrolRecord)
    {
        return toAjax(xlPropertyPatrolRecordService.insertXlPropertyPatrolRecord(xlPropertyPatrolRecord));
    }

    /**
     * 修改物业-巡更记录
     */
    @GetMapping("/edit/{recordId}")
    public String edit(@PathVariable("recordId") Long recordId, ModelMap mmap)
    {
        XlPropertyPatrolRecord xlPropertyPatrolRecord = xlPropertyPatrolRecordService.selectXlPropertyPatrolRecordById(recordId);
        mmap.put("xlPropertyPatrolRecord", xlPropertyPatrolRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存物业-巡更记录
     */
    @RequiresPermissions("system/property/patrol:record:edit")
    @Log(title = "物业-巡更记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlPropertyPatrolRecord xlPropertyPatrolRecord)
    {
        return toAjax(xlPropertyPatrolRecordService.updateXlPropertyPatrolRecord(xlPropertyPatrolRecord));
    }

    /**
     * 删除物业-巡更记录
     */
    @RequiresPermissions("system/property/patrol:record:remove")
    @Log(title = "物业-巡更记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlPropertyPatrolRecordService.deleteXlPropertyPatrolRecordByIds(ids));
    }

    /**
     * 查看巡更记录详情
     */
    @GetMapping("/detail/{recordId}")
    public String detail(@PathVariable("recordId") Long recordId, ModelMap mmap){
        //巡更记录
        XlPropertyPatrolRecord record = xlPropertyPatrolRecordService.selectXlPropertyPatrolRecordById(recordId);
        //巡更计划描述
        XlPropertyPatrolPlan plan = xlPropertyPatrolPlanService.selectXlPropertyPatrolPlanById(record.getPlanId());
        String planRemark = plan.getPlanRemark();
        //巡更打卡详情
        XlPropertyPatrolSign sign = new XlPropertyPatrolSign();
        sign.setRecordId(recordId);
        List<XlPropertyPatrolSign> signList = xlPropertyPatrolSignService.selectXlPropertyPatrolSignList(sign);
        mmap.put("record", record);
        mmap.put("planRemark", planRemark);
        mmap.put("signList", signList);
        return prefix + "/detail";
    }

    /**
     * 查看巡更点异常详情
     * @param signId
     * @param mmap
     * @return
     */
    @GetMapping("/signDetail/{signId}")
    public String signDetail(@PathVariable("signId") Long signId, ModelMap mmap){
        XlPropertyPatrolSign sign =
                xlPropertyPatrolSignService.selectXlPropertyPatrolSignById(signId);
        //图片
        String image = sign.getImage();
        //转化为数组
        if(image != null){
            String[] images = Convert.toStrArray(image);
            mmap.put("images", images);
        }
        mmap.put("sign", sign);
        return prefix + "/signDetail";
    }
//    @PostMapping("/selectByPatrolProperty/{id}")
//    @ResponseBody
//    public String selectByPatrolProperty(@PathVariable("id") Long recordId)
//    {
////        XlPropertyPatrolRecord xlPropertyPatrolRecord = xlPropertyPatrolRecordService.selectXlPropertyPatrolRecordById(recordId);
////        mmap.put("xlPropertyPatrolRecord", xlPropertyPatrolRecord);
////        return AjaxResult.success(xlEnterpriseInfoService.selectXlEnterpriseInfoById(id));
//    }
        @ApiOperation(value="当前物业下巡更打卡", notes="当前物业下巡更打卡")
        @PostMapping("/selectByPatrolProperty")
        @ResponseBody
        public AjaxResult selectByPatrolProperty(Long patrolPropertyId,String patrolProperty)
        {
            return AjaxResult.success(xlPropertyPatrolSignService.selectByPatrolProperty(patrolPropertyId,patrolProperty));
        }
}
