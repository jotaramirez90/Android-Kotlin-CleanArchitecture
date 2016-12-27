package com.jota.sunshine.domain.repository

import com.jota.sunshine.domain.model.CityForecast
import com.jota.sunshine.domain.model.CityWeather
import io.reactivex.Observable

interface Repository {

    fun getCityWeather(latitude: String, longitude: String): Observable<CityWeather>

    fun getCityForecast(latitude: String, longitude: String): Observable<CityForecast>
}
