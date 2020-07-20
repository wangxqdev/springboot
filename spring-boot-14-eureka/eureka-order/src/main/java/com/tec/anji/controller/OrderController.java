package com.tec.anji.controller;

import com.tec.anji.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/ticket")
    public String getTicket() {
        return orderService.getTicket();
    }
}
