package com.tec.anji.service.impl;

import com.tec.anji.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public String getTicket() {
        return "《花木兰》";
    }
}
