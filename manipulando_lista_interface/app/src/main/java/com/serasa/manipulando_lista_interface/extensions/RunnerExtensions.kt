package com.serasa.manipulando_lista_interface.extensions

fun main() {
    val cpf = "084.000.000-44"

    println(cpf.concatPontoTracoCpf())
}

// TODO: Criando extension para uma String

fun String.concatNameWithCompany() : String {
    return "$this - Proway"
}


// TODO: Criar extension para remover ponto e traco do CPF
fun String.concatPontoTracoCpf() : String {

    return replace(".","").replace("-","")
}