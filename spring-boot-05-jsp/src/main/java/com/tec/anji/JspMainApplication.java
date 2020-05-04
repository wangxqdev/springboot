package com.tec.anji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 *
 * 1. 启动流程
 *  1.1 服务器启动会根据jar包内META-INF/services/javax.servlet.ServletContainerInitializer文件所指向的类路径创建ServletContainerInitializer实例
 *  1.2 @HandlesTypes(WebApplicationInitializer.class) => 加载感兴趣的类
 *  1.3 调用ServletContainerInitializer.startUp()方法
 *  1.4 调用WebApplicationInitializer.startUp()方法
 *  1.5 调用SpringBootServletInitializer.createRootApplicationContext()方法
 *      1) 创建IOC容器
 *      2) 启动SpringBoot应用
 */
@SpringBootApplication
public class JspMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(JspMainApplication.class, args);
    }
}
