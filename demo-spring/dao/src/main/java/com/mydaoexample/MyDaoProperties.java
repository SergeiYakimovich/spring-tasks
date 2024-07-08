package com.mydaoexample;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "mydao")
public class MyDaoProperties {
    private String name;
}
