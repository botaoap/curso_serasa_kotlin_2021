package com.serasa.projeto_lista_tasks.adapter

import com.serasa.projeto_lista_tasks.model.Task

interface ClickableTask {

    fun onDelete(task: Task)
    fun onEdit(task: Task)
    fun onInfo(task: Task)
}