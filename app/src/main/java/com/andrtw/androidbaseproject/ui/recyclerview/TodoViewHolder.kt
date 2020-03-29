package com.andrtw.androidbaseproject.ui.recyclerview

import android.view.View
import com.andrtw.androidbaseproject.ui.model.UITodo
import com.andrtw.androidbaseproject.ui.recyclerview.base.AbstractViewHolder
import com.andrtw.androidbaseproject.ui.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.view_todo.*


class TodoViewHolder(
    itemView: View,
    private val viewModel: TodoViewModel
) : AbstractViewHolder<UITodo>(itemView) {

    override fun bind(model: UITodo) {
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