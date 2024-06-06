package borisov.spark;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class SparkApplicationContextInitalizer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("\nSparkApplicationContextInitalizer - initialize sparkService\n");
        applicationContext.getBeanFactory().registerSingleton("sparkService", new SparkService());
    }
}
