package com.jota.sunshine.presenter

import com.jota.sunshine.internal.di.scope.PerFragment
import com.jota.sunshine.view.views.SettingsView
import javax.inject.Inject

@PerFragment
class SettingsPresenter @Inject constructor() : BasePresenter {

    var view: SettingsView? = null

    override fun resume() {
    }

    override fun pause() {
    }

    override fun destroy() {
    }
}