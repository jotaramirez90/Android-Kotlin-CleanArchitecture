package com.jota.sunshine.data.net

import com.jota.sunshine.data.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestApi @Inject constructor() {

    private val apiService: Api

    init {
        apiService = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BuildConfig.API)
                .build()
                .create(Api::class.java)
    }

}
