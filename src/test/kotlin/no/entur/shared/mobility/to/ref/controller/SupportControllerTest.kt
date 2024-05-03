package no.entur.shared.mobility.to.ref.controller

import no.entur.shared.mobility.to.ref.Application
import no.entur.shared.mobility.to.ref.service.TransportOperator
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SupportControllerTest {
    @Autowired
    private lateinit var supportController: SupportController

    @Test
    fun supportIdStatusGet() {
        supportController.supportIdStatusGet(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            id = "",
        )
    }

    @Test
    fun supportPost() {
        supportController.supportPost(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            supportRequest = null,
        )
    }
}
