import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.0-rc-146"
}

group = "training"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    maven("https://dl.bintray.com/spekframework/spek-dev")
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile(kotlin("script-runtime"))
    testCompile(kotlin("test"))

    compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.+")

    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.3.1")
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:2.0.0-alpha.2") {
        exclude(group = "org.jetbrains.kotlin")
    }
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:2.0.0-alpha.2") {
        exclude(group = "org.junit.platform")
        exclude(group = "org.jetbrains.kotlin")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test> {
    useJUnitPlatform{includeEngines("spek2")}
}