package com.tec.anji.service;

import com.tec.anji.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class BookService {

    @RabbitListener(queues = {"atguigu.emps"})
    public void recv(Book book) {
        System.out.println(book);
    }

    @RabbitListener(queues = {"atguigu.news"})
    public void recv2(Message message) throws UnsupportedEncodingException {
        MessageProperties properties = message.getMessageProperties();
        System.out.println(properties);
        System.out.println(new String(message.getBody(), properties.getContentEncoding()));
    }
}
