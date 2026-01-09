package no.entur.shared.mobility.to.ref.tomp200.service

import no.entur.shared.mobility.to.ref.tomp200.controller.AfterSalesService
import no.entur.shared.mobility.to.ref.tomp200.dto.CancelPackageOperationRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.ConfirmPaymentEntryRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.Package
import no.entur.shared.mobility.to.ref.tomp200.dto.PaymentCategory
import no.entur.shared.mobility.to.ref.tomp200.dto.PaymentState
import no.entur.shared.mobility.to.ref.tomp200.dto.Payments
import no.entur.shared.mobility.to.ref.tomp200.dto.RedressOptionRequestRequest
import no.entur.shared.mobility.to.ref.tomp200.dto.RedressOptions
import no.entur.shared.mobility.to.ref.tomp200.dto.RefundDepositRequestRequest
import org.springframework.stereotype.Service
import java.time.OffsetDateTime

@Service("AfterSalesServiceImpl200")
class AfterSalesServiceImpl : AfterSalesService {
    /**
     * POST /processes/cancel-package/execution : Cancel a package in confirmed state for (technical issues).
     * Cancel this package. This endpoint is only there to correct (technical) issues.&lt;br&gt; Normally, after purchase, you have to request redress options, claim it and confirm the claim.&lt;br&gt; &lt;br&gt; Before purchase you release a package.&lt;br&gt; During the purchase you rollback a package.&lt;br&gt;
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param cancelPackageOperationRequest  (optional)
     * @return a single instance of a package (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun cancelPackageOperation(
        acceptLanguage: String,
        authorization: String,
        cancelPackageOperationRequest: CancelPackageOperationRequest?,
    ): Package {
        TODO("Not yet implemented")
    }

    /**
     * POST /processes/confirm-payment/execution : Confirm a financial transaction
     * The MP (reseller) confirms a payment
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param confirmPaymentEntryRequest  (optional)
     * @return the payment is acknowledged (status code 204)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun confirmPaymentEntry(
        acceptLanguage: String,
        authorization: String,
        confirmPaymentEntryRequest: ConfirmPaymentEntryRequest?,
    ) {
        TODO("Not yet implemented")
    }

    /**
     * POST /processes/confirm-redress-option/execution
     * confirm the claimed redress option
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param redressOptionRequestRequest  (optional)
     * @return a single instance of a package (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun confirmRedressOptionRequest(
        acceptLanguage: String,
        authorization: String,
        redressOptionRequestRequest: RedressOptionRequestRequest?,
    ): Package {
        TODO("Not yet implemented")
    }

    /**
     * GET /collections/payments/items : Retrieve financial details
     * Returns all the JOURNAL ENTRIES that should be paid
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param limit The optional limit parameter limits the number of items that are presented in the response document.  Only items are counted that are on the first level of the collection in the response document. Nested objects contained within the explicitly requested items shall not be counted.  Minimum &#x3D; 1. Maximum &#x3D; 10000. Default &#x3D; 100. (optional, default to 100)
     * @param offset The optional offset parameter representing the starting index of the returned collection.  Only items are counted that are on the first level of the collection in the response document. Nested objects contained within the explicitly requested items shall not be counted.  Default &#x3D; 0. (optional, default to 0)
     * @param startTime start of the selection (optional)
     * @param endTime end of the selection (optional)
     * @param invoiceState  (optional)
     * @param `package`  (optional)
     * @param category type of PAYMENT DETAIL (e.g. fare, addition costs, fines, ...) (optional)
     * @param onBehalveOf the identity of the reseller. Only to be used in a PSP (externalized payments) setup. (optional)
     * @return journal entries (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun getPaymentOverview(
        acceptLanguage: String,
        authorization: String,
        limit: Int,
        offset: Int,
        startTime: OffsetDateTime?,
        endTime: OffsetDateTime?,
        invoiceState: PaymentState?,
        `package`: String?,
        category: PaymentCategory?,
        onBehalveOf: String?,
    ): Payments {
        TODO("Not yet implemented")
    }

    /**
     * GET /collections/redress-options/items : Retrieve redress options for a guarantee
     * Returns possible refund or replacement options for a guarantee
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param packageId the id of the package that contains a purchased product (required)
     * @param offerId the offer with a guarantee (optional)
     * @param legId the offer with a guarantee (optional)
     * @param guaranteeId the unfulfilled guarantee (optional)
     * @param travellerId to request redresses for a single traveller (optional)
     * @param ancillaryId to request redresses for a not-used ancillary or ancillary to remove (optional)
     * @param supportTicket reference to support ticket(s) to claim redress options (optional)
     * @return a list of redress options (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun getRedressOptions(
        acceptLanguage: String,
        authorization: String,
        packageId: String,
        offerId: String?,
        legId: String?,
        guaranteeId: String?,
        travellerId: String?,
        ancillaryId: String?,
        supportTicket: String?,
    ): RedressOptions {
        TODO("Not yet implemented")
    }

    /**
     * POST /processes/claim-redress-option/execution
     * redress options must be claimed &amp; confirmed
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param redressOptionRequestRequest  (optional)
     * @return a single instance of a package (status code 200)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun redressOptionRequest(
        acceptLanguage: String,
        authorization: String,
        redressOptionRequestRequest: RedressOptionRequestRequest?,
    ): Package {
        TODO("Not yet implemented")
    }

    /**
     * POST /processes/refund-deposit/execution : Request to refund a deposit
     *
     * @param acceptLanguage  (required)
     * @param authorization Header field, JWT must be supplied (required)
     * @param refundDepositRequestRequest  (optional)
     * @return the payment is acknowledged (status code 204)
     *         or Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code. (status code 200)
     */
    override fun refundDepositRequest(
        acceptLanguage: String,
        authorization: String,
        refundDepositRequestRequest: RefundDepositRequestRequest?,
    ) {
        TODO("Not yet implemented")
    }
}
