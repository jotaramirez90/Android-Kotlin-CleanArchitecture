package com.jota.sunshine.data.entity.mapper

import com.jota.sunshine.data.entity.CoordinatesEntity
import com.jota.sunshine.domain.model.Coordinates
import javax.inject.Inject
import javax.inject.Singleton

@Singleton class CoordinatesEntityDataMapper @Inject constructor() :
        EntryEntityMapper<Coordinates, CoordinatesEntity>() {

    override fun transform(entity: CoordinatesEntity?): Coordinates? {
        if (entity != null) {
            val coordinates = Coordinates()
            coordinates.lon = entity.lon
            coordinates.lat = entity.lat
            return coordinates
        }
        return null
    }
}