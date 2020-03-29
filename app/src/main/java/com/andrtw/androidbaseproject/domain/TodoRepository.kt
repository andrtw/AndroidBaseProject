package com.andrtw.androidbaseproject.domain

import com.andrtw.androidbaseproject.data.source.HasErrorHandling
import com.andrtw.androidbaseproject.domain.model.Todo
import kotlinx.coroutines.flow.Flow


interface TodoRepository : HasErrorHandling {

    fun observeTodos(): Flow<List<Todo>>

    fun observeTodo(id: Int): Flow<Todo>

    suspend fun fetchTodos()

    suspend fun updateTodo(todo: Todo)
}