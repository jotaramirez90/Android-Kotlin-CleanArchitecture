package com.jota.sunshine.view.fragment

import android.widget.Toast
import com.jota.sunshine.R
import com.jota.sunshine.internal.di.components.MainComponent
import com.jota.sunshine.presenter.ForecastPresenter
import com.jota.sunshine.view.views.ForecastView
import javax.inject.Inject

class ForecastFragment : BaseFragment(), ForecastView {

    @Inject lateinit var forecastPresenter: ForecastPresenter

    override fun getLayoutResource(): Int {
        return R.layout.fragment_forecast
    }

    companion object {
        fun newInstance(): ForecastFragment {
            return ForecastFragment()
        }
    }

    override fun onResume() {
        super.onResume()
        forecastPresenter.resume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        forecastPresenter.destroy()
    }

    override fun initialize() {
        this.getComponent(MainComponent::class.java).inject(this)
        forecastPresenter.view = this
    }

    override fun error(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }
}