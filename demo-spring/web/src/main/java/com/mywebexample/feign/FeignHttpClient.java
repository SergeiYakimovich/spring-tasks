package com.mywebexample.feign;

import com.mywebexample.webflux.WebFluxClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "feignHttpClient", url = WebFluxClient.URL)
public interface FeignHttpClient {
    @RequestMapping(method = RequestMethod.GET)
    String getInfo();
}
