val mapstructVersion: String by project

//buildscript {
//	repositories {
//		mavenCentral()
//	}
//	dependencies {
//		classpath("org.springframework.boot:spring-boot-gradle-plugin:3.0.1")
//	}
//}

plugins {
	java
//	application
	id("org.springframework.boot") version "3.1.0"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

//application {
//	mainClass.set("com.example.base.BaseApplication")
//}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")

	implementation("org.liquibase:liquibase-core")
	implementation("org.postgresql:postgresql")

	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	implementation("org.mapstruct:mapstruct:$mapstructVersion")
	annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	testImplementation("org.testcontainers:junit-jupiter")
	testImplementation("org.testcontainers:postgresql")

}

tasks.withType<Test> {
	useJUnitPlatform()
}

//tasks.jar {
//	// https://stackoverflow.com/questions/21721119/creating-runnable-jar-with-gra
//	manifest {
//		attributes["Main-Class"] = "com.example.base.BaseApplication"
//	}
//	duplicatesStrategy = DuplicatesStrategy.EXCLUDE
//	val dependencies = configurations
//		.runtimeClasspath
//		.get()
//		.map(::zipTree)
//	from(dependencies)
//}

tasks.bootJar {
	duplicatesStrategy = DuplicatesStrategy.EXCLUDE
	mainClass.set("com.example.base.BaseApplication")
	launchScript()
}
