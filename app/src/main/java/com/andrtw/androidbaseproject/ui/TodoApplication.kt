package com.andrtw.androidbaseproject.ui

import android.app.Application
import com.andrtw.androidbaseproject.di.AppComponent
import com.andrtw.androidbaseproject.di.DaggerAppComponent


open class TodoApplication : Application() {

    val appComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent =
        DaggerAppComponent.factory().create(this)
}