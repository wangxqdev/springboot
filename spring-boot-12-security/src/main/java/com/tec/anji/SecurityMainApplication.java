package com.tec.anji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class SecurityMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityMainApplication.class, args);
    }
}
