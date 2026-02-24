package no.entur.shared.mobility.to.ref.tomp160.service

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import no.entur.shared.mobility.to.ref.client.SharedMobilityRouterClient
import no.entur.shared.mobility.to.ref.tomp160.dto.LegEvent
import no.entur.shared.mobility.to.ref.tomp160.dto.Notification
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime
import java.util.concurrent.ConcurrentHashMap

class EventScheduler160Test {
    private val sharedMobilityRouterClient: SharedMobilityRouterClient = mockk(relaxed = true)
    private val eventScheduler = EventScheduler160(sharedMobilityRouterClient)

    @BeforeEach
    fun setup() {
        getEventMap().clear()
    }

    @Test
    fun `handleScheduledLegAction - TAKE_MESSAGE sends notification and transitions to SET_IN_USE`() {
        // Arrange
        eventScheduler.addTakeBikeMessage(BOOKING_ID, LEG_ID, OPERATOR_ID)

        // Make it due now (avoid timing flakiness)
        val map = getEventMap()
        map[LEG_ID] = map[LEG_ID]!!.copy(triggerTime = OffsetDateTime.now().minusSeconds(1))

        val notifSlot = slot<Notification>()

        // Act
        eventScheduler.handleScheduledLegAction()

        // Assert: notification posted
        verify(exactly = 1) {
            sharedMobilityRouterClient.bookingsIdNotificationsPost160(
                id = BOOKING_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                notification = capture(notifSlot),
            )
        }
        notifSlot.captured.legId shouldBe LEG_ID
        notifSlot.captured.comment shouldBe "You can now take the bike."

        // Assert: state transitioned (still 1 entry in map)
        getEventMap() shouldHaveSize 1
        getEventMap()[LEG_ID]!!.type shouldBe ScheduledLegActionType.SET_IN_USE
        getEventMap()[LEG_ID]!!.legEvent shouldBe LegEvent.Event.SET_IN_USE
    }

    @Test
    fun `handleScheduledLegAction - TAKE_MESSAGE failure keeps entry for retry`() {
        eventScheduler.addTakeBikeMessage(BOOKING_ID, LEG_ID, OPERATOR_ID)

        val map = getEventMap()
        map[LEG_ID] = map[LEG_ID]!!.copy(triggerTime = OffsetDateTime.now().minusSeconds(1))

        every {
            sharedMobilityRouterClient.bookingsIdNotificationsPost160(
                id = BOOKING_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                notification = any(),
            )
        } throws RuntimeException("boom")

        shouldThrow<RuntimeException> {
            eventScheduler.handleScheduledLegAction()
        }

        verify(exactly = 1) {
            sharedMobilityRouterClient.bookingsIdNotificationsPost160(
                id = BOOKING_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                notification = any(),
            )
        }
        getEventMap() shouldHaveSize 1
        getEventMap()[LEG_ID]!!.type shouldBe ScheduledLegActionType.TAKE_MESSAGE
    }

    @Test
    fun `handleScheduledLegAction - SET_IN_USE posts leg event and transitions to FINISH`() {
        // Arrange: directly seed SET_IN_USE step (due now)
        getEventMap()[LEG_ID] =
            ScheduledLegAction(
                bookingId = BOOKING_ID,
                legId = LEG_ID,
                operatorId = OPERATOR_ID,
                triggerTime = OffsetDateTime.now().minusSeconds(1),
                type = ScheduledLegActionType.SET_IN_USE,
                legEvent = LegEvent.Event.SET_IN_USE,
            )

        val legEventSlot = slot<LegEvent>()

        // Act
        eventScheduler.handleScheduledLegAction()

        // Assert: leg event posted
        verify(exactly = 1) {
            sharedMobilityRouterClient.legsIdEventsPost160(
                id = LEG_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                legEvent = capture(legEventSlot),
            )
        }
        legEventSlot.captured.event shouldBe LegEvent.Event.SET_IN_USE

        // Assert: transitioned to FINISH
        getEventMap() shouldHaveSize 1
        getEventMap()[LEG_ID]!!.type shouldBe ScheduledLegActionType.FINISH
        getEventMap()[LEG_ID]!!.legEvent shouldBe LegEvent.Event.FINISH
    }

    @Test
    fun `handleScheduledLegAction - SET_IN_USE failure keeps entry for retry`() {
        getEventMap()[LEG_ID] =
            ScheduledLegAction(
                bookingId = BOOKING_ID,
                legId = LEG_ID,
                operatorId = OPERATOR_ID,
                triggerTime = OffsetDateTime.now().minusSeconds(1),
                type = ScheduledLegActionType.SET_IN_USE,
                legEvent = LegEvent.Event.SET_IN_USE,
            )

        every {
            sharedMobilityRouterClient.legsIdEventsPost160(
                id = LEG_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                legEvent = any(),
            )
        } throws RuntimeException("boom")

        shouldThrow<RuntimeException> {
            eventScheduler.handleScheduledLegAction()
        }

        verify(exactly = 1) {
            sharedMobilityRouterClient.legsIdEventsPost160(
                id = LEG_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                legEvent = any(),
            )
        }

        getEventMap() shouldHaveSize 1
        getEventMap()[LEG_ID]!!.type shouldBe ScheduledLegActionType.SET_IN_USE
    }

