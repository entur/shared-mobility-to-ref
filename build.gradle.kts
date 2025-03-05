import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    id("org.springframework.boot") version "3.4.3"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("jvm") version "2.1.10"
    kotlin("plugin.spring") version "2.1.10"
    id("org.openapi.generator") version "7.12.0"
    id("org.jlleitschuh.gradle.ktlint") version "12.2.0"
}

group = "no.entur"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

ktlint {
    version = "1.5.0"
    debug = true
    verbose = true
    filter {
        exclude {
            it.file.path.contains(generatedSources.path)
        }
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("jakarta.validation:jakarta.validation-api:3.1.1")
    implementation("io.swagger.core.v3:swagger-annotations:2.2.28")
    implementation("io.swagger.core.v3:swagger-models:2.2.28")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.5")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.flywaydb:flyway-core")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("io.micrometer:micrometer-registry-prometheus")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("io.kotest:kotest-property:5.9.1")
    testImplementation("io.kotest:kotest-assertions-core:5.9.1")
}

tasks.withType<KotlinCompile> {
    compilerOptions {
        freeCompilerArgs.add("-Xjsr305=strict")
        jvmTarget.set(JvmTarget.JVM_21)
    }
}

val generatedSources = file("$projectDir/build/generated-sources")
// val generatedSources = file("$projectDir/src/main/kotlin")
val swaggerSpecLocation = "$projectDir/src/main/resources/swagger-spec"
kotlin.sourceSets["main"].kotlin.srcDir("$generatedSources/src/main/kotlin")

idea {
    module {
        generatedSourceDirs.add(generatedSources)
    }
}

tasks.register<org.openapitools.generator.gradle.plugin.tasks.GenerateTask>("buildTomp150") {
    generatorName.set("kotlin-spring")
    outputDir.set("$generatedSources")
    inputSpec.set("$swaggerSpecLocation/TOMP-API.1.5.yaml")
    version.set("v1")
    modelPackage.set("no.entur.shared.mobility.to.ref.tomp150.dto")
    apiPackage.set("no.entur.shared.mobility.to.ref.tomp150.controller")
    globalProperties.set(
        mapOf(
            "apis" to "Booking,BookingOptional,General,OperatorInformation,Payment,Planning,Support,TripExecution",
            "models" to "",
            "modelDocs" to "false",
            "modelTests" to "false",
            "apiTests" to "false",
        ),
    )

    configOptions.set(
        mapOf(
            "useSpringBoot3" to "true",
            "useTags" to "true",
            "beanQualifiers" to "true",
            "serviceInterface" to "true",
            "enumPropertyNaming" to "UPPERCASE",
        ),
    )
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.named("compileKotlin") {
    dependsOn(":buildTomp150")
}
tasks.named("runKtlintFormatOverMainSourceSet") {
    dependsOn(":buildTomp150")
}

tasks.named("runKtlintCheckOverMainSourceSet") {
    dependsOn("runKtlintFormatOverMainSourceSet")
}
tasks.named("runKtlintCheckOverTestSourceSet") {
    dependsOn("runKtlintFormatOverTestSourceSet")
}
