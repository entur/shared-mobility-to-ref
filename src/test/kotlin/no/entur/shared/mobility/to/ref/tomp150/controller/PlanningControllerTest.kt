package no.entur.shared.mobility.to.ref.tomp150.controller

import no.entur.shared.mobility.to.ref.Application
import no.entur.shared.mobility.to.ref.config.TransportOperator
import no.entur.shared.mobility.to.ref.tomp150.data.place
import no.entur.shared.mobility.to.ref.tomp150.dto.OneStopBookingRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlanningControllerTest {
    @Autowired
    private lateinit var planningController: PlanningController

    @Test
    fun bookingsOneStopPost() {
        planningController.bookingsOneStopPost(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            oneStopBookingRequest = OneStopBookingRequest(from = place),
        )
    }

    @Test
    fun planningInquiriesPost() {
        planningController.planningInquiriesPost(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            null,
        )
    }

    @Test
    fun planningOffersPost() {
        planningController.planningOffersPost(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            planningRequest = null,
        )
    }
}
