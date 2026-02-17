package no.entur.shared.mobility.to.ref.tomp150.service

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import no.entur.shared.mobility.to.ref.client.SharedMobilityRouterClient
import no.entur.shared.mobility.to.ref.tomp150.dto.LegEvent
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.concurrent.ConcurrentHashMap

class EventScheduler150Test {
    private val sharedMobilityRouterClient: SharedMobilityRouterClient = mockk(relaxed = true)

    private val eventScheduler = EventScheduler150(sharedMobilityRouterClient)

    @BeforeEach
    fun setup() {
        // Clear queues before each test
        getEventMap().clear()
    }

    @Test
    fun `messageTakeBike should send message`() {
        eventScheduler.addToEventQueue(BOOKING_ID, LEG_ID, OPERATOR_ID)

        eventScheduler.messageTakeBike()

        verify {
            sharedMobilityRouterClient.bookingsIdNotificationsPost150(
                maasId = OPERATOR_ID,
                id = BOOKING_ID,
                addressedTo = ENTUR,
                notification = any(),
            )
        }
        getEventMap() shouldHaveSize 0
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
        } throws RuntimeException()

        eventScheduler.messageTakeBike()

        verify {
            sharedMobilityRouterClient.bookingsIdNotificationsPost150(
                maasId = OPERATOR_ID,
                id = BOOKING_ID,
                addressedTo = ENTUR,
                notification = any(),
            )
        }
        getEventMap() shouldHaveSize 0
    }

    @Test
    fun `setInUse should call legsIdEventsPost150 to start trip`() {
        val tripStartQueue = getEventMap()
        tripStartQueue.add(Triple(BOOKING_ID, LEG_ID, OPERATOR_ID))

        eventScheduler.setInUse()

        verify {
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
        val tripStartQueue = getEventMap()
        tripStartQueue.add(Triple(BOOKING_ID, LEG_ID, OPERATOR_ID))
        val slot = slot<LegEvent>()
        every {
            sharedMobilityRouterClient.legsIdEventsPost150(
                id = LEG_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                legEvent = capture(slot),
            )
        } throws RuntimeException()

        eventScheduler.setInUse()

        verify {
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
        val tripEndQueue = getEventMap()
        tripEndQueue.add(Triple(BOOKING_ID, LEG_ID, OPERATOR_ID))

        eventScheduler.handleFinish(automatedBehaviour)

        verify {
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
        val tripEndQueue = getEventMap()
        tripEndQueue.add(Triple(BOOKING_ID, LEG_ID, OPERATOR_ID))
        val slot = slot<LegEvent>()
        every {
            sharedMobilityRouterClient.legsIdEventsPost150(
                id = LEG_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                legEvent = capture(slot),
            )
        } throws RuntimeException()

        eventScheduler.handleFinish(automatedBehaviour)

        verify {
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

    private fun getEventMap(): ConcurrentHashMap<String, AutomatedBehaviour> {
        val field = EventScheduler150::class.java.getDeclaredField("eventMap")
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
