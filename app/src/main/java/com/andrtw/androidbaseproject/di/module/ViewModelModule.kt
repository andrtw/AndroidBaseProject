package com.andrtw.androidbaseproject.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andrtw.androidbaseproject.di.provider.ViewModelFactory
import com.andrtw.androidbaseproject.di.qualifier.ViewModelKey
import com.andrtw.androidbaseproject.ui.viewmodel.TodoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(TodoViewModel::class)
    abstract fun bindTodoViewModel(todoViewModel: TodoViewModel): ViewModel
}