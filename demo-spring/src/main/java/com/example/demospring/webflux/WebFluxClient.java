package com.example.demospring.webflux;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.stream.Collectors;

@Component
@Slf4j
public class WebFluxClient {
    public static final String URL = "https://example.com/";
    public String getInfo() {
        Flux<String>  fluxInfo = WebClient.create()
                .get()
                .uri(URL)
                .retrieve()
                .bodyToFlux(String.class);

        fluxInfo.subscribe(log::info);
        return fluxInfo.toStream().collect(Collectors.joining("\n"));
    }

}
