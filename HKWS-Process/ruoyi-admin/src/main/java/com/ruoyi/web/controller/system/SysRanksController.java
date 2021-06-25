package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.HkEarlyWarning.SysRanksVo;
import com.ruoyi.system.domain.SysRanks;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.SysUserRole;
import com.ruoyi.system.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 用户信息
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/ranks")
public class SysRanksController extends BaseController
{

    private String prefix = "system/ranks";

    @Autowired
    private ISysRanksService ranksService;

    /***队伍逻辑
     * 用户删除，对应的队伍也删除（否则该用户属于队伍但是没有登录浙政钉的账号）
     * 用户修改，是否队伍状态不可修改
     * 队伍删除，对应的用户不一定删除
     *
     *
     *
     *
     * ***/


    @RequiresPermissions("system:ranks:view")
    @GetMapping()
    public String ranks()
    {
        return prefix + "/ranks";
    }

    @RequiresPermissions("system:ranks:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysRanksVo ranks)
    {
        startPage();
        List<SysRanks> list = ranksService.selectRanksList(ranks);
        return getDataTable(list);
    }

    @Log(title = "队伍管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:ranks:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysRanksVo ranks)
    {
        List<SysRanks> list = ranksService.selectRanksList(ranks);
        ExcelUtil<SysRanks> util = new ExcelUtil<SysRanks>(SysRanks.class);
        return util.exportExcel(list, "队伍数据");
    }

    /*@Log(title = "队伍管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:ranks:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<SysRanks> util = new ExcelUtil<SysUser>(SysRanks.class);
        List<SysRanks> ranksList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = userService.importUser(userList, updateSupport, operName);
        return AjaxResult.success(message);
    }*/

    @RequiresPermissions("system:ranks:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<SysRanks> util = new ExcelUtil<SysRanks>(SysRanks.class);
        return util.importTemplateExcel("队伍数据");
    }

}