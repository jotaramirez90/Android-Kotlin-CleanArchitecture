package com.jota.sunshine.model.mapper

import com.jota.sunshine.domain.model.City
import com.jota.sunshine.model.CityModel
import javax.inject.Inject

class CityModelDataMapper @Inject
constructor(private val coordinatesModelDataMapper: CoordinatesModelDataMapper) :
        EntryModelMapper<CityModel, City>() {

    override fun transform(model: City?): CityModel? {
        if (model != null) {
            val cityModel = CityModel()
            cityModel.id = model.id
            cityModel.name = model.name
            cityModel.coord = coordinatesModelDataMapper.transform(model.coord)
            cityModel.country = model.country
            return cityModel
        }
        return null
    }
}