package com.djh.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @EnableScheduling注解（定时任务注解）可以用在启动类上，也可以用在@Scheduled配置类上
 *
 * @ComponentScan()因为如果启动类上用了@ComponentScan注解后，它就不会再自动扫描所在包及其子包下所有的Bean,
 * 在启动类上加上注解 @ComponentScan注解，强制扫描同级目录下的包或子包，就可以了。
 */
@SpringBootApplication//声明该类是springboot的一个引导类
@EnableScheduling
@MapperScan("com.djh.demo.Dao")
//@ComponentScan(basePackages = "com.djh.demo.Config")
public class DemoApplication {
    public static void main(String[] args) {
        //SpringApplicatioon.run方法表示运行Springboot的引导类，run参数就是SpringBoot引导类的字节码对象
        SpringApplication.run(DemoApplication.class, args);
    }
}