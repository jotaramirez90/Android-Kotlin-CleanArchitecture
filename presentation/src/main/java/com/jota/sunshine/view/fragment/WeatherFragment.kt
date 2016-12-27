package com.jota.sunshine.view.fragment

import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import com.jota.sunshine.Constants.SYMBOL_C
import com.jota.sunshine.R
import com.jota.sunshine.internal.di.components.MainComponent
import com.jota.sunshine.model.CityWeatherModel
import com.jota.sunshine.presenter.WeatherPresenter
import com.jota.sunshine.view.utils.WeatherUtils
import com.jota.sunshine.view.views.WeatherView
import kotlinx.android.synthetic.main.fragment_weather.*
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

    override fun setCityWeather(cityWeather: CityWeatherModel?) {
        progress_bar.visibility = GONE
        weatherLayout.visibility = VISIBLE
        iconWeather.setImageDrawable(context.resources.getDrawable(
                WeatherUtils.getIconWeather(cityWeather?.weather?.id?.toInt()!!)))
        cityText.text = cityWeather?.name
        tempText.text = (cityWeather?.main?.temp.toString() + SYMBOL_C)
        maxTempText.text = (cityWeather?.main?.temp_max.toString() + SYMBOL_C)
        minTempText.text = (cityWeather?.main?.temp_min.toString() + SYMBOL_C)
    }

    override fun error(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }
}
