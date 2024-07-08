package com.example.demospring.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Component
public class ValueSource {
    private final AtomicLong nextValue = new AtomicLong(1);

    public void generate() {
        var executor = Executors.newScheduledThreadPool(1);
        log.info("generation started");
        executor.scheduleAtFixedRate(() -> System.out.println(makeValue()), 0, 1, TimeUnit.SECONDS);
    }

    private String makeValue() {
        var id = nextValue.getAndIncrement();
        return "stVal:" + id;
    }
}
