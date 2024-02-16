package no.entur.shared.mobility.to.ref.controller

import no.entur.shared.mobility.to.ref.Application
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlanningsControllerTest {
    @Autowired
    private lateinit var planningsController: PlanningsController

    @Test
    fun planningsPost() {
        planningsController.planningsPost(
            "",
            "",
            "",
            "",
            "",
            true,
            null,
        )
    }
}
