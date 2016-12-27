package com.jota.sunshine.data.repository.datasource

import com.jota.sunshine.data.entity.CityForecastEntity
import com.jota.sunshine.data.entity.CityWeatherEntity
import io.reactivex.Observable

interface DataStore {
    fun getCityWeather(latitude: String, longitude: String): Observable<CityWeatherEntity>

    fun getCityForecast(latitude: String, longitude: String): Observable<CityForecastEntity>
}