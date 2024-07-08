package com.example.demospring.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "mail")
public class MyDemoSpringProperties {
    private String host;
}
