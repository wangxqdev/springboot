package com.tec.anji.mode;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 1. @Value：用于映射个别属性
 *  1.1 不能映射复杂对象
 *  1.2 不支持JSR303数据验证
 *  1.3 不支持松散语法
 */
@Data
@ToString
@Component
public class Cat {

    @Value("${cat.name}")
    private String name;

    @Value("#{ 11 * 2 }")
    private int age;

    @Value("true")
    private boolean sex;
}
