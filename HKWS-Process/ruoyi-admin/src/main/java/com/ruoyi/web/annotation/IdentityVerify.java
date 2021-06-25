package com.ruoyi.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.ding.annotation
 * @ClassName: IndentityVerify
 * @Author: guohailong
 * @Description: 浙政钉 - 方法标记需要校验
 * @Date: 2021/3/14 14:20
 * @Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface IdentityVerify {
}
