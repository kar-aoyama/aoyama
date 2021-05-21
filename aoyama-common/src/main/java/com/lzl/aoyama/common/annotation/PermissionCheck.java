package com.lzl.aoyama.common.annotation;

import java.lang.annotation.*;

/**
 * @author lzl
 * @ClassName Login
 * @date: 2021/4/26 下午3:57
 * @Description:
 */
@Documented
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionCheck {

    boolean required() default false;
}
