package com.andrtw.androidbaseproject.data.model.remote.response


data class NetworkTodo(
    val userId: Int,
    val id: Int,
    val title: String?,
    val completed: Boolean
)
