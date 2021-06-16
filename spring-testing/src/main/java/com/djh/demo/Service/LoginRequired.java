package com.djh.demo.Service;

import java.lang.annotation.*;
/**
 * 在需要登录验证的Controller的方法上使用此注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginRequired {
//    boolean loginSuccess() default true;
}
