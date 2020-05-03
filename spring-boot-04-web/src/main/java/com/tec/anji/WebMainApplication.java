package com.tec.anji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. 静态资源：
 *  1.1 pattern: /webjars/** => url: classpath:/META-INF/resources/webjars/
 *      eg: localhost:8080/webjars/jquery/3.5.0/jquery.js
 *  1.2 pattern: /** => url: classpath:/, classpath:/META-INF/resources/, classpath:/resources/, classpath:/static/, classpath:/public/
 *      eg: localhost:8080/about.html
 *  1.3 pattern: /** => url: classpath:/index.html, classpath:/META-INF/resources/index.html, classpath:/resources/index.html, classpath:/static/index.html, classpath:/public/index.html
 *      eg: localhost:8080/index.html
 *  1.4 pattern: **\/favicon.ico => classpath:/favicon.ico, classpath:/META-INF/resources/favicon.ico, classpath:/resources/favicon.ico, classpath:/static/favicon.ico, classpath:/public/favicon.ico
 *      eg: localhost:8080/favicon.ico
 * 2. 模板引擎
 *  2.1 Thymeleaf => ThymeleafProperties
 * 3. MVC自动配置
 *  3.1 https://docs.spring.io/spring-boot/docs/1.5.9.RELEASE/reference/html/boot-features-developing-web-applications.html#boot-features-spring-mvc
 *  3.1 WebMvcAutoConfiguration.class
 * 4. 自定义异常处理
 *  4.1 ErrorPageCustomizer => 注册错误处理页面(/error/**)
 *  4.2 BasicErrorController
 *   4.2.1 处理/error请求
 *   4.2.2 映射text/html请求路径 => errorHtml()
 *      1) 有模板引擎：/templates/error/4xx.html|5xx.html
 *      2) 无模板引擎：/error/4xx.html|5xx.html
 *      3) 框架自带错误页面
 *   4.2.3 映射json/application请求路径 => error()
 *  4.3 DefaultErrorViewResolver
 *  4.4 DefaultErrorAttributes
 */
@SpringBootApplication
public class WebMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebMainApplication.class, args);
    }
}
