package com.serasa.primeiroprojetoandroid.classes
// TODO: Classe mae de pessoa para pessoa fisica e juridica
open class Pessoa(
    val identicarTipoPessoa: String,
    val tipoRegistro: String,
    val emitirNotaFiscal: Boolean
) {

    open fun identificar(){
        println("Tipo da pessoa: ")
    }
    open fun tipoDeRegistro(){
        println("Registro principal: ")
    }

    open fun emiteNotaFiscal(){
        println("Pode emitir nota fiscal: ")
    }

}