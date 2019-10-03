package com.anand.industries.kotlingraphql.rest.mapper

import com.anand.industries.kotlingraphql.dto.Hobbie
import com.anand.industries.kotlingraphql.model.Hobbie as HobbieModel

object HobbieMapper{
    fun map(hobbie: Hobbie)  =
        with(hobbie) {
            HobbieModel(
                id = id,
                name = name
            )
        }
}
