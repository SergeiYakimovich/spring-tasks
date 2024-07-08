package com.mydaoexample.bpp;

import com.mydaoexample.model.MyEntity;
import com.mydaoexample.repo.MyEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyTaskImpl implements MyTask {
    private final MyEntityRepository myEntityRepository;

    @ProfilingSQL
    public void doTask_1() {
        myEntityRepository.save(MyEntity.builder().name("test_1").build());
        var result = myEntityRepository.findAll();
        System.out.println(result);
    }

    @ProfilingSQL
    public void doTask_2() {
        myEntityRepository.save(MyEntity.builder().name("test_2").build());
        var result = myEntityRepository.findAll();
        System.out.println(result);
    }

}
