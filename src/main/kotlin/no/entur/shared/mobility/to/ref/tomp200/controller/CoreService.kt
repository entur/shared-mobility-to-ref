package no.entur.shared.mobility.to.ref.tomp200.controller

import no.entur.shared.mobility.to.ref.tomp200.dto.GetDataSourcesDefaultResponse
import no.entur.shared.mobility.to.ref.tomp200.dto.Link
import no.entur.shared.mobility.to.ref.tomp200.dto.Package

interface CoreService {

    /**
     * GET /collections/datasources/items : Retrieves all (external) datasources, used in requests and responses
     * Retrieves all datasources
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @return a list of datasources, the &#39;rel&#39; contains the prefix to use in data (to create a URN), like &#39;gps:&#39; for coordinates (&#39;gps&#39; is always allowed). when referring to an external datasource, the &#39;href&#39; should be used to retrieve the related data. (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see Core#getDataSources
     */
    fun getDataSources(acceptLanguage: kotlin.String, authorization: kotlin.String): List<Link>

    /**
     * GET /collections/packages/items : Get package details
     * Retrieves package details
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param packageId the identifier of a package (required)
     * @return a single instance of a package (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see Core#getPackage
     */
    fun getPackage(acceptLanguage: kotlin.String, authorization: kotlin.String, packageId: kotlin.String): Package
}
