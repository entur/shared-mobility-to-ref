package no.entur.shared.mobility.to.ref.service

import no.entur.shared.mobility.to.ref.tomp150.controller.PaymentApiService
import no.entur.shared.mobility.to.ref.tomp150.dto.ExtraCosts
import no.entur.shared.mobility.to.ref.tomp150.dto.JournalCategory
import no.entur.shared.mobility.to.ref.tomp150.dto.JournalEntry
import no.entur.shared.mobility.to.ref.tomp150.dto.JournalState
import org.springframework.stereotype.Service
import java.time.OffsetDateTime

@Service
class PaymentService : PaymentApiService {
    override fun paymentIdClaimExtraCostsPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?,
        extraCosts: ExtraCosts?,
    ): JournalEntry = throw NotImplementedError()

    override fun paymentJournalEntryGet(
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
    ): List<JournalEntry> = throw NotImplementedError()
}
