package no.entur.shared.mobility.to.ref.config

import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springdoc.core.customizers.GlobalOperationCustomizer
import org.springdoc.core.filters.GlobalOpenApiMethodFilter
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling

@ComponentScan(ApplicationConfig.PACKAGE_NAME)
@OpenAPIDefinition(info = Info(title = "Entur shared mobility transport operator reference API", version = "v1"))
@ConfigurationPropertiesScan
@EnableScheduling
@Configuration
@EnableFeignClients(basePackages = ["no.entur.shared.mobility.to.ref.client"])
class ApplicationConfig {
    @Bean
    fun kotlinModule() = KotlinModule.Builder().build()

    // Swagger docs show only endpoints marked @TompEndpoint (TOMP 1.6 overrides).
    // Global beans so the default /v3/api-docs, which the API gateway publishes, is filtered.
    @Bean
    fun tompEndpointsOnly() = GlobalOpenApiMethodFilter { it.isAnnotationPresent(TompEndpoint::class.java) }

    // Group by the spec's first tag ("TO"/"MP" and "[optional]" tag variants dropped),
    // and label optional endpoints "[Optional]".
    @Bean
    fun tompOperationDocs() =
        GlobalOperationCustomizer { operation, handlerMethod ->
            operation.tags = operation.tags?.take(1)?.map { it.removeSuffix(" [optional]") }
            if (handlerMethod.getMethodAnnotation(TompEndpoint::class.java)?.optional == true) {
                operation.summary = "[Optional] ${operation.summary.orEmpty()}".trim()
            }
            operation
        }

    companion object {
        const val PACKAGE_NAME = "no.entur.shared.mobility.to.ref"
    }
}
