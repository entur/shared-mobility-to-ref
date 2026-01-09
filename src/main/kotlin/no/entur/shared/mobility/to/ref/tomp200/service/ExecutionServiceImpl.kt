package no.entur.shared.mobility.to.ref.tomp200.service

import no.entur.shared.mobility.to.ref.tomp200.controller.ExecutionService
import no.entur.shared.mobility.to.ref.tomp200.dto.AssetOperationRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.LegOperationRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.Package
import no.entur.shared.mobility.to.ref.tomp200.dto.ProductOperationRequest
import org.springframework.stereotype.Service

@Service("ExecutionServiceImpl200")
class ExecutionServiceImpl : ExecutionService {
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
     */
    override fun assetOperation(
        acceptLanguage: String,
        authorization: String,
        assetOperation: String,
        assetOperationRequest: AssetOperationRequest?,
    ): Package {
        TODO("Not yet implemented")
    }

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
     */
    override fun legOperation(
        acceptLanguage: String,
        authorization: String,
        legOperation: String,
        legOperationRequest: LegOperationRequest?,
    ): Package {
        TODO("Not yet implemented")
    }

    /**
     * POST /processes/{productOperation}-product/execution : Perform an operation on a product
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param productOperation OPERATION on a specified product (required)
     * @param productOperationRequest  (optional)
     * @return a single instance of a package (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun productOperation(
        acceptLanguage: String,
        authorization: String,
        productOperation: String,
        productOperationRequest: ProductOperationRequest?,
    ): Package {
        TODO("Not yet implemented")
    }
}
