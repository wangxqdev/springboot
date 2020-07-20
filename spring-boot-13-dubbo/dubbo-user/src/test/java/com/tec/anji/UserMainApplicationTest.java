package com.tec.anji;

import com.tec.anji.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMainApplicationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testDubbo() {
        String ticket = userService.buyTicket();
        System.out.println("bought ticket = " + ticket);
    }
}
