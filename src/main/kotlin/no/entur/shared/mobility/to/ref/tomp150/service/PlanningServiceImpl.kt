package no.entur.shared.mobility.to.ref.tomp150.service

import no.entur.shared.mobility.to.ref.config.TransportOperator.ALL_IMPLEMENTING_OPERATOR
import no.entur.shared.mobility.to.ref.config.TransportOperator.COLUMBI_BIKE
import no.entur.shared.mobility.to.ref.config.TransportOperator.SCOOTER_OPERATOR
import no.entur.shared.mobility.to.ref.config.TransportOperator.SCOOTER_OPERATOR_2
import no.entur.shared.mobility.to.ref.config.TransportOperator.SCOOTER_OPERATOR_3
import no.entur.shared.mobility.to.ref.config.TransportOperator.SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE
import no.entur.shared.mobility.to.ref.config.TransportOperator.SCOOTER_OPERATOR_NO_DEPOSIT
import no.entur.shared.mobility.to.ref.config.TransportOperator.URBAN_BIKE
import no.entur.shared.mobility.to.ref.tomp150.controller.PlanningService
import no.entur.shared.mobility.to.ref.tomp150.data.asset
import no.entur.shared.mobility.to.ref.tomp150.data.booking
import no.entur.shared.mobility.to.ref.tomp150.data.bookingHigherDepositAmountThanTotalAmount
import no.entur.shared.mobility.to.ref.tomp150.data.bookingWithoutDeposit
import no.entur.shared.mobility.to.ref.tomp150.data.finalFare
import no.entur.shared.mobility.to.ref.tomp150.data.leg
import no.entur.shared.mobility.to.ref.tomp150.data.planning
import no.entur.shared.mobility.to.ref.tomp150.dto.AssetProperties
import no.entur.shared.mobility.to.ref.tomp150.dto.Booking
import no.entur.shared.mobility.to.ref.tomp150.dto.LegState
import no.entur.shared.mobility.to.ref.tomp150.dto.OneStopBookingRequest
import no.entur.shared.mobility.to.ref.tomp150.dto.Planning
import no.entur.shared.mobility.to.ref.tomp150.dto.PlanningRequest
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.UUID

@Service("PlanningServiceTomp150")
class PlanningServiceImpl(
    private val eventScheduler150: EventScheduler150,
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
        // If extraInfo.vehicleCode is present this should be used to find the corresponding assetId / vehicleId / bike_id
        val extraInfo = planningRequest?.from?.extraInfo

        val booking =
            when (addressedTo) {
                SCOOTER_OPERATOR_NO_DEPOSIT -> bookingWithoutDeposit
                SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE -> bookingHigherDepositAmountThanTotalAmount
                SCOOTER_OPERATOR, SCOOTER_OPERATOR_2, SCOOTER_OPERATOR_3, COLUMBI_BIKE, URBAN_BIKE, ALL_IMPLEMENTING_OPERATOR -> booking
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
                                ) ?: no.entur.shared.mobility.to.ref.tomp150.dto.Asset(
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
                SCOOTER_OPERATOR_NO_DEPOSIT -> bookingWithoutDeposit
                SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE -> bookingHigherDepositAmountThanTotalAmount
                SCOOTER_OPERATOR -> booking.copy(pricing = finalFare(25.00F))
                SCOOTER_OPERATOR_2 -> booking.copy(pricing = finalFare(5.00F))
                SCOOTER_OPERATOR_3 -> booking.copy(pricing = finalFare(15.00F))
                COLUMBI_BIKE, URBAN_BIKE -> {
                    val notStartedLeg = leg.copy(state = LegState.NOT_STARTED)
                    eventScheduler150.addToEventQueue(booking.id!!, notStartedLeg.id!!, addressedTo)
                    booking.copy(legs = listOf(notStartedLeg))
                }
                ALL_IMPLEMENTING_OPERATOR -> booking
                else -> throw NotImplementedError()
            }
        return booking.copy(
            customer = oneStopBookingRequest!!.customer,
            from = oneStopBookingRequest.from,
            legs =
                booking.legs?.map { leg ->
                    leg.copy(
                        from = oneStopBookingRequest.from,
                        asset = asset.copy(id = oneStopBookingRequest.useAssets?.first() ?: UUID.randomUUID().toString()),
                    )
                },
        )
    }
}
