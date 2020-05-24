package com.tec.anji;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.tec.anji.mapper")
@SpringBootApplication
@EnableCaching
public class CacheMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheMainApplication.class, args);
    }
}
