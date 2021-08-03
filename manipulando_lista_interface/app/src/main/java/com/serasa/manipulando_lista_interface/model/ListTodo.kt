package com.serasa.manipulando_lista_interface.model

import android.text.Editable
import java.io.Serializable

data class ListTodo(
    val title: String,
    val description: String,
    val logo: ListTodoLogoUrl
): Serializable