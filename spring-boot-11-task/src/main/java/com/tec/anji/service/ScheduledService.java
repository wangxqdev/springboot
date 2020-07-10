package com.tec.anji.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    @Scheduled(cron = "0/15 * * * * ?")
    public void hello() {
        System.out.println("hello ...");
    }
}
