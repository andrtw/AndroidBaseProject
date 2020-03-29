package com.andrtw.androidbaseproject.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.andrtw.androidbaseproject.R
import com.andrtw.androidbaseproject.di.provider.ViewModelFactory
import com.andrtw.androidbaseproject.ui.base.AbstractBaseFragment
import com.andrtw.androidbaseproject.ui.model.TodoCommand
import com.andrtw.androidbaseproject.ui.recyclerview.adapter.TodoAdapter
import com.andrtw.androidbaseproject.ui.util.addDefaultItemDecoration
import com.andrtw.androidbaseproject.ui.util.observe
import com.andrtw.androidbaseproject.ui.util.observeEvent
import com.andrtw.androidbaseproject.ui.util.showSnackbar
import com.andrtw.androidbaseproject.ui.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject


class MainFragment : AbstractBaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: TodoViewModel by viewModels { viewModelFactory }

    companion object {
        const val TAG = "mainFragment"
    }

    override fun getContentView(): Int = R.layout.fragment_main

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as TodoApplication).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val todosAdapter = TodoAdapter(viewModel)

        todoList.apply {
            adapter = todosAdapter
            addDefaultItemDecoration(context)
        }

        observeEvent(viewModel.command) { onCommandReceived(it) }
        observe(viewModel.loading) { progress.isVisible = it }
        observe(viewModel.error) { showSnackbar(it) }
        observe(viewModel.data) { todosAdapter.submitList(it) }
    }

    private fun onCommandReceived(command: TodoCommand) {
        when (command) {
            is TodoCommand.ShowTodoInfo -> showSnackbar(command.todo.title)
        }
    }
}