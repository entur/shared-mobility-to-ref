package no.entur.shared.mobility.to.ref.tomp200.controller

import no.entur.shared.mobility.to.ref.tomp200.dto.ExtendExpiryTimeRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.Package
import no.entur.shared.mobility.to.ref.tomp200.dto.PurchaseOffersRequestDefaultResponse
import no.entur.shared.mobility.to.ref.tomp200.dto.PurchaseOffersRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.PurchasePackageRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.PurchaseProductRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.TravelDocuments
import no.entur.shared.mobility.to.ref.tomp200.dto.UseAssetRequestRequest

interface PurchaseService {

    /**
     * POST /processes/confirm-purchase/execution : Confirm the purchase, before the rollbackExpiryTime has ended
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param purchasePackageRequestRequest  (optional)
     * @return A package was succesfully purchased (PURCHASED), or pending (PENDING, to be confirmed using the package operation CONFIRM). (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see Purchase#confirmPurchaseRequest
     */
    fun confirmPurchaseRequest(acceptLanguage: kotlin.String, authorization: kotlin.String, purchasePackageRequestRequest: PurchasePackageRequestRequest?): Package

    /**
     * POST /processes/extend-expiry-time/execution : Request additional time to complete the purchase
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param extendExpiryTimeRequestRequest  (optional)
     * @return a single instance of a package (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see Purchase#extendExpiryTimeRequest
     */
    fun extendExpiryTimeRequest(acceptLanguage: kotlin.String, authorization: kotlin.String, extendExpiryTimeRequestRequest: ExtendExpiryTimeRequestRequest?): Package

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
     * @see Purchase#getTravelDocuments
     */
    fun getTravelDocuments(acceptLanguage: kotlin.String, authorization: kotlin.String, packageId: kotlin.String, legId: kotlin.String?): TravelDocuments

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
     * @see Purchase#purchaseOffersRequest
     */
    fun purchaseOffersRequest(acceptLanguage: kotlin.String, authorization: kotlin.String, digest: kotlin.String?, publicKey: kotlin.String?, signedDigest: kotlin.String?, purchaseOffersRequestRequest: PurchaseOffersRequestRequest?): Package

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
     * @see Purchase#purchasePackageRequest
     */
    fun purchasePackageRequest(acceptLanguage: kotlin.String, authorization: kotlin.String, digest: kotlin.String?, publicKey: kotlin.String?, signedDigest: kotlin.String?, purchasePackageRequestRequest: PurchasePackageRequestRequest?): Package

    /**
     * POST /processes/purchase-product/execution : Perform an purchase of a product
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param purchaseProductRequestRequest  (optional)
     * @return A package was succesfully purchased (PURCHASED), or pending (PENDING, to be confirmed using the package operation CONFIRM). (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see Purchase#purchaseProductRequest
     */
    fun purchaseProductRequest(acceptLanguage: kotlin.String, authorization: kotlin.String, purchaseProductRequestRequest: PurchaseProductRequestRequest?): Package

    /**
     * POST /processes/rollback-purchase/execution : Rollback a purchase, before the rollbackExpiryTime has ended
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param purchasePackageRequestRequest  (optional)
     * @return a single instance of a package (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see Purchase#rollbackPurchaseRequest
     */
    fun rollbackPurchaseRequest(acceptLanguage: kotlin.String, authorization: kotlin.String, purchasePackageRequestRequest: PurchasePackageRequestRequest?): Package

    /**
     * POST /processes/use-asset/execution : Request to use an asset
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param useAssetRequestRequest  (optional)
     * @return A package was succesfully purchased (PURCHASED), or pending (PENDING, to be confirmed using the package operation CONFIRM). (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     * @see Purchase#useAssetRequest
     */
    fun useAssetRequest(acceptLanguage: kotlin.String, authorization: kotlin.String, useAssetRequestRequest: UseAssetRequestRequest?): Package
}
