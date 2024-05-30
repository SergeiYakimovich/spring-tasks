package com.example.demo.borisov;

@Profiling
public class T1000 extends TerminatorQuoter implements Quoter {
    @Override
    public void say() {
        System.out.print("T1000 - ");
        System.out.println("repeat = " + getRepeat());
    }
}
