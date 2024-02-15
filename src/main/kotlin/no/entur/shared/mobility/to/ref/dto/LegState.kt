package no.entur.shared.mobility.to.ref.dto

/**
 * status of a leg
 * Values: nOTSTARTED,pREPARING,iNUSE,pAUSED,fINISHING,fINISHED,iSSUEREPORTED,cANCELLED
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
