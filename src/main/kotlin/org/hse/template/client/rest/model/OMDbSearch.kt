package org.hse.template.client.rest.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("omdb_search")
class OMDbSearch (
    @Id
    @Column("id")
    var id: UUID? = null,
    @Column("title")
    var title: String,
    @Column("year")
    var year: String,
    @Column("json_data")
    val jsonData: String
) {
    constructor(title: String, year : String, jsonData: String) : this(null, title, year, jsonData)
}