import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.0-SNAPSHOT"
	id("io.spring.dependency-management") version "1.0.13.RELEASE"
	kotlin("jvm") version "1.7.10"
	kotlin("plugin.spring") version "1.7.10"
	kotlin("plugin.serialization") version "1.7.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	// https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core
	implementation("org.apache.logging.log4j:log4j-core:2.18.0")
	// https://mvnrepository.com/artifact/org.springframework/spring-tx
	implementation("org.springframework:spring-tx:5.3.22")
	// https://mvnrepository.com/artifact/com.google.code.gson/gson
	implementation("com.google.code.gson:gson:2.9.1")

	// https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-test
	implementation("org.jetbrains.kotlin:kotlin-test:1.7.10")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	// https://mvnrepository.com/artifact/org.junit.platform/junit-platform-suite-api
	testImplementation("org.junit.platform:junit-platform-suite-api:1.9.0")
	// https://mvnrepository.com/artifact/org.junit.platform/junit-platform-suite-engine
	testImplementation("org.junit.platform:junit-platform-suite-engine:1.9.0")
	// https://mvnrepository.com/artifact/org.junit.platform/junit-platform-suite-commons
	runtimeOnly("org.junit.platform:junit-platform-suite-commons:1.9.0")

	// https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core
	implementation("org.apache.logging.log4j:log4j-core:2.18.0")

	// https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine
	testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.0")
	// https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
	// https://mvnrepository.com/artifact/org.junit.vintage/junit-vintage-engine
	testImplementation("org.junit.vintage:junit-vintage-engine:5.9.0")
	// https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-params
	testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.0")
	// https://mvnrepository.com/artifact/org.junit.platform/junit-platform-runner
	testImplementation("org.junit.platform:junit-platform-runner:1.9.0")


	// https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-serialization-json-jvm
	runtimeOnly("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:1.3.3")


	testImplementation(platform("org.junit:junit-bom:5.9.0"))
	// https://mvnrepository.com/artifact/org.junit.platform/junit-platform-launcher
	testImplementation("org.junit.platform:junit-platform-launcher:1.9.0")

	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
	testRuntimeOnly("org.junit.vintage:junit-vintage-engine")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