    @Test
    fun `startNearStationFlow sends PARKING_WARNING and schedules FULL_STATION_MESSAGE`() {
        // Arrange
        eventScheduler.addTakeBikeMessage(BOOKING_ID, LEG_ID, OPERATOR_ID)
        eventScheduler.startNearStationFlow(LEG_ID)

        // Make due now
        val map = getEventMap()
        map[LEG_ID] = map[LEG_ID]!!.copy(triggerTime = OffsetDateTime.now().minusSeconds(1))

        val notifSlot = slot<Notification>()

        // Act
        eventScheduler.handleScheduledLegAction()

        // Assert: parking warning sent
        verify(exactly = 1) {
            sharedMobilityRouterClient.bookingsIdNotificationsPost160(
                id = BOOKING_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                notification = capture(notifSlot),
            )
        }
        notifSlot.captured.comment shouldBe "Parking warning: please park the bike correctly and follow local rules."

        // Assert: transitioned to FULL_STATION_MESSAGE (next step)
        getEventMap()[LEG_ID]!!.type shouldBe ScheduledLegActionType.FULL_STATION_MESSAGE
        getEventMap()[LEG_ID]!!.legEvent shouldBe LegEvent.Event.SET_IN_USE // unchanged by notification step (ok)
    }

    @Test
    fun `nearStationFlow second run sends FULL_STATION_MESSAGE and schedules FINISH`() {
        eventScheduler.addTakeBikeMessage(BOOKING_ID, LEG_ID, OPERATOR_ID)
        eventScheduler.startNearStationFlow(LEG_ID)

        val map = getEventMap()

        // 1) PARKING_WARNING
        map[LEG_ID] =
            map[LEG_ID]!!.copy(
                type = ScheduledLegActionType.PARKING_WARNING,
                triggerTime = OffsetDateTime.now().minusSeconds(1),
            )
        eventScheduler.handleScheduledLegAction()

        // 2) FULL_STATION_MESSAGE
        map[LEG_ID] =
            map[LEG_ID]!!.copy(
                type = ScheduledLegActionType.FULL_STATION_MESSAGE,
                triggerTime = OffsetDateTime.now().minusSeconds(1),
            )
        eventScheduler.handleScheduledLegAction()

        val notifications = mutableListOf<Notification>()
        verify(exactly = 2) {
            sharedMobilityRouterClient.bookingsIdNotificationsPost160(
                id = BOOKING_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                notification = capture(notifications),
            )
        }

        notifications[1].comment shouldBe "Dock is full. Please place the bike next and lock the bike."

        getEventMap()[LEG_ID]!!.type shouldBe ScheduledLegActionType.FINISH
        getEventMap()[LEG_ID]!!.legEvent shouldBe LegEvent.Event.FINISH
    }

    @Test
    fun `handleScheduledLegAction - FINISH posts leg finish and removes entry`() {
        // Arrange
        getEventMap()[LEG_ID] =
            ScheduledLegAction(
                bookingId = BOOKING_ID,
                legId = LEG_ID,
                operatorId = OPERATOR_ID,
                triggerTime = OffsetDateTime.now().minusSeconds(1),
                type = ScheduledLegActionType.FINISH,
                legEvent = LegEvent.Event.FINISH,
            )

        val legEventSlot = slot<LegEvent>()

        // Act
        eventScheduler.handleScheduledLegAction()

        // Assert: FINISH posted and entry removed
        verify(exactly = 1) {
            sharedMobilityRouterClient.legsIdEventsPost160(
                id = LEG_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                legEvent = capture(legEventSlot),
            )
        }
        legEventSlot.captured.event shouldBe LegEvent.Event.FINISH

        getEventMap() shouldHaveSize 0
    }

    private fun getEventMap(): ConcurrentHashMap<String, ScheduledLegAction> {
        val field = EventScheduler160::class.java.getDeclaredField("eventMap")
        field.isAccessible = true
        @Suppress("UNCHECKED_CAST")
        return field.get(eventScheduler) as ConcurrentHashMap<String, ScheduledLegAction>
    }

    companion object {
        private const val BOOKING_ID = "bookingId"
        private const val LEG_ID = "legId"
        private const val OPERATOR_ID = "operatorId"
        private const val ENTUR = "Entur"
    }
}
