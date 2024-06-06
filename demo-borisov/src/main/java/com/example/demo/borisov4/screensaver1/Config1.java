package com.example.demo.borisov4.screensaver1;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "com/example/demo/borisov4/screensaver1")
public class Config1 {
    @Bean
    @Scope("prototype")
    public Color color() {
        Random random = new Random();
        System.out.println("Color-1");
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config1.class);
        while (true) {
            ColorFrame1 frame = context.getBean(ColorFrame1.class);
            frame.showOnRandomPlace();
            Thread.sleep(1000);
        }
    }
}
