import org.jetbrains.kotlin.gradle.tasks.*

val kotlinVersion: String by project
val spekVersion: String by project
val exposedVersion: String by project

plugins {
    kotlin("jvm") version "1.5.10"
    application
}

group = "ro.vech"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")

    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlinVersion")
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spekVersion")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spekVersion")

    testRuntimeOnly("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")

    implementation("com.discord4j:discord4j-core:3.1.5")
    implementation("org.slf4j:slf4j-simple:1.7.30")
    compileOnly("com.h2database:h2:1.4.200")

    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"
}