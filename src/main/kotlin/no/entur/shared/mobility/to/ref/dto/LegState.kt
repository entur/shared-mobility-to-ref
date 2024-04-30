package no.entur.shared.mobility.to.ref.dto

/**
 * status of a leg
 */
enum class LegState {
    NOT_STARTED,
    PREPARING,
    IN_USE,
    PAUSED,
    FINISHING,
    FINISHED,
    ISSUE_REPORTED,
    CANCELLED,
}
