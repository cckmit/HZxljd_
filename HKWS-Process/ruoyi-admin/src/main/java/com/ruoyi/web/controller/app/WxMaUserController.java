package com.ruoyi.web.controller.app;

import com.ruoyi.common.constant.ShiroConstants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.shiro.authc.UsernameLoginTypeToken;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.app.WxUserLogin;
import com.ruoyi.system.domain.app.appSysUser;
import com.ruoyi.system.service.ISysUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 微信小程序用户接口
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Controller
@RequestMapping("/wechat")
public class WxMaUserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${wx.appId}")
    private String wxAppId;

    @Value("${wx.appSecret}")
    private String wxAppSecret;

    @Value("${wx.msgDataFormat}")
    private String wxDataFormat;

    @Autowired
    private ISysUserService userService;

    /**
     * 获取微信端返回的openid
     * 将sessionId传到前端
     * @param request
     * @return
     */
    @RequestMapping("getToken")
    @ResponseBody
    public AjaxResult getToken(HttpServletRequest request){
        String sessionId=request.getSession().getId();
        /*String code=request.getParameter("code");
        if(StringUtils.isEmpty(code)){
            return AjaxResult.error("系统错误");
        }*/
        /*String result= HttpUtils.sendGet("https://api.weixin.qq.com/sns/jscode2session","appid="+wxAppId+"&secret="+wxAppSecret+"&js_code="+code+"&grant_type=authorization_code");
        System.out.println(result);
        WxSeeionObject wxSeeionObject= JSONArray.parseObject(result,WxSeeionObject.class);*/
        //String openid = UUID.randomUUID().toString().replaceAll("-", "");
        Map<String, Object> map = new HashMap<String, Object>();
        //map.put("openid",openid);
        map.put("session_key",sessionId);
        return AjaxResult.success(map);
    }

    /**
     * 小程序自动登陆
     *
     * 目前小程序仅通过返回的openid自动登陆
     * @param request
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public AjaxResult login(HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        String openid = request.getParameter("openid");
        String session_key = request.getParameter("session_key");
        //String session_key = request.getSession().getId();
        //使用自定义realm验证openid是否已绑定用户
        if(StringUtils.isEmpty(openid)){
            map.put("result","3");
            map.put("msg","首次登陆，请使用账号密码登陆");
            return AjaxResult.success(map);
        }
        UsernameLoginTypeToken token = new UsernameLoginTypeToken(ShiroConstants.LOGIN_TYPE_WX_OPENID,openid, session_key, false);
        Subject subject = SecurityUtils.getSubject();
        appSysUser appUser =  new appSysUser();
        try
        {
            subject.login(token);
            SysUser sysUser = ShiroUtils.getSysUser();
            BeanUtils.copyProperties(sysUser,appUser);
            map.put("result","1");
            map.put("openid",openid);
            map.put("userInfo",appUser);
        }
        catch (UnknownAccountException e)
        {
            //新客户，需要新增注册
            map.put("result","2");
        }
        catch (AuthenticationException e)
        {
            e.printStackTrace();
            map.put("result","0");
            map.put("msg","请使用微信登录平台");
        }
        return AjaxResult.success(map);
    }


    /**
     * 小程序 用户信息登录
     * @param loginUser
     * @return
     */
    @PostMapping("/userLogin")
    @ResponseBody
    public AjaxResult userLogin(WxUserLogin loginUser) {
        String session_key = ServletUtils.getRequest().getSession().getId();
        String userName = loginUser.getUserName();
        String password = loginUser.getPassword();
        if(StringUtils.isEmpty(userName)){
            return AjaxResult.error("登陆用户名不能为空");
        }else if(StringUtils.isEmpty(password)){
            return AjaxResult.error("密码不能为空");
        }
        /*if(PatternUtils.isChinaPhoneLegal(userName)){
            SysUser sysUser = userService.selectUserByPhoneNumber(userName);
            if(sysUser == null){
                return AjaxResult.error("手机号错误");
            }
            if(StringUtils.isEmpty(sysUser.getUserName())){
                return AjaxResult.error("请至运营后台设置用户信息");
            }
            userName = sysUser.getLoginName();
        }*/
        UsernameLoginTypeToken token = new UsernameLoginTypeToken(ShiroConstants.LOGIN_TYPE_WX_USER_PSWD,userName, password, false);
        Subject subject = SecurityUtils.getSubject();
        appSysUser appUser = new appSysUser();
        try
        {
            subject.login(token);
            SysUser sysUser = ShiroUtils.getSysUser();
            sysUser.setOpenId(loginUser.getOpenid());
            String openid = UUID.randomUUID().toString().replaceAll("-", "");
            sysUser.setOpenId(openid);
            userService.updateUserOpenid(sysUser);
            BeanUtils.copyProperties(sysUser,appUser);
            Map<String,Object> result = new HashMap<>();
            result.put("openid",openid);
            result.put("userInfo",appUser);
            AjaxResult success = AjaxResult.success(result);
            return success;
        }
        catch (AuthenticationException e)
        {
            String msg = "用户或密码错误";
            if (com.ruoyi.common.utils.StringUtils.isNotEmpty(e.getMessage()))
            {
                msg = e.getMessage();
            }
            return AjaxResult.error(msg);
        }
    }

}
