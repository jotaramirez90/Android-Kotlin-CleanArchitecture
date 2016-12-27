package com.jota.sunshine.data.entity

open class CityWeatherEntity {

    open var coord: CoordinatesEntity? = null
    open var weather: Array<WeatherEntity>? = null
    open var base: String? = null
    open var main: MainEntity? = null
    open var visibility: Int? = null
    open var clouds: CloudsEntity? = null
    open var dt: Int? = null
    open var sys: SysEntity? = null
    open var id: Int? = null
    open var name: String? = null
    open var cod: Int? = null

}
