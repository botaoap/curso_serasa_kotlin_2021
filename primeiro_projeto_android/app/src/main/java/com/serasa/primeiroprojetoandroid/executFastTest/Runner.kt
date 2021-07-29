package com.serasa.primeiroprojetoandroid.executFastTest

import com.serasa.primeiroprojetoandroid.classes.Veiculo
import com.serasa.primeiroprojetoandroid.usingHeranca.Cachorro
import com.serasa.primeiroprojetoandroid.usingHeranca.Cobra
import com.serasa.primeiroprojetoandroid.usingInterface.AutoFalante

fun main() {
    // TODO: Usando ifternario no Kotlin
    val num = 11
    val retorno = if (num > 9) "Numero é maior q 9" else if (num < 6) "Menor que 6" else "maior q 6 menor q 9"

    println(retorno)

    // TODO: Usando when, é parecido com um switch case
    val retornoWhen = when(num) {
        in 0..4 -> "Regular, Nota: ${num}"
        in 5..7 -> "Bom, Nota: ${num}"
        !in 8..10 -> "Otimo, Nota: ${num}"
        else -> "Nenhum numero informado"
    }

    print(retornoWhen)
//    val cachorro = Cachorro()
//    val cobra = Cobra()
//    val veiculo = Veiculo()
//
    // TODO: AutoFalante le cada interface
//    val autoFalante = AutoFalante()
//
//    autoFalante.reproduzirSom(cachorro)
//    autoFalante.reproduzirSom(cobra)
//    autoFalante.reproduzirSom(veiculo)
//
//    autoFalante.reproduzirMovimento(cachorro)
//    autoFalante.reproduzirMovimento(cobra)
//    autoFalante.reproduzirMovimento(veiculo)
}
