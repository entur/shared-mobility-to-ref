package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp200.dto.PaymentCategory
import no.entur.shared.mobility.to.ref.tomp200.dto.PaymentState
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import jakarta.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

/**
 * this object contains the filter parameters
 * @param type 
 * @param limit 
 * @param offset 
 * @param startTime https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)
 * @param endTime https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)
 * @param invoiceState 
 * @param &#x60;package&#x60; default string, full names etc (length 0-200)
 * @param category 
 */
data class PaymentsProperties(

    @get:Pattern(regexp="^(paymentCollection)$")
    @Schema(example = "null", description = "")
    @get:JsonProperty("type") val type: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("limit") val limit: kotlin.Int? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("offset") val offset: kotlin.Int? = null,

    @Schema(example = "null", description = "https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)")
    @get:JsonProperty("startTime") val startTime: java.time.OffsetDateTime? = null,

    @Schema(example = "null", description = "https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)")
    @get:JsonProperty("endTime") val endTime: java.time.OffsetDateTime? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("invoiceState") val invoiceState: PaymentState? = null,

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("package") val `package`: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("category") val category: PaymentCategory? = null
) {

}

