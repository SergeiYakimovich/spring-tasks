package com.example.demo.borisov1;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@Profiling
//@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {
    @InjectRandomInt(min = 1, max = 3)
    private int repeat = 10; // public

    public TerminatorQuoter() {
        System.out.print("\nPhase 1 - Конструктор - ");
        System.out.println("repeat = " + repeat);
    }

    @PostConstruct
    public void init1() {
        System.out.print("\nPhase 2 - PostConstruct - ");
        System.out.println("repeat = " + repeat);
    }

    @PostProxy
    @Override
    public void init2() {
        repeat = 4;
        System.out.print("Phase 3 - PostProxy - ");
        System.out.println("repeat = " + repeat);
        repeat = 5;
    }

    @Override
    public void say() {
        System.out.print("Phase 4 - say - ");
        System.out.println("repeat = " + repeat);
    }
}
