package no.entur.shared.mobility.to.ref.config

object TransportOperator {
    const val ALTAIR_SCOOTERS = "YAL:Operator:Altair"
    const val KENWAY_SCOOTERS = "YKE:Operator:Kenway"
    const val BASIM_BIKE = "YBA:Operator:Basim"
    const val EVIE_SCOOTERS_NO_DEPOSIT = "YEV:Operator:Evie"
    const val EZIO_SCOOTERS_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE = "YEZ:Operator:Ezio"
    const val COLUMBI_BIKE = "YCO:Operator:columbi"
    const val URBAN_BIKE = "YUR:Operator:urban"
    const val ALL_IMPLEMENTING_OPERATOR = "ALL:Operator:all_implementing_operator"
}

val operators =
    setOf(
        TransportOperator.ALTAIR_SCOOTERS,
        TransportOperator.KENWAY_SCOOTERS,
        TransportOperator.BASIM_BIKE,
        TransportOperator.EVIE_SCOOTERS_NO_DEPOSIT,
        TransportOperator.EZIO_SCOOTERS_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE,
        TransportOperator.COLUMBI_BIKE,
        TransportOperator.URBAN_BIKE,
        TransportOperator.ALL_IMPLEMENTING_OPERATOR,
    )

val bikeOperators =
    setOf(
        TransportOperator.BASIM_BIKE,
        TransportOperator.URBAN_BIKE,
        TransportOperator.COLUMBI_BIKE,
    )
val scooterOperators =
    setOf(
        TransportOperator.ALTAIR_SCOOTERS,
        TransportOperator.KENWAY_SCOOTERS,
        TransportOperator.EVIE_SCOOTERS_NO_DEPOSIT,
        TransportOperator.EZIO_SCOOTERS_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE,
    )
