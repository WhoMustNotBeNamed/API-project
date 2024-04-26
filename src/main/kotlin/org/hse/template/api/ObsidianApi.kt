package org.hse.template.api

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.hse.template.client.rest.model.ObsidianFiles

@Tag(name = "Obsidian" , description = "API для работы с заметками в Obsidian")
interface ObsidianApi {
    @Operation(summary = "Все заметки")
    @ApiResponses(
        ApiResponse(
            description = "Успешный запрос",
            responseCode = "200",
        )
    )
    fun getVaults(): ObsidianFiles

    @Operation(summary = "Открыть заметку")
    @ApiResponses(
        ApiResponse(
            description = "Успешный запрос",
            responseCode = "200",
        )
    )
    fun openVault(
        @Schema(
            description = "Наименование заметки",
            defaultValue = "Welcome.md"
        )
        name: String = "Welcome.md"
    ): String

    @Operation(summary = "Создать заметку или дополнить существующую")
    @ApiResponses(
        ApiResponse(
            description = "Успешный запрос",
            responseCode = "200",
        )
    )
    fun createVault(
        @Schema(
            description = "Наименование заметки",
            defaultValue = "test.md"
        )
        name: String = "test.md",
        @Schema(
            description = "Текст заметки",
            defaultValue = "Hello, World!"
        )
        text: String = "Hello, World!"
    )

    @Operation(summary = "Удалить заметку")
    @ApiResponses(
        ApiResponse(
            description = "Успешный запрос",
            responseCode = "200",
        )
    )
    fun deleteVault(
        @Schema(
            description = "Наименование заметки",
            defaultValue = "test.md"
        )
        name: String = "test.md"
    )
}