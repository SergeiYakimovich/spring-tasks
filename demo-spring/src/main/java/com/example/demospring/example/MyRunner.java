package com.example.demospring.example;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyRunner implements CommandLineRunner {
    private final ValueSource valueSource;

    @Override
    public void run(String... args) {
        valueSource.generate();
    }
}
