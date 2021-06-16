package com.djh.demo.Service;

import java.lang.annotation.*;

/**
 * 水果名注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    public String value() default "";
}
