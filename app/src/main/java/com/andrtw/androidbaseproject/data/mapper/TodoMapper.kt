package com.andrtw.androidbaseproject.data.mapper

import com.andrtw.androidbaseproject.data.model.remote.response.NetworkTodo
import com.andrtw.androidbaseproject.domain.model.Todo


fun NetworkTodo.asDomainModel() = Todo(
    userId = userId,
    id = id,
    title = title,
    completed = completed
)
