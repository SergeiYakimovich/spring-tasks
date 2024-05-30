package com.example.demospring.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.example.demospring.webflux.WebFluxClient.URL;

@FeignClient(value = "feignHttpClient", url = URL)
public interface FeignHttpClient {
    @RequestMapping(method = RequestMethod.GET)
    String getInfo();
}
