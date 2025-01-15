package no.entur.shared.mobility.to.ref.controller

import no.entur.shared.mobility.to.ref.Application
import no.entur.shared.mobility.to.ref.service.TransportOperator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.UUID

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SupportControllerTest {
    @Autowired
    private lateinit var supportController: SupportController

    @Test
    fun supportIdStatusGet() {
        assertThrows<NotImplementedError> {
            supportController.supportIdStatusGet(
                acceptLanguage = "NOB",
                api = "TOMP",
                apiVersion = "1.5.0",
                maasId = "entur:maas:shared-mobility",
                addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
                id = UUID.randomUUID().toString(),
            )
        }
    }

    @Test
    fun supportPost() {
        supportController.supportPost(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            supportRequest = null,
        )
    }
}
