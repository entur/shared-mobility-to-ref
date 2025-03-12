package no.entur.shared.mobility.to.ref.tomp160.controller

import no.entur.shared.mobility.to.ref.tomp160.dto.AssetType
import no.entur.shared.mobility.to.ref.tomp160.dto.EndpointImplementation
import no.entur.shared.mobility.to.ref.tomp160.dto.Error
import no.entur.shared.mobility.to.ref.tomp160.dto.StationInformation
import no.entur.shared.mobility.to.ref.tomp160.dto.SystemAlert
import no.entur.shared.mobility.to.ref.tomp160.dto.SystemCalendar
import no.entur.shared.mobility.to.ref.tomp160.dto.SystemHours
import no.entur.shared.mobility.to.ref.tomp160.dto.SystemInformation
import no.entur.shared.mobility.to.ref.tomp160.dto.SystemPricingPlan
import no.entur.shared.mobility.to.ref.tomp160.dto.SystemRegion

interface OperatorInformationService {

    /**
     * GET /operator/alerts : informs customers about changes to the system outside of normal operations
     * This feed is intended to inform customers about changes to the system that do not fall within the normal system operations. For example, system closures due to weather would be listed here, but a system that only operated for part of the year would have that schedule listed in the system-calendar.json feed. This file is an array of alert objects defined as below. Obsolete alerts should be removed so the client application can safely present to the end user everything present in the feed. The consumer could use the start/end information to determine if this is a past, ongoing or future alert and adjust the presentation accordingly. [from GBFS]
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param offset start of the selection (optional, default to 0)
     * @param limit count of the selection (optional)
     * @param regionId optional id of the region to use in the filter (/operator/regions) (optional)
     * @param stationId optional id of the station to use in the filter (/operator/stations) (optional)
     * @return returns currently active system alerts (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     * @see OperatorInformation#operatorAlertsGet
     */
    fun operatorAlertsGet(acceptLanguage: kotlin.String, api: kotlin.String, apiVersion: kotlin.String, maasId: kotlin.String, addressedTo: kotlin.String?, offset: kotlin.Int, limit: kotlin.Int?, regionId: kotlin.String?, stationId: kotlin.String?): List<SystemAlert>

    /**
     * GET /operator/available-assets
     * Returns a list of available assets.
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param offset start of the selection (optional, default to 0)
     * @param limit count of the selection (optional)
     * @param regionId optional id of the region to use in the filter (/operator/regions) (optional)
     * @param stationId optional id of the station to use in the filter (/operator/stations) (optional)
     * @param boundingbox an optional filtering bounding box, using the Nomatim definition: south Latitude, north Latitude, west Longitude, east Longitude (optional)
     * @return Available assets or asset-types. In case assets are replied, the realtime location is also available. (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     *         or The requested resources does not exist or the requester is not authorized to see it or know it exists. (status code 404)
     * @see OperatorInformation#operatorAvailableAssetsGet
     */
    fun operatorAvailableAssetsGet(acceptLanguage: kotlin.String, api: kotlin.String, apiVersion: kotlin.String, maasId: kotlin.String, addressedTo: kotlin.String?, offset: kotlin.Int, limit: kotlin.Int?, regionId: kotlin.String?, stationId: kotlin.String?, boundingbox: kotlin.collections.List<java.math.BigDecimal>?): List<AssetType>

    /**
     * GET /operator/information : describes the system
     * Describes the system including System operator, System location, year implemented, URLs, contact info, time zone. [from GBFS]
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @return successful operation (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     * @see OperatorInformation#operatorInformationGet
     */
    fun operatorInformationGet(acceptLanguage: kotlin.String, api: kotlin.String, apiVersion: kotlin.String, maasId: kotlin.String, addressedTo: kotlin.String?): SystemInformation

    /**
     * GET /operator/meta : describes the running implementations
     * all versions that are implemented on this url, are described in the result of this endpoint. In contains all versions and per version the endpoints, their status and the supported scenarios.
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @return successful operation (status code 200)
     * @see OperatorInformation#operatorMetaGet
     */
    fun operatorMetaGet(acceptLanguage: kotlin.String, maasId: kotlin.String, addressedTo: kotlin.String?): List<EndpointImplementation>

