package com.anand.industries.kotlingraphql.dto

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "Hobbie")
class Hobbie(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int, val name: String
) {

    private constructor(): this(0, "")

}