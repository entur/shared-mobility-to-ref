package no.entur.shared.mobility.to.ref.controller

import no.entur.shared.mobility.to.ref.dto.Asset
import no.entur.shared.mobility.to.ref.dto.ConfirmationRequest
import no.entur.shared.mobility.to.ref.dto.Leg
import no.entur.shared.mobility.to.ref.dto.LegEvent
import no.entur.shared.mobility.to.ref.dto.LegProgress

interface TripExecutionService {
    /**
     * DELETE /legs/{id}/ancillaries/{category}/{number}
     * an ancillary (or amount) is removed to the leg.
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param id Leg identifier (required)
     * @param category ancillary category (required)
     * @param number ancillary number (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @return operation successful (status code 200)
     *         or Request was successful, no content to return. (status code 204)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     *         or The requested resources does not exist or the requester is not authorized to see it or know it exists. (status code 404)
     * @see TripExecution#legsIdAncillariesCategoryNumberDelete
     */
    fun legsIdAncillariesCategoryNumberDelete(
        acceptLanguage: kotlin.String,
        api: kotlin.String,
        apiVersion: kotlin.String,
        maasId: kotlin.String,
        id: kotlin.String,
        category: kotlin.String,
        number: kotlin.String,
        addressedTo: kotlin.String?,
    ): Leg

    /**
     * POST /legs/{id}/ancillaries/{category}/{number}
     * a new ancillary is added to the leg.
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param id Leg identifier (required)
     * @param category ancillary category (required)
     * @param number ancillary number (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @return operation successful (status code 200)
     *         or Request was successful, no content to return. (status code 204)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     *         or The requested resources does not exist or the requester is not authorized to see it or know it exists. (status code 404)
     * @see TripExecution#legsIdAncillariesCategoryNumberPost
     */
    fun legsIdAncillariesCategoryNumberPost(
        acceptLanguage: kotlin.String,
        api: kotlin.String,
        apiVersion: kotlin.String,
        maasId: kotlin.String,
        id: kotlin.String,
        category: kotlin.String,
        number: kotlin.String,
        addressedTo: kotlin.String?,
    ): Leg

    /**
     * GET /legs/{id}/available-assets
     * Returns a list of available assets for the given leg. These assets can be used to POST to /legs/{id}/asset if no specific asset is assigned by the TO. If picking an asset is not allowed for this booking, or one already has been, 403 should be returned. If the booking is unknown, 404 should be returned. See (4.7) in the process flow. - trip execution
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param id Leg identifier (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param offset start of the selection (optional, default to 0)
     * @param limit count of the selection (optional)
     * @return Available assets for the leg. If no suitable assets are found an empty array is to be returned. (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     *         or The requested resources does not exist or the requester is not authorized to see it or know it exists. (status code 404)
     * @see TripExecution#legsIdAvailableAssetsGet
     */
    fun legsIdAvailableAssetsGet(
        acceptLanguage: kotlin.String,
        api: kotlin.String,
        apiVersion: kotlin.String,
        maasId: kotlin.String,
        id: kotlin.String,
        addressedTo: kotlin.String?,
        offset: kotlin.Int,
        limit: kotlin.Int?,
    ): List<Asset>

    /**
     * POST /legs/{id}/confirmation
     * The TO can request confirmation for certain actions from the MP.
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param id Leg identifier (required)
     * @param confirmationRequest  (optional)
     * @return operation successful (status code 200)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The requested resources does not exist or the requester is not authorized to see it or know it exists. (status code 404)
     * @see TripExecution#legsIdConfirmationPost
     */
    fun legsIdConfirmationPost(
        acceptLanguage: kotlin.String,
        api: kotlin.String,
        apiVersion: kotlin.String,
        id: kotlin.String,
        confirmationRequest: ConfirmationRequest?,
    ): kotlin.Boolean

