package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import jakarta.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param id https://en.wikipedia.org/wiki/Universally_unique_identifier see also https://www.ietf.org/rfc/rfc4122.txt (ae76f51c-a1a6-46af-b9ab-8233564adcae)
 * @param name default string, full names etc (length 0-200)
 * @param organisation default string, full names etc (length 0-200)
 * @param type _ALTERNATIVE_JOURNEY_ - A TRIP REPAIR GUARANTEE that if a designated SERVICE JOURNEY is not available then alternative SERVICE JOURNEY will be provided. -| (EASEMENT_REDRESS, PRODUCT EXCHANGE REDRESS) _HOME_LEG_ - A TRIP REPAIR GUARANTEE that if a the passenger is unable to reach their destination by public transport because of a delay in services, a taxi to their destination will be provided. -| (TAXI HOME REDRESS) _RETURN_TO_ORIGIN_ - A TRIP REPAIR GUARANTEE that if a designated SERVICE JOURNEY cannot be completed, then the passenger will be returned to their origin stop. -| (RETURN TO ORIGIN REDRESS) _ON_TIME_TRAVEL_ - A TRAVEL QUALITY GUARANTEE that compensation will be offered if repeated travel within a certain TIME INTERVAL fails to meet certain performance targets as to arrival times. -| (ALL REDRESSES, needs TEMPORAL PARAMETER) _TRIP_ON_TIME_ - A TRAVEL QUALITY GUARANTEE that compensation will be offered if a trip fails to meet certain performance targets as to arrival times. -| (ALL REDRESSES, needs TEMPORAL PARAMETER) _FACILITIES_AVAILABLE_ - A TRAVEL QUALITY GUARANTEE that compensation will be offered if a facility or service (e.g. WIFI, Meal, seat reservation, etc) is not available or fails to meet a specified quality. -| (ALL REDRESSES, needs SERVICE PARAMETER) _MOBILITY_ACCOMODATION_ - A TRAVEL QUALITY GUARANTEE that special accommodation will be provided in the event of severe disruption. -| (ALL REDRESSES, needs SERVICE PARAMETER) _MOBILITY_ASSISTANCE_ - A TRAVEL QUALITY GUARANTEE that mobility assistance will be provided. -| (ALL REDRESSES, needs SERVICE PARAMETER) _PASSENGER_SUPPORT_ - A TRAVEL QUALITY GUARANTEE that assistance will be provided, for example, if a disruption occurs or a that stations are staffed. (ALL REDRESSES) _DISRUPTION_INFORMATION_ - An INFORMATION QUALITY GUARANTEE that information on disruptions will be made available. (ALL REDRESSES) _REDRESS_INFORMATION_ - An INFORMATION QUALITY GUARANTEE that information on available compensation or other statutory and discretionary redress options will be made available to the passenger. (ALL REDRESSES) _BEST_FARE_INFORMATION_ - An INFORMATION QUALITY GUARANTEE that information on the best value fares will be made available (ALL REDRESSES) _GENERAL_TRAVEL_ - An arbitrary OTHER TRAVEL GUARANTEE describing some special guarantee not covered by the normal categories (ALL REDRESSES) _MEDIA_REPLACEMENT_ - An OTHER GUARANTEE that a replacement media will be provided if the original becomes unusable. _REFUND_UNUSED_ANCILLARIES_ - unused ancillaries will be refunded _REFUND_WHEN_CANCELLED_ - when cancelled before start, a refund will be scheduled
 */
