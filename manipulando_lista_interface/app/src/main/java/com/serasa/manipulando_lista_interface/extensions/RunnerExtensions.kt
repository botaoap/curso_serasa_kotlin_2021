package com.serasa.manipulando_lista_interface.extensions

fun main() {
    val cpfCerto = "084.000.000-44"

    println("Old: $cpfCerto | New: ${cpfCerto.concatPontoTracoCpf()}")

    val cpfErrado = "09823993988"

    println("Old: $cpfErrado | New: ${cpfErrado.adicionadoPontoTracoCpf()}")
}
