package com.jota.sunshine.data.repository.datasource

import com.jota.sunshine.data.entity.CityForecastEntity
import com.jota.sunshine.data.entity.CityWeatherEntity
import com.jota.sunshine.data.net.RestApi
import io.reactivex.Observable

class CloudDataStore(private val restApi: RestApi) : DataStore {

    override fun getCityWeather(latitude: String, longitude: String): Observable<CityWeatherEntity> {
        return restApi.getCityWeather(latitude, longitude)
    }

    override fun getCityForecast(latitude: String, longitude: String): Observable<CityForecastEntity> {
        return restApi.getCityForecast(latitude, longitude)
    }
}