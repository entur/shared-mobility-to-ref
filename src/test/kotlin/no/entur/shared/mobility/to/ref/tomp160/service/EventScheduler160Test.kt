package no.entur.shared.mobility.to.ref.tomp160.service

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
    fun `handleAutomatedBehaviour - TAKE_MESSAGE sends notification and transitions to SET_IN_USE`() {
        // Arrange
        eventScheduler.addTakeBikeMessage(BOOKING_ID, LEG_ID, OPERATOR_ID)

        // Make it due now (avoid timing flakiness)
        val map = getEventMap()
        map[LEG_ID] = map[LEG_ID]!!.copy(triggerTime = OffsetDateTime.now().minusSeconds(1))

        val notifSlot = slot<Notification>()

        // Act
        eventScheduler.handleAutomatedBehaviour()

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
        getEventMap()[LEG_ID]!!.type shouldBe "SET_IN_USE"
        getEventMap()[LEG_ID]!!.legEvent shouldBe LegEvent.Event.SET_IN_USE
    }

    @Test
    fun `handleAutomatedBehaviour - TAKE_MESSAGE failure keeps entry for retry`() {
        // Arrange
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

        // Act
        eventScheduler.handleAutomatedBehaviour()

        // Assert: attempted, but entry remains and stays on same step
        verify(exactly = 1) {
            sharedMobilityRouterClient.bookingsIdNotificationsPost160(
                id = BOOKING_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                notification = any(),
            )
        }
        getEventMap() shouldHaveSize 1
        getEventMap()[LEG_ID]!!.type shouldBe "TAKE_MESSAGE"
    }

    @Test
    fun `handleAutomatedBehaviour - SET_IN_USE posts leg event and transitions to FINISH`() {
        // Arrange: directly seed SET_IN_USE step (due now)
        getEventMap()[LEG_ID] =
            AutomatedBehaviour(
                bookingId = BOOKING_ID,
                legId = LEG_ID,
                operatorId = OPERATOR_ID,
                triggerTime = OffsetDateTime.now().minusSeconds(1),
                type = "SET_IN_USE",
                legEvent = LegEvent.Event.SET_IN_USE,
            )

        val legEventSlot = slot<LegEvent>()

        // Act
        eventScheduler.handleAutomatedBehaviour()

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
        getEventMap()[LEG_ID]!!.type shouldBe "FINISH"
        getEventMap()[LEG_ID]!!.legEvent shouldBe LegEvent.Event.FINISH
    }

    @Test
    fun `handleAutomatedBehaviour - SET_IN_USE failure keeps entry for retry`() {
        // Arrange
        getEventMap()[LEG_ID] =
            AutomatedBehaviour(
                bookingId = BOOKING_ID,
                legId = LEG_ID,
                operatorId = OPERATOR_ID,
                triggerTime = OffsetDateTime.now().minusSeconds(1),
                type = "SET_IN_USE",
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

        // Act
        eventScheduler.handleAutomatedBehaviour()

        // Assert
        verify(exactly = 1) {
            sharedMobilityRouterClient.legsIdEventsPost160(
                id = LEG_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                legEvent = any(),
            )
        }
        getEventMap() shouldHaveSize 1
        getEventMap()[LEG_ID]!!.type shouldBe "SET_IN_USE"
    }

    @Test
    fun `addFullStationMessage switches to FULL_STATION_MESSAGE and next run sends full station notification`() {
        // Arrange: start with a normal entry
        eventScheduler.addTakeBikeMessage(BOOKING_ID, LEG_ID, OPERATOR_ID)

        // Switch flow
        eventScheduler.addFullStationMessage(LEG_ID)

        // Make due now
        val map = getEventMap()
        map[LEG_ID] = map[LEG_ID]!!.copy(triggerTime = OffsetDateTime.now().minusSeconds(1))

        val notifSlot = slot<Notification>()

        // Act
        eventScheduler.handleAutomatedBehaviour()

        // Assert notification content
        verify(exactly = 1) {
            sharedMobilityRouterClient.bookingsIdNotificationsPost160(
                id = BOOKING_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                notification = capture(notifSlot),
            )
        }
        notifSlot.captured.comment shouldBe "Dock is full. Please place the bike next and lock the bike."

        // Assert transitioned to FINISH
        getEventMap()[LEG_ID]!!.type shouldBe "FINISH"
        getEventMap()[LEG_ID]!!.legEvent shouldBe LegEvent.Event.FINISH
    }

    @Test
    fun `handleAutomatedBehaviour - FINISH posts leg finish and removes entry`() {
        // Arrange
        getEventMap()[LEG_ID] =
            AutomatedBehaviour(
                bookingId = BOOKING_ID,
                legId = LEG_ID,
                operatorId = OPERATOR_ID,
                triggerTime = OffsetDateTime.now().minusSeconds(1),
                type = "FINISH",
                legEvent = LegEvent.Event.FINISH,
            )

        val legEventSlot = slot<LegEvent>()

        // Act
        eventScheduler.handleAutomatedBehaviour()

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

    private fun getEventMap(): ConcurrentHashMap<String, AutomatedBehaviour> {
        val field = EventScheduler160::class.java.getDeclaredField("eventMap")
        field.isAccessible = true
        @Suppress("UNCHECKED_CAST")
        return field.get(eventScheduler) as ConcurrentHashMap<String, AutomatedBehaviour>
    }

    companion object {
        const val BOOKING_ID = "bookingId"
        const val LEG_ID = "legId"
        const val OPERATOR_ID = "operatorId"
        const val ENTUR = "Entur"
    }
}
