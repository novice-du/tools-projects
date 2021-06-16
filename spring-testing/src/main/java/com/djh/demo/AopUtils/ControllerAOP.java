package com.djh.demo.AopUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//证明是一个配置文件(使用@Component也可以,因为点入后会发现@Configuration还是使用了@Component)
@Configuration
//证明是一个切面
@Aspect
public class ControllerAOP {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    //环绕aop
    //execution表达式 此表达式表示扫描controller下所有类的所有方法都执行此aop
    @Around("execution(public String com.djh.demo.Controller..*.*(..))")
    public Object testAop(ProceedingJoinPoint joinPoint) throws Throwable {  // Proceedingjoinpoint 继承了 JoinPoint
        //进入方法前执行的代码
//        System.out.println("===beginAround===");
        logger.info("===beginAround===");
        //执行调用的方法
        Object proceed = joinPoint.proceed();
        //进入代码后执行的代码
//        System.out.println("===endAround===");
        logger.info("===endAround===");
        return proceed;
    }

}
