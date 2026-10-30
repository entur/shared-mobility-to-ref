package no.entur.shared.mobility.to.ref.tomp160.controller

import no.entur.shared.mobility.to.ref.Application
import no.entur.shared.mobility.to.ref.config.TransportOperator
import no.entur.shared.mobility.to.ref.tomp160.data.place
import no.entur.shared.mobility.to.ref.tomp160.dto.OneStopBookingRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import no.entur.shared.mobility.to.ref.tomp160.controller.required.PlanningController as RequiredPlanningController
import no.entur.shared.mobility.to.ref.tomp160.controller.unused.PlanningController as UnusedPlanningController

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlanningControllerTest {
    @Autowired
    private lateinit var unusedPlanningController: UnusedPlanningController

    @Autowired
    private lateinit var requiredPlanningController: RequiredPlanningController

    @Test
    fun bookingsOneStopPost() {
        requiredPlanningController.bookingsOneStopPost(
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
        unusedPlanningController.planningInquiriesPost(
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
        requiredPlanningController.planningOffersPost(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            planningRequest = null,
        )
    }
}
