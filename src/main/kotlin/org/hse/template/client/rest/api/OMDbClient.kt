package org.hse.template.client.rest.api

import org.hse.template.client.rest.model.MovieSearch
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "omdbClient")
interface OMDbClient {

    @GetMapping
    fun search(
        @RequestParam("t") title: String,
        @RequestParam apiKey: String
    ): String

    @GetMapping
    fun movie(
        @RequestParam("i") id: String,
        @RequestParam apiKey: String
    ): String

    @GetMapping
    fun movies(
        @RequestParam("s") title: String,
        @RequestParam("y") year: String,
        @RequestParam apiKey: String,
        @RequestParam("type") type: String = "movie"
    ): MovieSearch

    @GetMapping
    fun series(
        @RequestParam("s") title: String,
        @RequestParam("y") year: String,
        @RequestParam apiKey: String,
        @RequestParam("type") type: String = "series"
    ): MovieSearch
}