package com.jota.sunshine.model.mapper

import com.jota.sunshine.domain.model.Main
import com.jota.sunshine.model.MainModel
import javax.inject.Inject

class MainModelDataMapper @Inject constructor() : EntryModelMapper<MainModel, Main>() {

    override fun transform(model: Main?): MainModel? {
        if (model != null) {
            val mainModel = MainModel()
            mainModel.temp = model.temp
            mainModel.pressure = model.pressure
            mainModel.humidity = model.humidity
            mainModel.temp_min = model.temp_min
            mainModel.temp_max = model.temp_max
            return mainModel
        }
        return null
    }
}