package com.andrtw.androidbaseproject.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.andrtw.androidbaseproject.data.model.local.LocalTodo


@Database(
    entities = [
        LocalTodo::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao
}