package org.hse.template.client.rest.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

data class MovieSearch(
    @JsonProperty("Search")
    @Schema(description = "Список фильмов")
    val search: List<MovieSearchItem>,
    @JsonProperty("totalResults")
    @Schema(description = "Общее количество результатов")
    val totalResults: String,
    @JsonProperty("Response")
    @Schema(description = "Статус ответа")
    val response: String
)