package com.jota.sunshine.presenter

import com.jota.sunshine.internal.di.scope.PerFragment
import com.jota.sunshine.view.views.WeatherView
import javax.inject.Inject

@PerFragment
class WeatherPresenter @Inject constructor() : BasePresenter {

    var view: WeatherView? = null

    override fun resume() {
    }

    override fun pause() {
    }

    override fun destroy() {
    }

}