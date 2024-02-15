package no.entur.shared.mobility.to.ref.dto

/**
 * The life-cycle state of the booking (from NEW to FINISHED)
 * Values: nEW,pENDING,rEJECTED,rELEASED,eXPIRED,cONDITIONALCONFIRMED,cONFIRMED,cANCELLED,sTARTED,fINISHED
 */
enum class BookingState {
    NEW,
    PENDING,
    REJECTED,
    RELEASED,
    EXPIRED,
    CONDITIONAL_CONFIRMED,
    CONFIRMED,
    CANCELLED,
    STARTED,
    FINISHED,
}
