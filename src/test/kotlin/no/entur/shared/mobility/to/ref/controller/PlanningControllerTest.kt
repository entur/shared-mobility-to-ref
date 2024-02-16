package no.entur.shared.mobility.to.ref.controller

import no.entur.shared.mobility.to.ref.Application
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlanningControllerTest {
    @Autowired
    private lateinit var planningController: PlanningController

    @Test
    fun planningInquiriesPost() {
        planningController.planningInquiriesPost(
            "",
            "",
            "",
            "",
            "",
            null,
        )
    }

    @Test
    fun planningOffersPost() {
        planningController.planningOffersPost(
            acceptLanguage = "",
            api = "",
            apiVersion = "",
            maasId = "",
            addressedTo = "",
            planningRequest = null,
        )
    }
}
