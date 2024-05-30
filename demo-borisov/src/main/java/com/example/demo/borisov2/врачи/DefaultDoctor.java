package com.example.demo.borisov2.врачи;

import org.springframework.stereotype.Component;

@Component
public class DefaultDoctor implements Целитель {
    @Override
    public void лечить() {
        System.out.println("Вызван DefaultDoctor");
        throw new RuntimeException("DefaultDoctor не может лечить");
    }

    @Override
    public String getType() {
        return "DefaultDoctor";
    }
}
