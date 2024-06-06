package com.example.demo;

import borisov.spark.SparkService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// !!! Spring Потрошитель - 3-х фазный конструктор

//		System.out.println("Стартуем");
//		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(DemoApplication.class);
//		SpringApplication.run(DemoApplication.class);
//		System.out.println("\nКонтекст загружен\n");
//		context.getBean(Quoter.class).say();


		// !!! регистрация списка бинов через свои аннотации

//		context.getBean(Знахарь.class).лечить();
//		context.getBean(Священник.class).лечить();

//		context.getBean(Госпиталь.class).курсЛечения("Знахарь");
//		context.getBean(Госпиталь.class).курсЛечения("Священник");
//		context.getBean(Госпиталь.class).курсЛечения("unknown");

//		не работает с spring-boot-starter-aop
//		context.getBean(MyBeanRegistrator.class).registerBean("доктор", "com.example.demo.borisov2.врачи.Доктор");
//		context.getBean(Госпиталь.class).курсЛечения("Доктор");


		// !!! регистрация Actors в Film через свои аннотации

//		context.getBean(Film.class).show();


		// !!! свой EventListener и Event

//	context.publishEvent(new MyEvent("test"));


		// !!! регистрация бина через ApplicationContextInitalizer из стартера

//		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class);
//		context.getBean(SparkService.class).sayHello();


		System.out.println("\n!!!!!!!!!!!!!!!!\n");

	}

}
