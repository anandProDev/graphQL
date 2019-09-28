package com.anand.industries.kotlingraphql.dto

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "Book")
class Book(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int, val name: String, val pageCount: Int, @OneToMany(
        fetch = FetchType.EAGER,
        cascade = [CascadeType.ALL]
    ) var authors: List<Author>) {

    private constructor(): this(0, "", 0, listOf())
}





