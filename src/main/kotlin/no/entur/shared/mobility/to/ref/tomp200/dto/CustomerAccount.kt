package no.entur.shared.mobility.to.ref.tomp200.dto

import java.util.Locale
import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp200.dto.Customer
import no.entur.shared.mobility.to.ref.tomp200.dto.CustomerAccountStatus
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
 * A registration of the TRANSPORT CUSTOMER with an ACCOUNT PROVIDER to obtain travel services.
 * @param id default string, full names etc (length 0-200)
 * @param customer 
 * @param creationDate https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)
 * @param modificationDate https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)
 * @param status 
 */
data class CustomerAccount(

    @get:Size(max=200)
    @Schema(example = "null", description = "default string, full names etc (length 0-200)")
    @get:JsonProperty("id") val id: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("customer") val customer: Customer? = null,

    @Schema(example = "null", description = "https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)")
    @get:JsonProperty("creationDate") val creationDate: java.time.OffsetDateTime? = null,

    @Schema(example = "null", description = "https://www.rfc-editor.org/rfc/rfc3339#section-5.6, date-time (2019-10-12T07:20:50.52Z)")
    @get:JsonProperty("modificationDate") val modificationDate: java.time.OffsetDateTime? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("status") val status: CustomerAccountStatus? = null
) {

}

