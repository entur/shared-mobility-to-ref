package no.entur.shared.mobility.to.ref.tomp160.service

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import no.entur.shared.mobility.to.ref.client.SharedMobilityRouterClient
import no.entur.shared.mobility.to.ref.tomp160.dto.LegEvent
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.concurrent.ConcurrentLinkedQueue

class EventScheduler160Test {
    private val sharedMobilityRouterClient: SharedMobilityRouterClient = mockk(relaxed = true)

    private val eventScheduler = EventScheduler160(sharedMobilityRouterClient)

    @BeforeEach
    fun setup() {
        // Clear queues before each test
        getQueue("startMessageQueue").clear()
        getQueue("tripStartQueue").clear()
        getQueue("tripEndQueue").clear()
    }

    @Test
    fun `messageTakeBike should send message`() {
        eventScheduler.addToEventQueue(BOOKING_ID, LEG_ID, OPERATOR_ID)

        eventScheduler.messageTakeBike()

        verify {
            sharedMobilityRouterClient.bookingsIdNotificationsPost160(
                maasId = OPERATOR_ID,
                id = BOOKING_ID,
                addressedTo = ENTUR,
                notification = any(),
            )
        }
        getQueue("startMessageQueue") shouldHaveSize 0
    }

    @Test
    fun `messageTakeBike that fails should still remove the item from the queue`() {
        eventScheduler.addToEventQueue(BOOKING_ID, LEG_ID, OPERATOR_ID)
        every {
            sharedMobilityRouterClient.bookingsIdNotificationsPost160(
                maasId = OPERATOR_ID,
                id = BOOKING_ID,
                addressedTo = ENTUR,
                notification = any(),
            )
        } throws RuntimeException()

        eventScheduler.messageTakeBike()

        verify {
            sharedMobilityRouterClient.bookingsIdNotificationsPost160(
                maasId = OPERATOR_ID,
                id = BOOKING_ID,
                addressedTo = ENTUR,
                notification = any(),
            )
        }
        getQueue("startMessageQueue") shouldHaveSize 0
    }

    @Test
    fun `setInUse should call legsIdEventsPost160 to start trip`() {
        val tripStartQueue = getQueue("tripStartQueue")
        tripStartQueue.add(Triple(BOOKING_ID, LEG_ID, OPERATOR_ID))

        eventScheduler.setInUse()

        verify {
            sharedMobilityRouterClient.legsIdEventsPost160(
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
        val tripStartQueue = getQueue("tripStartQueue")
        tripStartQueue.add(Triple(BOOKING_ID, LEG_ID, OPERATOR_ID))
        val slot = slot<LegEvent>()
        every {
            sharedMobilityRouterClient.legsIdEventsPost160(
                id = LEG_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                legEvent = capture(slot),
            )
        } throws RuntimeException()

        eventScheduler.setInUse()

        verify {
            sharedMobilityRouterClient.legsIdEventsPost160(
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
    fun `setFinished should call legsIdEventsPost160 to end trip`() {
        val tripEndQueue = getQueue("tripEndQueue")
        tripEndQueue.add(Triple(BOOKING_ID, LEG_ID, OPERATOR_ID))

        eventScheduler.setFinished()

        verify {
            sharedMobilityRouterClient.legsIdEventsPost160(
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
        val tripEndQueue = getQueue("tripEndQueue")
        tripEndQueue.add(Triple(BOOKING_ID, LEG_ID, OPERATOR_ID))
        val slot = slot<LegEvent>()
        every {
            sharedMobilityRouterClient.legsIdEventsPost160(
                id = LEG_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                legEvent = capture(slot),
            )
        } throws RuntimeException()

        eventScheduler.setFinished()

        verify {
            sharedMobilityRouterClient.legsIdEventsPost160(
                id = LEG_ID,
                maasId = OPERATOR_ID,
                addressedTo = ENTUR,
                legEvent = any(),
            )
        }
        slot.captured.event shouldBe LegEvent.Event.FINISH
        tripEndQueue shouldHaveSize 0
    }

    private fun getQueue(name: String): ConcurrentLinkedQueue<Any> {
        val field = EventScheduler160::class.java.getDeclaredField(name)
        field.isAccessible = true
        @Suppress("UNCHECKED_CAST")
        return field.get(eventScheduler) as ConcurrentLinkedQueue<Any>
    }

    companion object {
        const val BOOKING_ID = "bookingId"
        const val LEG_ID = "legId"
        const val OPERATOR_ID = "operatorId"
        const val ENTUR = "Entur"
    }
}
