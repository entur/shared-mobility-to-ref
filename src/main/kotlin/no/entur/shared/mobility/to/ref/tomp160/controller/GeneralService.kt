package no.entur.shared.mobility.to.ref.tomp160.controller

import no.entur.shared.mobility.to.ref.tomp160.dto.Error
import no.entur.shared.mobility.to.ref.tomp160.dto.Notification

interface GeneralService {

    /**
     * GET /bookings/{id}/notifications
     * retrieves all notifications concerning events related to this booking.
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param id Booking identifier (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @return The bookings matching the query (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     *         or The requested resources does not exist or the requester is not authorized to see it or know it exists. (status code 404)
     *         or The requested resource is no longer available. This is permanent. (status code 410)
     * @see General#bookingsIdNotificationsGet
     */
    fun bookingsIdNotificationsGet(acceptLanguage: kotlin.String, api: kotlin.String, apiVersion: kotlin.String, maasId: kotlin.String, id: kotlin.String, addressedTo: kotlin.String?): List<Notification>

    /**
     * POST /bookings/{id}/notifications
     * notification between MaaS provider and Transport operator in case of user no-show or if specific asset is not available or some other event occurs not covered by other API calls.
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param id Booking identifier (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param notification  (optional)
     * @return Request was successful, no content to return. (status code 204)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     *         or The requested resources does not exist or the requester is not authorized to see it or know it exists. (status code 404)
     *         or The requested resource is no longer available. This is permanent. (status code 410)
     * @see General#bookingsIdNotificationsPost
     */
    fun bookingsIdNotificationsPost(acceptLanguage: kotlin.String, api: kotlin.String, apiVersion: kotlin.String, maasId: kotlin.String, id: kotlin.String, addressedTo: kotlin.String?, notification: Notification?): Unit
}
