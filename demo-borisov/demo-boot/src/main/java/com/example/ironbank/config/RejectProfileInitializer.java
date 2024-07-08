package com.example.ironbank.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

public class RejectProfileInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        if(applicationContext.getEnvironment().getActiveProfiles().length == 0) {
            throw new IllegalStateException("Так нельзя! No active profile!");
        } else {
            System.out.println("Active profile: " + Arrays.toString(applicationContext.getEnvironment().getActiveProfiles()));
        }

    }
}
