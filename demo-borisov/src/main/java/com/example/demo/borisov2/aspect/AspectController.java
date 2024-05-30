package com.example.demo.borisov2.aspect;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CovidController
//@RestController
@RequestMapping(value = "/aspect", produces = "application/json")
public class AspectController {
    @GetMapping
    public Patient aspect() throws InterruptedException {
//        List<Patient> patients = new ArrayList<>();
//        for (int i = 0; i < 100000000; i++) {
////            Thread.sleep(1);
//            patients.add(new Patient("Антон"));
//        }
        return new Patient("Антон");
    }
}
