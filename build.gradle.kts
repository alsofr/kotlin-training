import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.0-rc-146"
}

group = "training"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile(kotlin("script-runtime"))

    compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.+")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}