plugins {
    id("java")
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.mydaoexample"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.h2database:h2")
    implementation("org.hibernate.orm:hibernate-core:6.5.2.Final")
    implementation("org.hibernate:hibernate-jmx:3.5.6-Final")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    testImplementation("junit:junit")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jeasy:easy-random-core:5.0.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}