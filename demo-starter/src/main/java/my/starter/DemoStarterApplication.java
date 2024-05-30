package my.starter;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoStarterApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DemoStarterApplication.class, args);

		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(DemoStarterApplication.class);
		MyDemoStarterClass myDemoStarterClass = context.getBean(MyDemoStarterClass.class);
		System.out.println("!!! " + myDemoStarterClass.getText());
		System.out.println("!!! " + myDemoStarterClass.getDescription());
	}

}
