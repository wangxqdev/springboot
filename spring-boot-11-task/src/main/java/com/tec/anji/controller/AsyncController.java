package com.tec.anji.controller;

import com.tec.anji.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping
    public String async() {
        asyncService.hello();
        return "success";
    }
}
