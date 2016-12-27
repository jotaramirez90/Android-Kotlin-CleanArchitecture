package com.jota.sunshine.model.mapper

import com.jota.sunshine.domain.model.Weather
import com.jota.sunshine.model.WeatherModel
import javax.inject.Inject

class WeatherModelDataMapper @Inject constructor() : EntryModelMapper<WeatherModel, Weather>() {

    override fun transform(model: Weather?): WeatherModel? {
        if (model != null) {
            val weatherModel = WeatherModel()
            weatherModel.id = model.id
            weatherModel.main = model.main
            weatherModel.description = model.description
            weatherModel.icon = model.icon
            return weatherModel
        }
        return null
    }
}