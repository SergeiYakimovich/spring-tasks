package com.example.demo.borisov2.врачи;

import com.example.demo.borisov2.Госпиталь;
import org.springframework.beans.factory.annotation.Autowired;

public interface Целитель {
    void лечить();
    String getType();

    @Autowired
    default void setЦелитель(Госпиталь госпиталь) {
        госпиталь.register(getType(), this);
    }
}
