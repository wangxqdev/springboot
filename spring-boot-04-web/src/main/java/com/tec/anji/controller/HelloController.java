package com.tec.anji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/success")
    public String success(Map<String, Object> data) {
        data.put("hello", "<h1>你好</h1>");
        data.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "success";
    }
}
