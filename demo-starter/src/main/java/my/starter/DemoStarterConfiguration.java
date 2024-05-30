package my.starter;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@EnableConfigurationProperties(DemoStarterProperties.class)
public class DemoStarterConfiguration {
    @Bean
    public DemoStarterProperties demoStarterProperties() {
        return new DemoStarterProperties();
    }

    @Bean
    public MyDemoStarterClass myDemoStarterClass(DemoStarterProperties demoStarterProperties) {
        MyDemoStarterClass myDemoStarterClass = new MyDemoStarterClass();
        myDemoStarterClass.setText(demoStarterProperties.getName());
        return myDemoStarterClass;
    }
}
