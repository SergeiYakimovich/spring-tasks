package com.example.ironbank.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("condition1")
public class MyTask1 implements MyTask {
    @Override
    public String doTask() {
        System.out.println("MyTask 1 doTask");
        return "MyTask 1 doTask";
    }
}
