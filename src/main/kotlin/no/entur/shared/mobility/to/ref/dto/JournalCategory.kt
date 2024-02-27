package no.entur.shared.mobility.to.ref.dto

/**
 * They are there for filtering purposes in the journal entry endpoint.
 */
enum class JournalCategory {
    ALL,
    DAMAGE,
    LOSS,
    STOLEN,
    EXTRA_USAGE,
    REFUND,
    FINE,
    OTHER_ASSET_USED,
    CREDIT,
    VOUCHER,
    DEPOSIT,
    OTHER,
    FARE,
}
