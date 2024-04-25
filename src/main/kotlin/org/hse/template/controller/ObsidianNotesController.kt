package org.hse.template.controller

import jakarta.servlet.http.HttpServletRequest
import org.hse.template.client.rest.api.ObsidianNotesClient
import org.hse.template.client.rest.model.ObsidianFiles
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/obsidian")
class ObsidianNotesController (
    @Value("\${obsidian.api.token}")
    private val token: String,
    private val obsidianNotesClient: ObsidianNotesClient
) {
    @GetMapping("/notes")
    fun getVaults(request: HttpServletRequest): ObsidianFiles {
        val bearerToken = "Bearer $token"
        return obsidianNotesClient.getVaults(bearerToken)
    }
}
