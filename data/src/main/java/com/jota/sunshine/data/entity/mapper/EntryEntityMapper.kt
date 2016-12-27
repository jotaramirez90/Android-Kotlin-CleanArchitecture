package com.jota.sunshine.data.entity.mapper

import java.util.*

abstract class EntryEntityMapper<Model, Entity> {

    abstract fun transform(entity: Entity?): Model?

    fun transform(collection: Array<Entity>?): ArrayList<Model> {
        val list = ArrayList<Model>()
        var model: Model?
        for (entity in collection!!) {
            model = transform(entity)
            if (model != null) {
                list.add(model)
            }
        }
        return list
    }
}