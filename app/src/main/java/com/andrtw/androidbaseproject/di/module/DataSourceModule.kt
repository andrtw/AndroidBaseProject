package com.andrtw.androidbaseproject.di.module

import com.andrtw.androidbaseproject.data.source.TodoRepositoryImpl
import com.andrtw.androidbaseproject.data.source.local.TodoLocalDataSource
import com.andrtw.androidbaseproject.data.source.local.TodoLocalDataSourceImpl
import com.andrtw.androidbaseproject.data.source.remote.TodoRemoteDataSource
import com.andrtw.androidbaseproject.data.source.remote.TodoRemoteDataSourceImpl
import com.andrtw.androidbaseproject.domain.TodoRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindTodoRemoteDataSource(todoRemoteDataSource: TodoRemoteDataSourceImpl): TodoRemoteDataSource

    @Singleton
    @Binds
    abstract fun bindTodoLocalDataSource(todoLocalDataSource: TodoLocalDataSourceImpl): TodoLocalDataSource

    @Singleton
    @Binds
    abstract fun bindTodoRepository(todoRepository: TodoRepositoryImpl): TodoRepository
}