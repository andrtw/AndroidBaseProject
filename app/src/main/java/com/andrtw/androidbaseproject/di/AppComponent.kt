package com.andrtw.androidbaseproject.di

import com.andrtw.androidbaseproject.di.module.DataSourceModule
import com.andrtw.androidbaseproject.di.module.NetworkModule
import com.andrtw.androidbaseproject.di.module.RoomModule
import com.andrtw.androidbaseproject.di.module.ViewModelModule
import com.andrtw.androidbaseproject.ui.MainFragment
import com.andrtw.androidbaseproject.ui.TodoApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        NetworkModule::class,
        RoomModule::class,
        DataSourceModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: TodoApplication): AppComponent
    }

    fun inject(mainFragment: MainFragment)
}