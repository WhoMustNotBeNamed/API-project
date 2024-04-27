package org.hse.template.service

import com.fasterxml.jackson.databind.ObjectMapper
import org.hse.template.client.rest.api.OMDbClient
import org.hse.template.client.rest.model.MovieSearch
import org.hse.template.client.rest.model.OMDbSearch
import org.hse.template.client.rest.repository.OMDbSearchRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import kotlin.math.log

@Service
class OMDbService (
    private val omdbSearchRepository: OMDbSearchRepository,
    private val omdbClient: OMDbClient,
    private val objectMapper: ObjectMapper,
) {
    private val logger = LoggerFactory.getLogger(OMDbService::class.java)
    fun movies(title: String, year: String, apiKey: String): MovieSearch {
        val existingData = omdbSearchRepository.findByTitleAndYear(title, year)
        return if (existingData != null) {
            logger.info("Data found in database")
            objectMapper.readValue(existingData.jsonData, MovieSearch::class.java)
        } else {
            val apiResponse = omdbClient.movies(title, year, apiKey)
            val movieData = OMDbSearch(title, year, objectMapper.writeValueAsString(apiResponse))
            omdbSearchRepository.save(movieData)
            apiResponse
        }
    }

    fun series(title: String, year: String, apiKey: String): MovieSearch {
        val existingData = omdbSearchRepository.findByTitleAndYear(title, year)
        return if (existingData != null) {
            logger.info("Data found in database")
            objectMapper.readValue(existingData.jsonData, MovieSearch::class.java)
        } else {
            val apiResponse = omdbClient.series(title, year, apiKey)
            val seriesData = OMDbSearch(title, year, objectMapper.writeValueAsString(apiResponse))
            omdbSearchRepository.save(seriesData)
            apiResponse
        }
    }
}