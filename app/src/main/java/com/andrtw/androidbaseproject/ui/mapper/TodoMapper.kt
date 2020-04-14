package com.andrtw.androidbaseproject.ui.mapper

import com.andrtw.androidbaseproject.R
import com.andrtw.androidbaseproject.domain.model.Todo
import com.andrtw.androidbaseproject.ui.model.UiTodo


fun Todo.asUiModel() = UiTodo(
    id = id,
    userId = userId,
    title = title,
    isCompleted = completed,
    image = if (completed) R.drawable.ic_done else R.drawable.ic_close
)

fun UiTodo.asDomainModel() = Todo(
    userId = userId,
    id = id,
    title = title,
    completed = isCompleted
)
