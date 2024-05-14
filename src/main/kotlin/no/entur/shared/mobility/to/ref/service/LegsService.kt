package no.entur.shared.mobility.to.ref.service

import no.entur.shared.mobility.to.ref.data.asset
import no.entur.shared.mobility.to.ref.data.leg
import no.entur.shared.mobility.to.ref.data.legProgress
import no.entur.shared.mobility.to.ref.dto.Asset
import no.entur.shared.mobility.to.ref.dto.ConfirmationRequest
import no.entur.shared.mobility.to.ref.dto.Leg
import no.entur.shared.mobility.to.ref.dto.LegEvent
import no.entur.shared.mobility.to.ref.dto.LegProgress
import no.entur.shared.mobility.to.ref.dto.LegState
import no.entur.shared.mobility.to.ref.service.TransportOperator.ALL_IMPLEMENTING_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.BIKE_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR
import org.springframework.stereotype.Service

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
    ): Leg {
        return when (addressedTo) {
            SCOOTER_OPERATOR -> throw NotImplementedError()
            BIKE_OPERATOR -> throw NotImplementedError()
            ALL_IMPLEMENTING_OPERATOR -> leg
            else -> throw NotImplementedError()
        }
    }

    fun legsIdAncillariesCategoryNumberPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        category: String,
        number: String,
        addressedTo: String?,
    ): Leg {
        return when (addressedTo) {
            SCOOTER_OPERATOR -> throw NotImplementedError()
            BIKE_OPERATOR -> throw NotImplementedError()
            ALL_IMPLEMENTING_OPERATOR -> leg
            else -> throw NotImplementedError()
        }
    }

    fun legsIdAvailableAssetsGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
        offset: Int,
        limit: Int?,
    ): List<Asset> {
        return when (addressedTo) {
            SCOOTER_OPERATOR -> throw NotImplementedError()
            BIKE_OPERATOR -> throw NotImplementedError()
            ALL_IMPLEMENTING_OPERATOR -> listOf(asset)
            else -> throw NotImplementedError()
        }
    }

    fun legsIdConfirmationPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        id: String,
        confirmationRequest: ConfirmationRequest?,
    ): Boolean {
        return true
    }

    fun legsIdEventsPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
        legEvent: LegEvent,
    ): Leg {
        val leg: Leg =
            leg.copy(
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
                asset = legEvent.asset,
            )

        return when (addressedTo) {
            SCOOTER_OPERATOR -> leg
            BIKE_OPERATOR -> leg
            ALL_IMPLEMENTING_OPERATOR -> leg
            else -> throw NotImplementedError()
        }
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
                SCOOTER_OPERATOR -> throw NotImplementedError()
                BIKE_OPERATOR -> throw NotImplementedError()
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
    ): LegProgress {
        return when (addressedTo) {
            SCOOTER_OPERATOR -> throw NotImplementedError()
            BIKE_OPERATOR -> throw NotImplementedError()
            ALL_IMPLEMENTING_OPERATOR -> legProgress
            else -> throw NotImplementedError()
        }
    }

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
