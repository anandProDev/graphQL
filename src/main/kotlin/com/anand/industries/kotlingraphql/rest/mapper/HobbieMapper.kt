package com.anand.industries.kotlingraphql.rest.mapper

import com.anand.industries.kotlingraphql.dto.Hobbie

object HobbieMapper{
    fun map(hobbie: Hobbie)  =
        with(hobbie) {
            com.anand.industries.kotlingraphql.model.Hobbie(
                id = id,
                name = name
            )
        }
}
