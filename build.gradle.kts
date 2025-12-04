import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    id("org.springframework.boot") version "3.5.7"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("jvm") version "2.2.21"
    kotlin("plugin.spring") version "2.2.21"
    id("org.openapi.generator") version "7.17.0"
    id("org.jlleitschuh.gradle.ktlint") version "13.1.0"
}

group = "no.entur"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    val artifactoryUser =
        project.properties["entur_artifactory_user"]
            ?: System.getenv("ARTIFACTORY_USER")
            ?: System.getenv("ARTIFACTORY_AUTH_USER")
    val artifactoryPassword =
        project.properties["entur_artifactory_password"]
            ?: System.getenv("ARTIFACTORY_PASSWORD")
            ?: System.getenv("ARTIFACTORY_AUTH_TOKEN")
    println("Artifactory user: ${artifactoryUser ?: "NOT SET"}")

    mavenCentral()
    // Entur Artifactory internal release
    maven {
        url = uri("https://entur2.jfrog.io/entur2/entur-release-standard")
        credentials {
            username = "$artifactoryUser"
            password = "$artifactoryPassword"
        }
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("jakarta.validation:jakarta.validation-api:3.1.1")
    implementation("io.swagger.core.v3:swagger-annotations:2.2.41")
    implementation("io.swagger.core.v3:swagger-models:2.2.41")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.13")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.flywaydb:flyway-core")
    implementation("io.github.openfeign:feign-httpclient:13.6")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    // Override versions with vulnerabilities
    implementation("commons-fileupload:commons-fileupload") {
        version {
            strictly("1.6.0")
        }
    }
    implementation("org.apache.commons:commons-lang3") {
        version {
            strictly("3.19.0")
        }
    }
    // override end

    // Security
    implementation("org.entur.auth:oidc-auth-client-spring-boot-starter:4.6.0")
    runtimeOnly("io.micrometer:micrometer-registry-prometheus")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("io.kotest:kotest-property:6.0.7")
    testImplementation("io.kotest:kotest-assertions-core:6.0.7")
    testImplementation("io.mockk:mockk:1.14.6")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.13")
}

dependencyManagement {
    imports {
        mavenBom("com.google.cloud:spring-cloud-gcp-dependencies:7.4.1")
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2025.1.0")
    }
}

tasks.withType<KotlinCompile> {
    compilerOptions {
        freeCompilerArgs.add("-Xjsr305=strict")
        jvmTarget.set(JvmTarget.JVM_21)
    }
}

val generatedSources = file("$projectDir/src/main/kotlin")
val swaggerSpecLocation = "$projectDir/src/main/resources/swagger-spec"
val modelPackageTomp150 = "no.entur.shared.mobility.to.ref.tomp150.dto"
val apiPackageTomp150 = "no.entur.shared.mobility.to.ref.tomp150.controller"
val modelPathTomp150 = file("$projectDir/src/main/kotlin/no/entur/shared/mobility/to/ref/tomp150/dto")
val apiPathTomp150 = file("$projectDir/src/main/kotlin/no/entur/shared/mobility/to/ref/tomp150/controller")
val modelPackageTomp160 = "no.entur.shared.mobility.to.ref.tomp160.dto"
val apiPackageTomp160 = "no.entur.shared.mobility.to.ref.tomp160.controller"
val modelPathTomp160 = file("$projectDir/src/main/kotlin/no/entur/shared/mobility/to/ref/tomp160/dto")
val apiPathTomp160 = file("$projectDir/src/main/kotlin/no/entur/shared/mobility/to/ref/tomp160/controller")
ktlint {
    version = "1.5.0"
    debug = true
    verbose = true
    filter {
        exclude {
            it.file.path.contains(modelPathTomp150.path)
        }
        exclude {
            it.file.path.contains(apiPathTomp150.path)
        }
        exclude {
            it.file.path.contains(modelPathTomp160.path)
        }
        exclude {
            it.file.path.contains(apiPathTomp160.path)
        }
    }
}

val configOptionsTomp =
    mapOf(
        "apiSuffix" to "",
        "useSpringBoot3" to "true",
        "useTags" to "true",
        "beanQualifiers" to "true",
        "serviceInterface" to "true",
        "enumPropertyNaming" to "UPPERCASE",
        "sourceFolder" to "",
    )
tasks.register<org.openapitools.generator.gradle.plugin.tasks.GenerateTask>("buildTomp150") {
    generatorName.set("kotlin-spring")
    outputDir.set("$generatedSources")
    inputSpec.set("$swaggerSpecLocation/TOMP-API.1.5.yaml")
    version.set("v1")
    modelPackage.set(modelPackageTomp150)
    apiPackage.set(apiPackageTomp150)
    globalProperties.set(
        mapOf(
//            "apis" to "Booking,BookingOptional,General,OperatorInformation,Payment,Planning,Support,TripExecution",
            "models" to "",
            "modelDocs" to "false",
            "modelTests" to "false",
            "apiTests" to "false",
        ),
    )
    configOptions.set(configOptionsTomp)
}

