package com.tec.anji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. JDBC自动配置
 *  1.1 DataSourceConfiguration => 注入数据源
 *  1.2 DataSourceAutoConfiguration
 *      1.2.1 DataSourceInitializer
 *          1) runSchemaScripts => classpath: schema-all.sql、classpath: schema.sql、自定义
 *          2) runDataScripts => classpath: data-all.sql、classpath: data.sql、自定义
 *  1.3 JdbcTemplateAutoConfiguration
 *      1.3.1 JdbcTemplate
 *      1.3.2 NamedParameterJdbcTemplate
 */
@SpringBootApplication
public class DataMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataMainApplication.class, args);
    }
}