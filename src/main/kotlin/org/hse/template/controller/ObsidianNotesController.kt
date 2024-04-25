package org.hse.template.controller

import feign.Body
import jakarta.servlet.http.HttpServletRequest
import org.hse.template.client.rest.api.ObsidianNotesClient
import org.hse.template.client.rest.model.ObsidianFiles
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/obsidian")
class ObsidianNotesController (
    @Value("\${obsidian.api.token}")
    private val token: String,
    private val obsidianNotesClient: ObsidianNotesClient
) {
    val bearerToken = "Bearer $token"
    @GetMapping("/notes")
    fun getVaults() = obsidianNotesClient.getVaults(bearerToken)

    @GetMapping("/notes/open/{name}")
    fun openVault(@PathVariable name : String) = obsidianNotesClient.openVault(name, bearerToken)

    @PostMapping("notes/create/{name}", consumes = [MediaType.TEXT_MARKDOWN_VALUE])
    fun createVault(@PathVariable name : String, @RequestBody text : String) = obsidianNotesClient.creareVault(name, text, bearerToken)

    @DeleteMapping("notes/delete/{name}")
    fun deleteVault(@PathVariable name : String) = obsidianNotesClient.deleteVault(name, bearerToken)
}
