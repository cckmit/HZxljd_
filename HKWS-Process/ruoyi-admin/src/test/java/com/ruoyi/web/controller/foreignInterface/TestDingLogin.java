package com.ruoyi.web.controller.foreignInterface;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.domain.ding.DingUser;
import com.ruoyi.system.service.ding.DingUserService;
import com.ruoyi.system.utils.MD5Util;
import com.ruoyi.web.config.JWTConfigProperties;
import com.ruoyi.web.jwt.JWTUtil;
import com.ruoyi.web.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.foreignInterface
 * @ClassName: TestDingLogin
 * @Author: guohailong
 * @Description:
 * @Date: 2021/4/21 17:58
 * @Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDingLogin {

    @Resource
    private DingUserService dingUserService;

    @Resource
    private JWTConfigProperties jwtConfigProperties;
    @Resource
    RedisUtils redisUtils;

    @Test
    public void run(){
        String loginName = "linfang";
        String password = "linfang";
        DingUser user = dingUserService.auth(loginName, MD5Util.getMD5(loginName + password));
        String token = JWTUtil.sign(JSONObject.toJSONString(user), jwtConfigProperties);
        boolean flag = redisUtils.set(jwtConfigProperties.getCachePrefix() + token, token, jwtConfigProperties.getExpire(), TimeUnit.SECONDS);

        System.out.println(token);
    }
}
