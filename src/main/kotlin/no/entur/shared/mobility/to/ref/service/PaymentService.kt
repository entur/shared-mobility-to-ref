package no.entur.shared.mobility.to.ref.service

import no.entur.shared.mobility.to.ref.dto.ExtraCosts
import no.entur.shared.mobility.to.ref.dto.JournalCategory
import no.entur.shared.mobility.to.ref.dto.JournalEntry
import no.entur.shared.mobility.to.ref.dto.JournalState
import org.springframework.stereotype.Service
import java.time.OffsetDateTime

@Service
class PaymentService {
    fun paymentIdClaimExtraCostsPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
        extraCosts: ExtraCosts?,
    ): JournalEntry {
        throw NotImplementedError()
    }

    fun paymentJournalEntryGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        from: OffsetDateTime?,
        to: OffsetDateTime?,
        state: JournalState?,
        id: String?,
        category: JournalCategory?,
        offset: Int,
        limit: Int?,
    ): List<JournalEntry> {
        throw NotImplementedError()
    }
}
