package com.serasa.manipulando_lista_interface.exercicioSingleton.adapter

import com.serasa.manipulando_lista_interface.exercicioSingleton.model.ProdutoSingleton

interface ClickableSingleton {

    fun onDelete(produtoSingleton: ProdutoSingleton)
}