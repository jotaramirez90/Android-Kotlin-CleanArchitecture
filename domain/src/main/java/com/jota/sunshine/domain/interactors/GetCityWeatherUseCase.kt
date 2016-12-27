package com.jota.sunshine.domain.interactors

import com.jota.sunshine.domain.executor.PostExecutionThread
import com.jota.sunshine.domain.executor.ThreadExecutor
import com.jota.sunshine.domain.model.CityWeather
import com.jota.sunshine.domain.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject


class GetCityWeatherUseCase @Inject constructor(threadExecutor: ThreadExecutor,
                                                postExecutionThread: PostExecutionThread,
                                                private val repository: Repository) :
        UseCase<CityWeather, GetCityWeatherUseCase.Params>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Params): Observable<CityWeather> {
        return this.repository.getCityWeather(params.latitude, params.longitude)
    }

    class Params private constructor(val latitude: String, val longitude: String) {
        companion object {

            fun forCityWeather(latitude: String, longitude: String): Params {
                return Params(latitude, longitude)
            }
        }
    }
}