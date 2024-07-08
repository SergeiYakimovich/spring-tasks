package com.example.ironbank;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties(RavenProperties.class)
@PropertySource("classpath:application.properties")
public class IronListenerConfiguration {
    @Bean
    @ConditionalOnProduction
    @ConditionalOnProperty("raven.destinations")
    public IronListener ironListener(RavenProperties properties) {
        return new IronListener(properties);
    }

}
