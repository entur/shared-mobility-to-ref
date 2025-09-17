package no.entur.shared.mobility.to.ref.config

object TransportOperator {
    const val SCOOTER_OPERATOR = "YAL:Operator:Altair"
    const val SCOOTER_OPERATOR_2 = "YKE:Operator:Kenway"
    const val SCOOTER_OPERATOR_3 = "YBA:Operator:Basim"
    const val SCOOTER_OPERATOR_NO_DEPOSIT = "YEV:Operator:Evie"
    const val SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE = "YEZ:Operator:Ezio"
    const val BIKE_OPERATOR = "BOP:Operator:bike_operator"
    const val ALL_IMPLEMENTING_OPERATOR = "ALL:Operator:all_implementing_operator"
}

val operators =
    listOf(
        TransportOperator.SCOOTER_OPERATOR,
        TransportOperator.SCOOTER_OPERATOR_2,
        TransportOperator.SCOOTER_OPERATOR_3,
        TransportOperator.SCOOTER_OPERATOR_NO_DEPOSIT,
        TransportOperator.SCOOTER_OPERATOR_DEPOSIT_HIGHER_THAN_TOTAL_PRICE,
        TransportOperator.BIKE_OPERATOR,
        TransportOperator.ALL_IMPLEMENTING_OPERATOR,
    )
