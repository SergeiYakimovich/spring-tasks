package com.example.demo.borisov3.actors;

import com.example.demo.borisov3.actors.Actor;
import com.example.demo.borisov3.genre.Melodrama;
import org.springframework.stereotype.Component;

@Component
@Melodrama
public class JuliaRoberts implements Actor {
    @Override
    public void play() {
        System.out.println("Julia Roberts");
    }
}
