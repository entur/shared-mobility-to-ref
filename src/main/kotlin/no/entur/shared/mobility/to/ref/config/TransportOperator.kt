package no.entur.shared.mobility.to.ref.config

object TransportOperator {
    const val SCOOTER_OPERATOR = "YAL:Operator:Altair"
    const val SCOOTER_OPERATOR_2 = "YKE:Operator:Kenway"
    const val SCOOTER_OPERATOR_3 = "YBA:Operator:Basim"
    const val SCOOTER_OPERATOR_NO_DEPOSIT = "YEV:Operator:Evie"
    const val SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE = "YEZ:Operator:Ezio"
    const val COLUMBI_BIKE = "YCO:Operator:columbi"
    const val URBAN_BIKE = "YUR:Operator:urban"
    const val ALL_IMPLEMENTING_OPERATOR = "ALL:Operator:all_implementing_operator"
}

val operators =
    listOf(
        TransportOperator.SCOOTER_OPERATOR,
        TransportOperator.SCOOTER_OPERATOR_2,
        TransportOperator.SCOOTER_OPERATOR_3,
        TransportOperator.SCOOTER_OPERATOR_NO_DEPOSIT,
        TransportOperator.SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE,
        TransportOperator.COLUMBI_BIKE,
        TransportOperator.URBAN_BIKE,
        TransportOperator.ALL_IMPLEMENTING_OPERATOR,
    )
