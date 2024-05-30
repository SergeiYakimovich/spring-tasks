package com.example.demo.borisov3.genre;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Comedy
@Melodrama
@Action
public @interface AnyGenre {
}
