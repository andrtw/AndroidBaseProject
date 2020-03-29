package com.andrtw.androidbaseproject.data.service

import com.andrtw.androidbaseproject.data.model.remote.response.NetworkTodo
import retrofit2.http.GET


interface TodoService {

    @GET("todos")
    suspend fun getTodos(): List<NetworkTodo>
}