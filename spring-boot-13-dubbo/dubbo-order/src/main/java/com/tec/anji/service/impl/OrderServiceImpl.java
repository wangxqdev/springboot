package com.tec.anji.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.tec.anji.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public String getTicket() {
        return "《花木兰》";
    }
}
