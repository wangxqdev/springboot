package com.tec.anji.mode;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 1. @ConfigurationProperties：用于批量将属性映射成内存对象
 *  1.1 不支持SpEL表达式
 *  1.2 只读取application配置文件
 * 2. @PropertiesSource：用于读取.properties后缀配置文件
 *  2.1 结合@ConfigurationProperties一起使用
 */
@Data
@ToString
@Component
@ConfigurationProperties("person")
//@PropertySource({"classpath:person.properties"})
public class Person {

    private String lastName;

    private int age;

    private boolean boss;

    private Date birthday;

    private Map<String, Object> demoMap;

    private List<Object> demoList;

    private Dog dog;
}
