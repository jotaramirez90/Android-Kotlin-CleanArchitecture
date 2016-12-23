package com.jota.sunshine.view.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import com.jota.sunshine.AndroidApplication
import com.jota.sunshine.internal.di.components.ApplicationComponent
import com.jota.sunshine.internal.di.modules.ActivityModule
import com.jota.sunshine.navigation.Navigator
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @Inject lateinit var navigator: Navigator

    abstract fun getLayoutResource(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())
    }

    protected fun replaceFragment(containerViewId: Int, fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(containerViewId, fragment)
        fragmentTransaction.commit()
    }

    fun enableHomeAsUp() {
        (supportActionBar as ActionBar)?.setDisplayHomeAsUpEnabled(true)
    }

    protected fun getApplicationComponent(): ApplicationComponent {
        return (application as AndroidApplication).applicationComponent
    }

    protected fun getActivityModule(): ActivityModule {
        return ActivityModule(this)
    }
}