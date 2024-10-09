package com.mywebexample;

import com.mywebexample.feign.FeignHttpClient;
import com.mywebexample.urlscanner.CurrencyModel;
import com.mywebexample.urlscanner.CurrencyService;
import com.mywebexample.webflux.WebFluxClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ThreadLocalRandom;

@EnableFeignClients
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

//        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        // feign
//		String info = context.getBean(FeignHttpClient.class).getInfo();
//		System.out.println("\n!!! " + info);
//		System.out.println("\n!!!!!!!!!!!!!!!!!! end FeignHttpClient\n");

        // webflux
//		context.getBean(WebFluxClient.class).getInfo();
//		System.out.println("\n!!!!!!!!!!!!!!!!!! end WebFluxClient\n");

//        ThreadLocalRandom.current().nextInt();

//        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
//        context.getBean(CurrencyService.class).getCurrencyRate("USD");

        record CurrencyModel(String currency, double rate) {}

        CurrencyModel currencyModel = new CurrencyModel("USD", 1.0);

    }
}