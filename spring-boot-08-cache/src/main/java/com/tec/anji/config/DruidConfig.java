package com.tec.anji.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties("spring.datasource")
    @Bean
    public DruidDataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        Map<String, String> initParameters = new HashMap<>(10);
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "123456");
        registrationBean.setInitParameters(initParameters);

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean statViewFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new WebStatFilter());
        registrationBean.setUrlPatterns(Collections.singletonList("/*"));

        Map<String, String> initParameters = new HashMap<>(10);
        initParameters.put("exclusions", "*.css,*.js,/druid/*");
        registrationBean.setInitParameters(initParameters);

        return registrationBean;
    }
}
