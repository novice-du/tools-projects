package com.djh.demo.Config;

import com.djh.demo.Until.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.ws.rs.ext.InterceptorContext;

/**
 * 注册拦截器
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("注册拦截器");
        //需要拦截的路径，/**表示需要拦截所有请求
        String[] addPathPatterns={"/**"};
        //不需要拦截的路径
        String [] excludePathPaterns={
                "/test/sel"
        };
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns(addPathPatterns)
                .excludePathPatterns(excludePathPaterns);
    }

}
