package com.example.demo.borisov2.aspect;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RestController
@Retention(RetentionPolicy.RUNTIME)
public @interface CovidController {
}
