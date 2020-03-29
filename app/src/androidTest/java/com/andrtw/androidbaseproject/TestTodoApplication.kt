package com.andrtw.androidbaseproject

import com.andrtw.androidbaseproject.di.AppComponent
import com.andrtw.androidbaseproject.di.DaggerTestAppComponent
import com.andrtw.androidbaseproject.ui.TodoApplication


class TestTodoApplication : TodoApplication() {

    override fun initializeComponent(): AppComponent =
        DaggerTestAppComponent.factory().create(this)
}