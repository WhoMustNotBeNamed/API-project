package org.hse.template.controller

import org.hse.template.api.ObsidianApi
import org.hse.template.client.rest.api.ObsidianNotesClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/obsidian")
class ObsidianNotesController (
    @Value("\${obsidian.api.token}")
    private val token: String,
    private val obsidianNotesClient: ObsidianNotesClient
) : ObsidianApi {
    val bearerToken = "Bearer $token"
    @GetMapping("/notes")
    override fun getVaults() = obsidianNotesClient.getVaults(bearerToken)

    @GetMapping("/notes/open/{name}")
    override fun openVault(@PathVariable name : String) = obsidianNotesClient.openVault(name, bearerToken)

    @PostMapping("notes/create/{name}", consumes = [MediaType.TEXT_MARKDOWN_VALUE])
    override fun createVault(@PathVariable name : String, @RequestBody text : String) = obsidianNotesClient.creareVault(name, text, bearerToken)

    @DeleteMapping("notes/delete/{name}")
    override fun deleteVault(@PathVariable name : String) = obsidianNotesClient.deleteVault(name, bearerToken)
}
