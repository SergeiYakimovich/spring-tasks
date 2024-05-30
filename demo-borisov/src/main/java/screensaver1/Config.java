package screensaver1;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "screensaver1")
public class Config {
    @Bean
    @Scope("prototype")
    public Color color() {
        Random random = new Random();
        System.out.println("Color-1");
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true) {
            ColorFrame frame = context.getBean(ColorFrame.class);
            frame.showOnRandomPlace();
            Thread.sleep(1000);
        }
    }
}
