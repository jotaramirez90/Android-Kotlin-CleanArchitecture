package com.jota.sunshine.data.net

import com.jota.sunshine.data.BuildConfig
import com.jota.sunshine.data.entity.CityForecastEntity
import com.jota.sunshine.data.entity.CityWeatherEntity
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestApi @Inject constructor() {

    private val apiService: Api
    private var units: String = "metric"

    init {
        apiService = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BuildConfig.API)
                .build()
                .create(Api::class.java)
    }

    fun getCityWeather(latitude: String, longitude: String): Observable<CityWeatherEntity> {
        return apiService.getCityWeather(latitude, longitude, units, BuildConfig.APPID)
    }

    fun getCityForecast(latitude: String, longitude: String): Observable<CityForecastEntity> {
        return apiService.getCityForecast(latitude, longitude, units, BuildConfig.APPID)
    }
}
