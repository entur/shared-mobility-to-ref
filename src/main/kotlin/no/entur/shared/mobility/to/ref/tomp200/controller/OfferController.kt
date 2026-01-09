package no.entur.shared.mobility.to.ref.tomp200.controller

import no.entur.shared.mobility.to.ref.tomp200.dto.OfferCollection
import no.entur.shared.mobility.to.ref.tomp200.dto.Package
import no.entur.shared.mobility.to.ref.tomp200.dto.SearchOffersDefaultResponse
import no.entur.shared.mobility.to.ref.tomp200.dto.SearchOffersRequest
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*
import org.springframework.validation.annotation.Validated
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.beans.factory.annotation.Autowired

import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

import kotlin.collections.List
import kotlin.collections.Map

@RestController("no.entur.shared.mobility.to.ref.tomp200.controller.OfferController")
@Validated
@RequestMapping("\${api.base-path:}")
class OfferController(@Autowired(required = true) val service: OfferService) {

    @Operation(
        summary = "Get offer details",
        operationId = "requestOffer",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "a single instance of a package", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = SearchOffersDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/collections/offers/items"],
        produces = ["application/geo+json", "application/json"]
    )
    fun requestOffer(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@NotNull @Parameter(description = "the identifier of an offer", required = true) @Valid @RequestParam(value = "offerId", required = true) offerId: kotlin.String): ResponseEntity<Package> {
        return ResponseEntity(service.requestOffer(acceptLanguage, authorization, offerId), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Search for offers",
        operationId = "searchOffers",
        description = """Returns offers based on travel specification, trip pattern, location, asset, product and user preferences. In case of a shallow integration, can even be offered as an endpoint without authentication.""",
        responses = [
            ApiResponse(responseCode = "200", description = "a list of offers", content = [Content(schema = Schema(implementation = OfferCollection::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = SearchOffersDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/search-offers/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun searchOffers(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Min(1) @Max(10000) @Parameter(description = "The optional limit parameter limits the number of items that are presented in the response document.  Only items are counted that are on the first level of the collection in the response document. Nested objects contained within the explicitly requested items shall not be counted.  Minimum = 1. Maximum = 10000. Default = 100.", schema = Schema(defaultValue = "100")) @Valid @RequestParam(value = "limit", required = false, defaultValue = "100") limit: kotlin.Int,@Min(0)@Parameter(description = "The optional offset parameter representing the starting index of the returned collection.  Only items are counted that are on the first level of the collection in the response document. Nested objects contained within the explicitly requested items shall not be counted.  Default = 0.", schema = Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") offset: kotlin.Int,@Parameter(description = "Only features that have a geometry that intersects the bounding box are selected. The bounding box is provided as four or six numbers, depending on whether the coordinate reference system includes a vertical axis (height or depth):  * Lower left corner, coordinate axis 1 * Lower left corner, coordinate axis 2 * Minimum value, coordinate axis 3 (optional) * Upper right corner, coordinate axis 1 * Upper right corner, coordinate axis 2 * Maximum value, coordinate axis 3 (optional)  If the value consists of four numbers, the coordinate reference system is WGS 84 longitude/latitude (http://www.opengis.net/def/crs/OGC/1.3/CRS84) unless a different coordinate reference system is specified in the parameter `bbox-crs`.  If the value consists of six numbers, the coordinate reference system is WGS 84 longitude/latitude/ellipsoidal height (http://www.opengis.net/def/crs/OGC/0/CRS84h) unless a different coordinate reference system is specified in the parameter `bbox-crs`.  The query parameter `bbox-crs` is specified in OGC API - Features - Part 2: Coordinate Reference Systems by Reference.  For WGS 84 longitude/latitude the values are in most cases the sequence of minimum longitude, minimum latitude, maximum longitude and maximum latitude. However, in cases where the box spans the antimeridian the first value (west-most box edge) is larger than the third value (east-most box edge).  If the vertical axis is included, the third and the sixth number are the bottom and the top of the 3-dimensional bounding box.  If a feature has multiple spatial geometry properties, it is the decision of the server whether only a single spatial geometry property is used to determine the extent or all relevant geometries.") @Valid @RequestParam(value = "bbox", required = false) bbox: kotlin.collections.List<java.math.BigDecimal>?,@Parameter(description = "") @Valid @RequestBody(required = false) searchOffersRequest: SearchOffersRequest?): ResponseEntity<OfferCollection> {
        return ResponseEntity(service.searchOffers(acceptLanguage, authorization, limit, offset, bbox, searchOffersRequest), HttpStatus.valueOf(200))
    }
}
