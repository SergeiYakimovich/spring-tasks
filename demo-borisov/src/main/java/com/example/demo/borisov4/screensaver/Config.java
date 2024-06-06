package com.example.demo.borisov4.screensaver;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "com/example/demo/borisov4/screensaver")
public class Config {
    @Bean
    @Scope("periodical")
    public Color color() {
        Random random = new Random();
        System.out.println("Color");
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

// TODO: remove this
//    @Bean
    public ColorFrame colorFrame() {
        return new ColorFrame() {
            @Override
            public Color getColor() {
                return color();
            }
        };
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true) {
            ColorFrame frame = context.getBean(ColorFrame.class);
            frame.showOnRandomPlace();
            Thread.sleep(1000);
        }
    }
}
