package com.example.demo.borisov2;

import com.example.demo.borisov2.врачи.Целитель;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class Госпиталь {
    private Map<String, Целитель> целительMap = new HashMap<>();

    public void register(String type, Целитель целитель) {
        целительMap.put(type, целитель);
    }

//    Госпиталь(List<Целитель> целители) {
//        целительMap = целители.stream().collect(Collectors.toMap(Целитель::getType, Function.identity()));
//    }

    public void курсЛечения(String type) {
        System.out.println("Курс лечения " + type);
        целительMap.getOrDefault(type, целительMap.get("DefaultDoctor")).лечить();
    }
}
