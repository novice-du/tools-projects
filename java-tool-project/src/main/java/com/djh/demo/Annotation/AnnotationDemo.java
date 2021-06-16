package com.djh.demo.Annotation;

import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 元注解的作用是负责注解其他注解，java中定义了四个标准的
 * meta-annotation类型
 * 这些类型和它们所支持的类在java.lang.annotation包中
 * @Target: 用来描述注解的使用范围(类,方法,属性,包...)
 * @Retention: 表示需要在什么级别保存该注释信息(描述注解的生命周期: Source < Class < Runtime)
 * @Document: 说明该注解将被包含在javadoc中
 * @Inherited: 说明子类可以继承父类中的该注解
 */
//@MyAnnotation(name = "lisi",age = 3,likes = {"d","e"})
@MyAnnotation()
public class AnnotationDemo {

}

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)  //一般都是运行时环境
@Documented
@Inherited
@interface MyAnnotation{

    String name() default "zhangsan";
    int age() default 5;
    String[] likes() default {"a","b","c"};
}