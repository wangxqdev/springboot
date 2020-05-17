package com.tec.anji.service;

import com.tec.anji.properties.HelloProperties;

public class HelloService {

    private final HelloProperties helloProperties;

    public HelloService(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHello(String name) {
        return String.join("-", helloProperties.getPrefix(), name, helloProperties.getSuffix());
    }
}
