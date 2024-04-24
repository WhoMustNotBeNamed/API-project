package org.hse.template.controller

import org.hse.template.api.OMDbApi
import org.hse.template.client.rest.api.OMDbClient
import org.hse.template.client.rest.model.MovieSearch
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/omdb")
class OMDbController (
    @Value("\${omdb.api.api-key}")
    val apiKey: String,
    private val omdbClient: OMDbClient
) : OMDbApi {
    @GetMapping("/search/{title}")
    override fun search(@PathVariable title: String) = omdbClient.search(title, apiKey)

    @GetMapping("/movie/{id}")
    override fun movie(@PathVariable id: String) = omdbClient.movie(id, apiKey)

    @GetMapping("/movies")
    override fun movies(@RequestParam title: String, @RequestParam year: String) = omdbClient.movies(title, year, apiKey)

    @GetMapping("/series")
    override fun series(@RequestParam title: String, @RequestParam year: String) = omdbClient.series(title, year, apiKey)
}