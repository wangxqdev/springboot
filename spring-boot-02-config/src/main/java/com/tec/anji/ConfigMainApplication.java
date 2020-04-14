package com.tec.anji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @ImportResource：描述自定义bean配置文件路径
 */
//@ImportResource({"classpath:bean.xml"})
@SpringBootApplication
public class ConfigMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigMainApplication.class, args);
    }
}
