package com.jota.sunshine.data.repository

import com.jota.sunshine.data.entity.mapper.CityWeatherEntityDataMapper
import com.jota.sunshine.data.repository.datasource.DataFactory
import com.jota.sunshine.domain.model.CityWeather
import com.jota.sunshine.domain.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject

class DataRepository
@Inject constructor(private val dataFactory: DataFactory,
                    private val cityWeatherEntityDataMapper: CityWeatherEntityDataMapper) : Repository {

    override fun getCityWeather(latitude: String, longitude: String): Observable<CityWeather> {
        return dataFactory.createCloudDataStore()
                .getCityWeather(latitude, longitude)
                .map { cityWeatherEntityDataMapper.transform(it) }
    }
}