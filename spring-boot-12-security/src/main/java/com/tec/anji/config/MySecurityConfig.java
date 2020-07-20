package com.tec.anji.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3")
                .and()
            // 1. 发送 /login 请求来到登录页
            // 2. 发送 /login?error 表示登录失败
            // 3. 默认用户名：username，密码：password
            .formLogin().loginPage("/userlogin")
                .and()
            // 1. 发送 /logout 请求注销
            // 2. 注销成功默认发送 /login?success 请求
            // 3. 注销成功发送 / 请求
            .logout().logoutSuccessUrl("/")
                .and()
            // 1. 默认记住我：remember-me
            .rememberMe();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("zhangsan").password("123456").roles("VIP1", "VIP3")
                .and()
                .withUser("lisi").password("123456").roles("VIP2", "VIP3")
                .and()
                .withUser("wangwu").password("123456").roles("VIP1", "VIP2");
    }
}
