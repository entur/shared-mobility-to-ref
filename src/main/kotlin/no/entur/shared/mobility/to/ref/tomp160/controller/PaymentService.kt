package no.entur.shared.mobility.to.ref.tomp160.controller

import no.entur.shared.mobility.to.ref.tomp160.dto.Error
import no.entur.shared.mobility.to.ref.tomp160.dto.ExtraCosts
import no.entur.shared.mobility.to.ref.tomp160.dto.JournalCategory
import no.entur.shared.mobility.to.ref.tomp160.dto.JournalEntry
import no.entur.shared.mobility.to.ref.tomp160.dto.JournalState

interface PaymentService {

    /**
     * POST /payment/{id}/claim-extra-costs
     * extra costs that the TO has to charge to the MP or vice versa.
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param id Booking identifier (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param extraCosts  (optional)
     * @return journal entry received, will be processed (state &#x3D; INVOICED) (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     * @see Payment#paymentIdClaimExtraCostsPost
     */
    fun paymentIdClaimExtraCostsPost(acceptLanguage: kotlin.String, api: kotlin.String, apiVersion: kotlin.String, maasId: kotlin.String, id: kotlin.String, addressedTo: kotlin.String?, extraCosts: ExtraCosts?): JournalEntry

    /**
     * GET /payment/journal-entry
     * Returns all the journal entries that should be paid per leg
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param from start of the selection (optional)
     * @param to end of the selection (optional)
     * @param state  (optional)
     * @param id  (optional)
     * @param category type of booking line (e.g. fare, addition costs, fines, ...) (optional)
     * @param offset start of the selection (optional, default to 0)
     * @param limit count of the selection (optional)
     * @return journal entries (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     * @see Payment#paymentJournalEntryGet
     */
    fun paymentJournalEntryGet(acceptLanguage: kotlin.String, api: kotlin.String, apiVersion: kotlin.String, maasId: kotlin.String, addressedTo: kotlin.String?, from: java.time.OffsetDateTime?, to: java.time.OffsetDateTime?, state: JournalState?, id: kotlin.String?, category: JournalCategory?, offset: kotlin.Int, limit: kotlin.Int?): List<JournalEntry>
}
