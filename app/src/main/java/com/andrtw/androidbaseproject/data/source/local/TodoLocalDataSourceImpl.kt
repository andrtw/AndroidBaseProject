package com.andrtw.androidbaseproject.data.source.local

import com.andrtw.androidbaseproject.data.mapper.asDomainModel
import com.andrtw.androidbaseproject.data.mapper.asLocalModel
import com.andrtw.androidbaseproject.domain.model.Todo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class TodoLocalDataSourceImpl @Inject constructor(
    private val dao: TodoDao
) : TodoLocalDataSource {

    override fun observeTodos(): Flow<List<Todo>> = dao.observeTodos().map { todos ->
        todos.map { todo -> todo.asDomainModel() }
    }

    @ExperimentalCoroutinesApi
    override fun observeTodo(id: Int): Flow<Todo> =
        dao.observeTodoDistinctUntilChanged(id).map { it.asDomainModel() }

    override suspend fun insertTodos(todos: List<Todo>) {
        dao.insertTodos(todos.map { it.asLocalModel() })
    }

    override suspend fun updateTodo(todo: Todo) {
        dao.updateTodo(todo.asLocalModel())
    }
}