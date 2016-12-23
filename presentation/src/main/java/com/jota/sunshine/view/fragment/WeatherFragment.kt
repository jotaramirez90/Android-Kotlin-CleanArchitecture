package com.jota.sunshine.view.fragment

import android.widget.Toast
import com.jota.sunshine.R
import com.jota.sunshine.internal.di.components.MainComponent
import com.jota.sunshine.presenter.WeatherPresenter
import com.jota.sunshine.view.views.WeatherView
import javax.inject.Inject

class WeatherFragment : BaseFragment(), WeatherView {

    @Inject lateinit var weatherPresenter: WeatherPresenter

    override fun getLayoutResource(): Int {
        return R.layout.fragment_weather
    }

    companion object {
        fun newInstance(): WeatherFragment {
            return WeatherFragment()
        }
    }

    override fun onResume() {
        super.onResume()
        weatherPresenter.resume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        weatherPresenter.destroy()
    }

    override fun initialize() {
        this.getComponent(MainComponent::class.java).inject(this)
        weatherPresenter.view = this
    }

    override fun error(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }
}
