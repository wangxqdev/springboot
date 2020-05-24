package com.tec.anji;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 1. CacheAutoConfiguration
 *  1) SimpleCacheConfiguration => ConcurrentMapCacheManager
 *  2) 首先从ConcurrentMapCacheManager获取名称为{{name}}的Cache，如果不存在则默认创建ConcurrentMapCache放入ConcurrentMapCacheManager
 *  3) 调用ConcurrentMapCache.lookup()方法从ConcurrentMap获取值，如果返回值为空则调用目标方法获取结果，并调用put()方法将结果放入ConcurrentMap中
 */
@MapperScan("com.tec.anji.mapper")
@SpringBootApplication
@EnableCaching
public class CacheMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheMainApplication.class, args);
    }
}
