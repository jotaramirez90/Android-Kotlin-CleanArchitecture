package com.jota.sunshine.view.views

import com.jota.sunshine.model.CityForecastModel

interface ForecastView : BaseView {

    fun setCityForecast(cityForecast: CityForecastModel?)

}