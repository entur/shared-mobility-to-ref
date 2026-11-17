package no.entur.shared.mobility.to.ref.config

object TransportOperator {
    const val BASIM_BIKE = "YBA:Operator:Basim"
    const val EVIE_SCOOTERS_NO_DEPOSIT = "YEV:Operator:Evie"
    const val EZIO_SCOOTERS_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE = "YEZ:Operator:Ezio"
}

val operators =
    setOf(
        TransportOperator.BASIM_BIKE,
        TransportOperator.EVIE_SCOOTERS_NO_DEPOSIT,
        TransportOperator.EZIO_SCOOTERS_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE,
    )

val bikeOperators =
    setOf(
        TransportOperator.BASIM_BIKE,
    )
val scooterOperators =
    setOf(
        TransportOperator.EVIE_SCOOTERS_NO_DEPOSIT,
        TransportOperator.EZIO_SCOOTERS_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE,
    )
