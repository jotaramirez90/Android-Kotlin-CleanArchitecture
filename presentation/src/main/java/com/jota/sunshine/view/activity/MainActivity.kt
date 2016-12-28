package com.jota.sunshine.view.activity

import android.os.Bundle
import com.jota.sunshine.R
import com.jota.sunshine.internal.di.HasComponent
import com.jota.sunshine.internal.di.components.DaggerMainComponent
import com.jota.sunshine.internal.di.components.MainComponent
import com.jota.sunshine.internal.di.modules.MainModule
import com.jota.sunshine.view.fragment.ForecastFragment
import com.jota.sunshine.view.fragment.InfoFragment
import com.jota.sunshine.view.fragment.WeatherFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), HasComponent<MainComponent> {
    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeActivity()
    }

    private fun initializeActivity() {
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_weather ->
                    replaceFragment(R.id.container, WeatherFragment.newInstance())
                R.id.action_forecast ->
                    replaceFragment(R.id.container, ForecastFragment.newInstance())
                R.id.action_info ->
                    replaceFragment(R.id.container, InfoFragment.newInstance())
            }
            true
        }
        replaceFragment(R.id.container, WeatherFragment.newInstance())
    }

    private val mainComponent: MainComponent get() = DaggerMainComponent.builder()
            .applicationComponent(getApplicationComponent())
            .activityModule(getActivityModule())
            .mainModule(MainModule())
            .build()

    override fun getComponent(): MainComponent {
        return mainComponent
    }
}
