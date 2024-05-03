package no.entur.shared.mobility.to.ref.service

import no.entur.shared.mobility.to.ref.data.journalEntry
import no.entur.shared.mobility.to.ref.dto.ExtraCosts
import no.entur.shared.mobility.to.ref.dto.JournalCategory
import no.entur.shared.mobility.to.ref.dto.JournalEntry
import no.entur.shared.mobility.to.ref.dto.JournalState
import no.entur.shared.mobility.to.ref.service.TransportOperator.ALL_IMPLEMENTING_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.BIKE_OPERATOR
import no.entur.shared.mobility.to.ref.service.TransportOperator.SCOOTER_OPERATOR
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
        return when (addressedTo) {
            SCOOTER_OPERATOR -> throw NotImplementedError()
            BIKE_OPERATOR -> throw NotImplementedError()
            ALL_IMPLEMENTING_OPERATOR -> journalEntry
            else -> throw NotImplementedError()
        }
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
        return when (addressedTo) {
            SCOOTER_OPERATOR -> listOf(journalEntry)
            BIKE_OPERATOR -> listOf(journalEntry)
            ALL_IMPLEMENTING_OPERATOR -> listOf(journalEntry)
            else -> throw NotImplementedError()
        }
    }
}
