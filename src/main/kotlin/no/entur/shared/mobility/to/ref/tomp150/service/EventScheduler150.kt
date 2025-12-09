package no.entur.shared.mobility.to.ref.tomp150.service

import no.entur.shared.mobility.to.ref.client.SharedMobilityRouterClient
import no.entur.shared.mobility.to.ref.config.TransportOperator.URBAN_BIKE
import no.entur.shared.mobility.to.ref.tomp150.dto.LegEvent
import no.entur.shared.mobility.to.ref.tomp150.dto.Notification
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.concurrent.ConcurrentLinkedQueue

@Service
class EventScheduler150(
    private val sharedMobilityRouterClient: SharedMobilityRouterClient,
) {
    private val startMessageQueue: ConcurrentLinkedQueue<Triple<String, String, String>> = ConcurrentLinkedQueue()
    private val tripStartQueue: ConcurrentLinkedQueue<Triple<String, String, String>> = ConcurrentLinkedQueue()
    private val tripEndQueue: ConcurrentLinkedQueue<Triple<String, String, String>> = ConcurrentLinkedQueue()

    fun addToEventQueue(
        bookingId: String,
        legId: String,
        operatorId: String,
    ) {
        startMessageQueue.add(Triple(bookingId, legId, operatorId))
    }

    @Scheduled(initialDelay = 10_000, fixedDelay = 1 * SECONDS)
    fun messageTakeBike() {
        startMessageQueue.forEach {
            runCatching {
                sharedMobilityRouterClient.bookingsIdNotificationsPost150(
                    id = it.first,
                    maasId = it.third,
                    addressedTo = "Entur",
                    notification =
                        Notification(
                            legId = it.second,
                            type = Notification.Type.MESSAGE_TO_END_USER,
                            comment = "You can now take the bike.",
                        ),
                )
            }
            startMessageQueue.remove(it)
            tripStartQueue.add(it)
        }
    }

    @Scheduled(initialDelay = 10_000, fixedDelay = 20 * SECONDS)
    fun setInUse() {
        tripStartQueue.forEach {
            postLeg(it, LegEvent.Event.SET_IN_USE)
            tripStartQueue.remove(it)
            if (it.third != URBAN_BIKE) {
                tripEndQueue.add(it)
            }
        }
    }

    @Scheduled(initialDelay = 10_000, fixedDelay = 300 * SECONDS)
    fun setFinished() {
        tripEndQueue.forEach {
            postLeg(it, LegEvent.Event.FINISH)
            tripEndQueue.remove(it)
        }
    }

    private fun postLeg(
        triple: Triple<String, String, String>,
        event: LegEvent.Event,
    ) {
        runCatching {
            sharedMobilityRouterClient.legsIdEventsPost150(
                id = triple.second,
                maasId = triple.third,
                addressedTo = "Entur",
                legEvent = LegEvent(OffsetDateTime.now(), event),
            )
        }
    }

    companion object {
        const val SECONDS = 1000L
    }
}
