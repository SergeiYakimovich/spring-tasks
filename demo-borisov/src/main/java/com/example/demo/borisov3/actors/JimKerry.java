package com.example.demo.borisov3.actors;

import com.example.demo.borisov3.actors.Actor;
import com.example.demo.borisov3.genre.Comedy;
import org.springframework.stereotype.Component;

@Component
@Comedy
public class JimKerry implements Actor {
    @Override
    public void play() {
        System.out.println("Jim Kerry");
    }
}
