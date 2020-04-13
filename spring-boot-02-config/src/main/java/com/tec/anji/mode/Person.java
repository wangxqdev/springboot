package com.tec.anji.mode;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@ToString
@Configuration
@ConfigurationProperties("person")
public class Person {

    private String lastName;

    private int age;

    private boolean boss;

    private Date birthday;

    private Map<String, Object> demoMap;

    private List<Object> demoList;

    private Dog dog;
}
