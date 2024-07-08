package com.example.ironbank.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("condition2")
public class MyTask2 implements MyTask {
    @Override
    public String doTask() {
        System.out.println("MyTask 2 doTask");
        return "MyTask 2 doTask";
    }
}
