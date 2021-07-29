package com.serasa.primeiroprojetoandroid.exercicioInterface

abstract class Profissao(
    val cargo: String
) : Necessidade {

    open fun trabalho(){
        println("Trabalhando ...")
    }
}