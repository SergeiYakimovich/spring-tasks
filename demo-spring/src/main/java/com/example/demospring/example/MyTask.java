package com.example.demospring.example;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
//@AllArgsConstructor(onConstructor = @__(@Autowired))
//@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyTask {
    private String taskName;

    public MyTask() {
        System.out.println("MyTask constructor");
        this.taskName = "MyTask-" + LocalDateTime.now();
    }

    @Lookup
    public MyService myService() {
        return null;
    }

    public void doTask() {
        System.out.println("\ndoTask " + taskName);
        System.out.println(myService().getInfo());
    }
}
