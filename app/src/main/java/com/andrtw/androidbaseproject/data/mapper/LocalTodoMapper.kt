package com.andrtw.androidbaseproject.data.mapper

import com.andrtw.androidbaseproject.data.model.local.LocalTodo
import com.andrtw.androidbaseproject.domain.model.Todo


fun Todo.asLocalModel() = LocalTodo(
    id = id,
    userId = userId,
    title = title,
    completed = completed
)

fun LocalTodo.asDomainModel() = Todo(
    userId = userId,
    id = id,
    title = title,
    completed = completed
)
