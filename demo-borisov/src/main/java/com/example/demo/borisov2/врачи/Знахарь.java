package com.example.demo.borisov2.врачи;

import borisov.Лечение;
import com.example.demo.borisov2.config.InjectList;
import com.example.demo.borisov2.методы.Водка;
import com.example.demo.borisov2.методы.Чеснок;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Знахарь implements Целитель {
    @InjectList({Водка.class, Чеснок.class})
    private List<Лечение> лекарства;

    @Override
    public void лечить() {
        лекарства.forEach(Лечение::применить);
    }

    @Override
    public String getType() {
        return "Знахарь";
    }
}
