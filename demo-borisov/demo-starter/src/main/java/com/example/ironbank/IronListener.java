package com.example.ironbank;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@RequiredArgsConstructor
public class IronListener implements ApplicationListener<ContextRefreshedEvent> {
    private final RavenProperties properties;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("!!!   IronBank is ready ...");
        properties.getDestinations()
                .forEach(x -> System.out.println("Send to " + x));
    }
}
