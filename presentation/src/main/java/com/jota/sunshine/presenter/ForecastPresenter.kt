package com.jota.sunshine.presenter

import com.jota.sunshine.Constants.DEFAULT_LATITUDE
import com.jota.sunshine.Constants.DEFAULT_LONGITUDE
import com.jota.sunshine.domain.interactors.DefaultObserver
import com.jota.sunshine.domain.interactors.GetCityForecastUseCase
import com.jota.sunshine.domain.model.CityForecast
import com.jota.sunshine.internal.di.scope.PerFragment
import com.jota.sunshine.model.mapper.CityForecastModelDataMapper
import com.jota.sunshine.view.views.ForecastView
import javax.inject.Inject

@PerFragment
class ForecastPresenter @Inject constructor(
        private val getCityForecastUseCase: GetCityForecastUseCase,
        private val cityForecastModelDataMapper: CityForecastModelDataMapper) : BasePresenter {

    var view: ForecastView? = null

    override fun resume() {
        getCityForecastUseCase.execute(CityForecastObserver(),
                GetCityForecastUseCase.Params.forCityWeather(DEFAULT_LATITUDE, DEFAULT_LONGITUDE))
    }

    override fun pause() {
    }

    override fun destroy() {
        getCityForecastUseCase.dispose()
        view = null
    }

    private inner class CityForecastObserver : DefaultObserver<CityForecast>() {
        override fun onError(exception: Throwable) {
            super.onError(exception)
            view?.error(exception.message!!)
        }

        override fun onNext(cityForecast: CityForecast) {
            super.onNext(cityForecast)
            view?.setCityForecast(cityForecastModelDataMapper.transform(cityForecast))
        }
    }
}