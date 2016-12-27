package com.jota.sunshine.data.entity.mapper

import com.jota.sunshine.data.entity.CityWeatherEntity
import com.jota.sunshine.domain.model.CityWeather
import javax.inject.Inject
import javax.inject.Singleton

@Singleton class CityWeatherEntityDataMapper @Inject constructor(
        private val coordinatesEntityDataMapper: CoordinatesEntityDataMapper,
        private val weatherEntityDataMapper: WeatherEntityDataMapper,
        private val mainEntityDataMapper: MainEntityDataMapper,
        private val cloudsEntityDataMapper: CloudsEntityDataMapper,
        private val sysEntityDataMapper: SysEntityDataMapper) :
        EntryEntityMapper<CityWeather, CityWeatherEntity>() {

    override fun transform(entity: CityWeatherEntity?): CityWeather? {
        if (entity != null) {
            val cityWeather = CityWeather()
            cityWeather.coord = coordinatesEntityDataMapper.transform(entity.coord)
            cityWeather.weather = weatherEntityDataMapper.transform(entity.weather!![0])
            cityWeather.base = entity.base
            cityWeather.main = mainEntityDataMapper.transform(entity.main)
            cityWeather.visibility = entity.visibility
            cityWeather.clouds = cloudsEntityDataMapper.transform(entity.clouds)
            cityWeather.dt = entity.dt
            cityWeather.sys = sysEntityDataMapper.transform(entity.sys)
            cityWeather.id = entity.id
            cityWeather.name = entity.name
            cityWeather.cod = entity.cod
            return cityWeather
        }
        return null
    }
}