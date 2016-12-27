package com.jota.sunshine.view.views

import com.jota.sunshine.model.CityWeatherModel

interface WeatherView : BaseView {

    fun setCityWeather(cityWeather: CityWeatherModel?)

}