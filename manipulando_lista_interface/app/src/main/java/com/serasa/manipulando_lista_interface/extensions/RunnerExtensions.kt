package com.serasa.manipulando_lista_interface.extensions

fun main() {
    val cpfCerto = "084.000.000-44"

    println("Old: $cpfCerto | New: ${cpfCerto.concatPontoTracoCpf()}")

    val cpfErrado = "09823993988"

    println("Old: $cpfCerto | New: ${cpfErrado.adicionadoPontoTracoCpf()}")
}

// TODO: Criando extension para uma String

fun String.concatNameWithCompany() : String {
    return "$this - Proway"
}


// TODO: Criar extension para remover ponto e traco do CPF
fun String.concatPontoTracoCpf() : String {

    return replace(".","").replace("-","")
}

// TODO: Colocar os pontos e o traco no CPF
fun String.adicionadoPontoTracoCpf() : String {
    val padraoCpf = "([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})".toRegex()
    val padraoEscrito = "$1.$2.$3-$4"

    return replace(padraoCpf, padraoEscrito)
}