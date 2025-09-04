package no.entur.shared.mobility.client.interceptor

import feign.RequestInterceptor
import feign.RequestTemplate
import org.entur.auth.client.AccessTokenFactory
import org.springframework.context.annotation.Bean

class AuthorizationInterceptor(
    private val accessTokenFactory: AccessTokenFactory,
) : RequestInterceptor {
    override fun apply(template: RequestTemplate) {
        val accessToken = accessTokenFactory.accessToken
        template.header("Authorization", "Bearer $accessToken")
    }
}

class AuthorizationConfig {
    @Bean
    fun authorizationInterceptor(accessTokenFactory: AccessTokenFactory): AuthorizationInterceptor =
        AuthorizationInterceptor(accessTokenFactory)
}
