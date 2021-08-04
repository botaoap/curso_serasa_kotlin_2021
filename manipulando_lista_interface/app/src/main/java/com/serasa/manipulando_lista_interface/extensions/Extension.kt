package com.serasa.manipulando_lista_interface.extensions

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

// TODO: Criando uma extensio para usar em qualquer Activity
fun AppCompatActivity.showMessage(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
}

// TODO: Criando extension para uma String

fun String.concatNameWithCompany() : String {
    return "$this - Proway"
}


// TODO: Criar extension para remover ponto e traco do CPF
fun String.concatPontoTracoCpf() : String? {
    if (length == 14) {
        return replace(".","").replace("-","")
    }
    return null
}

// TODO: Colocar os pontos e o traco no CPF
fun String.adicionadoPontoTracoCpf() : String? {
    val padraoCpf = "([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})".toRegex()
    val padraoEscrito = "$1.$2.$3-$4"

    if (length == 11) {
        return replace(padraoCpf, padraoEscrito)
    }
    return null
}