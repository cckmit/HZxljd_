package com.ruoyi.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.common.annotation
 * @ClassName: IdentityVerifys
 * @Author: guohailong
 * @Description: 浙政钉 - 方法参数标记需要校验
 * @Date: 2021/3/14 14:34
 * @Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface IdentityVerifys {

    /** 是否有效 */
    boolean valid() default true;


}
