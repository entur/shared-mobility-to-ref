package no.entur.shared.mobility.to.ref.dto

/**
 * They are there for filtering purposes in the journal entry endpoint.
 * Values: aLL,dAMAGE,lOSS,sTOLEN,eXTRAUSAGE,rEFUND,fINE,oTHERASSETUSED,cREDIT,vOUCHER,dEPOSIT,oTHER,fARE
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
