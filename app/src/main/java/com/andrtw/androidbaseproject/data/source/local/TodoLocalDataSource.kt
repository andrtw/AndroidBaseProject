package com.andrtw.androidbaseproject.data.source.local

import com.andrtw.androidbaseproject.domain.model.Todo
import kotlinx.coroutines.flow.Flow


interface TodoLocalDataSource {

    fun observeTodos(): Flow<List<Todo>>

    fun observeTodo(id: Int): Flow<Todo>

    suspend fun insertTodos(todos: List<Todo>)

    suspend fun updateTodo(todo: Todo)
}