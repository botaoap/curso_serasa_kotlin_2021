package com.serasa.manipulando_lista_interface.exercicioSingleton.model

import java.io.Serializable

data class ProdutoSingleton(
    val id: Long,
    val nome: String,
    val description: String,
    val logo: LogoProduto
): Serializable
