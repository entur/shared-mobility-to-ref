package no.entur.shared.mobility.to.ref.tomp150.service

import no.entur.shared.mobility.to.ref.config.TransportOperator.ALL_IMPLEMENTING_OPERATOR
import no.entur.shared.mobility.to.ref.config.TransportOperator.ALTAIR_SCOOTERS
import no.entur.shared.mobility.to.ref.config.TransportOperator.COLUMBI_BIKE
import no.entur.shared.mobility.to.ref.config.TransportOperator.EVIE_SCOOTERS_NO_DEPOSIT
import no.entur.shared.mobility.to.ref.config.TransportOperator.EZIO_SCOOTERS_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE
import no.entur.shared.mobility.to.ref.config.TransportOperator.KENWAY_SCOOTERS
import no.entur.shared.mobility.to.ref.config.bikeOperators
import no.entur.shared.mobility.to.ref.tomp150.data.leg
import no.entur.shared.mobility.to.ref.tomp150.data.legWithHighDepositAmount
import no.entur.shared.mobility.to.ref.tomp150.data.legWithoutDeposit
import no.entur.shared.mobility.to.ref.tomp150.dto.Leg
import no.entur.shared.mobility.to.ref.tomp150.dto.LegEvent
import no.entur.shared.mobility.to.ref.tomp150.dto.LegState
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import kotlin.random.Random

@Service("TripExecutionServiceTomp150")
class TripExecutionService(
    private val eventScheduler150: EventScheduler150,
) {
    fun legsIdEventsPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
        legEvent: LegEvent?,
    ): Leg {
        val leg =
            when (addressedTo) {
                EVIE_SCOOTERS_NO_DEPOSIT -> legWithoutDeposit
                EZIO_SCOOTERS_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE -> legWithHighDepositAmount
                ALTAIR_SCOOTERS, KENWAY_SCOOTERS, in bikeOperators, ALL_IMPLEMENTING_OPERATOR -> leg
                else -> throw NotImplementedError()
            }

        // Trigger randomized demo workflow when START_FINISHING is received for COLUMBI_BIKE
        if (addressedTo == COLUMBI_BIKE && legEvent?.event == LegEvent.Event.START_FINISHING) {
            if (Random.nextBoolean()) {
                eventScheduler150.startFullStationFlow(id)
            } else {
                eventScheduler150.startParkingWarningFlow(id)
            }
        }

        if (addressedTo == COLUMBI_BIKE && legEvent?.event == LegEvent.Event.FINISH) {
            throw IllegalStateException("Illegal event: COLUMBI_BIKE should not send FINISH. Leg $id.")
        }

        return leg.copy(
            id = id,
            state =
                when (legEvent!!.event) {
                    LegEvent.Event.PREPARE -> LegState.PREPARING
                    LegEvent.Event.ASSIGN_ASSET -> LegState.NOT_STARTED
                    LegEvent.Event.SET_IN_USE -> LegState.IN_USE
                    LegEvent.Event.PAUSE -> LegState.PAUSED
                    LegEvent.Event.OPEN_TRUNK -> LegState.IN_USE
                    LegEvent.Event.START_FINISHING -> LegState.FINISHING
                    LegEvent.Event.FINISH -> LegState.FINISHED
                    LegEvent.Event.TIME_EXTEND -> LegState.IN_USE
                    LegEvent.Event.TIME_POSTPONE -> LegState.NOT_STARTED
                    LegEvent.Event.CANCEL -> LegState.CANCELLED
                },
            actualArrivalTime =
                when (legEvent.event) {
                    LegEvent.Event.START_FINISHING -> OffsetDateTime.now().plusMinutes(12)
                    LegEvent.Event.FINISH -> OffsetDateTime.now().plusMinutes(12)
                    else -> null
                },
            asset = legEvent.asset,
        )
    }

    fun legsIdGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
    ): Leg {
        val leg: Leg =
            when (addressedTo) {
                EVIE_SCOOTERS_NO_DEPOSIT -> legWithoutDeposit
                EZIO_SCOOTERS_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE -> legWithHighDepositAmount
                ALTAIR_SCOOTERS, KENWAY_SCOOTERS, in bikeOperators, ALL_IMPLEMENTING_OPERATOR -> leg
                else -> throw NotImplementedError()
            }
        return leg.copy(id = id)
    }
}
