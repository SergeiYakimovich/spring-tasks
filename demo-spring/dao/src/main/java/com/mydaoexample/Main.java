package com.mydaoexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;
import java.sql.SQLException;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(MyDaoProperties.class)
@PropertySource("classpath:application.properties")
public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
//        System.out.println(context.getBean(MyDaoProperties.class).getName());


//        статистика SQL запросов через свою аннотацию  @ProfilingSQL
//        context.getBean(MyTask.class).doTask_1();
//        context.getBean(MyTask.class).doTask_2();

    }

}