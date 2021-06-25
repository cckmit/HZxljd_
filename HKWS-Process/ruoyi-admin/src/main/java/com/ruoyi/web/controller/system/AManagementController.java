package com.ruoyi.web.controller.system;

import com.github.pagehelper.PageInfo;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.elas.AESKey;
import com.ruoyi.common.utils.elas.DateUtils;
import com.ruoyi.system.domain.HkAConfiguration;
import com.ruoyi.system.domain.HkAManagement;
import com.ruoyi.system.service.HkAManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.*;

@Controller
@RequestMapping("system/open")
@Api(tags = "授权接口")
public class AManagementController extends BaseController {
    @Autowired
    private HkAManagementService aManagementService;
    private String prefix = "system/open";

    @GetMapping()
    public String config()
    {
        return prefix + "/open";
    }

    @PostMapping("/list")
    @ResponseBody
    @ApiOperation("授权菜单")
    public TableDataInfo manage(HkAManagement aManagement) {

        startPage();
        List<HkAManagement> list=aManagementService.selectRoleList(aManagement);
        return getDataTable(list);

    }

    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        String tableData="[{\"commonlyId\":\"8b9c8733d4834dfeba90f7bb2fdb728a\",\"createDate\":1605249925000,\"fieldCommit\":\"www\",\"fieldLength\":\"255\",\"fieldName\":\"\",\"fieldNull\":\"\",\"fieldType\":\"\",\"id\":52,\"params\":{}}]";
        mmap.put("tableData",tableData);
        return prefix + "/add";
    }

    @PostMapping("/miyao")
    @ResponseBody
    public Map<String,Object> miyao() throws NoSuchAlgorithmException {
        Map<String,Object> map=new HashMap<>();
        map.put("sid",AESKey.getUUID());
        map.put("code",AESKey.getRandomNickname(10));
       return map;
    }
    @PostMapping("/addHkAManagement")
    @ResponseBody
    @ApiOperation("创建授权单位")
    public AjaxResult addHkAManagement(HkAManagement aManagement)  {
        aManagement.setAmadmin("管理员");//预留
        aManagement.setAmsecreprivate("123");//预留私钥
        aManagement.setMonths(AESKey.nDaysBetweenTwoDate(aManagement.getAmeffectivedate(),aManagement.getAmexpirationdate()));

//        aManagement.setMonths((int) AESKey.calculateTimeGapDay(aManagement.getAmeffectivedate(),aManagement.getAmexpirationdate()));
        aManagementService.addHkAManagement(aManagement);

     return AjaxResult.success("ok");
    }

    /**
     * 删除行动配置
     * @param ids
     * @return
     */
    @RequiresPermissions("system:gzhi:remove")
    @Log(title = "开放配置删除", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(aManagementService.deleteHKAconfiguration(ids));
    }
}