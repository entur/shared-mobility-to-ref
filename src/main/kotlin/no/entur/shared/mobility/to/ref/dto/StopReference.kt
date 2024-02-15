package no.entur.shared.mobility.to.ref.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Size

/**
 * reference to a stop (can be nation specific). This can help to specific pinpoint a (bus) stop. Extra information about the stop is not
 * supplied; you should find it elsewhere.
 * @param type type of external reference (GTFS, CHB).
 * @param id this field should contain the complete ID. E.g. NL:S:13121110 or BE:S:79640040
 * @param country two-letter country codes according to ISO 3166-1
 */
data class StopReference(
    @Schema(example = "null", required = true, description = "type of external reference (GTFS, CHB).")
    @get:JsonProperty("type", required = true) val type: Type,
    @Schema(
        example = "null",
        required = true,
        description = "this field should contain the complete ID. E.g. NL:S:13121110 or BE:S:79640040",
    )
    @get:JsonProperty("id", required = true) val id: String,
    @get:Size(min = 2, max = 2)
    @Schema(example = "NL", required = true, description = "two-letter country codes according to ISO 3166-1")
    @get:JsonProperty("country", required = true) val country: String,
) {
    /**
     * type of external reference (GTFS, CHB).
     * Values: gTFSSTOPID,gTFSSTOPCODE,gTFSAREAID,cHBSTOPPLACECODE,cHBQUAYCODE,nSCODE
     */
    enum class Type {
        GTFS_STOP_ID,
        GTFS_STOP_CODE,
        GTFS_AREA_ID,
        CHB_STOP_PLACE_CODE,
        CHB_QUAY_CODE,
        NS_CODE,
    }
}
