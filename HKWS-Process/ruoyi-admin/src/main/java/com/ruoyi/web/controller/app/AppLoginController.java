package com.ruoyi.web.controller.app;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.app.appRole;
import com.ruoyi.system.domain.app.appSysUser;
import com.ruoyi.system.service.app.AppLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @program: data-ruoyi
 * @description: app-登录
 * @author: Yang-Teng-Fei
 * @create: 2020-12-08 10:31
 **/
@Controller
//@RequestMapping("/app")
class AppLoginController extends BaseController {

    @Autowired
    private AppLoginService appLoginService;


    /*@PostMapping("/applogin")
    @ResponseBody
    public AjaxResult ajaxLogin( String userName, String password) {
        AjaxResult ajaxResult = new AjaxResult();
        if(userName.equals("")){
            return AjaxResult.error("用户名不能为空");
        }
        if(password.equals("")){
            return AjaxResult.error("密码不能为空");
        }
//        String md6 = MD5Util.getMD5(userName+password);
        appSysUser sysUser= appLoginService.checkLogin(userName,password);

        if(sysUser!=null){
            Long userId=sysUser.getUserId();
            appRole appRole= appLoginService.checkRole(userId);
            int roleId=appRole.getRoleId();
            if(roleId==1){
                sysUser.setUserType("网格长");
            }else if(roleId==2){
                sysUser.setUserType("网格员");
            }

            return AjaxResult.success(sysUser);
        }else {
            return AjaxResult.error("登录失败");
        }

    }*/
}
