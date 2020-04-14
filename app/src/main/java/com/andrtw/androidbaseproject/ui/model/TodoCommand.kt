package com.andrtw.androidbaseproject.ui.model


sealed class TodoCommand {

    data class ShowTodoInfo(val todo: UiTodo) : TodoCommand()
}