data class Guarantee(

    @Schema(example = "null", description = "https://en.wikipedia.org/wiki/Universally_unique_identifier see also https://www.ietf.org/rfc/rfc4122.txt (ae76f51c-a1a6-46af-b9ab-8233564adcae)")
    @get:JsonProperty("id") val id: kotlin.String? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("name") val name: kotlin.String? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("organisation") val organisation: kotlin.String? = null,

    @Schema(example = "null", description = "_ALTERNATIVE_JOURNEY_ - A TRIP REPAIR GUARANTEE that if a designated SERVICE JOURNEY is not available then alternative SERVICE JOURNEY will be provided. -| (EASEMENT_REDRESS, PRODUCT EXCHANGE REDRESS) _HOME_LEG_ - A TRIP REPAIR GUARANTEE that if a the passenger is unable to reach their destination by public transport because of a delay in services, a taxi to their destination will be provided. -| (TAXI HOME REDRESS) _RETURN_TO_ORIGIN_ - A TRIP REPAIR GUARANTEE that if a designated SERVICE JOURNEY cannot be completed, then the passenger will be returned to their origin stop. -| (RETURN TO ORIGIN REDRESS) _ON_TIME_TRAVEL_ - A TRAVEL QUALITY GUARANTEE that compensation will be offered if repeated travel within a certain TIME INTERVAL fails to meet certain performance targets as to arrival times. -| (ALL REDRESSES, needs TEMPORAL PARAMETER) _TRIP_ON_TIME_ - A TRAVEL QUALITY GUARANTEE that compensation will be offered if a trip fails to meet certain performance targets as to arrival times. -| (ALL REDRESSES, needs TEMPORAL PARAMETER) _FACILITIES_AVAILABLE_ - A TRAVEL QUALITY GUARANTEE that compensation will be offered if a facility or service (e.g. WIFI, Meal, seat reservation, etc) is not available or fails to meet a specified quality. -| (ALL REDRESSES, needs SERVICE PARAMETER) _MOBILITY_ACCOMODATION_ - A TRAVEL QUALITY GUARANTEE that special accommodation will be provided in the event of severe disruption. -| (ALL REDRESSES, needs SERVICE PARAMETER) _MOBILITY_ASSISTANCE_ - A TRAVEL QUALITY GUARANTEE that mobility assistance will be provided. -| (ALL REDRESSES, needs SERVICE PARAMETER) _PASSENGER_SUPPORT_ - A TRAVEL QUALITY GUARANTEE that assistance will be provided, for example, if a disruption occurs or a that stations are staffed. (ALL REDRESSES) _DISRUPTION_INFORMATION_ - An INFORMATION QUALITY GUARANTEE that information on disruptions will be made available. (ALL REDRESSES) _REDRESS_INFORMATION_ - An INFORMATION QUALITY GUARANTEE that information on available compensation or other statutory and discretionary redress options will be made available to the passenger. (ALL REDRESSES) _BEST_FARE_INFORMATION_ - An INFORMATION QUALITY GUARANTEE that information on the best value fares will be made available (ALL REDRESSES) _GENERAL_TRAVEL_ - An arbitrary OTHER TRAVEL GUARANTEE describing some special guarantee not covered by the normal categories (ALL REDRESSES) _MEDIA_REPLACEMENT_ - An OTHER GUARANTEE that a replacement media will be provided if the original becomes unusable. _REFUND_UNUSED_ANCILLARIES_ - unused ancillaries will be refunded _REFUND_WHEN_CANCELLED_ - when cancelled before start, a refund will be scheduled")
    @get:JsonProperty("type") val type: Guarantee.Type? = null
) {

    /**
    * _ALTERNATIVE_JOURNEY_ - A TRIP REPAIR GUARANTEE that if a designated SERVICE JOURNEY is not available then alternative SERVICE JOURNEY will be provided. -| (EASEMENT_REDRESS, PRODUCT EXCHANGE REDRESS) _HOME_LEG_ - A TRIP REPAIR GUARANTEE that if a the passenger is unable to reach their destination by public transport because of a delay in services, a taxi to their destination will be provided. -| (TAXI HOME REDRESS) _RETURN_TO_ORIGIN_ - A TRIP REPAIR GUARANTEE that if a designated SERVICE JOURNEY cannot be completed, then the passenger will be returned to their origin stop. -| (RETURN TO ORIGIN REDRESS) _ON_TIME_TRAVEL_ - A TRAVEL QUALITY GUARANTEE that compensation will be offered if repeated travel within a certain TIME INTERVAL fails to meet certain performance targets as to arrival times. -| (ALL REDRESSES, needs TEMPORAL PARAMETER) _TRIP_ON_TIME_ - A TRAVEL QUALITY GUARANTEE that compensation will be offered if a trip fails to meet certain performance targets as to arrival times. -| (ALL REDRESSES, needs TEMPORAL PARAMETER) _FACILITIES_AVAILABLE_ - A TRAVEL QUALITY GUARANTEE that compensation will be offered if a facility or service (e.g. WIFI, Meal, seat reservation, etc) is not available or fails to meet a specified quality. -| (ALL REDRESSES, needs SERVICE PARAMETER) _MOBILITY_ACCOMODATION_ - A TRAVEL QUALITY GUARANTEE that special accommodation will be provided in the event of severe disruption. -| (ALL REDRESSES, needs SERVICE PARAMETER) _MOBILITY_ASSISTANCE_ - A TRAVEL QUALITY GUARANTEE that mobility assistance will be provided. -| (ALL REDRESSES, needs SERVICE PARAMETER) _PASSENGER_SUPPORT_ - A TRAVEL QUALITY GUARANTEE that assistance will be provided, for example, if a disruption occurs or a that stations are staffed. (ALL REDRESSES) _DISRUPTION_INFORMATION_ - An INFORMATION QUALITY GUARANTEE that information on disruptions will be made available. (ALL REDRESSES) _REDRESS_INFORMATION_ - An INFORMATION QUALITY GUARANTEE that information on available compensation or other statutory and discretionary redress options will be made available to the passenger. (ALL REDRESSES) _BEST_FARE_INFORMATION_ - An INFORMATION QUALITY GUARANTEE that information on the best value fares will be made available (ALL REDRESSES) _GENERAL_TRAVEL_ - An arbitrary OTHER TRAVEL GUARANTEE describing some special guarantee not covered by the normal categories (ALL REDRESSES) _MEDIA_REPLACEMENT_ - An OTHER GUARANTEE that a replacement media will be provided if the original becomes unusable. _REFUND_UNUSED_ANCILLARIES_ - unused ancillaries will be refunded _REFUND_WHEN_CANCELLED_ - when cancelled before start, a refund will be scheduled
    * Values: ALTERNATIVE_JOURNEY,HOME_LEG,RETURN_TO_ORIGIN,ON_TIME_TRAVEL,TRIP_ON_TIME,FACILITIES_AVAILABLE,MOBILITY_ACCOMODATION,MOBILITY_ASSISTANCE,PASSENGER_SUPPORT,DISRUPTION_INFORMATION,REDRESS_INFORMATION,BEST_FARE_INFORMATION,GENERAL_TRAVEL,MEDIA_REPLACEMENT,REFUND_UNUSED_ANCILLARIES,REFUND_WHEN_CANCELLED
    */
    enum class Type(@get:JsonValue val value: kotlin.String) {

        ALTERNATIVE_JOURNEY("ALTERNATIVE_JOURNEY"),
        HOME_LEG("HOME_LEG"),
        RETURN_TO_ORIGIN("RETURN_TO_ORIGIN"),
        ON_TIME_TRAVEL("ON_TIME_TRAVEL"),
        TRIP_ON_TIME("TRIP_ON_TIME"),
        FACILITIES_AVAILABLE("FACILITIES_AVAILABLE"),
        MOBILITY_ACCOMODATION("MOBILITY_ACCOMODATION"),
        MOBILITY_ASSISTANCE("MOBILITY_ASSISTANCE"),
        PASSENGER_SUPPORT("PASSENGER_SUPPORT"),
        DISRUPTION_INFORMATION("DISRUPTION_INFORMATION"),
        REDRESS_INFORMATION("REDRESS_INFORMATION"),
        BEST_FARE_INFORMATION("BEST_FARE_INFORMATION"),
        GENERAL_TRAVEL("GENERAL_TRAVEL"),
        MEDIA_REPLACEMENT("MEDIA_REPLACEMENT"),
        REFUND_UNUSED_ANCILLARIES("REFUND_UNUSED_ANCILLARIES"),
        REFUND_WHEN_CANCELLED("REFUND_WHEN_CANCELLED");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Type {
                return values().firstOrNull{it -> it.value == value}
                    ?: throw IllegalArgumentException("Unexpected value '$value' for enum 'Guarantee'")
            }
        }
    }

}

