package no.entur.shared.mobility.to.ref.tomp150.service

import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.mockk.mockk
import io.mockk.verify
import no.entur.shared.mobility.to.ref.client.SharedMobilityRouterClient
import no.entur.shared.mobility.to.ref.tomp150.dto.LegEvent
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime
import java.util.concurrent.ConcurrentHashMap

class EventScheduler150Test {
    private val sharedMobilityRouterClient: SharedMobilityRouterClient = mockk(relaxed = true)
    private val eventScheduler = EventScheduler150(sharedMobilityRouterClient)

    @BeforeEach
    fun setup() {
        getEventMap().clear()
    }

    @Test
    fun `handleScheduledLegAction for TAKE_MESSAGE posts notification and schedules SET_IN_USE`() {
        val map = getEventMap()
        map[LEG_ID] =
            ScheduledLegAction(
                bookingId = BOOKING_ID,
                legId = LEG_ID,
                operatorId = OPERATOR_ID,
                triggerTime = OffsetDateTime.now().minusSeconds(1),
                type = ScheduledLegActionType.TAKE_MESSAGE,
                legEvent = LegEvent.Event.SET_IN_USE,
            )

        eventScheduler.handleScheduledLegAction()

        verify(exactly = 1) {
            sharedMobilityRouterClient.bookingsIdNotificationsPost150(
                id = BOOKING_ID,
                maasId = OPERATOR_ID,
                addressedTo = "Entur",
                notification = any(),
            )
        }

        map shouldHaveSize 1
        map[LEG_ID]!!.type shouldBe ScheduledLegActionType.SET_IN_USE
        map[LEG_ID]!!.legEvent shouldBe LegEvent.Event.SET_IN_USE
    }

    @Test
    fun `SET_IN_USE posts leg event and schedules FINISH`() {
        val map = getEventMap()
        map[LEG_ID] =
            ScheduledLegAction(
                bookingId = BOOKING_ID,
                legId = LEG_ID,
                operatorId = OPERATOR_ID,
                triggerTime = OffsetDateTime.now().minusSeconds(1),
                type = ScheduledLegActionType.SET_IN_USE,
                legEvent = LegEvent.Event.SET_IN_USE,
            )

        eventScheduler.handleScheduledLegAction()

        verify(exactly = 1) {
            sharedMobilityRouterClient.legsIdEventsPost150(
                id = LEG_ID,
                maasId = OPERATOR_ID,
                addressedTo = "Entur",
                legEvent = any(),
            )
        }

        map shouldHaveSize 1
        map[LEG_ID]!!.type shouldBe ScheduledLegActionType.FINISH
        map[LEG_ID]!!.legEvent shouldBe LegEvent.Event.FINISH
    }

    @Test
    fun `FINISH posts leg event and removes entry`() {
        val map = getEventMap()
        map[LEG_ID] =
            ScheduledLegAction(
                bookingId = BOOKING_ID,
                legId = LEG_ID,
                operatorId = OPERATOR_ID,
                triggerTime = OffsetDateTime.now().minusSeconds(1),
                type = ScheduledLegActionType.FINISH,
                legEvent = LegEvent.Event.FINISH,
            )

        eventScheduler.handleScheduledLegAction()

        verify(exactly = 1) {
            sharedMobilityRouterClient.legsIdEventsPost150(
                id = LEG_ID,
                maasId = OPERATOR_ID,
                addressedTo = "Entur",
                legEvent = any(),
            )
        }

        map shouldHaveSize 0
    }

    private fun getEventMap(): ConcurrentHashMap<String, ScheduledLegAction> {
        val field = EventScheduler150::class.java.getDeclaredField("eventMap")
        field.isAccessible = true
        @Suppress("UNCHECKED_CAST")
        return field.get(eventScheduler) as ConcurrentHashMap<String, ScheduledLegAction>
    }

    companion object {
        private const val BOOKING_ID = "booking-1"
        private const val LEG_ID = "leg-1"
        private const val OPERATOR_ID = "operator-1"
    }
}
