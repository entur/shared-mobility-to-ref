package no.entur.shared.mobility.to.ref.tomp160.controller

import no.entur.shared.mobility.to.ref.Application
import no.entur.shared.mobility.to.ref.config.TransportOperator
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OperatorControllerTest {
    @Autowired
    private lateinit var operatorController: OperatorInformationController

    @Test
    fun operatorMetaGet() {
        operatorController.operatorMetaGet(
            acceptLanguage = "NOB",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
        )
    }
}