    /**
     * GET /operator/operating-calendar : describes the operating calendar for a system. An array of year objects defined as follows (if start/end year are omitted, then assume the start and end months do not change from year to year). [from GFBS]
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param regionId optional id of the region to use in the filter (/operator/regions) (optional)
     * @param stationId optional id of the station to use in the filter (/operator/stations) (optional)
     * @return successful operation (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     * @see OperatorInformation#operatorOperatingCalendarGet
     */
    fun operatorOperatingCalendarGet(acceptLanguage: kotlin.String, api: kotlin.String, apiVersion: kotlin.String, maasId: kotlin.String, addressedTo: kotlin.String?, regionId: kotlin.String?, stationId: kotlin.String?): List<SystemCalendar>

    /**
     * GET /operator/operating-hours : describes the system hours of operation
     * Describes the hours of operation of all available systems of the transport operator [from GBFS]
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param regionId optional id of the region to use in the filter (/operator/regions) (optional)
     * @param stationId optional id of the station to use in the filter (/operator/stations) (optional)
     * @return successful operation (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     * @see OperatorInformation#operatorOperatingHoursGet
     */
    fun operatorOperatingHoursGet(acceptLanguage: kotlin.String, api: kotlin.String, apiVersion: kotlin.String, maasId: kotlin.String, addressedTo: kotlin.String?, regionId: kotlin.String?, stationId: kotlin.String?): List<SystemHours>

    /**
     * GET /operator/ping : Describes the status of the Transport Operator - whether the APIs are running or not
     * This is a healthcheck endpoint to see if the TO is up and running perfectly.
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @return successful operation (status code 200)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or not every endpoint functions properly (status code 500)
     * @see OperatorInformation#operatorPingGet
     */
    fun operatorPingGet(acceptLanguage: kotlin.String): Unit

    /**
     * GET /operator/pricing-plans : gives pricing information
     * Describes pricing of systems or assets [from GBFS]
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param regionId optional id of the region to use in the filter (/operator/regions) (optional)
     * @param stationId optional id of the station to use in the filter (/operator/stations) (optional)
     * @return returns standard pricing plans for an operator (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     *         or The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client&#39;s identity is known to the server. (status code 403)
     * @see OperatorInformation#operatorPricingPlansGet
     */
    fun operatorPricingPlansGet(acceptLanguage: kotlin.String, api: kotlin.String, apiVersion: kotlin.String, maasId: kotlin.String, addressedTo: kotlin.String?, regionId: kotlin.String?, stationId: kotlin.String?): List<SystemPricingPlan>

    /**
     * GET /operator/regions : describes regions for a system that is broken up by geographic or political region. It is defined as a separate feed to allow for additional region metadata (such as shape definitions). [from GBFS]
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param offset start of the selection (optional, default to 0)
     * @param limit count of the selection (optional)
     * @return successful operation (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     * @see OperatorInformation#operatorRegionsGet
     */
    fun operatorRegionsGet(acceptLanguage: kotlin.String, api: kotlin.String, apiVersion: kotlin.String, maasId: kotlin.String, addressedTo: kotlin.String?, offset: kotlin.Int, limit: kotlin.Int?): List<SystemRegion>

    /**
     * GET /operator/stations : describes all available stations
     * All stations contained in this list are considered public (ie, can be shown on a map for public use). If there are private stations (such as Capital Bikeshare&#39;s White House station) these should not be exposed here and their status should not be included [from GBFS]. This endpoint can be filtered using the regionId OR with the combination lon, lat and range.
     *
     * @param acceptLanguage A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information (required)
     * @param api API description, can be TOMP or maybe other (specific/derived) API definitions (required)
     * @param apiVersion Version of the API. (required)
     * @param maasId The ID of the sending maas operator (required)
     * @param addressedTo The ID of the maas operator that has to receive this message (optional)
     * @param offset start of the selection (optional, default to 0)
     * @param limit count of the selection (optional)
     * @param regionId optional id of the region to use in the filter (/operator/regions) (optional)
     * @param lon the longitude of the search location (WGS84) (optional)
     * @param lat the latitude of the search location (WGS84) (optional)
     * @param radius the range in meters from the search location to look for stations (optional)
     * @return successful operation (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 400)
     *         or Although the HTTP standard specifies \&quot;unauthorized\&quot;, semantically this response means \&quot;unauthenticated\&quot;. That is, the client must authenticate itself to get the requested response. (status code 401)
     * @see OperatorInformation#operatorStationsGet
     */
    fun operatorStationsGet(acceptLanguage: kotlin.String, api: kotlin.String, apiVersion: kotlin.String, maasId: kotlin.String, addressedTo: kotlin.String?, offset: kotlin.Int, limit: kotlin.Int?, regionId: kotlin.String?, lon: kotlin.Float?, lat: kotlin.Float?, radius: kotlin.Float?): List<StationInformation>
}
