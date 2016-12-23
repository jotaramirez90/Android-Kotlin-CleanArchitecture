package com.jota.sunshine.internal.di.components

import com.jota.sunshine.internal.di.modules.ActivityModule
import com.jota.sunshine.internal.di.modules.MainModule
import com.jota.sunshine.internal.di.scope.PerFragment
import com.jota.sunshine.view.activity.MainActivity
import com.jota.sunshine.view.fragment.ForecastFragment
import com.jota.sunshine.view.fragment.SettingsFragment
import com.jota.sunshine.view.fragment.WeatherFragment
import dagger.Component

@PerFragment
@Component(dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ActivityModule::class, MainModule::class))
interface MainComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(weatherFragment: WeatherFragment)

    fun inject(forecastFragment: ForecastFragment)

    fun inject(settingsFragment: SettingsFragment)
}