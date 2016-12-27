package com.jota.sunshine.model.mapper

import com.jota.sunshine.domain.model.Sys
import com.jota.sunshine.model.SysModel
import javax.inject.Inject

class SysModelDataMapper @Inject constructor() : EntryModelMapper<SysModel, Sys>() {

    override fun transform(model: Sys?): SysModel? {
        if (model != null) {
            val sysModel = SysModel()
            sysModel.type = model.type
            sysModel.id = model.id
            sysModel.message = model.message
            sysModel.country = model.country
            sysModel.sunrise = model.sunrise
            sysModel.sunset = model.sunset
            return sysModel
        }
        return null
    }
}