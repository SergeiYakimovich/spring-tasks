package com.example.ironbank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyService {
    private final MyTask myTask;

    public String doTask() {
        return myTask.doTask();
    }
}
