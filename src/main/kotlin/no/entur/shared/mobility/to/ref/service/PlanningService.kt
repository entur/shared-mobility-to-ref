package no.entur.shared.mobility.to.ref.service

import no.entur.shared.mobility.to.ref.data.asset
import no.entur.shared.mobility.to.ref.data.booking
import no.entur.shared.mobility.to.ref.data.bookingHigherDepositAmountThanTotalAmount
import no.entur.shared.mobility.to.ref.data.bookingWithoutDeposit
import no.entur.shared.mobility.to.ref.data.planning
import no.entur.shared.mobility.to.ref.dto.Asset
import no.entur.shared.mobility.to.ref.dto.AssetProperties
import no.entur.shared.mobility.to.ref.dto.Planning
import no.entur.shared.mobility.to.ref.dto.PlanningRequest
import no.entur.shared.mobility.to.ref.service.TransportOperator.ALL_IMPLEMENTING_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.BIKE_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR_NO_DEPOSIT
import org.springframework.stereotype.Service
import java.time.OffsetDateTime

@Service
class PlanningService {
    fun planningInquiriesPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        planningRequest: PlanningRequest?,
    ): Planning {
        return when (addressedTo) {
            SCOOTER_OPERATOR -> throw NotImplementedError()
            BIKE_OPERATOR -> throw NotImplementedError()
            ALL_IMPLEMENTING_OPERATOR -> planning
            else -> throw NotImplementedError()
        }
    }

    fun planningOffersPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        planningRequest: PlanningRequest?,
    ): Planning {
        // If vehicleCode is present this should be used to find the corresponding assetId / vehicleId / bike_id
        val vehicleCode = planningRequest?.from?.extraInfo?.get("vehicleCode") as String

        val booking =
            when (addressedTo) {
                SCOOTER_OPERATOR_NO_DEPOSIT -> bookingWithoutDeposit
                SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE -> bookingHigherDepositAmountThanTotalAmount
                SCOOTER_OPERATOR -> booking
                BIKE_OPERATOR -> booking
                ALL_IMPLEMENTING_OPERATOR -> booking
                else -> throw NotImplementedError()
            }

        val bookingWithNewData =
            booking.copy(
                legs =
                    booking.legs?.map { leg ->
                        leg.copy(
                            asset =
                                leg.asset?.copy(
                                    id = "1234",
                                    stateOfCharge = 50,
                                    overriddenProperties =
                                        AssetProperties(
                                            meta = mapOf(Pair("vehicleCode", vehicleCode)),
                                        ),
                                ) ?: Asset(
                                    id = "1234",
                                    stateOfCharge = 50,
                                    overriddenProperties =
                                        AssetProperties(
                                            meta = mapOf(Pair("vehicleCode", vehicleCode)),
                                        ),
                                ),
                        )
                    },
            )

        return Planning(
            validUntil = OffsetDateTime.now().plusMinutes(5),
            options = listOf(bookingWithNewData),
        )
    }
}
