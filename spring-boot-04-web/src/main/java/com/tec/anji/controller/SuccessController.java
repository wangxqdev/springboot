package com.tec.anji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

/**
 * 1. 配置详见：ThymeleafProperties
 */
@RequestMapping("/web")
@Controller
public class SuccessController {

    @RequestMapping("/success")
    public String success(Map<String, Object> data) {
        data.put("hello", "<h1>你好</h1>");
        data.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "success";
    }
}
