package com.jota.sunshine.internal.di.modules

import android.app.Activity
import com.jota.sunshine.internal.di.scope.PerActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val baseActivity: Activity) {

    @Provides
    @PerActivity
    internal fun provideActivity(): Activity {
        return this.baseActivity
    }
}