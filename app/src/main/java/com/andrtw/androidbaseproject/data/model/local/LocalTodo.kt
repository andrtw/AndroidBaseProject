package com.andrtw.androidbaseproject.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "todos"
)
data class LocalTodo(
    @PrimaryKey
    val id: Int,
    val userId: Int,
    val title: String?,
    val completed: Boolean
)
