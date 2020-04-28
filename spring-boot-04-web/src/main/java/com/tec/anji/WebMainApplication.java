package com.tec.anji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 静态资源：
 *  1. pattern: /webjars/** => url: classpath:/META-INF/resources/webjars/
 *     eg: localhost:8080/webjars/jquery/3.5.0/jquery.js
 *  2. pattern: /** => url: classpath:/, classpath:/META-INF/resources/, classpath:/resources/, classpath:/static/, classpath:/public/
 *     eg: localhost:8080/about.html
 *  3. pattern: /** => url: classpath:/index.html, classpath:/META-INF/resources/index.html, classpath:/resources/index.html, classpath:/static/index.html, classpath:/public/index.html
 *     eg: localhost:8080/index.html
 *  4. pattern: **\/favicon.ico => classpath:/favicon.ico, classpath:/META-INF/resources/favicon.ico, classpath:/resources/favicon.ico, classpath:/static/favicon.ico, classpath:/public/favicon.ico
 *     eg: localhost:8080/favicon.ico
 */
@SpringBootApplication
public class WebMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebMainApplication.class, args);
    }
}
