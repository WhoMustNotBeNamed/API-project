package org.hse.template.controller

import org.hse.template.api.OMDbApi
import org.hse.template.client.rest.api.OMDbClient
import org.hse.template.client.rest.model.MovieSearch
import org.hse.template.client.rest.model.OMDbSearch
import org.hse.template.client.rest.repository.OMDbSearchRepository
import org.hse.template.service.OMDbService
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/omdb")
class OMDbController (
    @Value("\${omdb.api.api-key}")
    private val apiKey: String,
    private val omdbClient: OMDbClient,
    val omdbSearchRepository: OMDbSearchRepository,
    val omdbService: OMDbService
) : OMDbApi {
    @GetMapping("/search/{title}")
    override fun search(@PathVariable title: String) = omdbClient.search(title, apiKey)

    @GetMapping("/movie/{id}")
    override fun movie(@PathVariable id: String) = omdbClient.movie(id, apiKey)

    @GetMapping("/movies")
    override fun movies(@RequestParam title: String, @RequestParam year: String) = omdbService.movies(title, year, apiKey)

    @GetMapping("/series")
    override fun series(@RequestParam title: String, @RequestParam year: String) = omdbService.series(title, year, apiKey)
}