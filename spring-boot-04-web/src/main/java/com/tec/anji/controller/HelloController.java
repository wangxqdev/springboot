package com.tec.anji.controller;

import com.tec.anji.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @ResponseBody
    @GetMapping("/hello")
    public String hello(String username) {
        if ("aaa".equals(username)) {
            throw new UserNotExistException();
        }
        return "Hello world!";
    }
}
