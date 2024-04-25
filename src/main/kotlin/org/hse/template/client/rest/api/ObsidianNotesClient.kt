package org.hse.template.client.rest.api

import org.hse.template.client.rest.model.ObsidianFiles
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "obsidianNotes")
interface ObsidianNotesClient {
    @GetMapping("vault/")
    fun getVaults(@RequestHeader("Authorization") bearerToken: String): ObsidianFiles

    @PutMapping("vault/")
    fun creareVault(
        @RequestParam fileName : String,
        @RequestHeader("Authorization") bearerToken: String
    )
}