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
 *  3. SpringBoot启动原理
 *   3.1 创建SpringApplication
 *    3.1.1 获取META-INF/spring.factories配置文件中所有的ApplicationContextInitializer
 *    3.1.2 获取META-INF/spring.factories配置文件中所有的ApplicationListener
 *   3.2 调用run()方法
 *    3.2.1 获取META-INF/spring.factories配置文件中所有的SpringApplicationRunListener
 *    3.2.2 调用SpringApplicationRunListener.starting()方法
 *    3.2.3 准备运行环境，调用SpringApplicationRunListener.environmentPrepared()方法
 *    3.2.4 打印Banner
 *    3.2.5 根据运行环境创建IOC容器
 *    3.2.6 调用prepareContext()配置IOC容器
 *      1) ApplicationContextInitializer.initialize()
 *      2) SpringApplicationRunListeners.contextPrepared()
 *      3) SpringApplicationRunListeners.contextLoaded()
 *    3.2.7 调用refreshContext()刷新IOC容器
 *    3.2.8 调用afterRefresh()
 *      1) ApplicationRunner.run()
 *      2) CommandLineRunner.run()
 *    3.2.9 调用SpringApplicationRunListeners.finished()方法
 */
@SpringBootApplication
public class HelloWorldMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldMainApplication.class, args);
    }
}
