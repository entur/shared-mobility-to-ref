package no.entur.shared.mobility.to.ref.tomp150.controller

import no.entur.shared.mobility.to.ref.tomp150.dto.Booking
import no.entur.shared.mobility.to.ref.tomp150.dto.BookingState

interface BookingOptionalService {

    /**
     * GET /bookings
     * Optional - Returns bookings that has been created earlier, selected on state.
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param state  (optional)
     * @param minTime start time of the time window of all bookings (partially) overlapping with this time window (optional)
     * @param maxTime end time of the time window of all bookings (partially) overlapping with this time window (optional)
     * @param minPrice minimum search price, for the whole trip (optional)
     * @param maxPrice maximum search price, for the whole trip (optional)
     * @param containsAssetType filter the bookings on the ID of the asset type. Should return all complete bookings containing a leg executed with this asset type. (optional)
     * @return The bookings matching the query (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     * @see BookingOptional#bookingsGet
     */
    fun bookingsGet(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        addressedTo: String?,
        state: BookingState?,
        minTime: java.time.OffsetDateTime?,
        maxTime: java.time.OffsetDateTime?,
        minPrice: Float?,
        maxPrice: Float?,
        containsAssetType: String?
    ): List<Booking>

    /**
     * PUT /bookings/{id}
     * Optional - This endpoint should be used to adjust the parameters of the booking. Changes not acceptable to the TO should return 400. If a booking is started and can no longer be adjusted the TO should return 403. The state of the booking should **never** be adjusted using this method. Use /bookings/{id}/events for that. See also (7.2) in the flow diagram - booking.
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param id Booking identifier (required)
     * @param booking changed booking (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @return The booking was modified (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     *         or The requested resources does not exist or the requester is not authorized to see it or know it exists. (status code 404)
     *         or The request will not be fulfilled. The request itself is legal, but the content conflicts with the server and might be stale. The user might try again after looking up the current state of the resource. (status code 409)
     *         or The requested resource is no longer available. This is permanent. (status code 410)
     * @see BookingOptional#bookingsIdPut
     */
    fun bookingsIdPut(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        booking: Booking,
        addressedTo: String?
    ): Booking

    /**
     * DELETE /bookings/{id}/subscription
     * Optional - subscribe to a specific booking (&#x3D;leg &amp; (type of) asset). This is an optional endpoint
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param id Booking identifier (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @return Request was successful, no content to return. (status code 204)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     *         or The requested resources does not exist or the requester is not authorized to see it or know it exists. (status code 404)
     *         or The requested resource is no longer available. This is permanent. (status code 410)
     *         or Unexpected error (status code 200)
     * @see BookingOptional#bookingsIdSubscriptionDelete
     */
    fun bookingsIdSubscriptionDelete(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?
    ): Unit

    /**
     * POST /bookings/{id}/subscription
     * Optional - subscribe to a specific booking (&#x3D;leg &amp; (type of) asset). This is an optional endpoint. This endpoint facilitates notifications in all the phases. (see (7.1) in the flow chart - execution)
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param id Booking identifier (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @return Request was successful, no content to return. (status code 204)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     *         or The requested resources does not exist or the requester is not authorized to see it or know it exists. (status code 404)
     *         or The requested resource is no longer available. This is permanent. (status code 410)
     * @see BookingOptional#bookingsIdSubscriptionPost
     */
    fun bookingsIdSubscriptionPost(
        acceptLanguage: String,
        api: String,
        apiVersion: String,
        maasId: String,
        id: String,
        addressedTo: String?
    ): Unit
}
