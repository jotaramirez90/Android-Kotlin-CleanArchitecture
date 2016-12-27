package com.jota.sunshine.domain.interactors

import com.jota.sunshine.domain.executor.PostExecutionThread
import com.jota.sunshine.domain.executor.ThreadExecutor
import com.jota.sunshine.domain.model.CityForecast
import com.jota.sunshine.domain.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject

class GetCityForecastUseCase @Inject constructor(threadExecutor: ThreadExecutor,
                                                 postExecutionThread: PostExecutionThread,
                                                 private val repository: Repository) :
        UseCase<CityForecast, GetCityForecastUseCase.Params>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Params): Observable<CityForecast> {
        return this.repository.getCityForecast(params.latitude, params.longitude)
    }

    class Params private constructor(val latitude: String, val longitude: String) {
        companion object {

            fun forCityWeather(latitude: String, longitude: String): Params {
                return Params(latitude, longitude)
            }
        }
    }
}