package com.ruoyi.web.aop;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.exception.ding.IllegalOperationException;
import com.ruoyi.system.domain.ding.DingUser;
import com.ruoyi.web.annotation.IdentityVerifys;
import com.ruoyi.web.config.JWTConfigProperties;
import com.ruoyi.web.jwt.JWTUtil;
import com.ruoyi.web.utils.RedisUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.omg.CORBA.StringHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.ding.aop
 * @ClassName: IdentityVerifyAspect
 * @Author: guohailong
 * @Description: 浙政钉 - 用户身份参数校验aop
 * @Date: 2021/3/14 14:35
 * @Version: 1.0
 */
@Aspect
@Component
public class IdentityVerifyAspect {

    @Resource
    private RedisUtils redisUtils;
    @Resource
    private JWTConfigProperties jwtConfigProperties;

    /**
     * 切点.针对使用IdentityVerify注解的方法进行校验
     */
    @Pointcut(value = "@annotation(com.ruoyi.web.annotation.IdentityVerify)")
    public void identityVerify() {
    }

    /**
     * 前置通知校验参数是否合法
     *
     * @param point
     */
    @Before("identityVerify()")
    public void identityVerify(JoinPoint point) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取当前请求携带的token信息
        String token = request.getHeader("Authorization");
        //获取真实token
        String authorization = (String) redisUtils.get(jwtConfigProperties.getCachePrefix() + token);
        //切点对象
        Object[] params = point.getArgs();
        if (params.length == 0) {
            return;
        }
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        //参数注解，1维是每个参数，2维每个参数对应的注解
        Annotation[][] annotations = method.getParameterAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            Object param = params[i];
            Annotation[] paramAnn = annotations[i];
            //参数为空，直接下一个参数
            if (param == null || paramAnn.length == 0) {
                continue;
            }
            for (Annotation annotation : paramAnn) {
                //针对使用IdentityVerifys注解的方法参数进行校验
                if (annotation.annotationType().equals(IdentityVerifys.class)) {
                    //校验该参数，验证一次退出该注解
                    //解密token中用户id，校验参数中传过来的userId
                    String decryptUserInfo = JWTUtil.getUserInfo(authorization);
                    DingUser decryptDingUser = JSONObject.parseObject(decryptUserInfo, DingUser.class);
                    long paramUserId = (long) param;
                    long decryptDingUserId = decryptDingUser.getUserId();
                    if (paramUserId != decryptDingUserId) {
                        throw new IllegalOperationException("非法访问，已被禁止");
                    }
                    break;
                }
            }
        }


    }

}
