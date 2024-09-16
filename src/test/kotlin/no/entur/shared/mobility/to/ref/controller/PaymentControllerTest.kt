package no.entur.shared.mobility.to.ref.controller

import no.entur.shared.mobility.to.ref.Application
import no.entur.shared.mobility.to.ref.service.TransportOperator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.OffsetDateTime

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentControllerTest {
    @Autowired
    private lateinit var paymentController: PaymentController

    @Test
    fun paymentIdClaimExtraCostsPost() {
        assertThrows<NotImplementedError> {
            paymentController.paymentIdClaimExtraCostsPost(
                acceptLanguage = "",
                api = "",
                apiVersion = "",
                maasId = "",
                id = "",
                addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
                extraCosts = null,
            )
        }
    }

    @Test
    fun paymentJournalEntryGet() {
        assertThrows<NotImplementedError> {
            paymentController.paymentJournalEntryGet(
                acceptLanguage = "",
                api = "",
                apiVersion = "",
                maasId = "",
                id = "",
                limit = 0,
                offset = 0,
                from = OffsetDateTime.now(),
                to = OffsetDateTime.now(),
                state = null,
                category = null,
                addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            )
        }
    }
}
