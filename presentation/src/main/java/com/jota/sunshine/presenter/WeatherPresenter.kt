package com.jota.sunshine.presenter

import com.jota.sunshine.Constants.DEFAULT_LATITUDE
import com.jota.sunshine.Constants.DEFAULT_LONGITUDE
import com.jota.sunshine.domain.interactors.DefaultObserver
import com.jota.sunshine.domain.interactors.GetCityWeatherUseCase
import com.jota.sunshine.domain.model.CityWeather
import com.jota.sunshine.internal.di.scope.PerFragment
import com.jota.sunshine.model.mapper.CityWeatherModelDataMapper
import com.jota.sunshine.view.views.WeatherView
import javax.inject.Inject


@PerFragment
class WeatherPresenter @Inject constructor(
        private val getCityWeatherUseCase: GetCityWeatherUseCase,
        private val cityWeatherModelDataMapper: CityWeatherModelDataMapper) : BasePresenter {

    var view: WeatherView? = null

    override fun resume() {
        getCityWeatherUseCase.execute(CityWeatherObserver(),
                GetCityWeatherUseCase.Params.forCityWeather(DEFAULT_LATITUDE, DEFAULT_LONGITUDE))
    }

    override fun pause() {
    }

    override fun destroy() {
        getCityWeatherUseCase.dispose()
        view = null
    }

    private inner class CityWeatherObserver : DefaultObserver<CityWeather>() {

        override fun onError(e: Throwable) {
            view?.error(e.message!!)
        }

        override fun onNext(cityWeather: CityWeather) {
            view?.setCityWeather(cityWeatherModelDataMapper.transform(cityWeather))
        }
    }

}