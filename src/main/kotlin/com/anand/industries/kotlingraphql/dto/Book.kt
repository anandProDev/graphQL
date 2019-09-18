package com.anand.industries.kotlingraphql.dto



data class Author(val id: Int, val firstName: String, val lastName: String, val hobbies: List<Int>)

data class Book(val id: Int, val name: String, val pageCount : Int, val authorId: Int)

data class Hobbie(val id: Int, val name: String)