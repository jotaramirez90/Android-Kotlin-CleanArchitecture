package com.jota.sunshine.data.repository.datasource

import com.jota.sunshine.data.net.RestApi
import javax.inject.Inject

class DataFactory @Inject constructor(private val restApi: RestApi) {

    fun createCloudDataStore(): CloudDataStore {
        return CloudDataStore(restApi)
    }
}