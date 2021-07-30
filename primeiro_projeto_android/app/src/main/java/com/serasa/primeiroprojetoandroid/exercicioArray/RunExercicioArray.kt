package com.serasa.primeiroprojetoandroid.exercicioArray

fun main() {

    val arrayDeNome = arrayOf("Matheus", "Gabriel", "Arthur", "Andrei", "Giovanni", "Vinicius",
        "Gabriela", "Felipe", "Edson", "Danilo", "Jaison")

    arrayDeNome.sorted().forEach {
        println(it)
    }
}