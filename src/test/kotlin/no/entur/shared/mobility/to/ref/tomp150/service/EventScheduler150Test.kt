package no.entur.shared.mobility.to.ref.tomp150.service

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import no.entur.shared.mobility.to.ref.client.SharedMobilityRouterClient
import no.entur.shared.mobility.to.ref.tomp150.dto.LegEvent
import no.entur.shared.mobility.to.ref.tomp150.service.EventScheduler150.ScheduledTripEnd
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime

class EventScheduler150Test {
    private val sharedMobilityRouterClient: SharedMobilityRouterClient = mockk(relaxed = true)
    private val eventScheduler = EventScheduler150(sharedMobilityRouterClient)

    @BeforeEach
    fun setup() {
        eventScheduler.startMessageQueueForTest().clear()
        eventScheduler.tripStartQueueForTest().clear()
        eventScheduler.tripEndQueueForTest().clear()
    }

    @Test
    fun `messageTakeBike should send message`() {
        eventScheduler.addToEventQueue(BOOKING_ID, LEG_ID, OPERATOR_ID)

        eventScheduler.messageTakeBike()

        verify(exactly = 1) {
            sharedMobilityRouterClient.bookingsIdNotificationsPost150(
                maasId = OPERATOR_ID,
                id = BOOKING_ID,
                addressedTo = ENTUR,
                notification = any(),
            )
        }

        eventScheduler.startMessageQueueForTest() shouldHaveSize 0
        eventScheduler.tripStartQueueForTest() shouldHaveSize 1
    }

    @Test
    fun `messageTakeBike that fails should still remove the item from the queue`() {
        eventScheduler.addToEventQueue(BOOKING_ID, LEG_ID, OPERATOR_ID)

        every {
            sharedMobilityRouterClient.bookingsIdNotificationsPost150(
                maasId = OPERATOR_ID,
                id = BOOKING_ID,
                addressedTo = ENTUR,
                notification = any(),
            )
        } throws RuntimeException("boom")

        eventScheduler.messageTakeBike()

        verify(exactly = 1) {
            sharedMobilityRouterClient.bookingsIdNotificationsPost150(
                maasId = OPERATOR_ID,
                id = BOOKING_ID,
                addressedTo = ENTUR,
                notification = any(),
            )
        }

        // Koden din remover alltid fra startMessageQueue og add'er til tripStartQueue uansett runCatching-resultat
        eventScheduler.startMessageQueueForTest() shouldHaveSize 0
        eventScheduler.tripStartQueueForTest() shouldHaveSize 1
    }

    @Test
    fun `setInUse should call legsIdEventsPost150 to start trip`() {
        val tripStartQueue = eventScheduler.tripStartQueueForTest()
        tripStartQueue.add(Triple(BOOKING_ID, LEG_ID, OPERATOR_ID))

        eventScheduler.setInUse()

        verify(exactly = 1) {
            sharedMobilityRouterClient.legsIdEventsPost150(
                id = LEG_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                legEvent = any(),
            )
        }

        tripStartQueue shouldHaveSize 0
    }

    @Test
    fun `setInUse that fails should still remove the item from the queue`() {
        val tripStartQueue = eventScheduler.tripStartQueueForTest()
        tripStartQueue.add(Triple(BOOKING_ID, LEG_ID, OPERATOR_ID))

        val slot = slot<LegEvent>()
        every {
            sharedMobilityRouterClient.legsIdEventsPost150(
                id = LEG_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                legEvent = capture(slot),
            )
        } throws RuntimeException("boom")

        eventScheduler.setInUse()

        verify(exactly = 1) {
            sharedMobilityRouterClient.legsIdEventsPost150(
                id = LEG_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                legEvent = any(),
            )
        }

        slot.captured.event shouldBe LegEvent.Event.SET_IN_USE
        tripStartQueue shouldHaveSize 0
    }

    @Test
    fun `setFinished should call legsIdEventsPost150 to end trip`() {
        val tripEndQueue = eventScheduler.tripEndQueueForTest()

        tripEndQueue.add(
            ScheduledTripEnd(
                bookingId = BOOKING_ID,
                legId = LEG_ID,
                operatorId = OPERATOR_ID,
                finishAt = OffsetDateTime.now().minusSeconds(1), // due
                nearStationDropoff = false,
            ),
        )

        eventScheduler.setFinished()

        verify(exactly = 1) {
            sharedMobilityRouterClient.legsIdEventsPost150(
                id = LEG_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                legEvent = any(),
            )
        }

        tripEndQueue shouldHaveSize 0
    }

    @Test
    fun `setFinished that fails should still remove the item from the queue`() {
        val tripEndQueue = eventScheduler.tripEndQueueForTest()

        tripEndQueue.add(
            ScheduledTripEnd(
                bookingId = BOOKING_ID,
                legId = LEG_ID,
                operatorId = OPERATOR_ID,
                finishAt = OffsetDateTime.now().minusSeconds(1), // due
                nearStationDropoff = false,
            ),
        )

        val slot = slot<LegEvent>()
        every {
            sharedMobilityRouterClient.legsIdEventsPost150(
                id = LEG_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                legEvent = capture(slot),
            )
        } throws RuntimeException("boom")

        eventScheduler.setFinished()

        verify(exactly = 1) {
            sharedMobilityRouterClient.legsIdEventsPost150(
                id = LEG_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                legEvent = any(),
            )
        }

        slot.captured.event shouldBe LegEvent.Event.FINISH
        tripEndQueue shouldHaveSize 0
    }

    companion object {
        const val BOOKING_ID = "bookingId"
        const val LEG_ID = "legId"
        const val OPERATOR_ID = "operatorId"
        const val ENTUR = "Entur"
    }
}
