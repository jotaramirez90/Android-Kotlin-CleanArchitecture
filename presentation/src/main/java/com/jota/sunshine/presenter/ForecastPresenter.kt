package com.jota.sunshine.presenter

import com.jota.sunshine.internal.di.scope.PerFragment
import com.jota.sunshine.view.views.ForecastView
import javax.inject.Inject

@PerFragment
class ForecastPresenter @Inject constructor() : BasePresenter {

    var view: ForecastView? = null

    override fun resume() {
    }

    override fun pause() {
    }

    override fun destroy() {
    }
}