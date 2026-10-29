package no.entur.shared.mobility.to.ref.tomp150.controller

import no.entur.shared.mobility.to.ref.Application
import no.entur.shared.mobility.to.ref.config.TransportOperator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.UUID
import no.entur.shared.mobility.to.ref.tomp150.controller.optional.SupportController as OptionalSupportController
import no.entur.shared.mobility.to.ref.tomp150.controller.required.SupportController as RequiredSupportController

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SupportControllerTest {
    @Autowired
    private lateinit var requiredSupportController: RequiredSupportController

    @Autowired
    private lateinit var optionalSupportController: OptionalSupportController

    @Test
    fun supportIdStatusGet() {
        assertThrows<NotImplementedError> {
            optionalSupportController.supportIdStatusGet(
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
        requiredSupportController.supportPost(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            supportRequest = null,
        )
    }
}
