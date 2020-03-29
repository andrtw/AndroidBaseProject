package com.andrtw.androidbaseproject.data.source.remote

import com.andrtw.androidbaseproject.data.source.HasErrorHandling
import com.andrtw.androidbaseproject.domain.model.Todo


interface TodoRemoteDataSource : HasErrorHandling {

    suspend fun getTodos(): List<Todo>?
}