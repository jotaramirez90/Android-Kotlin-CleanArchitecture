package com.jota.sunshine.data.entity.mapper

import com.jota.sunshine.data.entity.CloudsEntity
import com.jota.sunshine.domain.model.Clouds
import javax.inject.Inject
import javax.inject.Singleton

@Singleton class CloudsEntityDataMapper @Inject constructor() : EntryEntityMapper<Clouds, CloudsEntity>() {

    override fun transform(entity: CloudsEntity?): Clouds? {
        if (entity != null) {
            val clouds = Clouds()
            clouds.all = entity.all
            return clouds
        }
        return null
    }
}