package com.tec.anji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 * 1. SpringBootConfiguration
 *  1.1 Configuration === Component
 * 2. EnableAutoConfiguration
 *  2.1 AutoConfigurationPackage
 *   2.1.1 @Import(AutoConfigurationPackages.Registrar.class)
 *    1）扫描注解@SpringBootApplication类所在包(com.tec.anji)下的所有配置文件
 *  2.2 @Import(EnableAutoConfigurationImportSelector.class)
 *   2.2.1 AutoConfigurationImportSelector.selectImports(...)
 *    1) SpringFactoriesLoader.loadFactoryNames(...)
 *    2) 从spring-boot-autoconfigure.META-INF/spring.factories获取EnableAutoConfiguration下的所有自动配置类
 */
@SpringBootApplication
public class HelloWorldMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldMainApplication.class, args);
    }
}
