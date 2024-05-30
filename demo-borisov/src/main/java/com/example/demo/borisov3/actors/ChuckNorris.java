package com.example.demo.borisov3.actors;

import com.example.demo.borisov3.actors.Actor;
import com.example.demo.borisov3.genre.AnyGenre;
import org.springframework.stereotype.Component;

@Component
@AnyGenre
public class ChuckNorris implements Actor {
    @Override
    public void play() {
        System.out.println("Chuck Norris");
    }
}
