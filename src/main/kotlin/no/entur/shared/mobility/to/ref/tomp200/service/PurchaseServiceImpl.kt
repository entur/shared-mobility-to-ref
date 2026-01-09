package no.entur.shared.mobility.to.ref.tomp200.service

import no.entur.shared.mobility.to.ref.tomp200.controller.PurchaseService
import no.entur.shared.mobility.to.ref.tomp200.dto.ExtendExpiryTimeRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.Package
import no.entur.shared.mobility.to.ref.tomp200.dto.PurchaseOffersRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.PurchasePackageRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.PurchaseProductRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.TravelDocuments
import no.entur.shared.mobility.to.ref.tomp200.dto.UseAssetRequestRequest
import org.springframework.stereotype.Service

@Service("PurchaseServiceImpl200")
class PurchaseServiceImpl : PurchaseService {
    /**
     * POST /processes/confirm-purchase/execution : Confirm the purchase, before the rollbackExpiryTime has ended
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param purchasePackageRequestRequest  (optional)
     * @return A package was succesfully purchased (PURCHASED), or pending (PENDING, to be confirmed using the package operation CONFIRM). (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun confirmPurchaseRequest(
        acceptLanguage: String,
        authorization: String,
        purchasePackageRequestRequest: PurchasePackageRequestRequest?,
    ): Package {
        TODO("Not yet implemented")
    }

    /**
     * POST /processes/extend-expiry-time/execution : Request additional time to complete the purchase
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param extendExpiryTimeRequestRequest  (optional)
     * @return a single instance of a package (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun extendExpiryTimeRequest(
        acceptLanguage: String,
        authorization: String,
        extendExpiryTimeRequestRequest: ExtendExpiryTimeRequestRequest?,
    ): Package {
        TODO("Not yet implemented")
    }

    /**
     * GET /collections/travel-documents/items : Retrieve travel documents
     * Returns travel documents for a package or leg
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param packageId the identifier of a package (required)
     * @param legId leg identifier (optional)
     * @return a response to obtain travel document (references) (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun getTravelDocuments(
        acceptLanguage: String,
        authorization: String,
        packageId: String,
        legId: String?,
    ): TravelDocuments {
        TODO("Not yet implemented")
    }

    /**
     * POST /processes/purchase-offers/execution : Perform an purchase of offer(s)
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param digest the hash of the body, SHA-256 (\&quot;SHA-256&#x3D;3q2+7w&#x3D;&#x3D;:\&quot;) (optional)
     * @param publicKey the public key of the sending party, can be used to validate the signed digest (it should deliver the digest) (optional)
     * @param signedDigest the signed hash of complete response, using the private key, SHA-256 base64 encoded (optional)
     * @param purchaseOffersRequestRequest  (optional)
     * @return A package was succesfully purchased (PURCHASED), or pending (PENDING, to be confirmed using the package operation CONFIRM). (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun purchaseOffersRequest(
        acceptLanguage: String,
        authorization: String,
        digest: String?,
        publicKey: String?,
        signedDigest: String?,
        purchaseOffersRequestRequest: PurchaseOffersRequestRequest?,
    ): Package {
        TODO("Not yet implemented")
    }

    /**
     * POST /processes/purchase-package/execution : Perform an purchase of a package
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param digest the hash of the body, SHA-256 (\&quot;SHA-256&#x3D;3q2+7w&#x3D;&#x3D;:\&quot;) (optional)
     * @param publicKey the public key of the sending party, can be used to validate the signed digest (it should deliver the digest) (optional)
     * @param signedDigest the signed hash of complete response, using the private key, SHA-256 base64 encoded (optional)
     * @param purchasePackageRequestRequest  (optional)
     * @return A package was succesfully purchased (PURCHASED), or pending (PENDING, to be confirmed using the package operation CONFIRM). (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun purchasePackageRequest(
        acceptLanguage: String,
        authorization: String,
        digest: String?,
        publicKey: String?,
        signedDigest: String?,
        purchasePackageRequestRequest: PurchasePackageRequestRequest?,
    ): Package {
        TODO("Not yet implemented")
    }

    /**
     * POST /processes/purchase-product/execution : Perform an purchase of a product
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param purchaseProductRequestRequest  (optional)
     * @return A package was succesfully purchased (PURCHASED), or pending (PENDING, to be confirmed using the package operation CONFIRM). (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun purchaseProductRequest(
        acceptLanguage: String,
        authorization: String,
        purchaseProductRequestRequest: PurchaseProductRequestRequest?,
    ): Package {
        TODO("Not yet implemented")
    }

    /**
     * POST /processes/rollback-purchase/execution : Rollback a purchase, before the rollbackExpiryTime has ended
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param purchasePackageRequestRequest  (optional)
     * @return a single instance of a package (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun rollbackPurchaseRequest(
        acceptLanguage: String,
        authorization: String,
        purchasePackageRequestRequest: PurchasePackageRequestRequest?,
    ): Package {
        TODO("Not yet implemented")
    }

    /**
     * POST /processes/use-asset/execution : Request to use an asset
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param useAssetRequestRequest  (optional)
     * @return A package was succesfully purchased (PURCHASED), or pending (PENDING, to be confirmed using the package operation CONFIRM). (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun useAssetRequest(
        acceptLanguage: String,
        authorization: String,
        useAssetRequestRequest: UseAssetRequestRequest?,
    ): Package {
        TODO("Not yet implemented")
    }
}
