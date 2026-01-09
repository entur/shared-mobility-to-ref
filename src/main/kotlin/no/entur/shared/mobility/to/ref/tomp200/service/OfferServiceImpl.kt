package no.entur.shared.mobility.to.ref.tomp200.service

import no.entur.shared.mobility.to.ref.tomp200.controller.OfferService
import no.entur.shared.mobility.to.ref.tomp200.dto.OfferCollection
import no.entur.shared.mobility.to.ref.tomp200.dto.Package
import no.entur.shared.mobility.to.ref.tomp200.dto.SearchOffersRequest
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service("OfferServiceImpl200")
class OfferServiceImpl : OfferService {
    /**
     * GET /collections/offers/items : Get offer details
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param offerId the identifier of an offer (required)
     * @return a single instance of a package (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun requestOffer(
        acceptLanguage: String,
        authorization: String,
        offerId: String,
    ): Package {
        TODO("Not yet implemented")
    }

    /**
     * POST /processes/search-offers/execution : Search for offers
     * Returns offers based on travel specification, trip pattern, location, asset, product and user preferences. In case of a shallow integration, can even be offered as an endpoint without authentication.
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param limit The optional limit parameter limits the number of items that are presented in the response document.  Only items are counted that are on the first level of the collection in the response document. Nested objects contained within the explicitly requested items shall not be counted.  Minimum &#x3D; 1. Maximum &#x3D; 10000. Default &#x3D; 100. (optional, default to 100)
     * @param offset The optional offset parameter representing the starting index of the returned collection.  Only items are counted that are on the first level of the collection in the response document. Nested objects contained within the explicitly requested items shall not be counted.  Default &#x3D; 0. (optional, default to 0)
     * @param bbox Only features that have a geometry that intersects the bounding box are selected. The bounding box is provided as four or six numbers, depending on whether the coordinate reference system includes a vertical axis (height or depth):  * Lower left corner, coordinate axis 1 * Lower left corner, coordinate axis 2 * Minimum value, coordinate axis 3 (optional) * Upper right corner, coordinate axis 1 * Upper right corner, coordinate axis 2 * Maximum value, coordinate axis 3 (optional)  If the value consists of four numbers, the coordinate reference system is WGS 84 longitude/latitude (http://www.opengis.net/def/crs/OGC/1.3/CRS84) unless a different coordinate reference system is specified in the parameter &#x60;bbox-crs&#x60;.  If the value consists of six numbers, the coordinate reference system is WGS 84 longitude/latitude/ellipsoidal height (http://www.opengis.net/def/crs/OGC/0/CRS84h) unless a different coordinate reference system is specified in the parameter &#x60;bbox-crs&#x60;.  The query parameter &#x60;bbox-crs&#x60; is specified in OGC API - Features - Part 2: Coordinate Reference Systems by Reference.  For WGS 84 longitude/latitude the values are in most cases the sequence of minimum longitude, minimum latitude, maximum longitude and maximum latitude. However, in cases where the box spans the antimeridian the first value (west-most box edge) is larger than the third value (east-most box edge).  If the vertical axis is included, the third and the sixth number are the bottom and the top of the 3-dimensional bounding box.  If a feature has multiple spatial geometry properties, it is the decision of the server whether only a single spatial geometry property is used to determine the extent or all relevant geometries. (optional)
     * @param searchOffersRequest  (optional)
     * @return a list of offers (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun searchOffers(
        acceptLanguage: String,
        authorization: String,
        limit: Int,
        offset: Int,
        bbox: List<BigDecimal>?,
        searchOffersRequest: SearchOffersRequest?,
    ): OfferCollection {
        TODO("Not yet implemented")
    }
}
