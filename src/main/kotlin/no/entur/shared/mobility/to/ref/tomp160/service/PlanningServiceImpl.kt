package no.entur.shared.mobility.to.ref.tomp160.service

import no.entur.shared.mobility.to.ref.config.TransportOperator.ALL_IMPLEMENTING_OPERATOR
import no.entur.shared.mobility.to.ref.config.TransportOperator.ALTAIR_SCOOTERS
import no.entur.shared.mobility.to.ref.config.TransportOperator.EVIE_SCOOTERS_NO_DEPOSIT
import no.entur.shared.mobility.to.ref.config.TransportOperator.EZIO_SCOOTERS_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE
import no.entur.shared.mobility.to.ref.config.TransportOperator.KENWAY_SCOOTERS
import no.entur.shared.mobility.to.ref.config.bikeOperators
import no.entur.shared.mobility.to.ref.tomp160.controller.PlanningService
import no.entur.shared.mobility.to.ref.tomp160.data.asset
import no.entur.shared.mobility.to.ref.tomp160.data.booking
import no.entur.shared.mobility.to.ref.tomp160.data.bookingHigherDepositAmountThanTotalAmount
import no.entur.shared.mobility.to.ref.tomp160.data.bookingWithoutDeposit
import no.entur.shared.mobility.to.ref.tomp160.data.finalFare
import no.entur.shared.mobility.to.ref.tomp160.data.leg
import no.entur.shared.mobility.to.ref.tomp160.data.planning
import no.entur.shared.mobility.to.ref.tomp160.dto.AssetProperties
import no.entur.shared.mobility.to.ref.tomp160.dto.Booking
import no.entur.shared.mobility.to.ref.tomp160.dto.LegState
import no.entur.shared.mobility.to.ref.tomp160.dto.OneStopBookingRequest
import no.entur.shared.mobility.to.ref.tomp160.dto.Planning
import no.entur.shared.mobility.to.ref.tomp160.dto.PlanningRequest
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.UUID

@Service("PlanningServiceTomp160")
class PlanningServiceImpl(
    private val eventScheduler160: EventScheduler160,
) : PlanningService {
    override fun planningInquiriesPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        planningRequest: PlanningRequest?,
    ): Planning =
        when (addressedTo) {
            ALL_IMPLEMENTING_OPERATOR -> planning
            else -> throw NotImplementedError()
        }

    override fun planningOffersPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        planningRequest: PlanningRequest?,
    ): Planning {
        // If extraInfo.vehicleCode is present this should be used to find the corresponding assetId/vehicleId/bike_id
        val extraInfo = planningRequest?.from?.extraInfo

        val booking =
            when (addressedTo) {
                EVIE_SCOOTERS_NO_DEPOSIT -> bookingWithoutDeposit
                EZIO_SCOOTERS_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE -> bookingHigherDepositAmountThanTotalAmount
                ALTAIR_SCOOTERS,
                KENWAY_SCOOTERS,
                in bikeOperators,
                ALL_IMPLEMENTING_OPERATOR,
                -> booking

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
                                            meta = extraInfo,
                                        ),
                                ) ?: no.entur.shared.mobility.to.ref.tomp160.dto.Asset(
                                    id = "1234",
                                    stateOfCharge = 50,
                                    overriddenProperties =
                                        AssetProperties(
                                            meta = extraInfo,
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

    override fun planningsPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        bookingIntent: Boolean,
        planningRequest: PlanningRequest?,
    ): Planning =
        when (addressedTo) {
            ALL_IMPLEMENTING_OPERATOR -> planning
            else -> throw NotImplementedError()
        }

    override fun bookingsOneStopPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        oneStopBookingRequest: OneStopBookingRequest?,
    ): Booking {
        val booking =
            when (addressedTo) {
                EVIE_SCOOTERS_NO_DEPOSIT -> bookingWithoutDeposit
                EZIO_SCOOTERS_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE -> bookingHigherDepositAmountThanTotalAmount
                ALTAIR_SCOOTERS -> booking.copy(pricing = finalFare(25.00F))
                KENWAY_SCOOTERS -> booking.copy(pricing = finalFare(5.00F))
                in bikeOperators -> {
                    val notStartedLeg = leg.copy(state = LegState.NOT_STARTED)
                    val bikeBooking = booking.copy(legs = listOf(notStartedLeg))
                    eventScheduler160.addTakeBikeMessage(bikeBooking.id!!, notStartedLeg.id!!, addressedTo!!)
                    bikeBooking
                }

                ALL_IMPLEMENTING_OPERATOR -> booking
                else -> throw NotImplementedError()
            }
        return booking.copy(
            customer = oneStopBookingRequest!!.customer,
            legs =
                booking.legs?.map { leg ->
                    leg.copy(
                        asset =
                            asset.copy(id = oneStopBookingRequest.useAssets?.first() ?: UUID.randomUUID().toString()),
                    )
                },
        )
    }
}
