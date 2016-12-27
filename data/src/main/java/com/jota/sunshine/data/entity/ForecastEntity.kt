package com.jota.sunshine.data.entity

open class ForecastEntity {

    open var dt: Int? = null
    open var main: MainEntity? = null
    open var weather: Array<WeatherEntity>? = null

}