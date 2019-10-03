package com.anand.industries.kotlingraphql.model

data class Book(
    val id : Int,
    val name: String,
//    val pageCount: Int,
    val authorHref: List<String>
)