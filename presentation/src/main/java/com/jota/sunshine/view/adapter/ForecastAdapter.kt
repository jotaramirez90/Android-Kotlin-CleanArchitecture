package com.jota.sunshine.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jota.sunshine.Constants.SYMBOL_C
import com.jota.sunshine.Constants.SYMBOL_HOUR
import com.jota.sunshine.R
import com.jota.sunshine.model.ForecastModel
import com.jota.sunshine.view.utils.DateUtils
import com.jota.sunshine.view.utils.WeatherUtils
import kotlinx.android.synthetic.main.item_forecast.view.*
import java.util.*

class ForecastAdapter(val forecastList: ArrayList<ForecastModel>) :
        RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_forecast,
                parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindForecast(forecastList[position])
    }

    override fun getItemCount(): Int {
        return forecastList.size
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindForecast(forecastModel: ForecastModel) {
            with(forecastModel) {
                val layoutItem = itemView.forecastLayout
                layoutItem.iconWeather.setImageDrawable(itemView.context.resources.getDrawable(
                        WeatherUtils.getIconWeather(forecastModel?.weather?.id?.toInt()!!)))
                layoutItem.currentTempText.text = (forecastModel?.main?.temp.toString() + SYMBOL_C)
                val layoutDetails = layoutItem.detailsLayout
                layoutDetails.dateText.text = (DateUtils.getDate(forecastModel?.dt?.toLong())
                        + SYMBOL_HOUR)
                val layoutTemps = layoutDetails.tempLayout
                layoutTemps.maxTempText.text = (forecastModel?.main?.temp_max.toString() + SYMBOL_C)
                layoutTemps.minTempText.text = (forecastModel?.main?.temp_min.toString() + SYMBOL_C)
            }
        }
    }

}