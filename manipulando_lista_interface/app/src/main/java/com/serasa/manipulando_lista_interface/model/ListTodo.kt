package com.serasa.manipulando_lista_interface.model

import java.io.Serializable

class ListTodo(
    val title: String,
    val description: String,
    val logo: ListTodoLogoUrl
): Serializable