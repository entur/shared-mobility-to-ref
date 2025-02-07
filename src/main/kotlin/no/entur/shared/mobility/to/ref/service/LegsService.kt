package no.entur.shared.mobility.to.ref.service

import no.entur.shared.mobility.to.ref.data.leg
import no.entur.shared.mobility.to.ref.data.legWithHighDepositAmount
import no.entur.shared.mobility.to.ref.data.legWithoutDeposit
import no.entur.shared.mobility.to.ref.dto.Asset
import no.entur.shared.mobility.to.ref.dto.ConfirmationRequest
import no.entur.shared.mobility.to.ref.dto.Leg
import no.entur.shared.mobility.to.ref.dto.LegEvent
import no.entur.shared.mobility.to.ref.dto.LegProgress
import no.entur.shared.mobility.to.ref.dto.LegState
import no.entur.shared.mobility.to.ref.service.TransportOperator.ALL_IMPLEMENTING_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.BIKE_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR_2
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR_3
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR_NO_DEPOSIT
import org.springframework.stereotype.Service
import java.time.OffsetDateTime

@Service
class LegsService {
    fun legsIdAncillariesCategoryNumberDelete(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        category: String,
        number: String,
        addressedTo: String?,
    ): Leg = throw NotImplementedError()

    fun legsIdAncillariesCategoryNumberPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        category: String,
        number: String,
        addressedTo: String?,
    ): Leg = throw NotImplementedError()

    fun legsIdAvailableAssetsGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
        offset: Int,
        limit: Int?,
    ): List<Asset> = throw NotImplementedError()

    fun legsIdConfirmationPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        id: String,
        confirmationRequest: ConfirmationRequest?,
    ): Boolean = true

    fun legsIdEventsPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
        legEvent: LegEvent,
    ): Leg {
        val leg =
            when (addressedTo) {
                SCOOTER_OPERATOR_NO_DEPOSIT -> legWithoutDeposit
                SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE -> legWithHighDepositAmount
                SCOOTER_OPERATOR, SCOOTER_OPERATOR_2, SCOOTER_OPERATOR_3 -> leg
                BIKE_OPERATOR -> leg
                ALL_IMPLEMENTING_OPERATOR -> leg
                else -> throw NotImplementedError()
            }
        return leg.copy(
            id = id,
            state =
                when (legEvent.event) {
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
                SCOOTER_OPERATOR_NO_DEPOSIT -> legWithoutDeposit
                SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE -> legWithHighDepositAmount
                SCOOTER_OPERATOR, SCOOTER_OPERATOR_2, SCOOTER_OPERATOR_3 -> leg
                BIKE_OPERATOR -> leg
                ALL_IMPLEMENTING_OPERATOR -> leg
                else -> throw NotImplementedError()
            }
        return leg.copy(id = id)
    }

    fun legsIdProgressGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
        locationOnly: Boolean,
    ): LegProgress = throw NotImplementedError()

    fun legsIdProgressPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
        legProgress: LegProgress?,
    ) {
        if (addressedTo != ALL_IMPLEMENTING_OPERATOR) {
            throw NotImplementedError()
        }
    }

    fun legsIdPut(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        leg: Leg,
        addressedTo: String?,
    ) {
        if (addressedTo != ALL_IMPLEMENTING_OPERATOR) {
            throw NotImplementedError()
        }
    }
}
