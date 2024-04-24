package org.hse.template.client.rest.api

import feign.Headers
import feign.RequestLine
import org.hse.template.client.rest.model.ObsidianFiles
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "obsidianNotes", url = "https://127.0.0.1:27124")
@Headers("Authorization: Bearer X")
interface ObsidianNotesClient {

    @GetMapping("vault")
    @Headers("Authorization: X")
    fun getVaults(/*@RequestHeader("Authorization") bearerToken: */): ObsidianFiles
}