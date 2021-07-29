package com.serasa.primeiroprojetoandroid.executFastTest

import com.serasa.primeiroprojetoandroid.classes.Veiculo
import com.serasa.primeiroprojetoandroid.usingHeranca.Cachorro
import com.serasa.primeiroprojetoandroid.usingHeranca.Cobra
import com.serasa.primeiroprojetoandroid.usingInterface.AutoFalante

fun main() {

    val cachorro = Cachorro()
    val cobra = Cobra()
    val veiculo = Veiculo()

    // TODO: AutoFalante le cada interface
    val autoFalante = AutoFalante()

    autoFalante.reproduzirSom(cachorro)
    autoFalante.reproduzirSom(cobra)
    autoFalante.reproduzirSom(veiculo)

    autoFalante.reproduzirMovimento(cachorro)
    autoFalante.reproduzirMovimento(cobra)
    autoFalante.reproduzirMovimento(veiculo)
}
