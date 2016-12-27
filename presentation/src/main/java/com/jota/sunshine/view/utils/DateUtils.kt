package com.jota.sunshine.view.utils

import java.text.SimpleDateFormat
import java.util.*

class DateUtils {

    companion object {
        fun getDate(time: Long?): String {
            val cal: Calendar = Calendar.getInstance()
            val tz: TimeZone = TimeZone.getDefault()
            cal.timeInMillis = time!! * 1000
            cal.add(Calendar.MILLISECOND, tz.getOffset(cal.timeInMillis))
            val sdf: SimpleDateFormat = SimpleDateFormat("dd/MM - HH:mm")
            val date: Date = cal.time
            return sdf.format(date)
        }
    }
}