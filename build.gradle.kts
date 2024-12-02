plugins {
    id("java")
    id("org.springframework.boot") version "3.4.0"
}
tasks.jar {
    manifest {
        attributes(
            mapOf(
                "Implementation-Title" to project.name,
                "Implementation-Version" to project.version,
                "Main-Class" to "gareev.learn.Main"
            )
        )
    }
}


group = "mark"
version = "1"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot
    implementation("org.springframework.boot:spring-boot:3.4.0")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter
    implementation("org.springframework.boot:spring-boot-starter:3.4.0")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-configuration-processor
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-logging
    implementation("org.springframework.boot:spring-boot-starter-logging:3.4.0")
    // https://mvnrepository.com/artifact/com.h2database/h2
    implementation("com.h2database:h2:2.3.232")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-jdbc
    implementation("org.springframework.boot:spring-boot-starter-jdbc:3.4.0")
    // https://mvnrepository.com/artifact/org.springframework.shell/spring-shell-starter
    implementation("org.springframework.shell:spring-shell-starter:3.3.3")




// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.4.0")
}

tasks.test {
    useJUnitPlatform()
}