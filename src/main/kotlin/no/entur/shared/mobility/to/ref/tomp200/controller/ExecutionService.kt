package no.entur.shared.mobility.to.ref.tomp200.controller

import no.entur.shared.mobility.to.ref.tomp200.dto.AssetOperationRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.LegOperationDefaultResponse
import no.entur.shared.mobility.to.ref.tomp200.dto.LegOperationRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.Package
import no.entur.shared.mobility.to.ref.tomp200.dto.ProductOperationRequest

interface ExecutionService {

    /**
     * POST /processes/{assetOperation}-asset/execution : Perform an operation on a asset
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param assetOperation OPERATION on a specified asset (required)
     * @param assetOperationRequest  (optional)
     * @return a single instance of a package (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 503)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see Execution#assetOperation
     */
    fun assetOperation(acceptLanguage: kotlin.String, authorization: kotlin.String, assetOperation: kotlin.String, assetOperationRequest: AssetOperationRequest?): Package

    /**
     * POST /processes/{legOperation}-leg/execution : Perform an operation on a leg
     * This endpoint must be used to alter the state of a LEG, using OPERATION requests.
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param legOperation OPERATION on a specified leg (required)
     * @param legOperationRequest  (optional)
     * @return a single instance of a package (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see Execution#legOperation
     */
    fun legOperation(acceptLanguage: kotlin.String, authorization: kotlin.String, legOperation: kotlin.String, legOperationRequest: LegOperationRequest?): Package

    /**
     * POST /processes/{productOperation}-product/execution : Perform an operation on a product
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param productOperation OPERATION on a specified product (required)
     * @param productOperationRequest  (optional)
     * @return a single instance of a package (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see Execution#productOperation
     */
    fun productOperation(acceptLanguage: kotlin.String, authorization: kotlin.String, productOperation: kotlin.String, productOperationRequest: ProductOperationRequest?): Package
}
