package com.ruoyi.web.controller.ding;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.HkDingUser;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.ding.DingUser;
import com.ruoyi.system.service.ding.DingUserService;
import com.ruoyi.system.service.ding.IHkDingUserService;
import com.ruoyi.system.utils.MD5Util;
import com.ruoyi.web.config.JWTConfigProperties;
import com.ruoyi.web.jwt.JWTUtil;
import com.ruoyi.web.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.ding
 * @ClassName: DingLoginController
 * @Author: guohailong
 * @Description: 浙政钉登录接口
 * @Date: 2021/3/9 23:57
 * @Version: 1.0
 */
@RestController
@RequestMapping("/ding")
public class DingLoginController {

    private static final Logger logger = LoggerFactory.getLogger(DingLoginController.class);

    @Resource
    private DingUserService dingUserService;

    @Resource
    private JWTConfigProperties jwtConfigProperties;

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private IHkDingUserService hkDingUserService;

    /**
     * 用户账号密码登录 携带用户授权码
     *
     * @param loginName
     * @param password
     * @param authCode
     * @param accountId
     * @return
     */
    @PostMapping("/login/auth")
    public AjaxResult auth(String loginName, String password, String authCode, String accountId) {
        if (StringUtils.isEmpty(loginName)) {
            return AjaxResult.warn("账号不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            return AjaxResult.warn("密码不能为空");
        }
        DingUser userByName = dingUserService.findByName(loginName);
        if (userByName == null) {
            return AjaxResult.warn("账号不存在");
        }
        DingUser user = dingUserService.auth(loginName, MD5Util.getMD5(loginName + password));
        if (user != null) {
            //判断当前是否有管理员权限
            List<SysRole> roles = user.getRoles();
            if (StringUtils.isEmpty(roles)) {
                return AjaxResult.warn("当前账号无权限组");
            }
            Long[] roleIds = new Long[roles.size()];
            for (int i = 0; i < roles.size(); i++) {
                roleIds[i] = roles.get(i).getRoleId();
            }
            user.setRoleIds(roleIds);

            /**
             * 生成jwt-token保存至缓存中,键值都是当前token.
             * 主要是为了实现即使token失效,只要缓存还没失效.
             * 仍然可以根据老的token拿到缓存的值,较新的token.进行校验
             * 若token过期则生成新的有效token
             * 然后再更新缓存及缓存过期时间.
             * 前端携带的token值始终不需要更新.
             * 这里分3种情况.
             * 1.有效token                -> token校验正常
             * 2.过期token,但缓存未过期     -> token校验失效,重新签发有效token.并更新缓存的值
             * 3.过期token,缓存也过期      -> token校验发现缓存不存在了,认为无token.需要重新登录
             * 一般设置redis缓存中的token是jwt生成的token的有效时间的2倍.使用中token会一直更新.用于延长用户在线时间.
             */
            String token = JWTUtil.sign(JSONObject.toJSONString(user), jwtConfigProperties);
            boolean flag = redisUtils.set(jwtConfigProperties.getCachePrefix() + token, token, jwtConfigProperties.getExpire(), TimeUnit.SECONDS);
            if (!flag) {
                logger.error("请检查redis是否启动");
                return AjaxResult.error("redis error");
            }
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("token", token);
            resultMap.put("userInfo", user);
            return AjaxResult.success(resultMap);
        }
        return AjaxResult.warn("密码错误");
    }


}
