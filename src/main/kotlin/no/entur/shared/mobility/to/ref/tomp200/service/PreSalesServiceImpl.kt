package no.entur.shared.mobility.to.ref.tomp200.service

import no.entur.shared.mobility.to.ref.tomp200.controller.PreSalesService
import no.entur.shared.mobility.to.ref.tomp200.dto.AncillaryCollection
import no.entur.shared.mobility.to.ref.tomp200.dto.AssetCollection
import no.entur.shared.mobility.to.ref.tomp200.dto.AssignAncillaryRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.AssignAssetRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.Package
import no.entur.shared.mobility.to.ref.tomp200.dto.ReleasePackageRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.RemoveOfferRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.SelectOffersRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.UpdateTravelSpecificationRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.UpdateTravellerRequestRequest
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service("PreSalesServiceImpl200")
class PreSalesServiceImpl : PreSalesService {
    /**
     * POST /processes/assign-ancillary/execution : Assign an ancillary to a package (and a leg). It could also replace another ancillary or remove one
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param assignAncillaryRequestRequest  (optional)
     * @return a single instance of a package (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun assignAncillaryRequest(
        acceptLanguage: String,
        authorization: String,
        assignAncillaryRequestRequest: AssignAncillaryRequestRequest?,
    ): Package {
        TODO("Not yet implemented")
    }

    /**
     * POST /processes/assign-asset/execution : Assign an asset to a package (and a leg). It could also replace another asset or remove one
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param assignAssetRequestRequest  (optional)
     * @return a single instance of a package (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun assignAssetRequest(
        acceptLanguage: String,
        authorization: String,
        assignAssetRequestRequest: AssignAssetRequestRequest?,
    ): Package {
        TODO("Not yet implemented")
    }

    /**
     * POST /processes/release-package/execution : Release the complete package
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param releasePackageRequestRequest  (optional)
     * @return a single instance of a package (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun releasePackageRequest(
        acceptLanguage: String,
        authorization: String,
        releasePackageRequestRequest: ReleasePackageRequestRequest?,
    ): Package {
        TODO("Not yet implemented")
    }

    /**
     * POST /processes/remove-offer/execution : Remove an offer from the package
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param removeOfferRequestRequest  (optional)
     * @return a single instance of a package (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun removeOfferRequest(
        acceptLanguage: String,
        authorization: String,
        removeOfferRequestRequest: RemoveOfferRequestRequest?,
    ): Package {
        TODO("Not yet implemented")
    }

    /**
     * GET /collections/ancillaries/items : Request available ancillaries for a leg
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param packageId the identifier of a package (required)
     * @param legId leg identifier (required)
     * @param limit The optional limit parameter limits the number of items that are presented in the response document.  Only items are counted that are on the first level of the collection in the response document. Nested objects contained within the explicitly requested items shall not be counted.  Minimum &#x3D; 1. Maximum &#x3D; 10000. Default &#x3D; 100. (optional, default to 100)
     * @param offset The optional offset parameter representing the starting index of the returned collection.  Only items are counted that are on the first level of the collection in the response document. Nested objects contained within the explicitly requested items shall not be counted.  Default &#x3D; 0. (optional, default to 0)
     * @param bbox Only features that have a geometry that intersects the bounding box are selected. The bounding box is provided as four or six numbers, depending on whether the coordinate reference system includes a vertical axis (height or depth):  * Lower left corner, coordinate axis 1 * Lower left corner, coordinate axis 2 * Minimum value, coordinate axis 3 (optional) * Upper right corner, coordinate axis 1 * Upper right corner, coordinate axis 2 * Maximum value, coordinate axis 3 (optional)  If the value consists of four numbers, the coordinate reference system is WGS 84 longitude/latitude (http://www.opengis.net/def/crs/OGC/1.3/CRS84) unless a different coordinate reference system is specified in the parameter &#x60;bbox-crs&#x60;.  If the value consists of six numbers, the coordinate reference system is WGS 84 longitude/latitude/ellipsoidal height (http://www.opengis.net/def/crs/OGC/0/CRS84h) unless a different coordinate reference system is specified in the parameter &#x60;bbox-crs&#x60;.  The query parameter &#x60;bbox-crs&#x60; is specified in OGC API - Features - Part 2: Coordinate Reference Systems by Reference.  For WGS 84 longitude/latitude the values are in most cases the sequence of minimum longitude, minimum latitude, maximum longitude and maximum latitude. However, in cases where the box spans the antimeridian the first value (west-most box edge) is larger than the third value (east-most box edge).  If the vertical axis is included, the third and the sixth number are the bottom and the top of the 3-dimensional bounding box.  If a feature has multiple spatial geometry properties, it is the decision of the server whether only a single spatial geometry property is used to determine the extent or all relevant geometries. (optional)
     * @return a list of ancillaries (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun requestAncillaries(
        acceptLanguage: String,
        authorization: String,
        packageId: String,
        legId: String,
        limit: Int,
        offset: Int,
        bbox: List<BigDecimal>?,
    ): AncillaryCollection {
        TODO("Not yet implemented")
    }

    /**
     * GET /collections/assets/items : Request available assets for a leg
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param packageId the identifier of a package (required)
     * @param legId leg identifier (required)
     * @param limit The optional limit parameter limits the number of items that are presented in the response document.  Only items are counted that are on the first level of the collection in the response document. Nested objects contained within the explicitly requested items shall not be counted.  Minimum &#x3D; 1. Maximum &#x3D; 10000. Default &#x3D; 100. (optional, default to 100)
     * @param offset The optional offset parameter representing the starting index of the returned collection.  Only items are counted that are on the first level of the collection in the response document. Nested objects contained within the explicitly requested items shall not be counted.  Default &#x3D; 0. (optional, default to 0)
     * @param bbox Only features that have a geometry that intersects the bounding box are selected. The bounding box is provided as four or six numbers, depending on whether the coordinate reference system includes a vertical axis (height or depth):  * Lower left corner, coordinate axis 1 * Lower left corner, coordinate axis 2 * Minimum value, coordinate axis 3 (optional) * Upper right corner, coordinate axis 1 * Upper right corner, coordinate axis 2 * Maximum value, coordinate axis 3 (optional)  If the value consists of four numbers, the coordinate reference system is WGS 84 longitude/latitude (http://www.opengis.net/def/crs/OGC/1.3/CRS84) unless a different coordinate reference system is specified in the parameter &#x60;bbox-crs&#x60;.  If the value consists of six numbers, the coordinate reference system is WGS 84 longitude/latitude/ellipsoidal height (http://www.opengis.net/def/crs/OGC/0/CRS84h) unless a different coordinate reference system is specified in the parameter &#x60;bbox-crs&#x60;.  The query parameter &#x60;bbox-crs&#x60; is specified in OGC API - Features - Part 2: Coordinate Reference Systems by Reference.  For WGS 84 longitude/latitude the values are in most cases the sequence of minimum longitude, minimum latitude, maximum longitude and maximum latitude. However, in cases where the box spans the antimeridian the first value (west-most box edge) is larger than the third value (east-most box edge).  If the vertical axis is included, the third and the sixth number are the bottom and the top of the 3-dimensional bounding box.  If a feature has multiple spatial geometry properties, it is the decision of the server whether only a single spatial geometry property is used to determine the extent or all relevant geometries. (optional)
     * @return a list of assets (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun requestAssets(
        acceptLanguage: String,
        authorization: String,
        packageId: String,
        legId: String,
        limit: Int,
        offset: Int,
        bbox: List<BigDecimal>?,
    ): AssetCollection {
        TODO("Not yet implemented")
    }

    /**
     * POST /processes/select-offers/execution : Select offer(s) into a package
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param selectOffersRequestRequest  (optional)
     * @return a single instance of a package (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun selectOffersRequest(
        acceptLanguage: String,
        authorization: String,
        selectOffersRequestRequest: SelectOffersRequestRequest?,
    ): Package {
        TODO("Not yet implemented")
    }

    /**
     * POST /processes/update-travel-specification/execution : update start/end location or start/end time
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param updateTravelSpecificationRequestRequest  (optional)
     * @return a single instance of a package (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun updateTravelSpecificationRequest(
        acceptLanguage: String,
        authorization: String,
        updateTravelSpecificationRequestRequest: UpdateTravelSpecificationRequestRequest?,
    ): Package {
        TODO("Not yet implemented")
    }

    /**
     * POST /processes/update-traveller/execution : update details of a traveller
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param updateTravellerRequestRequest  (optional)
     * @return a single instance of a package (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun updateTravellerRequest(
        acceptLanguage: String,
        authorization: String,
        updateTravellerRequestRequest: UpdateTravellerRequestRequest?,
    ): Package {
        TODO("Not yet implemented")
    }
}
