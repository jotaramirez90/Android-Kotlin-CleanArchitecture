package com.jota.sunshine.view.fragment

import android.widget.Toast
import com.jota.sunshine.R
import com.jota.sunshine.internal.di.components.MainComponent
import com.jota.sunshine.presenter.SettingsPresenter
import com.jota.sunshine.view.views.SettingsView
import javax.inject.Inject

class SettingsFragment : BaseFragment(), SettingsView {

    @Inject lateinit var settingsPresenter: SettingsPresenter

    override fun getLayoutResource(): Int {
        return R.layout.fragment_settings
    }

    companion object {
        fun newInstance(): SettingsFragment {
            return SettingsFragment()
        }
    }

    override fun onResume() {
        super.onResume()
        settingsPresenter.resume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        settingsPresenter.destroy()
    }

    override fun initialize() {
        this.getComponent(MainComponent::class.java).inject(this)
        settingsPresenter.view = this
    }

    override fun error(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }
}