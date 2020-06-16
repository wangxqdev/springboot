package com.tec.anji;

import com.tec.anji.bean.Employee;
import com.tec.anji.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public final class CacheMainApplicationTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisTemplate<String, Employee> employeeRedisTemplate;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testString() {
        stringRedisTemplate.opsForValue().set("hello", "world");
    }

    @Test
    public void testObject() {
        Employee employee = employeeMapper.getEmpById(1);
        redisTemplate.opsForValue().set("emp01", employee);
    }

    @Test
    public void testEmployee() {
        Employee employee = employeeMapper.getEmpById(1);
        employeeRedisTemplate.opsForValue().set("emp01", employee);
    }
}
