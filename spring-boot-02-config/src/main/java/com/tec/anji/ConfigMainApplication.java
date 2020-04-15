package com.tec.anji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 1. @ImportResource：描述自定义bean配置文件路径
 * 2. 自动配置
 *  2.1 自定义XXXXAutoConfiguration
 *  2.2 类注解
 *      2.2.1 @Configuration
 *      2.2.2 @EnableConfigurationProperties(XXXXProperties-@ConfigurationProperties)
 *      2.2.3 构造注入(无需@Autowired注解)
 *  2.3 [配置参考](https://docs.spring.io/spring-boot/docs/2.1.13.RELEASE/reference/html/common-application-properties.html)
 */
//@ImportResource({"classpath:bean.xml"})
@SpringBootApplication
public class ConfigMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigMainApplication.class, args);
    }
}
