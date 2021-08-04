package com.serasa.manipulando_lista_interface.exercicioSingleton.singleton

import com.serasa.manipulando_lista_interface.exercicioSingleton.model.LogoProduto
import com.serasa.manipulando_lista_interface.exercicioSingleton.model.ProdutoSingleton
import java.util.*

object ListaSingleton {

    var listaProdutos = mutableListOf<ProdutoSingleton>(
        ProdutoSingleton(UUID.randomUUID().leastSignificantBits,"Pao","Pao frances",LogoProduto.PAO_FRANCES),
        ProdutoSingleton(UUID.randomUUID().leastSignificantBits,"Pao","Pao Integral",LogoProduto.PAO_INTEGRAL),
        ProdutoSingleton(UUID.randomUUID().leastSignificantBits,"Pao de Queijo","Feito de queijo",LogoProduto.PAO_DE_QUEIJO),
    )
}