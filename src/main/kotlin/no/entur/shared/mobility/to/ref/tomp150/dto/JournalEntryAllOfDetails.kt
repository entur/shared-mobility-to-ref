package no.entur.shared.mobility.to.ref.tomp150.dto

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import no.entur.shared.mobility.to.ref.tomp150.dto.BankAccount
import no.entur.shared.mobility.to.ref.tomp150.dto.ExtraCosts
import no.entur.shared.mobility.to.ref.tomp150.dto.Fare
import no.entur.shared.mobility.to.ref.tomp150.dto.FarePart
import no.entur.shared.mobility.to.ref.tomp150.dto.JournalCategory
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
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
 * the specification of the amount; how is it composed.
 */
sealed interface JournalEntryAllOfDetails {
}

