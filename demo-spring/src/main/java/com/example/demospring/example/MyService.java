package com.example.demospring.example;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@ToString
@Component
@Scope("prototype")
public class MyService {
    @Value("${name}")
    private String name;

    private int number;

    public MyService() {
        Random random = new Random();
        number = random.nextInt(100);
    }

    public String getInfo() {
        return this.toString();
    }
}
