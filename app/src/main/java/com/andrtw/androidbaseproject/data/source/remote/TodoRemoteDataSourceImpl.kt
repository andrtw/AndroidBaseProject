package com.andrtw.androidbaseproject.data.source.remote

import androidx.lifecycle.MutableLiveData
import com.andrtw.androidbaseproject.data.mapper.asDomainModel
import com.andrtw.androidbaseproject.data.service.TodoService
import com.andrtw.androidbaseproject.domain.model.ErrorType
import com.andrtw.androidbaseproject.domain.model.Todo
import com.andrtw.androidbaseproject.ui.util.Event
import javax.inject.Inject


class TodoRemoteDataSourceImpl @Inject constructor(
    private val service: TodoService
) : TodoRemoteDataSource {

    override val error = MutableLiveData<Event<ErrorType>>()

    override suspend fun getTodos(): List<Todo>? = try {
        service.getTodos().map { it.asDomainModel() }
    } catch (e: Exception) {
        error.value = Event(ErrorType.FETCH_TODOS)
        null
    }
}