package com.jota.sunshine.internal.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.jota.sunshine.AndroidApplication
import com.jota.sunshine.Constants
import com.jota.sunshine.UIThread
import com.jota.sunshine.data.executor.JobExecutor
import com.jota.sunshine.data.repository.DataRepository
import com.jota.sunshine.domain.executor.PostExecutionThread
import com.jota.sunshine.domain.executor.ThreadExecutor
import com.jota.sunshine.domain.repository.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val androidApplication: AndroidApplication) {

    @Provides
    @Singleton
    fun application(): AndroidApplication {
        return androidApplication
    }

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return androidApplication
    }

    @Provides
    @Singleton
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @Singleton
    fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences {
        return androidApplication.getSharedPreferences(Constants.SHARE_PREF, Context.MODE_APPEND)
    }

    @Provides
    @Singleton
    fun provideRepository(dataRepository: DataRepository): Repository {
        return dataRepository
    }

}
