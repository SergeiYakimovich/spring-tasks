package my.starter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
		"demo-starter.name=New Demo Starter!!!"
})
class DemoStarterApplicationTests {
	@Autowired
	private DemoStarterProperties demoStarterProperties;

	@Test
	void contextLoads() {
		System.out.println(demoStarterProperties.getName());
	}



}
