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
    compile(kotlin("stdlib-jdk8", version = "1.3.0-rc-146"))
    compile(kotlin("reflect", version = "1.3.0-rc-146"))
    compile(kotlin("script-runtime"))
    testCompile(kotlin("test", version = "1.3.0-rc-146"))

    compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.+")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.3.1")
    testImplementation("io.mockk:mockk:1.8.9")
    testCompile("org.jetbrains.spek:spek-api:1.1.5")
    testCompile("org.jetbrains.spek:spek-subject-extension:1.1.5")
    testRuntime("org.jetbrains.spek:spek-junit-platform-engine:1.1.5")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test> {
    useJUnitPlatform{includeEngines("spek")}
}
