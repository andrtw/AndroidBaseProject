package com.andrtw.androidbaseproject.ui.viewmodel

import androidx.lifecycle.*
import com.andrtw.androidbaseproject.R
import com.andrtw.androidbaseproject.domain.TodoRepository
import com.andrtw.androidbaseproject.domain.model.ErrorType
import com.andrtw.androidbaseproject.ui.mapper.asDomainModel
import com.andrtw.androidbaseproject.ui.mapper.asUiModel
import com.andrtw.androidbaseproject.ui.model.TodoCommand
import com.andrtw.androidbaseproject.ui.model.UiTodo
import com.andrtw.androidbaseproject.ui.recyclerview.TodoRecyclerViewModel
import com.andrtw.androidbaseproject.ui.util.Event
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject


class TodoViewModel @Inject constructor(
    private val repository: TodoRepository
) : ViewModel() {

    private val _command = MutableLiveData<Event<TodoCommand>>()
    val command: LiveData<Event<TodoCommand>>
        get() = _command

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    val error: LiveData<Int?> = repository.error.map { parseErrorEvent(it) }

    val data: LiveData<List<TodoRecyclerViewModel>> = repository.observeTodos()
        .map { todos -> todos.map { todo -> todo.asUiModel() } }
        .asLiveData()

    init {
        exec { repository.fetchTodos() }
    }

    fun onTodoClick(todo: UiTodo) {
        exec(withLoading = false) {
            val newTodo = todo.copy(isCompleted = !todo.isCompleted)
            repository.updateTodo(newTodo.asDomainModel())
        }
    }

    fun onTodoLongClick(todo: UiTodo) {
        _command.value = Event(TodoCommand.ShowTodoInfo(todo))
    }

    private fun parseErrorEvent(errorEvent: Event<ErrorType>): Int? =
        when (errorEvent.getContentIfNotHandled()) {
            ErrorType.FETCH_TODOS -> R.string.error_generic
            else -> null
        }

    private fun exec(withLoading: Boolean = true, block: suspend () -> Unit) {
        viewModelScope.launch {
            if (withLoading) {
                _loading.value = true
            }
            block()
            if (withLoading) {
                _loading.value = false
            }
        }
    }
}