package com.anand.industries.kotlingraphql.model

data class Author(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val hobbieHref : List<String>
)