package com.example.demo.borisov2.врачи;

import borisov.Лечение;
import com.example.demo.borisov2.config.Legacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Священник implements Целитель {
    @Autowired
    @Legacy
    private List<Лечение> лекарства;

    @Override
    public void лечить() {
        лекарства.forEach(Лечение::применить);
    }

    @Override
    public String getType() {
        return "Священник";
    }
}
