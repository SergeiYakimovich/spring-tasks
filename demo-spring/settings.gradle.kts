pluginManagement {
	repositories {
		maven { url = uri("https://repo.spring.io/milestone") }
		maven { url = uri("https://repo.spring.io/snapshot") }
		gradlePluginPortal()
	}
}
rootProject.name = "demo-spring"
include("modulith")
include("dao")
include("web")
include("kafka")
include("kafka-producer")
include("kafka-consumer")
