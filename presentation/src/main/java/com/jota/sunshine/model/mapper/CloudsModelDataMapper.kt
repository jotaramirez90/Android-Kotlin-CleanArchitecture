package com.jota.sunshine.model.mapper

import com.jota.sunshine.domain.model.Clouds
import com.jota.sunshine.model.CloudsModel
import javax.inject.Inject

class CloudsModelDataMapper @Inject constructor() : EntryModelMapper<CloudsModel, Clouds>() {

    override fun transform(model: Clouds?): CloudsModel? {
        if (model != null) {
            val cloudsModel = CloudsModel()
            cloudsModel.all = model.all
            return cloudsModel
        }
        return null
    }
}