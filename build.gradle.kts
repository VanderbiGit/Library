plugins {
	java
	id("org.springframework.boot") version "3.4.0"
	id("io.spring.dependency-management") version "1.1.6"
	id("com.diffplug.spotless") version "7.0.2"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	compileOnly("org.projectlombok:lombok:1.18.30")
	annotationProcessor("org.projectlombok:lombok:1.18.30")


// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.postgresql:postgresql")


//	JDBC  H2,
//	implementation("org.springframework.data:spring-data-jdbc")
//	implementation("com.h2database:h2")


}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks {
	build {
		dependsOn(spotlessApply)
	}
}

spotless {
	java {
		removeUnusedImports()
		googleJavaFormat()
		targetExclude("build/**/*.java")
	}

}
