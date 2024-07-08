package com.example.demospring;

import com.example.demospring.config.MyDemoSpringProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@SpringBootApplication
@EnableConfigurationProperties(MyDemoSpringProperties.class)

public class DemoSpringApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(DemoSpringApplication.class, args);

//		System.out.println(context.getBean(MyDemoSpringProperties.class).getHost());

//		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(DemoSpringApplication.class);

//		 !!!   стартер

//		MyDemoStarterClass myDemoStarterClass = new MyDemoStarterClass();
//		System.out.println("\n!!! " + myDemoStarterClass.getText());
//		System.out.println("!!! " + myDemoStarterClass.getDescription());
//
//		MyDemoStarterClass bean = context.getBean(MyDemoStarterClass.class);
//		System.out.println("\n!!! " + bean.getText());
//		System.out.println("!!! " + bean.getDescription());


//		!!!   prototype to singleton by lookup

//		for (int i = 0; i < 2; i++) {
//			MyTask myTask = context.getBean(MyTask.class);
//			myTask.doTask();
//			myTask.doTask();
//		}




	}

}
