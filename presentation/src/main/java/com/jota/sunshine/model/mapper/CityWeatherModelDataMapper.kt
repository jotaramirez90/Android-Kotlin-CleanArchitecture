package com.jota.sunshine.model.mapper

import com.jota.sunshine.domain.model.CityWeather
import com.jota.sunshine.model.CityWeatherModel
import javax.inject.Inject

class CityWeatherModelDataMapper @Inject constructor(
        private val coordinatesModelDataMapper: CoordinatesModelDataMapper,
        private val weatherModelDataMapper: WeatherModelDataMapper,
        private val mainModelDataMapper: MainModelDataMapper,
        private val cloudsModelDataMapper: CloudsModelDataMapper,
        private val sysModelDataMapper: SysModelDataMapper) :
        EntryModelMapper<CityWeatherModel, CityWeather>() {

    override fun transform(model: CityWeather?): CityWeatherModel? {
        if (model != null) {
            val cityWeatherModel = CityWeatherModel()
            cityWeatherModel.coord = coordinatesModelDataMapper.transform(model.coord)
            cityWeatherModel.weather = weatherModelDataMapper.transform(model.weather)
            cityWeatherModel.base = model.base
            cityWeatherModel.main = mainModelDataMapper.transform(model.main)
            cityWeatherModel.visibility = model.visibility
            cityWeatherModel.clouds = cloudsModelDataMapper.transform(model.clouds)
            cityWeatherModel.dt = model.dt
            cityWeatherModel.sys = sysModelDataMapper.transform(model.sys)
            cityWeatherModel.id = model.id
            cityWeatherModel.name = model.name
            cityWeatherModel.cod = model.cod
            return cityWeatherModel
        }
        return null
    }
}