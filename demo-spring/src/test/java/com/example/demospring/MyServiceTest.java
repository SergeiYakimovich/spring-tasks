package com.example.demospring;

import com.example.demospring.example.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"demo-starter.name=MyServiceTest"})
class MyServiceTest {
    @Autowired
    private MyService myService;
    @Test
    void getInfo() {
        System.out.println(myService.getInfo());
    }
}