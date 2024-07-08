plugins {
	java
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	mavenLocal()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

extra["springCloudVersion"] = "2023.0.0"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")

	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	testImplementation("junit:junit")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	// стартер
	implementation(files("libs/demo-starter-0.0.1-SNAPSHOT-plain.jar"))
}



tasks.withType<Test> {
	useJUnitPlatform()
}
