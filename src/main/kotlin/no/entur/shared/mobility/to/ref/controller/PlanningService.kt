package no.entur.shared.mobility.to.ref.controller

import no.entur.shared.mobility.to.ref.dto.Booking
import no.entur.shared.mobility.to.ref.dto.OneStopBookingRequest
import no.entur.shared.mobility.to.ref.dto.Planning
import no.entur.shared.mobility.to.ref.dto.PlanningRequest

interface PlanningService {
    /**
     * POST /bookings/one-stop
     * Returns a booking for the given travel plan. This endpoint executes POST /planning/offers and POST /booking in one blow, the information provided should lead to only one possible offer, that is booked directly. The returned booking is still in &#x60;PENDING&#x60; state, you have to commit it. Unless &#39;AUTO_COMMIT&#39; process identifier is applied. In that case the booking is in state &#39;CONFIRMED&#39;.
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param oneStopBookingRequest  (optional)
     * @return A single booking, or when it&#39;s not possible, return a 406. (status code 201)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     *         or this booking cannot be done. (status code 406)
     * @see Planning#bookingsOneStopPost
     */
    fun bookingsOneStopPost(
        acceptLanguage: kotlin.String,
        api: kotlin.String,
        apiVersion: kotlin.String,
        maasId: kotlin.String,
        addressedTo: kotlin.String?,
        oneStopBookingRequest: OneStopBookingRequest?,
    ): Booking

    /**
     * POST /planning/inquiries
     * Returns informative options for the given travel plan. &lt;p&gt;Start time can be defined, but is optional. If startTime is not provided, but required by the third party API, a default value of \&quot;Date.now()\&quot; is used. [from MaaS-API /listing]. During the routing phase this service can be used to check availability without any state changes. &lt;p&gt;see (2.1) in the process flow - planning.
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param planningRequest  (optional)
     * @return Available transport methods matching the given query parameters. If no transport methods are available, an empty array is returned. (status code 201)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     * @see Planning#planningInquiriesPost
     */
    fun planningInquiriesPost(
        acceptLanguage: kotlin.String,
        api: kotlin.String,
        apiVersion: kotlin.String,
        maasId: kotlin.String,
        addressedTo: kotlin.String?,
        planningRequest: PlanningRequest?,
    ): Planning

    /**
     * POST /planning/offers
     * Returns bookable offers for the given travel plan. &lt;p&gt;Start time can be defined, but is optional. If startTime is not provided, but required by the third party API, a default value of \&quot;Date.now()\&quot; is used. [from MaaS-API /listing]. During the routing phase this service can be used to check availability without any state changes. &lt;p&gt;see (2.1) in the process flow - planning
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param planningRequest  (optional)
     * @return Available transport methods matching the given query parameters. If no transport methods are available, an empty array is returned. (status code 201)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     * @see Planning#planningOffersPost
     */
    fun planningOffersPost(
        acceptLanguage: kotlin.String,
        api: kotlin.String,
        apiVersion: kotlin.String,
        maasId: kotlin.String,
        addressedTo: kotlin.String?,
        planningRequest: PlanningRequest?,
    ): Planning

    /**
     * POST /plannings
     * Returns plannings for the given travel plan. &lt;p&gt;Start time can be defined, but is optional. If startTime is not provided, but required by the third party API, a default value of \&quot;Date.now()\&quot; is used. [from MaaS-API /listing]. During the routing phase this service can be used to check availability without any state changes. &lt;p&gt;In the final check, just before presenting the alternatives to the user, a call should be made using &#x60;booking-intent&#x60;, requesting the TO to provide booking IDs to reference to during communication with the MP. &lt;p&gt;see (2.1) in the process flow - planning Replaced by /plannings/inquires (booking-intent false) and /planning/offers (booking-intent true)
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param bookingIntent Specifies whether IDs should be returned for the leg options that can be referred to when booking (optional, default to false)
     * @param planningRequest  (optional)
     * @return Available transport methods matching the given query parameters. If no transport methods are available, an empty array is returned. (status code 201)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     * @deprecated
     * @see Planning#planningsPost
     */
    fun planningsPost(
        acceptLanguage: kotlin.String,
        api: kotlin.String,
        apiVersion: kotlin.String,
        maasId: kotlin.String,
        addressedTo: kotlin.String?,
        bookingIntent: kotlin.Boolean,
        planningRequest: PlanningRequest?,
    ): Planning
}
