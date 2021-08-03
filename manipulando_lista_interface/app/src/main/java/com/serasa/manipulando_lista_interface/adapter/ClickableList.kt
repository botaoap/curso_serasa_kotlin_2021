package com.serasa.manipulando_lista_interface.adapter

import com.serasa.manipulando_lista_interface.model.ListTodo

interface ClickableList {

    fun onEdit(todo: ListTodo)
    fun onInfo(todo: ListTodo)
    fun onDelete(todo: ListTodo)
}