package no.entur.shared.mobility.to.ref.tomp160.controller

import no.entur.shared.mobility.to.ref.tomp160.dto.SupportRequest
import no.entur.shared.mobility.to.ref.tomp160.dto.SupportStatus

interface SupportService {

    /**
     * GET /support/{id}/status
     * Gets the status report of the support request. Last status (highest order number) is the current status
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param id Booking identifier (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @return support status delivered (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     *         or The requested resources does not exist or the requester is not authorized to see it or know it exists. (status code 404)
     * @see Support#supportIdStatusGet
     */
    fun supportIdStatusGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?
    ): List<SupportStatus>

    /**
     * POST /support/
     * creates a request for support from end user via MP
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param supportRequest  (optional)
     * @return support request acknowledged (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     *         or The requested resources does not exist or the requester is not authorized to see it or know it exists. (status code 404)
     * @see Support#supportPost
     */
    fun supportPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        supportRequest: SupportRequest?
    ): SupportStatus
}