    /**
     * POST /legs/{id}/events
     * This endpoint must be used to alter the state of a leg.&lt;br&gt; Operations:&lt;br&gt; &#x60;PREPARE&#x60; the TO can send a message telling the MP that he is preparing the booked leg [To be implemented by the MP] (see (7.2) in the process flow - trip execution),&lt;br&gt; &#x60;ASSIGN_ASSET&#x60; can assign an asset to a leg. Can be to assign an asset in case there is still an asset type assigned [Optionally implementable by the MP]. See (4.7) in the process flow - trip execution&lt;br&gt; &#x60;SET_IN_USE&#x60; will activate the leg or resume the leg [TO and MP] (see (4.6) in process flow),&lt;br&gt; &#x60;TIME_EXTEND&#x60; will be used to request an extension in time; the end user wants to use the asset longer, the &#x60;time&#x60; field contains the new end time,&lt;br&gt; &#x60;TIME_POSTPONE&#x60; will be used to request a delay in the departure time, the end user wants to depart later, the &#x60;time&#x60; field contains the new departure time,&lt;br&gt; &#x60;PAUSE&#x60; will pause the leg [TO and MP] (see (4.6) in process flow),&lt;br&gt; &#x60;OPEN_TRUNK&#x60; request the TO to open up the trunk (of the scooter), e.g. to store the helmet&lt;br&gt; &#x60;START_FINISHING&#x60; will start the end-of-leg [Optionally implementable by TO and MP],&lt;br&gt; &#x60;FINISH&#x60; will end this leg (see (4.6) in process flow) [TO and MP]
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param id Leg identifier (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param legEvent  (optional)
     * @return operation successful (status code 200)
     *         or Request was successful, no content to return. (status code 204)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     *         or The requested resources does not exist or the requester is not authorized to see it or know it exists. (status code 404)
     *         or In case of temporary malfunctioning, this response can be send (e.g. bluetooth lock jammed). See also https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Retry-After (status code 503)
     * @see TripExecution#legsIdEventsPost
     */
    fun legsIdEventsPost(
        acceptLanguage: kotlin.String,
        api: kotlin.String,
        apiVersion: kotlin.String,
        maasId: kotlin.String,
        id: kotlin.String,
        addressedTo: kotlin.String?,
        legEvent: LegEvent?,
    ): Leg

    /**
     * GET /legs/{id}
     * Retrieves the latest summary of the leg, being the execution of a portion of a journey travelled using one asset (vehicle). Every leg belongs to one booking, every booking has at least one leg. Where the booking describes the agreement between user/MP and TO, the leg describes the journey as it occured. See (4.3) in the flow chart - trip execution
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param id Leg identifier (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @return operation successful (status code 200)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     *         or The requested resources does not exist or the requester is not authorized to see it or know it exists. (status code 404)
     * @see TripExecution#legsIdGet
     */
    fun legsIdGet(
        acceptLanguage: kotlin.String,
        api: kotlin.String,
        apiVersion: kotlin.String,
        maasId: kotlin.String,
        id: kotlin.String,
        addressedTo: kotlin.String?,
    ): Leg

    /**
     * GET /legs/{id}/progress
     * Monitors the current location of the asset and duration &amp; distance of the leg (see (4.7) in process flow)
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param id Leg identifier (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param locationOnly Specifies if only the location should be returned (optional, default to false)
     * @return operation successful (status code 200)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The requested resources does not exist or the requester is not authorized to see it or know it exists. (status code 404)
     * @see TripExecution#legsIdProgressGet
     */
    fun legsIdProgressGet(
        acceptLanguage: kotlin.String,
        api: kotlin.String,
        apiVersion: kotlin.String,
        maasId: kotlin.String,
        id: kotlin.String,
        addressedTo: kotlin.String?,
        locationOnly: kotlin.Boolean,
    ): LegProgress

    /**
     * POST /legs/{id}/progress
     * Monitors the current location of the asset and duration &amp; distance of the leg
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param id Leg identifier (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param legProgress  (optional)
     * @return Request was successful, no content to return. (status code 204)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     *         or The requested resources does not exist or the requester is not authorized to see it or know it exists. (status code 404)
     * @see TripExecution#legsIdProgressPost
     */
    fun legsIdProgressPost(
        acceptLanguage: kotlin.String,
        api: kotlin.String,
        apiVersion: kotlin.String,
        maasId: kotlin.String,
        id: kotlin.String,
        addressedTo: kotlin.String?,
        legProgress: LegProgress?,
    ): Unit

    /**
     * PUT /legs/{id}
     * Updates the leg with new information. Only used for updates about execution to the MP. To request changes as the MP, the booking should be updated and the TO can accept the change and update the leg in turn.
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param id Leg identifier (required)
     * @param leg changed leg (e.g. with different duration or destination) (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @return Request was successful, no content to return. (status code 204)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     *         or The requested resources does not exist or the requester is not authorized to see it or know it exists. (status code 404)
     * @see TripExecution#legsIdPut
     */
    fun legsIdPut(
        acceptLanguage: kotlin.String,
        api: kotlin.String,
        apiVersion: kotlin.String,
        maasId: kotlin.String,
        id: kotlin.String,
        leg: Leg,
        addressedTo: kotlin.String?,
    ): Unit
}
