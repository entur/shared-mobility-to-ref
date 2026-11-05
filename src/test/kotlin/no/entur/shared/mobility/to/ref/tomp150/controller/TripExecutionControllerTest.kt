package no.entur.shared.mobility.to.ref.tomp150.controller

import no.entur.shared.mobility.to.ref.Application
import no.entur.shared.mobility.to.ref.config.TransportOperator
import no.entur.shared.mobility.to.ref.tomp150.dto.LegEvent
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.OffsetDateTime
import java.util.UUID

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TripExecutionControllerTest {
    @Autowired
    private lateinit var legsController: TripExecutionController

    @Test
    fun legsIdEventsPost() {
        legsController.legsIdEventsPost(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            id = UUID.randomUUID().toString(),
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
            legEvent = LegEvent(event = LegEvent.Event.SET_IN_USE, time = OffsetDateTime.now()),
        )
    }

    @Test
    fun legsIdGet() {
        legsController.legsIdGet(
            acceptLanguage = "NOB",
            api = "TOMP",
            apiVersion = "1.5.0",
            maasId = "entur:maas:shared-mobility",
            id = UUID.randomUUID().toString(),
            addressedTo = TransportOperator.ALL_IMPLEMENTING_OPERATOR,
        )
    }
}
