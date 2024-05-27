package no.entur.shared.mobility.to.ref.config

import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan

@ComponentScan(ApplicationConfig.PACKAGE_NAME)
@OpenAPIDefinition(info = Info(title = "Entur shared mobility transport operator reference API", version = "v1"))
@ConfigurationPropertiesScan
class ApplicationConfig {
    @Bean
    fun kotlinModule() = KotlinModule.Builder().build()

    companion object {
        const val PACKAGE_NAME = "no.entur.shared.mobility.to.ref"
    }
}
