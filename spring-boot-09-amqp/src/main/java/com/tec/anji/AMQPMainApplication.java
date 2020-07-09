package com.tec.anji;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class AMQPMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(AMQPMainApplication.class, args);
    }
}
