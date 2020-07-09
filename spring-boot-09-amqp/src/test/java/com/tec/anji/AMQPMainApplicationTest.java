package com.tec.anji;

import com.tec.anji.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AMQPMainApplicationTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 自定义交换器、队列、绑定
     */
    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void testSendDirect() {
        rabbitTemplate.convertAndSend("exchange.direct", "atguigu", new Book("三国演义", "罗贯中"));
    }

    @Test
    public void testSendFanout() {
        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("红楼梦", "曹雪芹"));
    }

    @Test
    public void testRecv() {
        Object obj = rabbitTemplate.receiveAndConvert("atguigu");
        System.out.println(obj);
    }
}
