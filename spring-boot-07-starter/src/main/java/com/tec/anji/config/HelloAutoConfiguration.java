package com.tec.anji.config;

import com.tec.anji.properties.HelloProperties;
import com.tec.anji.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(HelloProperties.class)
public class HelloAutoConfiguration {

    private final HelloProperties helloProperties;

    public HelloAutoConfiguration(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    @Bean
    public HelloService helloService() {
        return new HelloService(helloProperties);
    }
}
