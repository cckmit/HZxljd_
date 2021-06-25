package com.ruoyi.system.domain.Annnotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommonTimeFrameAnnotation {

    public String name() default "";
}
