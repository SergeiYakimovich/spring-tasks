package com.example.demo.borisov2.методы;

import borisov.Лечение;
import org.springframework.stereotype.Component;

@Component
public class Водка implements Лечение {
    @Override
    public void применить() {
        System.out.println("Водка");
    }
}
