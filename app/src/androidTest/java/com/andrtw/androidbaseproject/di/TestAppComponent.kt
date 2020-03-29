package com.andrtw.androidbaseproject.di

import com.andrtw.androidbaseproject.di.module.DataSourceModule
import com.andrtw.androidbaseproject.di.module.NetworkModule
import com.andrtw.androidbaseproject.di.module.RoomModule
import com.andrtw.androidbaseproject.di.module.ViewModelModule
import com.andrtw.androidbaseproject.ui.TodoApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        RoomModule::class,
        ViewModelModule::class,
        DataSourceModule::class
    ]
)
interface TestAppComponent : AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: TodoApplication): TestAppComponent
    }
}