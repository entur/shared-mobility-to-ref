package no.entur.shared.mobility.to.ref.config

/**
 * Marks a TOMP endpoint override as shown in the Swagger docs.
 * Optional endpoints are labelled "[Optional]".
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class TompEndpoint(
    val optional: Boolean = false,
)
