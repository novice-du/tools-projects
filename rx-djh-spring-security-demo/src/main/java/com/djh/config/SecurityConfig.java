package com.djh.config;

import com.djh.commons.JwtFilter;
import com.djh.commons.JwtLoginFilter;
import com.djh.entity.PermissionEntity;
import com.djh.mapper.PermissionMapper;
import com.djh.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: dujunhua
 * @create: 2021/10/25 17:11
 * @description: SpringSecurity配置类
 */
@Component
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private MemberDetailsService memberDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new MyPasswordEncoderConfig();
    }

    /**
     * 授权
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //读取DB
        http.authorizeRequests().antMatchers("/").permitAll();
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry
                registry = http.authorizeRequests();
        //查询所有的权限
        List<PermissionEntity> allPermission = permissionMapper.findAllPermission();
        allPermission.forEach(item -> {
            //添加规则
            registry.antMatchers(item.getUrl()).hasAnyAuthority(item.getPermTag());
        });
        http.formLogin().loginProcessingUrl("/index")
                .and()
                .addFilterBefore(new JwtLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable();
    }

    /**
     * 认证
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //读取DB
        auth.userDetailsService(memberDetailsService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return MD5Util.encode((String) charSequence);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                // md5 传递密码 加密 === DB中密码则密码输入正确
                String rawPass = MD5Util.encode((String) rawPassword);
                boolean result = rawPass.equals(encodedPassword);
                return result;
            }

        });

    }

}
