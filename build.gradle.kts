import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    application
    id("maven-publish")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/christian-bernstein/smarthome-foundation/")
            // credentials {
            //     username = project.findProperty("gpr.user") ?: System.getenv("USERNAME")
            //     password = project.findProperty("gpr.key") ?: System.getenv("TOKEN")
            // }
        }
    }
    // publications {
    //     gpr(MavenPublication) {
    //         from(components.java)
    //     }
    // }
}