tasks.register<org.openapitools.generator.gradle.plugin.tasks.GenerateTask>("buildTomp160") {
    generatorName.set("kotlin-spring")
    outputDir.set("$generatedSources")
    inputSpec.set("$swaggerSpecLocation/TOMP-API.1.6.yaml")
    version.set("v1")
    modelPackage.set(modelPackageTomp160)
    apiPackage.set(apiPackageTomp160)
    globalProperties.set(
        mapOf(
//            "apis" to "Booking,BookingOptional,General,OperatorInformation,Payment,Planning,Support,TripExecution,CustomerManagement",
            "models" to "",
            "modelDocs" to "false",
            "modelTests" to "false",
            "apiTests" to "false",
        ),
    )
    configOptions.set(configOptionsTomp)
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.named("compileKotlin") {
    dependsOn(":buildTomp150")
    dependsOn(":buildTomp160")
}
tasks.named("runKtlintFormatOverMainSourceSet") {
    dependsOn(":buildTomp150")
    dependsOn(":buildTomp160")
}

tasks.named("runKtlintCheckOverMainSourceSet") {
    dependsOn("runKtlintFormatOverMainSourceSet")
}
tasks.named("runKtlintCheckOverTestSourceSet") {
    dependsOn("runKtlintFormatOverTestSourceSet")
}

tasks.register("fetchSecrets") {
    group = "setup"

    doLast {
        // Define project ID
        val projectId = "ent-shmotoref-dev"

        // Function to run shell commands and return output
        fun runCommand(command: String): String {
            val ex =
                providers
                    .exec {
                        // Corrected commandLine configuration
                        commandLine =
                            if (System.getProperty("os.name").lowercase().contains("windows")) {
                                listOf("cmd", "/c", command)
                            } else {
                                listOf("sh", "-c", command)
                            }
                    }
            ex.result.get().assertNormalExitValue() // Ensure the command ran without errors
            return ex.standardOutput.asText
                .get()
                .trim()
        }

        // Fetch secrets using gcloud commands
        val clientId =
            runCommand("""gcloud secrets versions access latest --secret=MNG_AUTH0_INT_CLIENT_ID --project="$projectId"""")
        val clientSecret =
            runCommand("""gcloud secrets versions access latest --secret=MNG_AUTH0_INT_CLIENT_SECRET --project="$projectId"""")

        // Store fetched secrets in extra properties
        project.extensions.extraProperties.set("MNG_AUTH0_INT_CLIENT_ID", clientId)
        project.extensions.extraProperties.set("MNG_AUTH0_INT_CLIENT_SECRET", clientSecret)
    }
}

tasks.register<Exec>("dockerBuild") {
    dependsOn("assemble") // Sikrer at applikasjonen er bygget før Docker-image bygges
    group = "docker"
    description = "Builds the Docker image."

    // Docker build-kommandoen
    commandLine("docker", "build", "-t", "shared-mobility-to-ref-0.0.1:latest", ".")
    doLast {
        println("Docker image has been built successfully.")
    }
}

tasks.register<Exec>("run") {
    dependsOn("dockerBuild", "fetchSecrets")

    group = "application"
    description = "Runs the Docker container."

    doFirst {
        println("Running the application with fetched secrets and Docker...")

        // Retrieve the dynamically fetched secrets
        val clientId = project.extra["MNG_AUTH0_INT_CLIENT_ID"] as String
        val clientSecret = project.extra["MNG_AUTH0_INT_CLIENT_SECRET"] as String

        // Define the container name
        val containerName = "shared-mobility-to-ref"

        // Stop and remove any existing container with the same name
        val existingContainerId =
            providers
                .exec {
                    commandLine("docker", "ps", "-q", "--filter", "name=^$containerName$")
                }.standardOutput.asText
        if (existingContainerId.get().trim().isNotEmpty()) {
            println("Stopping existing container $containerName with id ${existingContainerId.get()}...")
            providers
                .exec {
                    commandLine("docker", "stop", existingContainerId.get())
                }.result
                .get()
        }

        // Set the command to run the new Docker container
        commandLine(
            "docker",
            "run",
            "--name",
            "shared-mobility-to-ref",
            "--rm",
            "-p",
            "8080:8080",
            "-e",
            "APP_ENV=local",
            "-e",
            "MNG_AUTH0_INT_CLIENT_ID=$clientId",
            "-e",
            "MNG_AUTH0_INT_CLIENT_SECRET=$clientSecret",
            "shared-mobility-to-ref-0.0.1",
        )
    }
    // Set working directory to project directory
    workingDir = project.projectDir
}
