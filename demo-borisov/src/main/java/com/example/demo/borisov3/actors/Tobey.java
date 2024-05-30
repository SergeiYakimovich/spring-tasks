package com.example.demo.borisov3.actors;

import com.example.demo.borisov3.actors.Actor;
import com.example.demo.borisov3.genre.Action;
import org.springframework.stereotype.Component;

@Component
@Action
public class Tobey implements Actor {
    @Override
    public void play() {
        System.out.println("Tobey");
    }
}
