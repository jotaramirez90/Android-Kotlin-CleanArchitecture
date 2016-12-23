package com.jota.sunshine.internal.di.components

import android.app.Activity
import com.jota.sunshine.internal.di.modules.ActivityModule
import com.jota.sunshine.internal.di.scope.PerActivity
import dagger.Component

@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun activity(): Activity
}