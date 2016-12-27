package com.jota.sunshine.view.utils

import com.jota.sunshine.R

class WeatherUtils {

    companion object {
        fun getIconWeather(code: Int): Int {
            var resourceId: Int = 0
            if (code >= 200 && code < 300) {
                resourceId = R.drawable.ic_thunderstorm
            }else if (code >= 300 && code < 400){
                resourceId = R.drawable.ic_rain_shower
            }else if (code >= 500 && code < 600){
                resourceId = R.drawable.ic_rain
            }else if (code>= 600 && code < 700){
                resourceId = R.drawable.ic_mist
            }else if (code== 800){
                resourceId = R.drawable.ic_clear
            }else if (code >=801 && code<805){
                resourceId = R.drawable.ic_clouds
            }
            return resourceId
        }
    }

}

