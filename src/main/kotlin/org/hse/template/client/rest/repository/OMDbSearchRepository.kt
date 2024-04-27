package org.hse.template.client.rest.repository

import org.hse.template.client.rest.model.MovieSearch
import org.springframework.data.repository.CrudRepository

interface MovieSearchRepository: CrudRepository<MovieSearch, Int>{
    fun findAllByTitle(title: String): List<MovieSearch>
}