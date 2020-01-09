import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.3.41"
    // Apply the application plugin to add support for building a CLI application.

    application

    // Shadow Jar
    id("com.github.johnrengelman.shadow") version "5.2.0"

    kotlin("kapt") version "1.3.61"
}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    // Ktor
    implementation("io.ktor:ktor-server-netty:1.2.6")
    implementation("io.ktor:ktor-gson:1.2.6")
    implementation("io.ktor:ktor-auth:1.2.6")

    // Database
    implementation("org.jetbrains.exposed:exposed:0.17.7")
    implementation("org.postgresql:postgresql:42.2.9")

    // Arrow
    implementation("io.arrow-kt:arrow-core:0.10.4")
    implementation("io.arrow-kt:arrow-syntax:0.10.4")
    implementation("io.arrow-kt:arrow-fx:0.10.4")
}

application {
    // Define the main class for the application
    mainClassName = "io.mattmoore.examples.kotlin.arrow.ktor.AppKt"
}
