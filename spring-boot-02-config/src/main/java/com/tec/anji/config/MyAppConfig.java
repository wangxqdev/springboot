package com.tec.anji.config;

import com.tec.anji.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

    /**
     * @Bean：相当于<bean><bean/>标签
     */
    @Bean
    public HelloService helloService() {
        return new HelloService();
    }
}
