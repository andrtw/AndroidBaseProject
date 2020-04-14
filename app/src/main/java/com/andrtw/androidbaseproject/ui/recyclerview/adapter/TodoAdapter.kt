package com.andrtw.androidbaseproject.ui.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.andrtw.androidbaseproject.R
import com.andrtw.androidbaseproject.ui.model.UiTodo
import com.andrtw.androidbaseproject.ui.recyclerview.TodoRecyclerViewModel
import com.andrtw.androidbaseproject.ui.recyclerview.TodoViewHolder
import com.andrtw.androidbaseproject.ui.recyclerview.base.AbstractViewHolder
import com.andrtw.androidbaseproject.ui.recyclerview.base.RecyclerViewModel
import com.andrtw.androidbaseproject.ui.viewmodel.TodoViewModel


class TodoAdapter(
    private val viewModel: TodoViewModel
) : ListAdapter<TodoRecyclerViewModel, AbstractViewHolder<RecyclerViewModel>>(ItemCallback()) {

    private class ItemCallback : DiffUtil.ItemCallback<TodoRecyclerViewModel>() {
        override fun areItemsTheSame(
            oldItem: TodoRecyclerViewModel,
            newItem: TodoRecyclerViewModel
        ): Boolean = when {
            oldItem is UiTodo && newItem is UiTodo -> oldItem.id == newItem.id
            else -> oldItem.javaClass == newItem.javaClass
        }

        override fun areContentsTheSame(
            oldItem: TodoRecyclerViewModel,
            newItem: TodoRecyclerViewModel
        ): Boolean = oldItem == newItem
    }

    override fun getItemViewType(position: Int): Int = getItem(position).type

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AbstractViewHolder<RecyclerViewModel> = when (viewType) {
        TodoRecyclerViewModel.TYPE_TODO -> TodoViewHolder(
            inflate(parent, R.layout.view_todo),
            viewModel
        )
        else -> throw IllegalStateException("Unknown viewType $viewType")
    } as AbstractViewHolder<RecyclerViewModel>

    override fun onBindViewHolder(holder: AbstractViewHolder<RecyclerViewModel>, position: Int) {
        holder.bind(getItem(position))
    }

    private fun inflate(parent: ViewGroup, @LayoutRes layoutResId: Int): View =
        LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
}