package com.serasa.primeiroprojetoandroid.exercicioInterface

fun main() {
    val necessidade = Programador()
    val cargo = Programador()

    val reproduzNecessidade = MostraNecessidade()

    reproduzNecessidade.reproduzirpNecessidades(precisa = necessidade, trabalho = cargo)
}