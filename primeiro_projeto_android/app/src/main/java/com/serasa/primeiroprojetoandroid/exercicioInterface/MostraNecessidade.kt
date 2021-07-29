package com.serasa.primeiroprojetoandroid.exercicioInterface

class MostraNecessidade {

    fun reproduzirpNecessidades(precisa: Necessidade, trabalho: Programador){
        println("${trabalho.trabalho()}")
        println("${precisa.cafe()}")
    }
}