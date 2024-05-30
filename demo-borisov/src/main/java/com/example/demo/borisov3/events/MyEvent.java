package com.example.demo.borisov3.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class MyEvent extends ApplicationEvent {
    String message;
    public MyEvent(Object source) {
        super(source);
        message = source.toString();
    }
}
