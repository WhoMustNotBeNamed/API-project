package org.hse.template.api

import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.hse.template.client.rest.model.MovieSearch

interface OMDbApi {
    @Tag(name = "Получение всей информации о фильме по его названию")
    @ApiResponses(
        ApiResponse(
            description = "Успешный запрос",
            responseCode = "200",
        )
    )
    fun search(
        @Schema(
            description = "Наименование фильма",
            defaultValue = "The Matrix"
        )
        title: String = "The Matrix"
    ): String

    @Tag(name = "Получение всей информации о фильме по его ID")
    @ApiResponses(
        ApiResponse(
            description = "Успешный запрос",
            responseCode = "200",
        )
    )
    fun movie(
        @Schema(
            description = "ID фильма",
            defaultValue = "tt0133093"
        )
        id: String = "tt0133093"
    ): String

    @Tag(name = "Поиск фильмов по названию и году")
    @ApiResponses(
        ApiResponse(
            description = "Успешный запрос",
            responseCode = "200",
        )
    )
    fun movies(
        @Schema(
            description = "Наименование фильма",
            defaultValue = "Harry"
        )
        title: String = "Harry",
        @Schema(
            description = "Год выпуска фильма",
            defaultValue = "2001"
        )
        year: String = "2004"
    ) : MovieSearch

    @Tag(name = "Поиск сериала по названию и году")
    @ApiResponses(
        ApiResponse(
            description = "Успешный запрос",
            responseCode = "200",
        )
    )
    fun series(
        @Schema(
            description = "Наименование сериала",
            defaultValue = "Friends"
        )
        title: String = "Friends",
        @Schema(
            description = "Год выпуска сериала",
            defaultValue = "1994"
        )
        year: String = "1994"
    ): MovieSearch
}