package com.example.demo.borisov4;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class SparkApplicationContextInitalizer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        String appName = applicationContext.getEnvironment().getProperty("spark.app-name");
        System.out.println("appName = " + appName);

        applicationContext.getBeanFactory().registerSingleton("sparkService", new SparkService());
    }
}
