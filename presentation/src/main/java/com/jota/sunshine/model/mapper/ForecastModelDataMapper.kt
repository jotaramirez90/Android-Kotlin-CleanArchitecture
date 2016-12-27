package com.jota.sunshine.model.mapper

import com.jota.sunshine.domain.model.Forecast
import com.jota.sunshine.model.ForecastModel
import javax.inject.Inject

class ForecastModelDataMapper @Inject
constructor(private val weatherModelDataMapper: WeatherModelDataMapper,
            private val mainModelDataMapper: MainModelDataMapper) :
        EntryModelMapper<ForecastModel, Forecast>() {

    override fun transform(model: Forecast?): ForecastModel? {
        if (model != null) {
            val forecast = ForecastModel()
            forecast.dt = model.dt
            forecast.main = mainModelDataMapper.transform(model.main)
            forecast.weather = weatherModelDataMapper.transform(model.weather)
            return forecast
        }
        return null
    }
}