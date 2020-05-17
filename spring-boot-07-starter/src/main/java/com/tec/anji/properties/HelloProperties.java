package com.tec.anji.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("anji.hello")
public class HelloProperties {

    private String prefix;

    private String suffix;
}
