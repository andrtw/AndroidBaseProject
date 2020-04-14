package com.andrtw.androidbaseproject.ui.recyclerview

import android.view.View
import com.andrtw.androidbaseproject.ui.model.UiTodo
import com.andrtw.androidbaseproject.ui.recyclerview.base.AbstractViewHolder
import com.andrtw.androidbaseproject.ui.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.view_todo.*


class TodoViewHolder(
    itemView: View,
    private val viewModel: TodoViewModel
) : AbstractViewHolder<UiTodo>(itemView) {

    override fun bind(model: UiTodo) {
        todoText.text = model.title
        todoImage.setImageResource(model.image)
        todoRoot.apply {
            setOnClickListener { viewModel.onTodoClick(model) }
            setOnLongClickListener {
                viewModel.onTodoLongClick(model)
                true
            }
        }
    }
}