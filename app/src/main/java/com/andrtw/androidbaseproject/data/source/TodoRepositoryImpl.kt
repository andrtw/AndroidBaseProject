package com.andrtw.androidbaseproject.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.andrtw.androidbaseproject.data.source.local.TodoLocalDataSource
import com.andrtw.androidbaseproject.data.source.remote.TodoRemoteDataSource
import com.andrtw.androidbaseproject.domain.TodoRepository
import com.andrtw.androidbaseproject.domain.model.ErrorType
import com.andrtw.androidbaseproject.domain.model.Todo
import com.andrtw.androidbaseproject.ui.util.Event
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class TodoRepositoryImpl @Inject constructor(
    private val remoteDataSource: TodoRemoteDataSource,
    private val localDataSource: TodoLocalDataSource
) : TodoRepository {

    override val error: LiveData<Event<ErrorType>> = liveData {
        emitSource(remoteDataSource.error)
    }

    override fun observeTodos(): Flow<List<Todo>> = localDataSource.observeTodos()

    override fun observeTodo(id: Int): Flow<Todo> = localDataSource.observeTodo(id)

    override suspend fun fetchTodos() {
        remoteDataSource.getTodos()?.let { localDataSource.insertTodos(it) }
    }

    override suspend fun updateTodo(todo: Todo) {
        localDataSource.updateTodo(todo)
    }
}