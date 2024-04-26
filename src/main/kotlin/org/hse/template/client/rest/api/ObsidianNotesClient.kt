package org.hse.template.client.rest.api

import io.swagger.v3.oas.annotations.parameters.RequestBody
import org.hse.template.client.rest.model.ObsidianFiles
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@FeignClient(name = "obsidianNotes")
interface ObsidianNotesClient {
    @GetMapping("vault/")
    fun getVaults(@RequestHeader("Authorization") bearerToken: String): ObsidianFiles

    @GetMapping("vault/{fileName}")
    fun openVault (
        @PathVariable fileName : String,
        @RequestHeader("Authorization") bearerToken: String
    ): String

    @PostMapping("vault/{fileName}", produces = [MediaType.TEXT_MARKDOWN_VALUE])
    fun creareVault(
        @PathVariable fileName : String,
        @RequestBody text : String,
        @RequestHeader("Authorization") bearerToken: String,
    )

    @DeleteMapping("vault/{fileName}")
    fun deleteVault(
        @PathVariable fileName : String,
        @RequestHeader("Authorization") bearerToken: String,
    )
}