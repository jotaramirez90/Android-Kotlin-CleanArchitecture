package com.jota.sunshine.internal.di.components

import android.content.Context
import com.jota.sunshine.AndroidApplication
import com.jota.sunshine.domain.executor.PostExecutionThread
import com.jota.sunshine.domain.executor.ThreadExecutor
import com.jota.sunshine.domain.repository.Repository
import com.jota.sunshine.internal.di.modules.ApplicationModule
import com.jota.sunshine.navigation.Navigator
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(androidApplication: AndroidApplication)

    val androidApplication: AndroidApplication

    fun context(): Context

    fun navigator(): Navigator

    fun threadExecutor(): ThreadExecutor

    fun postExecutionThread(): PostExecutionThread

    fun Repository(): Repository
}