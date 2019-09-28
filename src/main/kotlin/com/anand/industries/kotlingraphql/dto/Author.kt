package com.anand.industries.kotlingraphql.dto

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "Author")
class Author(

    @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int, val firstName: String, val lastName: String, @OneToMany(
        fetch = FetchType.EAGER,
        cascade= [CascadeType.ALL]
    ) var hobbies: List<Hobbie>

) {

    private constructor(): this(0, "", "", listOf())
}