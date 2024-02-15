package no.entur.shared.mobility.to.ref.config

import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan

@ComponentScan(no.entur.shared.mobility.to.ref.config.ApplicationConfig.Companion.PACKAGE_NAME)
@OpenAPIDefinition(info = Info(title = "MaaSProvider API", version = "v1"), security = [SecurityRequirement(name = "bearer-key")])
@ConfigurationPropertiesScan
class ApplicationConfig {
    @Bean
    fun kotlinModule() = KotlinModule.Builder().build()

    companion object {
        const val PACKAGE_NAME = "no.entur.shared.mobility.to.ref"
    }
}
