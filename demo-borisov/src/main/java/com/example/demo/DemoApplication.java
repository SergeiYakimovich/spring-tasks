package com.example.demo;

import com.example.demo.borisov2.config.MyBeanRegistrator;
import com.example.demo.borisov2.Госпиталь;
import com.example.demo.borisov3.Film;
import com.example.demo.borisov3.actors.ChuckNorris;
import com.example.demo.borisov3.events.MyEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.annotation.Annotation;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		System.out.println("Стартуем");
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(DemoApplication.class);
//		SpringApplication.run(DemoApplication.class);
		System.out.println("\nКонтекст загружен\n");

//		context.getBean(Quoter.class).say();


//		context.getBean(Знахарь.class).лечить();
//		context.getBean(Священник.class).лечить();

//		context.getBean(Госпиталь.class).курсЛечения("Знахарь");
//		context.getBean(Госпиталь.class).курсЛечения("Священник");
//		context.getBean(Госпиталь.class).курсЛечения("unknown");


//		не работает с spring-boot-starter-aop
//		context.getBean(MyBeanRegistrator.class).registerBean("доктор", "com.example.demo.borisov2.врачи.Доктор");
//		context.getBean(Госпиталь.class).курсЛечения("Доктор");

		
//		context.getBean(Film.class).show();

//	context.publishEvent(new MyEvent("test"));
	}

}
