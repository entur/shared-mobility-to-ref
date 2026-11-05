package no.entur.shared.mobility.to.ref

import io.kotest.matchers.shouldBe
import no.entur.shared.mobility.to.ref.config.TransportOperator
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = [Application::class])
class ApplicationTests {
    @Value("\${local.server.port}")
    private var port: Int = 0

    @Test
    fun contextLoads() {
    }

    // Routes come from the generated API interfaces; custom controllers override only what they implement.
    @Test
    fun `overridden endpoints should be served under each version's base path`() {
        get("/tomp160/operator/meta") shouldBe 200
        get("/operator/meta") shouldBe 200
    }

    @Test
    fun `endpoints not overridden should return 501`() {
        get("/tomp160/bookings/1/notifications") shouldBe 501
        get("/bookings/1/notifications") shouldBe 501
    }

    private fun get(path: String): Int =
        HttpClient
            .newHttpClient()
            .send(
                HttpRequest
                    .newBuilder(URI("http://localhost:$port$path"))
                    .header("Accept-Language", "NOB")
                    .header("Api", "TOMP")
                    .header("Api-Version", "1.6.0")
                    .header("maas-id", "entur:maas:shared-mobility")
                    .header("addressed-to", TransportOperator.ALL_IMPLEMENTING_OPERATOR)
                    .build(),
                HttpResponse.BodyHandlers.discarding(),
            ).statusCode()
}
