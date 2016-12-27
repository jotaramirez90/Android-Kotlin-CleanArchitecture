package com.jota.sunshine.data.entity.mapper

import com.jota.sunshine.data.entity.ForecastEntity
import com.jota.sunshine.domain.model.Forecast
import javax.inject.Inject
import javax.inject.Singleton

@Singleton class ForecastEntityDataMapper @Inject
constructor(private val mainEntityDataMapper: MainEntityDataMapper,
            private val weatherEntityDataMapper: WeatherEntityDataMapper) :
        EntryEntityMapper<Forecast, ForecastEntity>() {

    override fun transform(entity: ForecastEntity?): Forecast? {
        if (entity != null) {
            val forecast = Forecast()
            forecast.dt = entity.dt
            forecast.main = mainEntityDataMapper.transform(entity.main)
            forecast.weather = weatherEntityDataMapper.transform(entity.weather!![0])
            return forecast
        }
        return null
    }
}