package com.tec.anji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping("/emps")
    public String list() {
        return "emp/list";
    }
}
