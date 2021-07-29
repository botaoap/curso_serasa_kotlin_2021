package com.serasa.primeiroprojetoandroid.usingInterface

class AutoFalante {

    fun reproduzirSom(som: Som) {
        print("${som.ruido()}")
    }

    fun reproduzirMovimento(movimento: Movimentacao) {
        println("${movimento.frente()}")
        println("${movimento.lado()}")
        println("${movimento.random()}")
    }
}