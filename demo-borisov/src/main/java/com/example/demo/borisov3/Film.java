package com.example.demo.borisov3;

import com.example.demo.borisov3.actors.Actor;
import com.example.demo.borisov3.genre.Action;
import com.example.demo.borisov3.genre.Comedy;
import com.example.demo.borisov3.genre.Melodrama;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Film {
    @Autowired
    @Melodrama @Comedy
    private List<Actor> actors;

    public void show() {
        actors.forEach(Actor::play);
    }

}
