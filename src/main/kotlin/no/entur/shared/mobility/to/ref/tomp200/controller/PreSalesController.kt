package no.entur.shared.mobility.to.ref.tomp200.controller

import no.entur.shared.mobility.to.ref.tomp200.dto.AncillaryCollection
import no.entur.shared.mobility.to.ref.tomp200.dto.AssetCollection
import no.entur.shared.mobility.to.ref.tomp200.dto.AssignAncillaryRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.AssignAssetRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.Package
import no.entur.shared.mobility.to.ref.tomp200.dto.ReleasePackageRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.RemoveOfferRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.SelectOffersRequestDefaultResponse
import no.entur.shared.mobility.to.ref.tomp200.dto.SelectOffersRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.UpdateTravelSpecificationRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.UpdateTravellerRequestRequest
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

@RestController("no.entur.shared.mobility.to.ref.tomp200.controller.PreSalesController")
@Validated
@RequestMapping("\${api.base-path:}")
class PreSalesController(@Autowired(required = true) val service: PreSalesService) {

    @Operation(
        summary = "Assign an ancillary to a package (and a leg). It could also replace another ancillary or remove one",
        operationId = "assignAncillaryRequest",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "a single instance of a package", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = SelectOffersRequestDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/assign-ancillary/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun assignAncillaryRequest(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) assignAncillaryRequestRequest: AssignAncillaryRequestRequest?): ResponseEntity<Package> {
        return ResponseEntity(service.assignAncillaryRequest(acceptLanguage, authorization, assignAncillaryRequestRequest), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Assign an asset to a package (and a leg). It could also replace another asset or remove one",
        operationId = "assignAssetRequest",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "a single instance of a package", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = SelectOffersRequestDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/assign-asset/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun assignAssetRequest(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) assignAssetRequestRequest: AssignAssetRequestRequest?): ResponseEntity<Package> {
        return ResponseEntity(service.assignAssetRequest(acceptLanguage, authorization, assignAssetRequestRequest), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Release the complete package",
        operationId = "releasePackageRequest",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "a single instance of a package", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = SelectOffersRequestDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/release-package/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun releasePackageRequest(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) releasePackageRequestRequest: ReleasePackageRequestRequest?): ResponseEntity<Package> {
        return ResponseEntity(service.releasePackageRequest(acceptLanguage, authorization, releasePackageRequestRequest), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Remove an offer from the package",
        operationId = "removeOfferRequest",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "a single instance of a package", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = SelectOffersRequestDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/remove-offer/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun removeOfferRequest(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) removeOfferRequestRequest: RemoveOfferRequestRequest?): ResponseEntity<Package> {
        return ResponseEntity(service.removeOfferRequest(acceptLanguage, authorization, removeOfferRequestRequest), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Request available ancillaries for a leg",
        operationId = "requestAncillaries",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "a list of ancillaries", content = [Content(schema = Schema(implementation = AncillaryCollection::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = SelectOffersRequestDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/collections/ancillaries/items"],
        produces = ["application/geo+json", "application/json"]
    )
    fun requestAncillaries(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@NotNull @Parameter(description = "the identifier of a package", required = true) @Valid @RequestParam(value = "packageId", required = true) packageId: kotlin.String,@NotNull @Parameter(description = "leg identifier", required = true) @Valid @RequestParam(value = "legId", required = true) legId: kotlin.String,@Min(1) @Max(10000) @Parameter(description = "The optional limit parameter limits the number of items that are presented in the response document.  Only items are counted that are on the first level of the collection in the response document. Nested objects contained within the explicitly requested items shall not be counted.  Minimum = 1. Maximum = 10000. Default = 100.", schema = Schema(defaultValue = "100")) @Valid @RequestParam(value = "limit", required = false, defaultValue = "100") limit: kotlin.Int,@Min(0)@Parameter(description = "The optional offset parameter representing the starting index of the returned collection.  Only items are counted that are on the first level of the collection in the response document. Nested objects contained within the explicitly requested items shall not be counted.  Default = 0.", schema = Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") offset: kotlin.Int,@Parameter(description = "Only features that have a geometry that intersects the bounding box are selected. The bounding box is provided as four or six numbers, depending on whether the coordinate reference system includes a vertical axis (height or depth):  * Lower left corner, coordinate axis 1 * Lower left corner, coordinate axis 2 * Minimum value, coordinate axis 3 (optional) * Upper right corner, coordinate axis 1 * Upper right corner, coordinate axis 2 * Maximum value, coordinate axis 3 (optional)  If the value consists of four numbers, the coordinate reference system is WGS 84 longitude/latitude (http://www.opengis.net/def/crs/OGC/1.3/CRS84) unless a different coordinate reference system is specified in the parameter `bbox-crs`.  If the value consists of six numbers, the coordinate reference system is WGS 84 longitude/latitude/ellipsoidal height (http://www.opengis.net/def/crs/OGC/0/CRS84h) unless a different coordinate reference system is specified in the parameter `bbox-crs`.  The query parameter `bbox-crs` is specified in OGC API - Features - Part 2: Coordinate Reference Systems by Reference.  For WGS 84 longitude/latitude the values are in most cases the sequence of minimum longitude, minimum latitude, maximum longitude and maximum latitude. However, in cases where the box spans the antimeridian the first value (west-most box edge) is larger than the third value (east-most box edge).  If the vertical axis is included, the third and the sixth number are the bottom and the top of the 3-dimensional bounding box.  If a feature has multiple spatial geometry properties, it is the decision of the server whether only a single spatial geometry property is used to determine the extent or all relevant geometries.") @Valid @RequestParam(value = "bbox", required = false) bbox: kotlin.collections.List<java.math.BigDecimal>?): ResponseEntity<AncillaryCollection> {
        return ResponseEntity(service.requestAncillaries(acceptLanguage, authorization, packageId, legId, limit, offset, bbox), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Request available assets for a leg",
        operationId = "requestAssets",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "a list of assets", content = [Content(schema = Schema(implementation = AssetCollection::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = SelectOffersRequestDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/collections/assets/items"],
        produces = ["application/geo+json", "application/json"]
    )
    fun requestAssets(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@NotNull @Parameter(description = "the identifier of a package", required = true) @Valid @RequestParam(value = "packageId", required = true) packageId: kotlin.String,@NotNull @Parameter(description = "leg identifier", required = true) @Valid @RequestParam(value = "legId", required = true) legId: kotlin.String,@Min(1) @Max(10000) @Parameter(description = "The optional limit parameter limits the number of items that are presented in the response document.  Only items are counted that are on the first level of the collection in the response document. Nested objects contained within the explicitly requested items shall not be counted.  Minimum = 1. Maximum = 10000. Default = 100.", schema = Schema(defaultValue = "100")) @Valid @RequestParam(value = "limit", required = false, defaultValue = "100") limit: kotlin.Int,@Min(0)@Parameter(description = "The optional offset parameter representing the starting index of the returned collection.  Only items are counted that are on the first level of the collection in the response document. Nested objects contained within the explicitly requested items shall not be counted.  Default = 0.", schema = Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") offset: kotlin.Int,@Parameter(description = "Only features that have a geometry that intersects the bounding box are selected. The bounding box is provided as four or six numbers, depending on whether the coordinate reference system includes a vertical axis (height or depth):  * Lower left corner, coordinate axis 1 * Lower left corner, coordinate axis 2 * Minimum value, coordinate axis 3 (optional) * Upper right corner, coordinate axis 1 * Upper right corner, coordinate axis 2 * Maximum value, coordinate axis 3 (optional)  If the value consists of four numbers, the coordinate reference system is WGS 84 longitude/latitude (http://www.opengis.net/def/crs/OGC/1.3/CRS84) unless a different coordinate reference system is specified in the parameter `bbox-crs`.  If the value consists of six numbers, the coordinate reference system is WGS 84 longitude/latitude/ellipsoidal height (http://www.opengis.net/def/crs/OGC/0/CRS84h) unless a different coordinate reference system is specified in the parameter `bbox-crs`.  The query parameter `bbox-crs` is specified in OGC API - Features - Part 2: Coordinate Reference Systems by Reference.  For WGS 84 longitude/latitude the values are in most cases the sequence of minimum longitude, minimum latitude, maximum longitude and maximum latitude. However, in cases where the box spans the antimeridian the first value (west-most box edge) is larger than the third value (east-most box edge).  If the vertical axis is included, the third and the sixth number are the bottom and the top of the 3-dimensional bounding box.  If a feature has multiple spatial geometry properties, it is the decision of the server whether only a single spatial geometry property is used to determine the extent or all relevant geometries.") @Valid @RequestParam(value = "bbox", required = false) bbox: kotlin.collections.List<java.math.BigDecimal>?): ResponseEntity<AssetCollection> {
        return ResponseEntity(service.requestAssets(acceptLanguage, authorization, packageId, legId, limit, offset, bbox), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "Select offer(s) into a package",
        operationId = "selectOffersRequest",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "a single instance of a package", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = SelectOffersRequestDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/select-offers/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun selectOffersRequest(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) selectOffersRequestRequest: SelectOffersRequestRequest?): ResponseEntity<Package> {
        return ResponseEntity(service.selectOffersRequest(acceptLanguage, authorization, selectOffersRequestRequest), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "update start/end location or start/end time",
        operationId = "updateTravelSpecificationRequest",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "a single instance of a package", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = SelectOffersRequestDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/update-travel-specification/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun updateTravelSpecificationRequest(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) updateTravelSpecificationRequestRequest: UpdateTravelSpecificationRequestRequest?): ResponseEntity<Package> {
        return ResponseEntity(service.updateTravelSpecificationRequest(acceptLanguage, authorization, updateTravelSpecificationRequestRequest), HttpStatus.valueOf(200))
    }

    @Operation(
        summary = "update details of a traveller",
        operationId = "updateTravellerRequest",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "a single instance of a package", content = [Content(schema = Schema(implementation = Package::class))]),
            ApiResponse(responseCode = "200", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = [Content(schema = Schema(implementation = SelectOffersRequestDefaultResponse::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/processes/update-traveller/execution"],
        produces = ["application/geo+json", "application/json"],
        consumes = ["application/json"]
    )
    fun updateTravellerRequest(@Size(max=75) @Parameter(description = "", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "Accept-Language", required = true) acceptLanguage: kotlin.String,@Parameter(description = "Header field, JWT must be supplied", `in` = ParameterIn.HEADER, required = true) @RequestHeader(value = "authorization", required = true) authorization: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) updateTravellerRequestRequest: UpdateTravellerRequestRequest?): ResponseEntity<Package> {
        return ResponseEntity(service.updateTravellerRequest(acceptLanguage, authorization, updateTravellerRequestRequest), HttpStatus.valueOf(200))
    }
}
