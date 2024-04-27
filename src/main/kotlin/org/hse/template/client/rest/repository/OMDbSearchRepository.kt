package org.hse.template.client.rest.repository

import org.hse.template.client.rest.model.MovieSearch
import org.hse.template.client.rest.model.OMDbSearch
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface OMDbSearchRepository: CrudRepository<OMDbSearch, UUID> {
    @Query("SELECT * FROM omdb_search WHERE title = :title AND year = :year")
    fun findByTitleAndYear(title: String, year: String): OMDbSearch?
}