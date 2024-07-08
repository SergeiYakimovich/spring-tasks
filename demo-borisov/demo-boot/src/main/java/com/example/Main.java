package com.example;

import com.example.ironbank.service.MyService;
import com.example.ironbank.RavenProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableConfigurationProperties(RavenProperties.class)
@PropertySource("classpath:application.properties")
public class Main {

    public static void main(String[] args) {
//        SpringApplication application = new SpringApplication(Main.class);
//        application.addInitializers(new RejectProfileInitializer());
//        application.run(args);

        SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);


//        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        context.getBean(MyService.class).doTask();

        context.close();

    }
}