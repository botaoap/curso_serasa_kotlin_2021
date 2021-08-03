package com.serasa.manipulando_lista_interface.adapter

import android.content.DialogInterface
import com.serasa.manipulando_lista_interface.model.ListTodo
import com.serasa.manipulando_lista_interface.model.ListTodoLogoUrl

interface ClickableList {

    fun onAdd(todo: ListTodo)
    fun onEdit(todo: ListTodo)
    fun onDelete(todo: ListTodo)
}