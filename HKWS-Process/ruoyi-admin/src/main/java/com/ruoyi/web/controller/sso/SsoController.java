package com.ruoyi.web.controller.sso;

import java.net.URLDecoder;

import com.ruoyi.common.utils.DateUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.cj.util.StringUtils;
import com.ruoyi.common.constant.ShiroConstants;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.framework.shiro.authc.UsernameLoginTypeToken;

@RequestMapping("/sso")
@Controller
public class SsoController {

    /**
     * 免登地址
     *
     * @param secretId
     * @param account
     * @param token
     * @param targetUrl
     * @return
     */
    @RequestMapping("/toTargetUrl")
    public String sso(@RequestParam(required = false) String secretId, @RequestParam(required = false) String account,
                      @RequestParam(required = false) String token, @RequestParam(required = false) String targetUrl) {
        if (StringUtils.isNullOrEmpty(secretId) || StringUtils.isNullOrEmpty(account) || StringUtils.isNullOrEmpty(token) || StringUtils.isNullOrEmpty(targetUrl)) {
            return "error/unauth";
        }
        try {
            Object principal = SecurityUtils.getSubject().getPrincipal();
            if (principal != null) {
                return "redirect:" + URLDecoder.decode(targetUrl, "UTF-8");
            }
            UsernameLoginTypeToken upt = new UsernameLoginTypeToken(ShiroConstants.LOGIN_TYPE_USERNAME_SECRET_KEY);

            upt.setUsername(account); // 登录用户名
            upt.setPassword(token.toCharArray()); // 密码组成：sso密钥+用户名+日期，进行md5加密，举例： Digests.md5(secretKey+username+20150101)）
            upt.setSecretId(secretId);
            SecurityUtils.getSubject().login(upt);
            return "redirect:" + URLDecoder.decode(targetUrl, "UTF-8");
        } catch (Exception e) {
            return "error/unauth";
        }
    }

    /**
     * 生成免密链接
     *
     * @param args
     */
    public static void main(String[] args) {
        //免登接口地址
        String apiUrl = "http://localhost/sso/toTargetUrl";
        //配置中心-授权认证管理中配置的密钥
        String secretId = "A989478493";
        String secretKey = "7dd690ba8c8011eb9abb80615f0b6710";
        //免登账号
        String account = "admin";
        //生成token
        String token = Md5Utils.hash(secretKey + account + DateUtils.dateYear());
        //免登后跳转的地址
        String targetUrl = "http://localhost/system/work";
        System.out.println("免登链接为【" + apiUrl + "?secretId=" + secretId + "&account=" + account + "&token=" + token + "&targetUrl=" + targetUrl + "】");
        //发起get请求测试
        HttpUtils.sendGet(apiUrl, "secretId=" + secretId +
                "&account=" + account +
                "&token=" + token +
                "&targetUrl=" + targetUrl);
    }
}
