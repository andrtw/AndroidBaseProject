package com.andrtw.androidbaseproject.ui.model

import androidx.annotation.DrawableRes
import com.andrtw.androidbaseproject.ui.recyclerview.TodoRecyclerViewModel


data class UITodo(
    val id: Int,
    val userId: Int,
    val title: String?,
    val isCompleted: Boolean,
    @DrawableRes val image: Int
) : TodoRecyclerViewModel {

    override val type: Int = TodoRecyclerViewModel.TYPE_TODO

}
