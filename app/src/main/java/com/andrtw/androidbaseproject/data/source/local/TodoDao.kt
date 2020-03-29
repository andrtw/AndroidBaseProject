package com.andrtw.androidbaseproject.data.source.local

import androidx.room.*
import com.andrtw.androidbaseproject.data.model.local.LocalTodo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged


@Dao
abstract class TodoDao {

    @Query("SELECT * FROM todos")
    abstract fun observeTodos(): Flow<List<LocalTodo>>

    @Query("SELECT * FROM todos WHERE id = :id")
    abstract fun observeTodo(id: Int): Flow<LocalTodo>

    @ExperimentalCoroutinesApi
    fun observeTodoDistinctUntilChanged(id: Int): Flow<LocalTodo> =
        observeTodo(id).distinctUntilChanged()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertTodos(todos: List<LocalTodo>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun updateTodo(todo: LocalTodo)

    @Delete
    abstract suspend fun deleteTodo(todo: LocalTodo)
}