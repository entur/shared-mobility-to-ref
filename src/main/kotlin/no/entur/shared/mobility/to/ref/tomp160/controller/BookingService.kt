package no.entur.shared.mobility.to.ref.tomp160.controller

import no.entur.shared.mobility.to.ref.tomp160.dto.Booking
import no.entur.shared.mobility.to.ref.tomp160.dto.BookingOperation
import no.entur.shared.mobility.to.ref.tomp160.dto.BookingRequest
import no.entur.shared.mobility.to.ref.tomp160.dto.Error

interface BookingService {

    /**
     * POST /bookings/{id}/events
     * This endpoint **must** be used to alter the state of a booking:&lt;br&gt; &#x60;CANCEL&#x60; - Cancels a pending or confirmed booking.&lt;br&gt; &#x60;EXTEND_EXPIRY_TIME&#x60; - the MP request to extend the expiry time of the booking. Only available when the Process Identifier &#39;ALLOW_EXTEND_BOOKING_EXPIRY_TIME&#39; is used. Whenever the extension is not granted, 410 should be returned.&lt;br&gt; &#x60;COMMIT&#x60; - Turns the booking in a confirmed state, after all legs are in state pending. If the booking is in state COMMITTED, CANCELLED or EXPIRED, a commit will result a 403. &lt;BR&gt; &#x60;DENY&#x60; - Used for the &#39;postponed-commit&#39; scenario. Whenever a TO cannot give guarantees directly to fulfil a booking, it can return a &#39;COMMIT&#39;, but the state of the booking object should be &#39;POSTPONED-COMMIT&#39;. In the conditions returned in the planning phase is stated until when this phase can be. After this time it will become expired. Otherwise, it can be committed when the leg is confirmed or denied (using this event).
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param id Leg identifier (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param bookingOperation  (optional)
     * @return The modified booking (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     *         or The requested resources does not exist or the requester is not authorized to see it or know it exists. (status code 404)
     *         or The requested resource is no longer available. This is permanent. (status code 410)
     * @see Booking#bookingsIdEventsPost
     */
    fun bookingsIdEventsPost(acceptLanguage: kotlin.String, api: kotlin.String, apiVersion: kotlin.String, maasId: kotlin.String, id: kotlin.String, addressedTo: kotlin.String?, bookingOperation: BookingOperation?): Booking

    /**
     * GET /bookings/{id}
     * Returns the booking. See (3.5.2) in the process flow - booking. In the &#39;meta&#39;-field the digital tickes can be returned (see (3.3) in the process flow - booking)
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param id Booking identifier (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @return The booking was found (status code 200)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The requested resources does not exist or the requester is not authorized to see it or know it exists. (status code 404)
     *         or The requested resource is no longer available. This is permanent. (status code 410)
     * @see Booking#bookingsIdGet
     */
    fun bookingsIdGet(acceptLanguage: kotlin.String, api: kotlin.String, apiVersion: kotlin.String, maasId: kotlin.String, id: kotlin.String, addressedTo: kotlin.String?): Booking

    /**
     * POST /bookings
     * Creates a new &#x60;Booking&#x60; for the TO in **Pending** state. The ID of the posted booking should be the ID provided in the previous step (planning). &lt;p&gt;The Booking may be modified in the response, e.g. location being adjusted for a more suitable pick-up location. In addition, the service may contain a **meta** attribute for arbitrary TO metadata that the TO needs later, and **token** attribute depicting how long the current state is valid. &lt;p&gt; see (3.2) in the process flow - booking. &lt;p&gt;The MP can implement this endpoint when it allows direct booking by TOs. The specific TO can book an asset from themselves to get it registrated and handled (financially) by the MP.
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param bookingRequest One of available booking options, returned by /plannings, with an ID. (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @return A new booking was succesfully created, status pending (status code 201)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     *         or The requested resources does not exist or the requester is not authorized to see it or know it exists. (status code 404)
     *         or The request will not be fulfilled. The request itself is legal, but the content conflicts with the server and might be stale. The user might try again after looking up the current state of the resource. (status code 409)
     *         or The requested resource is no longer available. This is permanent. (status code 410)
     *         or Preconditions are not met in order to access the requested resource. This might happen e.g. if a booking is made but the user has been blocked by the TO. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 428)
     * @see Booking#bookingsPost
     */
    fun bookingsPost(acceptLanguage: kotlin.String, api: kotlin.String, apiVersion: kotlin.String, maasId: kotlin.String, bookingRequest: BookingRequest, addressedTo: kotlin.String?): Booking
}
