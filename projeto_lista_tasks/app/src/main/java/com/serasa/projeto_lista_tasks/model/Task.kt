package com.serasa.projeto_lista_tasks.model

import java.io.Serializable

data class Task(
    val nomeTask: String,
    val descritionTask: String,
    val logo: TaskLogoUrl
) : Serializable