package com.tec.anji.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tec.anji.service.OrderService;
import com.tec.anji.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Reference
    private OrderService orderService;

    @Override
    public String buyTicket() {
        return orderService.getTicket();
    }
}
