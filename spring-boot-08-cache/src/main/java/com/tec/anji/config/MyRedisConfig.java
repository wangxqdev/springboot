package com.tec.anji.config;

import com.tec.anji.bean.Department;
import com.tec.anji.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<String, Employee> employeeRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Employee> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Employee.class));
        return template;
    }

    @Bean
    public RedisTemplate<String, Department> departmentRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Department> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Department.class));
        return template;
    }

    @Primary
    @Bean
    public RedisCacheManager employeeCacheManager(RedisTemplate<String, Employee> employeeRedisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(employeeRedisTemplate);
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }

    @Bean
    public RedisCacheManager departmentCacheManager(RedisTemplate<String, Department> departmentRedisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(departmentRedisTemplate);
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }
}
