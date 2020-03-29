package com.andrtw.androidbaseproject.di.module

import androidx.room.Room
import com.andrtw.androidbaseproject.data.source.local.AppDatabase
import com.andrtw.androidbaseproject.data.source.local.TodoDao
import com.andrtw.androidbaseproject.ui.TodoApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideAppDatabase(application: TodoApplication): AppDatabase =
        Room.databaseBuilder(
            application.applicationContext,
            AppDatabase::class.java,
            "app-database"
        ).build()

    @Singleton
    @Provides
    fun provideTodoDao(appDatabase: AppDatabase): TodoDao =
        appDatabase.todoDao()
}