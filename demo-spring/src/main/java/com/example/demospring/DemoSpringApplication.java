package com.example.demospring;

import my.starter.MyDemoStarterClass;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableFeignClients
@SpringBootApplication
public class DemoSpringApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DemoSpringApplication.class, args);

		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(DemoSpringApplication.class);

//		String info = context.getBean(FeignHttpClient.class).getInfo();
//		System.out.println("!!! " + info);
//		System.out.println("\n!!!!!!!!!!!!!!!!!! end FeignHttpClient\n");
//
//		context.getBean(WebFluxClient.class).getInfo();
//		System.out.println("\n!!!!!!!!!!!!!!!!!! end WebFluxClient\n");

		// стартер
		MyDemoStarterClass myDemoStarterClass = new MyDemoStarterClass();
		System.out.println("!!! " + myDemoStarterClass.getText());
		System.out.println("!!! " + myDemoStarterClass.getDescription());

		MyDemoStarterClass bean = context.getBean(MyDemoStarterClass.class);
		System.out.println("!!! " + bean.getText());
		System.out.println("!!! " + bean.getDescription());


	}

}
